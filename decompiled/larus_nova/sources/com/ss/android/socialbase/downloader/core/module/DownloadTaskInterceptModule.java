package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadTaskInterceptModule extends AbsDownloadModule {
    private static final String TAG = "DownloadTaskInterceptModule";

    public DownloadTaskInterceptModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r100) {
        if (r100.mDownloadInfo.isFastDownload() == false) goto L5;
        return null;
    L5:
        if (r100.mDownloadTask.getInterceptor() != null) goto L7;
        return null;
    L7:
        if (r100.mDownloadInfo.isIgnoreInterceptor() == false) goto L10;
        return null;
    L10:
        return super.init(r100);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r100) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L13;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L13:
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        r100.proceed();
        return;
    L6:
        if (this.mDownloadTask.getInterceptor().intercepte() == false) goto L11;
        DownloadCommonParams r101 = this.mCommonParams;     // Catch: Throwable -> L9
        r101.mRunStatus = RunStatus.RUN_STATUS_INTERCEPT;     // Catch: Throwable -> L9
    }
}
