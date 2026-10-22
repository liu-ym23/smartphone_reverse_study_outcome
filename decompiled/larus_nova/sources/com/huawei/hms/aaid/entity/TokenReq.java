package com.huawei.hms.aaid.entity;

import com.alipay.sdk.m.u.i;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class TokenReq implements IMessageEntity {

    @Packed
    private String aaid;

    @Packed
    private String appId;

    @Packed
    private boolean firstTime;

    @Packed
    private boolean isFastApp;

    @Packed
    private boolean isMultiSender;

    @Packed
    private String packageName;

    @Packed
    private String projectId;

    @Packed
    private String scope;

    @Packed
    private String subjectId;

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.append(getClass().getName());
        r100.append("{pkgName: ");
        r100.append(this.packageName);
        r100.append(",isFirstTime: ");
        r100.append(this.firstTime);
        r100.append(",scope:");
        r100.append(this.scope);
        r100.append(",appId:");
        r100.append(this.appId);
        r100.append(",projectId:");
        r100.append(this.projectId);
        r100.append(",subjectId:");
        r100.append(this.subjectId);
        r100.append(i.f25855d);
        return r100.toString();
    }

    public TokenReq() {
        this.isMultiSender = false;
        this.isFastApp = false;
    }

    public String getAaid() {
        return this.aaid;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getScope() {
        return this.scope;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public boolean isFirstTime() {
        return this.firstTime;
    }

    public boolean isMultiSender() {
        return this.isMultiSender;
    }

    public void setAaid(String r100) {
        this.aaid = r100;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setFastApp(boolean r100) {
        this.isFastApp = r100;
    }

    public void setFirstTime(boolean r100) {
        this.firstTime = r100;
    }

    public void setMultiSender(boolean r100) {
        this.isMultiSender = r100;
    }

    public void setPackageName(String r100) {
        this.packageName = r100;
    }

    public void setProjectId(String r100) {
        this.projectId = r100;
    }

    public void setScope(String r100) {
        this.scope = r100;
    }

    public void setSubjectId(String r100) {
        this.subjectId = r100;
    }
}
