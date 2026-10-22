package com.bytedance.ee.bear.doc.vote;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class o implements gqa.b {
    public final /* synthetic */ VoteOptionMembersActivity a;

    public o(VoteOptionMembersActivity r1) {
        this.a = r1;
    }

    public final void O0(cqa.h r2) {
        VoteOptionMemberViewModel r3 = this.a.i;
        if (r3 == null) goto L5;
        r3.pull();
        return;
    L5:
        tt5.a.d("VoteOptionMembersActivity", "mVoteOptionMemberVM is null");
    }
}
