package com.bytedance.dora.protocol.jni_entity;

/* JADX INFO: loaded from: classes15.dex */
public class DoraGBtLinkStatus {
    public int _3dh5Rate;
    public int a2dpState;
    public int hfpState;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f204662id;
    public int packetLost;
    public int rssi;
    public int sniffState;
    public int txPower;

    public String toString() {
        return "DoraGBtLinkStatus{id=" + this.f204662id + ", rssi=" + this.rssi + ", txPower=" + this.txPower + ", packetLost=" + this.packetLost + ", sniffState=" + this.sniffState + ", a2dpState=" + this.a2dpState + ", hfpState=" + this.hfpState + ", _3dh5Rate=" + this._3dh5Rate + '}';
    }

    public DoraGBtLinkStatus(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107) {
        this.f204662id = r100;
        this.rssi = r101;
        this.txPower = r102;
        this.packetLost = r103;
        this.sniffState = r104;
        this.a2dpState = r105;
        this.hfpState = r106;
        this._3dh5Rate = r107;
    }
}
