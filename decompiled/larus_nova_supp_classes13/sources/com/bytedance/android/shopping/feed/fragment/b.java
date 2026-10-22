package com.bytedance.android.shopping.feed.fragment;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feed.event.x;
import com.bytedance.android.shopping.feed.view.InnerFeedPageRightWidget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements InnerFeedPageRightWidget.a {
    public final /* synthetic */ ProductFeedContentFragment a;

    @Override // com.bytedance.android.shopping.feed.view.InnerFeedPageRightWidget.a
    public final void a() {
        int r0 = com.bytedance.android.shopping.feed.utils.l.a;
        Context r1 = this.a.getContext();
        int r2 = com.bytedance.android.ec.core.opt.ab.c.a;
        com.bytedance.android.shopping.feed.event.g.c(new x(), r1, null);
        RecyclerView r3 = this.a.k;
        if (r3 == null) goto L6;
        r3.smoothScrollToPosition(0);
        return;
    }

    public b(ProductFeedContentFragment r1) {
        this.a = r1;
    }
}
