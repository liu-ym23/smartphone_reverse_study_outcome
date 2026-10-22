package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.AtBean;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsFeedItemBase.FeedBaseViewHolder f232684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtBean f232685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FeedItemMention f232686c;

    public l(AbsFeedItemBase.FeedBaseViewHolder r100, AtBean r101, FeedItemMention r102) {
        this.f232684a = r100;
        this.f232685b = r101;
        this.f232686c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f232684a.W3().setVisibility(8);
        this.f232685b.setReadStatus(2);
        this.f232686c.f232643b.invoke(this.f232685b.getMessageId());
    }
}
