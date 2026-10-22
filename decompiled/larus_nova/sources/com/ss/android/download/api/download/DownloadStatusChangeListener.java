package com.ss.android.download.api.download;

import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadStatusChangeListener {
    void onDownloadActive(DownloadShortInfo r100, int r101);

    void onDownloadFailed(DownloadShortInfo r100);

    void onDownloadFinished(DownloadShortInfo r100);

    void onDownloadPaused(DownloadShortInfo r100, int r101);

    void onDownloadStart(DownloadModel r100, DownloadController r101);

    void onIdle();

    void onInstalled(DownloadShortInfo r100);
}
