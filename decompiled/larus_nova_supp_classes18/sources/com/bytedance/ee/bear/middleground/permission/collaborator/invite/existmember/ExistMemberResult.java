package com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember;

import com.bytedance.ee.bear.contract.Result;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ExistMemberResult extends Result {
    private List<Member> existMembers;

    public ExistMemberResult() {
    }

    public List<Member> getExistMembers() {
        return this.existMembers;
    }

    public void setExistMembers(List<Member> r1) {
        this.existMembers = r1;
    }
}
