package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/mall/homepage/card/headercard/widget/RVIndicator$bindRecyclerView$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RVIndicator$bindRecyclerView$1 extends RecyclerView.OnScrollListener {
    public final /* synthetic */ RVIndicator a;

    public RVIndicator$bindRecyclerView$1(RVIndicator r1) {
        this.a = r1;
    }

    public final void onScrolled(RecyclerView r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "recyclerView");
        long r8 = System.currentTimeMillis();
        RVIndicator r0 = this.a;
        if ((r8 - r0.h) >= r0.g) goto L5;
        return;
    L5:
        r0.h = System.currentTimeMillis();
        this.a.setProgress((r5.computeHorizontalScrollOffset() * 1.0f) / (r5.computeHorizontalScrollRange() - r5.computeHorizontalScrollExtent()));
    }
}
