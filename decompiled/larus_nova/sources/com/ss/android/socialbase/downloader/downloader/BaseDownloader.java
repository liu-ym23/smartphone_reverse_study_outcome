package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.ListenerType;
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
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
class BaseDownloader {
    private static IDownloadGlobalThrottleService globalThrottleService;
    private IDownloadComponentManagerService componentService;
    private IDownloadProcessDispatcherService dispatcherService;
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    static {
        globalThrottleService = (IDownloadGlobalThrottleService) DownloadServiceManager.getService(IDownloadGlobalThrottleService.class);
    }

    public void destoryDownloader() {
        this.componentService.unRegisterDownloadReceiver();
    }

    public void enableLruCache() {
        this.componentService.enableLruCache();
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return this.dispatcherService.getAllDownloadInfo();
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath);
    }

    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return this.componentService.getReserveWifiStatusListener();
    }

    public void initDownloadCacheImmediately() {
        this.componentService.initDownloadCacheImmediately();
    }

    public boolean isDownloadCacheSyncSuccess() {
        return this.dispatcherService.isDownloadCacheSyncSuccess();
    }

    public boolean isHttpServiceInit() {
        return this.dispatcherService.isHttpServiceInit();
    }

    public void pauseAll() {
        this.dispatcherService.pauseAll();
    }

    public void resetSleepDownloadingTaskState() {
        this.componentService.resetSleepDownloadingTaskState();
    }

    public void resumeAllEnqueueTask() {
        this.componentService.resumeAllEnqueueTask();
    }

    public void setDownloadInMultiProcess() {
        this.componentService.setDownloadInMultiProcess();
    }

    public void sleepDownloadingTask() {
        this.componentService.sleepDownloadingTask();
    }

    public void updateDownloadSpInfo() {
        this.componentService.updateDownloadSpInfo();
    }

    public BaseDownloader() {
        this.dispatcherService = (IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class);
        this.componentService = (IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class);
    }

    private File getGlobalSaveDir(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (DownloadDirUtils.isValidDirectory(r101) == false) goto L8;
        return r101;
    L8:
        return null;
    }

    public static DownloadTask with(Context r100) {
        Downloader.getInstance(r100);
        return new DownloadTask();
    }

    public boolean canResume(int r100) {
        return this.dispatcherService.canResume(r100);
    }

    public void cancel(int r100) {
        cancel(r100, true);
    }

    public long clearAllDownloadCache(boolean r100) {
        return this.componentService.clearAllDownloadCache(r100, null);
    }

    public void clearDirectory(IDirectoryCleanerListener r100) {
        this.componentService.clearDirectory(r100);
    }

    public void clearDownloadData(int r100) {
        this.dispatcherService.clearDownloadData(r100, true);
    }

    public void clearMemoryCacheData(double r100) {
        this.componentService.clearMemoryCacheData(r100);
    }

    public long getCurBytes(int r100) {
        return this.dispatcherService.getCurBytes(r100);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int r100) {
        return this.dispatcherService.getDownloadFileUriProvider(r100);
    }

    public DownloadInfo getDownloadInfo(int r100) {
        return this.dispatcherService.getDownloadInfo(r100);
    }

    public List<DownloadInfo> getDownloadInfoList(String r100) {
        return this.dispatcherService.getDownloadInfoList(r100);
    }

    public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) {
        return this.dispatcherService.getDownloadInfosByFileExtension(r100);
    }

    public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) {
        return this.dispatcherService.getDownloadInfosByMonitorScene(r100);
    }

    public List<DownloadInfo> getDownloadInfosBySavePath(String r100) {
        return this.dispatcherService.getDownloadInfosBySavePath(r100);
    }

    public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r100) {
        return this.dispatcherService.getDownloadNotificationEventListener(r100);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100) {
        return this.dispatcherService.getDownloadingDownloadInfosWithMimeType(r100);
    }

    public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r100) {
        return this.dispatcherService.getInstalledTimeStampBySavePath(r100);
    }

    public int getStatus(int r100) {
        return this.dispatcherService.getStatus(r100);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) {
        return this.dispatcherService.getSuccessedDownloadInfosWithMimeType(r100);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) {
        return this.dispatcherService.getUnCompletedDownloadInfosWithMimeType(r100);
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100) {
        return this.dispatcherService.isDownloadSuccessAndFileNotExist(r100);
    }

    public boolean isDownloading(int r100) {
        return this.dispatcherService.isDownloading(r100);
    }

    public void pause(int r100) {
        this.dispatcherService.pause(r100);
    }

    public void pauseAllEnqueueTask(List<String> r100) {
        this.componentService.pauseAllEnqueueTask(r100);
    }

    public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        this.dispatcherService.registerDownloadCacheSyncListener(r100);
    }

    public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100) {
        this.dispatcherService.registerDownloaderProcessConnectedListener(r100);
    }

    public void removeTaskMainListener(int r100) {
        this.dispatcherService.removeDownloadListener(r100, null, ListenerType.MAIN, true);
    }

    public void removeTaskNotificationListener(int r100) {
        this.dispatcherService.removeDownloadListener(r100, null, ListenerType.NOTIFICATION, true);
    }

    public void removeTaskSubListener(int r100) {
        this.dispatcherService.removeDownloadListener(r100, null, ListenerType.SUB, true);
    }

    public void restart(int r100) {
        this.dispatcherService.restart(r100);
    }

    public void restartAllFailedDownloadTasks(List<String> r100) {
        this.dispatcherService.restartAllFailedDownloadTasks(r100);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100) {
        this.dispatcherService.restartAllPauseReserveOnWifiDownloadTasks(r100);
    }

    public void resume(int r100) {
        this.dispatcherService.resume(r100);
    }

    public void setDefaultSavePath(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.globalDefaultSavePath = r100;
        return;
    }

    public void setDefaultSaveTempPath(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.globalDefaultSaveTempPath = r100;
        return;
    }

    public void setDownloadDBListener(IDownloadDBListener r100) {
        this.componentService.setDownloadDBListener(r100);
    }

    public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r100) {
        this.componentService.setDownloadMemoryInfoListener(r100);
    }

    public void setDownloadMemoryListener(IMemoryListener r100) {
        this.componentService.setDownloadMemoryListener(r100);
    }

    public void setDownloadMonitorListener(IDownloadMonitorListener r100) {
        this.componentService.setDownloadMonitorListener(r100);
    }

    public void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r100) {
        this.componentService.setDownloadMonitorTeaListener(r100);
    }

    public void setDownloadNetworkHandler(IDownloadNetworkHandler r100) {
        this.componentService.setDownloadNetworkHandler(r100);
    }

    public void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r100) {
        this.componentService.setDownloadPluginDegradeListener(r100);
    }

    public void setDownloadStatusListener(IDownloadStatusListener r100) {
        this.componentService.setDownloadStatusListener(r100);
    }

    public void setDownloadThreadCheckListener(IDownloadThreadCheckListener r100) {
        this.componentService.setDownloadThreadCheckListener(r100);
    }

    public void setLogLevel(int r100) {
        this.dispatcherService.setLogLevel(r100);
    }

    public void setMainThreadMonitor(IMainThreadMonitor r100) {
        this.componentService.setMainThreadMonitor(r100);
    }

    public void setNotificationClickCallback(INotificationClickCallback r100) {
        this.componentService.setNotificationClickCallback(r100);
    }

    public void setReserveWifiStatusListener(IReserveWifiStatusListener r100) {
        this.componentService.setReserveWifiStatusListener(r100);
    }

    public void stopThrottle(String[] r100) {
        this.componentService.stopThrottle(r100);
    }

    public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        this.dispatcherService.unRegisterDownloadCacheSyncListener(r100);
    }

    public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100) {
        this.dispatcherService.unRegisterDownloaderProcessConnectedListener(r100);
    }

    public void updateDownloadInfo(DownloadInfo r100) {
        this.componentService.updateDownloadInfo(r100);
    }

    public static void setGlobalThrottleTaskPriority(int r100, int r101) {
        globalThrottleService.setGlobalThrottleTaskPriority(r100, r101);
    }

    public void addMainThreadListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r100, r101, ListenerType.MAIN, false);
    }

    public void addNotificationListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r100, r101, ListenerType.NOTIFICATION, false);
    }

    public void addSubThreadListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r100, r101, ListenerType.SUB, false);
    }

    public void cancel(int r100, boolean r101) {
        this.dispatcherService.cancel(r100, r101);
    }

    public long clearAllDownloadCache(boolean r100, Set<String> r101) {
        return this.componentService.clearAllDownloadCache(r100, r101);
    }

    public void clearDBSuccessedDownloadInfo(String r100, String r101) {
        this.componentService.clearDBSuccessedDownloadInfo(r100, r101);
    }

    public void clearDownloadData(int r100, boolean r101) {
        this.dispatcherService.clearDownloadData(r100, r101);
    }

    public int getDownloadId(String r100, String r101) {
        return this.dispatcherService.getDownloadId(r100, r101);
    }

    public DownloadInfo getDownloadInfo(String r100, String r101) {
        return this.dispatcherService.getDownloadInfo(r100, r101);
    }

    public void removeMainThreadListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.removeDownloadListener(r100, r101, ListenerType.MAIN, false);
    }

    public void removeNotificationListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.removeDownloadListener(r100, r101, ListenerType.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.removeDownloadListener(r100, r101, ListenerType.SUB, false);
    }

    public void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventListener r101) {
        this.dispatcherService.setDownloadNotificationEventListener(r100, r101);
    }

    public void setMainThreadListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r100, r101, ListenerType.MAIN, true);
    }

    public void setNotificationListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r100, r101, ListenerType.NOTIFICATION, true);
    }

    public void setSubThreadListener(int r100, IDownloadListener r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r100, r101, ListenerType.SUB, true);
    }

    public void setThrottleNetSpeed(int r100, long r101) {
        setThrottleNetSpeed(r100, r101, 0);
    }

    public void startThrottle(String[] r100, long r101) {
        this.componentService.startThrottle(r100, r101);
    }

    public static void setGlobalThrottleSpeed(Context r100, int r101, int r102) {
        globalThrottleService.setGlobalThrottle(r101, r102);
    }

    public void setMainThreadListener(int r100, IDownloadListener r101, boolean r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        this.dispatcherService.addDownloadListener(r100, r101, ListenerType.MAIN, true, r102);
    }

    public void setThrottleNetSpeed(int r100, long r101, int r102) {
        this.dispatcherService.setThrottleNetSpeed(r100, r101, r102);
    }
}
