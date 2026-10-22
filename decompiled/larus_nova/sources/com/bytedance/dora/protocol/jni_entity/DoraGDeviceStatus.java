package com.bytedance.dora.protocol.jni_entity;

/* JADX INFO: loaded from: classes15.dex */
public class DoraGDeviceStatus {
    public int accessMode;
    public int ar1WifiState;
    public int bleAdvState;
    public int btLinkNum;
    public int cpuload;
    public DoraGBtLinkStatus currBtLinkStatus;
    public DoraGBtLinkStatus nextBtLinkStatus;
    public long obsInterval;
    public int obsSubmode;
    public int pltUplinkLossRate;
    public int vuiMode;

    public String toString() {
        return "DoraGDeviceStatus{cpuload=" + this.cpuload + ", vuiMode=" + this.vuiMode + ", pltUplinkLossRate=" + this.pltUplinkLossRate + ", ar1WifiState=" + this.ar1WifiState + ", bleAdvState=" + this.bleAdvState + ", accessMode=" + this.accessMode + ", btLinkNum=" + this.btLinkNum + ", currBtLinkStatus=" + this.currBtLinkStatus + ", nextBtLinkStatus=" + this.nextBtLinkStatus + ", obsSubmode=" + this.obsSubmode + ", obsInterval=" + this.obsInterval + '}';
    }

    public DoraGDeviceStatus(int r100, int r101, int r102, int r103, int r104, int r105, int r106, DoraGBtLinkStatus r107, DoraGBtLinkStatus r108, int r110, long r111) {
        this.cpuload = r100;
        this.vuiMode = r101;
        this.pltUplinkLossRate = r102;
        this.ar1WifiState = r103;
        this.bleAdvState = r104;
        this.accessMode = r105;
        this.btLinkNum = r106;
        this.currBtLinkStatus = r107;
        this.nextBtLinkStatus = r108;
        this.obsSubmode = r110;
        this.obsInterval = r111;
    }
}
