package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService;

/* JADX INFO: loaded from: classes38.dex */
public class RetryScheduler implements IDownloadRetrySchedulerService {
    public static final int NET_TYPE_COMMON = 1;
    public static final int NET_TYPE_NONE = 0;
    public static final int NET_TYPE_WIFI = 2;
    private static volatile RetryScheduler sInstance;
    private IDownloadRetrySchedulerService service;

    public interface RetryScheduleHandler {
        void cancelRetry(int r100);

        void scheduleRetry(DownloadInfo r100, long r101, boolean r102, int r103);
    }

    public static RetryScheduler getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(RetryScheduler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new RetryScheduler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RetryScheduler.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskConnected() {
        this.service.scheduleRetryWhenHasTaskConnected();
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void scheduleRetryWhenHasTaskSucceed() {
        this.service.scheduleRetryWhenHasTaskSucceed();
    }

    private RetryScheduler() {
        this.service = (IDownloadRetrySchedulerService) DownloadServiceManager.getService(IDownloadRetrySchedulerService.class);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void doSchedulerRetry(int r100) {
        this.service.doSchedulerRetry(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void setRetryScheduleHandler(RetryScheduleHandler r100) {
        this.service.setRetryScheduleHandler(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryCancelScheduleRetry(int r100) {
        this.service.tryCancelScheduleRetry(r100);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
    public void tryStartScheduleRetry(DownloadInfo r100) {
        this.service.tryStartScheduleRetry(r100);
    }
}
