package com.bytedance.ee.bear.doc.vote;

/* JADX INFO: loaded from: classes16.dex */
public final class o implements gqa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteOptionMembersActivity f218454a;

    public o(VoteOptionMembersActivity r100) {
        this.f218454a = r100;
    }

    @Override // gqa.b
    public final void O0(cqa.h r100) {
        VoteOptionMemberViewModel r101 = this.f218454a.f218400i;
        if (r101 == null) goto L5;
        r101.pull();
        return;
    L5:
        tt5.a.d("VoteOptionMembersActivity", "mVoteOptionMemberVM is null");
    }
}
