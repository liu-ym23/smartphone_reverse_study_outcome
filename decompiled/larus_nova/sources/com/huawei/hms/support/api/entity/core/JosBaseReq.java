package com.huawei.hms.support.api.entity.core;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class JosBaseReq implements IMessageEntity {

    @Packed
    private String channelId;

    @Packed
    private String cpId;

    @Packed
    private String hmsSdkVersionName;

    public JosBaseReq() {
    }

    private static <T> T get(T r100) {
        return r100;
    }

    public String getChannelId() {
        return (String) get(this.channelId);
    }

    public String getCpID() {
        return (String) get(this.cpId);
    }

    public String getHmsSdkVersionName() {
        return (String) get(this.hmsSdkVersionName);
    }

    public void setChannelId(String r100) {
        this.channelId = r100;
    }

    public void setCpID(String r100) {
        this.cpId = r100;
    }

    public void setHmsSdkVersionName(String r100) {
        this.hmsSdkVersionName = r100;
    }
}
