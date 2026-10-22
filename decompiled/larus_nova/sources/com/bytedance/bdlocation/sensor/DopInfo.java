package com.bytedance.bdlocation.sensor;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class DopInfo {

    @SerializedName("hdop")
    public double hdop;

    @SerializedName("pdop")
    public double pdop;

    @SerializedName("timestamp_ms")
    public long timestampMs;

    @SerializedName("vdop")
    public double vdop;

    public DopInfo() {
    }
}
