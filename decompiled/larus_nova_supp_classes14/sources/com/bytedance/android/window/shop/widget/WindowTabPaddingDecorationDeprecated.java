package com.bytedance.android.window.shop.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowTabPaddingDecorationDeprecated;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowTabPaddingDecorationDeprecated extends RecyclerView.ItemDecoration {

    public static final class a {
    }

    static {
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        UIUtils.dip2Px(null, 0.0f);
        UIUtils.dip2Px(null, 0.0f);
        UIUtils.dip2Px(null, 0.0f);
        UIUtils.dip2Px(null, 0.0f);
        if (r3.getLayoutParams() == null) goto L5;
        r4.getChildAdapterPosition(r3);
        throw null;
    L5:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
    }
}
