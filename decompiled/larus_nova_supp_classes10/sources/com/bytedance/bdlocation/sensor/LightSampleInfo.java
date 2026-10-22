package com.bytedance.bdlocation.sensor;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LightSampleInfo {

    @SerializedName("lux")
    public double lux;

    @SerializedName("timestamp_ms")
    public long timestampMs;

    public LightSampleInfo() {
    }
}
