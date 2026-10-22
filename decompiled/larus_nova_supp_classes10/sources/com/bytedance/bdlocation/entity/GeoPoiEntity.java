package com.bytedance.bdlocation.entity;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class GeoPoiEntity {

    @SerializedName("address")
    public String address;

    @SerializedName("area")
    public String area;

    @SerializedName("aweme_id")
    public String awemeId;

    @SerializedName("businessarea")
    public String businessArea;

    @SerializedName("distance")
    public Double distance;

    @SerializedName("id")
    public String id;

    @SerializedName(LocationMonitorConst.LOCATION)
    public String location;

    @SerializedName("name")
    public String name;

    @SerializedName("poiweight")
    public String poiWeight;

    @SerializedName("sid")
    public String sId;

    @SerializedName("source")
    public String source;

    @SerializedName("tel")
    public String tel;

    @SerializedName("typecode")
    public String typeCode;

    public GeoPoiEntity() {
    }
}
