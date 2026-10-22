package com.bytedance.bdlocation.sensor;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class AccelerometerGroupInfo {

    @SerializedName("timestamp_ms")
    public List<Long> timestampMs;

    @SerializedName("x")
    public List<Integer> x;

    @SerializedName("y")
    public List<Integer> y;

    @SerializedName("z")
    public List<Integer> z;

    public AccelerometerGroupInfo() {
    }
}
