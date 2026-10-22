package com.bytedance.ee.bear.middleground.feed.view.adapter;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ AbsFeedItemBase.FeedBaseViewHolder a;

    public i(AbsFeedItemBase.FeedBaseViewHolder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        ((RecyclerView.ViewHolder) this.a).itemView.performClick();
    }
}
