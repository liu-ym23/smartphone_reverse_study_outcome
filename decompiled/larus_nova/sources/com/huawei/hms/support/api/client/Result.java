package com.huawei.hms.support.api.client;

import com.huawei.hms.core.aidl.IMessageEntity;

/* JADX INFO: loaded from: classes23.dex */
public abstract class Result implements IMessageEntity {
    private Status status;

    public Result() {
        this.status = Status.FAILURE;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.status = r100;
    }
}
