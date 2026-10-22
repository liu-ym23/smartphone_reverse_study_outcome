package com.bytedance.android.window.shop.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowHeaderAuthorInfoHolder;
import com.bytedance.android.window.shop.repository.dto.b1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowHeaderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderItemDecoration extends RecyclerView.ItemDecoration {
    public WindowHeaderItemDecoration() {
    }

    public final void getItemOffsets(Rect r5, View r6, RecyclerView r7, RecyclerView.State r8) {
        Intrinsics.checkNotNullParameter(r5, "outRect");
        Intrinsics.checkNotNullParameter(r6, "view");
        Intrinsics.checkNotNullParameter(r7, "parent");
        Intrinsics.checkNotNullParameter(r8, "state");
        int r0 = r7.getChildAdapterPosition(r6);
        RecyclerView.ViewHolder r1 = r7.findContainingViewHolder(r6);
        b1 r3 = null;
        if ((r1 instanceof ShopWindowItemHolder) == true) goto L5;
        r1 = null;
    L5:
        ShopWindowItemHolder r2 = (ShopWindowItemHolder) r1;
        if (r2 != null) goto L9;
        super.getItemOffsets(r5, r6, r7, r8);
        return;
    L9:
        RecyclerView.Adapter r9 = r7.getAdapter();
        if ((r9 instanceof WindowTypeSeparatedAdapter) == true) goto L12;
        r9 = null;
    L12:
        WindowTypeSeparatedAdapter r10 = (WindowTypeSeparatedAdapter) r9;
        if (r10 == null) goto L17;
        com.bytedance.android.window.shop.repository.tab.entity.f r11 = (com.bytedance.android.window.shop.repository.tab.entity.f) ListProtector.get(r10.h, r0);
        if (r11 == null) goto L17;
        r3 = r11.g;
    L17:
        int r12 = 0;
        if ((r2 instanceof WindowHeaderAuthorInfoHolder) == true) goto L22;
        if (r3 == null) goto L22;
        int r13 = com.bytedance.android.window.shop.holder.d.a(Integer.valueOf(r3.d()));
    L23:
        r5.top = r13;
        if (r3 == null) goto L26;
        int r14 = com.bytedance.android.window.shop.holder.d.a(Integer.valueOf(r3.b()));
    L27:
        r5.left = r14;
        if (r3 == null) goto L30;
        int r15 = com.bytedance.android.window.shop.holder.d.a(Integer.valueOf(r3.c()));
    L31:
        r5.right = r15;
        if (r3 == null) goto L34;
        r12 = com.bytedance.android.window.shop.holder.d.a(Integer.valueOf(r3.a()));
    L34:
        r5.bottom = r12;
        return;
    L30:
        r15 = 0;
        goto L31
    L26:
        r14 = 0;
    L22:
        r13 = 0;
        goto L23
    }
}
