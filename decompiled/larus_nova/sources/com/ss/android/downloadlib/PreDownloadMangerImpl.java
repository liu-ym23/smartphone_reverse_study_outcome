package com.ss.android.downloadlib;

import com.ss.android.download.api.PreDownloadManager;

/* JADX INFO: loaded from: classes34.dex */
public class PreDownloadMangerImpl implements PreDownloadManager {
    private static PreDownloadMangerImpl sInstance;

    @Override // com.ss.android.download.api.PreDownloadManager
    public void getSilentDownloadAppList() {
    }

    @Override // com.ss.android.download.api.PreDownloadManager
    public void tryStartSilentDownload(String r100, boolean r101, long r102, String r103) {
    }

    public static PreDownloadMangerImpl getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(PreDownloadMangerImpl.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PreDownloadMangerImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PreDownloadMangerImpl.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private PreDownloadMangerImpl() {
    }
}
