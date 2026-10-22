package com.huawei.hms.support.api.entity.auth;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public abstract class AbstractResp implements IMessageEntity {

    @Packed
    private String errorReason;

    @Packed
    private int rtnCode;

    public AbstractResp() {
        this.rtnCode = 0;
    }

    public String getErrorReason() {
        return this.errorReason;
    }

    public int getRtnCode() {
        return this.rtnCode;
    }

    public void setErrorReason(String r100) {
        this.errorReason = r100;
    }

    public void setRtnCode(int r100) {
        this.rtnCode = r100;
    }
}
