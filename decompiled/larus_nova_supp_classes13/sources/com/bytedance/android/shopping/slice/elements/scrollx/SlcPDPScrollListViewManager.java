package com.bytedance.android.shopping.slice.elements.scrollx;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.hybrid.list.util.CommonUtilKt;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.list.SlcListElementView;
import com.bytedance.android.ecom.arch.slice.render.elements.list.c;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SlcPDPScrollListViewManager extends c {
    public static final /* synthetic */ int X3 = 0;
    public Integer W3;

    public SlcPDPScrollListViewManager(SlcTemplateContext r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    public final /* bridge */ /* synthetic */ View A0(Context r1) {
        return o1(r1);
    }

    public final void H0(Map<String, ? extends Object> r9) {
        Intrinsics.checkNotNullParameter(r9, "props");
        Integer r0 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r9.get("view_width"));
        final int r1 = -1;
        if (r0 == null) goto L5;
        final int r2 = r0.intValue();
    L6:
        Integer r3 = com.bytedance.android.ecom.arch.slice.render.util.b.i(r9.get("target_index"));
        boolean r4 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r9.get("disable_scroll_gesture"));
        if (r3 != null) goto L12;
        String r5 = com.bytedance.android.ecom.arch.slice.render.util.b.r(r9.get("spec_id"));
        List r6 = com.bytedance.android.ecom.arch.slice.render.util.b.s(r9.get("spec_ids"));
        if (r6 == null) goto L13;
        if (r5 == null) goto L13;
        r1 = ((ArrayList) r6).indexOf(r5);
    L13:
        boolean r7 = true;
        if (r1 < 0) goto L16;
        boolean r8 = true;
    L17:
        Integer r10 = this.W3;
        Object r11 = null;
        if (r10 != null) goto L21;
    L32:
        if (r8 == false) goto L38;
        if (r7 == false) goto L38;
        if (getView().getWidth() <= 0) goto L37;
        q1(r1, r2);
        goto L38
    L37:
        CommonUtilKt.g(new SlcPDPScrollListViewManager$onUpdateProp$1(this, r1, r2));
    L38:
        boolean r12 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r9.get("enable_gesture_opt"));
        View r13 = getView();
        if ((r13 instanceof a) == false) goto L42;
        r11 = r13;
    L42:
        a r14 = (a) r11;
        if (r14 == null) goto L46;
        r14.e = r4;
        r14.f.e = r12;
        return;
    L46:
        return;
    L21:
        if (r10.intValue() != r1) goto L32;
        RecyclerView.ViewHolder r15 = getView().findViewHolderForAdapterPosition(r1);
        if (r15 == null) goto L25;
        View r16 = r15.itemView;
    L26:
        if (r16 == null) goto L28;
        boolean r17 = true;
    L29:
        if (r17 == false) goto L32;
        r7 = false;
        goto L32
    L28:
        r17 = false;
        goto L29
    L25:
        r16 = null;
        goto L26
    L16:
        r8 = false;
        goto L17
    L12:
        r1 = r3.intValue();
        goto L13
    L5:
        r2 = -1;
        goto L6
    }

    public final void n1(SlcListElementView r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        super.n1(r2);
        r2.setOverScrollMode(2);
    }

    public final SlcListElementView o1(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return new a(r2);
    }

    public final /* bridge */ /* synthetic */ void x0(View r1) {
        n1((SlcListElementView) r1);
    }

    public final void q1(int r5, int r6) {
        if (getView().canScrollHorizontally(-1) == false) goto L5;
    L7:
        RecyclerView.ViewHolder r0 = getView().findViewHolderForAdapterPosition(r5);
        LinearLayoutManager r1 = null;
        if (r0 == null) goto L10;
        View r2 = r0.itemView;
    L12:
        if (r2 == null) goto L14;
        r6 = r2.getWidth();
    L20:
        if (r2 != null) goto L28;
        LinearLayoutManager r3 = getView().getLayoutManager();
        if ((r3 instanceof LinearLayoutManager) == false) goto L25;
        r1 = r3;
    L25:
        LinearLayoutManager r4 = r1;
        if (r4 == null) goto L29;
        r4.scrollToPositionWithOffset(r5, (getView().getWidth() - r6) / 2);
    L29:
        this.W3 = Integer.valueOf(r5);
        return;
    L28:
        getView().smoothScrollBy(r2.getLeft() - ((getView().getWidth() - r6) / 2), 0);
        goto L29
    L14:
        if (r6 > 0) goto L20;
        View r7 = (View) CollectionsKt.getOrNull(com.bytedance.commerce.base.view.b.a(getView()), 0);
        if (r7 == null) goto L19;
        r6 = r7.getWidth();
        goto L20
    L19:
        r6 = com.bytedance.android.shopping.extensions.b.a(52);
        goto L20
    L10:
        r2 = null;
        goto L12
    L5:
        if (getView().canScrollHorizontally(1) == true) goto L7;
    }
}
