package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class NotificationEnableResp implements IMessageEntity {

    @Packed
    private int retCode;

    public NotificationEnableResp() {
        this.retCode = -1;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public void setRetCode(int r100) {
        this.retCode = r100;
    }
}
