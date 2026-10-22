package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.card.vm.IntroCardViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.manager.IntroCardAnimController;
import com.bytedance.android.livesdk.livecommerce.intro.manager.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroPromotionVO;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.n;
import com.bytedance.android.livesdk.livecommerce.utils.t0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.v;
import sg2.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroCardWidgetController implements com.bytedance.android.livesdk.livecommerce.intro.controller.b {
    public static final Lazy y = null;
    public final int a;
    public final QUIManager b;
    public final ph2.g c;
    public final IntroCardViewModel d;
    public Disposable e;
    public final Lazy f;
    public boolean g;
    public boolean h;
    public boolean i;
    public c j;
    public final boolean k;
    public int l;
    public boolean m;
    public final Lazy n;
    public final Lazy o;
    public final RoomContextController p;
    public final com.bytedance.android.livesdk.livecommerce.room.model.e q;
    public final ViewGroup r;
    public final com.bytedance.android.livesdk.livecommerce.intro.manager.d s;
    public final IntroCardAnimController t;
    public final u u;
    public final com.bytedance.android.livesdk.livecommerce.intro.event.j v;
    public final qh2.b w;
    public final com.bytedance.android.livesdk.livecommerce.intro.controller.a x;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ IntroCardWidgetController a;
        public final /* synthetic */ IntroPromotionVO b;
        public final /* synthetic */ boolean c;

        public b(IntroCardWidgetController r1, IntroPromotionVO r2, String r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroCardWidgetController r0 = this.a;     // Catch: Throwable -> L7
            IntroPromotionVO r1 = this.b;     // Catch: Throwable -> L7
            if (r1 == null) goto L5;
            r1.getPromotionId();     // Catch: Throwable -> L7
        L5:
            r0.d(IntroCardWidgetController$cancelIntroCard$1$1.INSTANCE, IntroCardWidgetController$cancelIntroCard$1$2.INSTANCE, this.c);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ IntroCardWidgetController a;

        public c(IntroCardWidgetController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroCardWidgetController r0 = this.a;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            int r1 = g.a;     // Catch: Throwable -> L4
            g.c(false, new IntroCardWidgetController$onCardVisible$1(r0), r0.p);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Action {
        public final /* synthetic */ IntroCardWidgetController a;
        public final /* synthetic */ IntroPromotionVO b;

        public static final class a implements Runnable {
            public final /* synthetic */ r0 a;
            public final /* synthetic */ d b;

            public a(r0 r1, d r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.livesdk.livecommerce.intro.controller.a r0 = this.b.a.x;     // Catch: Throwable -> L6
                if (r0 == null) goto L9;
                r0.d(this.a);     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        public d(IntroCardWidgetController r1, IntroPromotionVO r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this.a, null, this.b.getPromotionId(), false, false, 13);
            s0 r0 = this.b.getControl();
            if (r0 == null) goto L8;
            r0 r1 = r0.a();
            if (r1 == null) goto L9;
            UtilityKotlinExtentionsKt.b.post(new a(r1, this));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ IntroPromotionVO a;

        public e(IntroPromotionVO r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.setExposureTime(((Long) r4).longValue());
        }
    }

    static {
        y = LazyKt.lazy(IntroCardWidgetController$Companion$disableCardLinkedAnimOnEnter$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final boolean i() {
        if (this.d.getCardState().a() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final String j() {
        IntroPromotionVO r0 = this.d.getCardState().a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPromotionId();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final boolean n() {
        IntroPromotionVO r0 = this.d.getCardState().a();
        if (r0 == null) goto L9;
        IntroProduct r1 = r0.getProduct();
        if (r1 == null) goto L9;
        if (r1.h() != 2) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void o() {
        if (this.h == false) goto L10;
        this.h = false;
        int r0 = g.a;
        ECLivePerformanceMonitor r1 = g.a(this.p);
        if (r1 == null) goto L10;
        r1.u("ec_perf_duration_intro_card", "card_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r2 = r1.p;
        if (r2 == null) goto L10;
        Map r3 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r2, MetricNames.POP_CARD_VISIBLE_DURATION);
    L10:
        if (this.i == false) goto L18;
        this.i = false;
        int r4 = g.a;
        ECLivePerformanceMonitor r5 = g.a(this.p);
        if (r5 == null) goto L16;
        r5.u("ec_perf_duration_intro_card", "main_image_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r6 = r5.p;
        if (r6 == null) goto L16;
        Map r7 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r6, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION);
    L16:
        this.j = new c(this);
    L18:
        if (this.g == false) goto L26;
        c r8 = this.j;
        if (r8 == null) goto L26;
        this.g = false;
        r8.run();
        this.j = null;
        if (this.k == false) goto L26;
        int r9 = g.a;
        ECLivePerformanceMonitor r10 = g.a(this.p);
        if (r10 == null) goto L26;
        r10.z(this.l);
    L26:
        OptCardUtil.b(null, "call dispatchDraw of card");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void onDestroy() {
        ((bk2.d) this.f.getValue()).clearDisposable();
        Disposable r0 = this.e;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.e = null;
        ph2.g r1 = this.c;
        if ((r1 instanceof ph2.h) == true) goto L8;
        Object r2 = null;
    L9:
        ph2.h r3 = (ph2.h) r2;
        if (r3 == null) goto L26;
        View r4 = r3.n;
        if (r4 == null) goto L26;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L16
        int r6 = nh2.a.a;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r4, "view");     // Catch: Throwable -> L16
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        ViewParent r7 = r4.getParent();
        if ((r7 instanceof ViewGroup) == true) goto L21;
        r7 = null;
    L21:
        ViewGroup r8 = (ViewGroup) r7;
        if (r8 == null) goto L24;
        r8.removeView(r4);
    L24:
        r3.n = null;
        throw null;
    L16:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L26:
        this.b.r(r1.getClass());
        this.d.onDestroy();
        return;
    L8:
        r2 = r1;
        goto L9
    }

    public static final boolean b(IntroCardWidgetController r0) {
        return ((Boolean) r0.o.getValue()).booleanValue();
    }

    public static final boolean c(IntroCardWidgetController r1) {
        r1.getClass();
        if (n.c() == true) goto L5;
    L6:
        ECLiveDegradeHelper.c.getClass();
        if (ECLiveDegradeHelper.c() == 1) goto L12;
        return false;
    L12:
        return true;
    L5:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.e(com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e) == true) goto L6;
        return true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void a(JSONObject r7) {
        Intrinsics.checkNotNullParameter("closeExplainCard", "event");
        Intrinsics.checkNotNullParameter(r7, "params");
        IntroPromotionVO r8 = this.d.getCardState().a();
        if (r8 == null) goto L8;
        String r1 = r8.getProductId();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this, r1, null, false, false, 14);
        return;
    L9:
        return;
    }

    public final void e(IntroPromotionVO r12) {
        s0 r0 = r12.getControl();
        if (r0 == null) goto L5;
        long r3 = r0.c();
    L6:
        long r4 = r3 / 1000;
        if (r4 > 0) goto L9;
        return;
    L9:
        Disposable r1 = this.e;
        if (r1 == null) goto L12;
        r1.dispose();
    L12:
        int r2 = t0.a;
        this.e = bk2.c.a(t0.b(0, 1, TimeUnit.SECONDS, Schedulers.io()).take(r4 + 1).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new d(this, r12)).subscribe(new e(r12)), (bk2.d) this.f.getValue());
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void k(boolean r2) {
        IntroPromotionVO r0 = this.d.getCardState().a();
        if (r0 == null) goto L6;
        r0.getPromotionId();
        d(null, null, r2);
        return;
    }

    public final void d(Function0 r10, Function0 r11, boolean r12) {
        fk2.b r0 = (fk2.b) this.n.getValue();
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = null;
        IntroCardAnimController r1 = this.t;
        IntroPromotionVO r2 = this.d.getCardState().a();
        if (r2 == null) goto L9;
        String r3 = r2.getPromotionId();
        if (r3 == null) goto L9;
    L10:
        r1.f(new j(this, r10, r11, r3, this.b.p(), new IntroCardWidgetController$hideIntroCard$2(this, r12)));
        return;
    L9:
        r3 = "";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void m(uh2.a r13, final boolean r14, final boolean r15) {
        if ((r13 instanceof IntroPromotionVO) == true) goto L5;
        r13 = null;
    L5:
        final IntroPromotionVO r16 = (IntroPromotionVO) r13;
        if (r16 == null) goto L84;
        if (r14 == false) goto L9;
        this.d.getCardState().g(r16);
    L85:
        IntroCardLoadOpt.n = false;
        if (this.m == false) goto L89;
        this.m = false;
        this.d.setEnterRoom(false);
        return;
    L89:
        return;
    L9:
        IntroProduct r2 = r16.getProduct();
        if (r2 == null) goto L12;
        int r3 = r2.h();
    L13:
        this.l = r3;
        IntroCardScene r4 = r16.getCardReqScene();
        if (r4 == null) goto L16;
        boolean r5 = sh2.f.b(r4);
    L17:
        if (r5 == true) goto L24;
        int r6 = g.a;
        ECLivePerformanceMonitor r7 = g.a(this.p);
        if (r7 == null) goto L21;
        ECLivePerformanceMonitor.y(r7, Boolean.FALSE, new gf.a(0));
    L21:
        y r8 = this.p.c;
        if (r8 == null) goto L24;
        r8.f(r16.getPromotionId());
    L24:
        com.bytedance.android.livesdk.livecommerce.room.utils.d r9 = this.p.d;
        String r10 = r16.getPromotionId();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.d = r10;
        IntroPromotionVO r11 = this.d.getCardState().a();
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r12 = this.t.a;
        if (r11 == null) goto L27;
        String r17 = r11.getPromotionId();
    L29:
        if (Intrinsics.areEqual(r17, r16.getPromotionId()) == false) goto L40;
        if (r12 != null) goto L32;
    L35:
        e(r16);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_POP_SAME_CARD_EXTEND() == false) goto L38;
    L39:
        this.d.getCardState().g(r16);
        goto L85
    L38:
        if (r16.getShouldExtendSameCardDuration() == false) goto L85;
    L32:
        if (r12.d != 1) goto L35;
        if (r12.d() == false) goto L35;
    L40:
        com.bytedance.android.livesdk.livecommerce.intro.controller.a r18 = this.x;
        if (r18 == null) goto L43;
        r18.a(r15);
    L43:
        Function0<Unit> r19 = new IntroCardWidgetController$handleIntroVO$$inlined$also$lambda$1(r16, this, r14, r15);
        OptCardUtil.b(null, "call showExplainCard");
        fk2.b r110 = (fk2.b) this.n.getValue();
        if (r110 == null) goto L51;
        long r20 = SystemClock.elapsedRealtime();
        r110.f = r20;
        if (r110.e <= 0) goto L48;
        boolean r21 = true;
    L49:
        if (r21 == true) goto L51;
        r110.g = r20;
        goto L51
    L48:
        r21 = false;
    L51:
        r16.setShowTimestamp(System.currentTimeMillis());
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = null;
        IntroCardScene r111 = r16.getCardReqScene();
        if (r111 != null) goto L54;
    L56:
        boolean r22 = false;
    L57:
        this.t.f(new k(this, r22, r19, r16, r16.getPromotionId(), this.b.p(), new IntroCardWidgetController$showIntroCard$2(this, r22, r15)));
        if (this.m == false) goto L60;
        IntroCardEventCenter r112 = this.d.getCardArgument().a;
        r112.getClass();
        IntroCardEventCenter.b(new com.bytedance.android.livesdk.livecommerce.intro.event.g(r112));
    L60:
        com.bytedance.android.livesdk.livecommerce.intro.event.j r113 = this.v;
        if (r113 == null) goto L85;
        Intrinsics.checkNotNullParameter(r16, "introPromotionVO");
        IntroProduct r114 = r16.getProduct();
        if (r114 != null) goto L65;
    L67:
        IntroCardScene r115 = r16.getCardReqScene();
        if (r115 != null) goto L70;
    L72:
        String r116 = "message";
    L73:
        v r23 = new v("livesdk_popup_card_show", r113.d);
        IntroProduct r24 = r16.getProduct();
        if (r24 == null) goto L76;
        String r25 = String.valueOf(r24.h());
    L77:
        r23.c("product_type", r25);
        r23.c("from_scene", r116);
        IntroProduct r117 = r16.getProduct();
        if (r117 == null) goto L80;
        String r118 = r117.i();
    L81:
        r23.c("promotion_id", r118);
        if (r113.c == false) goto L85;
        r23.i(null);
        goto L85
    L80:
        r118 = null;
        goto L81
    L76:
        r25 = null;
        goto L77
    L70:
        if (sh2.f.a(r115) != true) goto L72;
        r116 = "enter_room";
        goto L73
    L65:
        if (r114.h() != 2) goto L67;
        r116 = "related_card";
        goto L73
    L54:
        if (sh2.f.a(r111) != true) goto L56;
        r22 = true;
        goto L57
    L27:
        r17 = null;
        goto L29
    L16:
        r5 = false;
        goto L17
    L12:
        r3 = 1;
        goto L13
    L84:
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this, null, null, false, false, 15);
        Unit r119 = Unit.INSTANCE;
        goto L85
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void l(String r4, String r5, boolean r6, boolean r7) {
        IntroPromotionVO r0 = this.d.getCardState().a();
        if (r6 == true) goto L18;
        String r8 = null;
        if (r4 == null) goto L12;
        if (r0 == null) goto L8;
        String r2 = r0.getProductId();
    L10:
        if ((!Intrinsics.areEqual(r4, r2)) == false) goto L12;
        return;
    L8:
        r2 = null;
    L12:
        if (r5 == null) goto L18;
        if (r0 == null) goto L16;
        r8 = r0.getPromotionId();
    L16:
        if ((!Intrinsics.areEqual(r5, r8)) == false) goto L18;
        return;
    L18:
        this.s.i(1, new b(this, r0, r5, r7));
    }

    public IntroCardWidgetController(Context r10, RoomContextController r11, com.bytedance.android.livesdk.livecommerce.room.model.g r12, LiveRoomParams r13, com.bytedance.android.livesdk.livecommerce.intro.manager.h r14, qh2.d.b r15, com.bytedance.android.livesdk.livecommerce.intro.manager.d r16, IntroCardAnimController r17, u r18, com.bytedance.android.livesdk.livecommerce.intro.event.j r19, qh2.b r20, com.bytedance.android.livesdk.livecommerce.intro.manager.k r21) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "roomContextController");
        Intrinsics.checkNotNullParameter(r12, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r14, "rootView");
        Intrinsics.checkNotNullParameter(r15, "btmInfo");
        Intrinsics.checkNotNullParameter(r16, "cardQueue");
        Intrinsics.checkNotNullParameter(r17, "animController");
        Intrinsics.checkNotNullParameter(r18, "animDelegate");
        this.p = r11;
        this.q = r12;
        this.r = r14;
        this.s = r16;
        this.t = r17;
        this.u = r18;
        this.v = r19;
        this.w = r20;
        this.x = r21;
        this.a = 1;
        QUIManager r5 = new QUIManager();
        this.b = r5;
        this.f = LazyKt.lazy(IntroCardWidgetController$disposableContext$2.INSTANCE);
        this.k = true;
        this.l = 1;
        this.m = true;
        this.n = LazyKt.lazy(new IntroCardWidgetController$durationMonitor$2(this));
        this.o = LazyKt.lazy(IntroCardWidgetController$enableEnterRoomAnim$2.INSTANCE);
        IntroCardViewModel r6 = new IntroCardViewModel(r12, r13, r15, jf.b.g.b, r11);
        r6.setCardCallback(new h(this));
        r6.setEnterRoom(this.m);
        Unit r2 = Unit.INSTANCE;
        this.d = r6;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_KMP_UI() == false) goto L5;
        int r3 = ph2.h.o;
        int r4 = nh2.a.a;
    L5:
        ph2.g r7 = new ph2.g(r6, r6.getCardArgument(), r6.getContainerAbility());
        this.c = r7;
        r5.l(r7, r14.getContext(), true);
        r5.c(ph2.g.class, new i(this));
        r6.getClickCloseAction().b(g.b(r11), new ActionObserver(new IntroCardWidgetController$observeData$1(this)));
        r6.getOpenPriceAnimationFinishedAction$livecommerce_saasRelease().b(g.b(r11), new ActionObserver(new IntroCardWidgetController$observeData$2(this)));
        r6.getOpenPriceAnimationStateAction$livecommerce_saasRelease().b(g.b(r11), new ActionObserver(new IntroCardWidgetController$observeData$3(this)));
        View r1 = r5.p();
        FrameLayout.LayoutParams r8 = new FrameLayout.LayoutParams(r1.getLayoutParams());
        r8.gravity = 80;
        r1.setLayoutParams(r8);
        r14.addView(r1);
    }
}
