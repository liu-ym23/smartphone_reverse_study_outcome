package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadDirUtils {
    private static final String EXTERNAL_DOWNLOAD_DIRECTORY = null;
    public static String EXT_PUBLIC_DIR = "ByteDownload";
    private static String FAST_TEMP_PATH = null;
    private static final String TAG = "DownloadDirUtils";
    private static volatile File dataDir;
    private static volatile File externalCacheDir;
    private static volatile File externalFilesDir;
    private static volatile File externalStorageDirectory;
    private static volatile File externalStoragePublicDirectory;
    private static volatile File filesDir;
    private static volatile Boolean isExternalStorageLegacy;
    private static volatile File obbDir;

    public DownloadDirUtils() {
    }

    public static String getExtPublicDownloadPath() {
        return getExternalStoragePublicDirectory(false).getAbsolutePath();
    L5:
        e = move-exception;
        Logger.globalError(TAG, "getExtPublicDownloadPath", "Error:" + e);
        return null;
    }

    static {
        EXTERNAL_DOWNLOAD_DIRECTORY = Environment.DIRECTORY_DOWNLOADS + File.separator + EXT_PUBLIC_DIR;
        FAST_TEMP_PATH = null;
        externalCacheDir = null;
        obbDir = null;
        filesDir = null;
        externalFilesDir = null;
        externalStorageDirectory = null;
        dataDir = null;
        externalStoragePublicDirectory = null;
        isExternalStorageLegacy = null;
    }

    public static String getDefaultDataPath() {
        Context r100 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r100 == null) goto L8;
        File r101 = getFilesDir(r100, false);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getAbsolutePath();
    L8:
        return null;
    }

    public static String getDefaultExtPrivatePath() {
        Context r100 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return getExternalFilesDir(r100, false).getAbsolutePath();
    L12:
        return null;
    L6:
        e = move-exception;
        Logger.globalError(TAG, "getDefaultExtPrivatePath", "Error:" + e);
        return null;
    }

    public static String getDefaultExtPublicPath() {
        return getExternalStorageDirectory(false).getPath() + File.separator + DownloadSetting.obtainGlobal().optString(DownloadSettingKeys.DEFAULT_SAVE_DIR_NAME, EXT_PUBLIC_DIR);
    L4:
        e = move-exception;
        Logger.globalError(TAG, "getDefaultExtPublicPath", "Error:" + e);
        return null;
    }

    public static String getDownloadFastTempPath() {
        String r100 = FAST_TEMP_PATH;
        if (r100 == null) goto L10;
        return r100;
    L10:
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L7
        r101.append(getFilesDir(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext(), false));     // Catch: Throwable -> L7
        String r102 = File.separator;     // Catch: Throwable -> L7
        r101.append(r102);     // Catch: Throwable -> L7
        r101.append("download");     // Catch: Throwable -> L7
        r101.append(r102);     // Catch: Throwable -> L7
        r101.append("temp_fast_download");     // Catch: Throwable -> L7
        String r103 = r101.toString();     // Catch: Throwable -> L7
        FAST_TEMP_PATH = r103;     // Catch: Throwable -> L7
        return r103;
    L7:
        th = move-exception;
        th.printStackTrace();
        Logger.globalError(TAG, "getDownloadFastTempPath", "Error:" + th);
        return null;
    }

    public static String getDownloadPath() {
        return getValidDownloadPath(Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveDir());
    }

    public static String getDownloadTempPath() {
        return getValidDownloadPath(Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveTempDir());
    }

    public static String getGlobalSavePath() {
        File r100 = Downloader.getInstance(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()).getGlobalSaveDir();     // Catch: Exception -> L6
        if (r100 == null) goto L12;
        return r100.getAbsolutePath();
    L12:
        return null;
    L6:
        e = move-exception;
        Logger.globalError(TAG, "getGlobalSavePath", "Error:" + e);
        return null;
    }

    public static Uri getRootContentUri() {
        return MediaStore.Files.getContentUri("external");
    }

    public static String getExternalRelativePath() {
        return EXTERNAL_DOWNLOAD_DIRECTORY;
    }

    public static void forceLoadStoragePathCache(Context r100) {
        getExternalCacheDir(r100, true);
        getObbDirStr(r100, true);
        getFilesDir(r100, true);
        getExternalFilesDir(r100, true);
        getExternalStorageDirectory(true);
        getDataDirectory(true);
        getExternalStoragePublicDirectory(true);
        isExternalStorageLegacy(true);
    }

    public static File getDataDirectory(boolean r100) {
        if (dataDir == null) goto L13;
        if (r100 == true) goto L13;
        return dataDir;
    L13:
        dataDir = Environment.getDataDirectory();     // Catch: Throwable -> L9
    L12:
        return dataDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getDataDirectory", "Error:" + th);
        goto L12
    }

    public static File getExternalStorageDirectory(boolean r100) {
        if (externalStorageDirectory == null) goto L13;
        if (r100 == true) goto L13;
        return externalStorageDirectory;
    L13:
        externalStorageDirectory = Environment.getExternalStorageDirectory();     // Catch: Throwable -> L9
    L12:
        return externalStorageDirectory;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalStorageDirectory", "Error:" + th);
        goto L12
    }

    public static File getExternalStoragePublicDirectory(boolean r100) {
        if (externalStoragePublicDirectory == null) goto L13;
        if (r100 == true) goto L13;
        return externalStoragePublicDirectory;
    L13:
        externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return externalStoragePublicDirectory;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalStoragePublicDirectory", "Error:" + th);
        goto L12
    }

    public static String getValidDownloadPath(File r100) {
        Context r101 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (isValidDirectory(r100) == true) goto L5;
        if (r101 != null) goto L10;
        Logger.globalError(TAG, "getValidDownloadPath", "Context is null");
        return null;
    L10:
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_SAVE_EXTERNAL_DIR) > 0) goto L12;
        File r102 = getExternalFilesDir(r101, false);
        if (isValidDirectory(r102) == false) goto L18;
        return r102.getAbsolutePath();
    L18:
        return getDefaultDataPath();
    L12:
        return getDefaultDataPath();
    L5:
        return r100.getAbsolutePath();
    }

    public static boolean isExternalStorageLegacy(boolean r100) {
        if (isExternalStorageLegacy == null) goto L16;
        if (r100 == true) goto L16;
        return isExternalStorageLegacy.booleanValue();
    L16:
    L12:
        th = move-exception;
        Logger.globalError(TAG, "isExternalStorageLegacy", "Error:" + th);
    L15:
        return isExternalStorageLegacy.booleanValue();
    L8:
        if (Build.VERSION.SDK_INT < 29) goto L10;
        isExternalStorageLegacy = Boolean.valueOf(Environment.isExternalStorageLegacy());     // Catch: Throwable -> L12
        goto L15
    L10:
        isExternalStorageLegacy = Boolean.FALSE;     // Catch: Throwable -> L12
        goto L15
    }

    public static boolean isSavePathSecurity(String r100) {
        Context r101 = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
        if (r101 != null) goto L5;
    L19:
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L19;
        File r102 = getDataDirectory(false);     // Catch: Exception -> L17
        if (r102 != null) goto L10;
    L12:
        File r103 = getExternalCacheDir(r101, false);     // Catch: Exception -> L17
        if (r103 == null) goto L19;
        if (r100.startsWith(r103.getParent()) == false) goto L19;
        return true;
    L10:
        if (r100.startsWith(r102.getAbsolutePath()) == false) goto L12;
        return true;
    L17:
        e = move-exception;
        e.printStackTrace();
        Logger.globalError(TAG, "isSavePathSecurity", "Error:" + e);
        goto L19
    }

    public static boolean isValidDirectory(File r100) {
        if (r100 != null) goto L16;
        return false;
    L16:
    L15:
        return false;
    L6:
        if (r100.exists() == false) goto L8;
    L10:
        if (r100.isDirectory() == true) goto L13;
        return false;
    L13:
        return true;
    L8:
        if (r100.mkdirs() == true) goto L10;
        return false;
    }

    public static File getExternalCacheDir(Context r100, boolean r101) {
        if (externalCacheDir == null) goto L13;
        if (r101 == true) goto L13;
        return externalCacheDir;
    L13:
        externalCacheDir = r100.getExternalCacheDir();     // Catch: Throwable -> L9
    L12:
        return externalCacheDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalCacheDir", "Error:" + th);
        goto L12
    }

    public static File getExternalFilesDir(Context r100, boolean r101) {
        if (externalFilesDir == null) goto L13;
        if (r101 == true) goto L13;
        return externalFilesDir;
    L13:
        externalFilesDir = r100.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);     // Catch: Throwable -> L9
    L12:
        return externalFilesDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getExternalFilesDir", "Error:" + th);
        goto L12
    }

    public static File getFilesDir(Context r100, boolean r101) {
        if (filesDir == null) goto L13;
        if (r101 == true) goto L13;
        return filesDir;
    L13:
        filesDir = r100.getFilesDir();     // Catch: Throwable -> L9
    L12:
        return filesDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getFilesDir", "Error:" + th);
        goto L12
    }

    public static File getObbDirStr(Context r100, boolean r101) {
        if (obbDir == null) goto L13;
        if (r101 == true) goto L13;
        return obbDir;
    L13:
        obbDir = r100.getObbDir();     // Catch: Throwable -> L9
    L12:
        return obbDir;
    L9:
        th = move-exception;
        Logger.globalError(TAG, "getObbDirStr", "Error:" + th);
        goto L12
    }
}
