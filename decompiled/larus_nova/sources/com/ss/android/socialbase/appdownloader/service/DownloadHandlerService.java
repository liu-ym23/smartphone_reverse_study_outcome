package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.DownloadHandlerServiceImpl;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class DownloadHandlerService implements IDownloadHandlerService {
    public DownloadHandlerService() {
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService
    public void onStartCommand(Context r100, Intent r101) {
        DownloadHandlerServiceImpl.onStartCommand(r100, r101);
    }

    @Override // com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService
    public void handleActionClickWithoutType(Context r100, DownloadInfo r101, IAppDownloadEventHandler r102, IDownloadNotificationEventListener r103) {
        DownloadHandlerServiceImpl.handleActionClickWithoutType(r100, r101, r102, r103);
    }
}
