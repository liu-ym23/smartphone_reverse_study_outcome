package com.bytedance.ee.bear.middleground.permission.collaborator.search;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public class SearchUserResult extends Result {
    public List<Member> existMembers;
    public boolean hasMore;
    public boolean isRealUser;
    public boolean isRecent;
    public boolean isValid;
    public ArrayList<UserInfo> list;
    public boolean refresh;

    public SearchUserResult() {
        this.list = new ArrayList();
        this.existMembers = new ArrayList();
        this.hasMore = false;
        this.refresh = true;
        this.isRecent = false;
        this.isValid = false;
        this.isRealUser = false;
    }
}
