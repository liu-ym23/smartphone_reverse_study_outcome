package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.shopping.new_cart.components.CartLoadMoreComponent;
import com.bytedance.android.shopping.new_cart.slice.viewmanagers.u;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.google.android.material.tabs.TabLayout;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
    public final /* synthetic */ CartHeaderTab a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public b(CartHeaderTab r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r9) {
        Integer r0 = null;
        if (r9 == null) goto L5;
        View r10 = r9.getCustomView();
    L7:
        if ((r10 instanceof o) == true) goto L9;
        r10 = null;
    L9:
        o r11 = (o) r10;
        if (r11 == null) goto L32;
        CartViewModel r2 = CartHeaderTab.d(this.a);
        if (r2 == null) goto L27;
        Pair[] r4 = new Pair[4];
        u r5 = r11.getCurrentTabItem();
        if (r5 == null) goto L16;
        String r6 = r5.d();
    L17:
        r4[0] = TuplesKt.to("tab_name", r6);
        r4[1] = TuplesKt.to("btm", "c9319.d988420");
        u r7 = r11.getCurrentTabItem();
        if (r7 == null) goto L20;
        String r8 = r7.d();
    L21:
        r4[2] = TuplesKt.to("bcm_description", MapsKt.mapOf(TuplesKt.to("tab", r8)));
        u r12 = r11.getCurrentTabItem();
        if (r12 == null) goto L26;
        com.bytedance.android.shopping.new_cart.slice.viewmanagers.a r13 = r12.a();
        if (r13 == null) goto L26;
        r0 = Integer.valueOf(r13.c());
    L26:
        r4[3] = TuplesKt.to("remind_type", r0);
        CartViewModel.doEventAction$default(r2, "cart_list_tab_click", MapsKt.mapOf(r4), null, 4, null);
        goto L27
    L20:
        r8 = null;
        goto L21
    L16:
        r6 = null;
    L27:
        CartLoadMoreComponent r1 = CartHeaderTab.c(this.a);
        if (r1 == null) goto L30;
        r1.b = true;
    L30:
        r11.d(true, SlcViewExtensionsKt.g(this.a));
        return;
    L32:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public final void onTabUnselected(TabLayout.Tab r3) {
        if (r3 == null) goto L5;
        View r4 = r3.getCustomView();
    L7:
        if ((r4 instanceof o) == true) goto L9;
        r4 = null;
    L9:
        o r5 = (o) r4;
        if (r5 == null) goto L13;
        r5.d(false, null);
        return;
    L13:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
