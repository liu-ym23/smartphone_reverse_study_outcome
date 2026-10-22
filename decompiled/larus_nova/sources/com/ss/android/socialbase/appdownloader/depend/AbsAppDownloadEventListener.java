package com.ss.android.socialbase.appdownloader.depend;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public class AbsAppDownloadEventListener implements IAppDownloadEventListener {
    public AbsAppDownloadEventListener() {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener
    public String getNotifyProcessName() {
        return null;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener
    public boolean installIntercept(boolean r100) {
        return false;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener
    public void onAppDownloadCancel(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener
    public void onAppDownloadEvent(int r100, String r101, int r102, long r103) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener
    public void onAppInstallError(int r100, String r101, String r102, String r103) {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener
    public void onAppInstalled(Context r100, String r101) {
    }
}
