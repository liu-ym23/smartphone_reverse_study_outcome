package com.volcengine.zeus.download;

import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class PluginDownloadBean {
    public static final int ERROR_EXCEPTION = 5;
    public static final int ERROR_NET_OFF = 1;
    public static final int ERROR_NO_DATA = 4;
    public static final int ERROR_RESPONSE_EMPTY = 2;
    public static final int ERROR_RESPONSE_INTERCEPT = 3;
    public static final int ERROR_SHOULD_NOT_DOWNLOAD = 6;
    public String extraInfo;
    public int mApiVersionMax;
    public int mApiVersionMin;
    public List<String> mBackupUrlList;
    public String mCustomMsg;
    public int mErrorCode;
    public int mFlag;
    public long mFollowId;
    public String mMd5;
    public String mPackageName;
    public String mUrl;
    public int mVersionCode;

    public boolean hasResult() {
        if (this.mErrorCode != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isRevert() {
        if (this.mFlag != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isUnInstall() {
        if (this.mFlag == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public String toString() {
        return "PluginDownloadBean{mErrorCode=" + this.mErrorCode + ", mFollowId=" + this.mFollowId + ", mPackageName='" + this.mPackageName + "', mVersionCode=" + this.mVersionCode + ", mUrl='" + this.mUrl + "', mFlag=" + this.mFlag + ", mMd5='" + this.mMd5 + "', extraInfo='" + this.extraInfo + "', mBackupUrlList=" + this.mBackupUrlList + ", mApiVersionMin=" + this.mApiVersionMin + ", mApiVersionMax=" + this.mApiVersionMax + ", mCustomMsg=" + this.mCustomMsg + '}';
    }

    public PluginDownloadBean() {
        this.mApiVersionMin = 0;
        this.mApiVersionMax = Integer.MAX_VALUE;
        this.mErrorCode = 0;
    }

    public PluginDownloadBean(String r100, int r101) {
        this.mApiVersionMin = 0;
        this.mApiVersionMax = Integer.MAX_VALUE;
        this.mPackageName = r100;
        this.mErrorCode = r101;
    }
}
