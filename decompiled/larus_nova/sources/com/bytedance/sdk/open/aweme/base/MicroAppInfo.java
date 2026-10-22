package com.bytedance.sdk.open.aweme.base;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes22.dex */
public class MicroAppInfo {

    @SerializedName("appId")
    private String appId;

    @SerializedName("appTitle")
    private String appTitle;

    @SerializedName("appUrl")
    private String appUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("open_platform_third_app_schema")
    private String thirdAppSchema;

    public MicroAppInfo() {
    }

    public static MicroAppInfo unserialize(Bundle r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getString(ParamKeyConstants.ShareParams.SHARE_MICROAPP_INFO);
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        return null;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        return (MicroAppInfo) GsonProtectorUtils.fromJson(new Gson(), r101, MicroAppInfo.class);
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppTitle() {
        return this.appTitle;
    }

    public String getAppUrl() {
        return this.appUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public String getThirdAppSchema() {
        return this.thirdAppSchema;
    }

    public void serialize(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.putString(ParamKeyConstants.ShareParams.SHARE_MICROAPP_INFO, GsonProtectorUtils.toJson(new Gson(), this));
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setAppTitle(String r100) {
        this.appTitle = r100;
    }

    public void setAppUrl(String r100) {
        this.appUrl = r100;
    }

    public void setDescription(String r100) {
        this.description = r100;
    }

    public void setThirdAppSchema(String r100) {
        this.thirdAppSchema = r100;
    }
}
