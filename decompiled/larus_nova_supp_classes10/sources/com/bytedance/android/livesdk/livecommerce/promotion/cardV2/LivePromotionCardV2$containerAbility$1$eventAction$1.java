package com.bytedance.android.livesdk.livecommerce.promotion.cardV2;

import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.PromotionListEventActionImplV2;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.q;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.r;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.s;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.t;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.u;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.v;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.w;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.x;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.y;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionCardV2$containerAbility$1$eventAction$1 implements b {
    public final /* synthetic */ LivePromotionCardV2.a a;

    public final void e() {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L36;
        PromotionListEventActionImplV2 r2 = r0.a.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "promotionParams");
        ql.a r3 = r1.a;
        String r4 = null;
        if ((r3 instanceof ECUIPromotionV2) == true) goto L7;
        r3 = null;
    L7:
        ECUIPromotionV2 r5 = (ECUIPromotionV2) r3;
        if (r5 == null) goto L39;
        v0 r6 = r5.getExtend();
        if (r6 != null) goto L13;
        return;
    L13:
        if (r6.c() == null) goto L40;
        v0 r7 = r5.getExtend();
        if (r7 == null) goto L20;
        s1 r8 = r7.j();
        if (r8 == null) goto L20;
        r4 = r8.c();
    L20:
        boolean r9 = false;
        if (r4 != null) goto L23;
    L26:
        boolean r10 = true;
    L27:
        if (r10 == true) goto L29;
        String r11 = "livesdk_click_" + r4;
    L30:
        oh.a.c("livesdk_click_list_product_bottom", new r(r2, r1, r5));
        if (r11.length() <= 0) goto L33;
        r9 = true;
    L33:
        if (r9 == false) goto L38;
        oh.a.c(r11, new s(r2, r11, r1, r5));
        return;
    L38:
        return;
    L29:
        r11 = "";
        goto L30
    L23:
        if (r4.length() == 0) goto L26;
        r10 = false;
        goto L27
    L40:
        return;
    L39:
        return;
    }

    public final void f() {
        Intrinsics.checkNotNullParameter("livesdk_have_seen_cover_animation_icon", "eventName");
        LivePromotionCardV2 r2 = this.a.a;
        g r3 = r2.c;
        if (r3 == null) goto L6;
        PromotionListEventActionImplV2 r4 = r2.a.j;
        r4.getClass();
        Intrinsics.checkNotNullParameter("livesdk_have_seen_cover_animation_icon", "eventName");
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        oh.a.c("livesdk_have_seen_cover_animation_icon", new t(r4, r3));
        return;
    }

    public final void m() {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L17;
        PromotionListEventActionImplV2 r2 = r0.a.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "promotionParams");
        ECUIPromotionV2 r3 = r1.a;
        if (r3 == null) goto L16;
        ECUIPromotionV2 r4 = r3;
        v0 r5 = r4.getExtend();
        if (r5 == null) goto L11;
        List r6 = r5.g();
        if (r6 == null) goto L11;
        int r7 = r6.size();
    L13:
        if (r2.b.b("livesdk_ecom_gift_bar_show", r4.getPromotionId()) == true) goto L18;
        r2.b.d("livesdk_ecom_gift_bar_show", r4.getPromotionId());
        oh.a.c("livesdk_ecom_gift_bar_show", new w(r2, r1, r7, r4));
        return;
    L18:
        return;
    L11:
        r7 = 0;
        goto L13
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final void o() {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        r0.a.j.n(r1);
        return;
    }

    public final void q() {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        r0.a.j.l(r1);
        return;
    }

    public LivePromotionCardV2$containerAbility$1$eventAction$1(LivePromotionCardV2.a r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.b
    public final void a(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        g r0 = this.a.a.c;
        if (r0 == null) goto L8;
        ql.a r1 = r0.a;
        if (r1 == null) goto L9;
        r1.appendExtraEventParams(r2);
        return;
    L9:
        return;
    }

    public final void d(int r5) {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L9;
        PromotionListEventActionImplV2 r2 = r0.a.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "promotionParams");
        ECUIPromotionV2 r3 = r1.a;
        if (r3 == null) goto L8;
        oh.a.c("livesdk_ecom_gift_bar_click", new q(r2, r1, r5, r3));
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final void g(String r3) {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        r0.a.j.c(r1, r3);
        return;
    }

    public final void h(String r3) {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        r0.a.j.b(r1, r3);
        return;
    }

    public final void i(String r3) {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        r0.a.j.d(r1, r3);
        return;
    }

    public final void j(String r3) {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        r0.a.j.e(r1, r3);
        return;
    }

    public final void k(ECHotAtmosphere r5) {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        PromotionListEventActionImplV2 r2 = r0.a.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "promotionParams");
        oh.a.c("recordHotAtmosphereEvent", new u(r2, r1, r5, r1.a));
        return;
    }

    public final void n(boolean r4) {
        if (r4 == false) goto L6;
        LivePromotionCardV2 r5 = this.a.a;
        final g r0 = r5.c;
        if (r0 == null) goto L10;
        r5.a.e.c("livesdk_show_have_seen_label", r0.a.getPromotionId(), new LivePromotionCardV2$containerAbility$1$eventAction$1$doShowHaveSeenLabelEvent$$inlined$also$lambda$1(r0, this));
        return;
    L10:
        return;
    L6:
        LivePromotionCardV2 r6 = this.a.a;
        g r1 = r6.c;
        if (r1 == null) goto L12;
        r6.a.j.m(r1);
        return;
    }

    public final void c(String r4, String r5) {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        r0.a.j.h(r1, true, r4, r5);
        return;
    }

    public final void l(String r6, com.bytedance.android.btm.api.model.d r7) {
        Intrinsics.checkNotNullParameter(r6, "atmosphereType");
        Intrinsics.checkNotNullParameter(r7, "btmModel");
        LivePromotionCardV2 r2 = this.a.a;
        g r3 = r2.c;
        if (r3 == null) goto L6;
        PromotionListEventActionImplV2 r4 = r2.a.j;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        Intrinsics.checkNotNullParameter(r6, "atmosphereType");
        Intrinsics.checkNotNullParameter(r7, "btmModel");
        oh.a.c("livesdk_show_auction_hot_sale", new v(r4, r3, r6, r7));
        return;
    }

    public final void p(Map<String, String> r4, KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r5) {
        g r0 = this.a.a.c;
        String r1 = null;
        if (r0 == null) goto L7;
        ql.a r2 = r0.a;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.getIronIndex());
    L8:
        if (r5 == null) goto L13;
        if (r3 == null) goto L13;
        int r6 = r3.intValue();
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r7 = this.a.a.a.a;
        if (r7 == null) goto L13;
        r1 = r7.a(r5, r6);
    L13:
        LivePromotionCardV2 r8 = this.a.a;
        r8.a.j.a(r4, r8.c, r1);
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void r(Map<String, String> r4, KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r5) {
        g r0 = this.a.a.c;
        String r1 = null;
        if (r0 == null) goto L7;
        ql.a r2 = r0.a;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.getIronIndex());
    L8:
        if (r5 == null) goto L13;
        if (r3 == null) goto L13;
        int r6 = r3.intValue();
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r7 = this.a.a.a.a;
        if (r7 == null) goto L13;
        r1 = r7.a(r5, r6);
    L13:
        LivePromotionCardV2 r8 = this.a.a;
        g r9 = r8.c;
        if (r9 == null) goto L17;
        r8.a.j.f(r4, r9, r1);
        return;
    L17:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void s(String r4, String r5) {
        LivePromotionCardV2 r0 = this.a.a;
        g r1 = r0.c;
        if (r1 == null) goto L6;
        PromotionListEventActionImplV2 r2 = r0.a.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, "promotionParams");
        oh.a.c("ECSubShopCartEvent", new x(r2, r1, r4, r5));
        oh.a.c("doClickSubCartForDouPlus", new y(r2, r1));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.cardV2.b
    public final void b(String r4, Map<String, String> r5, KProperty1<com.bytedance.android.livesdk.livecommerce.promotion.card.g.a, String> r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        g r0 = this.a.a.c;
        if (r0 == null) goto L24;
        ql.a r1 = r0.a;
        if (r1 == null) goto L25;
        ql.b r2 = r1.getClientData();
        if (r2 != null) goto L9;
        return;
    L9:
        if (r2.b != true) goto L27;
        g r3 = this.a.a.c;
        String r7 = null;
        if (r3 == null) goto L16;
        ql.a r8 = r3.a;
        if (r8 == null) goto L16;
        Integer r9 = Integer.valueOf(r8.getIronIndex());
    L17:
        if (r6 == null) goto L22;
        if (r9 == null) goto L22;
        int r10 = r9.intValue();
        com.bytedance.android.livesdk.livecommerce.promotion.card.g.a r11 = this.a.a.a.a;
        if (r11 == null) goto L22;
        r7 = r11.a(r6, r10);
    L22:
        LivePromotionCardV2 r12 = this.a.a;
        r12.a.j.k(r4, r5, r7, r12.c);
        return;
    L16:
        r9 = null;
        goto L17
    L27:
        return;
    L25:
        return;
    }
}
