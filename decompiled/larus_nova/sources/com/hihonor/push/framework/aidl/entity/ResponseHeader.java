package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class ResponseHeader implements IMessageEntity {

    @Packed
    public int statusCode;

    @Packed
    public String statusMessage;

    public ResponseHeader() {
        this.statusCode = -1;
    }

    public ResponseHeader(int r100, String r101) {
        this.statusCode = r100;
        this.statusMessage = r101;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusCode(int r100) {
        this.statusCode = r100;
    }

    public void setStatusMessage(String r100) {
        this.statusMessage = r100;
    }
}
