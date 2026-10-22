package com.bytedance.bdlocation.network.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class WifiInfo implements Comparable<WifiInfo> {

    @SerializedName("frequency")
    public long frequency;

    @SerializedName("is_current")
    public int isCurrent;

    @SerializedName("rssi")
    public long rssi;

    @SerializedName("Timestamp")
    public long timeStamp;

    @SerializedName("wifi_mac")
    public String wifiMac;

    @SerializedName("wifi_name")
    public String wifiName;

    public WifiInfo() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(WifiInfo r5) {
        return Long.compare(r5.rssi, this.rssi);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(WifiInfo r1) {
        return compareTo2(r1);
    }
}
