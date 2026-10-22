package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes38.dex */
public class DownloaderBuilder {
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService customThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private List<IDownloadCompleteHandler> downloadCompleteHandlers;
    private IDownloadDns downloadDns;
    private boolean downloadInMultiProcess;
    private IDownloadInterceptor downloadInterceptor;
    private IDownloadLaunchHandler downloadLaunchHandler;
    private IDownloadMonitorListener downloadMonitorListener;
    private IDownloadSettings downloadSetting;
    private IDownloadHttpService httpService;
    private IDownloadIdGenerator idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private IMonitorConfig monitorConfig;
    private boolean needAutoRefreshUnSuccessTask;
    private INotificationClickCallback notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private ITTNetHandler ttNetHandler;
    private int writeBufferSize;

    public DownloaderBuilder downloadExpSwitch(int r100) {
        return this;
    }

    public DownloaderBuilder headHttpService(IDownloadHeadHttpService r100) {
        return this;
    }

    public DownloaderBuilder maxDownloadPoolSize(int r100) {
        return this;
    }

    public Downloader build() {
        return new Downloader(this);
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public Context getContext() {
        return this.context;
    }

    public ExecutorService getCustomThreadExecutor() {
        return this.customThreadExecutor;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public IDownloadDns getDownloadDns() {
        return this.downloadDns;
    }

    public IDownloadInterceptor getDownloadInterceptor() {
        return this.downloadInterceptor;
    }

    public IDownloadLaunchHandler getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public IDownloadMonitorListener getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public IDownloadSettings getDownloadSetting() {
        return this.downloadSetting;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public IDownloadIdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public IMonitorConfig getMonitorConfig() {
        return this.monitorConfig;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public ITTNetHandler getTTNetHandler() {
        return this.ttNetHandler;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }

    public DownloaderBuilder(Context r100) {
        this.downloadCompleteHandlers = new ArrayList();
        this.needAutoRefreshUnSuccessTask = true;
        this.context = r100;
    }

    public DownloaderBuilder addDownloadCompleteHandler(IDownloadCompleteHandler r100) {
        List<IDownloadCompleteHandler> r101 = this.downloadCompleteHandlers;
        monitor-enter(r101);
        if (r100 != null) goto L16;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return this;
    L16:
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.downloadCompleteHandlers.contains(r100) == true) goto L11;
        this.downloadCompleteHandlers.add(r100);     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService r100) {
        this.chunkDownloadExecutor = r100;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService r100) {
        this.cpuThreadExecutor = r100;
        return this;
    }

    public DownloaderBuilder customThreadExecutor(ExecutorService r100) {
        this.customThreadExecutor = r100;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService r100) {
        this.dbThreadExecutor = r100;
        return this;
    }

    public DownloaderBuilder downloadDns(IDownloadDns r100) {
        this.downloadDns = r100;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean r100) {
        this.downloadInMultiProcess = r100;
        return this;
    }

    public DownloaderBuilder downloadInterceptor(IDownloadInterceptor r100) {
        this.downloadInterceptor = r100;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(IDownloadLaunchHandler r100) {
        this.downloadLaunchHandler = r100;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(IDownloadMonitorListener r100) {
        this.downloadMonitorListener = r100;
        return this;
    }

    public DownloaderBuilder downloadSetting(IDownloadSettings r100) {
        this.downloadSetting = r100;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService r100) {
        this.httpService = r100;
        return this;
    }

    public DownloaderBuilder idGenerator(IDownloadIdGenerator r100) {
        this.idGenerator = r100;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService r100) {
        this.ioThreadExecutor = r100;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService r100) {
        this.mixApkDownloadExecutor = r100;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService r100) {
        this.mixDefaultDownloadExecutor = r100;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService r100) {
        this.mixFrequentDownloadExecutor = r100;
        return this;
    }

    public DownloaderBuilder monitorConfig(IMonitorConfig r100) {
        this.monitorConfig = r100;
        return this;
    }

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean r100) {
        this.needAutoRefreshUnSuccessTask = r100;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(INotificationClickCallback r100) {
        this.notificationClickCallback = r100;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService r100) {
        this.okHttpDispatcherExecutor = r100;
        return this;
    }

    public DownloaderBuilder ttNetHandler(ITTNetHandler r100) {
        this.ttNetHandler = r100;
        return this;
    }

    public DownloaderBuilder writeBufferSize(int r100) {
        this.writeBufferSize = r100;
        return this;
    }
}
