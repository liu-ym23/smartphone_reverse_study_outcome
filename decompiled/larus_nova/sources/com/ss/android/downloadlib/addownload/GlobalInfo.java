package com.ss.android.downloadlib.addownload;

import android.content.Context;
import com.ss.android.download.api.config.AppStatusChangeListener;
import com.ss.android.download.api.config.DownloadAutoInstallInterceptListener;
import com.ss.android.download.api.config.DownloadBpeaCertFactory;
import com.ss.android.download.api.config.DownloadBusinessInterceptor;
import com.ss.android.download.api.config.DownloadClearSpaceListener;
import com.ss.android.download.api.config.DownloadComplianceDialogCallback;
import com.ss.android.download.api.config.DownloadEventInterceptFactory;
import com.ss.android.download.api.config.DownloadEventLogger;
import com.ss.android.download.api.config.DownloadEventModelFactory;
import com.ss.android.download.api.config.DownloadLoggerListener;
import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.download.api.config.DownloadPermissionChecker;
import com.ss.android.download.api.config.DownloadProgressHandleFactory;
import com.ss.android.download.api.config.DownloadPushFactory;
import com.ss.android.download.api.config.DownloadSettings;
import com.ss.android.download.api.config.DownloadTLogger;
import com.ss.android.download.api.config.DownloadTaskQueueHandleFactory;
import com.ss.android.download.api.config.DownloadUIFactory;
import com.ss.android.download.api.config.DownloadUserEventLogger;
import com.ss.android.download.api.config.IApkUpdateHandler;
import com.ss.android.download.api.config.ICleanManager;
import com.ss.android.download.api.config.IDownloadCertManager;
import com.ss.android.download.api.config.IDownloadCustomChecker;
import com.ss.android.download.api.config.IDownloaderMonitor;
import com.ss.android.download.api.config.IEncryptor;
import com.ss.android.download.api.config.IPackageChannelChecker;
import com.ss.android.download.api.inner.ITTDownloaderMonitor;
import com.ss.android.download.api.model.AppInfo;
import com.ss.android.download.api.runtime.IAdDownloadActionProvider;
import com.ss.android.download.api.runtime.IAdDownloadCheckerProvider;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener;
import com.ss.android.socialbase.downloader.logger.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class GlobalInfo {
    public static final JSONObject EMPTY_JSON = null;
    private static final String SDK_VERSION = "1.7.0";
    private static final String SLARDAR_APP_ID = "6103";
    private static DownloadAutoInstallInterceptListener mDownloadAutoInstallInterceptListener;
    private static IAdDownloadActionProvider sAdDownloadActionProvider;
    private static IAdDownloadCheckerProvider sAdDownloadCheckerProvider;
    private static IApkUpdateHandler sApkUpdateHandler;
    private static AppInfo sAppInfo;
    private static AppStatusChangeListener sAppStatusChangeListener;
    private static ICleanManager sCleanManager;
    private static Context sContext;
    private static DownloadBpeaCertFactory sDownloadBpeaCertFactory;
    private static DownloadBusinessInterceptor sDownloadBusinessInterceptor;
    private static IDownloadCertManager sDownloadCertManager;
    private static DownloadClearSpaceListener sDownloadClearSpaceListener;
    private static DownloadComplianceDialogCallback sDownloadComplianceDialogCallback;
    private static IDownloadCustomChecker sDownloadCustomChecker;
    private static DownloadEventInterceptFactory sDownloadEventInterceptFactory;
    private static DownloadEventLogger sDownloadEventLogger;
    private static DownloadEventModelFactory sDownloadEventModelFactory;
    private static DownloadLoggerListener sDownloadLoggerListener;
    private static DownloadNetworkFactory sDownloadNetworkFactory;
    private static DownloadPermissionChecker sDownloadPermissionChecker;
    private static DownloadProgressHandleFactory sDownloadProgressHandleFactory;
    private static DownloadPushFactory sDownloadPushFactory;
    private static JSONObject sDownloadReverseExperimentValue;
    private static DownloadSettings sDownloadSettings;
    private static DownloadTLogger sDownloadTLogger;
    private static DownloadTaskQueueHandleFactory sDownloadTaskQueueHandleFactory;
    private static DownloadUIFactory sDownloadUIFactory;
    private static DownloadUserEventLogger sDownloadUserEventLogger;
    private static IDownloaderMonitor sDownloaderMonitor;
    private static IEncryptor sEncryptor;
    private static IAppDownloadMonitorListener sMonitorListener;
    private static IPackageChannelChecker sPackageChannelChecker;
    private static ITTDownloaderMonitor sTTDownloaderMonitor;

    public GlobalInfo() {
    }

    public static String getSdkVersion() {
        return SDK_VERSION;
    }

    static {
        EMPTY_JSON = new JSONObject();
    }

    public static Context getContext() {
        Context r100 = sContext;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Context is null");
    }

    public static DownloadBpeaCertFactory getDownloadBpeaCertFactory() {
        DownloadBpeaCertFactory r100 = sDownloadBpeaCertFactory;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new AnonymousClass7();
    }

    public static DownloadPushFactory getDownloadPushFactory() {
        DownloadPushFactory r100 = sDownloadPushFactory;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new AnonymousClass6();
    }

    public static JSONObject getDownloadSettings() {
        DownloadSettings r100 = sDownloadSettings;
        if (r100 == null) goto L5;
        JSONObject r101 = r100.get();
        if (r101 == null) goto L9;
        return r101;
    L9:
        return EMPTY_JSON;
    L5:
        return EMPTY_JSON;
    }

    public static IDownloaderMonitor getDownloaderMonitor() {
        if (sDownloaderMonitor != null) goto L6;
        sDownloaderMonitor = new AnonymousClass2();
    L6:
        return sDownloaderMonitor;
    }

    public static IEncryptor getEncryptor() {
        IEncryptor r100 = sEncryptor;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new AnonymousClass3();
    }

    public static IAppDownloadMonitorListener getMonitorListener() {
        if (sMonitorListener != null) goto L6;
        sMonitorListener = new AnonymousClass1();
    L6:
        return sMonitorListener;
    }

    public static ITTDownloaderMonitor getTTMonitor() {
        if (sTTDownloaderMonitor != null) goto L6;
        sTTDownloaderMonitor = new AnonymousClass4();
    L6:
        return sTTDownloaderMonitor;
    }

    public static boolean initCheck() {
        if (sDownloadEventLogger != null) goto L5;
        return false;
    L5:
        if (sDownloadNetworkFactory != null) goto L7;
        return false;
    L7:
        if (sDownloadSettings != null) goto L9;
        return false;
    L9:
        if (sAppStatusChangeListener != null) goto L11;
        return false;
    L11:
        if (sEncryptor == null) goto L20;
        return true;
    L20:
        return false;
    }

    public static /* synthetic */ IDownloadCertManager access$000() {
        return sDownloadCertManager;
    }

    public static IApkUpdateHandler getApkUpdateHandler() {
        return sApkUpdateHandler;
    }

    public static AppInfo getAppInfo() {
        return sAppInfo;
    }

    public static AppStatusChangeListener getAppStatusChangeListener() {
        return sAppStatusChangeListener;
    }

    public static ICleanManager getCleanManager() {
        return sCleanManager;
    }

    public static IAdDownloadActionProvider getDownloadActionFactory() {
        return sAdDownloadActionProvider;
    }

    public static DownloadAutoInstallInterceptListener getDownloadAutoInstallInterceptListener() {
        return mDownloadAutoInstallInterceptListener;
    }

    public static DownloadBusinessInterceptor getDownloadBusinessInterceptor() {
        return sDownloadBusinessInterceptor;
    }

    public static IDownloadCertManager getDownloadCertManager() {
        return sDownloadCertManager;
    }

    public static IAdDownloadCheckerProvider getDownloadCheckerFactory() {
        return sAdDownloadCheckerProvider;
    }

    public static DownloadClearSpaceListener getDownloadClearSpaceListener() {
        return sDownloadClearSpaceListener;
    }

    public static DownloadComplianceDialogCallback getDownloadComplianceDialogCallback() {
        return sDownloadComplianceDialogCallback;
    }

    public static IDownloadCustomChecker getDownloadCustomChecker() {
        return sDownloadCustomChecker;
    }

    public static DownloadEventInterceptFactory getDownloadEventInterceptFactory() {
        return sDownloadEventInterceptFactory;
    }

    public static DownloadEventLogger getDownloadEventLogger() {
        return sDownloadEventLogger;
    }

    public static DownloadEventModelFactory getDownloadEventModelFactory() {
        return sDownloadEventModelFactory;
    }

    public static DownloadLoggerListener getDownloadLoggerListener() {
        return sDownloadLoggerListener;
    }

    public static DownloadNetworkFactory getDownloadNetworkFactory() {
        return sDownloadNetworkFactory;
    }

    public static DownloadPermissionChecker getDownloadPermissionChecker() {
        return sDownloadPermissionChecker;
    }

    public static DownloadProgressHandleFactory getDownloadProgressHandleFactory() {
        return sDownloadProgressHandleFactory;
    }

    public static JSONObject getDownloadReverseExperimentValue() {
        return sDownloadReverseExperimentValue;
    }

    public static DownloadTLogger getDownloadTLogger() {
        return sDownloadTLogger;
    }

    public static DownloadTaskQueueHandleFactory getDownloadTaskQueueHandleFactory() {
        return sDownloadTaskQueueHandleFactory;
    }

    public static DownloadUIFactory getDownloadUIFactory() {
        return sDownloadUIFactory;
    }

    public static DownloadUserEventLogger getDownloadUserEventLogger() {
        return sDownloadUserEventLogger;
    }

    public static IPackageChannelChecker getPackageChannelChecker() {
        return sPackageChannelChecker;
    }

    public static void makeSureContext(Context r100) {
        if (sContext != null) goto L9;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.getApplicationContext() == null) goto L11;
        sContext = r100.getApplicationContext();
        return;
    L11:
        return;
    }

    public static void setApkUpdateHandler(IApkUpdateHandler r100) {
        sApkUpdateHandler = r100;
    }

    public static void setAppInfo(AppInfo r100) {
        sAppInfo = r100;
    }

    public static void setAppStatusChangeListener(AppStatusChangeListener r100) {
        sAppStatusChangeListener = r100;
    }

    public static void setCleanManager(ICleanManager r100) {
        sCleanManager = r100;
    }

    public static void setContext(Context r100) {
        if (r100 == null) goto L8;
        if (r100.getApplicationContext() == null) goto L8;
        sContext = r100.getApplicationContext();
        return;
    L8:
        throw new IllegalArgumentException("Context is null");
    }

    public static void setDownloadActionFactory(IAdDownloadActionProvider r100) {
        sAdDownloadActionProvider = r100;
    }

    public static void setDownloadAutoInstallInterceptListener(DownloadAutoInstallInterceptListener r100) {
        mDownloadAutoInstallInterceptListener = r100;
    }

    public static void setDownloadBpeaCertFactory(DownloadBpeaCertFactory r100) {
        sDownloadBpeaCertFactory = r100;
    }

    public static void setDownloadBusinessInterceptor(DownloadBusinessInterceptor r100) {
        sDownloadBusinessInterceptor = r100;
    }

    public static void setDownloadCertManager(IDownloadCertManager r100) {
        sDownloadCertManager = r100;
        if (r100 == null) goto L6;
        AppDownloader.getInstance().setAppDownloadInterceptor(new AnonymousClass5());
        return;
    }

    public static void setDownloadCheckerFactory(IAdDownloadCheckerProvider r100) {
        sAdDownloadCheckerProvider = r100;
    }

    public static void setDownloadClearSpaceListener(DownloadClearSpaceListener r100) {
        sDownloadClearSpaceListener = r100;
    }

    public static void setDownloadComplianceDialogCallback(DownloadComplianceDialogCallback r100) {
        sDownloadComplianceDialogCallback = r100;
    }

    public static void setDownloadCustomChecker(IDownloadCustomChecker r100) {
        sDownloadCustomChecker = r100;
    }

    public static void setDownloadEventInterceptFactory(DownloadEventInterceptFactory r100) {
        sDownloadEventInterceptFactory = r100;
    }

    public static void setDownloadEventLogger(DownloadEventLogger r100) {
        sDownloadEventLogger = r100;
    }

    public static void setDownloadEventModelFactory(DownloadEventModelFactory r100) {
        sDownloadEventModelFactory = r100;
    }

    public static void setDownloadLoggerListener(DownloadLoggerListener r100) {
        sDownloadLoggerListener = r100;
    }

    public static void setDownloadNetworkFactory(DownloadNetworkFactory r100) {
        sDownloadNetworkFactory = r100;
    }

    public static void setDownloadPermissionChecker(DownloadPermissionChecker r100) {
        sDownloadPermissionChecker = r100;
    }

    public static void setDownloadProgressHandleFactory(DownloadProgressHandleFactory r100) {
        sDownloadProgressHandleFactory = r100;
    }

    public static void setDownloadPushFactory(DownloadPushFactory r100) {
        sDownloadPushFactory = r100;
    }

    public static void setDownloadReverseExperimentValue(JSONObject r100) {
        sDownloadReverseExperimentValue = r100;
    }

    public static void setDownloadSettings(DownloadSettings r100) {
        sDownloadSettings = r100;
    }

    public static void setDownloadTLogger(DownloadTLogger r100) {
        sDownloadTLogger = r100;
    }

    public static void setDownloadTaskQueueHandleFactory(DownloadTaskQueueHandleFactory r100) {
        sDownloadTaskQueueHandleFactory = r100;
    }

    public static void setDownloadUIFactory(DownloadUIFactory r100) {
        sDownloadUIFactory = r100;
    }

    public static void setDownloadUserEventLogger(DownloadUserEventLogger r100) {
        sDownloadUserEventLogger = r100;
    }

    public static void setDownloaderMonitor(IDownloaderMonitor r100) {
        sDownloaderMonitor = r100;
    }

    public static void setEncryptor(IEncryptor r100) {
        sEncryptor = r100;
    }

    public static void setFileProviderAuthority(String r100) {
        AppDownloader.getInstance().setFileProviderAuthority(r100);
    }

    public static void setLogLevel(int r100) {
        Logger.setLogLevel(r100);
    }

    public static void setMonitorListener(IAppDownloadMonitorListener r100) {
        sMonitorListener = r100;
    }

    public static void setPackageChannelChecker(IPackageChannelChecker r100) {
        sPackageChannelChecker = r100;
    }

    public static void setTTDownloaderMonitor(ITTDownloaderMonitor r100) {
        sTTDownloaderMonitor = r100;
    }
}
