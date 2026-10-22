package com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ExistMemberParam implements NonProguard {
    private List<Member> members;
    private String token;
    private int type;

    public ExistMemberParam() {
    }

    public List<Member> getMembers() {
        return this.members;
    }

    public String getToken() {
        return this.token;
    }

    public int getType() {
        return this.type;
    }

    public void setMembers(List<Member> r1) {
        this.members = r1;
    }

    public void setToken(String r1) {
        this.token = r1;
    }

    public void setType(int r1) {
        this.type = r1;
    }

    public ExistMemberParam(int r1, String r2, List<Member> r3) {
        this.type = r1;
        this.token = r2;
        this.members = r3;
    }
}
