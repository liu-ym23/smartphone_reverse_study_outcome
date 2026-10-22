package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.model.response.anchorv3.TopicItemInfo;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.utils.d0;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ GuessULikeProductCardHeaderView a;
    public final /* synthetic */ TopicItemInfo b;
    public final /* synthetic */ List c;

    public h(GuessULikeProductCardHeaderView r1, TopicItemInfo r2, List r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        String r1 = this.b.getSchema();
        if (r1 == null) goto L14;
        ArrayList<String> r8 = d0.a;
        Context r0 = this.a.getContext();
        String r2 = this.b.getId();
        ProductFeedViewModel r9 = this.a.getViewModel();
        AnchorV3Param r3 = null;
        if (r9 == null) goto L9;
        com.bytedance.android.shopping.feed.utils.m r10 = r9.getInnerGuessULikeFiltersHelper();
        if (r10 == null) goto L9;
        ArrayList<String> r11 = r10.b;
    L10:
        List r4 = this.c;
        ProductFeedViewModel r5 = this.a.getViewModel();
        if (r5 == null) goto L13;
        r3 = r5.m907getAnchorV3Param();
    L13:
        d0.b(r0, r1, r2, r11, r4, r3);
    L9:
        r11 = null;
    L14:
        FeedProductEventTracker r12 = FeedProductEventTracker.a;
        Context r6 = this.a.getContext();
        TopicItemInfo r13 = this.b;
        r12.getClass();
        FeedProductEventTracker.G(r6, "label_click", r13);
    }
}
