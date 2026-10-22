package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy;

import android.content.Context;
import android.os.Handler;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.ability.g;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import si2.e0;
import si2.f0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class QueryWithMsgCacheCardShowStrategy implements com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a {
    public static final String p = null;
    public volatile boolean b;
    public long c;
    public g d;
    public final Lazy e;
    public b f;
    public long g;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b h;
    public com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a i;
    public Runnable j;
    public final Context k;
    public final com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a l;
    public final i m;
    public final tk2.b n;
    public final boolean o;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ QueryWithMsgCacheCardShowStrategy a;
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b b;
        public final /* synthetic */ boolean c;

        public b(QueryWithMsgCacheCardShowStrategy r1, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a() {
            dm.a.b r0 = dm.a.a;
            dm.a.a(QueryWithMsgCacheCardShowStrategy.p).a("real exec cancel msg, promotionId=" + this.b.c);
            this.a.l.p(this.b, this.c);
            this.a.f("FromMsg");
            fk2.a r1 = this.a.m.g();
            if (r1 == null) goto L6;
            r1.a(this.b, false);
            return;
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

    public static final class c implements com.bytedance.android.shopping.ligo.strategy.decision.scheduler.b {
        public final /* synthetic */ QueryWithMsgCacheCardShowStrategy a;
        public final /* synthetic */ ECUIPromotion b;

        public final void b() {
        }

        public final void a() {
            this.a.i().post(new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.c(this));
        }

        public c(QueryWithMsgCacheCardShowStrategy r1, ECUIPromotion r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ com.bytedance.android.livesdk.livecommerce.ability.f a;
        public final /* synthetic */ com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a b;
        public final /* synthetic */ QueryWithMsgCacheCardShowStrategy c;
        public final /* synthetic */ ECUIPromotion d;

        public d(com.bytedance.android.livesdk.livecommerce.ability.f r1, com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r2, QueryWithMsgCacheCardShowStrategy r3, ECUIPromotion r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void a() {
            dm.a.b r0 = dm.a.a;
            dm.a.a(QueryWithMsgCacheCardShowStrategy.p).a(">>> start show card runnable, promotionId=" + this.d.getPromotionId());
            Lazy r1 = LiveDynamicContext.c;
            LiveDynamicContext.a.a().a().a(this.c.k, this.a, this.b);
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

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void g(String r1, ECHotAtmosphere r2) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void h() {
    }

    public final Handler i() {
        return (Handler) this.e.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void j(ECUIPromotion r1) {
    }

    static {
        p = QueryWithMsgCacheCardShowStrategy.class.getSimpleName();
    }

    public final void c() {
        dm.a.b r0 = dm.a.a;
        dm.a.a(p).a("clearDelayedTask");
        b r1 = this.f;
        if (r1 == null) goto L5;
        i().removeCallbacks(r1);
    L5:
        this.f = null;
        this.g = 0;
        this.h = null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void o() {
        f("LiveEnd");
        i().removeCallbacksAndMessages(null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void a(boolean r2) {
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a.b.a(r2);
        this.l.a(r2);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void d(ECUIPromotion r4) {
        Intrinsics.checkNotNullParameter(r4, "uiPromotion");
        if (this.b == true) goto L5;
        return;
    L5:
        this.l.d(r4);
        dm.a.b r0 = dm.a.a;
        dm.a.a(p).a("START scheduler, enter room, promotionId=" + r4.getPromotionId());
        f("EnterRoom");
        q(r4);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void e(boolean r2) {
        this.l.e(r2);
    }

    public final void f(String r4) {
        dm.a.b r0 = dm.a.a;
        String r1 = p;
        dm.a.a(r1).a("startClearAllTasks, reason=".concat(r4));
        c();
        dm.a.a(r1).a("cancelDelayStart");
        Runnable r5 = this.j;
        if (r5 == null) goto L5;
        i().removeCallbacks(r5);
    L5:
        Runnable r6 = this.j;
        if (r6 == null) goto L8;
        i().removeCallbacks(r6);
    L8:
        this.j = null;
        dm.a.a(r1).a("cancelScheduler");
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r2 = this.i;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r3 = this.i;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        this.i = null;
        dm.a.a(r1).a("endClearAllTasks");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void k(boolean r2) {
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a.b.b(r2);
        this.l.k(r2);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void m(ECLiveCardPanelType r2) {
        Intrinsics.checkNotNullParameter(r2, "panelType");
        Intrinsics.checkNotNullParameter(r2, "panelType");
    }

    public final void q(ECUIPromotion r15) {
        if (r15 != null) goto L4;
        return;
    L4:
        g r0 = this.d;
        if (r0 != null) goto L7;
        return;
    L7:
        boolean r1 = r15.isAuction();
        String r2 = p;
        if (r1 == false) goto L11;
        dm.a.a(r2).a("auction card cannot auto schedule, skipped.");
        f("AuctionCard");
        return;
    L11:
        c93.b r3 = r0.c();
        int r4 = 0;
        if (r3 == null) goto L14;
        int r5 = r3.c();
    L16:
        if (r5 != 0) goto L18;
        boolean r9 = true;
    L19:
        Intrinsics.checkNotNullParameter(r0, "$this$convert2Standard");
        String r6 = r0.d();
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.c r7 = null;
        if (r6 == null) goto L24;
        String r8 = r0.a();
        if (r8 == null) goto L24;
        com.bytedance.android.livesdk.livecommerce.ability.f r10 = new com.bytedance.android.livesdk.livecommerce.ability.f(r6, r8, com.bytedance.android.livesdk.livecommerce.eventcenter.b.a(r8, r0.b()));
    L26:
        if (r10 == null) goto L56;
        dm.a.a(r2).a(">>> [" + (System.currentTimeMillis() / 1000) + "] start scheduler, promotionId=" + r15.getPromotionId() + ", title=" + r15.title + ", skip_first=" + r9);
        int r11 = RoomContextController.h;
        ECContext r12 = RoomContextController.a.a().r();
        if (r12 == null) goto L32;
        n<ECUIPromotion> r13 = r12.getExplainPromotion();
        if (r13 == null) goto L32;
        r13.setValue(r15);
    L32:
        int r14 = com.bytedance.android.shopping.ligo.strategy.decision.scheduler.e.a;
        c93.b r16 = r0.c();
        c r17 = new c(this, r15);
        if (r16 != null) goto L35;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.c r18 = new com.bytedance.android.shopping.ligo.strategy.decision.scheduler.c(r17);
    L45:
        dm.a.b r19 = dm.a.a(r2);
        StringBuilder r20 = new StringBuilder("new scheduler [");
        if (r18 == null) goto L48;
        r4 = r18.hashCode();
    L48:
        r20.append(r4);
        r20.append(']');
        r19.a(r20.toString());
        d r21 = new d(r10, r18, this, r15);
        Runnable r110 = this.j;
        if (r110 == null) goto L51;
        i().removeCallbacks(r110);
    L51:
        this.j = r21;
        i().post(r21);
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r111 = this.i;
        if (r111 == null) goto L54;
        r111.cancel();
    L54:
        this.i = r18;
        return;
    L35:
        int r22 = r16.getType();
        if (r22 == 0) goto L43;
        if (r22 != 1) goto L39;
        r7 = new com.bytedance.android.shopping.ligo.strategy.decision.scheduler.d(r16.c(), r17);
    L44:
        r18 = r7;
        goto L45
    L39:
        if (r22 == 2) goto L41;
        int r23 = ye3.a.a;
        String r24 = "create scheduler fail, pls check type or params: " + r16;
        Intrinsics.checkNotNullParameter("strategy", "module");
        Intrinsics.checkNotNullParameter(r24, "message");
        dm.a.a("LIGO").w("[strategy] " + r24, null);
        goto L44
    L41:
        r7 = new com.bytedance.android.shopping.ligo.strategy.decision.scheduler.f(r16.c(), r16.a(), r16.b(), r9, r17);
        goto L44
    L43:
        r7 = new com.bytedance.android.shopping.ligo.strategy.decision.scheduler.c(r17);
        goto L44
    L56:
        return;
    L24:
        r10 = null;
        goto L26
    L18:
        r9 = false;
        goto L19
    L14:
        r5 = 0;
        goto L16
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void p(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "message");
        if (this.b == true) goto L8;
        this.l.p(r6, r7);
        fk2.a r8 = this.m.g();
        if (r8 == null) goto L32;
        r8.a(r6, false);
        return;
    L32:
        return;
    L8:
        dm.a.b r0 = dm.a.a;
        dm.a.a(p).a("recv cancel msg, promotionId=" + r6.c + ", bubbleType=" + r6.b);
        boolean r2 = true;
        if (r6.b != 0) goto L12;
        if (r7 == true) goto L12;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L28;
        ExplainCardViewModel r3 = this.m.j();
        if (r3 == null) goto L23;
        QLiveData<ECUIPromotion> r4 = r3.getPromotionState();
        if (r4 == null) goto L23;
        ECUIPromotion r5 = (ECUIPromotion) r4.a();
        if (r5 == null) goto L23;
        if (r5.isAuction() != true) goto L23;
    L24:
        if (r2 == true) goto L28;
        if (this.o == true) goto L28;
        c();
        b r9 = new b(this, r6, r7);
        this.f = r9;
        this.g = r6.c;
        this.h = r6;
        i().postDelayed(r9, this.c);
        return;
    L23:
        r2 = false;
    L28:
        f("FromMsg");
        this.l.p(r6, r7);
        fk2.a r10 = this.m.g();
        if (r10 == null) goto L34;
        r10.a(r6, false);
        return;
    L34:
        return;
    L12:
        r1 = false;
        goto L13
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void b(com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r10, boolean r11, final Function1<? super ECUIPromotion, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "msg");
        boolean r1 = false;
        if (this.b == true) goto L8;
        this.l.b(r10, r11, r12);
        fk2.a r13 = this.m.g();
        if (r13 == null) goto L39;
        r13.a(r10, false);
        return;
    L39:
        return;
    L8:
        dm.a.b r0 = dm.a.a;
        String r2 = p;
        dm.a.a(r2).a("recv show msg, promotionId=" + r10.c);
        if (r10.b != 0) goto L12;
        if (r11 == true) goto L12;
        boolean r3 = true;
    L14:
        if (r3 == true) goto L16;
        dm.a.a(r2).a("NOT hit popcard cache, show new promotion, promotionId=" + r10.c);
        f("FromMsg");
        this.l.b(r10, r11, r12);
    L35:
        fk2.a r14 = this.m.g();
        if (r14 == null) goto L40;
        r14.a(r10, r1);
        return;
    L40:
        return;
    L16:
        if (r10.c != this.g) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L33;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r5 = this.i;
        if (r5 != null) goto L23;
    L25:
        boolean r6 = false;
    L26:
        if (r6 == false) goto L33;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.b r15 = this.h;
        if (r15 == null) goto L32;
        fk2.a r16 = this.m.g();
        if (r16 == null) goto L32;
        r16.a(r15, true);
    L32:
        c();
        dm.a.a(r2).a("HIT popcard cache, scheduler started, discard this msg, promotionId=" + r10.c);
        r1 = true;
        goto L35
    L23:
        if (r5.isCompleted() == true) goto L25;
        r6 = true;
    L33:
        dm.a.a(r2).a("NOT hit popcard cache or schedulerNOTstarted, start scheduler, promotionId=" + r10.c);
        f("FromMsg");
        this.l.b(r10, r11, new QueryWithMsgCacheCardShowStrategy$onReceiveCardAppearMsg$2(this, r12));
        goto L35
    L18:
        r4 = false;
    L12:
        r3 = false;
        goto L14
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void l(f0 r2, boolean r3, boolean r4, Function1<? super ECUIPromotion, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r6 = this.l;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r6.l(r2, r3, r1, r5);
        return;
    L5:
        if (r0.isCompleted() == true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a
    public final void n(e0 r2, boolean r3, boolean r4, Function2<? super ECUIPromotion, ? super Integer, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r5, "callback");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r6 = this.l;
        com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        r6.n(r2, r3, r1, r5);
        return;
    L5:
        if (r0.isCompleted() == true) goto L7;
        r1 = true;
        goto L8
    }

    public QueryWithMsgCacheCardShowStrategy(Context r2, DefaultCardShowStrategy r3, i r4, ok2.a r5, tk2.a r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "defaultStrategy");
        Intrinsics.checkNotNullParameter(r4, "bottomRightCardLiveManager");
        Intrinsics.checkNotNullParameter(r5, "autoPopConfig");
        Intrinsics.checkNotNullParameter(r6, "cardFreqManager");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        this.n = r6;
        this.o = r7;
        this.e = LazyKt.lazy(QueryWithMsgCacheCardShowStrategy$mainHandler$2.INSTANCE);
        if (r5.a() == null) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L9;
        r5 = null;
    L9:
        if (r5 == null) goto L11;
        this.c = r5.b();
        this.d = r5.a();
        this.b = true;
    L11:
        dm.a.b r9 = dm.a.a;
        dm.a.a(p).a("config initialized=" + this.b + ", cacheWaitTime=" + this.c);
        return;
    L5:
        r8 = false;
        goto L6
    }
}
