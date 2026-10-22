package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.entity.PoiInfoEntity;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class LocationResult {

    @SerializedName("AoiInfos")
    public List<PoiInfoEntity> aoiList;

    @SerializedName("City")
    public PlaceInfo city;

    @SerializedName("Continent")
    public PlaceInfo continent;

    @SerializedName("Country")
    public PlaceInfo country;

    @SerializedName("District")
    public PlaceInfo district;

    @SerializedName("Extra")
    public JsonObject extra;

    @SerializedName("GPS")
    public GPSResult gps;

    @SerializedName("IsDisputed")
    public boolean isDisputed;

    @SerializedName("ISP")
    public String isp;

    @SerializedName("LocateMethod")
    public String locateMethod;

    @SerializedName("Place")
    public Place place;

    @SerializedName("PoiInfos")
    public List<PoiInfoEntity> poiList;

    @SerializedName("Subdivisions")
    public PlaceInfo[] subdivisions;

    @SerializedName("Timestamp")
    public long timestamp;

    @SerializedName("Town")
    public RuralInfo town;

    @SerializedName("Village")
    public RuralInfo village;

    public LocationResult() {
    }

    public String toString() {
        return "LocationResult{continent=" + this.continent + ", country=" + this.country + ", subdivisions=" + Arrays.toString(this.subdivisions) + ", city=" + this.city + ", district=" + this.district + ", place=" + this.place + ", gps=" + this.gps + ", isp='" + this.isp + "', locateMethod='" + this.locateMethod + "', isDisputed='" + this.isDisputed + "', timestamp='" + this.timestamp + "', town'" + this.town + "', PoiInfos'" + this.poiList + "', AoiInfos'" + this.aoiList + "'}";
    }
}
