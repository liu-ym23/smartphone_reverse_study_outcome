package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class RuralInfo {

    @SerializedName("ASCIName")
    public String asciName;

    @SerializedName("Code")
    public String code;

    @SerializedName("GeoNameID")
    public long geoNameID;

    @SerializedName("LocalID")
    public String localID;

    @SerializedName("Name")
    public String name;

    public RuralInfo() {
    }

    public String toString() {
        return "Town{code=" + this.code + "', geoNameID='" + this.geoNameID + "', asciName='" + this.asciName + "', name='" + this.name + "', localID='" + this.localID + "'}";
    }
}
