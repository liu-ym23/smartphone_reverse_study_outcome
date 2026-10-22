package com.bytedance.android.livesdk.livecommerce.promotion.cardV2;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.e;
import com.bytedance.android.livesdk.livecommerce.promotion.card.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImplV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionCardArgsV2 extends g {
    public final bk2.b f;
    public final jf.d g;
    public final w83.d<? extends w83.c> h;
    public final Lazy<i> i;
    public final PromotionListEventActionImplV2 j;
    public final Function0<com.bytedance.android.ec.common.api.jump.model.g> k;

    public LivePromotionCardArgsV2(g r12, final Context r13, Function0<com.bytedance.android.ec.common.api.jump.model.g> r14) {
        Intrinsics.checkNotNullParameter(r12, "args");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "getPromotionParams");
        g.a r3 = r12.a;
        final ILivePromotionCardContainerHandler r8 = r12.b;
        jf.c r9 = r12.c;
        e r10 = r12.d;
        il.a r15 = r12.e;
        Intrinsics.checkNotNullParameter(r8, "containerHandler");
        Intrinsics.checkNotNullParameter(r15, "historyMap");
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r14, "getPromotionParams");
        super(r3, r8, r9, r10, r15);
        this.k = r14;
        bk2.b r0 = new bk2.b();
        this.f = r0;
        fi2.c.a r1 = fi2.c.a;
        jf.d r2 = fi2.c.a(r0, r9, r8.g());
        this.g = r2;
        gj2.a r4 = new gj2.a(r15, r2, r14, r8);
        int r16 = ECSdk.a;
        w83.g r17 = (w83.g) ECSdk.a(w83.g.class);
        if (r17 == null) goto L6;
        w83.d<? extends w83.c> r18 = r17.b(r4);
        if (r18 == null) goto L6;
    L7:
        this.h = r18;
        this.i = LazyKt.lazy(new LivePromotionCardArgsV2$ligoViewManager$1(this, r13, r8));
        this.j = new PromotionListEventActionImplV2(r10, r15);
        return;
    L6:
        r18 = new y83.b(new c());
        goto L7
    }

    public final void a(com.bytedance.android.ec.common.api.jump.model.g r11, String r12, boolean r13, String r14, BtmItemBuilder r15, View r16) {
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
        Intrinsics.checkNotNullParameter(r12, "clickArea");
        e r4 = this.d;
        if (r4 == null) goto L7;
        boolean r1 = r4.a("livesdk_click_product", MapsKt.emptyMap(), r14, r11.a, LivePromotionCardArgsV2$recordClickEventByIntercept$intercept$1.INSTANCE);
        boolean r5 = true;
        if (r1 != true) goto L7;
    L8:
        if (r5 == false) goto L10;
        return;
    L10:
        this.g.g(r11, r12, r13, r14, r15, r16, true);
        return;
    L7:
        r5 = false;
        goto L8
    }
}
