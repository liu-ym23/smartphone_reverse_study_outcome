package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class RegionInfo {

    @SerializedName("carrier_region")
    public String carrierRegion;

    @SerializedName("locale")
    public String locale;

    @SerializedName("mcc_mnc")
    public String mccmnc;

    @SerializedName("network_sim_region")
    public String networkSimRegion;

    @SerializedName("system_language")
    public String systemLanguage;

    @SerializedName("system_region")
    public String systemRegion;

    public RegionInfo() {
    }
}
