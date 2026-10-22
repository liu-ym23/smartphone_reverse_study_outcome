package com.huawei.hms.support.api.entity.push;

import com.alipay.sdk.m.u.i;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class AttributionReportReq implements IMessageEntity {

    @Packed
    String appVersion;

    @Packed
    String campaignId;

    @Packed
    int eventId;

    @Packed
    String haStorageId;

    @Packed
    String msgId;

    @Packed
    String pkgName;

    @Packed
    String reqPermission;

    @Packed
    long timeStamp;

    public AttributionReportReq() {
    }

    public String toString() {
        return " { eventId:" + this.eventId + " pkgName:" + this.pkgName + i.f25855d;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCampaignId() {
        return this.campaignId;
    }

    public int getEventId() {
        return this.eventId;
    }

    public String getHaStorageId() {
        return this.haStorageId;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getReqPermission() {
        return this.reqPermission;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setAppVersion(String r100) {
        this.appVersion = r100;
    }

    public void setCampaignId(String r100) {
        this.campaignId = r100;
    }

    public void setEventId(int r100) {
        this.eventId = r100;
    }

    public void setHaStorageId(String r100) {
        this.haStorageId = r100;
    }

    public void setMsgId(String r100) {
        this.msgId = r100;
    }

    public void setPkgName(String r100) {
        this.pkgName = r100;
    }

    public void setReqPermission(String r100) {
        this.reqPermission = r100;
    }

    public void setTimeStamp(long r100) {
        this.timeStamp = r100;
    }
}
