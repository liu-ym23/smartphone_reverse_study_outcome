package com.ss.android.lark.passport.signinsdk_api.entity;

import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class Tenant implements Serializable {
    private static final long serialVersionUID = -92609727225209513L;
    private String address;
    private String contactEmail;
    private String contactMobile;
    private String contactName;
    private String domain;
    private String iconUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f438079id;
    private String name;
    private String postCode;
    private String remark;
    private String suiteFullDomain;
    private String telephone;
    private String unitLeague;

    public Tenant() {
    }

    public String getSuiteFullDomain() {
        String r100 = this.suiteFullDomain;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public String getAddress() {
        return this.address;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public String getContactMobile() {
        return this.contactMobile;
    }

    public String getContactName() {
        return this.contactName;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.f438079id;
    }

    public String getName() {
        return this.name;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getUnitLeague() {
        return this.unitLeague;
    }

    public void setAddress(String r100) {
        this.address = r100;
    }

    public void setContactEmail(String r100) {
        this.contactEmail = r100;
    }

    public void setContactMobile(String r100) {
        this.contactMobile = r100;
    }

    public void setContactName(String r100) {
        this.contactName = r100;
    }

    public void setDomain(String r100) {
        this.domain = r100;
    }

    public void setIconUrl(String r100) {
        this.iconUrl = r100;
    }

    public void setId(String r100) {
        this.f438079id = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setPostCode(String r100) {
        this.postCode = r100;
    }

    public void setRemark(String r100) {
        this.remark = r100;
    }

    public void setSuiteFullDomain(String r100) {
        this.suiteFullDomain = r100;
    }

    public void setTelephone(String r100) {
        this.telephone = r100;
    }

    public void setUnitLeague(String r100) {
        this.unitLeague = r100;
    }
}
