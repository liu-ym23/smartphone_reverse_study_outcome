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
public final class q extends com.bytedance.android.ec.core.widget.d {
    public final /* synthetic */ MainProductCardHeaderView g;
    public final /* synthetic */ ProductFeedViewModel h;
    public final /* synthetic */ PromotionProductStruct i;

    public final void a(View r8) {
        Intrinsics.checkNotNullParameter(r8, "v");
        FeedProductEventTracker r9 = FeedProductEventTracker.a;
        Context r0 = this.g.getContext();
        r9.getClass();
        FeedProductEventTracker.A(r0, "click_inflow_similar_tab", false, null);
        Fragment r1 = this.h.getFlowFragment();
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isDetached() == true) goto L11;
        PromotionProductStruct r2 = this.i;
        if (r2 == null) goto L12;
        int r10 = ProductFeedActionHelper.a;
        ProductFeedActionHelper.c(r1, r2, this.g.r, this.h, false, null, null);
        return;
    L12:
        return;
    }

    public q(MainProductCardHeaderView r1, ProductFeedViewModel r2, PromotionProductStruct r3) {
        this.g = r1;
        this.h = r2;
        this.i = r3;
        super(null, null, 3);
    }
}
