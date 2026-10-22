package com.bytedance.android.shopping.feed.widget;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.shopping.feed.event.FeedProductEventTracker;
import com.bytedance.android.shopping.feed.utils.ProductFeedActionHelper;
import com.bytedance.android.shopping.feed.viewmodel.ProductFeedViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ GuessULikeProductCardHeaderView g;
    public final /* synthetic */ ProductFeedViewModel h;
    public final /* synthetic */ PromotionProductStruct i;
    public final /* synthetic */ rd3.a j;

    public final void a(View r11) {
        Intrinsics.checkNotNullParameter(r11, "v");
        FeedProductEventTracker r12 = FeedProductEventTracker.a;
        Context r0 = this.g.getContext();
        r12.getClass();
        String r2 = null;
        FeedProductEventTracker.A(r0, "click_inflow_similar_tab", true, null);
        Fragment r3 = this.h.getFlowFragment();
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isDetached() == true) goto L14;
        PromotionProductStruct r4 = this.i;
        if (r4 == null) goto L15;
        int r13 = ProductFeedActionHelper.a;
        View r5 = this.g.n;
        ProductFeedViewModel r6 = this.h;
        rd3.a r14 = this.j;
        String r8 = r14.d;
        rd3.g r15 = r14.d();
        if (r15 == null) goto L11;
        r2 = r15.a();
    L11:
        ProductFeedActionHelper.c(r3, r4, r5, r6, true, r8, r2);
        return;
    L15:
        return;
    }

    public g(GuessULikeProductCardHeaderView r1, ProductFeedViewModel r2, PromotionProductStruct r3, rd3.a r4) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        this.j = r4;
        super(null, null, 3);
    }
}
