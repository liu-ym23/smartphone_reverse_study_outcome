package com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public class Member implements NonProguard {

    @JSONField(name = "member_id")
    private String memberId;

    @JSONField(name = "member_type")
    private int memberType;

    @JSONField(deserialize = false, name = "perm", serialize = false)
    private int perm;

    public String toString() {
        return "Member{memberType=" + this.memberType + ", memberId='" + this.memberId + "'}";
    }

    public Member() {
    }

    public String getMemberId() {
        return this.memberId;
    }

    public int getMemberType() {
        return this.memberType;
    }

    public int getPerm() {
        return this.perm;
    }

    public void setMemberId(String r100) {
        this.memberId = r100;
    }

    public void setMemberType(int r100) {
        this.memberType = r100;
    }

    public void setPerm(int r100) {
        this.perm = r100;
    }

    public Member(int r100, String r101) {
        this.memberType = r100;
        this.memberId = r101;
    }
}
