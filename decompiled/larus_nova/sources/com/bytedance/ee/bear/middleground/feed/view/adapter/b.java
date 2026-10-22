package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeedItemComment.FeedCommentViewHolder f232664a;

    public b(FeedItemComment.FeedCommentViewHolder r100) {
        this.f232664a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f232664a.itemView.performClick();
    }
}
