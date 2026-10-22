package com.ss.android.lark.feed.shared.page.binder2;

import android.view.View;
import com.ss.android.lark.feed.shared.page.adapter.LarkFeedInBoxListAdapter;

/* JADX INFO: loaded from: classes35.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedExpiredFoldHintViewHolder f421370a;

    public l(FeedExpiredFoldHintViewHolder r100) {
        this.f421370a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f421370a.f421334b.setVisibility(8);
        com.ss.android.lark.feed.shared.hitpoint.a.c(false);
        LarkFeedInBoxListAdapter.D2(((teb.g) this.f421370a.f421333a).f545659a);
    }
}
