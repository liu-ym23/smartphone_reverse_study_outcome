package com.bytedance.ee.bear.doc.vote;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v implements gqa.b {
    public final /* synthetic */ VoteOptionMembersFragment a;

    public v(VoteOptionMembersFragment r1) {
        this.a = r1;
    }

    public final void O0(cqa.h r2) {
        VoteOptionMemberViewModel r3 = this.a.k;
        if (r3 == null) goto L5;
        r3.pull();
        return;
    L5:
        tt5.a.d("VoteOptionMembersFragment", "mVoteOptionMemberVM is null");
    }
}
