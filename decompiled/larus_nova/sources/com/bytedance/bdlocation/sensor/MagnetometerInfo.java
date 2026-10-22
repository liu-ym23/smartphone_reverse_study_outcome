package com.bytedance.bdlocation.sensor;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class MagnetometerInfo {

    @SerializedName("timestamp_ms")
    public long timestampMs;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    public double f199934x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    public double f199935y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @SerializedName(MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z)
    public double f199936z;

    public MagnetometerInfo() {
    }
}
