package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IBizCallback;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class AbsAppDownloadEventHandler implements IAppDownloadEventHandler, IBizCallback {
    public AbsAppDownloadEventHandler() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleAppInstallError(int r100, int r101, String r102, String r103, String r104) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleAppInstalled(Context r100, String r101) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleDownloadCancel(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public void handleDownloadEvent(int r100, int r101, String r102, int r103, long r104) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public boolean installIntercept(int r100, boolean r101) {
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler
    public boolean isForbidInvalidatePackageInstall() {
        return false;
    }

    public boolean isForbidInvalidatePackageInstall(DownloadInfo r100) {
        return isForbidInvalidatePackageInstall();
    }

    public void handleAppInstalled(DownloadInfo r100, Context r101, String r102) {
        handleAppInstalled(r101, r102);
    }
}
