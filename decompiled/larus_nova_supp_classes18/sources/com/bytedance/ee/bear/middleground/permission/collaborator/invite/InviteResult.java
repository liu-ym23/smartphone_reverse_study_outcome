package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class InviteResult extends Result {
    String code;
    InviteData data;
    String msg;

    public List<NotNotifyUserEntity> getConditionDenyUser() {
        InviteData r0 = this.data;
        if (r0 == null) goto L7;
        ArrayList<NotNotifyUserEntity> r1 = r0.conditionControlUsers;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    public List<NotNotifyUserEntity> getDlpControlUser() {
        InviteData r0 = this.data;
        if (r0 == null) goto L7;
        ArrayList<NotNotifyUserEntity> r1 = r0.dlpControlUsers;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    public String getLinkToken() {
        InviteData r0 = this.data;
        if (r0 == null) goto L6;
        String r1 = r0.linkToken;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public List<NotNotifyUserEntity> getNotNotifyUsers() {
        InviteData r0 = this.data;
        if (r0 == null) goto L7;
        List<NotNotifyUserEntity> r1 = r0.notNotifyUsers;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    public List<NotNotifyUserEntity> getNotPartnerTenantUser() {
        InviteData r0 = this.data;
        if (r0 == null) goto L7;
        ArrayList<NotNotifyUserEntity> r1 = r0.notPartnerTenantUsers;
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new ArrayList();
    }

    public String getNotificationId() {
        InviteData r0 = this.data;
        if (r0 == null) goto L6;
        String r1 = r0.notificationId;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String getSpaceId() {
        InviteData r0 = this.data;
        if (r0 == null) goto L6;
        String r1 = r0.spaceId;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "";
    }

    public String toString() {
        return "InviteResult{msg='" + this.msg + "', code='" + this.code + "'}";
    }

    /* JADX INFO: renamed from: getData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Serializable m280getData() {
        return getData();
    }

    public InviteResult() {
    }

    public InviteData getData() {
        return this.data;
    }

    public void setInviteData(InviteData r1) {
        this.data = r1;
    }
}
