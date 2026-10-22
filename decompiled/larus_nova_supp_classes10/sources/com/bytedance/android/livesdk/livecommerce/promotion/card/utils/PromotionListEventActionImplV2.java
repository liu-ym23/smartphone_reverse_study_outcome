package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.promotion.ECUIAskExplainInfo;
import com.bytedance.android.ec.model.promotion.ECUIPromotionV2;
import com.bytedance.android.ec.model.response.a1;
import com.bytedance.android.ec.model.response.g1;
import com.bytedance.android.ec.model.response.k1;
import com.bytedance.android.ec.model.response.m1;
import com.bytedance.android.ec.model.response.s1;
import com.bytedance.android.ec.model.response.v0;
import com.bytedance.android.ec.model.response.y0;
import com.bytedance.android.ec.model.response.z0;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.android.livesdk.livecommerce.event.d2;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class PromotionListEventActionImplV2 implements com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f {
    public final com.bytedance.android.livesdk.livecommerce.promotion.card.e a;
    public final il.a b;

    public static final class a implements Runnable {
        public final /* synthetic */ PromotionListEventActionImplV2 a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public a(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, boolean r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PromotionListEventActionImplV2.g(this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
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
        public final /* synthetic */ PromotionListEventActionImplV2 a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;

        public b(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.o(this.b, "add_to_cart");     // Catch: Throwable -> L4
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
        public final /* synthetic */ PromotionListEventActionImplV2 a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public c(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, boolean r3, String r4, String r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PromotionListEventActionImplV2.g(this.a, this.b, this.c, this.d, this.e);     // Catch: Throwable -> L4
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
        public final /* synthetic */ PromotionListEventActionImplV2 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;
        public final /* synthetic */ ECUIPromotionV2 d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ String f;

        public d(PromotionListEventActionImplV2 r1, String r2, com.bytedance.android.ec.common.api.jump.model.g r3, ECUIPromotionV2 r4, Map r5, String r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        public final void a() {
            sg2.v r0 = new sg2.v("livesdk_" + this.b + "_click", this.c);
            r0.c("product_id", this.d.getProductId());
            r0.d(this.e);
            PromotionListEventActionImplKt.a(r0, this.a.a, this.f);
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
        public final /* synthetic */ PromotionListEventActionImplV2 a;
        public final /* synthetic */ ECUIPromotionV2 b;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g c;
        public final /* synthetic */ String d;

        public e(PromotionListEventActionImplV2 r1, ECUIPromotionV2 r2, com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            z0 r0 = this.b.getImage();
            Map r1 = null;
            if (r0 == null) goto L9;
            a1 r2 = r0.c();
            if (r2 == null) goto L9;
            s1 r3 = r2.g();
            if (r3 == null) goto L9;
            String r4 = r3.c();
        L10:
            if (r4 != null) goto L12;
            r4 = "";
        L12:
            z0 r5 = this.b.getImage();
            if (r5 == null) goto L19;
            a1 r6 = r5.c();
            if (r6 == null) goto L19;
            s1 r7 = r6.g();
            if (r7 == null) goto L19;
            r1 = r7.d();
        L19:
            sg2.v r8 = new sg2.v("livesdk_" + r4 + "_show", this.c);
            r8.c("product_id", this.b.getProductId());
            r8.d(r1);
            PromotionListEventActionImplKt.a(r8, this.a.a, this.d);
            return;
        L9:
            r4 = null;
            goto L10
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
        public final /* synthetic */ PromotionListEventActionImplV2 a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ String e;

        public f(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, String r3, boolean r4, String r5) {
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
        public final /* synthetic */ PromotionListEventActionImplV2 a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ ECUIPromotionV2 c;
        public final /* synthetic */ Ref.ObjectRef d;

        public g(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, ECUIPromotionV2 r3, Ref.ObjectRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            sg2.v r0 = new sg2.v("livesdk_show_have_seen_label", this.b);
            r0.c("product_id", this.c.getProductId());
            r0.c("tag_name", (String) this.d.element);
            PromotionListEventActionImplKt.a(r0, this.a.a, null);
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
        public final /* synthetic */ ql.a a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ PromotionListEventActionImplV2 c;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g d;
        public final /* synthetic */ String e;

        public h(ql.a r1, Map r2, PromotionListEventActionImplV2 r3, com.bytedance.android.ec.common.api.jump.model.g r4, String r5) {
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
            ql.a r2 = this.a;
            if (r2 == null) goto L8;
            String r3 = r2.getProductId();
        L9:
            r0.c("product_id", r3);
            ql.a r4 = this.a;
            if (r4 == null) goto L22;
            r0.d(r4.getEventParams());
            r0.c("product_id", r4.getProductId());
            if (r4.isOnExplaining() == false) goto L14;
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
        public final /* synthetic */ PromotionListEventActionImplV2 a;
        public final /* synthetic */ com.bytedance.android.ec.common.api.jump.model.g b;
        public final /* synthetic */ LiveRoomParams c;
        public final /* synthetic */ Map d;
        public final /* synthetic */ String e;

        public i(PromotionListEventActionImplV2 r1, com.bytedance.android.ec.common.api.jump.model.g r2, LiveRoomParams r3, Map r4, String r5) {
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

    public final void l(final com.bytedance.android.ec.common.api.jump.model.g r11) {
        Intrinsics.checkNotNullParameter(r11, "promotionParams");
        ECUIPromotionV2 r0 = r11.a;
        if (r0 == null) goto L19;
        final ECUIPromotionV2 r4 = r0;
        g1 r1 = r4.getPurchase();
        Map r2 = null;
        if (r1 == null) goto L9;
        m1 r3 = r1.b();
        if (r3 == null) goto L9;
        s1 r5 = r3.e();
    L10:
        if (r5 == null) goto L12;
        r2 = r5.d();
    L12:
        final Map r6 = r2;
        if (r5 == null) goto L20;
        final String r7 = r5.c();
        if (r7 == null) goto L21;
        this.b.c(r7, r4.getPromotionId(), new PromotionListEventActionImplV2$doShowFindSimilarEvent$$inlined$also$lambda$1(r7, this, r4, r11, r6));
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r5 = null;
        goto L10
    L19:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final void m(com.bytedance.android.ec.common.api.jump.model.g r5) {
        Intrinsics.checkNotNullParameter(r5, "promotionParams");
        ECUIPromotionV2 r0 = r5.a;
        if (r0 == null) goto L17;
        ECUIPromotionV2 r1 = r0;
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = null;
        z0 r3 = r1.getImage();
        if (r3 == null) goto L14;
        List r4 = r3.g();
        if (r4 == null) goto L14;
        Iterator r6 = r4.iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        String r7 = ((y0) r6.next()).d();
        if (r7 == null) goto L10;
        r2.element = r7;
    L14:
        oh.a.c("doShowHaveSeenLabelEvent", new g(this, r5, r1, r2));
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final void n(final com.bytedance.android.ec.common.api.jump.model.g r9) {
        Intrinsics.checkNotNullParameter(r9, "promotionParams");
        ql.a r0 = r9.a;
        String r2 = null;
        if ((r0 instanceof ECUIPromotionV2) == true) goto L5;
        r0 = null;
    L5:
        final ECUIPromotionV2 r1 = (ECUIPromotionV2) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        v0 r3 = r1.getExtend();
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.c() == null) goto L37;
        v0 r4 = r1.getExtend();
        if (r4 == null) goto L18;
        s1 r5 = r4.j();
        if (r5 == null) goto L18;
        r2 = r5.c();
    L18:
        boolean r6 = true;
        if (r2 != null) goto L21;
    L24:
        boolean r7 = true;
    L25:
        if (r7 == true) goto L27;
        final String r8 = "livesdk_show_" + r2;
    L28:
        final String r10 = "livesdk_show_list_product_bottom";
        this.b.c("livesdk_show_list_product_bottom", r1.getPromotionId(), new PromotionListEventActionImplV2$doShowListProductBottom$1(this, r10, r9, r1));
        if (r8.length() > 0) goto L32;
        r6 = false;
    L32:
        if (r6 == false) goto L36;
        this.b.c(r8, r1.getPromotionId(), new PromotionListEventActionImplV2$doShowListProductBottom$2(this, r8, r9, r1));
        return;
    L36:
        return;
    L27:
        r8 = "";
        goto L28
    L21:
        if (r2.length() == 0) goto L24;
        r7 = false;
        goto L25
    }

    public PromotionListEventActionImplV2(com.bytedance.android.livesdk.livecommerce.promotion.card.e r2, il.a r3) {
        Intrinsics.checkNotNullParameter(r3, "eventMap");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void b(com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        oh.a.c("ECExplainReplayEntranceEvent", new z(this, r3, "show", r4));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void c(com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        oh.a.c("ECExplainReplayEntranceEvent", new z(this, r3, "click", r4));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void d(com.bytedance.android.ec.common.api.jump.model.g r9, String r10) {
        Intrinsics.checkNotNullParameter(r9, "promotionParams");
        ECUIPromotionV2 r0 = r9.a;
        if (r0 == null) goto L25;
        ECUIPromotionV2 r5 = r0;
        z0 r1 = r5.getImage();
        if (r1 == null) goto L11;
        a1 r2 = r1.c();
        if (r2 == null) goto L11;
        s1 r3 = r2.g();
        if (r3 == null) goto L11;
        String r4 = r3.c();
    L12:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        String r6 = r4;
        z0 r7 = r5.getImage();
        if (r7 == null) goto L21;
        a1 r8 = r7.c();
        if (r8 == null) goto L21;
        s1 r11 = r8.g();
        if (r11 == null) goto L21;
        Map r12 = r11.d();
    L22:
        oh.a.c("ExplainStatusClickEvent", new d(this, r6, r9, r5, r12, r10));
        return;
    L21:
        r12 = null;
    L11:
        r4 = null;
        goto L12
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void e(com.bytedance.android.ec.common.api.jump.model.g r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionParams");
        ECUIPromotionV2 r0 = r3.a;
        if (r0 == null) goto L7;
        oh.a.c("ExplainStatusShowEvent", new e(this, r0, r3, r4));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final Map i(com.bytedance.android.ec.common.api.jump.model.g r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "promotionParams");
        ECUIPromotionV2 r9 = r7.a;
        if (r9 == null) goto L41;
        ECUIPromotionV2 r10 = r9;
        LiveRoomParams r0 = r7.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        com.bytedance.android.ec.common.api.jump.model.f r1 = r7.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        k1 r2 = r10.getTrack();
        String r3 = null;
        if (r2 == null) goto L9;
        s1 r4 = r2.c();
        if (r4 == null) goto L9;
        String r5 = r4.c();
    L10:
        if (r5 != null) goto L13;
        r5 = "";
    L13:
        if (Intrinsics.areEqual(r5, "livesdk_show_product") == false) goto L20;
        sg2.v r6 = new sg2.v(r5, r7);
        Pair r11 = d2.a(r10);
        List r12 = (List) r11.component1();
        List r13 = (List) r11.component2();
        if ((!r12.isEmpty()) == false) goto L18;
        r6.c("tag_code_list", r12.toString());
    L18:
        if ((!r13.isEmpty()) == false) goto L21;
        r6.c("live_tag_list", r13.toString());
    L21:
        r6.c("bst_tag", "bst_tag");
        int r14 = RoomContextController.h;
        if (r0 == null) goto L24;
        String r15 = r0.getRoomId();
    L25:
        if (r0 == null) goto L27;
        r3 = r0.getRoomUniqueKey();
    L27:
        r6.c("duration", RoomContextController.a.b(r15, r3).I());
        r6.c("bst_group_type", "live");
        r6.a("ecom_goods_status", r10.getStatus());
        if (r1 == null) goto L38;
        String r16 = r1.b;
        if (r16 == null) goto L38;
        Map r17 = EcomBcmTracker.f(PageFinder.via(r16), r6.g());
        if (r17 == null) goto L38;
        LinkedHashMap r18 = new LinkedHashMap(MapsKt.mapCapacity(r17.size()));
        Iterator r19 = r17.entrySet().iterator();
    L35:
        if (r19.hasNext() == false) goto L37;
        Map.Entry r20 = (Map.Entry) r19.next();
        r18.put(r20.getKey(), String.valueOf(r20.getValue()));
        goto L35
    L37:
        r6.d(r18);
    L38:
        LinkedHashMap r21 = new LinkedHashMap();
        r21.putAll(r6.g());
        return r21;
    L24:
        r15 = null;
        goto L25
    L20:
        r6 = new sg2.v(r5, r7);
    L9:
        r5 = null;
        goto L10
    L41:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.model.promotion.ECUIPromotionV2");
    }

    public final void o(com.bytedance.android.ec.common.api.jump.model.g r8, String r9) {
        LiveRoomParams r0 = r8.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        ql.a r10 = r8.a;
        boolean r1 = EntryController.M1;
        String r2 = null;
        if (r0 == null) goto L5;
        String r3 = r0.getRoomId();
    L6:
        if (r0 == null) goto L8;
        String r4 = r0.getRoomUniqueKey();
    L9:
        ak2.m r5 = EntryController.a.b(r3, r4).F;
        if (r5 == null) goto L58;
        JSONObject r6 = new JSONObject();
        r6.put("shop_id", r10.getShopId());     // Catch: Exception -> L52
        r6.put("product_id", r10.getProductId());     // Catch: Exception -> L52
        r6.put("promotion_id", r10.getPromotionId());     // Catch: Exception -> L52
        if (r0 == null) goto L16;
        String r7 = r0.getAuthorId();     // Catch: Exception -> L52
    L17:
        String r11 = "";
        if (r7 != null) goto L20;
        r7 = "";
    L20:
        r6.put("anchor_id", r7);     // Catch: Exception -> L52
        if (hh2.f.e() == false) goto L30;
        if (r0 == null) goto L25;
        String r12 = r0.getAuthorId();     // Catch: Exception -> L52
    L26:
        if (r12 != null) goto L28;
        r12 = "";
    L28:
        r6.put("anchor_open_id", r12);     // Catch: Exception -> L52
        goto L30
    L25:
        r12 = null;
    L30:
        if (r0 == null) goto L32;
        String r13 = r0.getRoomId();     // Catch: Exception -> L52
    L33:
        if (r13 == null) goto L36;
        r11 = r13;
    L36:
        r6.put("room_id", r11);     // Catch: Exception -> L52
        r6.put("commodity_id", r10.getPromotionId());     // Catch: Exception -> L52
        String r14 = r10.getEventItemType();     // Catch: Exception -> L52
        if (r14 != null) goto L39;
        r14 = "-1";
    L39:
        r6.put("commodity_type", r14);     // Catch: Exception -> L52
        r6.put("commodity_price", (int) (CastFloatProtector.parseFloat(r10.getPrice()) * 100));     // Catch: Exception -> L52
        if (r0 == null) goto L42;
        String r15 = r0.getActionType();     // Catch: Exception -> L52
    L43:
        r6.put("action_type", r15);     // Catch: Exception -> L52
        if (r0 == null) goto L46;
        String r16 = r0.getEnterFromMerge();     // Catch: Exception -> L52
    L47:
        r6.put("enter_from_merge", r16);     // Catch: Exception -> L52
        if (r0 == null) goto L50;
        r2 = r0.getEnterMethod();     // Catch: Exception -> L52
    L50:
        r6.put("enter_method", r2);     // Catch: Exception -> L52
    L54:
        r5.onClickPromotion("live_ad", r9, "live", r6);
        return;
    L46:
        r16 = null;
        goto L47
    L42:
        r15 = null;
        goto L43
    L32:
        r13 = null;
        goto L33
    L16:
        r7 = null;
    L52:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L54
    L58:
        return;
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotion.card.utils.f
    public final void a(Map<String, String> r9, com.bytedance.android.ec.common.api.jump.model.g r10, String r11) {
        if (r9 == null) goto L12;
        ql.a r1 = null;
        if ((!r9.isEmpty()) == false) goto L6;
        Map<String, String> r4 = r9;
    L7:
        if (r4 == null) goto L13;
        if (r10 == null) goto L10;
        r1 = r10.a;
    L10:
        oh.a.c("livesdk_show_product_info", new h(r1, r4, this, r10, r11));
        return;
    L13:
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

    public final void j(boolean r8, com.bytedance.android.ec.common.api.jump.model.g r9, boolean r10, String r11) {
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

    public final void k(final String r10, final Map<String, String> r11, final String r12, final com.bytedance.android.ec.common.api.jump.model.g r13) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        if (r13 == null) goto L9;
        ql.a r0 = r13.a;
        if (r0 == null) goto L10;
        this.b.c(r10, r0.getUniTag(), new PromotionListEventActionImplV2$doSalePointShowEvent$1(this, r10, r13, r11, r12));
        return;
    L10:
        return;
    }

    public static final void g(PromotionListEventActionImplV2 r8, com.bytedance.android.ec.common.api.jump.model.g r9, boolean r10, String r11, String r12) {
        r8.getClass();
        ql.a r1 = r9.a;
        if (r1.canShowAddCart() == false) goto L60;
        int r3 = 0;
        int r4 = 1;
        if (r1.shouldShowStepper() == false) goto L13;
        com.bytedance.android.ec.model.response.v r2 = r1.getStepperInfo();
        if (r2 != null) goto L10;
    L18:
        r4 = 0;
    L19:
        com.bytedance.android.ec.common.api.jump.model.f r5 = r9.getParamsModel(Reflection.getOrCreateKotlinClass(com.bytedance.android.ec.common.api.jump.model.f.class));
        if (r10 == false) goto L22;
        String r6 = "livesdk_click_add_to_cart";
    L23:
        sg2.v r7 = new sg2.v(r6, r9);
        r7.c("click_area", "live_list_card");
        if (r1.shouldShowStepper() == false) goto L26;
        String r13 = "edit";
    L27:
        r7.c("display_type", r13);
        com.bytedance.android.ec.model.response.v r14 = r1.getStepperInfo();
        if (r14 == null) goto L30;
        r3 = r14.b();
    L30:
        r7.a("cart_num", r3);
        r7.a("add_display_status", r4);
        r7.c("cart_track", new JSONObject(r1.getTrackExtra()).optString("cart_track"));     // Catch: Exception -> L33
    L35:
        r7.c("ecom_pitaya_json_str", com.bytedance.android.livesdk.livecommerce.event.r.a(r1));
        r7.c("btm_id", r12);
        if (r5 == null) goto L46;
        String r15 = r5.b;
        if (r15 == null) goto L46;
        Map r16 = EcomBcmTracker.f(PageFinder.via(r15), r7.g());
        if (r16 == null) goto L46;
        LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r16.size()));
        Iterator r17 = r16.entrySet().iterator();
    L43:
        if (r17.hasNext() == false) goto L45;
        Map.Entry r18 = (Map.Entry) r17.next();
        r0.put(r18.getKey(), String.valueOf(r18.getValue()));
        goto L43
    L45:
        r7.d(r0);
    L46:
        PromotionListEventActionImplKt.a(r7, r8.a, r11);
        LiveRoomParams r19 = r9.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r10 == false) goto L59;
        Lazy r20 = LiveEventCenter.b;
        com.bytedance.android.livesdk.livecommerce.eventcenter.d r21 = LiveEventCenter.a.a();
        String r110 = null;
        if (r19 == null) goto L51;
        String r111 = r19.getRoomId();
    L52:
        if (r19 == null) goto L54;
        r110 = r19.getRoomUniqueKey();
    L54:
        r21.sendEvent("product_add_cart", new lh2.a(r111, r110, r1));
        return;
    L51:
        r111 = null;
        goto L52
    L59:
        return;
    L33:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L35
    L26:
        r13 = "normal";
        goto L27
    L22:
        r6 = "livesdk_show_add_to_cart";
        goto L23
    L10:
        if (r2.c() != true) goto L18;
    L13:
        if (r1.getCanAddShopCart() == false) goto L19;
        if (r1.isOnSale() == false) goto L19;
        if (r1.isFlash() == true) goto L19;
    }
}
