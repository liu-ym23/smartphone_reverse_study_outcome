package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorTeaListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IMainThreadMonitor;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadComponentManagerService {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadComponentManagerService implements IDownloadComponentManagerService {
        public DefaultDownloadComponentManagerService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public long clearAllDownloadCache(boolean r100, Set<String> r101) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void clearDBSuccessedDownloadInfo(String r100, String r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void clearDirectory(IDirectoryCleanerListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void clearMemoryCacheData(double r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void coverComponent(DownloaderBuilder r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void enableLruCache() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public Context getAppContext() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public IDownloadInterceptor getDownloadInterceptor() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public IReserveWifiStatusListener getReserveWifiStatusListener() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void initComponent(DownloaderBuilder r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void initDownloadCacheImmediately() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public boolean isInit() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void pauseAllEnqueueTask(List<String> r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void resetSleepDownloadingTaskState() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void resumeAllEnqueueTask() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setAppContext(Context r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setAppInfo(String r100, String r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadDBListener(IDownloadDBListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadInMultiProcess() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadMemoryListener(IMemoryListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadMonitorListener(IDownloadMonitorListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadNetworkHandler(IDownloadNetworkHandler r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadStatusListener(IDownloadStatusListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadThreadCheckListener(IDownloadThreadCheckListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setMainThreadMonitor(IMainThreadMonitor r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setNotificationClickCallback(INotificationClickCallback r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setReserveWifiStatusListener(IReserveWifiStatusListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void sleepDownloadingTask() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void startThrottle(String[] r100, long r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void stopThrottle(String[] r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitIOTask(Runnable r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitScheduleTask(Runnable r100, long r101, TimeUnit r102) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitSingleTask(Runnable r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void unRegisterDownloadReceiver() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void updateDownloadInfo(DownloadInfo r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void updateDownloadSpInfo() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public ITTNetHandler getTTNetHandler() {
            return new ITTNetHandler.DefaultTTNetHandler();
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public JSONObject getDownloadSetting() {
            return DownloadConstants.EMPTY_JSON;
        }
    }

    long clearAllDownloadCache(boolean r100, Set<String> r101);

    void clearDBSuccessedDownloadInfo(String r100, String r101);

    void clearDirectory(IDirectoryCleanerListener r100);

    void clearMemoryCacheData(double r100);

    void coverComponent(DownloaderBuilder r100);

    void enableLruCache();

    Context getAppContext();

    IDownloadInterceptor getDownloadInterceptor();

    JSONObject getDownloadSetting();

    IReserveWifiStatusListener getReserveWifiStatusListener();

    ITTNetHandler getTTNetHandler();

    void initComponent(DownloaderBuilder r100);

    void initDownloadCacheImmediately();

    boolean isInit();

    void pauseAllEnqueueTask(List<String> r100);

    void resetSleepDownloadingTaskState();

    void resumeAllEnqueueTask();

    void setAppContext(Context r100);

    void setAppInfo(String r100, String r101);

    void setDownloadDBListener(IDownloadDBListener r100);

    void setDownloadInMultiProcess();

    void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener r100);

    void setDownloadMemoryListener(IMemoryListener r100);

    void setDownloadMonitorListener(IDownloadMonitorListener r100);

    void setDownloadMonitorTeaListener(IDownloadMonitorTeaListener r100);

    void setDownloadNetworkHandler(IDownloadNetworkHandler r100);

    void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r100);

    void setDownloadStatusListener(IDownloadStatusListener r100);

    void setDownloadThreadCheckListener(IDownloadThreadCheckListener r100);

    void setMainThreadMonitor(IMainThreadMonitor r100);

    void setNotificationClickCallback(INotificationClickCallback r100);

    void setReserveWifiStatusListener(IReserveWifiStatusListener r100);

    void sleepDownloadingTask();

    void startThrottle(String[] r100, long r101);

    void stopThrottle(String[] r100);

    void submitIOTask(Runnable r100);

    void submitScheduleTask(Runnable r100, long r101, TimeUnit r102);

    void submitSingleTask(Runnable r100);

    void unRegisterDownloadReceiver();

    void updateDownloadInfo(DownloadInfo r100);

    void updateDownloadSpInfo();
}
