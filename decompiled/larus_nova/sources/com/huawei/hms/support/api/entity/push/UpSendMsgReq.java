package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class UpSendMsgReq implements IMessageEntity {

    @Packed
    private String collapseKey;

    @Packed
    private String data;

    @Packed
    private String msgId;

    @Packed
    private String msgType;

    @Packed
    private String packageName;

    @Packed
    private int receiptMode;

    @Packed
    private int sendMode;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    @Packed
    private String f277740to;

    @Packed
    private String token;

    @Packed
    private int ttl;

    public UpSendMsgReq() {
    }

    public String getCollapseKey() {
        return this.collapseKey;
    }

    public String getData() {
        return this.data;
    }

    public String getMessageId() {
        return this.msgId;
    }

    public String getMessageType() {
        return this.msgType;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getReceiptMode() {
        return this.receiptMode;
    }

    public int getSendMode() {
        return this.sendMode;
    }

    public String getTo() {
        return this.f277740to;
    }

    public String getToken() {
        return this.token;
    }

    public int getTtl() {
        return this.ttl;
    }

    public void setCollapseKey(String r100) {
        this.collapseKey = r100;
    }

    public void setData(String r100) {
        this.data = r100;
    }

    public void setMessageId(String r100) {
        this.msgId = r100;
    }

    public void setMessageType(String r100) {
        this.msgType = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setReceiptMode(int r100) {
        this.receiptMode = r100;
    }

    public void setSendMode(int r100) {
        this.sendMode = r100;
    }

    public void setTo(String r100) {
        this.f277740to = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setTtl(int r100) {
        this.ttl = r100;
    }
}
