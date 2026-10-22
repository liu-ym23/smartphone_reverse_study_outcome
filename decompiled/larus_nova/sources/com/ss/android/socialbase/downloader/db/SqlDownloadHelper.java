package com.ss.android.socialbase.downloader.db;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IMainThreadMonitor;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes5.dex */
public class SqlDownloadHelper {
    private static int APP_VERSION_CODE_INDEX = -1;
    private static int AUXILIARY_JSONOBJECT_STRING_INDEX = -1;
    private static int BACKUP_URLS_STR_INDEX = -1;
    private static int BACKUP_URL_RETRY_COUNT_INDEX = -1;
    private static int BACK_CUR_BYTES_INDEX = -1;
    private static int CACHE_LIFE_TIME_MAX_INDEX = -1;
    private static int CDN_URLS_STR_INDEX = -1;
    private static int CHUNK_COUNT_INDEX = -1;
    public static final String COUNT_ALIAS = "countAlias";
    private static int CUR_BYTES_INDEX = -1;
    private static int CUR_RETRY_TIME_INDEX = -1;
    private static int DEFAULT_HTTP_SERVICE_BACKUP_INDEX = -1;
    private static int DOWNLOAD_FINISH_TIMESTAMP_INDEX = -1;
    private static int DOWNLOAD_START_TIMESTAMP_INDEX = -1;
    private static int DOWNLOAD_TIME_INDEX = -1;
    private static int ETAG_INDEX = -1;
    private static int EXTRA_INDEX = -1;
    private static int FIRST_DOWNLOAD_INDEX = -1;
    private static int FIRST_SUCCESS_INDEX = -1;
    private static int FORCE_INDEX = -1;
    private static int HAS_DO_INSTALLATION_INDEX = -1;
    private static int ICON_URL_INDEX = -1;
    private static int ID_INDEX = -1;
    private static int INDEPENDENT_PROCESS_INDEX = -1;
    private static int INSTALLED_TIMESTAMP_INDEX = -1;
    private static final String KEY_CHECK_DB_INDEX_CREATE_TIME = "key_check_db_index_create_time";
    private static final String KEY_DB_INDEX_CREATE = "key_db_index_create";
    private static int MD5_INDEX = -1;
    private static int MIME_TYPE_INDEX = -1;
    private static int MONITOR_SCENE_INDEX = -1;
    private static int NAME_INDEX = -1;
    private static int NEED_HTTPS_TO_HTTP_RETRY_INDEX = -1;
    private static int NOTIFICATION_ENABLE_INDEX = -1;
    private static int NOTIFICATION_VISIBILITY_INDEX = -1;
    private static int ONLY_WIFI_INDEX = -1;
    private static int PACKAGE_NAME_INDEX = -1;
    private static int PCDN_URLS_STR_INDEX = -1;
    private static int REAL_BACK_DOWNLOAD_TIME_INDEX = -1;
    private static int REAL_DOWNLOAD_TIME_INDEX = -1;
    private static int RETRY_COUNT_INDEX = -1;
    private static int SAVE_PATH_INDEX = -1;
    private static int STATUS_INDEX = -1;
    public static final String SUM_BYTES_ALIAS = "sumBytesAlias";
    private static final String TAG = "SqlDownloadHelper";
    private static int TEMP_PATH_INDEX = -1;
    private static int TITLE_INDEX = -1;
    private static int TOTAL_BYTES_INDEX = -1;
    private static int URL_INDEX = -1;
    private static boolean isLoadIndex;
    private static IMainThreadMonitor sMainThreadMonitor;

    public SqlDownloadHelper() {
    }

    private static SQLiteDatabase getDataBase() {
        IDownloadCache r100 = DownloadComponentManager.getDownloadCache();
        if ((r100 instanceof DefaultDownloadCache) == true) goto L5;
        return null;
    L5:
        ISqlDownloadCache r101 = ((DefaultDownloadCache) r100).getSqlDownloadCache();
        if (r101 != null) goto L8;
    L10:
        SQLiteDatabase r102 = ((SqlDownloadCache) r101).getDatabase();
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102;
    L8:
        if ((r101 instanceof SqlDownloadCache) == true) goto L10;
        return null;
    }

