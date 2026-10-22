package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadTaskExecuteListener {
    void onFinish(DownloadTask r100, int r101);

    void onStart(DownloadTask r100, int r101);
}
