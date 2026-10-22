package com.huawei.hms.framework.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class NetworkKitSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME_DYNAMIC = "networkkit_dynamic.db";
    private static final String DB_NAME_LOCAL = "networkkit.db";
    private static final String DB_NAME_SUFFIX = "-journal";
    public static final int DB_VERSION = 1;
    private static final String TAG = "PLSQLiteOpenHelper";
    private static String dbName = "networkkit.db";
    private static volatile NetworkKitSQLiteOpenHelper instance;
    private ConcurrentHashMap<String, SQLiteDatabase> oldDbMaps;

    public String getDbNameSuffix() {
        return DB_NAME_SUFFIX;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r100) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    public static NetworkKitSQLiteOpenHelper getInstance() {
        if (instance != null) goto L19;
        monitor-enter(NetworkKitSQLiteOpenHelper.class);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (instance == null) goto L9;
    L13:
        monitor-exit(NetworkKitSQLiteOpenHelper.class);     // Catch: Throwable -> L15
        goto L19
    L9:
        if (Build.VERSION.SDK_INT >= 24) goto L11;
        Context r100 = ContextHolder.getAppContext();     // Catch: Throwable -> L15
    L12:
        instance = new NetworkKitSQLiteOpenHelper(r100, dbName, 1);     // Catch: Throwable -> L15
        goto L13
    L11:
        r100 = ContextHolder.getAppContext().createDeviceProtectedStorageContext();     // Catch: Throwable -> L15
    L19:
        return instance;
    }

    public boolean deleteUnusedDbFile() {
        String r100 = dbName;
        String r101 = DB_NAME_DYNAMIC;
        if (r100.equals(DB_NAME_DYNAMIC) == false) goto L6;
        r101 = DB_NAME_LOCAL;
    L6:
        return deleteDbFileByPath(getNetworkKitReadableDatabase().getPath().replace(dbName, r101));
    }

    public SQLiteDatabase getNetworkKitReadableDatabase() {
        SQLiteDatabase r100 = getReadableDatabase();     // Catch: Throwable -> L5
    L7:
        if (r100 != null) goto L9;
        Logger.e(TAG, "getReadableDatabase db is null");
    L9:
        return r100;
    L5:
        th = move-exception;
        Logger.e(TAG, "getReadableDatabase db error:" + th.getMessage());
        r100 = null;
        goto L7
    }

    public SQLiteDatabase getNetworkKitWritableDatabase() {
        SQLiteDatabase r100 = getWritableDatabase();     // Catch: Throwable -> L5
    L7:
        if (r100 != null) goto L9;
        Logger.e(TAG, "getWritableDatabase db is null");
    L9:
        return r100;
    L5:
        th = move-exception;
        Logger.e(TAG, "getWritableDatabase db error:" + th.getMessage());
        r100 = null;
        goto L7
    }

    public SQLiteDatabase getNetworkkitUnusedDbDB() {
        String r100 = dbName;
        String r101 = DB_NAME_DYNAMIC;
        if (r100.equals(DB_NAME_DYNAMIC) == false) goto L6;
        r101 = DB_NAME_LOCAL;
    L6:
        return getDbByName(r101);
    }

    static {
        if (ContextHolder.getKitContext() == null) goto L6;
        dbName = DB_NAME_DYNAMIC;
        return;
    }

    public boolean deleteDbFile() {
        return deleteDbFileByPath(getNetworkKitReadableDatabase().getPath());
    }

    public String getDbName() {
        return dbName;
    }

    public void deleteDbByName(String r100) {
        Logger.d(TAG, "close old db from oldDbMaps, dbname = " + r100);
        SQLiteDatabase r101 = this.oldDbMaps.get(r100);
        if (r101 == null) goto L6;
        r101.close();
        this.oldDbMaps.remove(r100);
        return;
    }

    public boolean deleteDbFileByPath(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L5;
        Logger.i(TAG, "db is not exists");
        return false;
    L5:
        return r101.delete();
    }

    public SQLiteDatabase getDbByName(String r100) {
        SQLiteDatabase r101 = this.oldDbMaps.get(r100);
        if (r101 == null) goto L6;
        Logger.d(TAG, "get old db from oldDbMaps, dbname = " + r100);
        return r101;
    L6:
        SQLiteDatabase r102 = getNetworkKitReadableDatabase();
        if (r102 == null) goto L13;
        String r103 = r102.getPath().replace(dbName, r100);
        if (new PolarisFileWrapper(r103).exists() == false) goto L11;
        SQLiteDatabase r104 = SQLiteDatabase.openDatabase(r103, null, 0);
        this.oldDbMaps.put(r100, r104);
        Logger.d(TAG, "create and put old db to oldDbMaps, dbname = " + r100);
        return r104;
    L11:
        Logger.i(TAG, "old db is not exists");
        return r102;
    L13:
        return r102;
    }

    private NetworkKitSQLiteOpenHelper(Context r100, String r101, int r102) {
        super(r100, r101, null, r102);
        this.oldDbMaps = new ConcurrentHashMap();
    }
}
