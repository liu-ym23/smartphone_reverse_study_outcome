package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class PushTokenResult implements IMessageEntity {

    @Packed
    private String pushToken;

    public PushTokenResult() {
        this.pushToken = "";
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public void setPushToken(String r100) {
        this.pushToken = r100;
    }
}
