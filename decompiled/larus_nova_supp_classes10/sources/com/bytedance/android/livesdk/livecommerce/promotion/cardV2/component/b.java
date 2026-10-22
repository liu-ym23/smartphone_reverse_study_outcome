package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.component;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.model.response.j0;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardV2$containerAbility$1$eventAction$1;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget.ECProductBottomGeneralView;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements ECProductBottomGeneralView.a {
    public final /* synthetic */ PromotionCardBottomComponent a;
    public final /* synthetic */ v0 b;

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.widget.ECProductBottomGeneralView.a
    public final void onClick() {
        com.bytedance.android.btm.api.model.d r9 = BtmUtilsKt.e(this.b.d(), PageFinder.via(this.a));
        LivePromotionCardArgsV2 r1 = this.a.b;
        if (r1 == null) goto L9;
        ILivePromotionCardContainerHandler r2 = r1.b;
        if (r2 == null) goto L9;
        il2.a r10 = r2.b(r9);
        if (r10 == null) goto L9;
        il2.a r3 = il2.a.C0145a.a(r10, "click_product_bottom", MapsKt.mapOf(new Pair[]{TuplesKt.to("click_area", "product_bottom"), TuplesKt.to("extend_type", String.valueOf(this.b.e()))}), false, null, null, null, 60);
    L10:
        j0 r6 = this.b.a();
        if (r6 == null) goto L17;
        if (r3 == null) goto L14;
        il2.a.C0145a.a(r3, "check_product_bottom", MapsKt.mapOf(TuplesKt.to("action", r6)), false, null, null, null, 60);
    L14:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r4 = this.a.c;
        if (r4 == null) goto L21;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.b(r4, "matching_button", null, r6, 0, null, r9, r3, 56);
    L21:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r5 = this.a.c;
        if (r5 == null) goto L24;
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a.C0088a.c(r5, "matching_button", this.b.d(), this.a, 10);
    L24:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r7 = this.a.c;
        if (r7 == null) goto L30;
        LivePromotionCardV2$containerAbility$1$eventAction$1 r8 = r7.b();
        if (r8 == null) goto L31;
        r8.e();
        return;
    L31:
        return;
    L30:
        return;
    L17:
        if (r3 == null) goto L21;
        il2.a r11 = il2.a.C0145a.a(r3, "check_product_bottom", null, false, "action_is_null", null, null, 50);
        if (r11 == null) goto L21;
        ((LiveActionTracker) r11).e(false);
        Unit r12 = Unit.INSTANCE;
    L9:
        r3 = null;
        goto L10
    }

    public b(PromotionCardBottomComponent r1, v0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
