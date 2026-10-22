package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public interface INotificationClickCallback {
    boolean onClickWhenInstalled(DownloadInfo r100);

    boolean onClickWhenSuccess(DownloadInfo r100);

    boolean onClickWhenUnSuccess(DownloadInfo r100);
}
