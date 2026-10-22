package com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Member implements NonProguard {

    @JSONField(name = "member_id")
    private String memberId;

    @JSONField(name = "member_type")
    private int memberType;

    @JSONField(deserialize = BaseKeyboardHeightProducer.VISIBLE_FALSE, name = "perm", serialize = BaseKeyboardHeightProducer.VISIBLE_FALSE)
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

    public void setMemberId(String r1) {
        this.memberId = r1;
    }

    public void setMemberType(int r1) {
        this.memberType = r1;
    }

    public void setPerm(int r1) {
        this.perm = r1;
    }

    public Member(int r1, String r2) {
        this.memberType = r1;
        this.memberId = r2;
    }
}
