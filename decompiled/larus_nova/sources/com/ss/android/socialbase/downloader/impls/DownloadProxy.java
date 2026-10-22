package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IDownloadProxy;

/* JADX INFO: loaded from: classes5.dex */
public class DownloadProxy {
    private static volatile IDownloadProxy downloadIndependentProxy;
    private static volatile IDownloadProxy downloadProxy;

    public DownloadProxy() {
    }

    private static IDownloadProxy getDefaultDownloadProxy() {
        if (downloadProxy != null) goto L15;
        monitor-enter(DownloadProxy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (downloadProxy != null) goto L9;
        downloadProxy = new ProcessDownloadHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DownloadProxy.class);     // Catch: Throwable -> L11
    L15:
        return downloadProxy;
    }

    public static IDownloadProxy get(boolean r100) {
        if (r100 == false) goto L24;
        if (DownloadComponentManager.supportMultiProc() == false) goto L24;
        if (downloadIndependentProxy != null) goto L20;
        monitor-enter(DownloadProxy.class);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (downloadIndependentProxy != null) goto L14;
        DownloadComponentManager.IndependentHolderCreator r101 = DownloadComponentManager.getIndependentHolderCreator();     // Catch: Throwable -> L16
        if (r101 == null) goto L14;
        downloadIndependentProxy = r101.createProxy();     // Catch: Throwable -> L16
    L14:
        monitor-exit(DownloadProxy.class);     // Catch: Throwable -> L16
    L20:
        if (downloadIndependentProxy == null) goto L24;
        return downloadIndependentProxy;
    L24:
        return getDefaultDownloadProxy();
    }
}
