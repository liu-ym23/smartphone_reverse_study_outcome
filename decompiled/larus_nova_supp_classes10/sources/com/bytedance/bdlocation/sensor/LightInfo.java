package com.bytedance.bdlocation.sensor;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LightInfo {

    @SerializedName("light_value")
    public float lightValue;

    @SerializedName(LocationMonitorConst.TIMESTAMP)
    public long timestamp;

    public LightInfo() {
    }
}
