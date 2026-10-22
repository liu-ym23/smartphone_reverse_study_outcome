package com.bytedance.bdlocation.network.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class ShakeUploadInfo {

    @SerializedName("ble_info_list")
    public JsonArray bleInfo;

    @SerializedName("busi_name")
    public String busiName;

    @SerializedName("extra")
    public JsonObject extra;

    @SerializedName("gps_info")
    public LocationInfo locationInfo;

    @SerializedName("subdivision_id")
    public long subdivisionId;

    @SerializedName("timestamp")
    public long timeStamp;

    @SerializedName("wifi_info_list")
    public JsonArray wifiInfo;

    public ShakeUploadInfo() {
    }
}
