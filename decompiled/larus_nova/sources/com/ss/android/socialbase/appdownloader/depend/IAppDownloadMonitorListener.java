package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public interface IAppDownloadMonitorListener {
    void onAppDownloadMonitorSend(DownloadInfo r100, BaseException r101, int r102);
}
