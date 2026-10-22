package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class EnableConsentReq implements IMessageEntity {

    @Packed
    private boolean enable;

    @Packed
    private String packageName;

    public String toString() {
        return "ConsentReq{packageName:" + this.packageName + ", enable:" + this.enable + '}';
    }

    public EnableConsentReq() {
    }

    public String getPackageName() {
        return this.packageName;
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }
}
