package com.ss.android.downloadad.api.download;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadManagementModel {
    private DownloadController mDownloadController;
    private DownloadEventConfig mDownloadEventConfig;
    private DownloadModel mDownloadModel;
    private int mTabType;

    public DownloadManagementModel() {
    }

    public DownloadController getDownloadController() {
        return this.mDownloadController;
    }

    public DownloadEventConfig getDownloadEventConfig() {
        return this.mDownloadEventConfig;
    }

    public DownloadModel getDownloadModel() {
        return this.mDownloadModel;
    }

    public int getmTabType() {
        return this.mTabType;
    }

    public void setDownloadController(DownloadController r100) {
        this.mDownloadController = r100;
    }

    public void setDownloadEventConfig(DownloadEventConfig r100) {
        this.mDownloadEventConfig = r100;
    }

    public void setDownloadModel(DownloadModel r100) {
        this.mDownloadModel = r100;
    }

    public void setmTabType(int r100) {
        this.mTabType = r100;
    }
}
