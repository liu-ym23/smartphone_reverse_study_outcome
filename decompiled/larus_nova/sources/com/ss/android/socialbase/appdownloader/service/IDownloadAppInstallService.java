package com.ss.android.socialbase.appdownloader.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallDetectorListener;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public interface IDownloadAppInstallService {

    public static class DefaultDownloadAppInstallService implements IDownloadAppInstallService {
        public DefaultDownloadAppInstallService() {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
        public void handleApkInstalled(String r100) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
        public void setAppInstallDetectorListener(IAppInstallDetectorListener r100) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
        public void startAppInstallDetector(Context r100, PackageInfo r101, JSONObject r102) {
        }

        @Override // com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService
        public void startInstall(DownloadInfo r100) {
        }
    }

    void handleApkInstalled(String r100);

    void setAppInstallDetectorListener(IAppInstallDetectorListener r100);

    void startAppInstallDetector(Context r100, PackageInfo r101, JSONObject r102);

    void startInstall(DownloadInfo r100);
}
