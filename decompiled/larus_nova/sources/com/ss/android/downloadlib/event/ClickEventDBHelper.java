package com.ss.android.downloadlib.event;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes34.dex */
public class ClickEventDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "click_event";
    static final String[] EVENT_COLS = null;
    static final String KEY_AD_ID = "ad_id";
    static final String KEY_ID = "_id";
    static final String KEY_REQ_ID = "req_id";
    static final String KEY_TIME = "time";
    static final String TABLE_NAME = "click_event";
    private static final int VERSION = 1;

    static {
        EVENT_COLS = new String[]{"_id", "ad_id", "req_id", "time"};
    }

    public ClickEventDBHelper(Context r100) {
        super(r100, "click_event", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE IF NOT EXISTS click_event(_id INTEGER PRIMARY KEY AUTOINCREMENT,ad_id INTEGER,req_id TEXT,time INTEGER)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        r100.execSQL("DROP TABLE IF EXISTS click_event");
        onCreate(r100);
    }
}
