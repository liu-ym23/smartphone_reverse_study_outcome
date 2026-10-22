package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class RegionCountry {

    @SerializedName("ASCIName")
    public String asciName;

    @SerializedName("Code")
    public String code;

    @SerializedName("GeoNameID")
    public String geoNameID;

    @SerializedName("Name")
    public String name;

    public RegionCountry() {
    }

    public String toString() {
        return "RegionCountry{code='" + this.code + "', geoNameID=" + this.geoNameID + ", asciName='" + this.asciName + "', name='" + this.name + "'}";
    }
}
