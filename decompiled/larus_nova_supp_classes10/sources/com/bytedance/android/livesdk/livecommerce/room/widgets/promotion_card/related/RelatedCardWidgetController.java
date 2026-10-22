package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.livesdk.livecommerce.model.ProductInfo;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
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
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sg2.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RelatedCardWidgetController implements com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b {
    public static final /* synthetic */ int s = 0;
    public final gf.a a;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.h b;
    public final Lazy c;
    public Map<String, ? extends Map<String, String>> d;
    public final QUIManager e;
    public final ExplainCardViewModel f;
    public Disposable g;
    public boolean h;
    public boolean i;
    public boolean j;
    public w k;
    public final Context l;
    public final ml.b m;
    public final BottomRightAnimController n;
    public final fk2.a o;
    public final Function0<Unit> p;
    public final ef.a q;
    public final RoomContextController r;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ RelatedCardWidgetController a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Function1 d;
        public final /* synthetic */ Pair e;
        public final /* synthetic */ com.bytedance.android.ec.model.response.s f;

        public b(RelatedCardWidgetController r1, boolean r2, String r3, Function1 r4, Pair r5, com.bytedance.android.ec.model.response.s r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.k(this.b, false, this.c, this.d, this.e, this.f);     // Catch: Throwable -> L4
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
        public final /* synthetic */ RelatedCardWidgetController a;

        public c(RelatedCardWidgetController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b.a.a(this.a, null, null, 7);     // Catch: Throwable -> L4
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
        public final /* synthetic */ RelatedCardWidgetController a;
        public final /* synthetic */ ECUIPromotion b;

        public d(RelatedCardWidgetController r1, ECUIPromotion r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b.a.a(this.a, this.b.getPromotionId(), null, 6);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ECUIPromotion a;

        public e(ECUIPromotion r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.exposureTime = (Long) r2;
        }
    }

    static {
    }

    public final ECLivePerformanceMonitor h() {
        if (this.a.a() == false) goto L14;
        RoomContextController r0 = this.r;
        ml.b r2 = this.m;
        if (r2 == null) goto L7;
        String r3 = r2.roomId();
    L8:
        ECContext r1 = ControllerExtensionsKt.c(r0, r3).r();
        if (r1 == null) goto L15;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r4 = r1.getEcLivePerformanceMonitor();
        if (r4 != null) goto L13;
        return null;
    L13:
        return (ECLivePerformanceMonitor) r4.getValue();
    L15:
        return null;
    L7:
        r3 = null;
        goto L8
    L14:
        return null;
    }

    public final LifecycleOwner i() {
        LifecycleOwner r1 = null;
        if (this.a.a() == false) goto L13;
        RoomContextController r0 = this.r;
        ml.b r2 = this.m;
        if (r2 == null) goto L7;
        String r3 = r2.roomId();
    L8:
        ECContext r4 = ControllerExtensionsKt.c(r0, r3).r();
        if (r4 == null) goto L18;
        com.bytedance.live.datacontext.i<LiveRoomLifecycleOwner> r5 = r4.getLifecycleOwner();
        if (r5 == null) goto L18;
        r1 = (LiveRoomLifecycleOwner) r5.getValue();
    L18:
        if (r1 == null) goto L20;
        return r1;
    L20:
        return ECQuickUtilKt.b;
    L7:
        r3 = null;
        goto L8
    L13:
        LifecycleOwner r6 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.l);
        if ((r6 instanceof LifecycleOwner) == false) goto L17;
        r1 = r6;
    L17:
        r1 = r1;
        goto L18
    }

    public static final boolean e(RelatedCardWidgetController r1) {
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

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b
    public final void a(String r8) {
        ECUIPromotion r0 = (ECUIPromotion) this.f.getPromotionState().a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0.getPromotionId(), r8) == false) goto L9;
        k(true, true, null, null, null, null);
        return;
    }

    public final void l(ECUIPromotion r8) {
        if ((!r8.isAuction()) == true) goto L6;
        return;
    L6:
        if (com.bytedance.android.ec.core.abtest.d.G() == false) goto L8;
        long r0 = com.bytedance.android.ec.core.abtest.d.H();
    L10:
        if (r0 > 0) goto L12;
        return;
    L12:
        Disposable r4 = this.g;
        if (r4 == null) goto L15;
        r4.dispose();
    L15:
        int r5 = t0.a;
        this.g = bk2.c.a(t0.a(0, 1, TimeUnit.SECONDS).take(r0 + 1).observeOn(AndroidSchedulers.mainThread()).doOnComplete(new d(this, r8)).subscribe(new e(r8)), (bk2.d) this.c.getValue());
        return;
    L8:
        r0 = r8.showDuration;
        goto L10
    }

    public static final void f(RelatedCardWidgetController r2, boolean r3) {
        r2.getClass();
        String r0 = null;
        OptCardUtil.b(null, "call onCardLoadFinish isShow=" + r3);
        if (r2.a.a() == false) goto L9;
        RoomContextController r4 = r2.r;
        ml.b r5 = r2.m;
        if (r5 == null) goto L7;
        r0 = r5.roomId();
    L7:
        ControllerExtensionsKt.c(r4, r0).A().t.Y();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b
    public final void b(final String r4, final String r5) {
        this.q.c(CardType.RELATED_CARD, new RelatedCardWidgetController$cancelCard$1(this, r4, r5));
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b
    public final void c(String r3, ProductInfo r4) {
        Intrinsics.checkNotNullParameter(r3, "promotionId");
        Intrinsics.checkNotNullParameter(r4, "productInfo");
        ECUIPromotion r0 = (ECUIPromotion) this.f.getPromotionState().a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r0.getPromotionId(), r3) == false) goto L15;
        String r5 = r4.title;
        if (r5 == null) goto L9;
        r0.title = r5;
    L9:
        String r6 = r4.cover;
        if (r6 == null) goto L12;
        r0.setCover(r6);
    L12:
        this.f.getPromotionState().e(r0);
        return;
    }

    public static void j(final RelatedCardWidgetController r7, Function0 r8, int r9) {
        if ((r9 & 2) == 0) goto L5;
        Function0 r3 = null;
    L6:
        r7.h = false;
        r7.i = false;
        r7.j = false;
        r7.k = null;
        BottomRightAnimController r10 = r7.n;
        ECUIPromotion r0 = (ECUIPromotion) r7.f.getPromotionState().a();
        if (r0 == null) goto L10;
        String r1 = r0.getPromotionId();
        if (r1 == null) goto L10;
    L11:
        r10.f(new u(r7, null, r3, r1, r7.e.p(), new RelatedCardWidgetController$hideExplainCard$2(r7)));
        return;
    L10:
        r1 = "";
        goto L11
    L5:
        r3 = r8;
        goto L6
    }

    public static final void d(final RelatedCardWidgetController r16, final ECUIPromotion r17, final boolean r18, final boolean r19, Function1 r20) {
        ECLivePerformanceMonitor r0 = r16.h();
        if (r0 == null) goto L5;
        r0.v("ec_perf_duration_shopping_related_card", CollectionsKt.listOf("render_start"), Long.valueOf(SystemClock.elapsedRealtime()));
    L5:
        if (r19 == true) goto L9;
        if (r17 != null) goto L9;
        UtilityKotlinExtentionsKt.b.post(new t(r16));
    L9:
        if (r17 == null) goto L45;
        r16.p.invoke();
        RoomContextController r1 = r16.r;
        ml.b r2 = r16.m;
        if (r2 == null) goto L13;
        String r3 = r2.roomId();
    L14:
        RoomContextController r4 = ControllerExtensionsKt.c(r1, r3);
        if (r19 == true) goto L22;
        if (r16.a.a() == false) goto L22;
        y r5 = r4.c;
        if (r5 == null) goto L22;
        r5.f(r17.getPromotionId());
    L22:
        if (r16.a.a() == false) goto L27;
        com.bytedance.android.livesdk.livecommerce.room.utils.d r6 = r4.d;
        String r7 = r17.getProductId();
        if (r7 != null) goto L26;
        r7 = "";
    L26:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r6.d = r7;
    L27:
        ECUIPromotion r8 = (ECUIPromotion) r16.f.getPromotionState().a();
        if (r8 == null) goto L30;
        String r9 = r8.getPromotionId();
    L32:
        if (Intrinsics.areEqual(r9, r17.getProductId()) == false) goto L36;
        if (r18 == false) goto L35;
        r16.f.getPromotionState().e(r17);
    L46:
        if (r20 == null) goto L49;
        Unit r10 = (Unit) r20.invoke(r17);
        return;
    L49:
        return;
    L35:
        r16.l(r17);
        goto L46
    L36:
        if (r8 == null) goto L38;
        j(r16, null, 3);
    L38:
        Function0<Unit> r11 = new RelatedCardWidgetController$handlePromotion$$inlined$let$lambda$1(r17, r16, r19, r17, r18);
        OptCardUtil.b(null, "call showExplainCard");
        r16.h = false;
        r16.i = false;
        r16.j = false;
        r16.k = null;
        ExplainCardViewModel r12 = r16.f;
        BottomRightAnimController r13 = r16.n;
        String r14 = r17.getPromotionId();
        if (r14 != null) goto L41;
        String r15 = "";
    L42:
        r13.f(new x(r16, r11, r12, r17, r19, r15, r16.e.p(), new RelatedCardWidgetController$showExplainCard$2(r16, r12, r19)));
        fk2.a r21 = r16.o;
        if (r21 == null) goto L46;
        r21.b(r16.a.a(), r19, false, r17.getPromotionId(), true);
        goto L46
    L41:
        r15 = r14;
        goto L42
    L30:
        r9 = null;
        goto L32
    L13:
        r3 = null;
        goto L14
    L45:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b.a.a(r16, null, null, 7);
        goto L46
    }

    public final void g(String r13, Function1<? super ECUIPromotion, Unit> r14, boolean r15, Pair<Long, Long> r16, com.bytedance.android.ec.model.response.s r17) {
        this.q.l(new ef.d(30, CardType.RELATED_CARD, new b(this, r15, r13, r14, r16, r17), new c(this)));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void k(final boolean r17, final boolean r18, String r19, final Function1<? super ECUIPromotion, Unit> r20, Pair<Long, Long> r21, com.bytedance.android.ec.model.response.s r22) {
        if (r17 == true) goto L68;
        if (r18 == true) goto L68;
        if (this.a.a() == false) goto L68;
        ml.b r4 = this.m;
        Boolean r5 = null;
        ECLivePerformanceMonitor r6 = null;
        r6 = null;
        r5 = null;
        if (r4 == null) goto L66;
        String r7 = r4.roomId();
        if (r7 == null) goto L66;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p r8 = this.r.A().t.V;
        dm.a.a("LiveCardLoader").i("try to consume related card data, instantRoomCardLoader = " + r8);
        PromotionCardLoadOptUtils.p.getClass();
        final PromotionCardLoadOptUtils r9 = PromotionCardLoadOptUtils.Companion.c(r7);
        final Function1<ECUIPromotion, Unit> r10 = new RelatedCardWidgetController$queryPromotion$$inlined$let$lambda$1(this, r18, r20);
        Intrinsics.checkNotNullParameter(r10, "callback");
        OptCardUtil.b(null, "consumeCachedPromotion isCacheAvailable=" + r9.e);
        dm.a.b r11 = dm.a.a("LiveCardLoad");
        StringBuilder r12 = new StringBuilder("consume related card promotion, isInstant = ");
        boolean r13 = false;
        boolean r14 = true;
        if (r8 == null) goto L14;
        boolean r15 = true;
    L15:
        r12.append(r15);
        r11.i(r12.toString());
        if (r8 == null) goto L32;
        Function1<ECUIPromotion, Unit> r16 = new PromotionCardLoadOptUtils$consumeCachedPromotion$1(r10);
        Intrinsics.checkNotNullParameter(r16, "callback");
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p.a("getRelatedCardData, isApiLoading = " + r8.b);
        if (r8.b == false) goto L20;
        r8.d = r16;
    L64:
        r5 = Boolean.valueOf(r14);
        goto L66
    L20:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p.a r23 = r8.c;
        if (r23 == null) goto L64;
        ECUIPromotion r24 = r23.a;
        ECUIPromotion r25 = r23.b;
        if (r25 != null) goto L25;
        r16.invoke(null);
        goto L64
    L25:
        if (r24 == null) goto L27;
        long r26 = r24.showPriority;
    L29:
        if (r26 < r25.showPriority) goto L31;
        r16.invoke(null);
        goto L64
    L31:
        r16.invoke(r25);
        r8.b(r25);
        goto L64
    L27:
        r26 = 0;
        goto L29
    L32:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.o.getClass();
        boolean r27 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y.j;
        if (r27 == true) goto L38;
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f == true) goto L38;
    L58:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.a r28 = r9.m;
        ECContext r29 = r9.h;
        if (r29 == null) goto L63;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r30 = r29.getEcLivePerformanceMonitor();
        if (r30 == null) goto L63;
        r6 = (ECLivePerformanceMonitor) r30.getValue();
    L63:
        r28.d(r6, r9.e);
        r14 = r13;
    L38:
        if (r9.a == false) goto L41;
        r9.g = new PromotionCardLoadOptUtils$consumeCachedPromotion$2(r9, r10);
    L57:
        r13 = true;
        goto L58
    L41:
        if (r9.e == false) goto L58;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.a r31 = r9.m;
        ECContext r32 = r9.h;
        if (r32 == null) goto L47;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r33 = r32.getEcLivePerformanceMonitor();
        if (r33 == null) goto L47;
        ECLivePerformanceMonitor r34 = (ECLivePerformanceMonitor) r33.getValue();
    L48:
        r31.d(r34, true);
        r10.invoke(r9.d);
        if (r27 == false) goto L57;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.a r35 = r9.m;
        ECContext r36 = r9.h;
        if (r36 == null) goto L55;
        com.bytedance.live.datacontext.i<ECLivePerformanceMonitor> r37 = r36.getEcLivePerformanceMonitor();
        if (r37 == null) goto L55;
        ECLivePerformanceMonitor r38 = (ECLivePerformanceMonitor) r37.getValue();
    L56:
        r35.a(r38, r9.b, r9.c);
    L55:
        r38 = null;
    L47:
        r34 = null;
        goto L48
    L14:
        r15 = false;
    L66:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L68;
        return;
    L68:
        if (r17 == false) goto L72;
        ECLivePerformanceMonitor r39 = h();
        if (r39 == null) goto L72;
        r39.t(r17, this.r.A().t.U);
    L72:
        ExplainCardViewModel r40 = this.f;
        ECLivePerformanceMonitor r41 = h();
        if (r41 == null) goto L75;
        r41.u("ec_perf_duration_shopping_related_card", "request_start", Long.valueOf(SystemClock.elapsedRealtime()));
    L75:
        if (r40 == null) goto L78;
        ExplainCardViewModel.queryPopPromotion$default(r40, r19, !r17, r21, r22, null, null, new RelatedCardWidgetController$queryPromotion$2(this, r18, r17, r20), 48, null);
        return;
    }

    public RelatedCardWidgetController(Context r14, ml.b r15, LiveRoomParams r16, BottomRightCardManager.b r17, BottomRightAnimController r18, fk2.a r19, int r20, cf.c r21, Function0 r22, ef.a r23, RoomContextController r24) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r17, "rootView");
        Intrinsics.checkNotNullParameter(r18, "animController");
        Intrinsics.checkNotNullParameter(r21, "btmInfo");
        Intrinsics.checkNotNullParameter(r22, "onRealShowRelated");
        Intrinsics.checkNotNullParameter(r23, "cardManager");
        Intrinsics.checkNotNullParameter(r24, "roomContextController");
        this.l = r14;
        this.m = r15;
        this.n = r18;
        this.o = r19;
        this.p = r22;
        this.q = r23;
        this.r = r24;
        this.a = new gf.a(r20);
        this.c = LazyKt.lazy(RelatedCardWidgetController$disposableContext$2.INSTANCE);
        QUIManager r11 = new QUIManager();
        this.e = r11;
        final ExplainCardViewModel r12 = new ExplainCardViewModel(new s(this), new gf.a(0), r15, r16, r21, jf.b.h.b, r24);
        r12.setEventPassthroughParams(new RelatedCardWidgetController$$special$$inlined$also$lambda$1(this));
        r12.setCardCallback(new q(this));
        Unit r1 = Unit.INSTANCE;
        this.f = r12;
        r11.l(new rk2.g(r12), r17.getContext(), true);
        r11.c(rk2.g.class, new r(this));
        r12.getClickCloseAction().b(i(), new ActionObserver(new RelatedCardWidgetController$observeData$1(this, r12)));
        View r2 = r11.p();
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(r2.getLayoutParams());
        r3.gravity = 80;
        r2.setLayoutParams(r3);
        r17.addView(r2);
    }
}
