package com.bytedance.bdlocation.network.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class GnssSettingResp {

    @SerializedName("traceroute")
    public JsonObject traceroute;

    public GnssSettingResp() {
    }

    public String toString() {
        return "GnssSettingResp{traceroute=" + this.traceroute + '}';
    }
}
