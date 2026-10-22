package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.presenter;

import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d implements View.OnLongClickListener {
    public final /* synthetic */ f a;

    public d(f r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r19) {
        f r1 = this.a;
        String r3 = null;
        il2.a r4 = r1.h.b.b(null);
        if (r4 == null) goto L5;
        il2.a r2 = il2.a.C0145a.a(r4, "long_press_card", null, false, null, null, null, 62);
    L6:
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r5 = r1.e;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L9:
        ql.a r6 = r5.a.a;
        if ((r6 instanceof ECUIPromotionV2) == true) goto L12;
        r6 = null;
    L12:
        ECUIPromotionV2 r16 = (ECUIPromotionV2) r6;
        if (r16 == null) goto L36;
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r7 = r1.h.a;
        if (r7 == null) goto L18;
        r3 = r7.a(PromotionCardGroupPresenter$onLongPress$btm$1.INSTANCE, r16.getIronIndex());
    L18:
        if (r2 == null) goto L20;
        ((LiveActionTracker) r2).g = BtmUtilsKt.e(r3, PageFinder.via(r1.y()));
    L20:
        com.bytedance.android.ec.model.response.d r8 = r16.getBlank();
        if (r8 == null) goto L30;
        j0 r9 = r8.a();
        if (r9 == null) goto L30;
        if (r2 == null) goto L26;
        il2.a.C0145a.a(r2, "check_long_press", MapsKt.mapOf(TuplesKt.to("action", r9)), false, null, null, null, 60);
    L26:
        jf.d r10 = r1.h.g;
        Context r11 = r1.u().c();
        com.bytedance.android.livesdk.livecommerce.promotion.card.h r12 = r1.e;
        if (r12 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("promotionCardItem");
    L29:
        char r13 = 0;
        jf.d.b.b(r10, r11, "blank", 2, r12.a, r9, 0, 1, null, null, r2, 416);
        int r14 = 2;
    L35:
        xh.a r15 = xh.c.a("Live");
        Pair[] r17 = new Pair[r14];
        r17[r13] = TuplesKt.to("promotion_id", r16.getPromotionId());
        r17[1] = TuplesKt.to("product_id", r16.getProductId());
        r15.g(MapsKt.mapOf(r17));
    L30:
        r14 = 2;
        r13 = 0;
        if (r2 == null) goto L35;
        il2.a r18 = il2.a.C0145a.a(r2, "long_press_action_empty", null, false, null, null, null, 62);
        if (r18 == null) goto L35;
        ((LiveActionTracker) r18).e(false);
        Unit r20 = Unit.INSTANCE;
    L36:
        return true;
    L5:
        r2 = null;
        goto L6
    }
}
