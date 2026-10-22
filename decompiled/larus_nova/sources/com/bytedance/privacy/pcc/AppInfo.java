package com.bytedance.privacy.pcc;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class AppInfo {

    @SerializedName("app_id")
    public final String appId;

    @SerializedName("app_svc_id")
    public final String appSvcId;
    public final String rpdid;
    public final String rpuid;

    public String toJsonString() {
        return GsonProtectorUtils.toJson(new Gson(), this);
    }

    public String toString() {
        return toJsonString();
    }

    public AppInfo(String r100, String r101, String r102, String r103) {
        this.rpdid = r100;
        this.rpuid = r101;
        this.appId = r102;
        this.appSvcId = r103;
    }
}
