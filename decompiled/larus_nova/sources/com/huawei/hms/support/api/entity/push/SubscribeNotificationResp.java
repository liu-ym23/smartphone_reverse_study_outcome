package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class SubscribeNotificationResp implements IMessageEntity {

    @Packed
    private int retCode;

    @Packed
    private String subscribeResults;

    public SubscribeNotificationResp() {
        this.retCode = -1;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getSubscribeResults() {
        return this.subscribeResults;
    }

    public void setRetCode(int r100) {
        this.retCode = r100;
    }

    public void setSubscribeResults(String r100) {
        this.subscribeResults = r100;
    }
}
