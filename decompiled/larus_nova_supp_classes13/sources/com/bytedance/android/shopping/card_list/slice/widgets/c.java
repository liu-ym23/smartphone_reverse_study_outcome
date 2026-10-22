package com.bytedance.android.shopping.card_list.slice.widgets;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.components.CardListLoadMoreComponent;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.google.android.material.tabs.TabLayout;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
    public final /* synthetic */ CardListHeaderTab a;

    public final void onTabReselected(TabLayout.Tab r1) {
    }

    public c(CardListHeaderTab r1) {
        this.a = r1;
    }

    public final void onTabSelected(TabLayout.Tab r9) {
        Integer r0 = null;
        if (r9 == null) goto L5;
        View r10 = r9.getCustomView();
    L7:
        if ((r10 instanceof m) == true) goto L9;
        r10 = null;
    L9:
        m r11 = (m) r10;
        if (r11 == null) goto L40;
        CardListTrackerComponent r1 = CardListHeaderTab.f(this.a);
        if (r1 == null) goto L35;
        CardListObjectContainer r3 = CardListHeaderTab.d(this.a);
        if (r3 == null) goto L18;
        CardListContainerConfig r4 = r3.f;
        if (r4 == null) goto L18;
        String r5 = r4.getStandardClickEventName();
    L19:
        if (r5 != null) goto L21;
        r5 = "";
    L21:
        Pair[] r6 = new Pair[4];
        com.bytedance.android.shopping.card_list.slice.viewmanagers.i r7 = r11.getCurrentTabItem();
        if (r7 == null) goto L24;
        String r8 = r7.d();
    L25:
        r6[0] = TuplesKt.to("tab_name", r8);
        r6[1] = TuplesKt.to("btm", "c9319.d988420");
        com.bytedance.android.shopping.card_list.slice.viewmanagers.i r12 = r11.getCurrentTabItem();
        if (r12 == null) goto L28;
        String r13 = r12.d();
    L29:
        r6[2] = TuplesKt.to("bcm_description", MapsKt.mapOf(TuplesKt.to("tab", r13)));
        com.bytedance.android.shopping.card_list.slice.viewmanagers.i r14 = r11.getCurrentTabItem();
        if (r14 == null) goto L34;
        com.bytedance.android.shopping.card_list.slice.viewmanagers.a r15 = r14.a();
        if (r15 == null) goto L34;
        r0 = Integer.valueOf(r15.c());
    L34:
        r6[3] = TuplesKt.to("remind_type", r0);
        CardListTrackerComponent.h(r1, r5, MapsKt.mapOf(r6), 4);
        goto L35
    L28:
        r13 = null;
        goto L29
    L24:
        r8 = null;
    L18:
        r5 = null;
    L35:
        CardListLoadMoreComponent r2 = CardListHeaderTab.c(this.a);
        if (r2 == null) goto L38;
        r2.d = true;
    L38:
        r11.e(true, SlcViewExtensionsKt.g(this.a));
        return;
    L40:
        return;
    L5:
        r10 = null;
        goto L7
    }

    public final void onTabUnselected(TabLayout.Tab r3) {
        if (r3 == null) goto L5;
        View r4 = r3.getCustomView();
    L7:
        if ((r4 instanceof m) == true) goto L9;
        r4 = null;
    L9:
        m r5 = (m) r4;
        if (r5 == null) goto L13;
        r5.e(false, null);
        return;
    L13:
        return;
    L5:
        r4 = null;
        goto L7
    }
}
