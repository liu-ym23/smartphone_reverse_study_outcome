package com.huawei.hms.aaid.entity;

import com.alipay.sdk.m.u.i;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class DeleteTokenReq implements IMessageEntity {

    @Packed
    private String appId;

    @Packed
    private int deleteType;

    @Packed
    private boolean isFastApp;

    @Packed
    private boolean isMultiSender;

    @Packed
    private String pkgName;

    @Packed
    private String projectId;

    @Packed
    private String scope;

    @Packed
    private String subjectId;

    @Packed
    private String token;

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        r100.append(getClass().getName());
        r100.append("{pkgName: ");
        r100.append(this.pkgName);
        r100.append(",scope:");
        r100.append(this.scope);
        r100.append(",appId:");
        r100.append(this.appId);
        r100.append(",projectId:");
        r100.append(this.projectId);
        r100.append(",subjectId:");
        r100.append(this.subjectId);
        r100.append(",subjectId:");
        r100.append(this.subjectId);
        r100.append(i.f25855d);
        return r100.toString();
    }

    public DeleteTokenReq() {
        this.isMultiSender = false;
        this.deleteType = 0;
        this.isFastApp = false;
    }

    public String getAppId() {
        return this.appId;
    }

    public int getDeleteType() {
        return this.deleteType;
    }

    public String getPkgName() {
        return this.pkgName;
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

    public String getToken() {
        return this.token;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public boolean isMultiSender() {
        return this.isMultiSender;
    }

    public void setAppId(String r100) {
        this.appId = r100;
    }

    public void setDeleteType(int r100) {
        this.deleteType = r100;
    }

    public void setFastApp(boolean r100) {
        this.isFastApp = r100;
    }

    public void setMultiSender(boolean r100) {
        this.isMultiSender = r100;
    }

    public void setPkgName(String r100) {
        this.pkgName = r100;
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

    public void setToken(String r100) {
        this.token = r100;
    }
}
