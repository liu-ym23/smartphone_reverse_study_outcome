package com.ss.bytertc.engine;

/* JADX INFO: loaded from: classes40.dex */
public class InternalNetworkQualityInfo {
    public double fractionLost;
    public int rtt;
    public int rxNetQuality;
    public int totalBandwidth;
    public int txNetQuality;
    public String uid;

    public String toString() {
        return "uid=" + this.uid + ",fractionLost=" + this.fractionLost + ",rtt=" + this.rtt + ",totalBandwidth=" + this.totalBandwidth + ",txNetQuality=" + this.txNetQuality + ",rxNetQuality=" + this.rxNetQuality;
    }

    public InternalNetworkQualityInfo(double r100, int r101, int r102, int r103, int r104) {
        this.uid = "";
        this.fractionLost = r100;
        this.rtt = r101;
        this.totalBandwidth = r102;
        this.txNetQuality = r103;
        this.rxNetQuality = r104;
    }

    public InternalNetworkQualityInfo(String r100, double r101, int r102, int r103, int r104, int r105) {
        this.uid = r100;
        this.fractionLost = r101;
        this.rtt = r102;
        this.totalBandwidth = r103;
        this.txNetQuality = r104;
        this.rxNetQuality = r105;
    }

    private static InternalNetworkQualityInfo create(String r100, double r110, int r111, int r112, int r113, int r114) {
        return new InternalNetworkQualityInfo(r100, r110, r111, r112, r113, r114);
    }
}
