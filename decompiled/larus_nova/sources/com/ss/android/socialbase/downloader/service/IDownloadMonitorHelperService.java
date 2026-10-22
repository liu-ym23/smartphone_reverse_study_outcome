package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;

/* JADX INFO: loaded from: classes5.dex */
public interface IDownloadMonitorHelperService {

    /* JADX INFO: loaded from: classes38.dex */
    public static class DefaultDownloadMonitorHelperService implements IDownloadMonitorHelperService {
        public DefaultDownloadMonitorHelperService() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorDownloadApp(DownloadInfo r100, String r101, int r102) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorSend(DownloadTask r100, BaseException r101, int r102) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
        public void monitorSendWithTaskMonitor(IDownloadMonitorDepend r100, DownloadInfo r101, BaseException r102, int r103) {
        }
    }

    void monitorDownloadApp(DownloadInfo r100, String r101, int r102);

    void monitorSend(DownloadTask r100, BaseException r101, int r102);

    void monitorSendWithTaskMonitor(IDownloadMonitorDepend r100, DownloadInfo r101, BaseException r102, int r103);
}
