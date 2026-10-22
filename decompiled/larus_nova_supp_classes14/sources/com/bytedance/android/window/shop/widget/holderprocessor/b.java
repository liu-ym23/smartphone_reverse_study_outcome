package com.bytedance.android.window.shop.widget.holderprocessor;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.holder.WindowHotsaleLatestLiveInfoHolder;
import com.bytedance.android.window.shop.holder.WindowHotsaleLoadMoreHolder;
import com.bytedance.android.window.shop.holder.WindowHotsaleProductHolder;
import com.bytedance.android.window.shop.repository.tab.entity.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends gr3.d {
    public b() {
    }

    @Override // gr3.d
    public final void a(ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f> r9, com.bytedance.android.window.shop.repository.tab.entity.f r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "holder");
        Intrinsics.checkNotNullParameter(r10, "vo");
        if ((r10 instanceof o0) == false) goto L5;
        ((o0) r10).n = Integer.valueOf(r11 + 1);
    L5:
        int r0 = 8;
        if ((r9 instanceof WindowHotsaleProductHolder) == false) goto L51;
        boolean r12 = r10 instanceof sq3.b;
        if (r12 == true) goto L10;
        com.bytedance.android.window.shop.repository.tab.entity.f r4 = null;
    L11:
        sq3.b r5 = (sq3.b) r4;
        if (r5 == null) goto L38;
        boolean r6 = r5.j;
        if (r6 == false) goto L21;
        if (r5.l == false) goto L19;
        Object r7 = gr3.a.f.a;
    L27:
        boolean r8 = r5.k;
        if (r8 == true) goto L30;
    L34:
        if (r8 == false) goto L36;
        Object r13 = gr3.b.C0130b.a;
    L37:
        ((RecyclerView.ViewHolder) r9).itemView.setTag(2131370945, r7);
        ((RecyclerView.ViewHolder) r9).itemView.setTag(2131370946, r13);
        goto L38
    L36:
        r13 = gr3.b.C0130b.a;
        goto L37
    L30:
        if (r5.l == false) goto L34;
        if (r6 == false) goto L33;
        r13 = gr3.b.C0130b.a;
        goto L37
    L33:
        r13 = gr3.b.c.a;
        goto L37
    L19:
        r7 = gr3.a.e.a;
        goto L27
    L21:
        if (r5.l == false) goto L24;
        r7 = gr3.a.g.a;
        goto L27
    L24:
        if (r5.k == false) goto L26;
        r7 = gr3.a.b.a;
        goto L27
    L26:
        r7 = gr3.a.e.a;
    L38:
        if (r12 == true) goto L40;
        r10 = null;
    L40:
        sq3.b r14 = (sq3.b) r10;
        if (r14 != null) goto L44;
        return;
    L44:
        if (r14.k == false) goto L47;
        View r15 = ((RecyclerView.ViewHolder) r9).itemView;
        r15.setPadding(r15.getPaddingLeft(), 0, r15.getPaddingRight(), com.bytedance.android.shopping.extensions.b.b(2));
        return;
    L47:
        if (r14.l == false) goto L49;
        View r16 = ((RecyclerView.ViewHolder) r9).itemView;
        r16.setPadding(r16.getPaddingLeft(), com.bytedance.android.shopping.extensions.b.b(2), r16.getPaddingRight(), com.bytedance.android.shopping.extensions.b.b(8));
        return;
    L49:
        View r17 = ((RecyclerView.ViewHolder) r9).itemView;
        r17.setPadding(r17.getPaddingLeft(), com.bytedance.android.shopping.extensions.b.b(2), r17.getPaddingRight(), com.bytedance.android.shopping.extensions.b.b(2));
        return;
    L10:
        r4 = r10;
        goto L11
    L51:
        if ((r9 instanceof WindowHotsaleLoadMoreHolder) == false) goto L54;
        WindowHotsaleLoadMoreHolder r18 = (WindowHotsaleLoadMoreHolder) r9;
        ((RecyclerView.ViewHolder) r18).itemView.setTag(2131370945, gr3.a.d.a);
        ((RecyclerView.ViewHolder) r18).itemView.setTag(2131370946, gr3.b.C0130b.a);
        return;
    L54:
        if ((r9 instanceof WindowHotsaleLatestLiveInfoHolder) == false) goto L64;
        WindowHotsaleLatestLiveInfoHolder r19 = (WindowHotsaleLatestLiveInfoHolder) r9;
        ((RecyclerView.ViewHolder) r19).itemView.setTag(2131370945, gr3.a.c.a);
        if (r19.getLayoutPosition() == 0) goto L58;
        r0 = 4;
    L58:
        ((RecyclerView.ViewHolder) r19).itemView.setTag(2131370946, new gr3.b.a(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r0))));
        return;
    }
}
