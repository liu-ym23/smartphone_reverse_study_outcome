package com.ss.android.socialbase.appdownloader.service;

import android.app.job.JobParameters;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadRetryJobSchedulerService {

    public static class DefaultDownloadRetryJobSchedulerService implements IDownloadRetryJobSchedulerService {
        public DefaultDownloadRetryJobSchedulerService() {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
        public void onStartJob(JobParameters r100) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
        public void tryCancelScheduleRetry(int r100) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadRetryJobSchedulerService
        public void tryStartScheduleRetry(DownloadInfo r100, long r101, boolean r102, int r103) {
        }
    }

    void onStartJob(JobParameters r100);

    void tryCancelScheduleRetry(int r100);

    void tryStartScheduleRetry(DownloadInfo r100, long r101, boolean r102, int r103);
}
