package com.bytedance.ee.bear.doc.vote;

/* JADX INFO: loaded from: classes16.dex */
public final class v implements gqa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteOptionMembersFragment f218460a;

    public v(VoteOptionMembersFragment r100) {
        this.f218460a = r100;
    }

    @Override // gqa.b
    public final void O0(cqa.h r100) {
        VoteOptionMemberViewModel r101 = this.f218460a.f218421k;
        if (r101 == null) goto L5;
        r101.pull();
        return;
    L5:
        tt5.a.d("VoteOptionMembersFragment", "mVoteOptionMemberVM is null");
    }
}
