package com.ss.bytertc.engine.type;

import com.ss.bytertc.engine.InternalNetworkQualityInfo;

/* JADX INFO: loaded from: classes40.dex */
public class NetworkQualityStats {
    public double fractionLost;
    public int rtt;
    public int rxQuality;
    public int totalBandwidth;
    public int txQuality;
    public String uid;

    public String toString() {
        return "uid=" + this.uid + ",fractionLost=" + this.fractionLost + ",rtt=" + this.rtt + ",totalBandwidth=" + this.totalBandwidth + ",txQuality=" + this.txQuality + ",rxQuality=" + this.rxQuality;
    }

    public NetworkQualityStats(InternalNetworkQualityInfo r100) {
        this.uid = r100.uid;
        this.fractionLost = r100.fractionLost;
        this.rtt = r100.rtt;
        this.totalBandwidth = r100.totalBandwidth;
        this.txQuality = r100.txNetQuality;
        this.rxQuality = r100.rxNetQuality;
    }

    public NetworkQualityStats(String r100, double r101, int r102, int r103, int r104, int r105) {
        this.uid = r100;
        this.fractionLost = r101;
        this.rtt = r102;
        this.totalBandwidth = r103;
        this.txQuality = r104;
        this.rxQuality = r105;
    }
}
