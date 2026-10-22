package com.ss.android.socialbase.appdownloader.service;

import com.ss.android.socialbase.appdownloader.depend.ITempAppInstallDownloadReceiverListener;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadReceiverService {

    public static class DefaultDownloadReceiverService implements IDownloadReceiverService {
        public DefaultDownloadReceiverService() {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
        public void registerDownloadReceiver() {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
        public void setTempAppInstallDownloadReceiverListener(ITempAppInstallDownloadReceiverListener r100) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
        public void tryRegisterTempAppInstallDownloadReceiver(int r100) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService
        public void unRegisterDownloadReceiver() {
        }
    }

    void registerDownloadReceiver();

    void setTempAppInstallDownloadReceiverListener(ITempAppInstallDownloadReceiverListener r100);

    void tryRegisterTempAppInstallDownloadReceiver(int r100);

    void unRegisterDownloadReceiver();
}
