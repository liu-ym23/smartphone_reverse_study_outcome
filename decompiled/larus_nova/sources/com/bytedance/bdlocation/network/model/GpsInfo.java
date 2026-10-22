package com.bytedance.bdlocation.network.model;

import com.amap.api.services.district.DistrictSearchQuery;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;

/* JADX INFO: loaded from: classes10.dex */
public class GpsInfo {

    @SerializedName("address")
    public String address;

    @SerializedName("city")
    public String city;

    @SerializedName("coordinateSystem")
    public String coordinateSystem;

    @SerializedName(DistrictSearchQuery.KEYWORDS_COUNTRY)
    public String country;

    @SerializedName(DistrictSearchQuery.KEYWORDS_DISTRICT)
    public String district;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("loc_time")
    public long locationTime;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName(ShortVideoSegments.KEY_PROP_PROVIDER)
    public String provider;

    @SerializedName("province")
    public String province;

    @SerializedName("source")
    public int source;

    public GpsInfo() {
    }
}
