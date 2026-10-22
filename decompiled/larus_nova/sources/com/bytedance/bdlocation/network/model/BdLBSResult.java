package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class BdLBSResult {

    @SerializedName("BaseResp")
    public BaseResp baseResp;

    @SerializedName("DeviceIdLocation")
    public LocationResult deviceIdLocation;

    @SerializedName("GPSLocation")
    public LocationResult gpsLocation;

    @SerializedName("IPLocation")
    public LocationResult ipLocation;

    @SerializedName("Location")
    public LocationResult location;

    @SerializedName("UserSelectedLocation")
    public LocationResult userSelectedLocation;

    public BdLBSResult() {
    }

    public String toString() {
        return "BdLBSResult{location=" + this.location + ", ipLocation=" + this.ipLocation + ", deviceIdLocation=" + this.deviceIdLocation + ", userSelectedLocation=" + this.userSelectedLocation + ", gpsLocation=" + this.gpsLocation + ", baseResp=" + this.baseResp + '}';
    }
}
