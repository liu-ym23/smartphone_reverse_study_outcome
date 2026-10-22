package com.bytedance.security.android.aopcheck;

import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0007J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J$\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/security/android/aopcheck/SQLiteDatabaseWrapper;", "", "()V", "openDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "path", "", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "flags", "", "errorHandler", "Landroid/database/DatabaseErrorHandler;", "openOrCreateDatabase", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class SQLiteDatabaseWrapper {
    public static final SQLiteDatabaseWrapper INSTANCE = null;

    private SQLiteDatabaseWrapper() {
    }

    static {
        INSTANCE = new SQLiteDatabaseWrapper();
    }

    @JvmStatic
    public static final SQLiteDatabase openOrCreateDatabase(String r100, SQLiteDatabase.CursorFactory r101) {
        return SQLiteDatabase.openOrCreateDatabase(r100, r101);
    }

    @JvmStatic
    public static final SQLiteDatabase openDatabase(String r100, SQLiteDatabase.CursorFactory r101, int r102) {
        return SQLiteDatabase.openDatabase(r100, r101, r102);
    }

    @JvmStatic
    public static final SQLiteDatabase openOrCreateDatabase(String r100, SQLiteDatabase.CursorFactory r101, DatabaseErrorHandler r102) {
        return SQLiteDatabase.openOrCreateDatabase(r100, r101, r102);
    }

    @JvmStatic
    public static final SQLiteDatabase openDatabase(String r100, SQLiteDatabase.CursorFactory r101, int r102, DatabaseErrorHandler r103) {
        return SQLiteDatabase.openDatabase(r100, r101, r102, r103);
    }
}
