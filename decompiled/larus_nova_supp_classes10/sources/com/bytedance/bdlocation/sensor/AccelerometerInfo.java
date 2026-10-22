package com.bytedance.bdlocation.sensor;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class AccelerometerInfo {

    @SerializedName("timestamp_ms")
    public long timestampMs;

    @SerializedName("x")
    public double x;

    @SerializedName("y")
    public double y;

    @SerializedName("z")
    public double z;

    public AccelerometerInfo() {
    }
}
