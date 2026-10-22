package com.bytedance.ee.bear.doc.vote;

import com.bytedance.ee.bear.facade.common.empty.EmptyView;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class n implements EmptyView.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VoteOptionMemberViewModel f218453a;

    public /* synthetic */ n(VoteOptionMemberViewModel r100) {
        this.f218453a = r100;
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.EmptyView.a
    public final void onFailedRetry() {
        this.f218453a.pull();
    }
}
