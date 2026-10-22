package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionBottomBanner;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionListEventActionImpl implements com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f {
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.e a;
    public final il.a b;

    public static final class a implements Runnable {
        public final /* synthetic */ PromotionListEventActionImpl a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, boolean r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PromotionListEventActionImpl.g(this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ PromotionListEventActionImpl a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;

        public b(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.l(this.b, "add_to_cart");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ PromotionListEventActionImpl a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public c(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, boolean r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PromotionListEventActionImpl.g(this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ PromotionListEventActionImpl a;
        public final /* synthetic */ ECUIPromotion b;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;
        public final /* synthetic */ String d;

        public d(PromotionListEventActionImpl r1, ECUIPromotion r2, com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            StringBuilder r1 = new StringBuilder("livesdk_");
            ECPromotionBottomBanner r2 = this.b.bottomBanner;
            Map r3 = null;
            if (r2 == null) goto L5;
            String r4 = r2.getTrackName();
        L6:
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r1.append(r4);
            r1.append("_click");
            sg2.v r0 = new sg2.v(r1.toString(), this.c);
            r0.c("product_id", this.b.getProductId());
            ECPromotionBottomBanner r5 = this.b.bottomBanner;
            if (r5 == null) goto L11;
            r3 = r5.getTrackParam();
        L11:
            r0.d(r3);
            PromotionListEventActionImplKt.a(r0, this.a.a, this.d);
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ PromotionListEventActionImpl a;
        public final /* synthetic */ ECUIPromotion b;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;
        public final /* synthetic */ String d;

        public e(PromotionListEventActionImpl r1, ECUIPromotion r2, com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            StringBuilder r1 = new StringBuilder("livesdk_");
            ECPromotionBottomBanner r2 = this.b.bottomBanner;
            Map r3 = null;
            if (r2 == null) goto L5;
            String r4 = r2.getTrackName();
        L6:
            if (r4 != null) goto L8;
            r4 = "";
        L8:
            r1.append(r4);
            r1.append("_show");
            sg2.v r0 = new sg2.v(r1.toString(), this.c);
            r0.c("product_id", this.b.getProductId());
            ECPromotionBottomBanner r5 = this.b.bottomBanner;
            if (r5 == null) goto L11;
            r3 = r5.getTrackParam();
        L11:
            r0.d(r3);
            PromotionListEventActionImplKt.a(r0, this.a.a, this.d);
            return;
        L5:
            r4 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ PromotionListEventActionImpl a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;

        public f(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, String r3, boolean r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            com.bytedance.android.ec.common.api.jump.model.g r0 = this.b;
            ql.a r1 = r0.a;
            sg2.v r2 = new sg2.v(this.c, r0);
            sl.q r3 = r1.getClientData().e;
            if (r3 == null) goto L5;
            Map r4 = r3.b();
        L6:
            r2.d(r4);
            if (this.d == false) goto L9;
            String r5 = "user";
        L10:
            r2.c("close_type", r5);
            PromotionListEventActionImplKt.a(r2, this.a.a, this.e);
            return;
        L9:
            r5 = "auto";
            goto L10
        L5:
            r4 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ PromotionListEventActionImpl a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ ECUIPromotion c;

        public g(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, ECUIPromotion r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            sg2.v r0 = new sg2.v("livesdk_show_have_seen_label", this.b);
            r0.c("product_id", this.c.getProductId());
            ECPromotion.FlickerIcon r1 = this.c.flickerIconV2;
            if (r1 == null) goto L5;
            String r2 = r1.eventTag;
        L6:
            r0.c("tag_name", r2);
            PromotionListEventActionImplKt.a(r0, this.a.a, null);
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ ECUIPromotion a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ PromotionListEventActionImpl c;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g d;
        public final /* synthetic */ String e;

        public h(ECUIPromotion r1, Map r2, PromotionListEventActionImpl r3, com.bytedance.android.ec.common.api.jump.model.g r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            com.bytedance.android.ec.common.api.jump.model.b r1 = this.d;
            if (r1 != null) goto L5;
            r1 = com.bytedance.android.ec.common.api.jump.model.b.a;
        L5:
            sg2.v r0 = new sg2.v("livesdk_show_product_info", r1);
            ECUIPromotion r2 = this.a;
            if (r2 == null) goto L8;
            String r3 = r2.getProductId();
        L9:
            r0.c("product_id", r3);
            ECUIPromotion r4 = this.a;
            if (r4 == null) goto L22;
            r0.d(r4.getEventParams());
            r0.c("product_id", r4.getProductId());
            if (r4.isOnExplain() == false) goto L14;
            String r5 = "1";
        L15:
            r0.c("is_explaining", r5);
            int r6 = 1;
            r0.a("with_sku", !r4.getSingleSku() ? 1 : 0);
            r0.a("local_num", r4.getLocalNum());
            ECUIAskExplainInfo r7 = r4.getAskExplainInfo();
            if (r7 != null) goto L18;
        L20:
            r6 = 0;
        L21:
            r0.a("is_explain_apply", r6);
            goto L22
        L18:
            if (r7.isAsked() != true) goto L20;
        L14:
            r5 = BDLocationException.ERROR_TIMEOUT;
        L22:
            r0.d(this.b);
            PromotionListEventActionImplKt.a(r0, this.c.a, this.e);
            return;
        L8:
            r3 = null;
            goto L9
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class i implements Runnable {
        public final /* synthetic */ PromotionListEventActionImpl a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ LiveRoomParams c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ String e;

        public i(PromotionListEventActionImpl r1, com.bytedance.android.ec.common.api.jump.model.g r2, LiveRoomParams r3, Map r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void a() {
            sg2.v r0 = new sg2.v("livesdk_show_store_info", this.b);
            LiveRoomParams r1 = this.c;
            String r2 = null;
            if (r1 == null) goto L5;
            String r3 = r1.getAuthorId();
        L6:
            r0.c("live_anchor_id", r3);
            r0.c("entrance_location", "live_product_card");
            r0.c("store_type", "shop");
            LiveRoomParams r4 = this.c;
            if (r4 == null) goto L9;
            String r5 = r4.getEnterFromMerge();
        L10:
            r0.c("store_source_page", r5);
            LiveRoomParams r6 = this.c;
            if (r6 == null) goto L13;
            r2 = r6.getEnterMethod();
        L13:
            r0.c("store_source_method", r2);
            r0.c("store_group_type", "live");
            r0.d(this.d);
            PromotionListEventActionImplKt.a(r0, this.a.a, this.e);
            return;
        L9:
            r5 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void j(final com.bytedance.android.ec.common.api.jump.model.g r5) {
        Intrinsics.checkNotNullParameter(r5, "promotionParams");
        final ql.a r0 = r5.a;
        this.b.c("livesdk_show_invalid_product", r0.getPromotionId(), new PromotionListEventActionImpl$doShowFindSimilarEvent$1(this, r5, r0));
    }

    public final void k(com.bytedance.android.ec.common.api.jump.model.g r3) {
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        ECUIPromotion r0 = r3.a;
        if (r0 == null) goto L7;
        oh.a.c("doShowHaveSeenLabelEvent", new g(this, r3, r0));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    public PromotionListEventActionImpl(com.bytedance.android.livesdk.livecommerce.promotion.card.e r2, il.a r3) {
        Intrinsics.checkNotNullParameter(r3, "eventMap");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void b(com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        oh.a.c("ECExplainReplayEntranceEvent", new p(this, r3, "livesdk_explain_replay_entrance_show", r4));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void c(com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        oh.a.c("ECExplainReplayEntranceEvent", new p(this, r3, "livesdk_explain_replay_entrance_click", r4));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void d(com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        ECUIPromotion r0 = r3.a;
        if (r0 == null) goto L7;
        oh.a.c("ExplainStatusClickEvent", new d(this, r0, r3, r4));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void e(com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        ECUIPromotion r0 = r3.a;
        if (r0 == null) goto L7;
        oh.a.c("ExplainStatusShowEvent", new e(this, r0, r3, r4));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    public final void l(com.bytedance.android.ec.common.api.jump.model.g r8, String r9) {
        LiveRoomParams r0 = r8.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        ECUIPromotion r10 = r8.a;
        if (r10 == null) goto L59;
        ECUIPromotion r11 = r10;
        boolean r1 = EntryController.M1;
        String r2 = null;
        if (r0 == null) goto L7;
        String r3 = r0.getRoomId();
    L8:
        if (r0 == null) goto L10;
        String r4 = r0.getRoomUniqueKey();
    L11:
        ak2.m r5 = EntryController.a.b(r3, r4).F;
        if (r5 == null) goto L62;
        JSONObject r6 = new JSONObject();
        r6.put("shop_id", r11.getShopId());     // Catch: Exception -> L54
        r6.put("product_id", r11.getProductId());     // Catch: Exception -> L54
        r6.put("promotion_id", r11.getPromotionId());     // Catch: Exception -> L54
        if (r0 == null) goto L18;
        String r7 = r0.getAuthorId();     // Catch: Exception -> L54
    L19:
        String r12 = "";
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        r6.put("anchor_id", r7);     // Catch: Exception -> L54
        if (hh2.f.e() == false) goto L32;
        if (r0 == null) goto L27;
        String r13 = r0.getAuthorId();     // Catch: Exception -> L54
    L28:
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        r6.put("anchor_open_id", r13);     // Catch: Exception -> L54
        goto L32
    L27:
        r13 = null;
    L32:
        if (r0 == null) goto L34;
        String r14 = r0.getRoomId();     // Catch: Exception -> L54
    L35:
        if (r14 == null) goto L38;
        r12 = r14;
    L38:
        r6.put("room_id", r12);     // Catch: Exception -> L54
        r6.put("commodity_id", r11.getPromotionId());     // Catch: Exception -> L54
        String r15 = r11.getEventItemType();     // Catch: Exception -> L54
        if (r15 != null) goto L41;
        r15 = "-1";
    L41:
        r6.put("commodity_type", r15);     // Catch: Exception -> L54
        r6.put("commodity_price", (int) (CastFloatProtector.parseFloat(r11.price) * 100));     // Catch: Exception -> L54
        if (r0 == null) goto L44;
        String r16 = r0.getActionType();     // Catch: Exception -> L54
    L45:
        r6.put("action_type", r16);     // Catch: Exception -> L54
        if (r0 == null) goto L48;
        String r17 = r0.getEnterFromMerge();     // Catch: Exception -> L54
    L49:
        r6.put("enter_from_merge", r17);     // Catch: Exception -> L54
        if (r0 == null) goto L52;
        r2 = r0.getEnterMethod();     // Catch: Exception -> L54
    L52:
        r6.put("enter_method", r2);     // Catch: Exception -> L54
    L56:
        r5.onClickPromotion("live_ad", r9, "live", r6);
        return;
    L48:
        r17 = null;
        goto L49
    L44:
        r16 = null;
        goto L45
    L34:
        r14 = null;
        goto L35
    L18:
        r7 = null;
    L54:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L56
    L62:
        return;
    L10:
        r4 = null;
        goto L11
    L7:
        r3 = null;
        goto L8
    L59:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void a(Map<String, String> r9, com.bytedance.android.ec.common.api.jump.model.g r10, String r11) {
        if (r9 == null) goto L14;
        ql.a r1 = null;
        if ((!r9.isEmpty()) == false) goto L6;
        Map<String, String> r4 = r9;
    L7:
        if (r4 == null) goto L15;
        if (r10 == null) goto L10;
        r1 = r10.a;
    L10:
        if (r1 == null) goto L13;
        oh.a.c("livesdk_show_product_info", new h((ECUIPromotion) r1, r4, this, r10, r11));
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    L15:
        return;
    L6:
        r4 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void f(Map<String, String> r8, com.bytedance.android.ec.common.api.jump.model.g r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "promotionParams");
        oh.a.c("livesdk_show_store_entrance", new i(this, r9, r9.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class)), r8, r10));
    }

    public final void h(com.bytedance.android.ec.common.api.jump.model.g r9, boolean r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "promotionParams");
        if (r10 == false) goto L5;
        oh.a.c("ECAddShopCartEvent", new a(this, r9, r10, r11, r12));
        oh.a.c("doClickAddCartForDouPlus", new b(this, r9));
        return;
    L5:
        oh.a.c("ECAddShopCartEvent", new c(this, r9, r10, r11, r12));
    }

    public final void i(boolean r8, com.bytedance.android.ec.common.api.jump.model.g r9, boolean r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "promotionParams");
        if (r8 == false) goto L5;
        String r12 = "livesdk_close_product_long_press_guide";
    L6:
        oh.a.c(r12, new f(this, r9, r12, r10, r11));
        return;
    L5:
        r12 = "livesdk_show_product_long_press_guide";
        goto L6
    }

    public static final void g(PromotionListEventActionImpl r6, com.bytedance.android.ec.common.api.jump.model.g r7, boolean r8, String r9, String r10) {
        r6.getClass();
        ECUIPromotion r1 = r7.a;
        if (r1 == null) goto L51;
        ECUIPromotion r2 = r1;
        if (r2.canShowAddCart() == false) goto L55;
        int r3 = 0;
        int r4 = 1;
        if (r2.shouldShowStepper() == false) goto L15;
        com.bytedance.android.ec.model.response.v r5 = r2.stepperInfo;
        if (r5 != null) goto L12;
    L20:
        r4 = 0;
    L21:
        com.bytedance.android.ec.common.api.jump.model.f r11 = r7.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r8 == false) goto L24;
        String r12 = "livesdk_click_add_to_cart";
    L25:
        sg2.v r13 = new sg2.v(r12, r7);
        r13.c("click_area", "live_list_card");
        if (r2.shouldShowStepper() == false) goto L28;
        String r14 = "edit";
    L29:
        r13.c("display_type", r14);
        com.bytedance.android.ec.model.response.v r15 = r2.stepperInfo;
        if (r15 == null) goto L32;
        r3 = r15.b();
    L32:
        r13.a("cart_num", r3);
        r13.a("add_display_status", r4);
        r13.c("cart_track", new JSONObject(r2.getTrackExtra()).optString("cart_track"));     // Catch: Exception -> L35
    L37:
        r13.c("ecom_pitaya_json_str", com.bytedance.android.livesdk.livecommerce.event.r.a(r2));
        r13.c("btm_id", r10);
        if (r11 == null) goto L48;
        String r16 = r11.b;
        if (r16 == null) goto L48;
        Map r17 = EcomBcmTracker.f(PageFinder.via(r16), r13.g());
        if (r17 == null) goto L48;
        LinkedHashMap r18 = new LinkedHashMap(MapsKt.mapCapacity(r17.size()));
        Iterator r19 = r17.entrySet().iterator();
    L45:
        if (r19.hasNext() == false) goto L47;
        Map.Entry r110 = (Map.Entry) r19.next();
        r18.put(r110.getKey(), String.valueOf(r110.getValue()));
        goto L45
    L47:
        r13.d(r18);
    L48:
        PromotionListEventActionImplKt.a(r13, r6.a, r9);
        return;
    L35:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L37
    L28:
        r14 = "normal";
        goto L29
    L24:
        r12 = "livesdk_show_add_to_cart";
        goto L25
    L12:
        if (r5.c() != true) goto L20;
    L15:
        if (r2.getCanAddShopCart() == false) goto L21;
        if (r2.isOnSale() == false) goto L21;
        if (r2.isFlash() == true) goto L21;
    L55:
        return;
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotion");
    }
}
