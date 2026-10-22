package com.hihonor.push.framework.aidl.entity;

import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class RequestHeader implements IMessageEntity {

    @Packed
    private String AAID;

    @Packed
    private String appId;

    @Packed
    private String certificateFingerprint;

    @Packed
    private String packageName;

    @Packed
    private String pushToken;

    @Packed
    private int sdkVersion;

    public RequestHeader() {
    }

    public String getAAID() {
        return this.AAID;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getCertificateFingerprint() {
        return this.certificateFingerprint;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPushToken() {
        return this.pushToken;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public void setAAID(String r100) {
        this.AAID = r100;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setCertificateFingerprint(String r100) {
        this.certificateFingerprint = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setPushToken(String r100) {
        this.pushToken = r100;
    }

    public void setSdkVersion(int r100) {
        this.sdkVersion = r100;
    }
}
