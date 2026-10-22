package com.ss.ttvideoengine.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* JADX INFO: loaded from: classes34.dex */
public class VideoModelDBManager {
    private static final int MAX_CACHE_SIZE = 200;
    private static final int MIN_CACHE_SIZE = 20;
    private static final String NAME = "videomodel";
    private static final String TAG = "VideoModelDBManager";
    private static int mCacheSize = 200;
    private static SQLiteDatabase mDB = null;
    private static VideoModelDBManager mInstance = null;
    private static boolean sEnableSizeLimit = true;

    public static class CacheInfo {
        public long time;
        public String vid;
        public String videoModelStr;

        public CacheInfo() {
            this.time = 0;
            this.videoModelStr = null;
            this.vid = null;
        }
    }

    public static void clear() {
        SQLiteDatabase r100 = mDB;
        if (r100 != null) goto L22;
        return;
    L22:
        r100.beginTransaction();     // Catch: Exception -> L17
        mDB.execSQL(String.format("DELETE FROM %s ", new Object[]{NAME}));     // Catch: Throwable -> L10 Exception -> L12
        mDB.setTransactionSuccessful();     // Catch: Throwable -> L10 Exception -> L12
        TTVideoEngineLog.i(TAG, "all cleared");     // Catch: Throwable -> L10 Exception -> L12
        SQLiteDatabase r101 = mDB;     // Catch: Exception -> L17
    L8:
        r101.endTransaction();     // Catch: Exception -> L17
        return;
    L12:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L10
        r101 = mDB;     // Catch: Exception -> L17
        goto L8
    L10:
        th = move-exception;
        mDB.endTransaction();     // Catch: Exception -> L17
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        TTVideoEngineLog.d(e);
    }

    public static int count() {
        if (mDB != null) goto L6;
        return -1;
    L6:
        int r100 = 0;
        Cursor r101 = mDB.rawQuery(String.format("SELECT COUNT(*) FROM %s", new Object[]{NAME}), null);     // Catch: Exception -> L12
        if (r101.moveToFirst() == false) goto L10;
        r100 = (int) r101.getLong(0);     // Catch: Exception -> L12
    L10:
        r101.close();     // Catch: Exception -> L12
    L14:
        TTVideoEngineLog.d(TAG, "count:" + r100);
        return r100;
    L12:
        e = move-exception;
        TTVideoEngineLog.d(e);
        goto L14
    }

    private VideoModelDBManager(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        DBHelper r101 = DBHelper.getInstance(r100);
        if (r101 == null) goto L16;
        SQLiteDatabase r102 = r101.getWritableDatabase();     // Catch: Throwable -> L11
        mDB = r102;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        mDB.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(vid TEXT PRIMARY KEY,videomodel TEXT,time INTEGER)", new Object[]{NAME}));     // Catch: Throwable -> L11
        return;
    L17:
        return;
    L11:
        th = move-exception;
        TTVideoEngineLog.d(th);
        return;
    }

    public static void delete(String r100) {
        SQLiteDatabase r101 = mDB;
        if (r101 != null) goto L23;
        return;
    L23:
        r101.beginTransaction();     // Catch: Exception -> L17
        mDB.execSQL(String.format("DELETE FROM %s WHERE vid='%s'", new Object[]{NAME, r100}));     // Catch: Throwable -> L10 Exception -> L12
        mDB.setTransactionSuccessful();     // Catch: Throwable -> L10 Exception -> L12
        SQLiteDatabase r102 = mDB;     // Catch: Exception -> L17
    L8:
        r102.endTransaction();     // Catch: Exception -> L17
    L19:
        TTVideoEngineLog.i(TAG, "deleted vid:" + r100);
        return;
    L12:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L10
        r102 = mDB;     // Catch: Exception -> L17
        goto L8
    L10:
        th = move-exception;
        mDB.endTransaction();     // Catch: Exception -> L17
        throw th;     // Catch: Exception -> L17
    L17:
        e = move-exception;
        TTVideoEngineLog.d(e);
        goto L19
    }

    public static VideoModelDBManager getInstance(Context r100) {
        if (mInstance != null) goto L15;
        monitor-enter(VideoModelDBManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new VideoModelDBManager(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(VideoModelDBManager.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static CacheInfo query(String r100) {
        CacheInfo r101 = null;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L18:
        return null;
    L5:
        if (mDB == null) goto L18;
        Cursor r102 = mDB.rawQuery(String.format("SELECT * FROM %s WHERE vid='%s'", new Object[]{NAME, r100}), null);     // Catch: Exception -> L15
        CacheInfo r103 = new CacheInfo();     // Catch: Exception -> L15
        r103.vid = r100;     // Catch: Exception -> L13
        if (r102.moveToFirst() == false) goto L11;
        r103.videoModelStr = r102.getString(r102.getColumnIndex(NAME));     // Catch: Exception -> L13
        r103.time = r102.getLong(r102.getColumnIndex("time"));     // Catch: Exception -> L13
    L11:
        r102.close();     // Catch: Exception -> L13
        TTVideoEngineLog.d(TAG, "query vid:" + r100 + " videomodel:" + r103.videoModelStr);     // Catch: Exception -> L13
        return r103;
    L13:
        e = e;
        r101 = r103;
    L16:
        TTVideoEngineLog.d(e);
        return r101;
    L15:
        e = e;
        goto L16
    }

    public static void setCacheSize(int r100) {
        mCacheSize = r100;
    }

    public static void setEnableSizeLimit(boolean r100) {
        sEnableSizeLimit = r100;
    }

    public static void insert(String r100, String r101) {
        if (mDB != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L48;
        TTVideoEngineLog.i(TAG, "insert vid:" + r100 + " videomodel:" + r101);
        boolean r102 = true;
        mDB.beginTransaction();     // Catch: Exception -> L31
        mDB.execSQL(String.format("REPLACE INTO %s VALUES ('%s','%s',%d)", new Object[]{NAME, r100, r101, Long.valueOf(System.currentTimeMillis())}));     // Catch: Throwable -> L19 IllegalStateException -> L21 SQLException -> L26
        if (sEnableSizeLimit == false) goto L15;
        mDB.execSQL(String.format("DELETE FROM %s WHERE vid IN (SELECT vid FROM %s ORDER BY time DESC LIMIT -1 OFFSET %d)", new Object[]{NAME, NAME, Integer.valueOf(mCacheSize)}));     // Catch: Throwable -> L19 IllegalStateException -> L21 SQLException -> L26
    L15:
        mDB.setTransactionSuccessful();     // Catch: Throwable -> L19 IllegalStateException -> L21 SQLException -> L26
        SQLiteDatabase r103 = mDB;     // Catch: Exception -> L31
    L17:
        r103.endTransaction();     // Catch: Exception -> L31
        r102 = false;
    L33:
        if (r102 == false) goto L45;
        int r104 = count();
        TTVideoEngineLog.d(TAG, "sqlExcHappen count " + r104);
        if (r104 <= 0) goto L46;
        int r105 = r104 - 10;
        mCacheSize = r105;
        if (r105 >= 20) goto L47;
        mCacheSize = 20;
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L19:
        th = move-exception;
        mDB.endTransaction();     // Catch: Exception -> L31
        throw th;     // Catch: Exception -> L31
    L26:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L19
        mDB.endTransaction();     // Catch: Exception -> L31
    L21:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L19
        r103 = mDB;     // Catch: Exception -> L31
    L31:
        e = move-exception;
        TTVideoEngineLog.d(e);
        goto L33
    }
}
