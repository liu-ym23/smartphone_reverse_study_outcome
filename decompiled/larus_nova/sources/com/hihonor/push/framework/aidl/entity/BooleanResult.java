package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class BooleanResult implements IMessageEntity {

    @Packed
    private boolean status;

    public BooleanResult() {
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean r100) {
        this.status = r100;
    }
}
