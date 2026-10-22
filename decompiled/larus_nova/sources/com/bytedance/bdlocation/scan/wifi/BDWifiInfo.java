package com.bytedance.bdlocation.scan.wifi;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
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
        String r100 = this.bssid;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
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

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L17;
        String r101 = this.bssid;
        String r102 = ((BDWifiInfo) r100).bssid;
        if (r101 != null) goto L18;
        if (r102 == null) goto L19;
        return false;
    L19:
        return true;
    L18:
        return r101.equals(r102);
    }

    public BDWifiInfo setBssid(String r100) {
        this.bssid = r100;
        return this;
    }

    public BDWifiInfo setChannel(int r100) {
        this.channel = r100;
        return this;
    }

    public BDWifiInfo setCurrent(boolean r100) {
        this.isCurrent = r100;
        return this;
    }

    public BDWifiInfo setRssi(int r100) {
        this.rssi = r100;
        return this;
    }

    public BDWifiInfo setSsid(String r100) {
        this.ssid = r100;
        return this;
    }

    public void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }
}
