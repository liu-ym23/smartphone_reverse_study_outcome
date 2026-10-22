package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class JosBaseResp implements IMessageEntity {

    @Packed
    private int statusCode;

    public JosBaseResp() {
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int r100) {
        this.statusCode = r100;
    }
}
