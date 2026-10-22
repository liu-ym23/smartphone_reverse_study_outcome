package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsFeedItemBase.FeedBaseViewHolder f232680a;

    public i(AbsFeedItemBase.FeedBaseViewHolder r100) {
        this.f232680a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f232680a.itemView.performClick();
    }
}
