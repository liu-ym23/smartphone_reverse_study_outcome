package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadCache {
    DownloadInfo OnDownloadTaskCancel(int r100, long r101);

    DownloadInfo OnDownloadTaskCompleted(int r100, long r101);

    DownloadInfo OnDownloadTaskConnected(int r100, long r101, String r102, String r103);

    DownloadInfo OnDownloadTaskError(int r100, long r101);

    DownloadInfo OnDownloadTaskIntercept(int r100);

    DownloadInfo OnDownloadTaskPause(int r100, long r101);

    DownloadInfo OnDownloadTaskPrepare(int r100);

    DownloadInfo OnDownloadTaskProgress(int r100, long r101);

    DownloadInfo OnDownloadTaskRetry(int r100);

    boolean cacheExist(int r100);

    void clearData();

    void clearMemoryCacheData(double r100);

    boolean ensureDownloadCacheSyncSuccess();

    List<DownloadInfo> getAllDownloadInfo();

    DownloadInfo getDownloadInfo(int r100);

    List<DownloadInfo> getDownloadInfoList(String r100);

    List<DownloadInfo> getDownloadInfosByFileExtension(String r100);

    List<DownloadInfo> getDownloadInfosByFilters(String r100, String r101);

    List<DownloadInfo> getDownloadInfosByMonitorScene(List<String> r100);

    Map<Long, Segment> getSegmentMap(int r100);

    List<Segment> getSegments(int r100);

    List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String r100);

    List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String r100);

    void init(boolean r100);

    void initImmediately();

    boolean isDownloadCacheSyncSuccess();

    DownloadInfo onDownloadTaskStart(int r100);

    boolean removeDownloadInfo(int r100);

    boolean removeDownloadTaskData(int r100);

    void removeSegments(int r100);

    void syncDownloadInfo(DownloadInfo r100);

    void syncDownloadInfoFromOtherCache(int r100);

    boolean updateDownloadInfo(DownloadInfo r100);

    boolean updateSegments(int r100, Map<Long, Segment> r101);
}
