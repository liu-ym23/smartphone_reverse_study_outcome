package com.facebook.battery.metrics.network;

import com.facebook.battery.metrics.core.SystemMetrics;

/* JADX INFO: loaded from: classes22.dex */
public class NetworkMetrics extends SystemMetrics<NetworkMetrics> {
    public long mobileBytesRx;
    public long mobileBytesTx;
    public long wifiBytesRx;
    public long wifiBytesTx;

    public int hashCode() {
        long r100 = this.mobileBytesTx;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.mobileBytesRx;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.wifiBytesTx;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.wifiBytesRx;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    }

    public String toString() {
        return "NetworkMetrics{mobileBytesTx=" + this.mobileBytesTx + ", mobileBytesRx=" + this.mobileBytesRx + ", wifiBytesTx=" + this.wifiBytesTx + ", wifiBytesRx=" + this.wifiBytesRx + '}';
    }

    public NetworkMetrics() {
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        NetworkMetrics r101 = (NetworkMetrics) r100;
        if (this.mobileBytesTx == r101.mobileBytesTx) goto L13;
    L19:
        return false;
    L13:
        if (this.mobileBytesRx != r101.mobileBytesRx) goto L19;
        if (this.wifiBytesTx != r101.wifiBytesTx) goto L19;
        if (this.wifiBytesRx != r101.wifiBytesRx) goto L19;
        return true;
    }

    public NetworkMetrics set(NetworkMetrics r100) {
        this.mobileBytesRx = r100.mobileBytesRx;
        this.mobileBytesTx = r100.mobileBytesTx;
        this.wifiBytesRx = r100.wifiBytesRx;
        this.wifiBytesTx = r100.wifiBytesTx;
        return this;
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics set(SystemMetrics r100) {
        return set((NetworkMetrics) r100);
    }

    public NetworkMetrics diff(NetworkMetrics r100, NetworkMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new NetworkMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.mobileBytesTx = this.mobileBytesTx - r100.mobileBytesTx;
        r101.mobileBytesRx = this.mobileBytesRx - r100.mobileBytesRx;
        r101.wifiBytesTx = this.wifiBytesTx - r100.wifiBytesTx;
        r101.wifiBytesRx = this.wifiBytesRx - r100.wifiBytesRx;
        goto L7
    }

    public NetworkMetrics sum(NetworkMetrics r100, NetworkMetrics r101) {
        if (r101 != null) goto L4;
        r101 = new NetworkMetrics();
    L4:
        if (r100 != null) goto L6;
        r101.set(this);
    L7:
        return r101;
    L6:
        r101.mobileBytesTx = this.mobileBytesTx + r100.mobileBytesTx;
        r101.mobileBytesRx = this.mobileBytesRx + r100.mobileBytesRx;
        r101.wifiBytesTx = this.wifiBytesTx + r100.wifiBytesTx;
        r101.wifiBytesRx = this.wifiBytesRx + r100.wifiBytesRx;
        goto L7
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics diff(SystemMetrics r100, SystemMetrics r101) {
        return diff((NetworkMetrics) r100, (NetworkMetrics) r101);
    }

    @Override // com.facebook.battery.metrics.core.SystemMetrics
    public /* bridge */ /* synthetic */ SystemMetrics sum(SystemMetrics r100, SystemMetrics r101) {
        return sum((NetworkMetrics) r100, (NetworkMetrics) r101);
    }
}
