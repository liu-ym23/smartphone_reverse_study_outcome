package com.bytedance.bdlocation.network.model;

import androidx.core.location.LocationCompat;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class InputSystemGpsInfo {

    @SerializedName("bearing")
    public float bearing;

    @SerializedName(LocationCompat.EXTRA_BEARING_ACCURACY)
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

    @SerializedName(LocationCompat.EXTRA_SPEED_ACCURACY)
    public float speedAccuracy;

    @SerializedName("timestampMs")
    public long timestampMs;

    public InputSystemGpsInfo() {
    }
}
