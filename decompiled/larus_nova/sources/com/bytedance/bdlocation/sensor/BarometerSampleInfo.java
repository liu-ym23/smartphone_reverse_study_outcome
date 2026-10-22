package com.bytedance.bdlocation.sensor;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class BarometerSampleInfo {

    @SerializedName("pressure_pa")
    public double pressureHpa;

    @SerializedName("timestamp_ms")
    public long timestampMs;

    public BarometerSampleInfo() {
    }
}
