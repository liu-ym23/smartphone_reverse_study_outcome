package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadHandlerService {

    public static class DefaultIDownloadHandlerService implements IDownloadHandlerService {
        public DefaultIDownloadHandlerService() {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService
        public void handleActionClickWithoutType(Context r100, DownloadInfo r101, IAppDownloadEventHandler r102, IDownloadNotificationEventListener r103) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadHandlerService
        public void onStartCommand(Context r100, Intent r101) {
        }
    }

    void handleActionClickWithoutType(Context r100, DownloadInfo r101, IAppDownloadEventHandler r102, IDownloadNotificationEventListener r103);

    void onStartCommand(Context r100, Intent r101);
}
