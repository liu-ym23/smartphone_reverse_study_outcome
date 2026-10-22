package com.bytedance.android.shopping.buynow.controller;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w {
    public boolean a;
    public final AndroidYaTaInstance b;
    public final BuyNowViewModel c;
    public final View d;
    public final View e;
    public final RecyclerView f;

    public static final void a(w r10, boolean r11) {
        AndroidYaTaInstance r0 = r10.b;
        String r1 = null;
        if (r0 == null) goto L7;
        Map r2 = r0.j();
        if (r2 == null) goto L7;
        Object r3 = r2.get("header_ceiling");
    L9:
        if ((r3 instanceof Map) == true) goto L11;
        r3 = null;
    L11:
        Map r4 = (Map) r3;
        if (r4 == null) goto L37;
        Object r5 = r4.get("target_component_name");
        if ((r5 instanceof String) == true) goto L16;
        r5 = null;
    L16:
        String r6 = (String) r5;
        if (r6 == null) goto L51;
        Object r7 = r4.get("target_yata_key");
        if ((r7 instanceof String) == true) goto L22;
        r7 = null;
    L22:
        String r8 = (String) r7;
        if (r8 == null) goto L52;
        com.bytedance.kmp.ec.yata.store.node.c r9 = com.bytedance.android.shopping.buynow.utils.h.a(r10.b, r6, r8);
        AndroidYaTaInstance r12 = r10.b;
        if (r12 == null) goto L45;
        YataEventCenter r13 = r12.k();
        if (r13 == null) goto L45;
        com.bytedance.kmp.ec.yata.event.common.e.a r14 = com.bytedance.kmp.ec.yata.event.common.e.a;
        AndroidYaTaInstance r15 = r10.b;
        if (r9 == null) goto L32;
        r1 = r9.getKey();
    L32:
        String r16 = r1;
        if (r11 == false) goto L35;
        String r17 = "exchangeToCeiling";
    L36:
        r13.d(r14.a(r15, null, r16, r17, null, "calcVisibility"));
        goto L45
    L35:
        r17 = "exchangToNoCeiling";
    L45:
        com.bytedance.android.shopping.buynow.tracker.a r18 = r10.c.getTracker();
        if (r11 == false) goto L48;
        String r19 = "1";
    L49:
        r18.a(MapsKt.mapOf(TuplesKt.to("is_ceiling", r19)));
        return;
    L48:
        r19 = "0";
        goto L49
    L52:
        return;
    L51:
        return;
    L37:
        View r20 = r10.e;
        int r21 = 8;
        if (r11 == false) goto L40;
        int r22 = 0;
    L41:
        r20.setVisibility(r22);
        View r23 = r10.d;
        if (r11 == true) goto L44;
        r21 = 0;
    L44:
        r23.setVisibility(r21);
        goto L45
    L40:
        r22 = 8;
    L7:
        r3 = null;
        goto L9
    }

    public w(AndroidYaTaInstance r2, BuyNowViewModel r3, View r4, View r5, RecyclerView r6) {
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "headerContainer");
        Intrinsics.checkNotNullParameter(r5, "ceilingHeaderContainer");
        Intrinsics.checkNotNullParameter(r6, "bodyContainer");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
