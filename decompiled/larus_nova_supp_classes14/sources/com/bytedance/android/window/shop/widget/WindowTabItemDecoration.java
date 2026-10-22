package com.bytedance.android.window.shop.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowTabItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabItemDecoration extends RecyclerView.ItemDecoration {
    public WindowTabItemDecoration() {
    }

    public final void getItemOffsets(Rect r4, View r5, RecyclerView r6, RecyclerView.State r7) {
        Intrinsics.checkNotNullParameter(r4, "outRect");
        Intrinsics.checkNotNullParameter(r5, "view");
        Intrinsics.checkNotNullParameter(r6, "parent");
        Intrinsics.checkNotNullParameter(r7, "state");
        int r0 = r6.getChildAdapterPosition(r5);
        RecyclerView.ViewHolder r1 = r6.findContainingViewHolder(r5);
        if ((r1 instanceof ShopWindowItemHolder) == true) goto L5;
        r1 = null;
    L5:
        ShopWindowItemHolder r2 = (ShopWindowItemHolder) r1;
        if (r2 != null) goto L9;
        super.getItemOffsets(r4, r5, r6, r7);
        return;
    L9:
        Rect r8 = r2.r4(r0);
        r4.top = r8.top;
        r4.left = r8.left;
        r4.right = r8.right;
        r4.bottom = r8.bottom;
    }
}
