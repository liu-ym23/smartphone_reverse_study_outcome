package com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember;

import com.bytedance.ee.bear.contract.Result;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class ExistMemberResult extends Result {
    private List<Member> existMembers;

    public ExistMemberResult() {
    }

    public List<Member> getExistMembers() {
        return this.existMembers;
    }

    public void setExistMembers(List<Member> r100) {
        this.existMembers = r100;
    }
}
