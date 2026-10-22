package com.ss.android.download.api.config;

import com.ss.android.download.api.download.DownloadModel;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadPushFactory {
    boolean pushMarketDownloadRetainMessage(DownloadModel r100);

    boolean pushNonSubjectiveUnInstalledMessage(DownloadModel r100);

    boolean pushNonSubjectiveUnfinishedMessage(DownloadModel r100);

    boolean pushOrderDownloadRetainMessage(DownloadModel r100, int r101);

    boolean pushUnInstalledMessage(DownloadModel r100);

    boolean pushUnfinishedMessage(DownloadModel r100);
}
