package com.ss.android.download.api.inner;

/* JADX INFO: loaded from: classes34.dex */
public interface ITTDownloaderMonitor {
    void monitorDataError(String r100);

    void monitorDataError(boolean r100, String r101);

    void monitorDataError(boolean r100, boolean r101, String r102);

    void monitorException(Throwable r100, String r101);

    void monitorException(boolean r100, Throwable r101, String r102);

    void monitorException(boolean r100, boolean r101, Throwable r102, String r103);

    void monitorPathError(String r100);

    void monitorPathError(boolean r100, String r101);

    void monitorPathError(boolean r100, boolean r101, String r102);
}
