package com.dtf.face.network.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;

/* JADX INFO: loaded from: classes22.dex */
public class BisClientInfo {

    @JSONField(name = "clientVer")
    public String clientVer;

    @JSONField(name = DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    public String model;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    @JSONField(name = "os")
    public String f273640os;

    @JSONField(name = "osVer")
    public String osVer;

    public BisClientInfo() {
    }

    public String getClientVer() {
        return this.clientVer;
    }

    public String getModel() {
        return this.model;
    }

    public String getOs() {
        return this.f273640os;
    }

    public String getOsVer() {
        return this.osVer;
    }

    public void setClientVer(String r100) {
        this.clientVer = r100;
    }

    public void setModel(String r100) {
        this.model = r100;
    }

    public void setOs(String r100) {
        this.f273640os = r100;
    }

    public void setOsVer(String r100) {
        this.osVer = r100;
    }
}
