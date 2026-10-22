package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class SubscribeNotificationReq implements IMessageEntity {

    @Packed
    private String entityIds;

    @Packed
    private String token;

    public SubscribeNotificationReq() {
    }

    public String getEntityIds() {
        return this.entityIds;
    }

    public String getToken() {
        return this.token;
    }

    public void setEntityIds(String r100) {
        this.entityIds = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }
}
