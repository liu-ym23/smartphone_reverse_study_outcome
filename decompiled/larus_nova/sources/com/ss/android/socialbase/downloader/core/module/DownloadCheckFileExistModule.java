package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadCheckFileExistModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckFileExistModule";

    public DownloadCheckFileExistModule() {
    }

    public static void finishWithFileExist(DownloadCommonParams r100) {
        if (r100.mExistTargetFileName.equals(r100.mDownloadInfo.getName()) == false) goto L5;
        r100.mRunStatus = RunStatus.RUN_STATUS_END_RIGHT_NOW;
    L6:
        r100.mDownloadInfo.setCacheExistsInDownloading(true);
        return;
    L5:
        r100.mRunStatus = RunStatus.RUN_STATUS_END_FOR_FILE_EXIST;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r100) {
        if (r100.mDownloadInfo.isFastDownload() == false) goto L7;
        return null;
    L7:
        return super.init(r100);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r100) throws BaseException {
        if (Logger.debugScene(this.mDownloadInfo) == false) goto L6;
        Logger.taskDebug(TAG, this.mDownloadInfo, "proceed", "Run");
    L6:
        if (TextUtils.isEmpty(this.mCommonParams.mExistTargetFileName) == true) goto L15;
        if (this.mDownloadInfo.isExpiredRedownload() == false) goto L10;
        DownloadCommonParams r101 = this.mCommonParams;
        DownloadInfo r102 = this.mDownloadInfo;
        r101.mNeedCheckIfModified = DownloadUtils.cacheExpiredWithHttp(r102, r102.isExpiredHttpCheck());
    L10:
        DownloadCommonParams r103 = this.mCommonParams;
        if (r103.mNeedCheckIfModified == true) goto L15;
        finishWithFileExist(r103);
        return;
    L15:
        if (this.mDownloadInfo.isExpiredRedownload() == true) goto L21;
        if (this.mDownloadInfo.isDownloaded() == false) goto L21;
        DownloadCommonParams r104 = this.mCommonParams;
        r104.mExistTargetFileName = this.mDownloadInfo.getName();
        DownloadCommonParams r105 = this.mCommonParams;
        r105.mExistTargetFilePath = this.mDownloadInfo.getSavePath();
        finishWithFileExist(this.mCommonParams);
        return;
    L21:
        if (this.mDownloadInfo.getChunkCount() <= 1) goto L23;
        this.mDownloadInfo.reset();
        DownloadUtils.deleteAllDownloadFiles(this.mDownloadInfo);
        this.mDownloadCache.updateDownloadInfo(this.mDownloadInfo);
    L23:
        r100.proceed();
    }
}
