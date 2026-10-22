package com.bytedance.bdlocation.scan.wifi;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class BDWifiInfo {

    @SerializedName("BSSID")
    private String bssid;

    @SerializedName("channel")
    private int channel;

    @SerializedName("isCurrent")
    private boolean isCurrent;

    @SerializedName("RSSI")
    private int rssi;

    @SerializedName("SSID")
    private String ssid;

    @SerializedName("Timestamp")
    private long timeStamp;

    public BDWifiInfo() {
    }

    public int hashCode() {
        String r0 = this.bssid;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "WifiInfo{bssid='" + this.bssid + "', channel='" + this.channel + "', isCurrent=" + this.isCurrent + ", rssi=" + this.rssi + ", ssid='" + this.ssid + "', timeStamp='" + this.timeStamp + "'}";
    }

    public String getBssid() {
        return this.bssid;
    }

    public int getChannel() {
        return this.channel;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSsid() {
        return this.ssid;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isCurrent() {
        return this.isCurrent;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        String r2 = this.bssid;
        String r6 = ((BDWifiInfo) r5).bssid;
        if (r2 != null) goto L18;
        if (r6 == null) goto L19;
        return false;
    L19:
        return true;
    L18:
        return r2.equals(r6);
    }

    public BDWifiInfo setBssid(String r1) {
        this.bssid = r1;
        return this;
    }

    public BDWifiInfo setChannel(int r1) {
        this.channel = r1;
        return this;
    }

    public BDWifiInfo setCurrent(boolean r1) {
        this.isCurrent = r1;
        return this;
    }

    public BDWifiInfo setRssi(int r1) {
        this.rssi = r1;
        return this;
    }

    public BDWifiInfo setSsid(String r1) {
        this.ssid = r1;
        return this;
    }

    public void setTimeStamp(long r1) {
        this.timeStamp = r1;
    }
}
