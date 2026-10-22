package com.bytedance.bdp.bdpbase.service;

/* JADX INFO: loaded from: classes3.dex */
public class BdpServiceImplInfo {
    private static final String TAG = "BdpServiceImplInfo";
    private final IBdpService bdpServiceImpl;
    private final Class<? extends IBdpService> bdpServiceImplClass;
    private final int priority;

    public String getServiceName() {
        return this.bdpServiceImplClass.getName();
    }

    public String toString() {
        return "BdpServiceImplInfo{bdpServiceImpl=" + this.bdpServiceImplClass + ", priority=" + this.priority + '}';
    }

    public int getPriority() {
        return this.priority;
    }

    public Class<?> getService() {
        return this.bdpServiceImplClass;
    }

    public IBdpService getServiceImpl() {
        return this.bdpServiceImpl;
    }

    public BdpServiceImplInfo(Class<? extends IBdpService> r100, int r101) {
        this(r100, r101, null);
    }

    public BdpServiceImplInfo(Class<? extends IBdpService> r100, int r101, IBdpService r102) {
        this.bdpServiceImplClass = r100;
        this.priority = r101;
        this.bdpServiceImpl = r102;
    }
}
