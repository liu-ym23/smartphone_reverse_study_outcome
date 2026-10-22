package com.ss.android.downloadlib;

import com.ss.android.download.api.config.DownloadConfigureInterceptor;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadConfigureInterceptorHolder {
    private static volatile DownloadConfigureInterceptorHolder instance;
    private DownloadConfigureInterceptor mInterceptor;

    public static DownloadConfigureInterceptorHolder getInstance() {
        if (instance != null) goto L15;
        monitor-enter(DownloadConfigureInterceptorHolder.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new DownloadConfigureInterceptorHolder();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadConfigureInterceptorHolder.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private DownloadConfigureInterceptorHolder() {
        this.mInterceptor = null;
    }

    public DownloadConfigureInterceptor getDownloadConfigureInterceptor() {
        return this.mInterceptor;
    }

    public void setDownloadConfigureInterceptor(DownloadConfigureInterceptor r100) {
        this.mInterceptor = r100;
    }
}
