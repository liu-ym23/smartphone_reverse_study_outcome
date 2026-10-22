package com.ss.android.socialbase.downloader.core;

import android.os.Handler;
import android.os.Process;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.RunStatus;
import com.ss.android.socialbase.downloader.core.module.CheckExternalPublicPathModule;
import com.ss.android.socialbase.downloader.core.module.DownloadBandwidthSamplerModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckFileExistModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckHasAnotherSameTaskModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckPathModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckTaskCanResumedModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckTaskRepetitionModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCheckWifiTaskValidModule;
import com.ss.android.socialbase.downloader.core.module.DownloadCommonParams;
import com.ss.android.socialbase.downloader.core.module.DownloadCompleteModule;
import com.ss.android.socialbase.downloader.core.module.DownloadLoadCacheModule;
import com.ss.android.socialbase.downloader.core.module.DownloadMimeTypeInterceptModule;
import com.ss.android.socialbase.downloader.core.module.DownloadPrepareModule;
import com.ss.android.socialbase.downloader.core.module.DownloadRetryModule;
import com.ss.android.socialbase.downloader.core.module.DownloadStartModule;
import com.ss.android.socialbase.downloader.core.module.DownloadTaskInterceptModule;
import com.ss.android.socialbase.downloader.core.module.DownloadUrlInterceptModule;
import com.ss.android.socialbase.downloader.core.module.fast.DownloadFastModule;
import com.ss.android.socialbase.downloader.core.module.multi.DownloadMultiSegmentModule;
import com.ss.android.socialbase.downloader.core.module.normal.DownloadSingleSegmentModule;
import com.ss.android.socialbase.downloader.core.module.pcdn.DownloadPCDNSegmentModule;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.DownloadStatusHandler;
import com.ss.android.socialbase.downloader.downloader.NetworkFailoverStrategy;
import com.ss.android.socialbase.downloader.downloader.NetworkRetryStrategy;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.concurrent.Future;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadRunnable implements Runnable {
    private static final String TAG = "DownloadRunnable";
    private DownloadCommonParams mCommonParams;
    private DownloadModuleChain mDownloadModuleChain;
    private Future mFuture;
    private boolean mIsPluginThreadPool;

    @Override // java.lang.Runnable
    public void run() {
        com_ss_android_socialbase_downloader_core_DownloadRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    private void resetStats() {
        this.mCommonParams.mDownloadTask.getTimingInfo().reset();
        this.mCommonParams.mDownloadTask.getThreadInfo().reset();
    }

    public void cancel() {
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "cancel", "Run");
    L5:
        DownloadCommonParams r100 = this.mCommonParams;
        r100.mRunStatus = RunStatus.RUN_STATUS_CANCELED;
        this.mDownloadModuleChain.cancel();
        if (this.mDownloadModuleChain.isStartDownload() == true) goto L9;
        this.mCommonParams.mStatusHandler.onCancel();
        resetStats();
        return;
    }

    public void com_ss_android_socialbase_downloader_core_DownloadRunnable__run$___twin___() {
        DownloadTimingInfo r100 = this.mCommonParams.mDownloadTask.getTimingInfo();
        r100.threadExecuteTime = System.currentTimeMillis();
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "run", "Run");
    L5:
        Process.setThreadPriority(10);
        DownloadModuleChain r101 = new DownloadModuleChain(this.mCommonParams).addDownloadModule(new DownloadCheckPathModule()).addDownloadModule(new DownloadCheckHasAnotherSameTaskModule()).addDownloadModule(new DownloadCheckWifiTaskValidModule()).addDownloadModule(new DownloadCheckTaskCanResumedModule()).addDownloadModule(new DownloadFastModule()).addDownloadModule(new DownloadMultiSegmentModule()).addDownloadModule(new DownloadPCDNSegmentModule()).addDownloadModule(new DownloadSingleSegmentModule()).addDownloadModule(new DownloadCompleteModule());
        this.mDownloadModuleChain.addDownloadModule(new DownloadCheckTaskRepetitionModule()).addDownloadModule(new DownloadBandwidthSamplerModule()).addDownloadModule(new DownloadPrepareModule()).addDownloadModule(new DownloadUrlInterceptModule()).addDownloadModule(new DownloadTaskInterceptModule()).addDownloadModule(new DownloadLoadCacheModule()).addDownloadModule(new DownloadStartModule()).addDownloadModule(new CheckExternalPublicPathModule()).addDownloadModule(new DownloadMimeTypeInterceptModule()).addDownloadModule(new DownloadCheckFileExistModule()).addDownloadModule(new DownloadRetryModule(r101));
        this.mDownloadModuleChain.proceed();     // Catch: Throwable -> L8
    L10:
        afterDownload();
        return;
    L8:
        th = move-exception;
        th.printStackTrace();
        this.mCommonParams.mStatusHandler.onError(new BaseException(1045, th));
        goto L10
    }

    public int getDownloadId() {
        return this.mCommonParams.mDownloadInfo.getId();
    }

    public DownloadInfo getDownloadInfo() {
        return this.mCommonParams.mDownloadInfo;
    }

    public DownloadTask getDownloadTask() {
        return this.mCommonParams.mDownloadTask;
    }

    public boolean isAlive() {
        return this.mCommonParams.mIsAlive;
    }

    public void pause() {
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "pause", "Run");
    L5:
        DownloadCommonParams r100 = this.mCommonParams;
        r100.mRunStatus = RunStatus.RUN_STATUS_PAUSE;
        this.mDownloadModuleChain.pause();
        if (this.mDownloadModuleChain.isStartDownload() == true) goto L9;
        this.mCommonParams.mStatusHandler.onPause();
        resetStats();
        return;
    }

    public void prepareDownload() {
        this.mCommonParams.mStatusHandler.onPrepare();
    }

    private void afterDownload() {
        resetStats();
        if (Logger.debugScene(this.mCommonParams.mDownloadInfo) == false) goto L5;
        Logger.taskDebug(TAG, this.mCommonParams.mDownloadInfo, "run", "Run Time:" + (System.currentTimeMillis() - this.mCommonParams.mDownloadTask.getTimingInfo().threadExecuteTime));
    L5:
        IDownloadStatusListener r100 = DownloadComponentManager.getDownloadStatusListener();
        if (r100 == null) goto L13;
        r100.onFinish(this.mCommonParams.mDownloadInfo.getStatus());
    L13:
        DownloadComponentManager.getDownloadEngine().removeDownloadRunnable(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    }

    public Future getFuture() {
        return this.mFuture;
    }

    public boolean isPluginThreadPool() {
        return this.mIsPluginThreadPool;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_ss_android_socialbase_downloader_core_DownloadRunnable_com_larus_apm_impl_protector_RunnableLancet_run(DownloadRunnable r100) {
        r100.com_ss_android_socialbase_downloader_core_DownloadRunnable__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public void setEnableSegmentDownload(boolean r100) {
        this.mCommonParams.mEnableSegmentDownload = r100;
    }

    public void setFuture(Future r100) {
        this.mFuture = r100;
    }

    public void setIsPluginThreadPool(boolean r100) {
        this.mIsPluginThreadPool = r100;
    }

    public DownloadRunnable(DownloadTask r100, Handler r101) {
        DownloadCommonParams r102 = new DownloadCommonParams();
        this.mCommonParams = r102;
        this.mDownloadModuleChain = new DownloadModuleChain(r102);
        DownloadCommonParams r103 = this.mCommonParams;
        r103.mDownloadTask = r100;
        r103.mDownloadInfo = r100.getDownloadInfo();
        DownloadCommonParams r104 = this.mCommonParams;
        r104.mStatusHandler = new DownloadStatusHandler(r100, r101);
        DownloadCommonParams r105 = this.mCommonParams;
        r105.mSetting = DownloadSetting.obtain(r105.mDownloadInfo.getId());
        DownloadCommonParams r106 = this.mCommonParams;
        r106.mDownloadCache = DownloadComponentManager.getDownloadCache();
        DownloadCommonParams r107 = this.mCommonParams;
        r107.mRetryStrategy = new NetworkRetryStrategy(r107.mDownloadInfo);
        DownloadCommonParams r108 = this.mCommonParams;
        r108.mFailoverStrategy = new NetworkFailoverStrategy(r108.mDownloadInfo);
    }

    public void setThrottleNetSpeed(long r100, int r101) {
        this.mDownloadModuleChain.setThrottleNetSpeed(r100, r101);
    }
}
