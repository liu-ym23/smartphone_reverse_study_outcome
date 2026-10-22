package com.ss.ttvideoengine.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes34.dex */
public class KVDBHelper extends SQLiteOpenHelper {
    private static final String TAG = "KVDBHelper";
    private static Integer Version;

    static {
        Version = 1;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r100) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    public KVDBHelper(Context r100, String r101) {
        this(r100, r101, Version.intValue());
    }

    public KVDBHelper(Context r100, String r101, int r102) {
        this(r100, r101, null, r102);
    }

    public KVDBHelper(Context r100, String r101, SQLiteDatabase.CursorFactory r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
