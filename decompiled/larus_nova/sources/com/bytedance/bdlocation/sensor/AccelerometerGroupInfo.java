package com.bytedance.bdlocation.sensor;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class AccelerometerGroupInfo {

    @SerializedName("timestamp_ms")
    public List<Long> timestampMs;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    public List<Integer> f199916x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    public List<Integer> f199917y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
    public List<Integer> f199918z;

    public AccelerometerGroupInfo() {
    }
}
