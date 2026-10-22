package com.bytedance.ee.bear.middleground.permission.collaborator.invite;

import com.bytedance.ee.bear.middleground.permission.collaborator.NotNotifyUserEntity;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class InviteData implements NonProguard {
    public ArrayList<NotNotifyUserEntity> addFailedUsers;
    public ArrayList<NotNotifyUserEntity> blockUsers;
    public int blockedCode;
    public ArrayList<NotNotifyUserEntity> blockedUsers;
    public ArrayList<NotNotifyUserEntity> conditionControlUsers;
    public ArrayList<NotNotifyUserEntity> dlpControlUsers;
    public boolean emailExceedLimit;
    private int failCount;
    private List<String> failOwners;
    public int limitCode;
    public int limitCodeByAdmin;
    public int limitCodeByConditionControl;
    public int limitNum;
    public ArrayList<NotNotifyUserEntity> limitUsers;
    public String linkToken;
    public boolean notNotifyOrg;
    public List<NotNotifyUserEntity> notNotifyUsers;
    public ArrayList<NotNotifyUserEntity> notPartnerTenantUsers;
    public String notificationId;
    public ArrayList<NotNotifyUserEntity> phoneLimitUsers;
    public ArrayList<NotNotifyUserEntity> privacyUsers;
    public String spaceId;
    private int successCount;

    public String toString() {
        return "InviteData{spaceId='" + this.spaceId + "', linkToken='" + this.linkToken + "', notNotifyOrg='" + this.notNotifyOrg + "', emailExceedLimit='" + this.emailExceedLimit + "'}";
    }

    public InviteData() {
        this.blockedCode = -1;
        this.successCount = 0;
        this.failCount = 0;
    }

    public int getFailCount() {
        return this.failCount;
    }

    public List<String> getFailOwners() {
        return this.failOwners;
    }

    public int getSuccessCount() {
        return this.successCount;
    }

    public void setFailCount(int r1) {
        this.failCount = r1;
    }

    public void setFailOwners(List<String> r1) {
        this.failOwners = r1;
    }

    public void setSuccessCount(int r1) {
        this.successCount = r1;
    }
}
