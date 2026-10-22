package com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
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

    public void setMembers(List<Member> r100) {
        this.members = r100;
    }

    public void setToken(String r100) {
        this.token = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }

    public ExistMemberParam(int r100, String r101, List<Member> r102) {
        this.type = r100;
        this.token = r101;
        this.members = r102;
    }
}
