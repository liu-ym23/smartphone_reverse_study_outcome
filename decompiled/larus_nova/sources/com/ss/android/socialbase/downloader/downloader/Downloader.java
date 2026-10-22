package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.util.Log;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorTeaListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.IMainThreadMonitor;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class Downloader extends BaseDownloader {
    private static final String TAG = "Downloader";
    private static volatile Downloader instance;
    private static volatile boolean mSetContext;

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getAllDownloadInfo() {
        return super.getAllDownloadInfo();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveDir() {
        return super.getGlobalSaveDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ File getGlobalSaveTempDir() {
        return super.getGlobalSaveTempDir();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IReserveWifiStatusListener getReserveWifiStatusListener() {
        return super.getReserveWifiStatusListener();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadCacheSyncSuccess() {
        return super.isDownloadCacheSyncSuccess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isHttpServiceInit() {
        return super.isHttpServiceInit();
    }

    private Downloader() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void destoryDownloader() {
        super.destoryDownloader();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void enableLruCache() {
        super.enableLruCache();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void initDownloadCacheImmediately() {
        super.initDownloadCacheImmediately();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pauseAll() {
        super.pauseAll();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resetSleepDownloadingTaskState() {
        super.resetSleepDownloadingTaskState();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resumeAllEnqueueTask() {
        super.resumeAllEnqueueTask();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadInMultiProcess() {
        super.setDownloadInMultiProcess();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void sleepDownloadingTask() {
        super.sleepDownloadingTask();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadSpInfo() {
        super.updateDownloadSpInfo();
    }

    public Downloader(DownloaderBuilder r100) {
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).initComponent(r100);
    }

    private static void checkContext(Context r100) {
        if (mSetContext == false) goto L6;
        return;
    L6:
        monitor-enter(Downloader.class);
    L21:
        th = move-exception;
        throw th;
    L8:
        if (mSetContext == false) goto L26;
        monitor-exit(Downloader.class);     // Catch: Throwable -> L21
        return;
    L26:
        if (r100 == null) goto L14;
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).setAppContext(r100.getApplicationContext());     // Catch: Throwable -> L17
        mSetContext = true;     // Catch: Throwable -> L17
    L25:
    L19:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L21
        return;
    L14:
        if (Logger.debug() == false) goto L25;
        Logger.globalDebug(TAG, "checkContext", "Context is null " + Log.getStackTraceString(new Throwable("context_empty")));     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L21
        Logger.globalError(TAG, "checkContext", "Error:" + th);     // Catch: Throwable -> L21
        goto L19
    }

    public static Downloader getInstance(Context r100) {
        if (instance == null) goto L5;
    L14:
        checkContext(r100);
        return instance;
    L5:
        monitor-enter(Downloader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).setAppContext(r100);     // Catch: Throwable -> L11
        instance = new Downloader();     // Catch: Throwable -> L11
    L9:
        monitor-exit(Downloader.class);     // Catch: Throwable -> L11
        goto L14
    }

    public static void init(DownloaderBuilder r100) {
        initOrCover(r100, false);
    }

    public static void loadService(IDownloadServiceLoader r100) {
        DownloadServiceManager.loadService(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean canResume(int r100) {
        return super.canResume(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int r100) {
        super.cancel(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long clearAllDownloadCache(boolean r100) {
        return super.clearAllDownloadCache(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDirectory(IDirectoryCleanerListener r100) {
        super.clearDirectory(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int r100) {
        super.clearDownloadData(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearMemoryCacheData(double r100) {
        super.clearMemoryCacheData(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long getCurBytes(int r100) {
        return super.getCurBytes(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadFileUriProvider getDownloadFileUriProvider(int r100) {
        return super.getDownloadFileUriProvider(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(int r100) {
        return super.getDownloadInfo(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfoList(String r100) {
        return super.getDownloadInfoList(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosByFileExtension(String r100) {
        return super.getDownloadInfosByFileExtension(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosByMonitorScene(List r100) {
        return super.getDownloadInfosByMonitorScene(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadInfosBySavePath(String r100) {
        return super.getDownloadInfosBySavePath(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ IDownloadNotificationEventListener getDownloadNotificationEventListener(int r100) {
        return super.getDownloadNotificationEventListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getDownloadingDownloadInfosWithMimeType(String r100) {
        return super.getDownloadingDownloadInfosWithMimeType(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ Map getInstalledTimeStampBySavePath(String r100) {
        return super.getInstalledTimeStampBySavePath(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getStatus(int r100) {
        return super.getStatus(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getSuccessedDownloadInfosWithMimeType(String r100) {
        return super.getSuccessedDownloadInfosWithMimeType(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ List getUnCompletedDownloadInfosWithMimeType(String r100) {
        return super.getUnCompletedDownloadInfosWithMimeType(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100) {
        return super.isDownloadSuccessAndFileNotExist(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ boolean isDownloading(int r100) {
        return super.isDownloading(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pause(int r100) {
        super.pause(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void pauseAllEnqueueTask(List r100) {
        super.pauseAllEnqueueTask(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        super.registerDownloadCacheSyncListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100) {
        super.registerDownloaderProcessConnectedListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeTaskMainListener(int r100) {
        super.removeTaskMainListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeTaskNotificationListener(int r100) {
        super.removeTaskNotificationListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeTaskSubListener(int r100) {
        super.removeTaskSubListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restart(int r100) {
        super.restart(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restartAllFailedDownloadTasks(List r100) {
        super.restartAllFailedDownloadTasks(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void restartAllPauseReserveOnWifiDownloadTasks(List r100) {
        super.restartAllPauseReserveOnWifiDownloadTasks(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void resume(int r100) {
        super.resume(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSavePath(String r100) {
        super.setDefaultSavePath(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDefaultSaveTempPath(String r100) {
        super.setDefaultSaveTempPath(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadDBListener(IDownloadDBListener r100) {
        super.setDownloadDBListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r100) {
        super.setDownloadMemoryInfoListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMemoryListener(IMemoryListener r100) {
        super.setDownloadMemoryListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMonitorListener(IDownloadMonitorListener r100) {
        super.setDownloadMonitorListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r100) {
        super.setDownloadMonitorTeaListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadNetworkHandler(IDownloadNetworkHandler r100) {
        super.setDownloadNetworkHandler(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r100) {
        super.setDownloadPluginDegradeListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadStatusListener(IDownloadStatusListener r100) {
        super.setDownloadStatusListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadThreadCheckListener(IDownloadThreadCheckListener r100) {
        super.setDownloadThreadCheckListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setLogLevel(int r100) {
        super.setLogLevel(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setMainThreadMonitor(IMainThreadMonitor r100) {
        super.setMainThreadMonitor(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setNotificationClickCallback(INotificationClickCallback r100) {
        super.setNotificationClickCallback(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setReserveWifiStatusListener(IReserveWifiStatusListener r100) {
        super.setReserveWifiStatusListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void stopThrottle(String[] r100) {
        super.stopThrottle(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        super.unRegisterDownloadCacheSyncListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100) {
        super.unRegisterDownloaderProcessConnectedListener(r100);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void updateDownloadInfo(DownloadInfo r100) {
        super.updateDownloadInfo(r100);
    }

    public static synchronized void initOrCover(DownloaderBuilder r100, boolean r101) {
        monitor-enter(Downloader.class);
        if (r100 != null) goto L22;
        monitor-exit(Downloader.class);
        return;
    L22:
    L19:
        th = move-exception;
        throw th;
    L8:
        if (instance != null) goto L12;
        instance = r100.build();     // Catch: Throwable -> L19
        monitor-exit(Downloader.class);
        return;
    L12:
        IDownloadComponentManagerService r102 = (IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class);     // Catch: Throwable -> L19
        if (r102.isInit() == true) goto L15;
        r102.initComponent(r100);     // Catch: Throwable -> L19
    L17:
        monitor-exit(Downloader.class);
        return;
    L15:
        if (r101 == false) goto L17;
        r102.coverComponent(r100);     // Catch: Throwable -> L19
        goto L17
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addMainThreadListener(int r100, IDownloadListener r101) {
        super.addMainThreadListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addNotificationListener(int r100, IDownloadListener r101) {
        super.addNotificationListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void addSubThreadListener(int r100, IDownloadListener r101) {
        super.addSubThreadListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void cancel(int r100, boolean r101) {
        super.cancel(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ long clearAllDownloadCache(boolean r100, Set r101) {
        return super.clearAllDownloadCache(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDBSuccessedDownloadInfo(String r100, String r101) {
        super.clearDBSuccessedDownloadInfo(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void clearDownloadData(int r100, boolean r101) {
        super.clearDownloadData(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ int getDownloadId(String r100, String r101) {
        return super.getDownloadId(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ DownloadInfo getDownloadInfo(String r100, String r101) {
        return super.getDownloadInfo(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeMainThreadListener(int r100, IDownloadListener r101) {
        super.removeMainThreadListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeNotificationListener(int r100, IDownloadListener r101) {
        super.removeNotificationListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void removeSubThreadListener(int r100, IDownloadListener r101) {
        super.removeSubThreadListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventListener r101) {
        super.setDownloadNotificationEventListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setMainThreadListener(int r100, IDownloadListener r101) {
        super.setMainThreadListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setNotificationListener(int r100, IDownloadListener r101) {
        super.setNotificationListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setSubThreadListener(int r100, IDownloadListener r101) {
        super.setSubThreadListener(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int r100, long r101) {
        super.setThrottleNetSpeed(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void startThrottle(String[] r100, long r101) {
        super.startThrottle(r100, r101);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setMainThreadListener(int r100, IDownloadListener r101, boolean r102) {
        super.setMainThreadListener(r100, r101, r102);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.BaseDownloader
    public /* bridge */ /* synthetic */ void setThrottleNetSpeed(int r100, long r101, int r102) {
        super.setThrottleNetSpeed(r100, r101, r102);
    }
}
