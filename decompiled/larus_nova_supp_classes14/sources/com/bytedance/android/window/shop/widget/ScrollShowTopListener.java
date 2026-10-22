package com.bytedance.android.window.shop.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/ScrollShowTopListener;", "Landroidx/recyclerview/widget/RecyclerView;", "R", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ScrollShowTopListener<R extends RecyclerView> extends RecyclerView.OnScrollListener {
    public int a;
    public final Function1<Integer, Unit> b;
    public final Function1<Boolean, Unit> c;

    public final void j(int r2) {
        int r0 = this.a;
        if (r0 > 0) goto L5;
        return;
    L5:
        if (r2 < r0) goto L7;
        boolean r3 = true;
    L8:
        this.c.invoke(Boolean.valueOf(r3));
        return;
    L7:
        r3 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollShowTopListener(Function1<? super Integer, Unit> r2, Function1<? super Boolean, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "onStateChanged");
        Intrinsics.checkNotNullParameter(r3, "onUpdated");
        this.b = r2;
        this.c = r3;
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        this.b.invoke(Integer.valueOf(r3));
    }

    public final void onScrolled(RecyclerView r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "recyclerView");
        int r4 = ((ECShopRecyclerView) r1).t();
        if (r1 == null) goto L13;
        int r5 = ((ECShopRecyclerView) r1).r();
        if (this.a > 0) goto L10;
        int r6 = (r4 - r5) + 1;
        if (r6 <= 1) goto L10;
        this.a = r6;
    L10:
        j(r5);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.widget.ECShopRecyclerView");
    }
}
