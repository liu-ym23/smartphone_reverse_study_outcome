package com.bytedance.bdlocation.scan.gps;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class BDSatelliteInfo {

    @SerializedName("azimuth_degrees")
    public float azimuthDegrees;

    @SerializedName("carrier_frequency_hz")
    public float carrierFrequencyHz;

    @SerializedName("constellation_type")
    public int constellationType;

    @SerializedName("elevation_degrees")
    public float elevationDegrees;

    @SerializedName("has_carrier_frequency_hz")
    public boolean hasCarrierFrequencyHz;

    @SerializedName("svid")
    public int sVid;

    @SerializedName("snr")
    public float snr;

    @SerializedName("used_in_fix")
    public boolean usedInFix;

    public BDSatelliteInfo() {
    }
}
