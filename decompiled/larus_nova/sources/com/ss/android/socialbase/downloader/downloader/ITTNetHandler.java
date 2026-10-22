package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;

/* JADX INFO: loaded from: classes38.dex */
public interface ITTNetHandler {

    public static class DefaultTTNetHandler implements ITTNetHandler {
        public DefaultTTNetHandler() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void enableTTNetLogger() {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public int getResponseCode(Throwable r100) {
            return -1;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public IDownloadHttpService getTTNetDownloadHttpService() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public boolean isTTNetEnable() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void startThrottle(String[] r100, long r101) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public void stopThrottle(String[] r100) {
        }

        @Override // com.ss.android.socialbase.downloader.downloader.ITTNetHandler
        public DownloadTTNetException translateTTNetException(Throwable r100, String r101) {
            return null;
        }
    }

    void enableTTNetLogger();

    int getResponseCode(Throwable r100);

    IDownloadHttpService getTTNetDownloadHttpService();

    boolean isTTNetEnable();

    void startThrottle(String[] r100, long r101);

    void stopThrottle(String[] r100);

    DownloadTTNetException translateTTNetException(Throwable r100, String r101);
}
