package com.bytedance.android.window.shop.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ScrollLoadMoreListener;", "Landroidx/recyclerview/widget/RecyclerView;", "R", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ScrollLoadMoreListener<R extends RecyclerView> extends RecyclerView.OnScrollListener {
    public final int a;
    public boolean b;
    public boolean c;

    public abstract int j(R r1);

    public abstract void k();

    public abstract void l();

    public ScrollLoadMoreListener() {
        this.a = RangesKt.coerceAtLeast(10, 1);
    }

    public final void onScrolled(RecyclerView r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        if (this.b == false) goto L5;
        return;
    L5:
        if (this.c == true) goto L24;
        int r0 = j(r4);
        RecyclerView.LayoutManager r1 = r4.getLayoutManager();
        if (r1 != null) goto L11;
        return;
    L11:
        if (r0 < (r1.getItemCount() - this.a)) goto L23;
        this.b = true;
        k();
        if (this.c == true) goto L25;
        if (r5 != 0) goto L20;
        if (r6 != 0) goto L20;
        if (r4.getScrollState() != 0) goto L20;
        return;
    L20:
        l();
        return;
    L25:
        return;
    L23:
        return;
    }
}
