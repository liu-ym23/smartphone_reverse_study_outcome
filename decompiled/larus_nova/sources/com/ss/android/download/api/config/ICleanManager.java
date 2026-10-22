package com.ss.android.download.api.config;

/* JADX INFO: loaded from: classes34.dex */
public interface ICleanManager {
    void clearStorageSpace();

    boolean enableScan();

    boolean enableShowDownloadCleanDialog();

    boolean enableShowInstallCleanDialog();

    long getLastScanSpaceSize();

    boolean handleCleanSpace(int r100, String r101, boolean r102, long r103);

    void setModelId(long r100);

    void startScan();
}
