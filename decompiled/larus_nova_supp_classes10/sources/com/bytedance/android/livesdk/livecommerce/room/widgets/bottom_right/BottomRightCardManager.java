package com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.card.CardType;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.opt.ab.p;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.s;
import com.bytedance.android.ec.opt.messagequeue.ForceDoFrameMessage;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.eventcenter.LiveEventCenter;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.EntryController;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.BottomRightAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.ExplainCardLiveMessageListener;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.ExplainCardWidgetController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.l;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.m;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.n;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.RelatedCardMessageController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.RelatedCardWidgetController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.w;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sg2.v;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right/BottomRightCardManager;", "Lcf/d;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/bottom_right/i;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lef/a;", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomRightCardManager implements cf.d, i, LifecycleEventObserver, ef.a {
    public static final /* synthetic */ int t = 0;
    public final BottomRightAnimController a;
    public final ExplainCardWidgetController b;
    public final RelatedCardWidgetController c;
    public ef.b d;
    public final gf.a e;
    public final b f;
    public boolean g;
    public final d h;
    public boolean i;
    public boolean j;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.a k;
    public RelatedCardMessageController l;
    public com.bytedance.android.ec.core.frontier.c m;
    public final Lazy n;
    public final Context o;
    public final ml.b p;
    public final int q;
    public final RoomContextController r;
    public final /* synthetic */ ik2.a s;

    public static final class a implements Runnable {
        public final /* synthetic */ b a;
        public final /* synthetic */ BottomRightCardManager b;

        public a(b r1, BottomRightCardManager r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            Lazy r0 = ECSettingKeys.a;
            int r1 = p.a;
            Object r2 = 0;
            Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L7
            jj4.b r4 = jj4.b.b;     // Catch: Throwable -> L7
            Object r5 = jj4.a.a("ecom_live_explain_card_click_area_extend_size", Integer.class, r2, false);     // Catch: Throwable -> L7
            if (r5 != null) goto L13;
            Intrinsics.throwNpe();     // Catch: Throwable -> L7
        L13:
            int r6 = ((Number) r5).intValue();
            if (r6 <= 0) goto L45;
            BottomRightCardManager r7 = this.b;
            b r8 = this.a;
            int r9 = BottomRightCardManager.t;
            r7.getClass();
            int r10 = UtilityKotlinExtentionsKt.d(Integer.valueOf(r6));
            Rect r11 = new Rect();
            r11.left = 0;
            int r12 = 5;
            View r13 = r8;
        L16:
            Object r14 = null;
            if (r13 == null) goto L27;
            r13.getHitRect(r11);
            if (r11.left > r10) goto L27;
            Object r15 = r13.getParent();
            if ((r15 instanceof View) == true) goto L25;
            r15 = null;
        L25:
            r13 = (View) r15;
            r12 = r12 - 1;
            if (r12 > 0) goto L16;
        L27:
            if (r13 != null) goto L29;
            return;
        L29:
            if (r11.left == 0) goto L48;
            ViewParent r16 = r13.getParent();
            if ((r16 instanceof View) == false) goto L35;
            r14 = r16;
        L35:
            View r17 = (View) r14;
            if (r17 == null) goto L47;
            Rect r18 = new Rect(r11);
            r18.left -= r10;
            Unit r19 = Unit.INSTANCE;
            r17.setTouchDelegate(new g(r11, r18, r8));
            return;
        L47:
            return;
        L48:
            return;
        L45:
            return;
        L7:
            th = move-exception;
            Result.Companion r20 = Result.Companion;
            Object r21 = Result.constructor-impl(ResultKt.createFailure(th));
            if (Result.isFailure-impl(r21) == true) goto L12;
            r2 = r21;
        L12:
            r5 = r2;
            goto L13
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

    public static final class b extends FrameLayout {
        public final /* synthetic */ BottomRightCardManager a;

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.a.e.a() == false) goto L10;
            OptCardUtil.b(null, "call onAttachedToWindow of card");
            OptCardUtil.e = true;
            if (t.k == true) goto L7;
            return;
        L7:
            if (Intrinsics.areEqual(t.q, Boolean.TRUE) == false) goto L12;
            OptCardUtil.b(null, "call forceDoFrame");
            ForceDoFrameMessage.a();
            return;
        L12:
            return;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void dispatchDraw(Canvas r11) {
            Intrinsics.checkNotNullParameter(r11, "canvas");
            super.dispatchDraw(r11);
            if (this.a.e.a() == false) goto L60;
            ExplainCardWidgetController r12 = this.a.b;
            if (r12 != null) goto L7;
        L36:
            RelatedCardWidgetController r13 = this.a.c;
            if (r13 != null) goto L39;
            return;
        L39:
            if (r13.a.a() == true) goto L41;
            return;
        L41:
            if (r13.i == false) goto L46;
            r13.i = false;
            ECLivePerformanceMonitor r6 = r13.h();
            if (r6 == null) goto L46;
            r6.u("ec_perf_duration_shopping_related_card", "card_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        L46:
            if (r13.j == false) goto L52;
            r13.j = false;
            ECLivePerformanceMonitor r4 = r13.h();
            if (r4 == null) goto L50;
            r4.u("ec_perf_duration_shopping_related_card", "main_image_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
        L50:
            r13.k = new w(r13);
        L52:
            if (r13.h == false) goto L58;
            w r2 = r13.k;
            if (r2 == null) goto L58;
            r13.h = false;
            r2.run();
            r13.k = null;
            ECLivePerformanceMonitor r14 = r13.h();
            if (r14 == null) goto L58;
            ECLivePerformanceMonitor.w(r14, "ec_perf_duration_shopping_related_card", null, null, 6);
        L58:
            OptCardUtil.b(null, "call dispatchDraw of card");
            return;
        L7:
            if (r12.a.a() == false) goto L36;
            if (r12.o == false) goto L16;
            r12.o = false;
            ECLivePerformanceMonitor r7 = r12.h();
            if (r7 == null) goto L16;
            r7.u("ec_perf_duration_shopping_card", "card_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
            String r8 = r7.p;
            if (r8 == null) goto L16;
            Map r9 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.j(r8, MetricNames.POP_CARD_VISIBLE_DURATION);
        L16:
            if (r12.p == false) goto L24;
            r12.p = false;
            ECLivePerformanceMonitor r10 = r12.h();
            if (r10 == null) goto L22;
            r10.u("ec_perf_duration_shopping_card", "main_image_visible_end", Long.valueOf(SystemClock.elapsedRealtime()));
            String r15 = r10.p;
            if (r15 == null) goto L22;
            Map r16 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.j(r15, MetricNames.POP_CARD_MAIN_IMAGE_VISIBLE_DURATION);
        L22:
            r12.q = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.i(r12);
        L24:
            if (r12.n == false) goto L35;
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.i r17 = r12.q;
            if (r17 == null) goto L35;
            r12.n = false;
            r17.run();
            r12.q = null;
            if (r12.r == false) goto L35;
            ECLivePerformanceMonitor r18 = r12.h();
            if (r18 == null) goto L35;
            ECLivePerformanceMonitor.w(r18, "ec_perf_duration_shopping_card", null, null, 6);
            String r19 = r18.p;
            if (r19 == null) goto L34;
            UtilityKotlinExtentionsKt.b.post(new com.bytedance.android.livesdk.livecommerce.opt.b(r19));
        L34:
            r18.p = null;
        L35:
            OptCardUtil.b(null, "call dispatchDraw of card");
            goto L36
        }

        public b(BottomRightCardManager r1, Context r2) {
            this.a = r1;
            super(r2);
        }

        @Override // android.widget.FrameLayout, android.view.View
        public final void onMeasure(int r1, int r2) {
            super.onMeasure(r1, r2);
            if (this.a.e.a() == false) goto L8;
            boolean r3 = OptCardUtil.a;
            if (OptCardUtil.e == false) goto L9;
            OptCardUtil.e = false;
            OptCardUtil.b(null, "call onMeasure of card");
            return;
        L9:
            return;
        }
    }

    public static final class c {
    }

    public static final class d implements j {
        public final /* synthetic */ BottomRightCardManager a;

        public d(BottomRightCardManager r1) {
            this.a = r1;
        }

        public final void a(JSONObject r10) {
            Intrinsics.checkNotNullParameter(r10, "params");
            ExplainCardWidgetController r1 = this.a.b;
            if (r1 == null) goto L15;
            Intrinsics.checkNotNullParameter(r10, "params");
            ECUIPromotion r6 = (ECUIPromotion) r1.e.getPromotionState().a();
            if (r6 == null) goto L15;
            int r7 = r10.optInt("campaignType", -1);
            if (r7 != (-1)) goto L9;
        L14:
            n.a.a(r1, r6.getProductId(), null, 6);
            goto L15
        L9:
            if (r6.isCampaign == false) goto L15;
            ECUICampaign r8 = r6.campaign;
            if (r8 == null) goto L15;
            if (r7 == r8.campaignType) goto L14;
        L15:
            RelatedCardWidgetController r2 = this.a.c;
            if (r2 == null) goto L29;
            Intrinsics.checkNotNullParameter(r10, "params");
            ECUIPromotion r0 = (ECUIPromotion) r2.f.getPromotionState().a();
            if (r0 == null) goto L30;
            int r11 = r10.optInt("campaignType", -1);
            if (r11 != (-1)) goto L22;
        L27:
            com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.b.a.a(r2, r0.getProductId(), null, 6);
            return;
        L22:
            if (r0.isCampaign == false) goto L31;
            ECUICampaign r4 = r0.campaign;
            if (r4 != null) goto L26;
            return;
        L26:
            if (r11 == r4.campaignType) goto L27;
            return;
        L31:
            return;
        L30:
            return;
        }
    }

    static {
    }

    public final void c(CardType r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r2, "cardType");
        this.s.c(r2, r3);
    }

    public final void l(ef.d r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.s.l(r2);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void b() {
        dm.a.a("BottomRightCardManager").i("Receive bridge event, cancel external card.");
        ef.b r0 = this.d;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void d() {
        boolean r0 = t.f;
        t.a.a(this.o);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final fk2.a g() {
        return (fk2.a) this.n.getValue();
    }

    public final View getView() {
        if (this.i == false) goto L18;
        this.i = false;
        Activity r0 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.o);
        if ((r0 instanceof LifecycleOwner) == true) goto L7;
        r0 = null;
    L7:
        ECQuickUtilKt.DEFAULT_LIFECYCLE_OWNER.1 r1 = (LifecycleOwner) r0;
        if (r1 != null) goto L10;
        r1 = ECQuickUtilKt.b;
    L10:
        r1.getLifecycle().addObserver(this);
        s();
        ExplainCardWidgetController r2 = this.b;
        if (r2 == null) goto L18;
        if (r2.j == false) goto L18;
        if (r2.a.a() == true) goto L18;
        n.a.b(r2);
    L18:
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final ExplainCardViewModel j() {
        ExplainCardWidgetController r0 = this.b;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final Context n() {
        return this.f.getContext();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void r() {
        ExplainCardWidgetController r0 = this.b;
        if (r0 == null) goto L6;
        r0.l(null, null, null);
        return;
    }

    public final void s() {
        if (this.j == false) goto L6;
        return;
    L6:
        if (this.e.a != 1) goto L8;
        boolean r0 = true;
    L9:
        String r2 = null;
        if (r0 == false) goto L17;
        this.k = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.a(new WeakReference(this.f.getContext()), this);
        ml.b r3 = this.p;
        if (r3 == null) goto L14;
        String r4 = r3.roomId();
    L15:
        com.bytedance.android.ec.core.frontier.c r1 = new com.bytedance.android.ec.core.frontier.c("StoreLiveRoom", r4);
        this.m = r1;
        UtilityKotlinExtentionsKt.f(this.k, r1, BottomRightCardManager$registerMessage$1.INSTANCE);
        goto L17
    L14:
        r4 = null;
    L17:
        if (this.e.a() == true) goto L19;
    L39:
        this.j = true;
        return;
    L19:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L22;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r5 = this.r.A().q;
    L29:
        Context r6 = this.o;
        ml.b r7 = this.p;
        if (r7 == null) goto L32;
        String r8 = r7.roomId();
    L33:
        r5.f = new ExplainCardLiveMessageListener(r6, this, r8, r5);
        RelatedCardWidgetController r9 = this.c;
        if (r9 == null) goto L39;
        this.l = new RelatedCardMessageController(r9);
        RoomContextController r10 = this.r;
        ml.b r11 = this.p;
        if (r11 == null) goto L38;
        r2 = r11.roomId();
    L38:
        ControllerExtensionsKt.c(r10, r2).A().q.e = this.l;
        goto L39
    L32:
        r8 = null;
        goto L33
    L22:
        if (this.r.v() == false) goto L24;
        r5 = this.r.A().q;
        goto L29
    L24:
        int r12 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.o;
        ml.b r13 = this.p;
        if (r13 == null) goto L27;
        String r14 = r13.roomId();
    L28:
        r5 = com.bytedance.android.livesdk.livecommerce.room.controller.business.n.a.a(r14, this.r.D());
        goto L29
    L27:
        r14 = null;
        goto L28
    L8:
        r0 = false;
        goto L9
    }

    public final void t() {
        RelatedCardWidgetController r0 = this.c;
        if (r0 == null) goto L6;
        r0.g(null, null, false, null, null);
        return;
    }

    public final void u() {
        if (this.j == true) goto L5;
        return;
    L5:
        UtilityKotlinExtentionsKt.f(this.k, this.m, new BottomRightCardManager$unRegisterMessage$1(this));
        if (this.e.a() == false) goto L15;
        this.l = null;
        if (this.r.v() == false) goto L10;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r1 = this.r.A().q;
        r1.f = null;
        r1.e = null;
        r1.j = null;
        goto L15
    L10:
        RoomContextController r2 = this.r;
        ml.b r3 = this.p;
        if (r3 == null) goto L13;
        String r4 = r3.roomId();
    L14:
        com.bytedance.android.livesdk.livecommerce.room.controller.business.n r5 = ControllerExtensionsKt.c(r2, r4).A().q;
        r5.f = null;
        r5.e = null;
        r5.j = null;
        goto L15
    L13:
        r4 = null;
    L15:
        this.j = false;
    }

    public final void onDestroy() {
        u();
        ECLiveHybridUtil.p("closeExplainCard", this.h);
        Activity r0 = com.bytedance.android.ec.sdk.plugin.e.getActivity(this.o);
        if ((r0 instanceof LifecycleOwner) == true) goto L5;
        r0 = null;
    L5:
        ECQuickUtilKt.DEFAULT_LIFECYCLE_OWNER.1 r1 = (LifecycleOwner) r0;
        if (r1 != null) goto L8;
        r1 = ECQuickUtilKt.b;
    L8:
        r1.getLifecycle().removeObserver(this);
        ExplainCardWidgetController r2 = this.b;
        if (r2 == null) goto L17;
        r2.m = true;
        ((bk2.d) r2.g.getValue()).clearDisposable();
        Disposable r3 = r2.f;
        if (r3 == null) goto L13;
        r3.dispose();
    L13:
        r2.f = null;
        Runnable r4 = r2.h;
        if (r4 == null) goto L16;
        UtilityKotlinExtentionsKt.b.removeCallbacks(r4);
    L16:
        r2.h = null;
        r2.d.r(rk2.g.class);
        r2.e.onDestroy();
        Lazy r5 = LiveEventCenter.b;
        LiveEventCenter.a.a().a(r2.i);
    L17:
        RelatedCardWidgetController r6 = this.c;
        if (r6 == null) goto L23;
        ((bk2.d) r6.c.getValue()).clearDisposable();
        Disposable r7 = r6.g;
        if (r7 == null) goto L22;
        r7.dispose();
    L22:
        r6.g = null;
        r6.e.r(rk2.g.class);
        r6.f.onDestroy();
    L23:
        ef.b r8 = this.d;
        if (r8 == null) goto L26;
        r8.a(false);
    L26:
        BottomRightAnimController r9 = this.a;
        r9.h.set(true);
        Iterator<T> r10 = r9.g.iterator();
    L28:
        if (r10.hasNext() == false) goto L30;
        ((Handler) r9.e.getValue()).removeCallbacksAndMessages((Message) r10.next());
        goto L28
    L30:
        Iterator<T> r11 = r9.f.iterator();
    L32:
        if (r11.hasNext() == false) goto L34;
        r9.d.removeCallbacksAndMessages((Message) r11.next());
        goto L32
    L34:
        this.s.b();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final RoomContextController i() {
        return this.r;
    }

    public final void a(com.bytedance.android.livesdk.livecommerce.saascoupon.e r9) {
        Intrinsics.checkNotNullParameter(r9, "cardControllerProvider");
        if (this.d == null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.livecommerce.saascoupon.lynxcoupon.a r10 = r9.a(this.o, this.q, l0.l(), this.a, new com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.b(this), this);
        r10.c();
        Unit r0 = Unit.INSTANCE;
        this.d = r10;
    }

    public final void e(Map<String, ? extends Map<String, String>> r4) {
        ExplainCardWidgetController r0 = this.b;
        RelatedCardWidgetController r2 = null;
        if ((r0 instanceof ExplainCardWidgetController) == true) goto L5;
        r0 = null;
    L5:
        if (r0 == null) goto L7;
        r0.s = r4;
    L7:
        RelatedCardWidgetController r1 = this.c;
        if ((r1 instanceof RelatedCardWidgetController) == false) goto L11;
        r2 = r1;
    L11:
        if (r2 == null) goto L14;
        r2.d = r4;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void f(ECUIPromotion r4) {
        Intrinsics.checkNotNullParameter(r4, "uiPromotion");
        ExplainCardWidgetController r1 = this.b;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNullParameter(r4, "uiPromotion");
        ECUIPromotion r0 = (ECUIPromotion) r1.e.getPromotionState().a();
        if (r0 == null) goto L7;
        String r2 = r0.getPromotionId();
    L9:
        if (Intrinsics.areEqual(r2, r4.getPromotionId()) == false) goto L13;
        r1.e.getPromotionState().e(r4);
        return;
    L13:
        return;
    L7:
        r2 = null;
        goto L9
    }

    public final void m(com.bytedance.android.shopping.store.home.presenter.preview.b r2) {
        ExplainCardWidgetController r0 = this.b;
        if (r0 == null) goto L5;
        r0.k = r2;
        r0.e.setOpenSchemaProxy(r2);
    L5:
        RelatedCardWidgetController r1 = this.c;
        if (r1 == null) goto L9;
        r1.f.setOpenSchemaProxy(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void h(String r6, long r7) {
        ExplainCardWidgetController r0 = this.b;
        if (r0 == null) goto L15;
        if (r6 == null) goto L18;
        ECUIPromotion r1 = (ECUIPromotion) r0.e.getPromotionState().a();
        if (r1 != null) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r1.getPromotionId(), r6) == true) goto L12;
        r1 = null;
    L12:
        if (r1 == null) goto L17;
        dm.a.a("BottomRightCardManager").i("reset card(" + r6 + ") show time for " + r7 + " ms");
        r0.m(r1, r7 / 1000);
        return;
    L17:
        return;
    L18:
        return;
    }

    public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "event");
        int r5 = com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.a.a[r4.ordinal()];
        boolean r6 = false;
        boolean r0 = true;
        if (r5 == 1) goto L13;
        if (r5 == 2) goto L8;
        return;
    L8:
        if (this.e.a != 1) goto L10;
        r6 = true;
    L10:
        if (r6 == false) goto L24;
        u();
        this.g = true;
        return;
    L24:
        return;
    L13:
        if (this.e.a == 1) goto L16;
        r0 = false;
    L16:
        if (r0 == false) goto L26;
        s();
        if (this.g == false) goto L27;
        ExplainCardWidgetController r7 = this.b;
        if (r7 == null) goto L22;
        n.a.b(r7);
    L22:
        this.g = false;
        return;
    L27:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void q(String r2, long r3) {
        ExplainCardWidgetController r0 = this.b;
        if (r0 == null) goto L6;
        r0.g(r2, r3);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void k(String r1, String r2, boolean r3) {
        ExplainCardWidgetController r4 = this.b;
        if (r4 == null) goto L6;
        r4.a(r1, r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void o(ECUIPromotion r12, boolean r13, String r14, Function1<? super ECUIPromotion, Unit> r15) {
        Intrinsics.checkNotNullParameter(r12, "uiPromotion");
        ExplainCardWidgetController r7 = this.b;
        if (r7 == null) goto L6;
        Intrinsics.checkNotNullParameter(r12, "uiPromotion");
        r7.y.l(new ef.d(10, CardType.EXPLAIN_CARD, new l(r7, r12, r13, r14, r15), new m(r7)));
        return;
    }

    public BottomRightCardManager(Context r23, ml.b r24, LiveRoomParams r25, cf.i r26, int r27, cf.c r28, RoomContextController r29) {
        Intrinsics.checkNotNullParameter(r23, "context");
        Intrinsics.checkNotNullParameter(r26, "getExplainPromotion");
        Intrinsics.checkNotNullParameter(r28, "btmInfo");
        Intrinsics.checkNotNullParameter(r29, "roomContextController");
        this.s = new ik2.a();
        this.o = r23;
        this.p = r24;
        this.q = r27;
        this.r = r29;
        BottomRightAnimController r9 = new BottomRightAnimController(r29);
        this.a = r9;
        gf.a r8 = new gf.a(r27);
        this.e = r8;
        d r7 = new d(this);
        this.h = r7;
        this.i = true;
        Lazy r5 = LazyKt.lazy(new BottomRightCardManager$cardMonitor$2(this));
        this.n = r5;
        b r3 = new b(this, r23);
        r3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r3.post(new a(r3, this));
        Unit r0 = Unit.INSTANCE;
        this.f = r3;
        d r14 = r7;
        ExplainCardWidgetController r2 = new ExplainCardWidgetController(r23, r24, r25, r26, r3, r9, r27, r28, this, (fk2.a) r5.getValue(), r29);
        this.b = r2;
        if (r8.a() == true) goto L5;
        r14 = r14;
    L22:
        ECLiveHybridUtil.m("closeExplainCard", r14);
        return;
    L5:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONTROLLER_OPT() == false) goto L8;
        EntryController r1 = r29.A().t;
    L11:
        String r4 = r1.M().f(IRelatedInfoManager$Scene.CARRY_ON_CARD);
        if (r29.A().t.V == null) goto L14;
        boolean r6 = true;
    L15:
        if (r4 != null) goto L19;
        if (r6 == true) goto L19;
    L20:
        s();
        r2.b = ControllerExtensionsKt.c(r29, r24.roomId()).A().t.T;
        ControllerExtensionsKt.c(r29, r24.roomId()).A().q.h = this;
    L19:
        this.c = new RelatedCardWidgetController(r23, r24, r25, r3, r9, (fk2.a) r5.getValue(), r27, r28, new AnonymousClass3(this), this, r29);
        goto L20
    L14:
        r6 = false;
        goto L15
    L8:
        if (r29.v() == false) goto L10;
        r1 = r29.A().t;
        goto L11
    L10:
        boolean r10 = EntryController.M1;
        r1 = EntryController.a.b(r24.roomId(), r29.D());
        goto L11
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i
    public final void p(String r12, Function1<? super ECUIPromotion, Unit> r13, boolean r14, Pair<Long, Long> r15, s r16, String r17, Map<String, String> r18) {
        fk2.a r1 = (fk2.a) this.n.getValue();
        if (r1 != null) goto L5;
    L13:
        ExplainCardWidgetController r3 = this.b;
        if (r3 == null) goto L17;
        r3.f(r12, r13, r14, r15, r16, r17, r18);
        return;
    L17:
        return;
    L5:
        if (this.e.a() == false) goto L13;
        if (r14 == true) goto L9;
        String r2 = "enter_room";
    L10:
        v r4 = new v("livesdk_popup_card_request_show", r1.d);
        r4.c("from_scene", r2);
        Unit r5 = Unit.INSTANCE;
        if (r1.c == false) goto L13;
        r4.i(null);
        goto L13
    L9:
        r2 = "message";
        goto L10
    }
}
