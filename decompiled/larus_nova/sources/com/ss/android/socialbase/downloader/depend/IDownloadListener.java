package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes.dex */
public interface IDownloadListener {
    void onCanceled(DownloadInfo r100);

    void onFailed(DownloadInfo r100, BaseException r101);

    void onFirstStart(DownloadInfo r100);

    void onFirstSuccess(DownloadInfo r100);

    void onPause(DownloadInfo r100);

    void onPrepare(DownloadInfo r100);

    void onProgress(DownloadInfo r100);

    void onRetry(DownloadInfo r100, BaseException r101);

    void onRetryDelay(DownloadInfo r100, BaseException r101);

    void onStart(DownloadInfo r100);

    void onSuccessed(DownloadInfo r100);
}
