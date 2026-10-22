package com.bytedance.android.livesdk.livecommerce.intro.controller;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.intro.auction.IntroAuctionViewModel;
import com.bytedance.android.livesdk.livecommerce.intro.event.IntroCardEventCenter;
import com.bytedance.android.livesdk.livecommerce.intro.manager.IntroCardAnimController;
import com.bytedance.android.livesdk.livecommerce.intro.manager.u;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.IntroProduct;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.r0;
import com.bytedance.android.livesdk.livecommerce.intro.model.resp.s0;
import com.bytedance.android.livesdk.livecommerce.intro.model.vo.IntroAuctionPromotionVO;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class IntroAuctionWidgetController implements com.bytedance.android.livesdk.livecommerce.intro.controller.b {
    public static final Lazy w = null;
    public final int a;
    public final QUIManager b;
    public final IntroAuctionViewModel c;
    public Disposable d;
    public final Lazy e;
    public boolean f;
    public boolean g;
    public boolean h;
    public c i;
    public final boolean j;
    public int k;
    public boolean l;
    public final Lazy m;
    public final Lazy n;
    public final RoomContextController o;
    public final com.bytedance.android.livesdk.livecommerce.room.model.e p;
    public final ViewGroup q;
    public final com.bytedance.android.livesdk.livecommerce.intro.manager.d r;
    public final IntroCardAnimController s;
    public final u t;
    public final qh2.b u;
    public final com.bytedance.android.livesdk.livecommerce.intro.controller.a v;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ IntroAuctionWidgetController a;
        public final /* synthetic */ IntroAuctionPromotionVO b;
        public final /* synthetic */ boolean c;

        public b(IntroAuctionWidgetController r1, IntroAuctionPromotionVO r2, String r3, boolean r4) {
            this.a = r1;
            this.b = r2;
            this.c = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroAuctionWidgetController r0 = this.a;     // Catch: Throwable -> L7
            IntroAuctionPromotionVO r1 = this.b;     // Catch: Throwable -> L7
            if (r1 == null) goto L5;
            r1.getPromotionId();     // Catch: Throwable -> L7
        L5:
            r0.d(IntroAuctionWidgetController$cancelIntroCard$1$1.INSTANCE, IntroAuctionWidgetController$cancelIntroCard$1$2.INSTANCE, this.c);     // Catch: Throwable -> L7
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
        public final /* synthetic */ IntroAuctionWidgetController a;

        public c(IntroAuctionWidgetController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            IntroAuctionWidgetController r0 = this.a;     // Catch: Throwable -> L4
            r0.getClass();     // Catch: Throwable -> L4
            int r1 = g.a;     // Catch: Throwable -> L4
            g.c(false, new IntroAuctionWidgetController$onCardVisible$1(r0), r0.o);     // Catch: Throwable -> L4
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
        public final /* synthetic */ IntroAuctionWidgetController a;
        public final /* synthetic */ IntroAuctionPromotionVO b;

        public static final class a implements Runnable {
            public final /* synthetic */ r0 a;
            public final /* synthetic */ d b;

            public a(r0 r1, d r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.bytedance.android.livesdk.livecommerce.intro.controller.a r0 = this.b.a.v;     // Catch: Throwable -> L6
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

        public d(IntroAuctionWidgetController r1, IntroAuctionPromotionVO r2) {
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
        public final /* synthetic */ IntroAuctionPromotionVO a;

        public e(IntroAuctionPromotionVO r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            this.a.setExposureTime(((Long) r4).longValue());
        }
    }

    static {
        w = LazyKt.lazy(IntroAuctionWidgetController$Companion$disableCardLinkedAnimOnEnter$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final boolean i() {
        if (this.c.getCardState().a() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final String j() {
        IntroAuctionPromotionVO r0 = this.c.getCardState().a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPromotionId();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final boolean n() {
        IntroAuctionPromotionVO r0 = this.c.getCardState().a();
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
        if (this.g == false) goto L10;
        this.g = false;
        int r0 = g.a;
        ECLivePerformanceMonitor r1 = g.a(this.o);
        if (r1 == null) goto L10;
        r1.u("ec_perf_duration_intro_card", "card_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r2 = r1.p;
        if (r2 == null) goto L10;
        Map r3 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r2, MetricNames.POP_CARD_VISIBLE_DURATION);
    L10:
        if (this.h == false) goto L18;
        this.h = false;
        int r4 = g.a;
        ECLivePerformanceMonitor r5 = g.a(this.o);
        if (r5 == null) goto L16;
        r5.u("ec_perf_duration_intro_card", "main_image_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        String r6 = r5.p;
        if (r6 == null) goto L16;
        Map r7 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.j(r6, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION);
    L16:
        this.i = new c(this);
    L18:
        if (this.f == false) goto L26;
        c r8 = this.i;
        if (r8 == null) goto L26;
        this.f = false;
        r8.run();
        this.i = null;
        if (this.j == false) goto L26;
        int r9 = g.a;
        ECLivePerformanceMonitor r10 = g.a(this.o);
        if (r10 == null) goto L26;
        r10.z(this.k);
    L26:
        OptCardUtil.b(null, "call dispatchDraw of card");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void onDestroy() {
        ((bk2.d) this.e.getValue()).clearDisposable();
        Disposable r0 = this.d;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.d = null;
        this.b.r(com.bytedance.android.livesdk.livecommerce.intro.auction.f.class);
        this.c.onDestroy();
    }

    public static final boolean b(IntroAuctionWidgetController r0) {
        return ((Boolean) r0.n.getValue()).booleanValue();
    }

    public static final boolean c(IntroAuctionWidgetController r1) {
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
        IntroAuctionPromotionVO r8 = this.c.getCardState().a();
        if (r8 == null) goto L8;
        String r1 = r8.getProductId();
        if (r1 == null) goto L9;
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this, r1, null, false, false, 14);
        return;
    L9:
        return;
    }

    public final void e(IntroAuctionPromotionVO r12) {
        s0 r0 = r12.getControl();
        if (r0 == null) goto L5;
        long r3 = r0.c();
    L6:
        long r4 = r3 / 1000;
        if (r4 > 0) goto L9;
        return;
    L9:
        Disposable r1 = this.d;
        if (r1 == null) goto L12;
        r1.dispose();
    L12:
        int r2 = t0.a;
        this.d = bk2.c.a(t0.b(0, 1, TimeUnit.SECONDS, Schedulers.io()).take(r4 + 1).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new d(this, r12)).subscribe(new e(r12)), (bk2.d) this.e.getValue());
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void k(boolean r2) {
        IntroAuctionPromotionVO r0 = this.c.getCardState().a();
        if (r0 == null) goto L6;
        r0.getPromotionId();
        d(null, null, r2);
        return;
    }

    public final void d(Function0 r10, Function0 r11, boolean r12) {
        fk2.b r0 = (fk2.b) this.m.getValue();
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = null;
        IntroCardAnimController r1 = this.s;
        IntroAuctionPromotionVO r2 = this.c.getCardState().a();
        if (r2 == null) goto L9;
        String r3 = r2.getPromotionId();
        if (r3 == null) goto L9;
    L10:
        r1.f(new com.bytedance.android.livesdk.livecommerce.intro.controller.e(this, r10, r11, r3, this.b.p(), new IntroAuctionWidgetController$hideIntroCard$2(this, r12)));
        return;
    L9:
        r3 = "";
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void m(uh2.a r12, final boolean r13, final boolean r14) {
        if ((r12 instanceof IntroAuctionPromotionVO) == true) goto L5;
        r12 = null;
    L5:
        final IntroAuctionPromotionVO r6 = (IntroAuctionPromotionVO) r12;
        if (r6 == null) goto L58;
        if (r13 == false) goto L9;
        this.c.getCardState().g(r6);
    L59:
        IntroCardLoadOpt.n = false;
        if (this.l == false) goto L63;
        this.l = false;
        this.c.setEnterRoom(false);
        return;
    L63:
        return;
    L9:
        IntroProduct r0 = r6.getProduct();
        if (r0 == null) goto L12;
        int r1 = r0.h();
    L13:
        this.k = r1;
        IntroCardScene r2 = r6.getCardReqScene();
        if (r2 == null) goto L16;
        boolean r3 = sh2.f.b(r2);
    L17:
        if (r3 == true) goto L24;
        int r4 = g.a;
        ECLivePerformanceMonitor r5 = g.a(this.o);
        if (r5 == null) goto L21;
        ECLivePerformanceMonitor.y(r5, Boolean.FALSE, new gf.a(0));
    L21:
        y r7 = this.o.c;
        if (r7 == null) goto L24;
        r7.f(r6.getPromotionId());
    L24:
        com.bytedance.android.livesdk.livecommerce.room.utils.d r8 = this.o.d;
        String r9 = r6.getPromotionId();
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        r8.d = r9;
        IntroAuctionPromotionVO r10 = this.c.getCardState().a();
        com.bytedance.android.livesdk.livecommerce.intro.manager.a r11 = this.s.a;
        if (r10 == null) goto L27;
        String r15 = r10.getPromotionId();
    L29:
        if (Intrinsics.areEqual(r15, r6.getPromotionId()) == false) goto L38;
        if (r11 != null) goto L32;
    L35:
        e(r6);
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_POP_SAME_CARD_EXTEND() == false) goto L59;
        this.c.getCardState().g(r6);
        goto L59
    L32:
        if (r11.d != 1) goto L35;
        if (r11.d() == false) goto L35;
    L38:
        com.bytedance.android.livesdk.livecommerce.intro.controller.a r16 = this.v;
        if (r16 == null) goto L41;
        r16.a(r14);
    L41:
        Function0<Unit> r17 = new IntroAuctionWidgetController$handleIntroVO$$inlined$also$lambda$1(r6, this, r13, r14);
        OptCardUtil.b(null, "call showExplainCard");
        fk2.b r18 = (fk2.b) this.m.getValue();
        if (r18 == null) goto L49;
        long r19 = SystemClock.elapsedRealtime();
        r18.f = r19;
        if (r18.e <= 0) goto L46;
        boolean r20 = true;
    L47:
        if (r20 == true) goto L49;
        r18.g = r19;
        goto L49
    L46:
        r20 = false;
    L49:
        r6.setShowTimestamp(System.currentTimeMillis());
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = null;
        IntroCardScene r110 = r6.getCardReqScene();
        if (r110 != null) goto L52;
    L54:
        boolean r21 = false;
    L55:
        this.s.f(new f(this, r21, r17, r6, r6.getPromotionId(), this.b.p(), new IntroAuctionWidgetController$showIntroCard$2(this, r21, r14)));
        if (this.l == false) goto L59;
        IntroCardEventCenter r111 = this.c.getCardArgument().a;
        r111.getClass();
        IntroCardEventCenter.b(new com.bytedance.android.livesdk.livecommerce.intro.event.g(r111));
        goto L59
    L52:
        if (sh2.f.a(r110) != true) goto L54;
        r21 = true;
        goto L55
    L27:
        r15 = null;
        goto L29
    L16:
        r3 = false;
        goto L17
    L12:
        r1 = 1;
        goto L13
    L58:
        com.bytedance.android.livesdk.livecommerce.intro.controller.b.a.a(this, null, null, false, false, 15);
        Unit r112 = Unit.INSTANCE;
        goto L59
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.controller.b
    public final void l(String r3, String r4, boolean r5, boolean r6) {
        IntroAuctionPromotionVO r0 = this.c.getCardState().a();
        if (r5 == true) goto L18;
        String r7 = null;
        if (r3 == null) goto L12;
        if (r0 == null) goto L8;
        String r1 = r0.getProductId();
    L10:
        if ((!Intrinsics.areEqual(r3, r1)) == false) goto L12;
        return;
    L8:
        r1 = null;
    L12:
        if (r4 == null) goto L18;
        if (r0 == null) goto L16;
        r7 = r0.getPromotionId();
    L16:
        if ((!Intrinsics.areEqual(r4, r7)) == false) goto L18;
        return;
    L18:
        this.r.i(this.a, new b(this, r0, r4, r6));
    }

    public IntroAuctionWidgetController(Context r14, RoomContextController r15, com.bytedance.android.livesdk.livecommerce.room.model.g r16, LiveRoomParams r17, com.bytedance.android.livesdk.livecommerce.intro.manager.h r18, qh2.d.b r19, com.bytedance.android.livesdk.livecommerce.intro.manager.d r20, IntroCardAnimController r21, u r22, qh2.b r23, com.bytedance.android.livesdk.livecommerce.intro.manager.k r24) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "roomContextController");
        Intrinsics.checkNotNullParameter(r16, "liveRoomInfo");
        Intrinsics.checkNotNullParameter(r18, "rootView");
        Intrinsics.checkNotNullParameter(r19, "btmInfo");
        Intrinsics.checkNotNullParameter(r20, "cardQueue");
        Intrinsics.checkNotNullParameter(r21, "animController");
        Intrinsics.checkNotNullParameter(r22, "animDelegate");
        this.o = r15;
        this.p = r16;
        this.q = r18;
        this.r = r20;
        this.s = r21;
        this.t = r22;
        this.u = r23;
        this.v = r24;
        this.a = 2;
        QUIManager r10 = new QUIManager();
        this.b = r10;
        this.e = LazyKt.lazy(IntroAuctionWidgetController$disposableContext$2.INSTANCE);
        this.j = true;
        this.k = 1;
        this.l = true;
        this.m = LazyKt.lazy(new IntroAuctionWidgetController$durationMonitor$2(this));
        this.n = LazyKt.lazy(IntroAuctionWidgetController$enableEnterRoomAnim$2.INSTANCE);
        IntroAuctionViewModel r12 = new IntroAuctionViewModel(r16, r17, r19, jf.b.e.b, r15, r22);
        r12.setCardCallback(new com.bytedance.android.livesdk.livecommerce.intro.controller.c(this));
        r12.setEnterRoom(this.l);
        Unit r1 = Unit.INSTANCE;
        this.c = r12;
        r10.l(new com.bytedance.android.livesdk.livecommerce.intro.auction.f(r12, r12.getCardArgument(), r12.getContainerAbility()), r18.getContext(), true);
        r10.c(com.bytedance.android.livesdk.livecommerce.intro.auction.f.class, new com.bytedance.android.livesdk.livecommerce.intro.controller.d(this));
        r12.getClickCloseAction().b(g.b(r15), new ActionObserver(new IntroAuctionWidgetController$observeData$1(this)));
        View r2 = r10.p();
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(r2.getLayoutParams());
        r3.gravity = 80;
        r2.setLayoutParams(r3);
        r18.addView(r2);
    }
}
