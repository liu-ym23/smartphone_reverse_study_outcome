package com.ss.android.socialbase.downloader.service;

import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadMonitorHelperService implements IDownloadMonitorHelperService {
    public DownloadMonitorHelperService() {
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorDownloadApp(DownloadInfo r100, String r101, int r102) {
        DownloadMonitorHelper.monitorDownloadApp(r100, r101, r102);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorSend(DownloadTask r100, BaseException r101, int r102) {
        DownloadMonitorHelper.monitorSend(r100, r101, r102);
    }

    @Override // com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService
    public void monitorSendWithTaskMonitor(IDownloadMonitorDepend r100, DownloadInfo r101, BaseException r102, int r103) {
        DownloadMonitorHelper.monitorSendWithTaskMonitor(r100, r101, r102, r103);
    }
}
