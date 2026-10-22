package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadStartModule extends AbsDownloadModule {
    public DownloadStartModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r100) throws BaseException {
        this.mDownloadInfo.updateStartDownloadTime();
        this.mDownloadInfo.resetRealStartDownloadTime();
        this.mDownloadInfo.setCacheExistsInDownloading(false);
        this.mStatusHandler.onStart();
        r100.proceed();
    }
}
