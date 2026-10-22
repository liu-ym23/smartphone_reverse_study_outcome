package com.bytedance.security.android.aopcheck;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J4\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007¨\u0006 "}, d2 = {"Lcom/bytedance/security/android/aopcheck/ContextWrapper;", "", "()V", "deleteDatabase", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "name", "", "deleteFile", "deleteSharedPreferences", "getDatabasePath", "Ljava/io/File;", "getDir", "mode", "", "getFileStreamPath", "getSharedPreferences", "Landroid/content/SharedPreferences;", "moveDatabaseFrom", "sourceContext", "moveSharedPreferencesFrom", "openFileInput", "Ljava/io/FileInputStream;", "openFileOutput", "Ljava/io/FileOutputStream;", "openOrCreateDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "errorHandler", "Landroid/database/DatabaseErrorHandler;", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class ContextWrapper {
    public static final ContextWrapper INSTANCE = null;

    private ContextWrapper() {
    }

    static {
        INSTANCE = new ContextWrapper();
    }

    @JvmStatic
    public static final boolean deleteDatabase(Context r100, String r101) {
        return r100.deleteDatabase(r101);
    }

    @JvmStatic
    public static final boolean deleteFile(Context r100, String r101) {
        return r100.deleteFile(r101);
    }

    @JvmStatic
    public static final boolean deleteSharedPreferences(Context r100, String r101) {
        return r100.deleteSharedPreferences(r101);
    }

    @JvmStatic
    public static final File getDatabasePath(Context r100, String r101) {
        return r100.getDatabasePath(r101);
    }

    @JvmStatic
    public static final File getFileStreamPath(Context r100, String r101) {
        return r100.getFileStreamPath(r101);
    }

    @JvmStatic
    public static final FileInputStream openFileInput(Context r100, String r101) {
        return r100.openFileInput(r101);
    }

    @JvmStatic
    public static final File getDir(Context r100, String r101, int r102) {
        return r100.getDir(r101, r102);
    }

    @JvmStatic
    public static final SharedPreferences getSharedPreferences(Context r100, String r101, int r102) {
        return r100.getSharedPreferences(r101, r102);
    }

    @JvmStatic
    public static final boolean moveDatabaseFrom(Context r100, Context r101, String r102) {
        return r100.moveDatabaseFrom(r101, r102);
    }

    @JvmStatic
    public static final boolean moveSharedPreferencesFrom(Context r100, Context r101, String r102) {
        return r100.moveSharedPreferencesFrom(r101, r102);
    }

    @JvmStatic
    public static final FileOutputStream openFileOutput(Context r100, String r101, int r102) {
        return r100.openFileOutput(r101, r102);
    }

    @JvmStatic
    public static final SQLiteDatabase openOrCreateDatabase(Context r100, String r101, int r102, SQLiteDatabase.CursorFactory r103) {
        return r100.openOrCreateDatabase(r101, r102, r103);
    }

    @JvmStatic
    public static final SQLiteDatabase openOrCreateDatabase(Context r100, String r101, int r102, SQLiteDatabase.CursorFactory r103, DatabaseErrorHandler r104) {
        return r100.openOrCreateDatabase(r101, r102, r103, r104);
    }
}
