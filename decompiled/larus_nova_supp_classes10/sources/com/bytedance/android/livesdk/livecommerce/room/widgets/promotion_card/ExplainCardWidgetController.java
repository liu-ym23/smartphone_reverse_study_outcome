package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECSkinData;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.quick.ActionObserver;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.BottomRightCardManager;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.ECLiveDegradeHelper;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.t0;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ExplainCardWidgetController implements n {
    public static final Lazy B = null;
    public final RoomContextController A;
    public final gf.a a;
    public t b;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.h c;
    public final QUIManager d;
    public final ExplainCardViewModel e;
    public Disposable f;
    public final Lazy g;
    public Runnable h;
    public final com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.e i;
    public boolean j;
    public cf.n k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public i q;
    public boolean r;
    public Map<String, ? extends Map<String, String>> s;
    public final Lazy t;
    public final Context u;
    public final ml.b v;
    public final ViewGroup w;
    public final BottomRightAnimController x;
    public final ef.a y;
    public final fk2.a z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ExplainCardWidgetController a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ Pair e;
        public final /* synthetic */ com.bytedance.android.ec.model.response.s f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Map h;

        public b(ExplainCardWidgetController r1, boolean r2, String r3, Function1 r4, Pair r5, com.bytedance.android.ec.model.response.s r6, String r7, Map r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void a() {
            if (this.b == false) goto L7;
            ECLivePerformanceMonitor r0 = this.a.h();
            if (r0 == null) goto L7;
            ECLivePerformanceMonitor.y(r0, Boolean.TRUE, this.a.a);
        L7:
            this.a.k(this.b, false, this.c, this.d, this.e, this.f, this.g, this.h);
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

    public static final class c implements Runnable {
        public final /* synthetic */ ExplainCardWidgetController a;

        public c(ExplainCardWidgetController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            n.a.a(this.a, null, null, 7);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d extends com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b {
        public final /* synthetic */ ExplainCardWidgetController f;
        public final /* synthetic */ Function0 g;
        public final /* synthetic */ ExplainCardViewModel h;
        public final /* synthetic */ Function0 i;

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
        public final void c() {
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
        public final void a() {
            this.h.getPromotionState().e(null);
            if (this.h.isFromLive() == true) goto L5;
        L20:
            ExplainCardWidgetController r0 = this.f;
            Disposable r2 = r0.f;
            if (r2 == null) goto L23;
            r2.dispose();
        L23:
            r0.f = null;
            Runnable r3 = r0.h;
            if (r3 == null) goto L26;
            UtilityKotlinExtentionsKt.b.removeCallbacks(r3);
        L26:
            r0.h = null;
            Function0 r1 = this.i;
            if (r1 == null) goto L30;
            Unit r4 = (Unit) r1.invoke();
            return;
        L30:
            return;
        L5:
            if (this.f.A.v() == false) goto L7;
            ECContext r5 = this.f.A.r();
        L8:
            if (r5 != null) goto L10;
        L11:
            if (r5 == null) goto L16;
            com.bytedance.live.datacontext.m<Boolean> r6 = r5.isBottomCardVisible();
            if (r6 == null) goto L16;
            r6.setValue(Boolean.FALSE);
        L16:
            if (t.j == false) goto L20;
            com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.h r7 = this.f.c;
            if (r7 == null) goto L20;
            r7.q(false);
            goto L20
        L10:
            if (r5.isCleared() == true) goto L20;
        L7:
            int r8 = RoomContextController.h;
            r5 = RoomContextController.a.a().r();
            goto L8
        }

        @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b
        public final void b() {
            Function0 r0 = this.g;
            if (r0 == null) goto L6;
            Unit r1 = (Unit) r0.invoke();
            return;
        }

        public d(ExplainCardWidgetController r1, Function0 r2, ExplainCardViewModel r3, Function0 r4, String r5, View r6, Function2 r7) {
            this.f = r1;
            this.g = r2;
            this.h = r3;
            this.i = r4;
            super(r5, r6, 1, r7);
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ ExplainCardWidgetController a;
        public final /* synthetic */ ECUIPromotion b;

        public e(ExplainCardWidgetController r1, ECUIPromotion r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            n.a.a(this.a, null, this.b.getPromotionId(), 5);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ ECUIPromotion a;

        public f(ECUIPromotion r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.exposureTime = (Long) r2;
        }
    }

    static {
        B = LazyKt.lazy(ExplainCardWidgetController$Companion$disableCardLinkedAnimOnEnter$2.INSTANCE);
    }

    public final ECLivePerformanceMonitor h() {
        if (this.a.a() == true) goto L5;
    L16:
        return null;
    L5:
        if (this.A.v() == false) goto L11;
        ECContext r0 = this.A.r();
        if (r0 == null) goto L16;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r1 = r0.getEcLivePerformanceMonitor();
        if (r1 == null) goto L16;
        return (ECLivePerformanceMonitor) r1.getValue();
    L11:
        int r2 = RoomContextController.h;
        ECContext r3 = RoomContextController.a.a().r();
        if (r3 == null) goto L16;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r4 = r3.getEcLivePerformanceMonitor();
        if (r4 == null) goto L16;
        return (ECLivePerformanceMonitor) r4.getValue();
    }

    public final LifecycleOwner i() {
        LifecycleOwner r1 = null;
        if (this.a.a() == true) goto L5;
        LifecycleOwner r0 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.u);
        if ((r0 instanceof LifecycleOwner) == false) goto L24;
        r1 = r0;
    L24:
        r1 = r1;
    L25:
        if (r1 == null) goto L27;
        return r1;
    L27:
        return ECQuickUtilKt.b;
    L5:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L8;
        RoomContextController r2 = this.A;
    L15:
        ECContext r3 = r2.r();
        if (r3 == null) goto L25;
        com.bytedance.live.datacontext.i<LiveRoomLifecycleOwner> r4 = r3.getLifecycleOwner();
        if (r4 == null) goto L25;
        r1 = (LiveRoomLifecycleOwner) r4.getValue();
        goto L25
    L8:
        if (this.A.v() == false) goto L10;
        r2 = this.A;
        goto L15
    L10:
        int r5 = RoomContextController.h;
        ml.b r6 = this.v;
        if (r6 == null) goto L13;
        String r7 = r6.roomId();
    L14:
        r2 = RoomContextController.a.b(r7, this.A.D());
        goto L15
    L13:
        r7 = null;
        goto L14
    }

    public static final boolean c(ExplainCardWidgetController r1) {
        if (r1.a.a() == true) goto L5;
    L11:
        return false;
    L5:
        if (com.bytedance.android.livesdk.livecommerce.utils.n.c() == true) goto L7;
    L8:
        ECLiveDegradeHelper.c.getClass();
        if (ECLiveDegradeHelper.c() != 1) goto L11;
        return true;
    L7:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.e(com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e) == true) goto L8;
        return true;
    }

    public static final void d(ExplainCardWidgetController r2, boolean r3) {
        r2.getClass();
        String r0 = null;
        OptCardUtil.b(null, "call onCardLoadFinish isShow=" + r3);
        if (r2.a.a() == true) goto L5;
        return;
    L5:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L8;
        r2.A.A().t.Y();
        return;
    L8:
        if (r2.A.v() == false) goto L10;
        r2.A.A().t.Y();
        return;
    L10:
        boolean r4 = EntryController.M1;
        ml.b r5 = r2.v;
        if (r5 == null) goto L13;
        r0 = r5.roomId();
    L13:
        EntryController.a.b(r0, r2.A.D()).Y();
    }

    public static final void e(ExplainCardWidgetController r1, boolean r2) {
        r1.getClass();
        if (r2 == true) goto L5;
        UtilityKotlinExtentionsKt.b.post(new g(r1));
    L5:
        UtilityKotlinExtentionsKt.b.post(new h(r1));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.n
    public final void a(final String r4, final String r5) {
        this.y.c(CardType.EXPLAIN_CARD, new ExplainCardWidgetController$cancelExplainCard$1(this, r4, r5));
    }

    public final void g(final String r19, final long r20) {
        if (r19 != null) goto L5;
        return;
    L5:
        ECUIPromotion r0 = (ECUIPromotion) this.e.getPromotionState().a();
        if (r0 != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(r0.getPromotionId(), r19) == true) goto L11;
        r0 = null;
    L11:
        final ECUIPromotion r1 = r0;
        if (r1 == null) goto L41;
        long r4 = RangesKt.coerceAtLeast(System.currentTimeMillis() - r1.showTimestamp.longValue(), 0);
        dm.a.a("BottomRightCardManager").i("extend card(" + r19 + ") show time for " + r20 + " ms, current exposure " + r4);
        Long r2 = Long.valueOf(r1.showDuration);
        if (r2 == null) goto L16;
        long r12 = r2.longValue();
    L17:
        ECLiveABUtils r3 = ECLiveABUtils.INSTANCE;
        if (r4 <= ((r12 * 1000) - r3.getEC_LIVE_CARD_HOT_ATMOSPHERE_EXTEND_TIME())) goto L43;
        Long r5 = Long.valueOf(r1.showDuration);
        if (r5 == null) goto L23;
        long r13 = r5.longValue();
    L25:
        if (((r13 * 1000) - r4) >= r3.getEC_LIVE_CARD_HOT_ATMOSPHERE_EXTEND_TIME()) goto L27;
    L28:
        Function0<Unit> r14 = new ExplainCardWidgetController$extendExplainCardShowTime$$inlined$also$lambda$1(r1, this, r19, r20);
        Disposable r6 = this.f;
        if (r6 == null) goto L32;
        r6.dispose();
    L32:
        if (r20 <= 0) goto L37;
        Runnable r7 = this.h;
        if (r7 == null) goto L36;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r7);
    L36:
        j r8 = new j(r20, r14);
        this.h = r8;
        UtilityKotlinExtentionsKt.b.postDelayed(r8, r20);
    L38:
        dm.a.a("BottomRightCardManager").i("real extend time " + r20);
        return;
    L37:
        r14.invoke();
        goto L38
    L27:
        if (r4 >= r1.showDuration) goto L28;
        return;
    L23:
        r13 = 0;
        goto L25
    L43:
        return;
    L16:
        r12 = 0;
        goto L17
    }

    public final void m(ECUIPromotion r6, long r7) {
        if ((!r6.isAuction()) == true) goto L6;
        return;
    L6:
        if (r7 <= 0) goto L9;
    L12:
        dm.a.a("BottomRightCardManager").i("(" + hashCode() + ") start card timer for " + r7 + " s");
        if (r7 > 0) goto L15;
        return;
    L15:
        Disposable r2 = this.f;
        if (r2 == null) goto L18;
        r2.dispose();
    L18:
        int r3 = t0.a;
        this.f = bk2.c.a(t0.a(0, 1, TimeUnit.SECONDS).take(r7 + 1).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new e(this, r6)).subscribe(new f(r6)), (bk2.d) this.g.getValue());
        return;
    L9:
        if (com.bytedance.android.ec.core.abtest.d.G() == false) goto L11;
        r7 = com.bytedance.android.ec.core.abtest.d.H();
        goto L12
    L11:
        r7 = r6.showDuration;
        goto L12
    }

    public final void j(String r10, Function0<Unit> r11, Function0<Unit> r12) {
        fk2.b r13 = (fk2.b) this.t.getValue();
        if (r13 == null) goto L5;
        r13.a();
    L5:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r14 = this.A.A().q.j;
        if (r14 == null) goto L8;
        r14.h();
    L8:
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = null;
        final ExplainCardViewModel r3 = this.e;
        BottomRightAnimController r15 = this.x;
        ECUIPromotion r0 = (ECUIPromotion) r3.getPromotionState().a();
        if (r0 == null) goto L12;
        String r1 = r0.getPromotionId();
        if (r1 == null) goto L12;
    L13:
        r15.f(new d(this, r11, r3, r12, r1, this.d.p(), new ExplainCardWidgetController$hideExplainCard$2(this, r3)));
        return;
    L12:
        r1 = "";
        goto L13
    }

    public final void l(Function1 r11, String r12, Map r13) {
        ExplainCardViewModel r0 = this.e;
        if (r0 == null) goto L10;
        QLiveData<ECUIPromotion> r1 = r0.getPromotionState();
        if (r1 != null) goto L7;
        return;
    L7:
        if (((ECUIPromotion) r1.a()) == null) goto L12;
        k(true, true, null, r11, null, null, r12, r13);
        return;
    L12:
        return;
    }

    public static final void b(final ExplainCardWidgetController r18, final ECUIPromotion r19, final boolean r20, final boolean r21, final boolean r22, String r23, Function1 r24) {
        ECLivePerformanceMonitor r0 = r18.h();
        if (r0 == null) goto L7;
        r0.v("ec_perf_duration_shopping_card", CollectionsKt.listOf("render_start"), Long.valueOf(SystemClock.elapsedRealtime()));
        String r1 = r0.p;
        if (r1 == null) goto L7;
        Map r2 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r1, MetricNames.RENDER_DURATION, null);
        com.bytedance.android.ec.core.monitor.c.h(r1, MetricNames.POP_CARD_ANIM_DELAY_DURATION, null);
    L7:
        if (r21 == true) goto L10;
        if (r19 != null) goto L10;
        UtilityKotlinExtentionsKt.b.post(new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.d(r18));
    L10:
        Boolean r3 = t.q;
        if (r3 != null) goto L14;
        t.q = Boolean.TRUE;
    L16:
        boolean r7 = true;
        if (r23 != null) goto L19;
    L28:
        if (r19 == null) goto L34;
        if (r21 == false) goto L32;
        if (r22 == false) goto L32;
        String r4 = "1";
    L33:
        r19.appendExtraEventParams("card_pop_with_cache", r4);
    L32:
        r4 = BDLocationException.ERROR_TIMEOUT;
    L34:
        if (r19 == null) goto L104;
        ExplainCardViewModel r5 = r18.e;
        ECSkinData r6 = r19.skinData;
        if (r6 == null) goto L38;
        List<String> r8 = r6.getThemes();
    L39:
        r5.initCardSkin(r8);
        if (r18.A.v() == false) goto L42;
        RoomContextController r9 = r18.A;
    L43:
        if (r21 == false) goto L45;
    L52:
        String r10 = "";
        if (r18.a.a() == false) goto L58;
        com.bytedance.android.livesdk.livecommerce.room.utils.d r11 = r9.d;
        String r12 = r19.getProductId();
        if (r12 != null) goto L57;
        r12 = "";
    L57:
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "<set-?>");
        r11.d = r12;
    L58:
        ECUIPromotion r13 = (ECUIPromotion) r18.e.getPromotionState().a();
        com.bytedance.android.livesdk.livecommerce.room.widgets.anim.b r14 = r18.x.a;
        if (r13 == null) goto L61;
        String r15 = r13.getPromotionId();
    L63:
        if (Intrinsics.areEqual(r15, r19.getPromotionId()) == false) goto L77;
        if (r20 == true) goto L77;
        if (r14 != null) goto L67;
    L76:
        r18.m(r19, 0);
    L105:
        t.p = false;
        if (r18.j == false) goto L108;
        r18.j = false;
        r18.e.setEnterRoom(false);
    L108:
        if (r24 == null) goto L111;
        Unit r16 = (Unit) r24.invoke(r19);
        return;
    L111:
        return;
    L67:
        if (r14.d != 1) goto L76;
        int r17 = r14.a;
        if (r17 != 1) goto L71;
    L74:
        boolean r25 = true;
    L75:
        if (r25 == true) goto L77;
    L71:
        if (r17 == 2) goto L74;
        r25 = false;
    L77:
        if (r13 == null) goto L79;
        r18.j(r13.getPromotionId(), null, null);
    L79:
        Function0<Unit> r110 = new ExplainCardWidgetController$handlePromotion$$inlined$let$lambda$1(r19, r18, r21, r19, r20, r22);
        int r26 = com.bytedance.android.livesdk.livecommerce.kmp.a.a;
        Intrinsics.checkNotNullParameter("pop_card_load", "scene");
        OptCardUtil.b(null, "call showExplainCard");
        fk2.b r27 = (fk2.b) r18.t.getValue();
        if (r27 == null) goto L87;
        long r28 = SystemClock.elapsedRealtime();
        r27.f = r28;
        if (r27.e > 0) goto L85;
        r7 = false;
    L85:
        if (r7 == true) goto L87;
        r27.g = r28;
    L87:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.a r29 = r18.A.A().q.j;
        if (r29 == null) goto L90;
        r29.j(r19);
    L90:
        r19.showTimestamp = Long.valueOf(System.currentTimeMillis());
        r18.n = false;
        r18.o = false;
        r18.p = false;
        r18.q = null;
        ExplainCardViewModel r30 = r18.e;
        BottomRightAnimController r31 = r18.x;
        String r32 = r19.getPromotionId();
        if (r32 == null) goto L94;
        r10 = r32;
    L94:
        r31.f(new k(r18, r110, r30, r19, r21, r10, r18.d.p(), new ExplainCardWidgetController$showExplainCard$2(r18, r30, r21)));
        if (r18.j == false) goto L101;
        int r33 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a;
        ml.b r34 = r18.v;
        if (r34 == null) goto L99;
        String r111 = r34.roomId();
    L100:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.d.a("ECProductIntroduceEvent", new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.m(ControllerExtensionsKt.c(r18.A, r111), r19.getProductId()));
        goto L101
    L99:
        r111 = null;
    L101:
        fk2.a r35 = r18.z;
        if (r35 == null) goto L105;
        r35.b(r18.a.a(), r21, r22, r19.getPromotionId(), false);
        goto L105
    L61:
        r15 = null;
        goto L63
    L45:
        if (r18.a.a() == false) goto L52;
        ECLivePerformanceMonitor r36 = r18.h();
        if (r36 == null) goto L49;
        ECLivePerformanceMonitor.y(r36, Boolean.FALSE, r18.a);
    L49:
        sg2.y r37 = r9.c;
        if (r37 == null) goto L52;
        r37.f(r19.getPromotionId());
        goto L52
    L42:
        int r38 = RoomContextController.h;
        r9 = RoomContextController.a.a();
        goto L43
    L38:
        r8 = null;
        goto L39
    L104:
        n.a.a(r18, null, null, 7);
        goto L105
    L19:
        if (r23.length() <= 0) goto L21;
        boolean r39 = true;
    L22:
        if (r39 == false) goto L24;
        String r40 = r23;
    L25:
        if (r40 == null) goto L28;
        if (r19 == null) goto L28;
        r19.appendExtraEventParams("card_pop_scene", r40);
        goto L28
    L24:
        r40 = null;
        goto L25
    L21:
        r39 = false;
        goto L22
    L14:
        if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L16;
        t.q = Boolean.FALSE;
        goto L16
    }

    public final void f(String r15, Function1<? super ECUIPromotion, Unit> r16, boolean r17, Pair<Long, Long> r18, com.bytedance.android.ec.model.response.s r19, String r20, Map<String, String> r21) {
        this.y.l(new ef.d(10, CardType.EXPLAIN_CARD, new b(this, r17, r15, r16, r18, r19, r20, r21), new c(this)));
    }

    public final void k(final boolean r17, final boolean r18, String r19, final Function1<? super ECUIPromotion, Unit> r20, Pair<Long, Long> r21, com.bytedance.android.ec.model.response.s r22, String r23, Map<String, String> r24) {
        String r5 = "";
        if (r17 == true) goto L93;
        if (r18 == true) goto L93;
        if (this.a.a() == false) goto L93;
        p r6 = this.A.A().t.V;
        final t r7 = this.b;
        if (r7 == null) goto L89;
        ml.b r8 = this.v;
        if (r8 == null) goto L12;
        String r9 = r8.roomId();
    L13:
        if (r9 != null) goto L15;
        r9 = "";
    L15:
        final Function1<ECUIPromotion, Unit> r10 = new ExplainCardWidgetController$queryPopPromotion$isOptLoad$1(this, r18, r20);
        Intrinsics.checkNotNullParameter(r10, "callback");
        dm.a.b r11 = dm.a.a("LiveCardLoad");
        StringBuilder r12 = new StringBuilder("consume explain card promotion, isInstant = ");
        boolean r13 = false;
        boolean r14 = true;
        if (r6 == null) goto L18;
        boolean r15 = true;
    L19:
        r12.append(r15);
        r11.i(r12.toString());
        if (r6 == null) goto L35;
        Function1<ECUIPromotion, Unit> r16 = new PromotionCardLoadOpt$consumeCachedPromotion$1(r10);
        Intrinsics.checkNotNullParameter(r16, "callback");
        p.a("getExplainCardData, isApiLoading = " + r6.b);
        p.a r25 = r6.c;
        if (r25 == null) goto L88;
        ECUIPromotion r26 = r25.a;
        ECUIPromotion r27 = r25.b;
        if (r26 != null) goto L26;
        r16.invoke(null);
        goto L88
    L26:
        long r110 = r26.showPriority;
        if (r27 == null) goto L29;
        long r111 = r27.showPriority;
    L31:
        if (r110 < r111) goto L33;
        r16.invoke(r26);
        r6.b(r26);
        goto L88
    L33:
        r16.invoke(null);
        goto L88
    L29:
        r111 = 0;
    L88:
        Boolean r28 = Boolean.valueOf(r14);
    L91:
        if (Intrinsics.areEqual(r28, Boolean.TRUE) == false) goto L93;
        return;
    L35:
        if (cg4.a.a(r9) == false) goto L63;
        y.o.getClass();
        if (y.j == false) goto L63;
        final y r29 = y.n.get(r9);
        if (r29 == null) goto L63;
        if (r29.a == false) goto L44;
        r29.g = new PromotionCardLoadOpt$consumeCachedPromotion$$inlined$let$lambda$1(r29, r7, r10);
    L52:
        boolean r30 = true;
    L54:
        if (r30 == false) goto L63;
        ECContext r31 = r7.e;
        if (r31 == null) goto L62;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r32 = r31.getEcLivePerformanceMonitor();
        if (r32 == null) goto L62;
        ECLivePerformanceMonitor r33 = (ECLivePerformanceMonitor) r32.getValue();
        if (r33 == null) goto L62;
        r33.B(r29.e);
    L62:
        OptCardUtil.b(null, "enterload consumeCachedPromotion isLoading=" + r29.a + " isCacheAvailable=" + r29.e);
        goto L88
    L44:
        if (r29.e == false) goto L53;
        r10.invoke(r29.d);
        ECContext r34 = r7.e;
        if (r34 == null) goto L52;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r35 = r34.getEcLivePerformanceMonitor();
        if (r35 == null) goto L52;
        ECLivePerformanceMonitor r36 = (ECLivePerformanceMonitor) r35.getValue();
        if (r36 == null) goto L52;
        r36.c(r29.b, r29.c);
        goto L52
    L53:
        r30 = false;
    L63:
        OptCardUtil.b(null, "consumeCachedPromotion isCacheAvailable=" + r7.b);
        if (t.f == true) goto L67;
    L80:
        ECContext r37 = r7.e;
        if (r37 == null) goto L87;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r38 = r37.getEcLivePerformanceMonitor();
        if (r38 == null) goto L87;
        ECLivePerformanceMonitor r39 = (ECLivePerformanceMonitor) r38.getValue();
        if (r39 == null) goto L87;
        r39.B(r7.b);
    L87:
        r14 = r13;
        goto L88
    L67:
        if (r7.c == false) goto L70;
        r7.d = r10;
    L79:
        r13 = true;
        goto L80
    L70:
        if (r7.b == false) goto L80;
        ECContext r40 = r7.e;
        if (r40 == null) goto L78;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r41 = r40.getEcLivePerformanceMonitor();
        if (r41 == null) goto L78;
        ECLivePerformanceMonitor r42 = (ECLivePerformanceMonitor) r41.getValue();
        if (r42 == null) goto L78;
        r42.B(true);
    L78:
        r10.invoke(r7.a);
        goto L79
    L18:
        r15 = false;
        goto L19
    L12:
        r9 = null;
        goto L13
    L89:
        r28 = null;
    L93:
        if (r17 == false) goto L103;
        ECLivePerformanceMonitor r43 = h();
        if (r43 == null) goto L103;
        ml.b r44 = this.v;
        if (r44 == null) goto L102;
        String r45 = r44.roomId();
        if (r45 == null) goto L102;
        r5 = r45;
    L102:
        r43.r(r17, r5, this.A.A().t.U);
    L103:
        ExplainCardViewModel r46 = this.e;
        ECLivePerformanceMonitor r47 = h();
        if (r47 == null) goto L108;
        r47.u("ec_perf_duration_shopping_card", "request_start", Long.valueOf(SystemClock.elapsedRealtime()));
        String r48 = r47.p;
        if (r48 == null) goto L108;
        Map r49 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r48, MetricNames.POP_API_DURATION, null);
    L108:
        if (r46 == null) goto L111;
        r46.queryPopPromotion(r19, !r17, r21, r22, r23, r24, new ExplainCardWidgetController$queryPopPromotion$2(this, r18, r17, r20));
        return;
    }

    public ExplainCardWidgetController(Context r17, ml.b r18, LiveRoomParams r19, cf.i r20, BottomRightCardManager.b r21, BottomRightAnimController r22, int r23, cf.c r24, ef.a r25, fk2.a r26, RoomContextController r27) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r20, "getExplainPromotion");
        Intrinsics.checkNotNullParameter(r21, "rootView");
        Intrinsics.checkNotNullParameter(r22, "animController");
        Intrinsics.checkNotNullParameter(r24, "btmInfo");
        Intrinsics.checkNotNullParameter(r25, "cardManager");
        Intrinsics.checkNotNullParameter(r27, "roomContextController");
        this.u = r17;
        this.v = r18;
        this.w = r21;
        this.x = r22;
        this.y = r25;
        this.z = r26;
        this.A = r27;
        gf.a r12 = new gf.a(r23);
        this.a = r12;
        QUIManager r13 = new QUIManager();
        this.d = r13;
        this.g = LazyKt.lazy(ExplainCardWidgetController$disposableContext$2.INSTANCE);
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.e r14 = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.e(this);
        this.i = r14;
        this.j = true;
        this.r = true;
        this.t = LazyKt.lazy(new ExplainCardWidgetController$durationMonitor$2(this));
        final ExplainCardViewModel r10 = new ExplainCardViewModel(r20, r12, r18, r19, r24, jf.b.g.b, r27);
        r10.setOpenSchemaProxy(this.k);
        r10.setEventPassthroughParams(new ExplainCardWidgetController$$special$$inlined$also$lambda$1(this));
        r10.setCardCallback(new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.b(this));
        r10.setEnterRoom(this.j);
        com.bytedance.android.livesdk.livecommerce.room.controller.business.u r3 = r27.A().v;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r10, "instance");
        r3.f = r10;
        r3.H("explain_card", r21);
        r13.l(new rk2.g(r10), r21.getContext(), true);
        r13.c(rk2.g.class, new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.c(this, r10));
        r10.getClickCloseAction().b(i(), new ActionObserver(new ExplainCardWidgetController$observeData$1(this, r10)));
        if (r12.a() == false) goto L5;
        r10.getNoFilterNoticeLiveData().b(i(), new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.f(this, r10));
    L5:
        this.e = r10;
        View r1 = r13.p();
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(r1.getLayoutParams());
        r4.gravity = 80;
        Unit r5 = Unit.INSTANCE;
        r1.setLayoutParams(r4);
        r21.addView(r1);
        Lazy r2 = LiveEventCenter.b;
        LiveEventCenter.a.a().b(r14);
    }
}
