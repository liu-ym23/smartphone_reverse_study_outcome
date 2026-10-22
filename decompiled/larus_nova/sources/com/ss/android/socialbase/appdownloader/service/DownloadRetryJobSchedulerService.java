package com.ss.android.socialbase.appdownloader.service;

import android.app.job.JobParameters;
import com.ss.android.socialbase.appdownloader.RetryJobSchedulerServiceImpl;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadRetryJobSchedulerService implements IDownloadRetryJobSchedulerService {
    public DownloadRetryJobSchedulerService() {
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
    public void onStartJob(JobParameters r100) {
        RetryJobSchedulerServiceImpl.onStartJob(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
    public void tryCancelScheduleRetry(int r100) {
        RetryJobSchedulerServiceImpl.tryCancelScheduleRetry(r100);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
    public void tryStartScheduleRetry(DownloadInfo r100, long r101, boolean r102, int r103) {
        RetryJobSchedulerServiceImpl.tryStartScheduleRetry(r100, r101, r102, r103);
    }
}
