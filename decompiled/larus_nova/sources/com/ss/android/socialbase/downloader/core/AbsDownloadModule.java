package com.ss.android.socialbase.downloader.core;

import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsDownloadModule implements IDownloadModule {
    protected DownloadCommonParams mCommonParams;
    protected IDownloadCache mDownloadCache;
    protected DownloadInfo mDownloadInfo;
    protected DownloadTask mDownloadTask;
    protected DownloadSetting mSetting;
    protected DownloadStatusHandler mStatusHandler;

    public AbsDownloadModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void cancel() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void pause() {
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void setThrottleNetSpeed(long r100, int r101) {
    }

    public boolean checkTaskFinishByUser() {
        if (this.mCommonParams.mDownloadInfo.getStatus() != (-2)) goto L9;
        DownloadCommonParams r100 = this.mCommonParams;
        RunStatus r101 = r100.mRunStatus;
        RunStatus r102 = RunStatus.RUN_STATUS_PAUSE;
        if (r101 == r102) goto L7;
        r100.mRunStatus = r102;
    L7:
        return true;
    L9:
        if (this.mCommonParams.mDownloadInfo.getStatus() != (-4)) goto L14;
        DownloadCommonParams r103 = this.mCommonParams;
        RunStatus r104 = r103.mRunStatus;
        RunStatus r105 = RunStatus.RUN_STATUS_CANCELED;
        if (r104 == r105) goto L13;
        r103.mRunStatus = r105;
    L13:
        return true;
    L14:
        RunStatus r106 = this.mCommonParams.mRunStatus;
        if (r106 != RunStatus.RUN_STATUS_CANCELED) goto L17;
        return true;
    L17:
        if (r106 == RunStatus.RUN_STATUS_PAUSE) goto L22;
        return false;
    L22:
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r100) {
        this.mCommonParams = r100;
        this.mDownloadCache = r100.mDownloadCache;
        this.mDownloadTask = r100.mDownloadTask;
        this.mDownloadInfo = r100.mDownloadInfo;
        this.mSetting = r100.mSetting;
        this.mStatusHandler = r100.mStatusHandler;
        return this;
    }
}
