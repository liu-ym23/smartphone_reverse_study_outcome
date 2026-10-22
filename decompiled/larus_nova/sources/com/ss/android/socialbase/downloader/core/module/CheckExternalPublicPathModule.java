package com.ss.android.socialbase.downloader.core.module;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* JADX INFO: loaded from: classes38.dex */
public class CheckExternalPublicPathModule extends AbsDownloadModule {
    public CheckExternalPublicPathModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r100) {
        if (r100.mSetting.optInt(DownloadSettingKeys.RUN_CLEANER_BACKGROUND_DELAY_TIME_S) > 0) goto L5;
        return null;
    L5:
        if (r100.mSetting.optInt(DownloadSettingKeys.REMOVE_EXTERNAL_PUBLIC_DIR_TASK_FOR_Q) > 0) goto L7;
        return null;
    L7:
        if (DownloadFileUtils.isAtLeastAndroidQ() == true) goto L9;
        return null;
    L9:
        return super.init(r100);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r100) throws BaseException {
        if (TextUtils.isEmpty(this.mDownloadInfo.getSavePath()) == false) goto L5;
    L11:
        r100.proceed();
        return;
    L5:
        if (DownloadFileUtils.isMediaUri(this.mDownloadInfo.getSavePath()) == true) goto L11;
        if (DownloadFileUtils.isFilePathInExternalPublicDir(this.mDownloadInfo.getSavePath()) == false) goto L11;
        throw new BaseException(1094, "External Public Path Error:" + this.mDownloadInfo.getSavePath());
    }
}
