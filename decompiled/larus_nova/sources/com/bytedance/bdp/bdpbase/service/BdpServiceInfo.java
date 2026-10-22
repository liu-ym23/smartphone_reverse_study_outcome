package com.bytedance.bdp.bdpbase.service;

/* JADX INFO: loaded from: classes11.dex */
public class BdpServiceInfo {
    private String desc;
    private Class<? extends IBdpService> service;

    public String getServiceName() {
        return this.service.getName();
    }

    public String toString() {
        return "BdpServiceInfo{name=" + this.service.getName() + ", desc='" + this.desc + "'}";
    }

    public String getDesc() {
        return this.desc;
    }

    public Class<? extends IBdpService> getService() {
        return this.service;
    }

    public BdpServiceInfo(Class<? extends IBdpService> r100) {
        this.service = r100;
    }

    public BdpServiceInfo setDesc(String r100) {
        this.desc = r100;
        return this;
    }
}
