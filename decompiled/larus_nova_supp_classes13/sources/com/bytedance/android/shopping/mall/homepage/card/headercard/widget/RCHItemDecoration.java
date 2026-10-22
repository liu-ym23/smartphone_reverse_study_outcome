package com.bytedance.android.shopping.mall.homepage.card.headercard.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/widget/RCHItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RCHItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public RCHItemDecoration(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r2, View r3, RecyclerView r4, RecyclerView.State r5) {
        Intrinsics.checkNotNullParameter(r2, "outRect");
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r4, "parent");
        Intrinsics.checkNotNullParameter(r5, "state");
        int r6 = r4.getChildAdapterPosition(r3);
        RecyclerView.Adapter r7 = r4.getAdapter();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r6 >= (r7.getItemCount() - 1)) goto L9;
        r2.right = this.a;
        return;
    }
}
