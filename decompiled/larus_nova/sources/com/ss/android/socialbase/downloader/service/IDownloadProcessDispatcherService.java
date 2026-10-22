package com.ss.android.socialbase.downloader.service;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IDownloaderProcessConnectedListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadProcessDispatcherService {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadProcessDispatcherService implements IDownloadProcessDispatcherService {
        public DefaultDownloadProcessDispatcherService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r103) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r103, boolean r104) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void addNotificationListener(int r100, IDownloadListener r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean canResume(int r100) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void cancel(int r100, boolean r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void clearDownloadData(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void clearDownloadData(int r100, boolean r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getAllDownloadInfo() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public long getCurBytes(int r100) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public IDownloadFileUriProvider getDownloadFileUriProvider(int r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public int getDownloadId(String r100, String r101) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public DownloadInfo getDownloadInfo(int r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public DownloadInfo getDownloadInfo(String r100, String r101) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfoList(String r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosByFileExtension(String r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadInfosBySavePath(String r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public IDownloadNotificationEventListener getDownloadNotificationEventListener(int r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public INotificationClickCallback getNotificationClickCallback(int r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public int getStatus(int r100) {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100) {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloadCacheSyncSuccess() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isDownloading(int r100) {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public boolean isHttpServiceInit() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void pause(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void pauseAll() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r103) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeNotificationListener(int r100, IDownloadListener r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeSubThreadListener(int r100, IDownloadListener r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeTaskNotificationListener(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void removeTaskSubListener(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restart(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restartAllFailedDownloadTasks(List<String> r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void resume(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventListener r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setLogLevel(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setNotificationListener(int r100, IDownloadListener r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void setThrottleNetSpeed(int r100, long r101, int r102) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void tryDownload(DownloadTask r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService
        public void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100) {
        }
    }

    void addDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r103);

    void addDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r103, boolean r104);

    void addNotificationListener(int r100, IDownloadListener r101);

    boolean canResume(int r100);

    void cancel(int r100, boolean r101);

    void clearDownloadData(int r100);

    void clearDownloadData(int r100, boolean r101);

    List<DownloadInfo> getAllDownloadInfo();

    long getCurBytes(int r100);

    IDownloadFileUriProvider getDownloadFileUriProvider(int r100);

    int getDownloadId(String r100, String r101);

    DownloadInfo getDownloadInfo(int r100);

    DownloadInfo getDownloadInfo(String r100, String r101);

    List<DownloadInfo> getDownloadInfoList(String r100);

    List<DownloadInfo> getDownloadInfosByFileExtension(String r100);

    List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101);

    List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100);

    List<DownloadInfo> getDownloadInfosBySavePath(String r100);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int r100);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100);

    Map<String, Pair<Integer, Long>> getInstalledTimeStampBySavePath(String r100);

    INotificationClickCallback getNotificationClickCallback(int r100);

    int getStatus(int r100);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100);

    boolean isDownloadCacheSyncSuccess();

    boolean isDownloadSuccessAndFileNotExist(DownloadInfo r100);

    boolean isDownloading(int r100);

    boolean isHttpServiceInit();

    void pause(int r100);

    void pauseAll();

    void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100);

    void registerDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100);

    void removeDownloadListener(int r100, IDownloadListener r101, ListenerType r102, boolean r103);

    void removeNotificationListener(int r100, IDownloadListener r101);

    void removeSubThreadListener(int r100, IDownloadListener r101);

    void removeTaskNotificationListener(int r100);

    void removeTaskSubListener(int r100);

    void restart(int r100);

    void restartAllFailedDownloadTasks(List<String> r100);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100);

    void resume(int r100);

    void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventListener r101);

    void setLogLevel(int r100);

    void setNotificationListener(int r100, IDownloadListener r101);

    void setThrottleNetSpeed(int r100, long r101, int r102);

    void tryDownload(DownloadTask r100);

    void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener r100);

    void unRegisterDownloaderProcessConnectedListener(IDownloaderProcessConnectedListener r100);
}
