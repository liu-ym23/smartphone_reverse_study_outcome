package com.ss.android.download.api.clean;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ApkCleanFile extends CleanFolder {
    public static final String APK_CLEAN_FILE = "apk_clean_file";
    private ApkInfo mApkInfo;

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile
    public String getClassifyType() {
        return APK_CLEAN_FILE;
    }

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.BaseCleanItem
    public String getName() {
        ApkInfo r100 = this.mApkInfo;
        if (r100 == null) goto L9;
        if (TextUtils.isEmpty(r100.getAppName()) == true) goto L9;
        return this.mApkInfo.getAppName();
    L9:
        return super.getName();
    }

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public JSONObject toJson() {
        return super.toJson();
    }

    public ApkCleanFile() {
    }

    public ApkInfo getApkInfo() {
        return this.mApkInfo;
    }

    @Override // com.ss.android.download.api.clean.CleanFolder, com.ss.android.download.api.clean.CleanFile, com.ss.android.download.api.clean.BaseCleanItem, com.ss.android.download.api.clean.IJsonable
    public void parse(JSONObject r100) {
        super.parse(r100);
    }

    public void setApkInfo(ApkInfo r100) {
        this.mApkInfo = r100;
    }
}
