package com.ss.android.downloadlib;

import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.downloader.db.SqlDownloadCache;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IDownloadCache;
import com.ss.android.socialbase.downloader.downloader.ISqlDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadScheduledThreadPoolExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadComponentManager {
    private ExecutorService cpuExecutor;
    private ScheduledExecutorService customScheduledExecutor;
    private ScheduledExecutorService downloadRetainScheduledExecutor;
    private ExecutorService installFinishCheckCPUExecutor;
    private ExecutorService ioExecutor;
    private ScheduledExecutorService scheduledExecutor;

    public static class SingleTonHolder {
        private static DownloadComponentManager INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new DownloadComponentManager(null);
        }

        public static /* synthetic */ DownloadComponentManager access$100() {
            return INSTANCE;
        }
    }

    public void clearAllData() {
        submitCPUTask(new AnonymousClass1(this));
    }

    public ExecutorService getCPUExecutor() {
        if (this.cpuExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.cpuExecutor != null) goto L9;
        this.cpuExecutor = new PThreadPoolExecutor(2, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TTDownloader.class.getName().concat("-CPUThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.cpuExecutor;
    }

    public ScheduledExecutorService getCustomScheduledExecutor() {
        if (this.customScheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.customScheduledExecutor != null) goto L9;
        this.customScheduledExecutor = new PThreadScheduledThreadPoolExecutor(0, new DefaultThreadFactory(TTDownloader.class.getName().concat("-CustomScheduledThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.customScheduledExecutor;
    }

    public ScheduledExecutorService getDownloadRetainScheduledExecutor() {
        if (this.downloadRetainScheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.downloadRetainScheduledExecutor != null) goto L9;
        this.downloadRetainScheduledExecutor = new PThreadScheduledThreadPoolExecutor(2, new DefaultThreadFactory(TTDownloader.class.getName().concat("DownloadRetainScheduledThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.downloadRetainScheduledExecutor;
    }

    public ExecutorService getIOExecutor() {
        if (this.ioExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.ioExecutor != null) goto L9;
        this.ioExecutor = new PThreadPoolExecutor(5, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TTDownloader.class.getName().concat("-IOThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.ioExecutor;
    }

    public ExecutorService getInstallFinishCheckCPUExecutor() {
        if (this.installFinishCheckCPUExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.installFinishCheckCPUExecutor != null) goto L9;
        this.installFinishCheckCPUExecutor = new PThreadPoolExecutor(5, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory(TTDownloader.class.getName().concat("-InstallFinishCheckCPUThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.installFinishCheckCPUExecutor;
    }

    public ScheduledExecutorService getScheduledExecutor() {
        if (this.scheduledExecutor != null) goto L15;
        monitor-enter(DownloadComponentManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.scheduledExecutor != null) goto L9;
        this.scheduledExecutor = new PThreadScheduledThreadPoolExecutor(0, new DefaultThreadFactory(TTDownloader.class.getName().concat("-ScheduledThreadPool")));     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadComponentManager.class);     // Catch: Throwable -> L11
    L15:
        return this.scheduledExecutor;
    }

    public static DownloadComponentManager getInstance() {
        return SingleTonHolder.access$100();
    }

    public void clearApkAndData() {
        TTDownloaderMonitor.inst().monitorDataError(false, "using CLEAR function");
        clearAllData();
        IDownloadCache r100 = com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.getDownloadCache();
        if ((r100 instanceof DefaultDownloadCache) == true) goto L5;
        return;
    L5:
        ISqlDownloadCache r101 = ((DefaultDownloadCache) r100).getSqlDownloadCache();
        if ((r101 instanceof SqlDownloadCache) == true) goto L8;
        return;
    L8:
        r101.clearData();
        ModelManager.getInstance().getAllNativeModels().clear();
    }

    public void destroyComponents() {
        AppDownloader.getInstance().unRegisterDownloadReceiver();
        Downloader.getInstance(GlobalInfo.getContext()).destoryDownloader();
    }

    private DownloadComponentManager() {
    }

    public /* synthetic */ DownloadComponentManager(AnonymousClass1 r100) {
        this();
    }

    public void setCPUExecutor(ExecutorService r100) {
        this.cpuExecutor = r100;
    }

    public void setIOExecutor(ExecutorService r100) {
        this.ioExecutor = r100;
    }

    public void setScheduledExecutor(ScheduledExecutorService r100) {
        this.scheduledExecutor = r100;
    }

    public void submitCPUTask(Runnable r100) {
        submitCPUTask(r100, false);
    }

    public void submitIOTask(Runnable r100) {
        submitIOTask(r100, false);
    }

    public void submitInstallFinishCheckCPUTask(Runnable r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        getInstallFinishCheckCPUExecutor().execute(r100);
    }

    public void submitCPUTask(Runnable r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == true) goto L6;
    L8:
        getCPUExecutor().execute(r100);
        return;
    L6:
        if (ToolUtils.isMainThread() == true) goto L8;
        r100.run();
    }

    public void submitCustomScheduledTask(Runnable r100, long r101) {
        getCustomScheduledExecutor().schedule(r100, r101, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void submitDownloadRetainScheduledTask(Runnable r100, long r101) {
        getDownloadRetainScheduledExecutor().schedule(r100, r101, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public void submitIOTask(Runnable r100, boolean r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 == true) goto L6;
    L8:
        getIOExecutor().execute(r100);
        return;
    L6:
        if (ToolUtils.isMainThread() == true) goto L8;
        r100.run();
    }

    public void submitScheduledTask(Runnable r100, long r101) {
        getScheduledExecutor().schedule(r100, r101, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
