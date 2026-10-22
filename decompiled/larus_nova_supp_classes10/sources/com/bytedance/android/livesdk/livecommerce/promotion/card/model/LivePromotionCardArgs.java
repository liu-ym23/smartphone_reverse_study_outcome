package com.bytedance.android.livesdk.livecommerce.promotion.card.model;

import android.view.View;
import bk2.b;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.card.e;
import com.bytedance.android.livesdk.livecommerce.promotion.card.g;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImpl;
import il.a;
import jf.c;
import jf.d;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionCardArgs extends g {
    public final b f;
    public final d g;
    public final PromotionListEventActionImpl h;

    public LivePromotionCardArgs(g r10) {
        Intrinsics.checkNotNullParameter(r10, "args");
        g.a r2 = r10.a;
        ILivePromotionCardContainerHandler r0 = r10.b;
        c r7 = r10.c;
        e r8 = r10.d;
        a r11 = r10.e;
        Intrinsics.checkNotNullParameter(r0, "containerHandler");
        Intrinsics.checkNotNullParameter(r11, "historyMap");
        super(r2, r0, r7, r8, r11);
        b r1 = new b();
        this.f = r1;
        fi2.c.a r3 = fi2.c.a;
        this.g = fi2.c.a(r1, r7, r0.g());
        this.h = new PromotionListEventActionImpl(r8, r11);
    }

    public final void a(com.bytedance.android.ec.common.api.jump.model.e r13, String r14, boolean r15, String r16, BtmItemBuilder r17, View r18) {
        Intrinsics.checkNotNullParameter(r13, "promotionParams");
        Intrinsics.checkNotNullParameter(r14, "clickArea");
        e r6 = this.d;
        if (r6 == null) goto L7;
        boolean r3 = true;
        if (r6.a("livesdk_click_product", MapsKt.emptyMap(), r16, r13.a, LivePromotionCardArgs$recordClickEventByIntercept$intercept$1.INSTANCE) != true) goto L7;
    L8:
        if (r3 == false) goto L10;
        return;
    L10:
        d.b.f(this.g, r13.b, r14, r15, r16, r17, r18, false, 64);
        return;
    L7:
        r3 = false;
        goto L8
    }

    public static /* synthetic */ void b(LivePromotionCardArgs r8, com.bytedance.android.ec.common.api.jump.model.e r9, String r10, String r11, BtmItemBuilder r12, View r13, int r14) {
        if ((r14 & 4) == 0) goto L5;
        boolean r4 = true;
    L7:
        if ((r14 & 16) == 0) goto L9;
        BtmItemBuilder r6 = null;
    L11:
        if ((r14 & 32) == 0) goto L13;
        View r7 = null;
    L14:
        r8.a(r9, r10, r4, r11, r6, r7);
        return;
    L13:
        r7 = r13;
        goto L14
    L9:
        r6 = r12;
        goto L11
    L5:
        r4 = false;
        goto L7
    }
}