    public static void resetDBIndexState() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CREATE_SQLITE_DOWNLOAD_ID_INDEX_MIN_DATA_COUNT) > 0) goto L5;
        return;
    L5:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CHECK_CREATE_SQLITE_DOWNLOAD_ID_INDEX_INTERVAL_D) <= 0) goto L15;
        DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0).edit().remove(KEY_DB_INDEX_CREATE).remove(KEY_CHECK_DB_INDEX_CREATE_TIME).apply();     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "resetDBIndexState", "Error:" + th);
        return;
    }

    public static void tryCreateDBIndex() {
        if (Logger.debug() == false) goto L5;
        Logger.globalDebug(TAG, "tryCreateDBIndex", "Run");
    L5:
        int r100 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CHECK_CREATE_SQLITE_DOWNLOAD_ID_INDEX_INTERVAL_D);
        if (r100 > 0) goto L8;
        return;
    L8:
        int r101 = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.CREATE_SQLITE_DOWNLOAD_ID_INDEX_MIN_DATA_COUNT);
        if (r101 > 0) goto L25;
        return;
    L25:
    L22:
        th = move-exception;
        Logger.globalError(TAG, "tryCreateDBIndex", "Error:" + th);
        return;
    L12:
        if (checkInterval(r100) == true) goto L14;
        return;
    L14:
        SQLiteDatabase r102 = getDataBase();     // Catch: Throwable -> L22
        if (r102 != null) goto L17;
        return;
    L17:
        if (checkRowCount(r102, r101) == false) goto L27;
        createDBIndexImpl(r102);     // Catch: Throwable -> L22
        return;
    }

    public static IMainThreadMonitor getMainThreadMonitor() {
        return sMainThreadMonitor;
    }

    private static boolean checkInterval(int r110) {
        SharedPreferences r100 = DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0);
        if (r100.getBoolean(KEY_DB_INDEX_CREATE, false) == true) goto L5;
        long r101 = r100.getLong(KEY_CHECK_DB_INDEX_CREATE_TIME, 0);
        if ((System.currentTimeMillis() - r101) < (((long) r110) * 86400000)) goto L11;
        r100.edit().putLong(KEY_CHECK_DB_INDEX_CREATE_TIME, System.currentTimeMillis()).apply();
        return true;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "checkInterval", "Not exceeding the detection period");
    L13:
        return false;
    L5:
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "checkInterval", "The index has already been created");
    L7:
        return false;
    }

    private static void createDBIndexImpl(SQLiteDatabase r100) {
        if (Logger.debug() == false) goto L14;
        Logger.globalDebug(TAG, "createDBIndexImpl", "Run");
    L14:
        r100.beginTransaction();     // Catch: Throwable -> L7
        r100.execSQL("CREATE INDEX IF NOT EXISTS idx_id ON downloader (_id)");     // Catch: Throwable -> L7
    L6:
        r100.endTransaction();
        return;
    L7:
        th = move-exception;
        Logger.globalError(TAG, "createDBIndexImpl", "Error:" + th);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r100.endTransaction();
        throw th;
    }

    public static boolean loadDownloadInfoIndex(Cursor r100) {
        if (isLoadIndex == false) goto L11;
        return true;
    L11:
        ID_INDEX = r100.getColumnIndex(DBDefinition.ID);     // Catch: Exception -> L8
        NAME_INDEX = r100.getColumnIndex("name");     // Catch: Exception -> L8
        TITLE_INDEX = r100.getColumnIndex("title");     // Catch: Exception -> L8
        URL_INDEX = r100.getColumnIndex("url");     // Catch: Exception -> L8
        SAVE_PATH_INDEX = r100.getColumnIndex(DBDefinition.SAVE_PATH);     // Catch: Exception -> L8
        TEMP_PATH_INDEX = r100.getColumnIndex(DBDefinition.TEMP_PATH);     // Catch: Exception -> L8
        STATUS_INDEX = r100.getColumnIndex("status");     // Catch: Exception -> L8
        CUR_BYTES_INDEX = r100.getColumnIndex(DBDefinition.CUR_BYTES);     // Catch: Exception -> L8
        FORCE_INDEX = r100.getColumnIndex("force");     // Catch: Exception -> L8
        MIME_TYPE_INDEX = r100.getColumnIndex(DBDefinition.MIME_TYPE);     // Catch: Exception -> L8
        CACHE_LIFE_TIME_MAX_INDEX = r100.getColumnIndex(DBDefinition.CACHE_LIFE_TIME_MAX);     // Catch: Exception -> L8
        AUXILIARY_JSONOBJECT_STRING_INDEX = r100.getColumnIndex(DBDefinition.AUXILIARY_JSONOBJECT_STRING);     // Catch: Exception -> L8
        DOWNLOAD_START_TIMESTAMP_INDEX = r100.getColumnIndex(DBDefinition.DOWNLOAD_START_TIMESTAMP);     // Catch: Exception -> L8
        MONITOR_SCENE_INDEX = r100.getColumnIndex(DBDefinition.MONITOR_SCENE);     // Catch: Exception -> L8
        CHUNK_COUNT_INDEX = r100.getColumnIndex(DBDefinition.CHUNK_COUNT);     // Catch: Exception -> L8
        BACK_CUR_BYTES_INDEX = r100.getColumnIndex(DBDefinition.BACK_CUR_BYTES);     // Catch: Exception -> L8
        TOTAL_BYTES_INDEX = r100.getColumnIndex(DBDefinition.TOTAL_BYTES);     // Catch: Exception -> L8
        ETAG_INDEX = r100.getColumnIndex(DBDefinition.ETAG);     // Catch: Exception -> L8
        ONLY_WIFI_INDEX = r100.getColumnIndex(DBDefinition.ONLY_WIFI);     // Catch: Exception -> L8
        RETRY_COUNT_INDEX = r100.getColumnIndex(DBDefinition.RETRY_COUNT);     // Catch: Exception -> L8
        EXTRA_INDEX = r100.getColumnIndex("extra");     // Catch: Exception -> L8
        NOTIFICATION_ENABLE_INDEX = r100.getColumnIndex(DBDefinition.NOTIFICATION_ENABLE);     // Catch: Exception -> L8
        NOTIFICATION_VISIBILITY_INDEX = r100.getColumnIndex(DBDefinition.NOTIFICATION_VISIBILITY);     // Catch: Exception -> L8
        FIRST_DOWNLOAD_INDEX = r100.getColumnIndex(DBDefinition.FIRST_DOWNLOAD);     // Catch: Exception -> L8
        FIRST_SUCCESS_INDEX = r100.getColumnIndex(DBDefinition.FIRST_SUCCESS);     // Catch: Exception -> L8
        NEED_HTTPS_TO_HTTP_RETRY_INDEX = r100.getColumnIndex(DBDefinition.NEED_HTTPS_TO_HTTP_RETRY);     // Catch: Exception -> L8
        DOWNLOAD_TIME_INDEX = r100.getColumnIndex(DBDefinition.DOWNLOAD_TIME);     // Catch: Exception -> L8
        PACKAGE_NAME_INDEX = r100.getColumnIndex("packageName");     // Catch: Exception -> L8
        MD5_INDEX = r100.getColumnIndex("md5");     // Catch: Exception -> L8
        CUR_RETRY_TIME_INDEX = r100.getColumnIndex(DBDefinition.CUR_RETRY_TIME);     // Catch: Exception -> L8
        DEFAULT_HTTP_SERVICE_BACKUP_INDEX = r100.getColumnIndex(DBDefinition.DEFAULT_HTTP_SERVICE_BACKUP);     // Catch: Exception -> L8
        BACKUP_URLS_STR_INDEX = r100.getColumnIndex(DBDefinition.BACKUP_URLS_STR);     // Catch: Exception -> L8
        BACKUP_URL_RETRY_COUNT_INDEX = r100.getColumnIndex(DBDefinition.BACKUP_URL_RETRY_COUNT);     // Catch: Exception -> L8
        REAL_DOWNLOAD_TIME_INDEX = r100.getColumnIndex(DBDefinition.REAL_DOWNLOAD_TIME);     // Catch: Exception -> L8
        REAL_BACK_DOWNLOAD_TIME_INDEX = r100.getColumnIndex(DBDefinition.REAL_BACK_DOWNLOAD_TIME);     // Catch: Exception -> L8
        INDEPENDENT_PROCESS_INDEX = r100.getColumnIndex(DBDefinition.INDEPENDENT_PROCESS);     // Catch: Exception -> L8
        ICON_URL_INDEX = r100.getColumnIndex("iconUrl");     // Catch: Exception -> L8
        APP_VERSION_CODE_INDEX = r100.getColumnIndex(DBDefinition.APP_VERSION_CODE);     // Catch: Exception -> L8
        DOWNLOAD_FINISH_TIMESTAMP_INDEX = r100.getColumnIndex(DBDefinition.DOWNLOAD_FINISH_TIMESTAMP);     // Catch: Exception -> L8
        INSTALLED_TIMESTAMP_INDEX = r100.getColumnIndex(DBDefinition.INSTALLED_TIMESTAMP);     // Catch: Exception -> L8
        HAS_DO_INSTALLATION_INDEX = r100.getColumnIndex(DBDefinition.HAS_DO_INSTALLATION);     // Catch: Exception -> L8
        PCDN_URLS_STR_INDEX = r100.getColumnIndex(DBDefinition.PCDN_URLS_STR);     // Catch: Exception -> L8
        CDN_URLS_STR_INDEX = r100.getColumnIndex(DBDefinition.CDN_URLS_STR);     // Catch: Exception -> L8
        isLoadIndex = true;
        return true;
    L8:
        e = move-exception;
        DownloadMonitorHelper.monitorDownloadOtherError(e);
        Logger.globalError(TAG, "loadDownloadInfoIndex", "Error:" + e);
        return false;
    }

    public static int parseDownloadId(Cursor r100) {
        return r100.getInt(ID_INDEX);
    }

    public static DownloadInfo parsePartialDownloadInfo(Cursor r100) {
        DownloadInfo r101 = new DownloadInfo();
        parsePartialDownloadInfo(r100, r101, parseMonitorScene(r100, r101));
        return r101;
    }

    public static void setMainThreadMonitor(IMainThreadMonitor r100) {
        sMainThreadMonitor = r100;
    }

    private static boolean checkRowCount(SQLiteDatabase r100, int r101) {
        Cursor r102 = null;
        r102 = r100.rawQuery("SELECT COUNT(*) FROM downloader", null);     // Catch: Throwable -> L9
        if (r102.moveToFirst() == false) goto L7;
        int r103 = r102.getInt(0);     // Catch: Throwable -> L9
    L8:
        DownloadUtils.safeClose(new Cursor[]{r102});
    L12:
        if (r103 < r101) goto L14;
        DownloadComponentManager.getAppContext().getSharedPreferences(DownloadConstants.SP_DOWNLOAD_CACHE, 0).edit().putBoolean(KEY_DB_INDEX_CREATE, true).apply();
        return true;
    L14:
        if (Logger.debug() == false) goto L16;
        Logger.globalDebug(TAG, "checkRowCount", "RowCount:" + r103 + " createIndexMinDataCount:" + r101);
    L16:
        return false;
    L7:
        r103 = 0;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "checkRowCount", "Error:" + th);     // Catch: Throwable -> L19
        DownloadUtils.safeClose(new Cursor[]{r102});
        r103 = 0;
    L19:
        th = move-exception;
        DownloadUtils.safeClose(new Cursor[]{r102});
        throw th;
    }

    public static void parseAllRemainingDownloadInfo(Cursor r100, DownloadInfo r101) {
        r101.setChunkCount(r100.getInt(CHUNK_COUNT_INDEX));     // Catch: Exception -> L35
        r101.setBackCurBytes(r100.getLong(BACK_CUR_BYTES_INDEX));     // Catch: Exception -> L35
        r101.setTotalBytes(r100.getLong(TOTAL_BYTES_INDEX));     // Catch: Exception -> L35
        r101.seteTag(r100.getString(ETAG_INDEX));     // Catch: Exception -> L35
        boolean r102 = false;
        if (r100.getInt(ONLY_WIFI_INDEX) == 0) goto L5;
        boolean r103 = true;
    L6:
        r101.setOnlyWifi(r103);     // Catch: Exception -> L35
        r101.setRetryCount(r100.getInt(RETRY_COUNT_INDEX));     // Catch: Exception -> L35
        r101.setExtra(r100.getString(EXTRA_INDEX));     // Catch: Exception -> L35
        if (r100.getInt(NOTIFICATION_ENABLE_INDEX) == 0) goto L9;
        boolean r104 = true;
    L10:
        r101.setShowNotification(r104);     // Catch: Exception -> L35
        r101.setNotificationVisibility(r100.getInt(NOTIFICATION_VISIBILITY_INDEX));     // Catch: Exception -> L35
        if (r100.getInt(FIRST_DOWNLOAD_INDEX) != 1) goto L13;
        boolean r105 = true;
    L14:
        r101.setFirstDownload(r105);     // Catch: Exception -> L35
        if (r100.getInt(FIRST_SUCCESS_INDEX) != 1) goto L17;
        boolean r106 = true;
    L18:
        r101.setFirstSuccess(r106);     // Catch: Exception -> L35
        if (r100.getInt(NEED_HTTPS_TO_HTTP_RETRY_INDEX) != 1) goto L21;
        boolean r107 = true;
    L22:
        r101.setNeedHttpsToHttpRetry(r107);     // Catch: Exception -> L35
        r101.setDownloadTime(r100.getLong(DOWNLOAD_TIME_INDEX));     // Catch: Exception -> L35
        r101.setPackageName(r100.getString(PACKAGE_NAME_INDEX));     // Catch: Exception -> L35
        r101.setMd5(r100.getString(MD5_INDEX));     // Catch: Exception -> L35
        r101.setCurRetryTime(r100.getInt(CUR_RETRY_TIME_INDEX));     // Catch: Exception -> L35
        if (r100.getInt(DEFAULT_HTTP_SERVICE_BACKUP_INDEX) != 1) goto L25;
        boolean r108 = true;
    L26:
        r101.setNeedDefaultHttpServiceBackUp(r108);     // Catch: Exception -> L35
        r101.setBackUpUrlsStr(r100.getString(BACKUP_URLS_STR_INDEX));     // Catch: Exception -> L35
        r101.setBackUpUrlRetryCount(r100.getInt(BACKUP_URL_RETRY_COUNT_INDEX));     // Catch: Exception -> L35
        r101.setRealDownloadTime(r100.getLong(REAL_DOWNLOAD_TIME_INDEX));     // Catch: Exception -> L35
        r101.setRealBackDownloadTime(r100.getLong(REAL_BACK_DOWNLOAD_TIME_INDEX));     // Catch: Exception -> L35
        if (r100.getInt(INDEPENDENT_PROCESS_INDEX) != 1) goto L29;
        boolean r109 = true;
    L30:
        r101.setNeedIndependentProcess(r109);     // Catch: Exception -> L35
        r101.setIconUrl(r100.getString(ICON_URL_INDEX));     // Catch: Exception -> L35
        r101.setAppVersionCode(r100.getInt(APP_VERSION_CODE_INDEX));     // Catch: Exception -> L35
        r101.setDownloadFinishTimeStamp(r100.getLong(DOWNLOAD_FINISH_TIMESTAMP_INDEX));     // Catch: Exception -> L35
        r101.setInstalledTimeStamp(r100.getLong(INSTALLED_TIMESTAMP_INDEX));     // Catch: Exception -> L35
        if (r100.getInt(HAS_DO_INSTALLATION_INDEX) != 1) goto L33;
        r102 = true;
    L33:
        r101.setHasDoInstallation(r102);     // Catch: Exception -> L35
        r101.setPcdnUrlsStr(r100.getString(PCDN_URLS_STR_INDEX));     // Catch: Exception -> L35
        r101.setCdnUrlsStr(r100.getString(CDN_URLS_STR_INDEX));     // Catch: Exception -> L35
        return;
    L29:
        r109 = false;
        goto L30
    L25:
        r108 = false;
        goto L26
    L21:
        r107 = false;
        goto L22
    L17:
        r106 = false;
        goto L18
    L13:
        r105 = false;
        goto L14
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
    L35:
        e = move-exception;
        DownloadMonitorHelper.monitorDownloadOtherError(e);
        Logger.globalError(TAG, "parseAllRemainingDownloadInfo", "Error:" + e);
    }

    public static boolean parseMonitorScene(Cursor r100, DownloadInfo r101) {
        String r102 = r100.getString(MONITOR_SCENE_INDEX);
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r101.setMonitorScene(r102);
        return false;
    L6:
        String r103 = r100.getString(AUXILIARY_JSONOBJECT_STRING_INDEX);
        if (TextUtils.isEmpty(r103) == false) goto L9;
        return true;
    L9:
        r101.setDbJsonDataString(r103);
        r101.unsafeEnsureDBJsonData();
        r101.setMonitorScene(r101.getDBJsonString("monitor_scene"));
        return true;
    }

    public static DownloadInfo parsePartialDownloadInfo(Cursor r100, DownloadInfo r101, boolean r102) {
        r101.setId(r100.getInt(ID_INDEX));     // Catch: Exception -> L10
        r101.setName(r100.getString(NAME_INDEX));     // Catch: Exception -> L10
        r101.setTitle(r100.getString(TITLE_INDEX));     // Catch: Exception -> L10
        r101.setUrl(r100.getString(URL_INDEX));     // Catch: Exception -> L10
        r101.setSavePath(r100.getString(SAVE_PATH_INDEX));     // Catch: Exception -> L10
        r101.setTempPath(r100.getString(TEMP_PATH_INDEX));     // Catch: Exception -> L10
        r101.setStatus(r100.getInt(STATUS_INDEX));     // Catch: Exception -> L10
        r101.setCurBytes(r100.getLong(CUR_BYTES_INDEX));     // Catch: Exception -> L10
        if (r100.getInt(FORCE_INDEX) == 0) goto L5;
        boolean r103 = true;
    L6:
        r101.setForce(r103);     // Catch: Exception -> L10
        r101.setMimeType(r100.getString(MIME_TYPE_INDEX));     // Catch: Exception -> L10
        r101.setCacheLifeTimeMax(r100.getLong(CACHE_LIFE_TIME_MAX_INDEX));     // Catch: Exception -> L10
        r101.setDownloadStartTimeStamp(r100.getLong(DOWNLOAD_START_TIMESTAMP_INDEX));     // Catch: Exception -> L10
        if (r102 == true) goto L12;
        r101.setDbJsonDataString(r100.getString(AUXILIARY_JSONOBJECT_STRING_INDEX));     // Catch: Exception -> L10
    L12:
        return r101;
    L5:
        r103 = false;
    L10:
        e = move-exception;
        DownloadMonitorHelper.monitorDownloadOtherError(e);
        Logger.globalError(TAG, "parsePartialDownloadInfo", "Error:" + e);
        goto L12
    }
}
