package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadRetrySchedulerService {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadRetrySchedulerService implements IDownloadRetrySchedulerService {
        public DefaultDownloadRetrySchedulerService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void doSchedulerRetry(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void scheduleRetryWhenHasTaskConnected() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void scheduleRetryWhenHasTaskSucceed() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void tryCancelScheduleRetry(int r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadRetrySchedulerService
        public void tryStartScheduleRetry(DownloadInfo r100) {
        }
    }

    void doSchedulerRetry(int r100);

    void scheduleRetryWhenHasTaskConnected();

    void scheduleRetryWhenHasTaskSucceed();

    void setRetryScheduleHandler(RetryScheduler.RetryScheduleHandler r100);

    void tryCancelScheduleRetry(int r100);

    void tryStartScheduleRetry(DownloadInfo r100);
}
