package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes5.dex */
public class TTDownloaderClickIdDBHelper extends SQLiteOpenHelper {
    public static final String CLICK_ID_TABLE_NAME = "ttdownloaderClickId";
    private static final String TABLE_CLICK_ID = "clickId";
    private static final String TABLE_DOWNLOAD_URL = "downloadUrl";
    private static final String TABLE_ID = "_id";
    private static final String TABLE_PACKAGE_NAME = "packageName";
    private static final String TABLE_TIMESTAMP = "timestamp";
    public static final String TTDOWNLOADER_DATABASE_NAME = "ttdownloader_db";
    private static final int TTDOWNLOADER_DATABASE_VERSION = 1;
    private final String CREATE_CLICK_ID_TABLE;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    public TTDownloaderClickIdDBHelper(Context r100) {
        super(r100, TTDOWNLOADER_DATABASE_NAME, null, 1);
        this.CREATE_CLICK_ID_TABLE = "CREATE TABLE IF NOT EXISTS ttdownloaderClickId(_id INTEGER PRIMARY KEY AUTOINCREMENT, downloadUrl TEXT, packageName TEXT,clickId TEXT, timestamp TEXT)";
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE IF NOT EXISTS ttdownloaderClickId(_id INTEGER PRIMARY KEY AUTOINCREMENT, downloadUrl TEXT, packageName TEXT,clickId TEXT, timestamp TEXT)");
    }
}
