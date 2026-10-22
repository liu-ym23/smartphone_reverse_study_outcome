package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadGlobalThrottleService {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadGlobalThrottleService implements IDownloadGlobalThrottleService {
        public DefaultDownloadGlobalThrottleService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void end(DownloadTask r100) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void setGlobalThrottle(int r100, int r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void setGlobalThrottleTaskPriority(int r100, int r101) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadGlobalThrottleService
        public void start(DownloadTask r100) {
        }
    }

    void end(DownloadTask r100);

    void setGlobalThrottle(int r100, int r101);

    void setGlobalThrottleTaskPriority(int r100, int r101);

    void start(DownloadTask r100);
}
