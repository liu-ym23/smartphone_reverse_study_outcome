package com.huawei.hms.support.api.entity.push;

import com.alipay.sdk.m.u.i;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class ProfileReq implements IMessageEntity {

    @Packed
    private int operation;

    @Packed
    private String pkgName;

    @Packed
    private String profileId;

    @Packed
    private String subjectId;

    @Packed
    private int type;

    public ProfileReq() {
    }

    public String toString() {
        return getClass().getName() + "{ pkgName: " + this.pkgName + ",subjectId: " + this.subjectId + ",operation: " + this.operation + " type: " + this.type + i.f25855d;
    }

    public int getOperation() {
        return this.operation;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public int getType() {
        return this.type;
    }

    public void setOperation(int r100) {
        this.operation = r100;
    }

    public void setPkgName(String r100) {
        this.pkgName = r100;
    }

    public void setProfileId(String r100) {
        this.profileId = r100;
    }

    public void setSubjectId(String r100) {
        this.subjectId = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
