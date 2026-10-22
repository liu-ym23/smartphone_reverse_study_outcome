package com.bytedance.bdlocation.scan.gps;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BDGnssInfo {

    @SerializedName("callback_clock")
    public long callbackClock;

    @SerializedName("satellite_info")
    public List<BDSatelliteInfo> satelliteInfos;

    @SerializedName("satellite_num")
    public int satelliteNum;

    @SerializedName("snr")
    public List<Float> snr;

    @SerializedName("timestamp")
    public long timestamp;

    public BDGnssInfo() {
    }
}
