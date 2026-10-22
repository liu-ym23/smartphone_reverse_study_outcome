package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class PlaceInfo {

    @SerializedName("ASCIName")
    public String asciName;

    @SerializedName("Code")
    public String code;

    @SerializedName("GeoNameID")
    public long geoNameID;

    @SerializedName("LocalID")
    public String localID;

    @SerializedName("MetropolitanCode")
    public String metropolitanCode;

    @SerializedName("Name")
    public String name;

    public PlaceInfo() {
    }

    public String toString() {
        return "PlaceInfo{code='" + this.code + "', geoNameID=" + this.geoNameID + ", asciName='" + this.asciName + "', name='" + this.name + "', localID='" + this.localID + "', metropolitanCode='" + this.metropolitanCode + "'}";
    }
}
