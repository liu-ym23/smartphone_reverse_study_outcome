package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.core.DownloadRunnable;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadEngine {
    void addDownloadListener(int r100, int r101, IDownloadListener r102, ListenerType r103, boolean r104);

    void addDownloadListener(int r100, int r101, IDownloadListener r102, ListenerType r103, boolean r104, boolean r105);

    boolean cancel(int r100, boolean r101);

    void clearDownloadData(int r100, boolean r101, boolean r102);

    Future doDownload(DownloadTask r100);

    void doPause(int r100, boolean r101);

    IDownloadFileUriProvider getDownloadFileUriProvider(int r100);

    DownloadInfo getDownloadInfo(int r100);

    List<DownloadInfo> getDownloadInfoList(String r100);

    IDownloadNotificationEventListener getDownloadNotificationEventListener(int r100);

    DownloadTask getDownloadTask(int r100, int r101);

    List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String r100);

    INotificationClickCallback getNotificationClickCallback(int r100);

    boolean isDownloading(int r100);

    boolean isInDownloadTaskPool(int r100);

    boolean pause(int r100);

    void refreshDownloadTaskMap(int r100, int r101, int r102);

    void removeDownloadListener(int r100, int r101, IDownloadListener r102, ListenerType r103, boolean r104);

    void removeDownloadRunnable(DownloadRunnable r100);

    void resetDownloadData(int r100, boolean r101);

    boolean restart(int r100);

    void restartAllFailedDownloadTasks(List<String> r100);

    void restartAllPauseReserveOnWifiDownloadTasks(List<String> r100);

    boolean restartAsyncWaitingTask(int r100);

    boolean resume(int r100);

    void setDownloadNotificationEventListener(int r100, IDownloadNotificationEventListener r101);

    void setThrottleNetSpeed(int r100, long r101, int r102);

    void shutDown();

    void tryDownload(DownloadTask r100);
}
