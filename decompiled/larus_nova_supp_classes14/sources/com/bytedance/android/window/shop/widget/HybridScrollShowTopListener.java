package com.bytedance.android.window.shop.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/window/shop/widget/HybridScrollShowTopListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class HybridScrollShowTopListener extends RecyclerView.OnScrollListener {
    public int a;
    public final Function1<Integer, Unit> b;
    public final Function1<Boolean, Unit> c;

    /* JADX WARN: Multi-variable type inference failed */
    public HybridScrollShowTopListener(Function1<? super Integer, Unit> r2, Function1<? super Boolean, Unit> r3) {
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

    public final void onScrolled(RecyclerView r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "recyclerView");
        RecyclerView.LayoutManager r6 = r3.getLayoutManager();
        LinearLayoutManager r0 = null;
        if ((r6 instanceof LinearLayoutManager) == true) goto L5;
        r6 = null;
    L5:
        LinearLayoutManager r7 = (LinearLayoutManager) r6;
        boolean r8 = false;
        if (r7 == null) goto L8;
        int r9 = r7.findLastVisibleItemPosition();
    L9:
        LinearLayoutManager r10 = r3.getLayoutManager();
        if ((r10 instanceof LinearLayoutManager) == false) goto L13;
        r0 = r10;
    L13:
        LinearLayoutManager r1 = r0;
        if (r1 == null) goto L16;
        int r11 = r1.findFirstCompletelyVisibleItemPosition();
    L18:
        if (this.a > 0) goto L23;
        int r12 = (r9 - r11) + 1;
        if (r12 <= 1) goto L23;
        this.a = r12;
    L23:
        int r13 = this.a;
        if (r13 <= 0) goto L30;
        if (r11 < r13) goto L28;
        r8 = true;
    L28:
        this.c.invoke(Boolean.valueOf(r8));
        return;
    L30:
        return;
    L16:
        r11 = 0;
        goto L18
    L8:
        r9 = 0;
        goto L9
    }
}
