package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.entity.GeoPoiEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class Place {

    @SerializedName("AddressLines")
    public List<String> addressLines;

    @SerializedName("AdminArea")
    public String adminArea;

    @SerializedName("AreasOfInterest")
    public List<String> areasOfInterest;

    @SerializedName("FeatureCode")
    public String featureCode;

    @SerializedName("aoi")
    public List<GeoPoiEntity> geoAoiList;

    @SerializedName("FormattedAddress")
    public String geoFormattedAddress;

    @SerializedName("GeoNameID")
    public String geoNameID;

    @SerializedName("poi")
    public List<GeoPoiEntity> geoPoiList;

    @SerializedName("Locality")
    public String locality;

    @SerializedName("Name")
    public String name;

    @SerializedName("PostalCode")
    public String postalCode;

    @SerializedName("SubAdminArea")
    public String subAdminArea;

    @SerializedName("SubLocality")
    public String subLocality;

    @SerializedName("SubThoroughfare")
    public String subThoroughfare;

    @SerializedName("TimeZone")
    public String timeZone;

    public Place() {
    }

    public String toString() {
        return "Place{addressLines=" + this.addressLines + ", adminArea='" + this.adminArea + "', name='" + this.name + "', areasOfInterest='" + this.areasOfInterest + "', subAdminArea='" + this.subAdminArea + "', locality='" + this.locality + "', subLocality='" + this.subLocality + "', subThoroughfare='" + this.subThoroughfare + "', postalCode='" + this.postalCode + "', featureCode='" + this.featureCode + "', geoNameID='" + this.geoNameID + "', timeZone='" + this.timeZone + "', geoAoiList='" + this.geoAoiList + "', geoPoiList='" + this.geoPoiList + "', geoFormattedAddress='" + this.geoFormattedAddress + "'}";
    }
}
