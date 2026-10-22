package com.ss.android.download.api;

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
import com.ss.android.download.api.config.IDownloaderMonitor;
import com.ss.android.download.api.config.IEncryptor;
import com.ss.android.download.api.config.IPackageChannelChecker;
import com.ss.android.download.api.guide.IInstallGuideViewListener;
import com.ss.android.download.api.model.AppInfo;
import com.ss.android.download.api.runtime.IAdDownloadActionProvider;
import com.ss.android.download.api.runtime.IAdDownloadCheckerProvider;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadFileUriProvider;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadConfigure {
    void configEnd();

    DownloadConfigure initDownloader(DownloaderBuilder r100);

    DownloadConfigure setApkUpdateHandler(IApkUpdateHandler r100);

    DownloadConfigure setAppDownloadFileUriProvider(IAppDownloadFileUriProvider r100);

    DownloadConfigure setAppInfo(AppInfo r100);

    DownloadConfigure setAppStatusChangeListener(AppStatusChangeListener r100);

    DownloadConfigure setCleanManager(ICleanManager r100);

    DownloadConfigure setDownloadActionFactory(IAdDownloadActionProvider r100);

    DownloadConfigure setDownloadAutoInstallInterceptListener(DownloadAutoInstallInterceptListener r100);

    DownloadConfigure setDownloadBpeaCertFactory(DownloadBpeaCertFactory r100);

    DownloadConfigure setDownloadBusinessInterceptor(DownloadBusinessInterceptor r100);

    DownloadConfigure setDownloadCertManager(IDownloadCertManager r100);

    DownloadConfigure setDownloadCheckerFactory(IAdDownloadCheckerProvider r100);

    DownloadConfigure setDownloadClearSpaceListener(DownloadClearSpaceListener r100);

    DownloadConfigure setDownloadComplianceDialogCallback(DownloadComplianceDialogCallback r100);

    DownloadConfigure setDownloadEventInterceptFactory(DownloadEventInterceptFactory r100);

    DownloadConfigure setDownloadEventModelFactory(DownloadEventModelFactory r100);

    DownloadConfigure setDownloadLoggerListener(DownloadLoggerListener r100);

    DownloadConfigure setDownloadMonitorListener(IAppDownloadMonitorListener r100);

    DownloadConfigure setDownloadNetworkFactory(DownloadNetworkFactory r100);

    DownloadConfigure setDownloadPermissionChecker(DownloadPermissionChecker r100);

    DownloadConfigure setDownloadProgressHandleFactory(DownloadProgressHandleFactory r100);

    DownloadConfigure setDownloadPushFactory(DownloadPushFactory r100);

    DownloadConfigure setDownloadSettings(DownloadSettings r100);

    DownloadConfigure setDownloadTLogger(DownloadTLogger r100);

    DownloadConfigure setDownloadTaskQueueHandleFactory(DownloadTaskQueueHandleFactory r100);

    DownloadConfigure setDownloadUIFactory(DownloadUIFactory r100);

    DownloadConfigure setDownloadUserEventLogger(DownloadUserEventLogger r100);

    DownloadConfigure setDownloaderMonitor(IDownloaderMonitor r100);

    DownloadConfigure setEncryptor(IEncryptor r100);

    DownloadConfigure setEventLogger(DownloadEventLogger r100);

    DownloadConfigure setFileProviderAuthority(String r100);

    DownloadConfigure setInstallGuideViewListener(IInstallGuideViewListener r100);

    DownloadConfigure setLogLevel(int r100);

    DownloadConfigure setPackageChannelChecker(IPackageChannelChecker r100);

    DownloadConfigure setUseReflectParseRes(boolean r100);
}
