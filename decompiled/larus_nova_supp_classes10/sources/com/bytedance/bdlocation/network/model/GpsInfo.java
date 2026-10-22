package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class GpsInfo {

    @SerializedName("address")
    public String address;

    @SerializedName("city")
    public String city;

    @SerializedName("coordinateSystem")
    public String coordinateSystem;

    @SerializedName("country")
    public String country;

    @SerializedName("district")
    public String district;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("loc_time")
    public long locationTime;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("provider")
    public String provider;

    @SerializedName("province")
    public String province;

    @SerializedName("source")
    public int source;

    public GpsInfo() {
    }
}
