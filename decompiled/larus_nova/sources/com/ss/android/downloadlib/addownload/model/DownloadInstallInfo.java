package com.ss.android.downloadlib.addownload.model;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadInstallInfo {
    public static int DOWNLOAD_INSTALL_DEFAULT = 0;
    public static int DOWNLOAD_INSTALL_NORMAL = 1;
    public static int DOWNLOAD_INSTALL_UPGRADE = 2;
    private String mAppPackageName;
    private JSONObject mDownloadExtraObject;
    private long mDownloadTaskId;
    private int mInstallStatus;
    private int mVersionCode;
    private String mVersionName;

    public boolean isInstall() {
        if (this.mInstallStatus != DOWNLOAD_INSTALL_NORMAL) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNeedUpgrade() {
        if (this.mInstallStatus != DOWNLOAD_INSTALL_UPGRADE) goto L5;
        return true;
    L5:
        return false;
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.put("mInstallStatus", this.mInstallStatus);     // Catch: Exception -> L5
        r100.put("mDownloadTaskId", this.mDownloadTaskId);     // Catch: Exception -> L5
        r100.put("mDownloadExtraObject", this.mDownloadExtraObject);     // Catch: Exception -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public DownloadInstallInfo() {
        this.mInstallStatus = DOWNLOAD_INSTALL_DEFAULT;
        this.mDownloadTaskId = 0;
        this.mDownloadExtraObject = null;
        this.mVersionCode = 0;
        this.mVersionName = "";
        this.mAppPackageName = "";
    }

    public String getAppPackageName() {
        return this.mAppPackageName;
    }

    public int getInstallStatus() {
        return this.mInstallStatus;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String getVersionName() {
        return this.mVersionName;
    }

    public JSONObject getmDownloadExtraObject() {
        return this.mDownloadExtraObject;
    }

    public long getmDownloadTaskId() {
        return this.mDownloadTaskId;
    }

    public DownloadInstallInfo setAppPackageName(String r100) {
        this.mAppPackageName = r100;
        return this;
    }

    public DownloadInstallInfo setDownloadExtraObject(JSONObject r100) {
        this.mDownloadExtraObject = r100;
        return this;
    }

    public DownloadInstallInfo setDownloadTaskId(long r100) {
        this.mDownloadTaskId = r100;
        return this;
    }

    public DownloadInstallInfo setInstallStatus(int r100) {
        this.mInstallStatus = r100;
        return this;
    }

    public DownloadInstallInfo setVersionCode(int r100) {
        this.mVersionCode = r100;
        return this;
    }

    public DownloadInstallInfo setVersionName(String r100) {
        this.mVersionName = r100;
        return this;
    }
}
