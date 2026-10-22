package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes5.dex */
public class IndependentProcessDownloadService extends DownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.DownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DownloadComponentManager.setAppContext(this);
        if (DownloadComponentManager.getIndependentHolderCreator() != null) goto L5;
        DownloadComponentManager.setIndependentServiceCreator(new MultiProcCreater());
    L5:
        IDownloadServiceHandler r100 = DownloadComponentManager.getIndependentDownloadServiceHandler();
        this.downloadServiceHandler = r100;
        r100.setDownloadService(new WeakReference(this));
    }

    public IndependentProcessDownloadService() {
    }
}
