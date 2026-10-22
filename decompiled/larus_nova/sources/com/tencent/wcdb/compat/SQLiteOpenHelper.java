package com.tencent.wcdb.compat;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import com.tencent.wcdb.core.Database;
import com.tencent.wcdb.fts.BuiltinTokenizer;

/* JADX INFO: loaded from: classes40.dex */
public abstract class SQLiteOpenHelper {
    private static final String TAG = "WCDB2.SQLiteOpenHelper";
    private SQLiteCipherSpec mCipher;
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;
    private byte[] mPassword;

    public synchronized void close() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInitializing == true) goto L14;
        SQLiteDatabase r100 = this.mDatabase;     // Catch: Throwable -> L15
        if (r100 != null) goto L8;
    L10:
        this.mDatabase = null;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        if (r100.isOpen() == false) goto L10;
        this.mDatabase.close();     // Catch: Throwable -> L15
        goto L10
    L14:
        throw new IllegalStateException("Closed during initialization");     // Catch: Throwable -> L15
    }

    public void onConfigure(SQLiteDatabase r100) {
    }

    public abstract void onCreate(SQLiteDatabase r100);

    public void onOpen(SQLiteDatabase r100) {
    }

    public abstract void onUpgrade(SQLiteDatabase r100, int r101, int r102);

    private SQLiteDatabase getDatabaseLocked() {
        SQLiteDatabase r100 = this.mDatabase;
        if (r100 == null) goto L5;
        return r100;
    L5:
        SQLiteDatabase r101 = null;
        this.mIsInitializing = true;     // Catch: Throwable -> L16
        String r102 = this.mName;     // Catch: Throwable -> L16
        if (r102 != null) goto L10;
        SQLiteDatabase r103 = SQLiteDatabase.wrap(new Database("null"));     // Catch: Throwable -> L16
    L9:
        r101 = r103;
        r101.getInnerDB().addTokenizer(BuiltinTokenizer.MMICU);     // Catch: Throwable -> L16
        SQLiteDatabase r104 = getDatabaseLockedLast(r101);     // Catch: Throwable -> L16
        this.mIsInitializing = false;
        if (r101 == this.mDatabase) goto L15;
        r101.close();
    L15:
        return r104;
    L10:
        r103 = SQLiteDatabase.openDatabase(this.mContext.getDatabasePath(r102).getPath(), this.mPassword, this.mCipher, this.mErrorHandler);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.mIsInitializing = false;
        if (r101 != null) goto L20;
    L22:
        throw th;
    L20:
        if (r101 == this.mDatabase) goto L22;
        r101.close();
        goto L22
    }

    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase r100 = this.mDatabase;
        if (r100 == null) goto L6;
        return r100;
    L6:
        monitor-enter(SQLiteOpenHelper.class);
        SQLiteDatabase r101 = getDatabaseLocked();     // Catch: Throwable -> L10
        monitor-exit(SQLiteOpenHelper.class);     // Catch: Throwable -> L10
        return r101;
    L10:
        th = move-exception;
        throw th;
    }

    public String getDatabaseName() {
        return this.mName;
    }

    private SQLiteDatabase getDatabaseLockedLast(SQLiteDatabase r100) {
        onConfigure(r100);
        int r101 = r100.getVersion();
        if (r101 == this.mNewVersion) goto L16;
        r100.beginTransaction();
        if (r101 != 0) goto L7;
        onCreate(r100);     // Catch: Throwable -> L13
    L11:
        r100.setVersion(this.mNewVersion);     // Catch: Throwable -> L13
        r100.setTransactionSuccessful();     // Catch: Throwable -> L13
        r100.endTransaction();
        goto L16
    L7:
        int r102 = this.mNewVersion;     // Catch: Throwable -> L13
        if (r101 <= r102) goto L10;
        onDowngrade(r100, r101, r102);     // Catch: Throwable -> L13
        goto L11
    L10:
        onUpgrade(r100, r101, r102);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r100.endTransaction();
        throw th;
    L16:
        onOpen(r100);
        this.mDatabase = r100;
        return r100;
    }

    public void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
        throw new SQLiteException("Can't downgrade database from version " + r101 + " to " + r102);
    }

    public SQLiteOpenHelper(Context r100, String r101, byte[] r110, int r111, DatabaseErrorHandler r112) {
        this(r100, r101, r110, null, r111, r112);
    }

    public SQLiteOpenHelper(Context r100, String r101, byte[] r102, SQLiteCipherSpec r103, int r104, DatabaseErrorHandler r105) {
        if (r104 < 1) goto L11;
        this.mContext = r100;
        this.mName = r101;
        this.mNewVersion = r104;
        this.mErrorHandler = r105;
        this.mPassword = r102;
        if (r103 != null) goto L7;
        SQLiteCipherSpec r106 = null;
    L8:
        this.mCipher = r106;
        return;
    L7:
        r106 = new SQLiteCipherSpec(r103);
        goto L8
    L11:
        throw new IllegalArgumentException("Version must be >= 1, was " + r104);
    }
}
