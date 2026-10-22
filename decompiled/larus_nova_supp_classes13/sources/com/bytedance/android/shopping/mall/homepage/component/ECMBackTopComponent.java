package com.bytedance.android.shopping.mall.homepage.component;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMBackTopComponent extends b {
    public View b;
    public boolean c;

    public static final class a {
    }

    static {
    }

    @Override // u93.b, u93.c
    public final void a() {
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public ECMBackTopComponent() {
    }

    @Override // u93.b, u93.c
    public final void b(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
        IHybridHostService r5 = com.bytedance.android.ec.hybrid.a.h();
        if (r5 == null) goto L9;
        g r6 = r5.getHostAB();
        if (r6 == null) goto L9;
        Boolean r7 = r6.g();
        if (r7 == null) goto L9;
        boolean r8 = r7.booleanValue();
    L10:
        if (r8 == true) goto L28;
        View r9 = r3.findViewById(2131385237);
        this.b = r9;
        if (r9 == null) goto L29;
        ECFMiddleware r10 = p();
        Map r11 = MapsKt.emptyMap();
        Lazy r0 = HybridAppInfoService.a;
        if (HybridAppInfoService.m() == true) goto L16;
    L26:
        r9.setOnClickListener(new com.bytedance.android.shopping.mall.homepage.component.a(this));
        return;
    L16:
        if (Intrinsics.areEqual(r11.get("position_type"), "page") == false) goto L24;
        ViewGroup.LayoutParams r1 = r9.getLayoutParams();
        if ((r1 instanceof FrameLayout.LayoutParams) == true) goto L20;
        r1 = null;
    L20:
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;
        if (r2 == null) goto L24;
        int r12 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r2.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.d(72);
    L24:
        if (Intrinsics.areEqual(r11.get("big_font_enabled"), Boolean.TRUE) == false) goto L26;
        BigFontAdapter.e(r9, 6);
        goto L26
    L29:
        return;
    L28:
        return;
    L9:
        Lazy r13 = HybridAppInfoService.a;
        r8 = HybridAppInfoService.l();
        goto L10
    }

    @Override // u93.b, u93.c
    public final void i(View r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, FreqActions.ACTION_VIEW);
        ECMallFeed r3 = p().b;
        if (r3 == null) goto L6;
        r3.Z(new ECMBackTopComponent$onAfterViewCreated$1(this));
        return;
    }
}
