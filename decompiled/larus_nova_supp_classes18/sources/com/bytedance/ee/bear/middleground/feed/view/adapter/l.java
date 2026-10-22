package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import com.bytedance.ee.bear.middleground.feed.export.bean.AtBean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ AbsFeedItemBase.FeedBaseViewHolder a;
    public final /* synthetic */ AtBean b;
    public final /* synthetic */ FeedItemMention c;

    public l(AbsFeedItemBase.FeedBaseViewHolder r1, AtBean r2, FeedItemMention r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.W3().setVisibility(8);
        this.b.setReadStatus(2);
        this.c.b.invoke(this.b.getMessageId());
    }
}
