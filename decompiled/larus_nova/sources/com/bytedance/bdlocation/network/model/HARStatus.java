package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class HARStatus {

    @SerializedName("predict")
    public Map<String, Float> predict;

    @SerializedName("timestamp")
    public long timestamp;

    public HARStatus() {
    }
}
