package com.bytedance.bdlocation.sensor;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class LightGroupInfo {

    @SerializedName("lux")
    public List<Double> lux;

    @SerializedName("timestamp_ms")
    public List<Long> timestampMs;

    public LightGroupInfo() {
    }
}
