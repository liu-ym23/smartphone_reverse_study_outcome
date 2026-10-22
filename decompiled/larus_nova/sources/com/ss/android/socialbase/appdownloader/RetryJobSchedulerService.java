package com.ss.android.socialbase.appdownloader;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class RetryJobSchedulerService extends JobService {
    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters r100) {
        return false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
    }

    public RetryJobSchedulerService() {
    }

    public static void tryCancelScheduleRetry(int r100) {
        ((IDownloadRetryJobSchedulerService) AppDownloadServiceManager.getService(IDownloadRetryJobSchedulerService.class)).tryCancelScheduleRetry(r100);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters r100) {
        ((IDownloadRetryJobSchedulerService) AppDownloadServiceManager.getService(IDownloadRetryJobSchedulerService.class)).onStartJob(r100);
        return false;
    }

    public static void tryStartScheduleRetry(DownloadInfo r100, long r101, boolean r110, int r111) {
        ((IDownloadRetryJobSchedulerService) AppDownloadServiceManager.getService(IDownloadRetryJobSchedulerService.class)).tryStartScheduleRetry(r100, r101, r110, r111);
    }
}
