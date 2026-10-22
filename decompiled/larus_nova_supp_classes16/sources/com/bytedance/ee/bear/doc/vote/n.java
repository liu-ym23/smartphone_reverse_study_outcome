package com.bytedance.ee.bear.doc.vote;

import com.bytedance.ee.bear.facade.common.empty.EmptyView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final /* synthetic */ class n implements EmptyView.a {
    public final /* synthetic */ VoteOptionMemberViewModel a;

    public /* synthetic */ n(VoteOptionMemberViewModel r1) {
        this.a = r1;
    }

    @Override // com.bytedance.ee.bear.facade.common.empty.EmptyView.a
    public final void onFailedRetry() {
        this.a.pull();
    }
}
