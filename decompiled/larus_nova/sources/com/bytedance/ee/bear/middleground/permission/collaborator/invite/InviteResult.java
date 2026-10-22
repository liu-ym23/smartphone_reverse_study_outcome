package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class InviteResult extends Result {
    String code;
    InviteData data;
    String msg;

    public List<NotNotifyUserEntity> getConditionDenyUser() {
        InviteData r100 = this.data;
        if (r100 == null) goto L7;
        ArrayList<NotNotifyUserEntity> r101 = r100.conditionControlUsers;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    public List<NotNotifyUserEntity> getDlpControlUser() {
        InviteData r100 = this.data;
        if (r100 == null) goto L7;
        ArrayList<NotNotifyUserEntity> r101 = r100.dlpControlUsers;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    public String getLinkToken() {
        InviteData r100 = this.data;
        if (r100 == null) goto L6;
        String r101 = r100.linkToken;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public List<NotNotifyUserEntity> getNotNotifyUsers() {
        InviteData r100 = this.data;
        if (r100 == null) goto L7;
        List<NotNotifyUserEntity> r101 = r100.notNotifyUsers;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    public List<NotNotifyUserEntity> getNotPartnerTenantUser() {
        InviteData r100 = this.data;
        if (r100 == null) goto L7;
        ArrayList<NotNotifyUserEntity> r101 = r100.notPartnerTenantUsers;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new ArrayList();
    }

    public String getNotificationId() {
        InviteData r100 = this.data;
        if (r100 == null) goto L6;
        String r101 = r100.notificationId;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public String getSpaceId() {
        InviteData r100 = this.data;
        if (r100 == null) goto L6;
        String r101 = r100.spaceId;
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public String toString() {
        return "InviteResult{msg='" + this.msg + "', code='" + this.code + "'}";
    }

    @Override // com.bytedance.ee.bear.contract.Result
    public /* bridge */ /* synthetic */ Serializable getData() {
        return getData();
    }

    public InviteResult() {
    }

    @Override // com.bytedance.ee.bear.contract.Result
    public InviteData getData() {
        return this.data;
    }

    public void setInviteData(InviteData r100) {
        this.data = r100;
    }
}
