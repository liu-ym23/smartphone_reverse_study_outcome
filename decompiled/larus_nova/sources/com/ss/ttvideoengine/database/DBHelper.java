package com.ss.ttvideoengine.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes34.dex */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "fangqing.db";
    private static final int DATABASE_VERSION = 1;
    private static DBHelper mInstance;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r100) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    private DBHelper(Context r100) {
        super(r100, DATABASE_NAME, null, 1);
    }

    public static DBHelper getInstance(Context r100) {
        if (mInstance != null) goto L15;
        monitor-enter(DBHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new DBHelper(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DBHelper.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }
}
