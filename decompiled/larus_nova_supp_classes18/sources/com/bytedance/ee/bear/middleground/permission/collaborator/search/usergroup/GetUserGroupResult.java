package com.bytedance.ee.bear.middleground.permission.collaborator.search.usergroup;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class GetUserGroupResult extends Result<Serializable> {
    private List<Member> existsMembers;
    private List<UserGroup> visibleGroups;

    public GetUserGroupResult() {
    }

    public List<Member> getExistsMembers() {
        return this.existsMembers;
    }

    public List<UserGroup> getVisibleGroups() {
        return this.visibleGroups;
    }

    public void setExistsMembers(List<Member> r1) {
        this.existsMembers = r1;
    }

    public void setVisibleGroups(List<UserGroup> r1) {
        this.visibleGroups = r1;
    }
}
