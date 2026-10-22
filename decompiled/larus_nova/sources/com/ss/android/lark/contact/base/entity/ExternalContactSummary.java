package com.ss.android.lark.contact.base.entity;

import com.bytedance.lark.pb.basic.v1.TenantNameStatus;
import java.io.Serializable;

/* JADX INFO: loaded from: classes35.dex */
public class ExternalContactSummary implements Serializable {
    private String avatarKey;
    private String departmentName;
    private String i18nName;
    private String tenantName;
    private TenantNameStatus tenantNameStatus;
    private String useId;
    private String userEnName;
    private String userName;

    public ExternalContactSummary() {
    }

    public String getAvatarKey() {
        return this.avatarKey;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public String getI18nName() {
        return this.i18nName;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public TenantNameStatus getTenantNameStatus() {
        return this.tenantNameStatus;
    }

    public String getUseId() {
        return this.useId;
    }

    public String getUserEnName() {
        return this.userEnName;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public void setDepartmentName(String r100) {
        this.departmentName = r100;
    }

    public void setI18nName(String r100) {
        this.i18nName = r100;
    }

    public void setTenantName(String r100) {
        this.tenantName = r100;
    }

    public void setTenantNameStatus(TenantNameStatus r100) {
        this.tenantNameStatus = r100;
    }

    public void setUseId(String r100) {
        this.useId = r100;
    }

    public void setUserEnName(String r100) {
        this.userEnName = r100;
    }

    public void setUserName(String r100) {
        this.userName = r100;
    }
}
