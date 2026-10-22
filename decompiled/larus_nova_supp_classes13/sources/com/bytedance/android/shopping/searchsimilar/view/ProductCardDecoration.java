package com.bytedance.android.shopping.searchsimilar.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/searchsimilar/view/ProductCardDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductCardDecoration extends RecyclerView.ItemDecoration {
    public final int a;
    public final int b;
    public final int c;

    public ProductCardDecoration() {
        this.a = com.bytedance.android.shopping.extensions.b.b(Double.valueOf(2.5d));
        this.b = com.bytedance.android.shopping.extensions.b.b(9);
        this.c = com.bytedance.android.shopping.extensions.b.b(5);
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        StaggeredGridLayoutManager.LayoutParams r6 = r3.getLayoutParams();
        if (r6 == null) goto L11;
        if ((r6.getSpanIndex() % 2) != 0) goto L7;
        r2.left = this.b;
        r2.right = this.a;
    L8:
        r2.top = this.c;
        return;
    L7:
        r2.left = this.a;
        r2.right = this.b;
        goto L8
    L11:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }
}
