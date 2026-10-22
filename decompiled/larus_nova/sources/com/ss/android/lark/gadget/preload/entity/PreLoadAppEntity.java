package com.ss.android.lark.gadget.preload.entity;

import com.tt.refer.common.base.AppType;

/* JADX INFO: loaded from: classes36.dex */
public class PreLoadAppEntity {
    public static final int DOWNLOAD_PRIORITY_HIGH = 1;
    public static final int DOWNLOAD_PRIORITY_HIGHEST = 2;
    public static final int DOWNLOAD_PRIORITY_NORMAL = 0;
    public static final int PRELOAD_MODE_LATEST = 2;
    public static final int PRELOAD_MODE_LAZY = 1;
    private AppType brandAppType;
    private String mAppId;
    private int mAppType;
    private int mDownloadPriority;
    private int mOriginDownloadPriority;
    private int mPreloadMode;

    public static boolean compareDownloadPriority(int r100, int r101) {
        if (r100 <= r101) goto L4;
        return true;
    L4:
        return false;
    }

    public static boolean isPreloadModeValid(int r100) {
        if (r100 != 1) goto L5;
    L8:
        return true;
    L5:
        if (r100 == 2) goto L8;
        return false;
    }

    public void downgradePriority() {
        this.mDownloadPriority = 0;
    }

    public boolean downgraded() {
        int r100 = this.mDownloadPriority;
        if (r100 == 0) goto L5;
    L7:
        return false;
    L5:
        if (r100 == this.mOriginDownloadPriority) goto L7;
        return true;
    }

    public String toString() {
        return "mAppId: " + this.mAppId + " mAppType: " + this.mAppType + " mDownloadPriority: " + this.mDownloadPriority + " mOriginDownloadPriority: " + this.mOriginDownloadPriority;
    }

    public PreLoadAppEntity() {
        this.mDownloadPriority = 0;
        this.mOriginDownloadPriority = 0;
        this.mPreloadMode = -1;
    }

    public String getAppid() {
        return this.mAppId;
    }

    public int getApptype() {
        return this.mAppType;
    }

    public AppType getBrandAppType() {
        return this.brandAppType;
    }

    public int getDownloadPriority() {
        return this.mDownloadPriority;
    }

    public int getOriginDownloadPriority() {
        return this.mOriginDownloadPriority;
    }

    public int getPreloadMode() {
        return this.mPreloadMode;
    }

    public void setAppid(String r100) {
        this.mAppId = r100;
    }

    public void setApptype(int r100) {
        this.mAppType = r100;
    }

    public void setBrandAppType(AppType r100) {
        this.brandAppType = r100;
    }

    public void setDownloadPriority(int r100) {
        if (r100 == 1) goto L7;
        if (r100 == 2) goto L7;
        if (r100 == 0) goto L7;
        r100 = 0;
    L7:
        this.mDownloadPriority = r100;
        this.mOriginDownloadPriority = r100;
        if (r100 == 2) goto L10;
        return;
    L10:
        if (isPreloadModeValid(this.mPreloadMode) == true) goto L14;
        this.mPreloadMode = 2;
        return;
    }

    public void setPreloadMode(int r100) {
        this.mPreloadMode = r100;
    }
}
