package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class HARStatus {

    @SerializedName("predict")
    public Map<String, Float> predict;

    @SerializedName(LocationMonitorConst.TIMESTAMP)
    public long timestamp;

    public HARStatus() {
    }
}
