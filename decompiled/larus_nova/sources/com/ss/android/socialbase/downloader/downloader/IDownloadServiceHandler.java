package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.DownloadService;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadServiceHandler<T extends DownloadService> {
    boolean isServiceAlive();

    IBinder onBind(Intent r100);

    void onDestroy();

    void onStartCommand(Intent r100, int r101, int r102);

    void onStartCommandOnMainThread();

    void pendDownloadTask(DownloadTask r100);

    void setDownloadService(WeakReference<T> r100);

    void setLogLevel(int r100);

    void setServiceConnectionListener(IDownloadServiceConnectionListener r100);

    void startService();

    void tryDownload(DownloadTask r100);

    void tryDownloadWithEngine(DownloadTask r100);
}
