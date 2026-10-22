package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes38.dex */
public class PluginDownloadEngine {
    private static final String TAG = "PluginDownloadEngine";
    private static volatile PluginDownloadEngine mInstance;
    private static volatile IDownloadPluginDegradeListener sDownloadPluginDegradeListener;
    private static volatile boolean sUsingBackupEngine;
    private BackUpPluginDownloadEngine mBackUpPluginDownloadEngine;
    private CorePluginDownloadEngine mCorePluginDownloadEngine;

    public static PluginDownloadEngine getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(PluginDownloadEngine.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new PluginDownloadEngine();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PluginDownloadEngine.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public static void resumeAllDownloadTask() {
        if (mInstance == null) goto L12;
        if (mInstance.mCorePluginDownloadEngine == null) goto L12;
        if (sUsingBackupEngine == true) goto L12;
        mInstance.mCorePluginDownloadEngine.resumeAllDownloadTask();
        return;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.globalDebug(TAG, "resumeAllDownloadTask", "Instance:" + mInstance + " UsingBackupEngine");
        return;
    }

    private PluginDownloadEngine() {
        this.mCorePluginDownloadEngine = new CorePluginDownloadEngine();
        this.mBackUpPluginDownloadEngine = new BackUpPluginDownloadEngine();
    }

    public static IDownloadPluginDegradeListener getDownloadPluginDegradeListener() {
        return sDownloadPluginDegradeListener;
    }

    public static boolean isBackupEngine() {
        return sUsingBackupEngine;
    }

    public static boolean isEnabledDownloadPluginOpt(DownloadInfo r100) {
        if (r100.getEnqueueType() != EnqueueType.NEW_ENQUEUE_NORMAL) goto L5;
    L8:
        return true;
    L5:
        if (r100.getEnqueueType() == EnqueueType.NEW_ENQUEUE_IMMEDIATE) goto L8;
        return false;
    }

    public static void pauseAllDownloadTask(List<String> r100) {
        if (mInstance == null) goto L12;
        if (mInstance.mCorePluginDownloadEngine == null) goto L12;
        if (sUsingBackupEngine == true) goto L12;
        mInstance.mCorePluginDownloadEngine.pauseAllDownloadTask(r100);
        return;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.globalDebug(TAG, "pauseAllDownloadTask", "Instance:" + mInstance + " UsingBackupEngine");
        return;
    }

    public static void setBackupEngine(boolean r100) {
        sUsingBackupEngine = r100;
    }

    public static void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        sDownloadPluginDegradeListener = r100;
    }

    public void download(DownloadTask r100) {
        if (sUsingBackupEngine == false) goto L5;
        this.mBackUpPluginDownloadEngine.download(r100);
        return;
    L5:
        this.mCorePluginDownloadEngine.download(r100);
    }

    public ExecutorService getPluginExecutor(EnqueueType r100) {
        if (sUsingBackupEngine == false) goto L6;
        return this.mBackUpPluginDownloadEngine.getPluginExecutor(r100);
    L6:
        return this.mCorePluginDownloadEngine.getPluginExecutor();
    }
}
