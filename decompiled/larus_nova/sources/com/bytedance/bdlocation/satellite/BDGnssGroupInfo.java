package com.bytedance.bdlocation.satellite;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class BDGnssGroupInfo {

    @SerializedName("callback_clock")
    public long callbackClock;

    @SerializedName("satellite_info")
    public SatelliteGroupInfo satelliteInfo;

    @SerializedName("satellite_num")
    public int satelliteNum;

    @SerializedName("timestamp")
    public long timestamp;

    public BDGnssGroupInfo() {
    }
}
