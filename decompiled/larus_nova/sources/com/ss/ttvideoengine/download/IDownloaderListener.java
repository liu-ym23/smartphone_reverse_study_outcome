package com.ss.ttvideoengine.download;

import com.ss.ttvideoengine.utils.Error;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public interface IDownloaderListener {

    /* JADX INFO: renamed from: com.ss.ttvideoengine.download.IDownloaderListener$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$downloaderProgress(IDownloaderListener r100, Downloader r101, DownloadTask r102, long r103, long r104) {
        }
    }

    void downloaderDidComplete(Downloader r100, DownloadTask r101, Error r102);

    void downloaderDidLoadAllTask(Downloader r100, List<DownloadTask> r101, Error r102);

    void downloaderDidResume(Downloader r100, DownloadTask r101, long r102, long r103);

    void downloaderProgress(Downloader r100, DownloadTask r101, long r102, long r103);

    void downloaderStateChanged(Downloader r100, DownloadTask r101, int r102);

    void downloaderWriteData(Downloader r100, DownloadTask r101, long r102, long r103);
}
