package com.ss.android.lark.flow.feed.page;

import com.ss.android.lark.feed.shared.page.FeedRecyclerView;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements LarkFeedInBoxListAdapter.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedRecyclerView f423451a;

    @Override // com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter.c
    public final void a() {
        com.ss.android.lark.feed.shared.page.utils.b.a(this.f423451a);
    }

    @Override // com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter.c
    public final void b() {
        FeedRecyclerView r100 = this.f423451a;
        if (com.ss.android.lark.feed.shared.page.utils.b.b() == false) goto L7;
        if (r100 == null) goto L8;
        r100.getItemAnimator().setRemoveDuration(300);
        r100.getItemAnimator().setMoveDuration(150);
        return;
    L8:
        return;
    }

    public b(FeedRecyclerView r100) {
        this.f423451a = r100;
    }
}
