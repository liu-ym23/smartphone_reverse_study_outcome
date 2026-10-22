package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BaseResp {

    @SerializedName("StatusCode")
    public int statusCode;

    @SerializedName("StatusMessage")
    public String statusMessage;

    public BaseResp() {
    }

    public String toString() {
        return "BaseResp{statusMessage='" + this.statusMessage + "', statusCode=" + this.statusCode + '}';
    }
}
