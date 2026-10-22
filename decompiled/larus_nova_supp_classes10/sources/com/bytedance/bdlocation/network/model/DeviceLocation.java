package com.bytedance.bdlocation.network.model;

import com.bytedance.bdlocation.sensor.LightInfo;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class DeviceLocation {

    @SerializedName("amap_location")
    public LocationInfo aMapLocation;

    @SerializedName("base_station")
    public BaseStation baseLocation;

    @SerializedName("light_info_list")
    public List<LightInfo> lightInfoList;
    public transient JsonObject liveStallReport;

    @SerializedName("location_strategy")
    public String locationMode;

    @SerializedName("sys_location")
    public LocationInfo sysLocation;

    @SerializedName("wifi_info_list")
    public JsonArray wifiInfo;

    public DeviceLocation() {
    }
}
