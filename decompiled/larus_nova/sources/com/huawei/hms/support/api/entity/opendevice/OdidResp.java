package com.huawei.hms.support.api.entity.opendevice;

import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class OdidResp extends AbstractMessageEntity {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @Packed
    private String f277739id;

    public OdidResp() {
    }

    public String getId() {
        return this.f277739id;
    }

    public void setId(String r100) {
        this.f277739id = r100;
    }
}
