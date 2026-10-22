package com.bytedance.bdlocation.sensor;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class BarometerGroupInfo {

    @SerializedName("pressure_pa")
    public List<Integer> pressureHpa;

    @SerializedName("timestamp_ms")
    public List<Long> timestampMs;

    public BarometerGroupInfo() {
    }
}
