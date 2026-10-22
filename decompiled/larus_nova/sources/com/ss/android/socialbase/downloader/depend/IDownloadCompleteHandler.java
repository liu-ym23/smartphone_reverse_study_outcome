package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadCompleteHandler {
    void handle(DownloadInfo r100) throws BaseException;

    boolean needHandle(DownloadInfo r100);
}
