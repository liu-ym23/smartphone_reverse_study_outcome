package com.ss.android.socialbase.downloader.downloader;

import android.util.Pair;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadProxy {
    void addDownloadListener(int r100, int r101, IDownloadListener r102, ListenerType r103, boolean r104);

    void addDownloadListener(int r100, int r101, IDownloadListener r102, ListenerType r103, boolean r104, boolean r105);

    void addProcessCallback(ProcessCallback r100);

    boolean canResume(int r100);

    void cancel(int r100, boolean r101);

    void clearData();

    void clearDownloadData(int r100, boolean r101, boolean r102);

    void dispatchProcessCallback(int r100, int r101);

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

    int getDownloadWithIndependentProcessStatus(int r100);

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

    boolean isServiceAlive();

    void pause(int r100, boolean r101);

    void pauseAll();

    boolean removeDownloadInfo(int r100);

    void removeDownloadListener(int r100, int r101, IDownloadListener r102, ListenerType r103, boolean r104);

    boolean removeDownloadTaskData(int r100);

    void resetDownloadData(int r100, boolean r101);

    void restart(int r100);

    void restartAllFailedDownloadTasks(List<String> r100);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100);

    void resume(int r100);

    void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventListener r101);

    void setDownloadWithIndependentProcessStatus(int r100, boolean r101);

    void setLogLevel(int r100);

    void setThrottleNetSpeed(int r100, long r101, int r102);

    void startService();

    void syncDownloadInfo(DownloadInfo r100);

    void syncDownloadInfoFromOtherCache(int r100);

    void tryDownload(DownloadTask r100);

    void tryDownloadWithEngine(DownloadTask r100);

    boolean updateDownloadInfo(DownloadInfo r100);
}
