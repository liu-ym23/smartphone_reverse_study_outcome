package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BaseStation {
    public long baseStationGap;

    @SerializedName("current")
    public BssInfo current;

    @SerializedName("neighboring")
    public List<BssInfo> neighboring;

    public BaseStation() {
    }
}
