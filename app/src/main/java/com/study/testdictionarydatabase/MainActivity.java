package com.study.testdictionarydatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    Button btnDel;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd=findViewById(R.id.btn_add);
        btnDel=findViewById(R.id.btn_del);

        uri= Uri.parse("content://com.study.electronic_dictionary/dict");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put("word","从测试项目中添加的数据");
                getContentResolver().insert(uri,values);
                Toast.makeText(MainActivity.this,"添加成功",Toast.LENGTH_LONG).show();
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContentResolver().delete(uri,"word = ?",new String[]{"从测试项目中添加的数据"});
                Toast.makeText(MainActivity.this,"删除成功",Toast.LENGTH_LONG).show();
            }
        });
    }
}
