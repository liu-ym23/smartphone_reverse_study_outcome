package com.bytedance.android.shopping.store.shopfeed.list;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.k1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/store/shopfeed/list/ShopFeedLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopFeedLayoutManager extends LinearLayoutManager {
    public final int a;
    public final float b;

    public ShopFeedLayoutManager(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, 1, false);
        this.a = k1.j(r3);
        this.b = 100.0f;
    }

    public final int getExtraLayoutSpace(RecyclerView.State r1) {
        return this.a * 2;
    }

    public final void smoothScrollToPosition(RecyclerView r1, RecyclerView.State r2, int r3) {
        Intrinsics.checkNotNull(r1);
        final Context r4 = r1.getContext();
        LinearSmoothScroller r5 = new ShopFeedLayoutManager$smoothScrollToPosition$smoothScroller$1(this, r4);
        r5.setTargetPosition(r3);
        startSmoothScroll(r5);
    }
}
