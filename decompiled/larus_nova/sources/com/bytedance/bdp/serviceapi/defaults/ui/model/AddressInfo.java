package com.bytedance.bdp.serviceapi.defaults.ui.model;

/* JADX INFO: loaded from: classes11.dex */
public class AddressInfo implements WheelItem {
    public String code;
    public String name;
    public String type;

    public String getAddrHashCode() {
        return this.name + this.code + this.type;
    }

    @Override // com.bytedance.bdp.serviceapi.defaults.ui.model.WheelItem
    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

    public AddressInfo(String r100, String r101, String r102) {
        this.name = r100;
        this.code = r101;
        this.type = r102;
    }
}
