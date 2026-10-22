package com.bytedance.bdlocation.entity;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LogIdCacheEntity {

    @SerializedName("log_id")
    public String logId;

    @SerializedName(LocationMonitorConst.TIMESTAMP)
    public long timestamp;

    public LogIdCacheEntity() {
    }
}
