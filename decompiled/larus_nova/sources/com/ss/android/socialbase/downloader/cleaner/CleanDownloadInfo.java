package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes5.dex */
public class CleanDownloadInfo {
    private int mId;
    private String mMonitorScene;
    private String mName;
    private String mSavePath;
    private String mTempPath;
    private String mUrl;

    public CleanDownloadInfo() {
    }

    public int getId() {
        return this.mId;
    }

    public String getMonitorScene() {
        return this.mMonitorScene;
    }

    public String getName() {
        return this.mName;
    }

    public String getSavePath() {
        return this.mSavePath;
    }

    public String getTempPath() {
        return this.mTempPath;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public CleanDownloadInfo(DownloadInfo r100) {
        this.mId = r100.getId();
        this.mSavePath = r100.getSavePath();
        this.mTempPath = r100.getTempPath();
        this.mName = r100.getName();
        this.mMonitorScene = r100.getMonitorScene();
        this.mUrl = r100.getUrl();
    }

    public void setId(int r100) {
        this.mId = r100;
    }

    public void setMonitorScene(String r100) {
        this.mMonitorScene = r100;
    }

    public void setName(String r100) {
        this.mName = r100;
    }

    public void setSavePath(String r100) {
        this.mSavePath = r100;
    }

    public void setTempPath(String r100) {
        this.mTempPath = r100;
    }

    public void setUrl(String r100) {
        this.mUrl = r100;
    }
}
