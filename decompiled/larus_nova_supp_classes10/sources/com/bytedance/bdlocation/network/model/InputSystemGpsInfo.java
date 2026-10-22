package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class InputSystemGpsInfo {

    @SerializedName("bearing")
    public float bearing;

    @SerializedName("bearingAccuracy")
    public float bearingAccuracy;

    @SerializedName("lat")
    public double lat;

    @SerializedName("locationAccuracy")
    public float locationAccuracy;

    @SerializedName("lon")
    public double lon;

    @SerializedName("sourceType")
    public int sourceType;

    @SerializedName("speed")
    public float speed;

    @SerializedName("speedAccuracy")
    public float speedAccuracy;

    @SerializedName("timestampMs")
    public long timestampMs;

    public InputSystemGpsInfo() {
    }
}
