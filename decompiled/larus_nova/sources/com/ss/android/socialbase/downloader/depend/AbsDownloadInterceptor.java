package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes38.dex */
public abstract class AbsDownloadInterceptor implements IDownloadInterceptor, IBizCallback {
    public AbsDownloadInterceptor() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IBizCallback
    public String getMonitorScene() {
        return null;
    }

    public boolean intercept(DownloadInfo r100) {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
    public boolean intercepte() {
        return false;
    }
}
