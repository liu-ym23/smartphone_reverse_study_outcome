package com.bytedance.bdlocation.scan.bluetooth;

import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
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

    @SerializedName(LocationMonitorConst.TIMESTAMP)
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
    public int compareTo2(BDBleInfo r5) {
        if (Boolean.compare(r5.isBeacon, this.isBeacon) != 0) goto L15;
        if (Boolean.compare(!TextUtils.isEmpty(r5.rawData), !TextUtils.isEmpty(this.rawData)) != 0) goto L13;
        int r0 = r5.rssi;
        int r1 = this.rssi;
        if (r0 != r1) goto L11;
        return Boolean.compare(!TextUtils.isEmpty(r5.bleName), !TextUtils.isEmpty(this.bleName));
    L11:
        return Long.compare(r0, r1);
    L13:
        return Boolean.compare(!TextUtils.isEmpty(r5.rawData), !TextUtils.isEmpty(this.rawData));
    L15:
        return Boolean.compare(r5.isBeacon, this.isBeacon);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L18:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L18;
        String r2 = this.bleMac;
        String r6 = ((BDBleInfo) r5).bleMac;
        if (r2 == r6) goto L19;
        if (r2 != null) goto L14;
    L16:
        return false;
    L14:
        if (r2.equals(r6) == false) goto L16;
        return true;
    L19:
        return true;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(BDBleInfo r1) {
        return compareTo2(r1);
    }
}
