package com.ss.android.socialbase.downloader.db;

import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadDBHelper extends SQLiteOpenHelper {
    private static volatile DownloadDBHelper instance;
    private final String TAG;
    private boolean mIgnoreDuplicateColumn;

    public DownloadDBHelper updateWriteAheadLoggingMode() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.ENABLE_DOWNLOAD_SQLITE_WAL) <= 0) goto L6;
        setWriteAheadLoggingEnabled(true);
    L8:
        return this;
    L6:
        if (Build.VERSION.SDK_INT != 28) goto L8;
        setWriteAheadLoggingEnabled(false);
        goto L8
    }

    private void dropAndCreateDBTable(SQLiteDatabase r100) {
        if (Logger.debug() == false) goto L13;
        Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Run");
    L13:
        r100.execSQL(DBDefinition.DROP_DOWNLOAD_TABLE);     // Catch: Throwable -> L7
        r100.execSQL(DBDefinition.DROP_SEGMENT_TABLE);     // Catch: Throwable -> L7
        SqlDownloadHelper.resetDBIndexState();     // Catch: Throwable -> L7
    L9:
        onCreate(r100);
        if (Logger.debug() == false) goto L15;
        Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Run End");
        return;
    L15:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError("DownloadDBHelper", "dropAndCreateDBTable", "Error: " + th);
        goto L9
    }

    public static DownloadDBHelper getInstance(DatabaseErrorHandler r100) {
        return getInstance(DBDefinition.DATABASE_NAME, r100);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r100) {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug("DownloadDBHelper", WidgetCostModule.TYPE_ON_CREATE, "Run");
    L5:
        r100.execSQL(DBDefinition.CREATE_DOWNLOAD_TABLE);
        r100.execSQL(DBDefinition.CREATE_SEGMENT_TABLE);
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug("DownloadDBHelper", WidgetCostModule.TYPE_ON_CREATE, "Run End");
        return;
    }

    public DownloadDBHelper(String r100, DatabaseErrorHandler r101) {
        super(DownloadComponentManager.getAppContext(), r100, null, 20, r101);
        this.TAG = "DownloadDBHelper";
    }

    private void addItem(SQLiteDatabase r100, String r101) throws SQLException {
        r100.execSQL("ALTER TABLE downloader ADD " + r101);     // Catch: SQLException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        Logger.globalError("DownloadDBHelper", "addItem", "Error:" + e);
        if (this.mIgnoreDuplicateColumn == false) goto L15;
        String r102 = e.getMessage();
        if (TextUtils.isEmpty(r102) == false) goto L11;
    L14:
        throw e;
    L11:
        if (r102.contains("duplicate column") == false) goto L14;
        Logger.globalError("DownloadDBHelper", "addItem", "duplicate column");
        return;
    L15:
        throw e;
    }

    public static DownloadDBHelper getInstance(String r100, DatabaseErrorHandler r101) {
        if (instance != null) goto L15;
        monitor-enter(DownloadDBHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DownloadDBHelper(r100, r101);     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadDBHelper.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private void onUpgradeImpl(SQLiteDatabase r100, int r101, int r102) {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQLITE_UPGRADE_IGNORE_DUPLICATE_COLUMN) <= 0) goto L5;
        boolean r103 = true;
    L6:
        this.mIgnoreDuplicateColumn = r103;
        if (Logger.debug() == false) goto L9;
        Logger.globalDebug("DownloadDBHelper", "onUpgradeImpl", "OldVersion: " + r101 + " newVersion: " + r102 + " ignoreDuplicateColumn:" + this.mIgnoreDuplicateColumn);
    L9:
        switch(r101) {
            case 1: goto L11;
            case 2: goto L12;
            case 3: goto L13;
            case 4: goto L14;
            case 5: goto L15;
            case 6: goto L16;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L18;
            case 10: goto L19;
            case 11: goto L20;
            case 12: goto L21;
            case 13: goto L22;
            case 14: goto L23;
            case 15: goto L24;
            case 16: goto L25;
            case 17: goto L26;
            case 18: goto L27;
            case 19: goto L28;
            default: goto L30;
        };
    L11:
        addItem(r100, "mimeType TEXT");
        addItem(r100, "title TEXT");
        addItem(r100, "notificationEnable INTEGER");
        addItem(r100, "notificationVisibility INTEGER");
    L12:
        addItem(r100, "isFirstDownload INTEGER");
    L13:
        addItem(r100, "isFirstSuccess INTEGER");
    L14:
        addItem(r100, "needHttpsToHttpRetry INTEGER");
        addItem(r100, "downloadTime INTEGER");
    L15:
        addItem(r100, "packageName TEXT");
        addItem(r100, "md5 TEXT");
    L16:
        addItem(r100, "retryDelay INTEGER");
        addItem(r100, "curRetryTime INTEGER");
        addItem(r100, "retryDelayStatus INTEGER");
        addItem(r100, "defaultHttpServiceBackUp INTEGER");
    L17:
        addItem(r100, "chunkRunnableReuse INTEGER");
    L18:
        addItem(r100, "retryDelayTimeArray TEXT");
    L19:
        addItem(r100, "chunkDowngradeRetry INTEGER");
        addItem(r100, "backUpUrlsStr TEXT");
        addItem(r100, "backUpUrlRetryCount INTEGER");
        addItem(r100, "realDownloadTime INTEGER");
        addItem(r100, "retryScheduleMinutes INTEGER");
        addItem(r100, "independentProcess INTEGER");
    L20:
        addItem(r100, "auxiliaryJsonobjectString TEXT");
    L21:
        addItem(r100, "iconUrl TEXT");
        addItem(r100, "appVersionCode INTEGER");
    L22:
        r100.execSQL(DBDefinition.CREATE_SEGMENT_TABLE);
    L23:
        addItem(r100, "taskId TEXT");
    L24:
        addItem(r100, "downloadStartTimeStamp INTEGER");
        addItem(r100, "downloadFinishTimeStamp INTEGER");
        addItem(r100, "installedTimeStamp INTEGER");
        addItem(r100, "hasDoInstallation INTEGER");
    L25:
        addItem(r100, "cacheLifeTimeMax INTEGER");
    L26:
        addItem(r100, "pcdnUrlsStr TEXT");
        addItem(r100, "cdnUrlsStr TEXT");
    L27:
        addItem(r100, "backCurBytes INTEGER");
        addItem(r100, "realBackDownloadTime INTEGER");
    L28:
        addItem(r100, "monitorScene TEXT");
        return;
    L30:
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug("DownloadDBHelper", "onDowngrade", "OldVersion: " + r101 + " newVersion: " + r102);
    L6:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SUPPORT_SQLITE_DOWNGRADE) <= 0) goto L9;
        dropAndCreateDBTable(r100);
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug("DownloadDBHelper", "onUpgrade", "Run OldVersion: " + r101 + " newVersion: " + r102);
    L16:
        onUpgradeImpl(r100, r101, r102);     // Catch: Throwable -> L7
    L12:
        if (Logger.debug() == false) goto L18;
        Logger.globalDebug("DownloadDBHelper", "onUpgrade", "Run End");
        return;
    L18:
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError("DownloadDBHelper", "onUpgrade", "Error:" + th);
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.SQLITE_UPGRADE_FAIL_DROP_TABLE) <= 0) goto L15;
        dropAndCreateDBTable(r100);
        goto L12
    L15:
        throw th;
    }
}
