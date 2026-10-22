package com.ss.android.socialbase.appdownloader.service;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;

/* JADX INFO: loaded from: classes38.dex */
public class AppDownloadServiceManager extends DownloadServiceManager {
    private static final String APPDOWNLOAD_SERVICE_LOADER = "com.ss.android.socialbase.appdownloader.service.AppDownloadServiceLoader";
    private static final String TAG = null;
    private static volatile boolean isLoadService;

    public static void setServiceLoaded() {
        isLoadService = true;
    }

    static {
        TAG = "AppDownloadServiceManager";
        isLoadService = false;
    }

    public AppDownloadServiceManager() {
    }

    public static <T> T getService(Class<T> r100) {
        if (isLoadService == true) goto L6;
        loadDefaultService(APPDOWNLOAD_SERVICE_LOADER);
    L6:
        return (T) DownloadServiceManager.getService(r100);
    }

    private static void loadDefaultService(String r100) {
        monitor-enter(DownloadServiceManager.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (isLoadService == false) goto L9;
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
        return;
    L9:
        if (DownloadServiceManager.runLoad(r100) == false) goto L13;
        isLoadService = true;     // Catch: Throwable -> L16
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
        return;
    L13:
        DownloadServiceManager.registerService(IDownloadAhUtilsService.class, new IDownloadAhUtilsService.DefaultDownloadAhUtilsService());     // Catch: Throwable -> L16
        DownloadServiceManager.registerService(IDownloadHandlerService.class, new IDownloadHandlerService.DefaultIDownloadHandlerService());     // Catch: Throwable -> L16
        DownloadServiceManager.registerService(IDownloadPackageInfoUtilsService.class, new IDownloadPackageInfoUtilsService.DefaultDownloadPackageInfoUtilsService());     // Catch: Throwable -> L16
        DownloadServiceManager.registerService(IDownloadReceiverService.class, new IDownloadReceiverService.DefaultDownloadReceiverService());     // Catch: Throwable -> L16
        DownloadServiceManager.registerService(IDownloadRetryJobSchedulerService.class, new IDownloadRetryJobSchedulerService.DefaultDownloadRetryJobSchedulerService());     // Catch: Throwable -> L16
        DownloadServiceManager.registerService(IDownloadAppInstallService.class, new IDownloadAppInstallService.DefaultDownloadAppInstallService());     // Catch: Throwable -> L16
        Logger.globalError(TAG, "loadDefaultService", "Register default appdownload service");     // Catch: Throwable -> L16
        isLoadService = true;     // Catch: Throwable -> L16
        monitor-exit(DownloadServiceManager.class);     // Catch: Throwable -> L16
    }
}
