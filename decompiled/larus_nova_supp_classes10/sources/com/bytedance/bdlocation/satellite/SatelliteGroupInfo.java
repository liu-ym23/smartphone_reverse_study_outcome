package com.bytedance.bdlocation.satellite;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class SatelliteGroupInfo {

    @SerializedName("azimuth_degrees")
    public List<Float> azimuthDegrees;

    @SerializedName("carrier_frequency_hz")
    public List<Float> carrierFrequencyHz;

    @SerializedName("constellation_type")
    public List<Integer> constellationType;

    @SerializedName("elevation_degrees")
    public List<Float> elevationDegrees;

    @SerializedName("has_carrier_frequency_hz")
    public List<Boolean> hasCarrierFrequencyHz;

    @SerializedName("snr")
    public List<Float> snr;

    @SerializedName("svid")
    public List<Integer> svid;

    @SerializedName("used_in_fix")
    public List<Boolean> usedInFix;

    public SatelliteGroupInfo() {
    }
}
