package com.ss.android.download.api.clean;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes34.dex */
public class ApkInfo {
    private String mAppName;
    private Drawable mIcon;
    private String mPackageName;
    private String mVersion;

    public ApkInfo() {
    }

    public String getAppName() {
        return this.mAppName;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public void setAppName(String r100) {
        this.mAppName = r100;
    }

    public void setIcon(Drawable r100) {
        this.mIcon = r100;
    }

    public void setPackageName(String r100) {
        this.mPackageName = r100;
    }

    public void setVersion(String r100) {
        this.mVersion = r100;
    }
}
