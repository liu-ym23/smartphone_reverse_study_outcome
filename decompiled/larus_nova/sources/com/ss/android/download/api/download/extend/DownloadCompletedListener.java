package com.ss.android.download.api.download.extend;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadCompletedListener {
    void onCanceled(DownloadInfo r100);

    void onDownloadFailed(DownloadInfo r100, BaseException r101, String r102);

    void onDownloadFinished(DownloadInfo r100, String r101);

    void onDownloadStart(DownloadModel r100, DownloadController r101, DownloadEventConfig r102);

    void onInstalled(DownloadInfo r100, String r101);
}
