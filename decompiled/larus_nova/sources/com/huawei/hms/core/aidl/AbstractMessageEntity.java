package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Status;

/* JADX INFO: loaded from: classes23.dex */
public class AbstractMessageEntity implements IMessageEntity {

    @Packed
    private Status commonStatus;

    public AbstractMessageEntity() {
    }

    public Status getCommonStatus() {
        return this.commonStatus;
    }

    public void setCommonStatus(Status r100) {
        this.commonStatus = r100;
    }
}
