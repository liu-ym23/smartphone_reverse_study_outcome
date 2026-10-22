package com.ss.android.socialbase.downloader.core.module;

import com.ss.android.socialbase.downloader.core.AbsDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModule;
import com.ss.android.socialbase.downloader.core.IDownloadModuleChain;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadCheckTaskRepetitionModule extends AbsDownloadModule {
    private static final String TAG = "DownloadCheckTaskRepetitionModule";
    private static Set mDownloadingIdSet;
    private static Object mLock;

    static {
        mLock = new Object();
        mDownloadingIdSet = new HashSet();
    }

    public DownloadCheckTaskRepetitionModule() {
    }

    @Override // com.ss.android.socialbase.downloader.core.AbsDownloadModule, com.ss.android.socialbase.downloader.core.IDownloadModule
    public IDownloadModule init(DownloadCommonParams r100) {
        if (r100.mSetting.optInt(DownloadSettingKeys.FIX_TASK_REPETITION) > 0) goto L5;
        return null;
    L5:
        return super.init(r100);
    }

    @Override // com.ss.android.socialbase.downloader.core.IDownloadModule
    public void proceed(IDownloadModuleChain r100) throws BaseException {
        int r101 = this.mDownloadInfo.getId();
        Object r102 = mLock;
        monitor-enter(r102);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (mDownloadingIdSet.contains(Integer.valueOf(r101)) == false) goto L9;
        Logger.taskError(TAG, r101, "proceed", "Repetitive task");     // Catch: Throwable -> L29
        monitor-exit(r102);     // Catch: Throwable -> L29
        return;
    L9:
        mDownloadingIdSet.add(Integer.valueOf(r101));     // Catch: Throwable -> L29
        monitor-exit(r102);     // Catch: Throwable -> L29
        r100.proceed();     // Catch: Throwable -> L20
        Object r103 = mLock;
        monitor-enter(r103);
        mDownloadingIdSet.remove(Integer.valueOf(r101));     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L20:
        th = move-exception;
        monitor-enter(mLock);
        mDownloadingIdSet.remove(Integer.valueOf(r101));     // Catch: Throwable -> L26
        throw th;
    L26:
        th = move-exception;
        throw th;
    }
}
