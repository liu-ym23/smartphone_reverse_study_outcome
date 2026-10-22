package com.bytedance.android.shopping.mall.homepage.card.headercard.channel;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/GridItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GridItemDecoration extends RecyclerView.ItemDecoration {
    public final int a;

    public GridItemDecoration(int r1) {
        this.a = r1;
    }

    public final void getItemOffsets(Rect r10, View r11, RecyclerView r12, RecyclerView.State r13) {
        Intrinsics.checkNotNullParameter(r10, "outRect");
        Intrinsics.checkNotNullParameter(r11, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r12, "parent");
        Intrinsics.checkNotNullParameter(r13, "state");
        int r14 = r12.getChildAdapterPosition(r11);
        RecyclerView.LayoutManager r15 = r12.getLayoutManager();
        if ((r15 instanceof GridLayoutManager) == true) goto L5;
        r15 = null;
    L5:
        GridLayoutManager r16 = (GridLayoutManager) r15;
        if (r16 == null) goto L45;
        int r17 = r16.getSpanCount();
        RecyclerView.Adapter r0 = r12.getAdapter();
        if (r0 == null) goto L46;
        int r1 = r0.getItemCount();
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L10:
        if (r3 >= r1) goto L25;
        RecyclerView.LayoutManager r7 = r12.getLayoutManager();
        if ((r7 instanceof GridLayoutManager) == true) goto L14;
        r7 = null;
    L14:
        GridLayoutManager r8 = (GridLayoutManager) r7;
        if (r8 == null) goto L19;
        GridLayoutManager.SpanSizeLookup r9 = r8.getSpanSizeLookup();
        if (r9 == null) goto L19;
        int r18 = r9.getSpanSize(r3);
    L20:
        if (r3 > r14) goto L22;
        r5 = r5 + r18;
    L22:
        if (r3 >= r14) goto L24;
        r6 = r6 + r18;
    L24:
        r4 = r4 + r18;
        r3 = r3 + 1;
    L19:
        r18 = 0;
        goto L20
    L25:
        int r19 = this.a;
        if ((r4 - r5) >= r17) goto L28;
        int r110 = 0;
    L30:
        if ((r5 % r17) != 0) goto L32;
        int r20 = 0;
    L33:
        if (r5 > r17) goto L35;
        int r21 = 0;
    L37:
        if ((r6 % r17) == 0) goto L40;
        r2 = r19;
    L40:
        r10.set(r2, r21, r20, r110);
        return;
    L35:
        r21 = r19;
        goto L37
    L32:
        r20 = r19;
        goto L33
    L28:
        r110 = r19;
        goto L30
    L46:
        return;
    }
}
