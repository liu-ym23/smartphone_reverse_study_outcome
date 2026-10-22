package com.bytedance.bdlocation.scan.bluetooth;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class BDBleInfo implements Comparable<BDBleInfo> {

    @SerializedName("beacon_uuid")
    public String beaconUuid;

    @SerializedName("ble_mac")
    public String bleMac;

    @SerializedName("ble_name")
    public String bleName;

    @SerializedName("is_beacon")
    public boolean isBeacon;

    @SerializedName("major")
    public int major;

    @SerializedName("minor")
    public int minor;

    @SerializedName("beacon_data")
    public String rawData;

    @SerializedName("rssi")
    public int rssi;

    @SerializedName("timestamp")
    public long timeStamp;

    public int hashCode() {
        return Arrays.hashCode(new String[]{this.bleMac});
    }

    public String toString() {
        return "BDBleInfo{bleName='" + this.bleName + "', bleMac='" + this.bleMac + "', major=" + this.major + ", minor=" + this.minor + ", beaconUuid='" + this.beaconUuid + "', rssi=" + this.rssi + ", isBeacon=" + this.isBeacon + ", rawData='" + this.rawData + "', timeStamp=" + this.timeStamp + '}';
    }

    public BDBleInfo() {
        this.bleName = "";
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(BDBleInfo r100) {
        if (Boolean.compare(r100.isBeacon, this.isBeacon) != 0) goto L15;
        if (Boolean.compare(!TextUtils.isEmpty(r100.rawData), !TextUtils.isEmpty(this.rawData)) != 0) goto L13;
        int r101 = r100.rssi;
        int r102 = this.rssi;
        if (r101 != r102) goto L11;
        return Boolean.compare(!TextUtils.isEmpty(r100.bleName), !TextUtils.isEmpty(this.bleName));
    L11:
        return Long.compare(r101, r102);
    L13:
        return Boolean.compare(!TextUtils.isEmpty(r100.rawData), !TextUtils.isEmpty(this.rawData));
    L15:
        return Boolean.compare(r100.isBeacon, this.isBeacon);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L18;
        String r101 = this.bleMac;
        String r102 = ((BDBleInfo) r100).bleMac;
        if (r101 == r102) goto L19;
        if (r101 != null) goto L14;
    L16:
        return false;
    L14:
        if (r101.equals(r102) == false) goto L16;
        return true;
    L19:
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BDBleInfo r100) {
        return compareTo2(r100);
    }
}
