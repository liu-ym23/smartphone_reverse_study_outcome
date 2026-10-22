package com.ss.ttvideoengine.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;

/* JADX INFO: loaded from: classes34.dex */
public class KVDBManager implements IKVStorage {
    private static final String TAG = "KVDBManager";
    private boolean createDBSuccess;
    private SQLiteDatabase mDB;
    private KVDBHelper mHelper;
    private String mTableName;

    @Override // com.ss.ttvideoengine.database.IKVStorage
    public boolean clear() {
        SQLiteDatabase r100 = this.mDB;
        if (r100 != null) goto L24;
        return false;
    L24:
        r100.beginTransaction();     // Catch: Exception -> L19
        this.mDB.execSQL(String.format("DELETE FROM %s ", new Object[]{this.mTableName}));     // Catch: Throwable -> L11 Exception -> L13
        this.mDB.setTransactionSuccessful();     // Catch: Throwable -> L11 Exception -> L13
        TTVideoEngineLog.d(TAG, "all cleared");     // Catch: Throwable -> L11 Exception -> L13
        SQLiteDatabase r101 = this.mDB;     // Catch: Exception -> L19
    L9:
        r101.endTransaction();     // Catch: Exception -> L19
        return true;
    L13:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L11
        r101 = this.mDB;     // Catch: Exception -> L19
        goto L9
    L11:
        th = move-exception;
        this.mDB.endTransaction();     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        TTVideoEngineLog.d(e);
        return false;
    }

    public boolean isCreateDBSuccess() {
        return this.createDBSuccess;
    }

    public String get(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L22:
        TTVideoEngineLog.e(TAG, "open db fail");
        return null;
    L5:
        if (this.mDB == null) goto L22;
        Cursor r101 = this.mDB.rawQuery(String.format("SELECT * FROM %s WHERE key='%s'", new Object[]{this.mTableName, r100}), null);     // Catch: Exception -> L16 Throwable -> L24
        if (r101.moveToFirst() == false) goto L11;
        String r102 = r101.getString(r101.getColumnIndex("value"));     // Catch: Exception -> L16 Throwable -> L24
    L25:
        r101.close();     // Catch: Exception -> L14 Throwable -> L20
        TTVideoEngineLog.d(TAG, "get key: " + r100 + " value: " + r102);     // Catch: Exception -> L14 Throwable -> L20
        return r102;
    L14:
        e = e;
    L18:
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L20
        return null;
    L21:
        return r102;
        goto L30
    L11:
        r102 = null;
    L16:
        e = e;
        r102 = null;
    L30:
        return null;
    }

    @Override // com.ss.ttvideoengine.database.IKVStorage
    public String getString(String r100) {
        return get(r100);
    }

    public boolean remove(String r100) {
        boolean r101 = false;
        if (this.mDB != null) goto L5;
    L30:
        TTVideoEngineLog.d(TAG, "open db fail");
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L30;
        this.mDB.beginTransaction();     // Catch: Throwable -> L24
        this.mDB.execSQL(String.format("DELETE FROM %s WHERE key='%s'", new Object[]{this.mTableName, r100}));     // Catch: Exception -> L12 Throwable -> L32
        this.mDB.setTransactionSuccessful();     // Catch: Exception -> L12 Throwable -> L32
        this.mDB.endTransaction();     // Catch: Throwable -> L24
        TTVideoEngineLog.d(TAG, "remove key " + r100);     // Catch: Throwable -> L24
        return true;
    L12:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L18
        this.mDB.endTransaction();     // Catch: Throwable -> L16
        return false;
    L16:
        th = th;
        r101 = true;
    L35:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L28
        return !r101;
    L29:
        return !r101;
    L18:
        r101 = true;
    L19:
        this.mDB.endTransaction();     // Catch: Throwable -> L24
        if (r101 == true) goto L23;
        TTVideoEngineLog.d(TAG, "remove key " + r100);     // Catch: Throwable -> L24
    L23:
        return !r101;
    L24:
        th = th;
        goto L35
    }

    @Override // com.ss.ttvideoengine.database.IKVStorage
    public boolean removeString(String r100) {
        return remove(r100);
    }

    public KVDBManager(Context r100, String r101) {
        this.mDB = null;
        this.mTableName = null;
        this.mHelper = null;
        boolean r102 = false;
        this.createDBSuccess = false;
        if (r100 != null) goto L5;
    L34:
        TTVideoEngineLog.e(TAG, "context or name is invalid");
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L34;
        this.mTableName = r101;
        KVDBHelper r103 = new KVDBHelper(r100, this.mTableName);
        this.mHelper = r103;
        SQLiteDatabase r104 = r103.getWritableDatabase();     // Catch: Throwable -> L17
        this.mDB = r104;     // Catch: Throwable -> L17
        if (r104 == null) goto L12;
        this.mDB.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(key TEXT PRIMARY KEY,value TEXT,time INTEGER)", new Object[]{this.mTableName}));     // Catch: Throwable -> L17
    L12:
        if (this.mHelper != null) goto L15;
        TTVideoEngineLog.e(TAG, "create db fail, mHelper == null, table name " + this.mTableName);
    L15:
        if (this.mHelper == null) goto L23;
        r102 = true;
    L23:
        this.createDBSuccess = r102;
        return;
    L17:
        th = move-exception;
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L25
        TTVideoEngineLog.e(TAG, "create db fail, table name " + this.mTableName);
        if (this.mHelper != null) goto L22;
        TTVideoEngineLog.e(TAG, "create db fail, mHelper == null, table name " + this.mTableName);
    L22:
        KVDBHelper r105 = this.mHelper;
    L25:
        th = move-exception;
        if (this.mHelper != null) goto L30;
        TTVideoEngineLog.e(TAG, "create db fail, mHelper == null, table name " + this.mTableName);
    L30:
        if (this.mHelper == null) goto L32;
        r102 = true;
    L32:
        this.createDBSuccess = r102;
        throw th;
    }

    @Override // com.ss.ttvideoengine.database.IKVStorage
    public boolean putString(String r100, String r101) {
        return save(r100, r101);
    }

    public boolean save(String r100, String r101) {
        boolean r102 = false;
        if (this.mDB != null) goto L5;
    L32:
        TTVideoEngineLog.e(TAG, "open db fail");
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L32;
        if (TextUtils.isEmpty(r101) == true) goto L32;
        TTVideoEngineLog.i(TAG, "save key: " + r100 + " value: " + r101);
        this.mDB.beginTransaction();     // Catch: Throwable -> L26
        this.mDB.execSQL(String.format("REPLACE INTO %s VALUES ('%s','%s',%d)", new Object[]{this.mTableName, r100, r101, Long.valueOf(System.currentTimeMillis())}));     // Catch: IllegalStateException -> L14 SQLException -> L18 Throwable -> L24
        this.mDB.setTransactionSuccessful();     // Catch: IllegalStateException -> L14 SQLException -> L18 Throwable -> L24
        this.mDB.endTransaction();     // Catch: Throwable -> L26
        return true;
    L24:
        this.mDB.endTransaction();     // Catch: Throwable -> L26
        return true;
    L18:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L24
        this.mDB.endTransaction();     // Catch: Throwable -> L22
        return false;
    L22:
        th = th;
        r102 = true;
    L34:
        TTVideoEngineLog.d(th);     // Catch: Throwable -> L30
        return !r102;
    L31:
        return !r102;
    L14:
        e = move-exception;
        TTVideoEngineLog.d(e);     // Catch: Throwable -> L24
        this.mDB.endTransaction();     // Catch: Throwable -> L26
        return true;
    L26:
        th = th;
        goto L34
    }
}
