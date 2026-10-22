package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes38.dex */
public class BackUpPluginDownloadEngine {
    private static final int NORMAL_PLUGIN_POOL_SIZE = 2;
    private static final int PLUGIN_POOL_KEEP_ALIVE_TIME = 15;
    private static final String TAG = "BackUpPluginDownloadEngine";
    private ThreadPoolExecutor mBackUpPluginImmediateExecutor;
    private ThreadPoolExecutor mBackUpPluginNormalExecutor;
    private AbsDownloadEngine mDownloadEngine;

    public BackUpPluginDownloadEngine() {
        this.mDownloadEngine = DownloadComponentManager.getDownloadEngine();
        final int r100 = 0;
        final int r101 = Integer.MAX_VALUE;
        final long r102 = 15;
        final TimeUnit r110 = TimeUnit.SECONDS;
        final LinkedBlockingDeque r103 = new LinkedBlockingDeque();
        final DefaultThreadFactory r104 = new DefaultThreadFactory("DownloadThreadPool-bi-plugin", true);
        this.mBackUpPluginImmediateExecutor = new AnonymousClass1(this, r100, r101, r102, r110, r103, r104);
        final int r105 = 2;
        final int r106 = 2;
        final LinkedBlockingDeque r107 = new LinkedBlockingDeque();
        final DefaultThreadFactory r108 = new DefaultThreadFactory("DownloadThreadPool-bn-plugin", true);
        this.mBackUpPluginNormalExecutor = new AnonymousClass2(this, r105, r106, r102, r110, r107, r108);
    }

    public void download(DownloadTask r100) {
        DownloadInfo r101 = r100.getDownloadInfo();
        r101.safePutToDBJsonData(DownloadSettingKeys.FIX_TASK_REPETITION, 1);
        if (Logger.debugScene(r101) == false) goto L5;
        Logger.taskDebug(TAG, r101, "download", "Run type:" + r101.getEnqueueType().ordinal());
    L5:
        this.mDownloadEngine.doDownload(r100, true);
    }

    public ExecutorService getPluginExecutor(EnqueueType r100) {
        if (r100 != EnqueueType.NEW_ENQUEUE_IMMEDIATE) goto L6;
        return this.mBackUpPluginImmediateExecutor;
    L6:
        return this.mBackUpPluginNormalExecutor;
    }
}
