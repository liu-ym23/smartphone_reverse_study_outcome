package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadModule {
    void cancel();

    IDownloadModule init(DownloadCommonParams r100);

    void pause();

    void proceed(IDownloadModuleChain r100) throws BaseException;

    void setThrottleNetSpeed(long r100, int r101);
}
