package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.apt.IECAPTService;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.MetricNames;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncCacheInflater;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.android.ec.core.utils.ECLiveEntranceMonitor;
import com.bytedance.android.ec.core.utils.Json;
import com.bytedance.android.ec.core.utils.OptCardUtil;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.LoggerConsumer;
import com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.SlardarConsumer;
import com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.TrackerConsumer;
import com.bytedance.android.livesdk.livecommerce.dynamiccontext.LiveDynamicContext;
import com.bytedance.android.livesdk.livecommerce.event.b1;
import com.bytedance.android.livesdk.livecommerce.event.i0;
import com.bytedance.android.livesdk.livecommerce.event.j1;
import com.bytedance.android.livesdk.livecommerce.event.k1;
import com.bytedance.android.livesdk.livecommerce.event.l0;
import com.bytedance.android.livesdk.livecommerce.event.l1;
import com.bytedance.android.livesdk.livecommerce.event.n1;
import com.bytedance.android.livesdk.livecommerce.event.o1;
import com.bytedance.android.livesdk.livecommerce.event.refactor.EntranceShowStatusByRoomState;
import com.bytedance.android.livesdk.livecommerce.event.refactor.ReportWhenEnter;
import com.bytedance.android.livesdk.livecommerce.event.refactor.RequestLivePromotions;
import com.bytedance.android.livesdk.livecommerce.event.u1;
import com.bytedance.android.livesdk.livecommerce.event.v1;
import com.bytedance.android.livesdk.livecommerce.intro.model.req.IntroCardScene;
import com.bytedance.android.livesdk.livecommerce.intro.utils.IntroCardLoadOpt;
import com.bytedance.android.livesdk.livecommerce.iron.helper.ECLiveLoginHelper;
import com.bytedance.android.livesdk.livecommerce.iron.navigate.IronNavigator;
import com.bytedance.android.livesdk.livecommerce.network.response.ECEnterRequestData;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.opt.ECLivePerformanceMonitor;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.LiveActionTracker;
import com.bytedance.android.livesdk.livecommerce.room.api.ControllerExtensionsKt;
import com.bytedance.android.livesdk.livecommerce.room.controller.ControllerCenter;
import com.bytedance.android.livesdk.livecommerce.room.controller.CoreRequests;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$FromSource;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.IRelatedInfoManager$Scene;
import com.bytedance.android.livesdk.livecommerce.room.controller.related.RelatedInfoManager;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponEventRegisterHelper;
import com.bytedance.android.livesdk.livecommerce.room.coupon.CouponGrowProvider;
import com.bytedance.android.livesdk.livecommerce.room.quick.LiveRoomLifecycleOwner;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectInfo;
import com.bytedance.android.livesdk.livecommerce.room.utils.LiveRoomRedirectPriority;
import com.bytedance.android.livesdk.livecommerce.room.utils.json.JSONDslUtilKt;
import com.bytedance.android.livesdk.livecommerce.room.widgets.anim.CartCardLinkedAnimController;
import com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.BottomRightWidgetV2;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.related.PromotionCardLoadOptUtils;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.y;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ECToolbarHandler;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.ShoppingCart;
import com.bytedance.android.livesdk.livecommerce.room.widgets.shortcut.ShortCutWidget;
import com.bytedance.android.livesdk.livecommerce.router.ECLiveSchemaBuilder;
import com.bytedance.android.livesdk.livecommerce.utils.ECCartMonitor;
import com.bytedance.android.livesdk.livecommerce.utils.ECEnterRoomJumpLogUtils;
import com.bytedance.android.livesdk.livecommerce.utils.ECPreloadGeckoChannelUtil;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.android.livesdk.livecommerce.utils.LogRule;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.h0;
import com.bytedance.android.livesdk.livecommerce.utils.m0;
import com.bytedance.android.livesdk.livecommerce.utils.z0;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarComponentCheckInterface;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
import vi2.v0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class EntryController extends c0 implements zk.a, sg2.u {
    public static final boolean M1 = false;
    public static final boolean P1 = false;
    public final IntroCardLoadOpt A;
    public boolean B;
    public boolean C;
    public boolean D;
    public View E;
    public ak2.m F;
    public boolean G;
    public final com.bytedance.android.livesdk.livecommerce.room.controller.business.i G1;
    public boolean H;
    public boolean H0;
    public boolean H1;
    public long I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean L0;
    public final Handler L1;
    public com.bytedance.android.livesdk.livecommerce.room.utils.g M;
    public String N;
    public String O;
    public int P;
    public boolean P0;
    public String Q;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f R;
    public i S;
    public final com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t T;
    public int U;
    public com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p V;
    public boolean V0;
    public ek2.b W;
    public Disposable X;
    public final Lazy Y;
    public final Lazy Z;
    public boolean b1;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean g1;
    public boolean h;
    public boolean h1;
    public boolean i;
    public String j;
    public boolean k;
    public boolean k0;
    public boolean k1;
    public long l;
    public boolean m;
    public Integer n;
    public boolean o;
    public boolean p;
    public boolean p0;
    public final CompositeDisposable p1;
    public boolean q;
    public hk2.a r;
    public ShoppingCart s;
    public ShortCutWidget t;
    public xk2.a u;
    public BottomRightWidgetV2 v;
    public Boolean v1;
    public boolean w;
    public qh2.d x;
    public final Lazy x1;
    public boolean y;
    public final Lazy y1;
    public boolean z;

    public static final class a {
        @JvmStatic
        public static EntryController a() {
            EntryController r0 = ControllerCenter.c(null, null).t;
            Objects.toString(r0);
            return r0;
        }

        @JvmStatic
        public static EntryController b(String r0, String r1) {
            EntryController r2 = ControllerCenter.c(r0, r1).t;
            Objects.toString(r2);
            return r2;
        }
    }

    public static final class b implements v0<xi2.s> {
        public final /* synthetic */ EntryController a;

        @Override // vi2.v0
        public final void onError(Throwable r1) {
        }

        public b(EntryController r1) {
            this.a = r1;
        }

        @Override // vi2.v0
        public final void onSuccess(xi2.s r4) {
            xi2.s r5 = r4;
            if (r5 == null) goto L15;
            ECEnterRequestData r6 = r5.a();
            if (r6 == null) goto L16;
            String r7 = r6.getToast();
            if (r7 != null) goto L9;
            return;
        L9:
            if (cg4.a.a(r7) == true) goto L12;
            r7 = null;
        L12:
            if (r7 == null) goto L18;
            com.bytedance.android.ec.sdk.helper.i.a.e(this.a.m(), r7, false, false);
            return;
        L18:
            return;
        L16:
            return;
        }
    }

    public static final class c implements ml.b {
        public final /* synthetic */ JSONObject a;

        public final String c() {
            return this.a.optString("author_id");
        }

        public final String d() {
            return this.a.optString("sec_author_id");
        }

        public final String roomId() {
            return this.a.optString("room_id");
        }

        public c(JSONObject r1) {
            this.a = r1;
        }
    }

    public static final class d implements zk.b {
        public d() {
        }

        public final String entryName() {
            return "live_pop_card_buy_to_add";
        }

        public final String getCouponId() {
            return null;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Map a;

        public e(Map r1) {
            this.a = r1;
        }

        public final void a() {
            b1 r0 = new b1();
            Map r1 = this.a;
            Intrinsics.checkNotNullParameter(r1, "params");
            Iterator r2 = r1.entrySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            Map.Entry r3 = (Map.Entry) r2.next();
            r0.f((String) r3.getKey(), (String) r3.getValue());
            goto L4
        L6:
            r0.k();
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
        public final /* synthetic */ EntryController a;

        public f(EntryController r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.W();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements View.OnLongClickListener {
        public final /* synthetic */ cl.d a;

        public g(cl.d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r1) {
            this.a.p();
            return true;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ EntryController a;

        public h(EntryController r1) {
            this.a = r1;
        }

        public final void a() {
            ECLivePerformanceMonitor r0 = (ECLivePerformanceMonitor) this.a.o().getEcLivePerformanceMonitor().getValue();
            r0.getClass();
            r0.u("ec_perf_duration_live_shopping_bag", "render_end", Long.valueOf(SystemClock.elapsedRealtime()));
            String r1 = r0.o;
            if (r1 == null) goto L5;
            Map r2 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.j(r1, MetricNames.RENDER_DURATION);
            com.bytedance.android.ec.core.monitor.c.j(r1, MetricNames.DURATION);
        L5:
            EntryController r3 = this.a;
            if (r3.B == true) goto L12;
            r3.B = true;
            ECLivePerformanceMonitor r4 = (ECLivePerformanceMonitor) r3.o().getEcLivePerformanceMonitor().getValue();
            r4.getClass();
            ECLivePerformanceMonitor.w(r4, "ec_perf_duration_live_shopping_bag", null, null, 6);
            String r5 = r4.o;
            if (r5 == null) goto L10;
            Map r6 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.d(r5);
        L10:
            r4.o = null;
            PromotionListController r7 = this.a.A().r;
            r7.h = SystemClock.elapsedRealtime();
            fk2.b r8 = (fk2.b) this.a.o().getEcLiveRoomDurationMonitor().getValue();
            r8.getClass();
            r8.a = SystemClock.elapsedRealtime();
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

    public static final class i implements Runnable {
        public final /* synthetic */ EntryController a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public i(EntryController r1, boolean r2, boolean r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L3:
            if (this.b == true) goto L5;
            this.a.b0(true, !this.c);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            this.a.b0(false, true ^ this.c);     // Catch: Throwable -> L7
            goto L12
        }
    }

    public static final class j extends ak2.e {
        public final /* synthetic */ EntryController a;

        public final View getButtonViewInMore() {
            ImageView r0 = new ImageView(this.a.m());
            r0.setImageResource(2131234236);
            return r0;
        }

        public j(EntryController r1) {
            this.a = r1;
        }
    }

    public static final class k implements vd.a, ToolbarComponentCheckInterface {
        public final /* synthetic */ EntryController a;
        public final /* synthetic */ int b;

        public static final class a implements Runnable {
            public final /* synthetic */ k a;
            public final /* synthetic */ ToolbarMatchInterface b;
            public final /* synthetic */ Function0 c;
            public final /* synthetic */ Function1 d;

            public a(k r1, ToolbarMatchInterface r2, Function0 r3, Function1 r4) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.b(this.b, this.c, this.d);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public k(EntryController r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a(te.a r4, Function0 r5, Function1 r6) {
            Intrinsics.checkNotNullParameter(r4, "model");
            Intrinsics.checkNotNullParameter(r5, "loadButton");
            Intrinsics.checkNotNullParameter(r6, "stopLoadCallback");
            if (this.b > 0) goto L7;
            b(r4, r5, r6);
            return;
        L7:
            if (this.a.w() == false) goto L9;
            this.a.L1.postDelayed(new m(this, r4, r5, r6), this.b);
            return;
        L9:
            ECLiveEntranceMonitor.trace$default("checkThenLoad roomState not attached", "EntryController", false, 4, null);
            r6.invoke("roomState is not attached");
        }

        public final void b(Object r8, Function0 r9, Function1 r10) {
            if (this.b <= 0) goto L9;
            if (this.a.u() == true) goto L9;
            ECLiveEntranceMonitor.trace$default("checkThenLoad context not attached", "EntryController", false, 4, null);
            r10.invoke("context is not attached");
            return;
        L9:
            if (this.a.w() == true) goto L12;
            ECLiveEntranceMonitor.trace$default("checkThenLoad roomState not attached", "EntryController", false, 4, null);
            r10.invoke("roomState is not attached");
            return;
        L12:
            ECLivePerformanceMonitor r0 = (ECLivePerformanceMonitor) this.a.o().getEcLivePerformanceMonitor().getValue();
            r0.j();
            String r1 = r0.s;
            if (r1 == null) goto L35;
            Map r5 = com.bytedance.android.ec.core.monitor.c.a;
            com.bytedance.android.ec.core.monitor.c.j(r1, MetricNames.ENTER_ROOM_DURATION);
        L35:
            Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L17
            com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a r3 = com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e;     // Catch: Throwable -> L17
            Bundle r6 = this.a.C().n;     // Catch: Throwable -> L17
            r3.getClass();     // Catch: Throwable -> L17
            com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.f(com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.c(r6), this.a.A().m);     // Catch: Throwable -> L17
            Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L19:
            com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a r4 = com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e;
            com.bytedance.android.ec.adapter.api.state.a r7 = this.a.C();
            r4.getClass();
            boolean r11 = com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.a(r7);
            ECLiveEntranceMonitor.trace$default("checkThenLoad canShowCart=" + r11, "EntryController", false, 4, null);
            if (r11 == false) goto L33;
            EntryController r12 = this.a;
            ShoppingCart r13 = r12.s;
            if (r13 != null) goto L24;
            r13 = r12.I();
        L24:
            if (r13 == null) goto L32;
            this.a.s = r13;
            if ((r8 instanceof vd.b) == false) goto L29;
            ((vd.b) r8).a(r13);
        L31:
            r9.invoke();
            return;
        L29:
            if ((r8 instanceof ToolbarMatchInterface) == false) goto L31;
            ((ToolbarMatchInterface) r8).setExtraDataAfterCheck(r13);
            goto L31
        L32:
            r10.invoke("cart is null");
            return;
        L33:
            r10.invoke("canShowCart=false");
            return;
        L17:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L19
        }

        public final boolean checkThenLoad(ToolbarMatchInterface r5, Function0<Unit> r6, Function1<? super String, Unit> r7) {
            Intrinsics.checkNotNullParameter(r5, "model");
            Intrinsics.checkNotNullParameter(r6, "loadButton");
            Intrinsics.checkNotNullParameter(r7, "stopLoadCallback");
            if (this.b > 0) goto L7;
            b(r5, r6, r7);
            return true;
        L7:
            if (this.a.w() == false) goto L9;
            this.a.L1.postDelayed(new a(this, r5, r6, r7), this.b);
        L10:
            return true;
        L9:
            ECLiveEntranceMonitor.trace$default("checkThenLoad roomState not attached", "EntryController", false, 4, null);
            r7.invoke("roomState is not attached");
            goto L10
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void F() {
        this.D = false;
        this.K = false;
    }

    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.c K() {
        return (com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.c) this.Z.getValue();
    }

    public final com.bytedance.android.livesdk.livecommerce.largemode.b L() {
        return (com.bytedance.android.livesdk.livecommerce.largemode.b) this.Y.getValue();
    }

    public final RelatedInfoManager M() {
        return (RelatedInfoManager) this.x1.getValue();
    }

    @Override // sg2.u
    public final void b() {
        this.K = true;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onActivityCreated() {
        this.g = true;
        if (u() == false) goto L8;
        int r0 = th.a.f(m()).getConfiguration().orientation;
        Integer r1 = this.n;
        if (r1 == null) goto L7;
        r1.intValue();
    L7:
        this.n = Integer.valueOf(r0);
    L10:
        if (v() == true) goto L12;
        boolean r2 = ECCartMonitor.a;
        ECCartMonitor.e(B(), D());
    L12:
        h0("onActivityCreated");
        return;
    L8:
        ECExceptionMonitor.c("invalid controller lifecycle: context not attached on onActivityCreated");
        goto L10
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onCreate() {
        this.h = true;
        com.bytedance.android.livesdk.livecommerce.utils.p.a = false;
        com.bytedance.android.livesdk.livecommerce.utils.p.b = true;
        UtilityKotlinExtentionsKt.b.removeCallbacks(com.bytedance.android.livesdk.livecommerce.utils.p.e);
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t r0 = this.T;
        if (r0 == null) goto L5;
        r0.a = null;
        r0.b = false;
        r0.c = false;
        r0.d = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.p = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.q = null;
    L5:
        IntroCardLoadOpt r1 = this.A;
        if (r1 == null) goto L9;
        r1.a = null;
        r1.b = false;
        r1.c = false;
        r1.d = null;
        IntroCardLoadOpt.n = IntroCardLoadOpt.f;
        IntroCardLoadOpt.o = null;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onEnterRoomPrepared() {
        this.i = true;
        if (P1 == false) goto L5;
    L24:
        l();
        return;
    L5:
        if (T() == false) goto L10;
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == true) goto L10;
        R();
    L10:
        if (hh2.f.a() == true) goto L12;
    L23:
        h0("onEnterRoomPrepared");
        goto L24
    L12:
        if (s() == true) goto L23;
        if (T() == false) goto L23;
        if (V() == false) goto L23;
        if (u() == false) goto L23;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t r1 = this.T;
        if (r1 == null) goto L22;
        r1.b(o(), new com.bytedance.android.livesdk.livecommerce.room.model.g(o(), A().m), m(), this.V, M().f(IRelatedInfoManager$Scene.CARRY_ON_CARD));
    L22:
        PromotionCardLoadOptUtils.Companion r2 = PromotionCardLoadOptUtils.p;
        String r3 = B();
        r2.getClass();
        PromotionCardLoadOptUtils.Companion.c(r3).a(o(), new com.bytedance.android.livesdk.livecommerce.room.model.g(o(), A().m), M().f(IRelatedInfoManager$Scene.CARRY_ON_CARD), m(), this.V);
        goto L23
    }

    static {
        M1 = EComABUtils.enableOptCouponLoad();
        P1 = EComABUtils.enableEnterRoomInitAdjust();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void G() {
        if (this.H == true) goto L5;
    L10:
        this.H = false;
        this.G = false;
        this.I = 0;
        this.J = false;
        ((fk2.b) o().getEcLiveRoomDurationMonitor().getValue()).d();
        return;
    L5:
        if (this.I <= 0) goto L10;
        String r4 = y();
        String r5 = B();
        if (s() == false) goto L9;
        new k1(r4, r5).k();
        long r6 = this.I;
        Handler r3 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        new l1(r4, r5, SystemClock.elapsedRealtime() - r6).k();
        goto L10
    L9:
        String r7 = l0.f();
        long r8 = this.I;
        Handler r9 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        new o1(r4, r5, r7, SystemClock.elapsedRealtime() - r8).k();
        goto L10
    }

    public final boolean H() {
        this.c++;
        if (ECLiveABUtils.INSTANCE.getEnableLiveFixFunctionHandlerAttached() == false) goto L5;
        boolean r0 = this.f;
    L6:
        boolean r2 = this.d;
        if (r2 == true) goto L9;
    L15:
        Map r1 = MapsKt.mapOf(new Pair[]{TuplesKt.to("contextAttached", String.valueOf(r2)), TuplesKt.to("viewHandler", String.valueOf(this.e)), TuplesKt.to("activityCreated", String.valueOf(this.g)), TuplesKt.to("dataContextAvailable", String.valueOf(this.h)), TuplesKt.to("checkRoomStatusTimes", String.valueOf(this.c)), TuplesKt.to("functionHandlerAttached", String.valueOf(this.f))});
        ECLiveEntranceMonitor.trace$default("checkRoomStatus roomId: " + B() + " checkRoomStatusTimes: " + this.c + " contextAttached: " + this.d + " viewHandlerAttached: " + this.e + " activityCreated: " + this.g + " dataContextAvailable: " + this.h + " functionHandlerAttached: " + this.f, "EntryController", false, 4, null);
        new v1(r1, B()).k();
        return false;
    L9:
        if (this.e == false) goto L15;
        if (this.g == false) goto L15;
        if (this.h == false) goto L15;
        if (r0 == false) goto L15;
        return true;
    L5:
        r0 = true;
        goto L6
    }

    public final void Q() {
        if (H() == true) goto L6;
        return;
    L6:
        if (this.p == false) goto L8;
        return;
    L8:
        this.p = true;
        boolean r4 = false;
        ECLiveEntranceMonitor.trace$default("initCommerceWidget roomId: " + B(), "EntryController", false, 4, null);
        if (this.k == false) goto L12;
        this.J = false;
    L12:
        if (this.j != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        this.k = r2;
        if (r2 == false) goto L21;
        Handler r3 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        this.l = SystemClock.elapsedRealtime();
    L21:
        this.j = B();
        com.bytedance.android.livesdk.livecommerce.view.countdown.d r5 = com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a;
        r5.a();
        ((CopyOnWriteArrayList) r5.a).clear();
        com.bytedance.android.livesdk.livecommerce.view.countdown.c r7 = new com.bytedance.android.livesdk.livecommerce.view.countdown.c(r5);
        r5.b = r7;
        monitor-enter(r7);
        r7.a = false;     // Catch: Throwable -> L123
        r7.b = true;     // Catch: Throwable -> L123
        com.bytedance.android.livesdk.livecommerce.view.countdown.e r6 = r7.c;     // Catch: Throwable -> L123
        r6.sendMessage(r6.obtainMessage(1));     // Catch: Throwable -> L123
        monitor-exit(r7);
        ((HashMap) com.bytedance.android.livesdk.livecommerce.opt.f.b).clear();
        com.bytedance.android.livesdk.livecommerce.opt.f.c = false;
        int r8 = ECSdk.a;
        ECSdk.b(IAdapterService.class, EntryController$initCommerceWidget$1.INSTANCE);
        this.F = new ak2.m(q().getLogger(be.b.class));
        SystemClock.uptimeMillis();
        this.r = new hk2.a(m());
        com.bytedance.android.livesdk.livecommerce.room.api.e r9 = E();
        hk2.a r10 = this.r;
        if (r10 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rankEntry");
    L28:
        r9.L(r10, xd.e.a);
        boolean r11 = ECCartMonitor.a;
        com.bytedance.android.ec.adapter.api.state.a r12 = C();
        boolean r13 = U();
        Intrinsics.checkNotNullParameter(r12, "roomState");
        boolean r14 = r12.n.getBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE");
        String r15 = r12.n.getString("EXTRA_ROOM_ENTER_LOG_ID", "");
        boolean r16 = r12.n.getBoolean("EXTRA_BOOL_ROOM_HAS_CART_INFO");
        if (r12.n.getInt("EXTRA_INT_SHOW_CART") != 1) goto L31;
        boolean r17 = true;
    L32:
        ECCartMonitor.a(new h0(r15, r13, r14, r16, r17, r12.n.getBoolean("EXTRA_BOOL_IS_TOOLBAR_EQUAL_CART")));
        ECCartMonitor.g = true;
        ECLiveEntranceMonitor.trace$default("loadToolbar isOptSlot=" + U() + " roomId=" + B() + " isCommerce=" + T(), "EntryController", false, 4, null);
        if (U() == false) goto L45;
        boolean r18 = this.m;
        if (r18 == true) goto L37;
    L39:
        boolean r19 = false;
    L40:
        this.L = r19;
        if (T() == false) goto L43;
        if (r18 == false) goto L43;
    L44:
        y();
        z();
        B();
    L110:
        i r0 = this.S;
        if (r0 == null) goto L113;
        r0.run();
    L113:
        this.S = null;
        if (s() == false) goto L128;
        boolean r1 = LynxAnchorPromotionListUtils.a;
        m();
        String r20 = B();
        String r21 = y();
        Intrinsics.checkNotNullParameter(r20, "roomId");
        Intrinsics.checkNotNullParameter(r21, "anchorId");
        if (LynxAnchorPromotionListUtils.a == false) goto L118;
        r.a("isRegistered is true ,so return");
        return;
    L118:
        LynxAnchorPromotionListUtils.a = true;
        r.a("registerLynxAnchorPromotionListEvent success");
        ECLiveHybridUtil.m("ecom.anchor.pickedViewClose", (ti.j) LynxAnchorPromotionListUtils.b.getValue());
        LynxAnchorPromotionListUtils.a r22 = LynxAnchorPromotionListUtils.c;
        if (r22 == null) goto L121;
        ECLiveHybridUtil.p("ecom.anchor.open_coupon_panel", r22);
    L121:
        LynxAnchorPromotionListUtils.a r23 = new LynxAnchorPromotionListUtils.a(r20, r21);
        ECLiveHybridUtil.m("ecom.anchor.open_coupon_panel", r23);
        LynxAnchorPromotionListUtils.c = r23;
        LynxAnchorPromotionListUtils.b r24 = new LynxAnchorPromotionListUtils.b();
        ECLiveHybridUtil.m("ecom.anchor.open_anchor_promotions_panel", r24);
        LynxAnchorPromotionListUtils.d = r24;
        ECLiveHybridUtil.m("ecom.anchor.continue_push_stream", (ti.j) LynxAnchorPromotionListUtils.e.getValue());
        return;
    L128:
        return;
    L43:
        b0(false, true);
        goto L44
    L37:
        if (T() == false) goto L39;
        r19 = true;
        goto L40
    L45:
        com.bytedance.android.ec.adapter.api.state.a r25 = C();
        boolean r26 = this.m;
        if (r26 == true) goto L48;
    L50:
        boolean r110 = false;
    L51:
        this.L = r110;
        String r111 = y();
        String r112 = z();
        String r113 = B();
        if (s() == false) goto L61;
        ECLiveEntranceMonitor.trace$default("anchor isCommerce=" + T() + " roomId=" + r113, "EntryController", false, 4, null);
        if (T() == false) goto L57;
        if (r26 == false) goto L57;
        r4 = true;
    L57:
        h(new si2.d(true, r4));
        if (T() == false) goto L110;
        if (r26 == false) goto L110;
        CompositeDisposable r27 = CoreRequests.a;
        CoreRequests.e(r111, r112, r113, D(), new com.bytedance.android.livesdk.livecommerce.room.controller.business.j(this, r111, r113));
        CoreRequests.c(new com.bytedance.android.livesdk.livecommerce.room.controller.business.k(this));
        goto L110
    L61:
        boolean r28 = r25.n.getBoolean("EXTRA_BOOL_ROOM_HAS_CART_INFO");
        boolean r114 = V();
        StringBuilder r29 = new StringBuilder("audience isVs=");
        int r30 = r25.b;
        if (r30 != 1) goto L64;
    L69:
        boolean r31 = true;
    L70:
        r29.append(r31);
        r29.append(" isCommerce=");
        r29.append(T());
        r29.append(" hasCartInfo=");
        r29.append(r28);
        r29.append(" isShowCart=");
        r29.append(r114);
        ECLiveEntranceMonitor.trace$default(r29.toString(), "EntryController", false, 4, null);
        if (T() == false) goto L108;
        if (r26 == false) goto L108;
        ECContext r32 = o();
        if (r32 == null) goto L79;
        boolean r33 = ((Bundle) r32.getExtras().getValue()).getBoolean("EXTRA_BOOL_ROOM_HAS_CART_INFO", false);
        boolean r34 = ((Bundle) r32.getExtras().getValue()).getBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE");
        if (r33 == true) goto L79;
        if (r34 == false) goto L79;
        boolean r35 = true;
    L80:
        if (r35 == true) goto L107;
        hh2.g r36 = hh2.f.a.a;
        if (r36 == null) goto L86;
        Boolean r37 = r36.e();
        if (r37 == null) goto L86;
        boolean r38 = r37.booleanValue();
    L87:
        if (r38 == false) goto L107;
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a r39 = com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.e;
        Bundle r40 = r25.n;
        r39.getClass();
        com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.f(com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.c(r40), A().m);
        if (this.k == true) goto L91;
        r114 = this.G;
    L92:
        if (r114 == true) goto L94;
    L96:
        boolean r41 = false;
    L97:
        J(r41);
        if (r41 == true) goto L100;
    L102:
        int r42 = kh2.b.b;
        kh2.b.a r43 = kh2.b.C0149b.a(new kh2.f(r25));
        kh2.a r44 = new kh2.a(r25);
        Intrinsics.checkNotNullParameter(r44, "value");
        r43.a = r44;
        kh2.d r45 = new kh2.d(r25);
        Intrinsics.checkNotNullParameter(r45, "value");
        r43.b = r45;
        r43.b(ReportWhenEnter.YES);
        kh2.j r46 = new kh2.j(r25);
        Intrinsics.checkNotNullParameter(r46, "value");
        r43.f = r46;
        kh2.i r47 = new kh2.i(r25);
        Intrinsics.checkNotNullParameter(r47, "value");
        r43.g = r47;
        r43.c(RequestLivePromotions.NO);
        kh2.g r48 = new kh2.g(null);
        Intrinsics.checkNotNullParameter(r48, "value");
        r43.i = r48;
        kh2.h r49 = new kh2.h(null);
        Intrinsics.checkNotNullParameter(r49, "value");
        r43.j = r49;
        kh2.c r50 = new kh2.c("fast entrance judge".concat(com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.d(r25, r114)));
        Intrinsics.checkNotNullParameter(r50, "value");
        r43.d = r50;
        if (r41 == false) goto L105;
        EntranceShowStatusByRoomState r51 = EntranceShowStatusByRoomState.YES;
    L106:
        r43.a(r51);
        new kh2.b(r43).a();
        goto L110
    L105:
        r51 = EntranceShowStatusByRoomState.NO;
        goto L106
    L100:
        if (xh2.a.a() != 0) goto L102;
        A().r.O("cart_entrance");
        goto L102
    L94:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a.C0119a.a(r25) == false) goto L96;
        r41 = true;
        goto L97
    L91:
        this.G = r114;
    L86:
        r38 = true;
    L107:
        CompositeDisposable r52 = CoreRequests.a;
        CoreRequests.e(r111, r112, r113, D(), new l(this, r113, r25));
    L109:
        c0(new si2.e(0, false));
    L79:
        r35 = false;
    L108:
        h(new si2.d(true, false));
        int r53 = kh2.b.b;
        kh2.b.a r54 = kh2.b.C0149b.a(new kh2.f(r25));
        kh2.a r55 = new kh2.a(r25);
        Intrinsics.checkNotNullParameter(r55, "value");
        r54.a = r55;
        kh2.d r56 = new kh2.d(r25);
        Intrinsics.checkNotNullParameter(r56, "value");
        r54.b = r56;
        r54.b(ReportWhenEnter.YES);
        kh2.j r57 = new kh2.j(r25);
        Intrinsics.checkNotNullParameter(r57, "value");
        r54.f = r57;
        kh2.i r58 = new kh2.i(r25);
        Intrinsics.checkNotNullParameter(r58, "value");
        r54.g = r58;
        r54.c(RequestLivePromotions.NO);
        kh2.g r59 = new kh2.g(null);
        Intrinsics.checkNotNullParameter(r59, "value");
        r54.i = r59;
        kh2.h r60 = new kh2.h(null);
        Intrinsics.checkNotNullParameter(r60, "value");
        r54.j = r60;
        kh2.c r61 = new kh2.c("[isCommerceLiveRoom() && canShowCommerceEntrance] -> false [canShowCommerceEntrance] -> " + r26);
        Intrinsics.checkNotNullParameter(r61, "value");
        r54.d = r61;
        r54.a(EntranceShowStatusByRoomState.NO);
        new kh2.b(r54).a();
        goto L109
    L64:
        if (r30 == 3) goto L69;
        if (r30 == 2) goto L69;
        r31 = false;
        goto L70
    L48:
        if (T() == false) goto L50;
        r110 = true;
        goto L51
    L31:
        r17 = false;
    L123:
        th = move-exception;
        throw th;
    L14:
        if (TextUtils.equals(B(), this.j) == false) goto L17;
        r2 = false;
        goto L18
    }

    public final void R() {
        if (this.k1 == false) goto L5;
        return;
    L5:
        this.k1 = true;
        ECLivePerformanceMonitor r1 = (ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue();
        r1.e();
        String r2 = B();
        Intrinsics.checkNotNullParameter(r2, "roomId");
        r1.b("ec_perf_duration_live_shopping_bag", "room_id", r2);
        String r3 = r1.n;
        String r5 = "";
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r1.b("ec_perf_duration_live_shopping_bag", "enter_room_type", r3);
        r1.b("ec_perf_duration_live_shopping_bag", "enter_from_merge", l0.d());
        r1.b("ec_perf_duration_live_shopping_bag", "enter_method", l0.e());
        r1.v("ec_perf_duration_live_shopping_bag", CollectionsKt.listOf(new String[]{"initial", "enter_room_start", "enter_ec_room_start", "real_start"}), r1.c);
        if (r1.o != null) goto L17;
        Map r4 = com.bytedance.android.ec.core.monitor.c.a;
        String r6 = com.bytedance.android.ec.core.monitor.c.c(MonitorScenes.EC_LIVE_SHOPPING_BAG_SHOW_DURATION, ECLivePerformanceMonitor.y);
        r1.o = r6;
        String r7 = r1.n;
        if (r7 == null) goto L15;
        r5 = r7;
    L15:
        com.bytedance.android.ec.core.monitor.c.e(r6, "enter_room_type", r5);
        com.bytedance.android.ec.core.monitor.c.e(r6, "enter_from_merge", l0.d());
        com.bytedance.android.ec.core.monitor.c.e(r6, "enter_method", l0.e());
        com.bytedance.android.ec.core.monitor.c.h(r6, MetricNames.DURATION, r1.c);
        com.bytedance.android.ec.core.monitor.c.h(r6, MetricNames.ENTER_ROOM_DURATION, r1.c);
        com.bytedance.android.ec.core.monitor.c.h(r6, MetricNames.LIVE_CART_REAL_SHOW_DURATION, r1.c);
        com.bytedance.android.ec.core.monitor.c.h(r6, MetricNames.LIVE_CART_NEXT_FRAME_SHOW_DURATION, r1.c);
    L17:
        if (this.w == false) goto L19;
        r1.s(false, B(), this.U);
    L20:
        r1.t(false, this.U);
        if (EComABUtils.isArsEnable() == false) goto L60;
        yg2.a r8 = (yg2.a) o().getEcLiveActionRecordService().getValue();
        LinkedHashMap r9 = new LinkedHashMap();
        LiveRoomParams r10 = ControllerExtensionsKt.c(A().m, (String) o().getRoomId().getValue()).l();
        r9.put("EVENT_ORIGIN_FEATURE", "TEMAI");
        String r11 = null;
        if (r10 == null) goto L25;
        String r12 = r10.getEnterFromMerge();
    L26:
        r9.put("enter_from_merge", r12);
        if (r10 == null) goto L29;
        String r13 = r10.getEnterMethod();
    L30:
        r9.put("enter_method", r13);
        if (r10 == null) goto L33;
        String r14 = r10.getDisplayAnchorId();
    L34:
        r9.put("anchor_id", r14);
        if (r10 == null) goto L37;
        r11 = r10.getRoomId();
    L37:
        r9.put("room_id", r11);
        List r15 = CollectionsKt.mutableListOf(new com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a[]{new LoggerConsumer(r9), new SlardarConsumer(r9), new TrackerConsumer(r9)});
        r8.getClass();
        Intrinsics.checkNotNullParameter(r15, "registerConsumers");
        if (EComABUtils.isArsEnable() == false) goto L61;
        int r16 = yg2.g.a;
        Intrinsics.checkNotNullParameter(r15, "registerConsumers");
        List<String> r17 = EComABUtils.getArsConsumerWhitList();
        ArrayList r18 = new ArrayList();
        Iterator r19 = r15.iterator();
    L42:
        if (r19.hasNext() == false) goto L49;
        com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a r20 = (com.bytedance.android.livesdk.livecommerce.actionrecord.consumer.a) r19.next();
        if (r17 == null) goto L42;
        if (r17.contains(r20.a()) != true) goto L42;
        r18.add(r20);
        goto L42
    L49:
        if (r18.isEmpty() == true) goto L62;
        ug2.a r0 = r8.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r18, "registerConsumers");
        ((ArrayList) r0.a).addAll(r18);
        return;
    L62:
        return;
    L61:
        return;
    L33:
        r14 = null;
        goto L34
    L29:
        r13 = null;
        goto L30
    L25:
        r12 = null;
        goto L26
    L60:
        return;
    L19:
        r1.r(false, B(), this.U);
        goto L20
    }

    public final void Y() {
        ECLiveEntranceMonitor.trace$default("call onCardLoadFinish", "EntryController", false, 4, null);
        this.P0 = true;
        if (M1 == false) goto L9;
        if (this.L0 == false) goto L7;
        W();
        return;
    L7:
        UtilityKotlinExtentionsKt.b.postDelayed(this.G1, 1000);
        return;
    L9:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.n == false) goto L14;
        W();
        return;
    }

    public final void Z() {
        int r0 = com.bytedance.android.livesdk.livecommerce.hybrid.a.a;
        RoomContextController r1 = A().m;
        Intrinsics.checkNotNullParameter(r1, "contextControl");
        com.bytedance.android.livesdk.livecommerce.hybrid.a.a(false, r1);
        com.bytedance.android.livesdk.livecommerce.room.utils.g r2 = this.M;
        if (r2 == null) goto L5;
        r2.a();
    L5:
        boolean r3 = com.bytedance.android.livesdk.livecommerce.utils.p.a;
        UtilityKotlinExtentionsKt.b.removeCallbacks(com.bytedance.android.livesdk.livecommerce.utils.p.e);
        ECCartMonitor.f.removeCallbacksAndMessages(null);
        if (this.r == null) goto L12;
        com.bytedance.android.livesdk.livecommerce.room.api.e r4 = E();
        hk2.a r5 = this.r;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rankEntry");
    L10:
        r4.K(r5);
    L12:
        if (s() == true) goto L18;
        xk2.a r6 = this.u;
        if (r6 == null) goto L18;
        r6.c();
        if (this.u != null) goto L18;
        xk2.a r7 = new xk2.a(o());
        this.u = r7;
        r7.b(false);
    L18:
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f r8 = this.R;
        if (r8 != null) goto L21;
        return;
    L21:
        if ((r8 instanceof mk2.a) == true) goto L24;
        r8 = null;
    L24:
        if (r8 == null) goto L28;
        r8.onDestroy();
        this.R = null;
        return;
    }

    public final void e0() {
        if (this.B == true) goto L6;
        ((ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue()).k();
        UtilityKotlinExtentionsKt.b.post(new h(this));
        return;
    }

    public final void f0() {
        if (this.J == true) goto L32;
        this.J = true;
        if (s() == false) goto L13;
        if (w() == false) goto L33;
        int r1 = ch2.b.a;
        Bundle r2 = C().n;
        boolean r3 = false;
        if (r2 == null) goto L11;
        r3 = r2.getBoolean("EXTRA_BOOL_COMMODITY_NO_FILTER", false);
    L11:
        new com.bytedance.android.livesdk.livecommerce.event.g(r3).k();
        return;
    L33:
        return;
    L13:
        if (v() == false) goto L15;
        q().previewCompShowEvent();
        return;
    L15:
        n1 r0 = new n1(y(), B());
        r0.r(this.m);
        LiveRoomParams r4 = A().m.l();
        String r5 = null;
        if (r4 == null) goto L18;
        Map r6 = r4.generaInitialData();
    L19:
        r0.o(r6);
        r0.p(C().m);
        ShoppingCart r7 = this.s;
        if (r7 == null) goto L24;
        View r8 = r7.getViewSafe();
        if (r8 == null) goto L24;
        String r9 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r8));
    L25:
        r0.n(r9);
        r0.c.c("is_preview", String.valueOf(v()));
        ShoppingCart r10 = this.s;
        if (r10 == null) goto L30;
        View r11 = r10.getViewSafe();
        if (r11 == null) goto L30;
        r5 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r11));
    L30:
        r0.l("c9398.d8575", r5);
        g0();
        return;
    L24:
        r9 = null;
        goto L25
    L18:
        r6 = null;
        goto L19
    }

    public final void g0() {
        if (this.F == null) goto L16;
        JSONObject r0 = new JSONObject();
        r0.put("anchor_id", y());     // Catch: JSONException -> L10
        if (hh2.f.e() == false) goto L8;
        r0.put("anchor_open_id", y());     // Catch: JSONException -> L10
    L8:
        r0.put("room_id", B());     // Catch: JSONException -> L10
    L12:
        ak2.m r1 = this.F;
        Intrinsics.checkNotNull(r1);
        r1.onClickPromotion("live_ad", "slidecart_show", "", r0);
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public final void i0() {
        if (this.C == true) goto L5;
        return;
    L5:
        if (this.o == true) goto L7;
        return;
    L7:
        if (w() == false) goto L31;
        int r0 = ECLiveLoginHelper.a;
        int r1 = this.U;
        ECLiveABUtils r2 = ECLiveABUtils.INSTANCE;
        if (ECLiveLoginHelper.c(r1, r2.getECOM_LIVE_CARD_NO_LOGIN().booleanValue()) == true) goto L14;
        if (C().a() == true) goto L14;
        return;
    L14:
        if (C().c == false) goto L16;
        return;
    L16:
        if (this.v != null) goto L35;
        ECContext r4 = o();
        ((ECLivePerformanceMonitor) r4.getEcLivePerformanceMonitor().getValue()).h();
        if (r2.getENABLE_KMP_POP_CARD() == true) goto L21;
        BottomRightWidgetV2 r3 = new BottomRightWidgetV2(m(), r4, E(), A().m, l());
    L25:
        this.v = r3;
        if (r3 == null) goto L33;
        r3.load();
        return;
    L33:
        return;
    L21:
        if (A().q.n == null) goto L23;
        Context r5 = m();
        com.bytedance.android.livesdk.livecommerce.room.api.e r6 = E();
        RoomContextController r7 = A().m;
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r4, "ecContext");
        Intrinsics.checkNotNullParameter(r6, "iLiveRoomViewHandler");
        Intrinsics.checkNotNullParameter(r7, "roomContextController");
    L23:
        r3 = null;
        goto L25
    L35:
        return;
    }

    public final void j0() {
        if (this.o == true) goto L5;
        return;
    L5:
        if (this.h1 == true) goto L8;
        return;
    L8:
        if (this.R == null) goto L10;
        return;
    L10:
        if (w() == false) goto L17;
        com.bytedance.android.ec.adapter.api.state.d r0 = (com.bytedance.android.ec.adapter.api.state.d) C().z.a.getValue();
        if (r0 == null) goto L17;
        if (r0.a() != 1) goto L17;
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f r1 = new mk2.a(m(), E(), l());
    L20:
        this.R = r1;
        r1.load();
        return;
    L17:
        if (ECLiveABUtils.INSTANCE.getENABLE_KMP_POP_CARD() == false) goto L19;
        r1 = new com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.g(m(), o(), E(), l());
        goto L20
    L19:
        r1 = new com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.e(m(), o(), E(), l());
        goto L20
    }

    public final void k0() {
        if (this.y == true) goto L5;
        return;
    L5:
        if (this.o == true) goto L7;
        return;
    L7:
        if (w() == false) goto L25;
        int r0 = ECLiveLoginHelper.a;
        if (ECLiveLoginHelper.c(this.U, ECLiveABUtils.INSTANCE.getECOM_LIVE_CARD_NO_LOGIN().booleanValue()) == false) goto L11;
    L13:
        com.bytedance.android.ec.adapter.api.state.a r1 = C();
        if (r1.y == 1) goto L17;
        return;
    L17:
        if (r1.c == false) goto L19;
        return;
    L19:
        if (this.x != null) goto L29;
        ECContext r3 = o();
        ((ECLivePerformanceMonitor) r3.getEcLivePerformanceMonitor().getValue()).h();
        qh2.d r2 = new qh2.d(m(), r3, E(), A().m, l());
        r2.v(this.z);
        Unit r4 = Unit.INSTANCE;
        this.x = r2;
        r2.load();
        return;
    L29:
        return;
    L11:
        if (C().a() == true) goto L13;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0
    public final void n() {
        xk2.a r0 = this.u;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        this.u = null;
        BottomRightWidgetV2 r1 = this.v;
        if (r1 == null) goto L8;
        r1.onDestroy();
    L8:
        this.v = null;
        qh2.d r2 = this.x;
        if (r2 == null) goto L11;
        r2.u();
    L11:
        this.x = null;
        this.s = null;
        com.bytedance.android.livesdk.livecommerce.room.utils.g r3 = this.M;
        if (r3 == null) goto L14;
        r3.a();
    L14:
        com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.f r4 = this.R;
        if (r4 == null) goto L17;
        r4.onDestroy();
    L17:
        this.R = null;
        this.h1 = false;
        boolean r5 = com.bytedance.android.livesdk.livecommerce.utils.p.a;
        Handler r6 = UtilityKotlinExtentionsKt.b;
        r6.removeCallbacks(com.bytedance.android.livesdk.livecommerce.utils.p.e);
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t r7 = this.T;
        if (r7 == null) goto L20;
        r7.a = null;
        r7.b = false;
        r7.c = false;
        r7.d = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.p = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.q = null;
    L20:
        IntroCardLoadOpt r8 = this.A;
        if (r8 == null) goto L23;
        r8.a = null;
        r8.b = false;
        r8.c = false;
        r8.d = null;
        IntroCardLoadOpt.n = IntroCardLoadOpt.f;
        IntroCardLoadOpt.o = null;
    L23:
        PromotionCardLoadOptUtils.Companion r9 = PromotionCardLoadOptUtils.p;
        String r10 = B();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "roomId");
        PromotionCardLoadOptUtils r11 = PromotionCardLoadOptUtils.n.remove(r10);
        if (r11 == null) goto L32;
        r11.b = null;
        r11.c = null;
        r11.d = null;
        r11.e = false;
        r11.a = false;
        Disposable r12 = r11.f;
        if (r12 == null) goto L28;
        r12.dispose();
    L28:
        r11.f = null;
        r11.g = null;
        WeakReference<Context> r13 = r11.j;
        if (r13 == null) goto L31;
        r13.clear();
    L31:
        r11.j = null;
    L32:
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p r14 = this.V;
        if (r14 == null) goto L38;
        Disposable r15 = r14.a;
        if (r15 == null) goto L37;
        r15.dispose();
    L37:
        r14.a = null;
        r14.c = null;
        r14.d = null;
    L38:
        ECCartMonitor.d = null;
        ((LinkedHashMap) ECCartMonitor.e).clear();
        ECCartMonitor.g = false;
        ECCartMonitor.f.removeCallbacksAndMessages(null);
        if (u() == false) goto L51;
        ShoppingAsyncInflater.a r16 = ShoppingAsyncInflater.e;
        Context r17 = m();
        r16.getClass();
        if (r17 == null) goto L44;
        Activity r18 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r17);
        ShoppingAsyncInflater.d.remove(r18);
    L44:
        Map r19 = ShoppingAsyncCacheInflater.d;
        Context r20 = m();
        if (r20 == null) goto L51;
        Activity r21 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r20);
        if (r21 == null) goto L51;
        ShoppingAsyncCacheInflater.d.remove(r21);
    L51:
        if (this.k0 == true) goto L53;
    L63:
        this.H0 = false;
        y.a r22 = y.o;
        String r23 = B();
        r22.getClass();
        Intrinsics.checkNotNullParameter(r23, "roomId");
        y r24 = y.n.remove(r23);
        if (r24 == null) goto L72;
        r24.b = null;
        r24.c = null;
        r24.d = null;
        Disposable r25 = r24.f;
        if (r25 == null) goto L68;
        r25.dispose();
    L68:
        r24.f = null;
        r24.g = null;
        WeakReference<Context> r26 = r24.i;
        if (r26 == null) goto L71;
        r26.clear();
    L71:
        r24.i = null;
    L72:
        com.bytedance.android.livesdk.livecommerce.intro.utils.f.a r27 = com.bytedance.android.livesdk.livecommerce.intro.utils.f.o;
        String r28 = B();
        r27.getClass();
        Intrinsics.checkNotNullParameter(r28, "roomId");
        com.bytedance.android.livesdk.livecommerce.intro.utils.f r29 = com.bytedance.android.livesdk.livecommerce.intro.utils.f.n.remove(r28);
        if (r29 == null) goto L81;
        r29.b = null;
        r29.c = null;
        r29.d = null;
        Disposable r30 = r29.f;
        if (r30 == null) goto L77;
        r30.dispose();
    L77:
        r29.f = null;
        r29.g = null;
        WeakReference<Context> r31 = r29.i;
        if (r31 == null) goto L80;
        r31.clear();
    L80:
        r29.i = null;
    L81:
        r6.removeCallbacks(this.G1);
        this.L0 = false;
        this.P0 = false;
        this.V0 = false;
        this.b1 = false;
        this.g1 = false;
        M().c(true);
        if (ECLiveABUtils.INSTANCE.getECOM_LIVE_ENABLE_RELATED_INFO_UPDATE_DEDUPLICATE().booleanValue() == false) goto L84;
        this.H1 = false;
    L84:
        int r32 = ECEnterRoomJumpLogUtils.a;
        cl.d r33 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r33 == null) goto L87;
        r33.i();
    L87:
        com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.c r34 = K();
        r34.getClass();
        int r35 = com.bytedance.android.livesdk.livecommerce.promotion.cardV2.tracker.c.b;
        dm.a.a("ActionTrack").a("clear all tracker");
        Map r36 = r34.a.a.snapshot();
        if (r36 == null) goto L93;
        Iterator r37 = r36.entrySet().iterator();
    L91:
        if (r37.hasNext() == false) goto L93;
        ((LiveActionTracker) ((Map.Entry) r37.next()).getKey()).e(true);
    L93:
        r34.a.a.evictAll();
        return;
    L53:
        if (u() == false) goto L63;
        this.k0 = false;
        int r38 = ECSdk.a;
        IECUserTrackerService r39 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r39 == null) goto L60;
        of.a r40 = r39.getMarketingService();
        if (r40 == null) goto L60;
        r40.a("live_total_visit_seconds", PostActionType.END_DURATION, "live");
    L60:
        IECUserTrackerService r41 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r41 == null) goto L63;
        r41.leavePage(new of.b(m(), "live", false, null, 24));
        goto L63
    }

    public final ShoppingCart I() {
        if (com.bytedance.android.livesdk.livecommerce.room.f.c(Boolean.valueOf(s())) == false) goto L5;
        return null;
    L5:
        ECContext r0 = o();
        if (r0 != null) goto L8;
        return null;
    L8:
        return new ShoppingCart(m(), r0, this, A().m);
    }

    public final boolean T() {
        if (w() == true) goto L5;
    L7:
        return false;
    L5:
        if (C().n.getBoolean("EXTRA_BOOL_ROOM_HAS_COMMERCE") == false) goto L7;
        return true;
    }

    public final boolean U() {
        if (com.bytedance.android.ec.core.opt.ab.j.a().n() == false) goto L9;
        Boolean r0 = this.v1;
        if (r0 != null) goto L10;
        boolean r1 = EComABUtils.isEnableLiveOptSlot();
        this.v1 = Boolean.valueOf(r1);
        return r1;
    L10:
        return r0.booleanValue();
    L9:
        return EComABUtils.isEnableLiveOptSlot();
    }

    public final boolean V() {
        if (C().n.getInt("EXTRA_INT_SHOW_CART") == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final void W() {
        com.bytedance.android.livesdk.livecommerce.room.controller.business.c r0 = A().o;
        r0.getClass();
        if (ECLiveABUtils.INSTANCE.getECOM_DISABLE_LEGACY_LOAD_COUPON_LOGIC() == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L14;
        if (r0.w() == false) goto L12;
        CouponEventRegisterHelper.a();
    L12:
        dm.a.a("[CouponController]").i("disable legacy load coupon render logic");
        return;
    L14:
        if (r0.d == false) goto L16;
        return;
    L16:
        if (r0.w() == false) goto L26;
        LiveRoomLifecycleOwner r2 = (LiveRoomLifecycleOwner) r0.o().getLifecycleOwner().getValue();
        if (Intrinsics.areEqual((Boolean) r0.b.d().getValue(), Boolean.TRUE) == false) goto L21;
        r0.I();
    L22:
        r0.d = true;
        return;
    L21:
        r0.b.d().observe(r2, new com.bytedance.android.livesdk.livecommerce.room.controller.business.d(r0));
        goto L22
    L26:
        return;
    L5:
        if (ECAppInfoService.h() == false) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onDestroy() {
        super.onDestroy();
        if (s() == false) goto L5;
    L10:
        this.o = false;
        this.p = false;
        this.q = false;
        this.C = false;
        ECLiveABUtils r1 = ECLiveABUtils.INSTANCE;
        if (r1.getEC_LIVE_INTRO_CARD_WIDGET_LOAD_FIX() == false) goto L18;
        this.z = false;
        if (r1.getEC_LIVE_INTRO_CARD_WIDGET_LOAD_FIX() == false) goto L17;
        qh2.d r2 = this.x;
        if (r2 == null) goto L17;
        r2.v(false);
    L17:
        this.y = false;
    L18:
        this.B = false;
        this.c = 0;
        this.h = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.i = false;
        s0.e(this);
        if (s() == false) goto L21;
        LynxAnchorPromotionListUtils.a();
    L21:
        ECLivePerformanceMonitor r0 = (ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue();
        String r3 = r0.p;
        if (r3 == null) goto L24;
        Map r4 = com.bytedance.android.ec.core.monitor.c.a;
        ((HashMap) com.bytedance.android.ec.core.monitor.c.a).remove(r3);
    L24:
        r0.p = null;
        String r5 = r0.o;
        if (r5 == null) goto L27;
        Map r6 = com.bytedance.android.ec.core.monitor.c.a;
        ((HashMap) com.bytedance.android.ec.core.monitor.c.a).remove(r5);
    L27:
        r0.o = null;
        ((fk2.b) o().getEcLiveRoomDurationMonitor().getValue()).d();
        if (v() == false) goto L31;
        this.p1.dispose();
        return;
    L31:
        return;
    L5:
        if (this.H == true) goto L7;
    L9:
        this.I = 0;
        goto L10
    L7:
        if (this.I <= 0) goto L9;
        String r7 = y();
        String r8 = B();
        String r9 = l0.f();
        long r10 = this.I;
        Handler r11 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        new o1(r7, r8, r9, SystemClock.elapsedRealtime() - r10).k();
        goto L9
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.a();
        this.s = null;
        this.v = null;
        this.n = null;
        this.l = 0;
        this.j = null;
        Disposable r1 = this.X;
        if (r1 == null) goto L5;
        r1.dispose();
    L5:
        this.X = null;
        this.L1.removeCallbacksAndMessages(null);
        s0.e(this);
        if (s() == false) goto L8;
        LynxAnchorPromotionListUtils.a();
    L8:
        JSONObject r0 = new JSONObject();
        r0.put("room_id", B());
        r0.put("room_unique_key", D());
        Unit r2 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ec.live.didLeaveRoom", r0);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onRoomVisible() {
        if (w() == false) goto L6;
        R();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onStart() {
        if (v() == false) goto L13;
        if (this.w == false) goto L10;
        if (this.y == true) goto L13;
        this.y = true;
        k0();
        goto L13
    L10:
        if (this.C == true) goto L13;
        this.C = true;
        i0();
    L13:
        if (u() == false) goto L18;
        ShoppingCart r0 = this.s;
        if (r0 == null) goto L19;
        r0.updateContext(m());
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onWidgetLoadFinished() {
        F();
        if (this.p == true) goto L6;
        new i0(MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", "commerce_entrance"), TuplesKt.to("contextAttached", String.valueOf(this.d)), TuplesKt.to("viewHandler", String.valueOf(this.e)), TuplesKt.to("activityCreated", String.valueOf(this.g)), TuplesKt.to("dataContextAvailable", String.valueOf(this.h))}), B()).k();
        Q();
    L6:
        if (v() == false) goto L8;
    L15:
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == false) goto L18;
        return;
    L18:
        if (this.e == true) goto L20;
        return;
    L20:
        if (ECLiveABUtils.INSTANCE.getENABLE_CONVERTER_OPT() == false) goto L22;
        E().L(new wk2.c(m(), o(), E()), xd.f.a);
        return;
    L22:
        E().L(new wk2.a(m(), o(), E()), xd.f.a);
        return;
    L8:
        if (this.w == false) goto L13;
        if (this.y == true) goto L15;
        this.y = true;
        k0();
        goto L15
    L13:
        if (this.C == true) goto L15;
        this.C = true;
        i0();
        goto L15
    }

    public EntryController(RealRoomController$roomResources$1 r2) {
        Intrinsics.checkNotNullParameter(r2, "roomResources");
        super(r2);
        this.m = true;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t r0 = null;
        if (hh2.f.a() == false) goto L5;
        IntroCardLoadOpt r3 = new IntroCardLoadOpt();
    L6:
        this.A = r3;
        if (hh2.f.a() == false) goto L9;
        r0 = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t();
    L9:
        this.T = r0;
        this.Y = LazyKt.lazy(EntryController$largeModeManager$2.INSTANCE);
        this.Z = LazyKt.lazy(EntryController$actionTrackerCenter$2.INSTANCE);
        this.p1 = new CompositeDisposable();
        this.x1 = LazyKt.lazy(EntryController$relatedInfoManager$2.INSTANCE);
        this.y1 = LazyKt.lazy(new EntryController$jumpDispatcher$2(this));
        this.G1 = new com.bytedance.android.livesdk.livecommerce.room.controller.business.i(this);
        this.L1 = new Handler(Looper.getMainLooper());
        hh2.a.a().b.getClass();
        return;
    L5:
        r3 = null;
        goto L6
    }

    public static boolean S(String r1) {
        if (Intrinsics.areEqual(r1, "CommerceCart_More_Anchor") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r1, "CommerceCart_Toolbar_Anchor") == true) goto L10;
        if (Intrinsics.areEqual(r1, "CommerceCart_Toolbar_Audience") == true) goto L10;
        return false;
    }

    public final void J(boolean r4) {
        if (r4 == true) goto L5;
        this.B = true;
    L5:
        ((ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue()).j();
        this.H = r4;
        if (r4 == false) goto L8;
        Handler r1 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        this.I = SystemClock.elapsedRealtime();
        f0();
    L8:
        h(new si2.d(true, r4));
    }

    public final void N(final Map<String, String> r10) {
        HashMap r0 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r1 = com.bytedance.android.ec.core.hybrid.utils.j.i(r10.get("enter_request"));
        LinkedHashMap r2 = null;
        String r3 = null;
        if (r1 == null) goto L5;
        String r4 = r1.optString("is_need_block_coupon");
    L7:
        if (Intrinsics.areEqual(r4, "true") == false) goto L10;
        return;
    L10:
        if (C().a() == false) goto L12;
        JSONObject r5 = com.bytedance.android.ec.core.hybrid.utils.j.i(r10.get("enter_request"));
        CouponGrowProvider.Companion r6 = CouponGrowProvider.l;
        r6.getClass();
        boolean r11 = CouponGrowProvider.Companion.e(r5);
        if (hh2.f.d() == false) goto L46;
        if (r11 == true) goto L79;
        CouponGrowProvider.Companion.a("rac");
        CouponGrowProvider.Companion.h(r6, m(), r5, B(), false, 24);
        return;
    L79:
        return;
    L46:
        if (r11 == false) goto L49;
        CouponGrowProvider.Companion.a("nrac");
        return;
    L49:
        if (r5 == null) goto L81;
        String r12 = r5.optString("host");
        if (cg4.a.a(r12) == true) goto L54;
        r12 = null;
    L54:
        if (r12 != null) goto L56;
        r12 = si2.g.a;
    L56:
        String r7 = r5.optString("api");
        if (r7 != null) goto L59;
        return;
    L59:
        JSONObject r8 = r5.optJSONObject("params");
        if (r8 == null) goto L65;
        r2 = new LinkedHashMap();
        Iterator<String> r9 = r8.keys();
    L63:
        if (r9.hasNext() == false) goto L65;
        String r13 = r9.next();
        r2.put(r13, r8.optString(r13));
    L65:
        CompositeDisposable r14 = CoreRequests.a;
        CoreRequests.a("https://" + r12 + r7, B(), r2, new b(this));
        return;
    L81:
        return;
    L12:
        if (this.d == true) goto L14;
        return;
    L14:
        final Context r15 = m();
        if ((r15 instanceof Activity) == false) goto L68;
        JSONObject r16 = com.bytedance.android.ec.core.hybrid.utils.j.i(r10.get("enter_request"));
        if (r16 == null) goto L19;
        String r17 = r16.optString("auth_type");
    L21:
        if (cg4.a.a(r17) == false) goto L23;
        r3 = r17;
    L23:
        if (r3 == null) goto L69;
        final Function0<Unit> r18 = new EntryController$handleEnterRequest$$inlined$let$lambda$1(this, r10, r15);
        switch(r3.hashCode()) {
            case 49: goto L39;
            case 50: goto L36;
            case 51: goto L33;
            case 52: goto L28;
            default: goto L78;
        };
    L78:
        return;
    L28:
        if (r3.equals("4") == true) goto L30;
        return;
    L30:
        if (hh2.f.d() == false) goto L71;
        com.bytedance.android.ec.sdk.helper.c.a.a("lqmt", "coguide");
        return;
    L71:
        return;
    L33:
        if (r3.equals("3") == false) goto L73;
        com.bytedance.android.ec.sdk.helper.r.a.showLogin((Activity) r15, "live_detail", "livesdk_click_product", new EntryController$handleEnterRequest$$inlined$let$lambda$3(this, r10, r15), new EntryController$handleEnterRequest$2$4(r18));
        return;
    L73:
        return;
    L36:
        if (r3.equals(PromotionCategory.CATEGORY_TYPE_SECOND) == false) goto L75;
        r18.invoke();
        return;
    L75:
        return;
    L39:
        if (r3.equals("1") == false) goto L77;
        com.bytedance.android.ec.sdk.helper.r.a.showLogin((Activity) r15, "live_detail", "livesdk_click_product", new EntryController$handleEnterRequest$$inlined$let$lambda$2(this, r10, r15), EntryController$handleEnterRequest$2$2.INSTANCE);
        return;
    L77:
        return;
    L69:
        return;
    L19:
        r17 = null;
        goto L21
    L68:
        return;
    L5:
        r4 = null;
        goto L7
    }

    public final void O(Map<String, ? extends Object> r8) {
        Object r0 = null;
        if (r8 == null) goto L5;
        Object r1 = r8.get("ecom_live_params");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        if (r2 == null) goto L34;
        HashMap r3 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r4 = com.bytedance.android.ec.core.hybrid.utils.j.i(r2);
        if (r4 == null) goto L35;
        Object r9 = r8.get("source_btm_token");
        if ((r9 instanceof String) == false) goto L18;
        r0 = r9;
    L18:
        String r5 = (String) r0;
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<String> r6 = r4.keys();
    L20:
        if (r6.hasNext() == false) goto L27;
        String r7 = r6.next();
        String r11 = a2.d(r4.optString(r7));
        if (r11 == null) goto L20;
        if (Intrinsics.areEqual(r7, "jump_schema") == false) goto L26;
        r11 = com.bytedance.android.shopping.utils.l0.a(r11, "source_btm_token", r5);
    L26:
        r10.put(r7, r11);
        goto L20
    L27:
        this.D = false;
        P(r10, true);
        return;
    L35:
        return;
    L34:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void X(boolean r30) {
        if (s() == false) goto L5;
        return;
    L5:
        Map<String, String> r4 = p();
        int r5 = ECEnterRoomJumpLogUtils.a;
        xh.b r6 = new xh.b();
        r6.c("LiveRoom");
        r6.b("get_ecom_params");
        r6.a(r4);
        xh.c.a("EnterJump").f(4, r6);
        ECEnterRoomJumpLogUtils.d(r6);
        if (r30 == true) goto L8;
        return;
    L8:
        if (com.bytedance.android.livesdk.livecommerce.room.model.h.a(C()) == false) goto L10;
        boolean r7 = ECToolbarHandler.b;
        boolean r10 = false;
        ECToolbarHandler.b = false;
        View r11 = null;
        if (r7 == false) goto L21;
        ShoppingCart r0 = this.s;
        if (r0 == null) goto L18;
        r11 = r0.getViewSafe();
    L18:
        PromotionListController.N(A().r, m(), "live_shopping_cart", new si2.b("live_shopping_cart", true, false), new PromotionListController.c(null, false, null, null, BtmSDK.INSTANCE.createJumpSourceBtmToken(BtmUtilsKt.e("c9398.d8575", PageFinder.via(r11))), null, null, null, 239), true, null, null, null, 224);
        return;
    L21:
        if (TextUtils.equals(r4.get("show_law"), BDLocationException.ERROR_TIMEOUT) == false) goto L23;
        hh2.f.b().a();
    L23:
        N(r4);
        A().r.K();
        String r13 = r4.get("params_version");
        if (r13 != null) goto L26;
    L29:
        boolean r14 = true;
    L30:
        if (r14 == true) goto L34;
        Map r15 = MapsKt.mapOf(TuplesKt.to("params_version", r13));
        xh.b r16 = new xh.b();
        r16.c("LiveRoom");
        r16.b("get_params_version");
        r16.a(r15);
        xh.c.a("EnterJump").f(4, r16);
        ECEnterRoomJumpLogUtils.d(r16);
    L34:
        if (Intrinsics.areEqual(r4.get("params_version"), "1") == false) goto L36;
        P(r4, false);
        return;
    L36:
        ShoppingCart r8 = this.s;
        if (r8 == null) goto L39;
        r11 = r8.getViewSafe();
    L39:
        com.bytedance.android.btm.api.model.d r9 = BtmUtilsKt.e("c366460.d75972", PageFinder.via(r11));
        if (TextUtils.equals("ecom_list_panel", r4.get("pop_type")) == true) goto L42;
        return;
    L42:
        ((ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue()).q(B());
        String r12 = r4.get("should_not_show_panel");
        String r17 = r4.get("should_show_panel");
        if (r17 == null) goto L46;
        boolean r18 = Intrinsics.areEqual(r17, "1");
    L49:
        String r19 = r4.get("pop_goods_detail");
        if (this.D == false) goto L52;
        return;
    L52:
        if (r18 == false) goto L54;
    L70:
        if (r18 == false) goto L83;
        JSONObject r1 = l0.p(r4);
        if (r1 != null) goto L74;
        r1 = new JSONObject();
    L74:
        PromotionListController.N(A().r, m(), "schema", new si2.b(r4.get("live_list_channel"), true, true), new PromotionListController.c(r4.get("product_id"), false, r1.toString(), null, BtmSDK.INSTANCE.createJumpSourceBtmToken(r9), null, null, null, 232), false, null, new EntryController$onButtonStatusChange$2(this), null, 176);
        this.D = true;
        return;
    L83:
        return;
    L54:
        if (TextUtils.equals(r19, "1") == false) goto L70;
        JSONObject r20 = l0.p(r4);
        if (r20 != null) goto L76;
        r20 = new JSONObject();
    L76:
    L67:
        e = move-exception;
        ECExceptionMonitor.e(e);
    L69:
        IronNavigator.g(m(), B(), null, r4.get("product_id"), l0.b(r4), r20, null, r9, (bk2.b) o().getDisposableContext().getValue());
        this.D = true;
        return;
    L59:
        if (r20.has("draw_order") == true) goto L62;
        r20.put("draw_order", C().n.getInt("EXTRA_ROOM_DRAW_INDEX", -1));     // Catch: JSONException -> L67
    L62:
        if (r20.has("outflow_order") == false) goto L69;
        if (r20.has("click_order") == true) goto L69;
        r20.put("click_order", r20.optString("outflow_order"));     // Catch: JSONException -> L67
        goto L69
    L46:
        if (EComABUtils.getLiveParamsDeprecateShouldNotShow() != 0) goto L48;
        r10 = !Intrinsics.areEqual(r12, "1");
    L48:
        int r21 = ECExceptionMonitor.a;
        ECExceptionMonitor.h(EComABUtils.getLiveParamsDeprecateShouldNotShowTip());
        oh.a.c("livesdk_ecom_live_params_log", new e(r4));
        r18 = r10;
        goto L49
    L26:
        if (r13.length() == 0) goto L29;
        r14 = false;
        goto L30
    L10:
        if (Intrinsics.areEqual(r4.get("enter_request_allow_scroll"), "1") == false) goto L78;
        N(r4);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void a(com.bytedance.android.ec.adapter.api.state.a r19) {
        Intrinsics.checkNotNullParameter(r19, BaseCoreViewModel.CORE_TAG_STATE);
        Intrinsics.checkNotNullParameter(r19, BaseCoreViewModel.CORE_TAG_STATE);
        l0(r19.w, LiveRoomRedirectPriority.ROOM_ENTER);
        if (r19.y != 1) goto L5;
        boolean r2 = true;
    L6:
        this.w = r2;
        int r3 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("=== isNewIntroCard == " + this.w + ", introType = " + r19.y + " ===");
        int r4 = r19.v;
        this.U = r4;
        if (r4 >= 1) goto L9;
    L28:
        this.m = r19.d;
        boolean r5 = com.bytedance.android.livesdk.livecommerce.utils.p.a;
        String r6 = r19.f;
        boolean r7 = s();
        com.bytedance.android.livesdk.livecommerce.utils.p.c = r6;
        com.bytedance.android.livesdk.livecommerce.utils.p.d = r7;
        if (s() == false) goto L31;
    L39:
        PromotionListController r8 = A().r;
        if (r8.w() == false) goto L42;
        Map<String, String> r9 = r8.p();
    L43:
        if (r9 == null) goto L51;
        if (r8.E == true) goto L51;
        String r10 = a2.d(r9.get("store_id"));
        if (r10 == null) goto L51;
        r8.z = r10;
        r8.E = true;
        dm.a.a("LiveAddress").a("handleEnterStoreInfo: storeId=".concat(r10));
    L51:
        if (this.V == null) goto L53;
    L57:
        ECLiveABUtils r11 = ECLiveABUtils.INSTANCE;
        if (r11.getEC_LIVE_ENABLE_LARGE_MODE() == false) goto L65;
        List<Integer> r12 = r11.getINSTANT_ROOM_FUNC_MAP().get("big_font_block");
        if (r12 != null) goto L63;
        r12 = CollectionsKt.emptyList();
    L63:
        if (r12.contains(Integer.valueOf(r19.v)) == true) goto L65;
        L().a(true);
    L67:
        if (this.e == true) goto L69;
    L158:
        View r13 = null;
    L160:
        if (r11.getECOM_LIVE_ENABLE_RELATED_INFO_UPDATE_DEDUPLICATE().booleanValue() == false) goto L165;
        if (this.H1 == false) goto L165;
    L180:
        if (this.b1 == true) goto L197;
        if (w() == false) goto L197;
        if (s() == true) goto L197;
        if (T() == false) goto L197;
        if (V() == false) goto L197;
        if (u() == false) goto L197;
        if (C().a() == false) goto L197;
        this.b1 = true;
        if (A().q.n == null) goto L197;
        Intrinsics.checkNotNullParameter(A().m, "controller");
    L197:
        if (this.e == true) goto L199;
    L217:
        ShoppingCart r0 = this.s;
        if (r0 == null) goto L220;
        View r14 = r0.getViewSafe();
    L221:
        if (r14 == null) goto L226;
        A().v.H("shopping_cart", r14);
        return;
    L226:
        return;
    L220:
        r14 = r13;
        goto L221
    L199:
        if (this.g1 == true) goto L217;
        if (P1 == false) goto L217;
        if (hh2.f.a() == false) goto L217;
        this.g1 = true;
        if (s() == true) goto L217;
        if (T() == false) goto L217;
        if (V() == false) goto L217;
        if (u() == false) goto L217;
        if (C().a() == false) goto L217;
        if (this.w == true) goto L217;
        PromotionCardLoadOptUtils.Companion r1 = PromotionCardLoadOptUtils.p;
        String r15 = B();
        r1.getClass();
        PromotionCardLoadOptUtils.Companion.c(r15).a(o(), new com.bytedance.android.livesdk.livecommerce.room.model.g(o(), A().m), M().f(IRelatedInfoManager$Scene.CARRY_ON_CARD), m(), this.V);
    L165:
        if (w() == false) goto L180;
        RelatedInfoManager r16 = M();
        IRelatedInfoManager$FromSource r17 = IRelatedInfoManager$FromSource.ECOM_LIVE_PARAMS;
        if (r16.a(r17) == false) goto L180;
        String r18 = (String) C().p.get("favorite_product_id");
        if (r18 != null) goto L224;
        RelatedInfoManager r20 = M();
        String r21 = p().get("related_info");
        if (r21 != null) goto L177;
        r21 = "";
    L177:
        r20.i(r21, r17);
    L178:
        this.H1 = true;
        goto L180
    L224:
        M().i(new JSONObject().put("favorite_product_id", r18).toString(), r17);     // Catch: Exception -> L172
    L172:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L178
    L69:
        if (this.V0 == true) goto L158;
        this.V0 = true;
        Lazy r22 = ECAppInfoService.a;
        if (we.a.a == false) goto L79;
        if (T() == false) goto L79;
        if (v() == true) goto L79;
        R();
    L79:
        if (P1 == false) goto L158;
        if (com.bytedance.android.livesdk.livecommerce.room.controller.b.a(r19) == false) goto L90;
        if (T() == false) goto L90;
        if (we.a.a == true) goto L90;
        if (v() == true) goto L90;
        R();
    L90:
        if (hh2.f.a() == true) goto L92;
    L156:
        r13 = null;
    L157:
        this.i = true;
        h0("startInitOnEnterRoom");
        goto L160
    L92:
        if (v() == true) goto L156;
        if (s() == true) goto L156;
        if (T() == false) goto L156;
        if (V() == false) goto L156;
        if (u() == false) goto L156;
        if (C().a() == false) goto L156;
        if (this.w == false) goto L153;
        IntroCardLoadOpt r23 = this.A;
        if (r23 == null) goto L156;
        ECContext r24 = o();
        com.bytedance.android.livesdk.livecommerce.room.model.g r25 = new com.bytedance.android.livesdk.livecommerce.room.model.g(o(), A().m);
        Context r110 = m();
        Intrinsics.checkNotNullParameter(r24, "ecContext");
        Intrinsics.checkNotNullParameter(r25, "liveRoomInfo");
        com.bytedance.android.livesdk.livecommerce.intro.utils.f.o.getClass();
        com.bytedance.android.livesdk.livecommerce.intro.utils.f r111 = com.bytedance.android.livesdk.livecommerce.intro.utils.f.n.get(r25.roomId());
        if (r111 != null) goto L110;
    L111:
        if (r111 != null) goto L113;
    L116:
        OptCardUtil.b(null, "request=" + IntroCardLoadOpt.h + " bind=" + IntroCardLoadOpt.i + " show=" + IntroCardLoadOpt.j + " CardDoFrame=" + IntroCardLoadOpt.k + " PicPreload=" + IntroCardLoadOpt.l + " PicDoFrame=" + IntroCardLoadOpt.m);
        com.bytedance.android.livesdk.livecommerce.intro.manager.t r26 = new com.bytedance.android.livesdk.livecommerce.intro.manager.t();
        Intrinsics.checkNotNullParameter(r26, "dataSource");
        r23.c = true;
        ECLivePerformanceMonitor r27 = (ECLivePerformanceMonitor) r24.getEcLivePerformanceMonitor().getValue();
        r27.getClass();
        r27.u("ec_perf_duration_intro_card", "request_start", Long.valueOf(SystemClock.elapsedRealtime()));
        String r28 = r27.p;
        if (r28 == null) goto L119;
        Map r112 = com.bytedance.android.ec.core.monitor.c.a;
        com.bytedance.android.ec.core.monitor.c.h(r28, MetricNames.POP_API_DURATION, null);
    L119:
        IntroCardScene r29 = IntroCardScene.ENTER_ROOM;
        if ((240 & 4) == 0) goto L122;
        boolean r113 = false;
    L123:
        Intrinsics.checkNotNullParameter(r25, "roomInfo");
        Intrinsics.checkNotNullParameter(r29, "cardScene");
        bk2.c.a(r26.a(r25, r29, r113, false, null, null, null, null).subscribe(new com.bytedance.android.livesdk.livecommerce.intro.utils.d(r23, r24), new com.bytedance.android.livesdk.livecommerce.intro.utils.e(r23, r24)), (bk2.d) r24.getDisposableContext().getValue());
    L124:
        r23.e = r24;
        if (r110 == 0) goto L152;
        boolean r30 = com.bytedance.android.livesdk.livecommerce.intro.utils.f.k;
        boolean r31 = IntroCardLoadOpt.f;
        if (r30 == false) goto L151;
        if (r111 == 0) goto L132;
        WeakReference<Context> r32 = r111.getContext();
        if (r32 == null) goto L132;
        Context r33 = r32.get();
    L133:
        boolean r34 = Intrinsics.areEqual(r33, r110);
        ECLivePerformanceMonitor r35 = (ECLivePerformanceMonitor) r24.getEcLivePerformanceMonitor().getValue();
        r35.getClass();
        String r36 = "1";
        if (r34 == false) goto L136;
        String r37 = "1";
    L137:
        r35.b("ec_perf_duration_intro_card", "is_preload_same_activity", r37);
        String r38 = r35.p;
        if (r38 == null) goto L144;
        Map r39 = com.bytedance.android.ec.core.monitor.c.a;
        if (r34 == true) goto L143;
        r36 = BDLocationException.ERROR_TIMEOUT;
    L143:
        com.bytedance.android.ec.core.monitor.c.e(r38, "is_preload_same_activity", r36);
    L144:
        r13 = null;
        OptCardUtil.b(null, "async layout same: " + r34);
        if (r111 != 0) goto L147;
    L150:
        IntroCardLoadOpt.a.a(r110);
        goto L157
    L147:
        if (r111.h != true) goto L150;
        if (r34 == false) goto L150;
    L136:
        r37 = BDLocationException.ERROR_TIMEOUT;
    L132:
        r33 = null;
        goto L133
    L151:
        r13 = null;
        IntroCardLoadOpt.a.a(r110);
        goto L157
    L152:
        r13 = null;
        goto L157
    L122:
        r113 = true;
        goto L123
    L113:
        if (r111.e == true) goto L124;
    L110:
        if (r111.a == true) goto L124;
    L153:
        r13 = null;
        com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t r40 = this.T;
        if (r40 == null) goto L157;
        r40.b(o(), new com.bytedance.android.livesdk.livecommerce.room.model.g(o(), A().m), m(), this.V, M().f(IRelatedInfoManager$Scene.CARRY_ON_CARD));
    L65:
        L().a(false);
        goto L67
    L53:
        if (r19.v != 1) goto L57;
        if (ECLiveABUtils.INSTANCE.getENABLE_INSTANT_ROOM_QUERY_RELATED_CARD() == false) goto L57;
        RelatedInfoManager r41 = M();
        dm.a.a("LiveCardLoader").i("getInstantRoomPromotionCardLoader");
        EntryController$getInstantRoomPromotionCardLoader$relatedCardDataSource$1 r42 = EntryController$getInstantRoomPromotionCardLoader$relatedCardDataSource$1.INSTANCE;
        final qk2.a r43 = new qk2.a();
        this.V = new com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.p(r41, r42, new EntryController$getInstantRoomPromotionCardLoader$explainCardDataSource$1(r43));
        goto L57
    L42:
        r9 = null;
        goto L43
    L31:
        if (T() == false) goto L39;
        if (V() == false) goto L39;
        if (u() == false) goto L39;
        if (C().a() == false) goto L39;
        ((CartCardLinkedAnimController) o().getLinkedAnimController().getValue()).a = this.w;
        goto L39
    L9:
        if (this.W != null) goto L11;
        this.W = new ek2.b(ECLiveABUtils.INSTANCE.getINSTANT_ROOM_PRELOAD_CONFIG());
    L11:
        ek2.b r44 = this.W;
        if (r44 == null) goto L28;
        int r45 = this.U;
        CopyOnWriteArraySet<Integer> r46 = r44.a;
        if ((!r46.contains(Integer.valueOf(r45))) == true) goto L17;
        r46 = null;
    L17:
        if (r46 == null) goto L28;
        r44.a.add(Integer.valueOf(r45));
        Map<Integer, List<String>> r47 = r44.b;
        if (r47 == null) goto L28;
        List<String> r48 = r47.get(Integer.valueOf(r45));
        if (r48 == null) goto L28;
        if ((!r48.isEmpty()) == true) goto L26;
        r48 = null;
    L26:
        if (r48 == null) goto L28;
        dm.a.a("InstantPreload").i("type = " + r45 + ", preload channels " + r48);
        boolean r49 = ECPreloadGeckoChannelUtil.a;
        ECPreloadGeckoChannelUtil.b(r48, 2);
        goto L28
    L5:
        r2 = false;
        goto L6
    }

    public final void a0(boolean r14) {
        com.bytedance.android.livesdk.livecommerce.utils.p.b = r14;
        Handler r0 = UtilityKotlinExtentionsKt.b;
        com.bytedance.android.livesdk.livecommerce.utils.p.a r1 = com.bytedance.android.livesdk.livecommerce.utils.p.e;
        r0.removeCallbacks(r1);
        r0.postDelayed(r1, EComABUtils.getCheckCartStateDelay());
        ECCartMonitor.f();
        int r2 = com.bytedance.android.livesdk.livecommerce.hybrid.a.a;
        RoomContextController r3 = A().m;
        Intrinsics.checkNotNullParameter(r3, "contextControl");
        com.bytedance.android.livesdk.livecommerce.hybrid.a.a(true, r3);
        if (s() == true) goto L131;
        this.o = true;
        Unit r4 = null;
        if (r14 == true) goto L13;
        if (this.M != null) goto L9;
        this.M = new com.bytedance.android.livesdk.livecommerce.room.utils.g();
    L9:
        com.bytedance.android.livesdk.livecommerce.room.utils.g r15 = this.M;
        if (r15 == null) goto L71;
        Function0<Unit> r5 = new EntryController$onCartShow$1(this);
        int r6 = com.bytedance.android.livesdk.livecommerce.room.utils.g.c;
        r15.c("coupon", 1, true, r5);
    L71:
        if (this.w == false) goto L73;
        k0();
    L74:
        xk2.a r16 = this.u;
        if (r16 == null) goto L78;
        r16.e(true);
    L78:
        if (this.u != null) goto L80;
        xk2.a r17 = new xk2.a(o());
        this.u = r17;
        r17.b(true);
    L80:
        j0();
        if (this.k0 == false) goto L83;
        return;
    L83:
        if (u() == false) goto L133;
        this.k0 = true;
        int r18 = ECSdk.a;
        IECUserTrackerService r19 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r19 == null) goto L88;
        r19.enterPage(new of.b(m(), "live", false, null, 24));
    L88:
        IECUserTrackerService r110 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r110 == null) goto L93;
        of.a r111 = r110.getMarketingService();
        if (r111 == null) goto L93;
        r111.a("live_total_visit_seconds", PostActionType.START_DURATION, "live");
    L93:
        IECAPTService r112 = (IECAPTService) ECSdk.a(IECAPTService.class);
        if (r112 == null) goto L96;
        r112.record(new si2.h(C()));
    L96:
        com.bytedance.android.ec.adapter.api.state.a r113 = C();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L122
        cl.d r8 = com.bytedance.android.ec.sdk.helper.k.a();     // Catch: Throwable -> L122
        if (r8 == null) goto L117;
        PageFinder.via(m());     // Catch: Throwable -> L122
        Pair[] r9 = new Pair[13];     // Catch: Throwable -> L122
        r9[0] = TuplesKt.to("房间ID", r113.f);     // Catch: Throwable -> L122
        r9[1] = TuplesKt.to("主播ID", r113.g);     // Catch: Throwable -> L122
        r9[2] = TuplesKt.to("主播加密id", r113.h);     // Catch: Throwable -> L122
        r9[3] = TuplesKt.to("直播中台版本", String.valueOf(r113.o));     // Catch: Throwable -> L122
        r9[4] = TuplesKt.to("关注主播", String.valueOf(r113.i));     // Catch: Throwable -> L122
        r9[5] = TuplesKt.to("开启回放", String.valueOf(r113.j));     // Catch: Throwable -> L122
        r9[6] = TuplesKt.to("主播", String.valueOf(r113.c));     // Catch: Throwable -> L122
        r9[7] = TuplesKt.to("竖屏", String.valueOf(r113.d));     // Catch: Throwable -> L122
        Lazy r10 = Json.a;     // Catch: Throwable -> L122
        String r11 = Json.d(r113.m);     // Catch: Throwable -> L122
        String r12 = "";
        if (r11 != null) goto L103;
        r11 = "";
    L103:
        r9[8] = TuplesKt.to("进房埋点 reportParams", r11);     // Catch: Throwable -> L122
        String r13 = Json.d(r113.n);     // Catch: Throwable -> L122
        if (r13 != null) goto L106;
        r13 = "";
    L106:
        r9[9] = TuplesKt.to("临时额外变量 extra", r13);     // Catch: Throwable -> L122
        String r20 = Json.d(r113.p);     // Catch: Throwable -> L122
        if (r20 != null) goto L109;
        r20 = "";
    L109:
        r9[10] = TuplesKt.to("进房参数 enterRoomParams", r20);     // Catch: Throwable -> L122
        String r114 = Json.d(r113.t);     // Catch: Throwable -> L122
        if (r114 != null) goto L112;
        r114 = "";
    L112:
        r9[11] = TuplesKt.to("购物车入口icon", r114);     // Catch: Throwable -> L122
        String r21 = Json.d(hh2.f.b);     // Catch: Throwable -> L122
        if (r21 == null) goto L116;
        r12 = r21;
    L116:
        r9[12] = TuplesKt.to("直播间异构配置表", r12);     // Catch: Throwable -> L122
        r8.h(MapsKt.mapOf(r9));     // Catch: Throwable -> L122
    L117:
        cl.d r115 = com.bytedance.android.ec.sdk.helper.k.a();     // Catch: Throwable -> L122
        if (r115 == null) goto L120;
        int r22 = m0.a;     // Catch: Throwable -> L122
        m0.a.a.toJson(p());     // Catch: Throwable -> L122
        r115.j("ecom_live_params");     // Catch: Throwable -> L122
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L122
    L120:
        Object r116 = Result.constructor-impl(r4);     // Catch: Throwable -> L122
    L124:
        Throwable r117 = Result.exceptionOrNull-impl(r116);
        if (r117 == null) goto L127;
        ECExceptionMonitor.e(r117);
    L127:
        com.bytedance.android.livesdk.livecommerce.room.utils.d r118 = A().m.d;
        com.bytedance.android.livesdk.livecommerce.room.controller.business.f r23 = new com.bytedance.android.livesdk.livecommerce.room.controller.business.f(this);
        r118.getClass();
        Intrinsics.checkNotNullParameter(r23, "listener");
        r118.e.add(r23);
        return;
    L122:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        r116 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L124
    L133:
        return;
    L73:
        i0();
        goto L74
    L13:
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.n == true) goto L21;
        if (M1 == true) goto L21;
        if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f == false) goto L19;
        r0.post(new f(this));
        goto L21
    L19:
        W();
    L21:
        if (this.H0 == true) goto L31;
        if (EComABUtils.isEnableEnterRequest() == false) goto L31;
        this.H0 = true;
        if (w() == false) goto L28;
        boolean r119 = V();
    L29:
        dm.a.a("EntryController").i("loadEnterRoomInfo isRoomStateAttached: " + w() + " isEcom: " + r119);
        UtilityKotlinExtentionsKt.i(new EntryController$loadEnterRoomInfo$1(this, r119));
        goto L31
    L28:
        r119 = false;
    L31:
        if (w() == false) goto L66;
        if (u() == false) goto L66;
        if (this.p0 == true) goto L66;
        com.bytedance.android.ec.adapter.api.state.a r120 = C();
        Map r25 = r120.p;
        this.p0 = true;
        u1 r26 = new u1(r25);
        String r27 = "click";
        if (com.bytedance.android.livesdk.livecommerce.room.model.h.a(r120) == false) goto L39;
        String r28 = "click";
    L40:
        r26.f("action_type", r28);
        r26.k();
        xh.a r29 = xh.c.a("Live");
        Pair[] r30 = new Pair[3];
        r30[0] = TuplesKt.to("enter_room_params", r120.p);
        r30[1] = TuplesKt.to("report_params", r120.m);
        if (com.bytedance.android.livesdk.livecommerce.room.model.h.a(r120) == true) goto L44;
        r27 = "draw";
    L44:
        r30[2] = TuplesKt.to("action_type", r27);
        r29.j("live_room", "live_room", MapsKt.mapOf(r30));
        String r121 = VmSdkSetting.a().d();
        if (r121 == null) goto L53;
        String r122 = (String) r25.get("ec_room_enter_start_time");
        Map<String, String> r31 = ECLiveSchemaBuilder.l;
        if (r122 == null) goto L49;
        LinkedHashMap r32 = (LinkedHashMap) ECLiveSchemaBuilder.l;
        String r123 = (String) r32.get(r122);
        r32.clear();
    L50:
        String r33 = new JSONObject().put("enter_before", r123).put("enter_after", cd.a.c(r25).toString()).toString();
        int r124 = ECSdk.a;
        com.bytedance.android.ec.core.monitor.o r34 = (com.bytedance.android.ec.core.monitor.o) ECSdk.a(com.bytedance.android.ec.core.monitor.o.class);
        if (r34 == null) goto L53;
        r34.a(m(), "ecom_live_params", r33, "", r121);
        goto L53
    L49:
        ((LinkedHashMap) ECLiveSchemaBuilder.l).clear();
        r123 = null;
    L53:
        String r35 = (String) r25.get(LocationMonitorConst.ERROR_MSG);
        if (ECAppInfoService.e.i() == false) goto L66;
        if (r35 != null) goto L57;
    L60:
        boolean r125 = true;
    L61:
        if (r125 == true) goto L66;
        cl.d r36 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r36 == null) goto L66;
        cl.d.b.a(r36, "EC_VERIFY_ENTER_ROOM_PARAMS", r35, null, null, ErrorType.WARING, 12);
        goto L66
    L57:
        if (r35.length() == 0) goto L60;
        r125 = false;
        goto L61
    L39:
        r28 = "draw";
    L66:
        if (w() == false) goto L71;
        if (u() == false) goto L71;
        com.bytedance.android.ec.adapter.api.state.a r126 = C();
        BuildersKt.launch$default(this.a, Dispatchers.getIO(), null, new EntryController$reportAdParams$1(this, r126.m, r126, null), 2, null);
        goto L71
    }

    @Subscribe
    public final void afterAutoApplyCoupon(com.bytedance.android.livesdk.livecommerce.event.j r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        ECLiveHybridUtil.f("ecom.coupon.setApplyCouponRespV2", JSONDslUtilKt.a(new com.bytedance.android.livesdk.livecommerce.room.utils.json.a[]{JSONDslUtilKt.c("roomID", B()), JSONDslUtilKt.d("couponInfo", r4.a)}));
    }

    public final void c0(si2.e r7) {
        StringBuilder r0 = new StringBuilder("onFlashTraced hasAuth=");
        boolean r2 = true;
        if (r7.a == 0) goto L5;
        boolean r1 = true;
    L6:
        r0.append(r1);
        r0.append(" isFlashOpen=");
        r0.append(r7.b);
        r0.append(" shortcut=");
        r0.append(ECLiveEntranceMonitor.getNullStr(this.t));
        ECLiveEntranceMonitor.trace$default(r0.toString(), "EntryController", false, 4, null);
        if (s() == true) goto L9;
        return;
    L9:
        ECContext r3 = o();
        if (r3 != null) goto L12;
        return;
    L12:
        com.bytedance.live.datacontext.m<Boolean> r4 = r3.getHasFlashAuth();
        if (r7.a != 0) goto L16;
        r2 = false;
    L16:
        r4.setValue(Boolean.valueOf(r2));
        r3.isFlashOpen().setValue(Boolean.valueOf(r7.b));
        if (com.bytedance.android.livesdk.livecommerce.room.f.c(Boolean.valueOf(s())) == false) goto L20;
        return;
    L20:
        if (this.t != null) goto L23;
        ShortCutWidget r8 = new ShortCutWidget(m(), E(), r3, A().m);
        this.t = r8;
        E().L(r8, xd.d.a);
        E().L(new hk2.a(m()), xd.c.a);
        return;
    L23:
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void d(com.bytedance.android.livesdk.livecommerce.room.api.e r7) {
        Intrinsics.checkNotNullParameter(r7, "handler");
        Intrinsics.checkNotNullParameter(r7, "handler");
        this.e = true;
        boolean r0 = EComABUtils.isEnableLiveOptSlot();
        ECLiveEntranceMonitor.trace$default("onViewHandlerAttached roomId: " + B() + " enableLiveOptSlot: " + r0, "EntryController", false, 4, null);
        if (r0 == false) goto L6;
        ECLiveEntranceMonitor.trace$default("onViewHandlerAttached", "EntryController", false, 4, null);
        r7.D(new k(this, ECLiveABUtils.INSTANCE.getEC_LIVE_SHOPPING_CART_DELAY_SHOW()));
        r7.G(new j(this));
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void eCShoppingCartTaskEvent(wk.c r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        if (r7.c != 1) goto L23;
        int r0 = r7.d;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L11;
        if (r0 != 3) goto L13;
        this.Q = r7.f;
    L13:
        if (TextUtils.isEmpty(r7.e) == false) goto L15;
        return;
    L15:
        if (this.P != 2) goto L25;
        final String r8 = r7.e;
        final int r1 = com.bytedance.android.ec.sdk.helper.d.b.getIECSPService().getInt("ec_task_shopping_cart_popUp_show_times", 0);
        if (r1 >= 1) goto L26;
        View r2 = LayoutInflater.from(m()).inflate(2131560926, null);
        final ql2.e r5 = new ql2.e(m());
        r5.c = r2;
        r5.h = true;
        r5.d = false;
        r5.g = 2131953369;
        r5.a();
        FragmentActivity r3 = m();
        if (r3 == null) goto L22;
        LifecycleCoroutineScope r4 = LifecycleKt.getCoroutineScope(r3.getLifecycle());
        com.bytedance.android.livesdk.livecommerce.utils.f.a(600, r4, new EntryController$showShoppingCartTaskPopUp$$inlined$let$lambda$1(this, r8, r5, r1));
        com.bytedance.android.livesdk.livecommerce.utils.f.a(5600, r4, new EntryController$showShoppingCartTaskPopUp$$inlined$let$lambda$2(this, r8, r5, r1));
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L26:
        return;
    L25:
        return;
    L11:
        this.N = r7.a;
        this.O = r7.b;
        this.P = r0;
        goto L13
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void ecHideAllLiveDialogFragement(wk.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Activity r0 = com.bytedance.android.ec.sdk.plugin.e.getActivity(m());
        if ((!Intrinsics.areEqual(r3.a, B())) == true) goto L5;
        return;
    L5:
        if ((r0 instanceof FragmentActivity) == false) goto L49;
        List r1 = null;
        if ((r0 instanceof FragmentActivity) == true) goto L9;
        r0 = null;
    L9:
        FragmentActivity r2 = (FragmentActivity) r0;     // Catch: Throwable -> L32
        if (r2 == null) goto L14;
        FragmentManager r4 = r2.getSupportFragmentManager();     // Catch: Throwable -> L32
        if (r4 == null) goto L14;
        r1 = r4.getFragments();     // Catch: Throwable -> L32
    L14:
        if (r1 != null) goto L16;
        return;
    L16:
        if (r1.isEmpty() == true) goto L47;
        Iterator r5 = r1.iterator();     // Catch: Throwable -> L32
    L19:
        if (r5.hasNext() == false) goto L50;
        DialogFragment r6 = (Fragment) r5.next();     // Catch: Throwable -> L32
        if ((r6 instanceof DialogFragment) == false) goto L19;
        r6.dismissAllowingStateLoss();     // Catch: Exception -> L26 Throwable -> L32
    L26:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L32
        Throwable r7 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L32
        if (r7 == null) goto L19;
        com.bytedance.crash.d.d(r7, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L32
        goto L19
    L50:
        return;
    L47:
        return;
    L32:
        th = move-exception;
        ECExceptionMonitor.c(String.valueOf(th.getMessage()));
        return;
    }

    public final void h(si2.d r7) {
        Intrinsics.checkNotNullParameter(r7, "commerceEntranceData");
        ECContext r0 = o();
        if (r0 != null) goto L5;
    L17:
        ECLiveEntranceMonitor.trace$default("onInfoTraced isShowCart=" + r7.b + " isFirstLoad=" + r7.a, "EntryController", false, 4, null);
        if (r7.b != true) goto L23;
        ShoppingCart r1 = I();
        if (r1 == null) goto L22;
        com.bytedance.android.livesdk.livecommerce.room.api.e r2 = E();
        xd.i r3 = xd.i.a;
        r2.E(r1);
        this.s = r1;
    L22:
        a0(r7.a);
    L27:
        X(r7.b);
        return;
    L23:
        ShoppingCart r4 = this.s;
        if (r4 == null) goto L26;
        com.bytedance.android.livesdk.livecommerce.room.api.e r5 = E();
        xd.i r6 = xd.i.a;
        r5.C(r4);
    L26:
        Z();
        goto L27
    L5:
        if (r0.isCleared() == false) goto L7;
        ECLiveEntranceMonitor.trace$default("onInfoTraced context cleard", "EntryController", false, 4, null);
        return;
    L7:
        if (((Boolean) r0.isCartShow().getValue()).booleanValue() == true) goto L9;
    L14:
        r0.isCartShow().setValue(Boolean.valueOf(r7.b));
        goto L17
    L9:
        if (r7.b == false) goto L14;
        if (com.bytedance.android.livesdk.livecommerce.utils.p.a == false) goto L14;
        ECLiveEntranceMonitor.trace$default("onInfoTraced isCartShow=" + ((Boolean) r0.isCartShow().getValue()).booleanValue() + " isCartVisible=" + com.bytedance.android.livesdk.livecommerce.utils.p.a, "EntryController", false, 4, null);
    }

    public final void h0(String r5) {
        ECLiveEntranceMonitor.trace$default("tryInitCommerceWidget roomId: " + B() + " callFrom: " + r5 + " loadToolbar=" + this.q + " enterRoomPrepared=" + this.i + " checkRoomStatus=" + H(), "EntryController", false, 4, null);
        if (this.q == true) goto L5;
        return;
    L5:
        if (this.i == false) goto L9;
        Q();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void i(com.bytedance.android.livesdk.livecommerce.room.api.c r5) {
        Intrinsics.checkNotNullParameter(r5, "functionHandler");
        Intrinsics.checkNotNullParameter(r5, "functionHandler");
        this.f = true;
        ECLiveEntranceMonitor.trace$default("onFunctionHandlerAttached roomId: " + B(), "EntryController", false, 4, null);
    }

    public final void k(boolean r3) {
        q().c(!r3);
        if (EComABUtils.isEnableLiveOptSlot() == false) goto L5;
        return;
    L5:
        if (r3 == false) goto L9;
        ShoppingCart r4 = I();
        if (r4 == null) goto L13;
        com.bytedance.android.livesdk.livecommerce.room.api.e r0 = E();
        xd.i r1 = xd.i.a;
        r0.E(r4);
        this.s = r4;
        return;
    L13:
        return;
    L9:
        ShoppingCart r5 = this.s;
        if (r5 == null) goto L15;
        com.bytedance.android.livesdk.livecommerce.room.api.e r2 = E();
        xd.i r6 = xd.i.a;
        r2.C(r5);
        return;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onAddToShopCartSuccess(hl.b r13) {
        Intrinsics.checkNotNullParameter(r13, "event");
        if (v() == false) goto L5;
        return;
    L5:
        if (cg4.a.a(r13.n) == true) goto L7;
    L9:
        Map r0 = r13.i;
        if (r0 == null) goto L12;
        Object r1 = r0.get("buy_to_add");
    L14:
        if ((r1 instanceof Map) == true) goto L16;
        r1 = null;
    L16:
        Map r2 = (Map) r1;
        if (r2 == null) goto L31;
        Object r3 = r2.get("next_action");
        if (r3 != null) goto L21;
        return;
    L21:
        if (Intrinsics.areEqual(r3, "ONLY_TOAST") == false) goto L24;
        return;
    L24:
        if (Intrinsics.areEqual(r3, "ADD_CART_OPEN_PAGE_LIST") == false) goto L33;
        PromotionListController r4 = A().r;
        Context r5 = m();
        d r6 = new d();
        String r14 = r13.d;
        if (r14 != null) goto L28;
        r14 = "";
    L28:
        PromotionListController.N(r4, r5, "live_pop_card_buy_to_add", r6, null, false, new wj2.g.a(r14, null), null, null, 192);
        return;
    L33:
        return;
    L31:
        return;
    L12:
        r1 = null;
        goto L14
    L7:
        if ((!Intrinsics.areEqual(r13.n, B())) == false) goto L9;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onContextAttached(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = true;
        s0.c(this);
    }

    @Override // sg2.u
    public final void onPromotionsChangedWhenReceiveMsg(boolean r10) {
        String r6 = y();
        String r7 = B();
        if (r10 == false) goto L5;
    L25:
        if (r10 == true) goto L27;
    L32:
        if (r10 == false) goto L34;
        f0();
    L35:
        this.H = r10;
        return;
    L34:
        this.J = false;
        goto L35
    L27:
        if (this.H == true) goto L32;
        if (s() == false) goto L31;
        new j1(r6, r7).k();
    L31:
        Handler r0 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        this.I = SystemClock.elapsedRealtime();
        goto L32
    L5:
        if (this.H == false) goto L25;
        if (this.I <= 0) goto L25;
        if (s() == false) goto L11;
        new k1(r6, r7).k();
        long r1 = this.I;
        Handler r3 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        new l1(r6, r7, SystemClock.elapsedRealtime() - r1).k();
        goto L25
    L11:
        String r4 = l0.f();
        long r2 = this.I;
        Handler r5 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        new o1(r6, r7, r4, SystemClock.elapsedRealtime() - r2).k();
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_EVENT_ATTRIBUTION_PARAMS_UPLOAD() == false) goto L25;
        com.bytedance.android.ec.common.api.jump.model.b r8 = ControllerExtensionsKt.c(A().m, (String) o().getRoomId().getValue()).l();
        if (r8 != null) goto L16;
        r8 = com.bytedance.android.ec.common.api.jump.model.b.a;
    L16:
        sg2.v r9 = new sg2.v("livesdk_ecom_entrance_show_status", r8);
        r9.c("ecom_entrance_show_status", LogRule.REQUIRE_NO_CART);
        ShoppingCart r11 = this.s;
        if (r11 == null) goto L21;
        View r12 = r11.getViewSafe();
        if (r12 == null) goto L21;
        String r13 = BtmSDK.INSTANCE.getPageId(PageFinder.via(r12));
    L22:
        if (r13 != null) goto L24;
        r13 = "";
    L24:
        r9.j("c9398.d8575", r13);
    L21:
        r13 = null;
        goto L22
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificViewAttached(String r4) {
        Intrinsics.checkNotNullParameter(r4, "viewClassName");
        Intrinsics.checkNotNullParameter(r4, "viewClassName");
        if (M1 == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r4, "cmd_first_chat_view_loaded") == false) goto L14;
        this.L0 = true;
        if (this.P0 == false) goto L10;
        W();
        return;
    L10:
        if (this.P0 == false) goto L16;
        UtilityKotlinExtentionsKt.b.postDelayed(this.G1, 1000);
        return;
    L16:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificWidgetLoadFinished(String r4) {
        Intrinsics.checkNotNullParameter(r4, "widgetClassName");
        Intrinsics.checkNotNullParameter(r4, "widgetClassName");
        Intrinsics.checkNotNullParameter(r4, "widgetClassName");
        int r0 = com.bytedance.android.livesdk.livecommerce.intro.utils.k.a;
        com.bytedance.android.livesdk.livecommerce.intro.utils.k.c("onSpecificWidgetLoadFinished widgetClassName=" + r4 + ", isNewIntroCard=" + this.w);
        int r1 = r4.hashCode();
        if (r1 == 49) goto L36;
        if (r1 == 57) goto L24;
        if (r1 == 51) goto L15;
        if (r1 == 52) goto L12;
        return;
    L12:
        if (r4.equals("4") == false) goto L39;
        this.h1 = true;
        j0();
        return;
    L39:
        return;
    L15:
        if (r4.equals("3") == true) goto L17;
        return;
    L17:
        if (v() == false) goto L19;
        return;
    L19:
        if (this.w == false) goto L21;
        return;
    L21:
        if (this.C == true) goto L44;
        this.C = true;
        i0();
        return;
    L44:
        return;
    L24:
        if (r4.equals("9") == true) goto L26;
        return;
    L26:
        if (this.w == false) goto L47;
        this.z = true;
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_INTRO_CARD_WIDGET_LOAD_FIX() == false) goto L33;
        qh2.d r5 = this.x;
        if (r5 == null) goto L33;
        r5.v(true);
    L33:
        if (this.y == true) goto L48;
        this.y = true;
        k0();
        return;
    L48:
        return;
    L47:
        return;
    L36:
        if (r4.equals("1") == false) goto L50;
        this.q = true;
        h0("onSpecificWidgetLoadFinished");
        return;
    }

    public final void P(Map<String, String> r42, boolean r43) {
        if (this.D == false) goto L5;
        return;
    L5:
        this.D = true;
        String r6 = r42.get("jump_schema");     // Catch: Throwable -> L138
        if (r6 != null) goto L9;
        return;
    L9:
        ECEnterRoomJumpLogUtils.c(r6);     // Catch: Throwable -> L138
        Uri r7 = UriProtector.parse(r6);     // Catch: Throwable -> L138
        String r8 = B();     // Catch: Throwable -> L138
        String r9 = r7.getHost();     // Catch: Throwable -> L138
        String r10 = "";
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        ECEnterRoomJumpLogUtils.f(r8, r42, r6, r9);     // Catch: Throwable -> L138
        HashMap r11 = com.bytedance.android.ec.core.hybrid.utils.j.a;     // Catch: Throwable -> L138
        JSONObject r12 = com.bytedance.android.ec.core.hybrid.utils.j.i(UriProtector.getQueryParameter(r7, "extra"));     // Catch: Throwable -> L138
        if (r12 == null) goto L18;
        String r13 = r12.optString("promotion_id");     // Catch: Throwable -> L138
        if (r13 == null) goto L18;
        String r14 = a2.d(r13);     // Catch: Throwable -> L138
    L19:
        if (r12 == null) goto L23;
        String r15 = r12.optString("product_id");     // Catch: Throwable -> L138
        if (r15 == null) goto L23;
        String r16 = a2.d(r15);     // Catch: Throwable -> L138
    L24:
        if (r12 == null) goto L28;
        String r17 = r12.optString("sku_id");     // Catch: Throwable -> L138
        if (r17 == null) goto L28;
        String r18 = a2.d(r17);     // Catch: Throwable -> L138
    L29:
        if (r12 == null) goto L31;
        String r19 = r12.optString("detail_auto_add_to_cart");     // Catch: Throwable -> L138
    L32:
        boolean r22 = Intrinsics.areEqual(r19, "1");     // Catch: Throwable -> L138
        if (r12 == null) goto L37;
        String r110 = r12.optString("request_additions");     // Catch: Throwable -> L138
        if (r110 == null) goto L37;
        String r111 = a2.d(r110);     // Catch: Throwable -> L138
    L38:
        JSONObject r112 = com.bytedance.android.ec.core.hybrid.utils.j.i(UriProtector.getQueryParameter(r7, "live_room_info"));     // Catch: Throwable -> L138
        ShoppingCart r113 = this.s;     // Catch: Throwable -> L138
        if (r113 == null) goto L41;
        View r114 = r113.getViewSafe();     // Catch: Throwable -> L138
    L42:
        com.bytedance.android.btm.api.model.d r115 = BtmUtilsKt.e("c366460.d75972", PageFinder.via(r114));     // Catch: Throwable -> L138
        String r26 = UriProtector.getQueryParameter(r7, "passthrough_params");     // Catch: Throwable -> L138
        String r116 = UriProtector.getQueryParameter(r7, "event_params");     // Catch: Throwable -> L138
        if (r116 == null) goto L47;
        String r117 = a2.d(r116);     // Catch: Throwable -> L138
        if (r117 == null) goto L47;
        JSONObject r30 = com.bytedance.android.ec.core.hybrid.utils.j.i(r117);     // Catch: Throwable -> L138
    L48:
        if (r43 == true) goto L50;
        ((ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue()).q(B());     // Catch: Throwable -> L138
    L50:
        String r20 = r7.getHost();     // Catch: Throwable -> L138
        if (r20 != null) goto L54;
    L52:
        com.bytedance.android.btm.api.model.d r118 = r115;
    L132:
        com.bytedance.android.ec.sdk.helper.p.a.openSchema(m(), BtmUtilsKt.b(r6, r118));     // Catch: Throwable -> L138
        String r0 = B();     // Catch: Throwable -> L138
        String r2 = r7.getHost();     // Catch: Throwable -> L138
        if (r2 == null) goto L136;
        r10 = r2;
    L136:
        ECEnterRoomJumpLogUtils.a(r0, r10);     // Catch: Throwable -> L138
        return;
    L54:
        switch(r20.hashCode()) {
            case -2132228688: goto L85;
            case -1869906124: goto L81;
            case -1684758071: goto L78;
            case -605081373: goto L72;
            case 1325153974: goto L57;
            default: goto L52;
        };     // Catch: Throwable -> L138
    L78:
        com.bytedance.android.btm.api.model.d r3 = r115;
        if (r20.equals("ec_live_ai_im") == false) goto L84;
        A().y.J(r7);     // Catch: Throwable -> L138
        return;
    L84:
        r118 = r3;
        goto L132
    L81:
        r3 = r115;
        if (r20.equals("ec_live_buy") == false) goto L84;
        IronNavigator r4 = IronNavigator.a;     // Catch: Throwable -> L138
        Context r119 = m();     // Catch: Throwable -> L138
        String r120 = B();     // Catch: Throwable -> L138
        String r121 = y();     // Catch: Throwable -> L138
        String r122 = z();     // Catch: Throwable -> L138
        l0.b(r42);     // Catch: Throwable -> L138
        bk2.b r21 = (bk2.b) o().getDisposableContext().getValue();     // Catch: Throwable -> L138
        r4.getClass();     // Catch: Throwable -> L138
        IronNavigator.e(r119, r14, r120, r121, r122, r26, r111, r3, r21);     // Catch: Throwable -> L138
        return;
    L85:
        r118 = r115;
        if (r20.equals("ec_live_list") == false) goto L132;
        IronNavigator r23 = IronNavigator.a;     // Catch: Throwable -> L138
        if (r12 == null) goto L91;
        String r123 = r12.optString("related_info");     // Catch: Throwable -> L138
    L92:
        String r124 = r42.get("live_list_channel");     // Catch: Throwable -> L138
        String r5 = UriProtector.getQueryParameter(r7, "source_btm_token");     // Catch: Throwable -> L138
        r23.getClass();     // Catch: Throwable -> L138
        IronNavigator.c(r123, r124, r5, r112);     // Catch: Throwable -> L138
        if (r12 == null) goto L104;
        String r24 = r12.optString("related_info");     // Catch: Throwable -> L138
        if (r24 == null) goto L104;
        if (cg4.a.a(r24) == true) goto L100;
        r24 = null;
    L100:
        if (r24 == null) goto L104;
        A().getClass();     // Catch: Exception -> L103 Throwable -> L138
        M().i(r24, IRelatedInfoManager$FromSource.JUMP_SCHEMA);     // Catch: Exception -> L103 Throwable -> L138
    L103:
        ECExceptionMonitor.c("encode relatedInfo failure!");     // Catch: Throwable -> L138
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L138
    L104:
        PromotionListController r27 = A().r;     // Catch: Throwable -> L138
        Context r28 = m();     // Catch: Throwable -> L138
        String r1 = r42.get("live_list_channel");     // Catch: Throwable -> L138
        if (r1 != null) goto L112;
        if (r26 == null) goto L110;
        HashMap r29 = com.bytedance.android.ec.core.hybrid.utils.j.a;     // Catch: Throwable -> L138
        JSONObject r31 = com.bytedance.android.ec.core.hybrid.utils.j.i(r26);     // Catch: Throwable -> L138
        if (r31 == null) goto L110;
        r1 = r31.optString("live_list_channel");     // Catch: Throwable -> L138
    L110:
        r1 = null;
    L112:
        if (r43 == true) goto L114;
        boolean r32 = true;
    L115:
        si2.b r33 = new si2.b(r1, true, r32);     // Catch: Throwable -> L138
        if (r14 != null) goto L118;
        String r210 = r16;
    L119:
        if (r14 == null) goto L121;
        boolean r211 = true;
    L122:
        String r34 = UriProtector.getQueryParameter(r7, "source_btm_token");     // Catch: Throwable -> L138
        if (r34 == null) goto L126;
        String r35 = a2.d(r34);     // Catch: Throwable -> L138
        if (r35 == null) goto L126;
    L127:
        String r212 = r35;
        if (r112 == null) goto L130;
        c r213 = new c(r112);     // Catch: Throwable -> L138
    L131:
        PromotionListController.N(r27, r28, "schema", r33, new PromotionListController.c(r210, r211, r26, null, r212, r213, r30, null, 136), false, null, new EntryController$handleNewEcomLiveParams$4(this), null, 176);     // Catch: Throwable -> L138
        int r36 = ECEnterRoomJumpLogUtils.a;     // Catch: Throwable -> L138
        ECEnterRoomJumpLogUtils.a(B(), "ec_live_list");     // Catch: Throwable -> L138
        return;
    L130:
        r213 = null;
    L126:
        r35 = BtmSDK.INSTANCE.createJumpSourceBtmToken(r118);     // Catch: Throwable -> L138
        goto L127
    L121:
        r211 = false;
        goto L122
    L118:
        r210 = r14;
        goto L119
    L114:
        r32 = false;
        goto L115
    L91:
        r123 = null;
        goto L92
    L57:
        if (r20.equals("ec_live_im") == false) goto L52;
        if (r12 == null) goto L144;
        String r37 = r12.optString("schema");     // Catch: Throwable -> L138
        if (r37 == null) goto L145;
        String r38 = a2.d(r37);     // Catch: Throwable -> L138
        if (r38 == null) goto L146;
        String r39 = Uri.decode(r38);     // Catch: Throwable -> L138
        String r40 = r12.optString("scene");     // Catch: Throwable -> L138
        if (Intrinsics.areEqual(r40, "comment_association") == true) goto L67;
        r40 = null;
    L67:
        if (r40 == null) goto L69;
        com.bytedance.android.btm.api.model.d r41 = BtmUtilsKt.e("c57545.d76690", PageFinder.via(BtmSDK.INSTANCE.getCurrentResumedPage()));     // Catch: Throwable -> L138
    L70:
        A().x.J(r39, r41);     // Catch: Throwable -> L138
        return;
    L69:
        r41 = null;
        goto L70
    L146:
        return;
    L145:
        return;
    L144:
        return;
    L72:
        if (r20.equals("ec_live_detail") == false) goto L52;
        Context r125 = m();     // Catch: Throwable -> L138
        String r126 = B();     // Catch: Throwable -> L138
        JSONObject r44 = l0.b(r42);     // Catch: Throwable -> L138
        if (r26 == null) goto L76;
        JSONObject r127 = com.bytedance.android.ec.core.hybrid.utils.j.i(r26);     // Catch: Throwable -> L138
    L77:
        String r128 = r14;
        IronNavigator.f(r125, r126, r128, r16, r18, r44, r127, r111, r115, (bk2.b) o().getDisposableContext().getValue(), r22);     // Catch: Throwable -> L138
        return;
    L76:
        r127 = null;
    L47:
        r30 = null;
        goto L48
    L41:
        r114 = null;
    L37:
        r111 = null;
        goto L38
    L31:
        r19 = null;
    L28:
        r18 = null;
    L23:
        r16 = null;
    L18:
        r14 = null;
    L138:
        th = move-exception;
        ECExceptionMonitor.e(th);
    }

    public final void b0(boolean r7, boolean r8) {
        ECContext r0 = o();
        if (r0.isCleared() == false) goto L5;
        ECLiveEntranceMonitor.trace$default("onCartStateChanged context cleard", "EntryController", false, 4, null);
        return;
    L5:
        if (((Boolean) r0.isCartShow().getValue()).booleanValue() == false) goto L11;
        if (r7 == false) goto L11;
        if (com.bytedance.android.livesdk.livecommerce.utils.p.a == false) goto L11;
        ECLiveEntranceMonitor.trace$default("onCartStateChanged isCartShow=" + ((Boolean) r0.isCartShow().getValue()).booleanValue() + " isCartVisible=" + com.bytedance.android.livesdk.livecommerce.utils.p.a, "EntryController", false, 4, null);
        return;
    L11:
        r0.isCartShow().setValue(Boolean.valueOf(r7));
        if (v() == true) goto L16;
        ECLivePerformanceMonitor.b r1 = ECLivePerformanceMonitor.x;
        ECLivePerformanceMonitor r2 = ECLivePerformanceMonitor.c.a(B(), D());
        if (r2 == null) goto L16;
        r2.p(0, r7);
    L16:
        sg2.y r3 = A().m.c;
        if (r3 == null) goto L19;
        r3.b(r7);
    L19:
        ECLiveEntranceMonitor.trace$default("onCartStateChanged isShowCart=" + r7 + " isFirstLoad=" + r8 + " isAnchor=" + s() + " roomId=" + B(), "EntryController", false, 4, null);
        if (r8 == false) goto L29;
        y();
        z();
        B();
        this.H = r7;
        if (r7 == false) goto L25;
        Handler r4 = com.bytedance.android.livesdk.livecommerce.utils.k.a;
        this.I = SystemClock.elapsedRealtime();
        f0();
    L25:
        if (s() == false) goto L34;
        if (r7 == false) goto L34;
        String r5 = y();
        String r6 = z();
        String r9 = B();
        CompositeDisposable r10 = CoreRequests.a;
        CoreRequests.e(r5, r6, r9, D(), new com.bytedance.android.livesdk.livecommerce.room.controller.business.g(this, r5, r9));
        CoreRequests.c(new com.bytedance.android.livesdk.livecommerce.room.controller.business.h(this));
    L34:
        if (r7 != true) goto L36;
        a0(r8);
    L37:
        X(r7);
        com.bytedance.android.livesdk.livecommerce.kmp.b r11 = A().w;
        if (s() == true) goto L47;
        if (r7 == false) goto L48;
        if (r8 == true) goto L42;
        return;
    L42:
        if (xh2.a.a() != 0) goto L50;
        A().r.O("cart_entrance");
        return;
    L50:
        return;
    L48:
        return;
    L47:
        return;
    L36:
        Z();
        goto L37
    L29:
        if (s() == true) goto L32;
        if (r7 == true) goto L32;
        JSONObject r12 = new JSONObject();
        r12.put("room_id", B());
        r12.put("room_unique_key", D());
        Unit r13 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ec.live.didHideShopCart", r12);
    L32:
        onPromotionsChangedWhenReceiveMsg(r7);
        goto L34
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void c(Context r2, com.bytedance.android.ec.adapter.api.state.a r3) {
        super.c(r2, r3);
        com.bytedance.android.livesdk.livecommerce.view.countdown.d.a.a.a();
        this.l = 0;
        this.j = null;
        s0.e(this);
        if (s() == false) goto L6;
        LynxAnchorPromotionListUtils.a();
    L6:
        if (ECLiveABUtils.INSTANCE.getEC_LIVE_LYNX_NOTIFY_LIVE_EVENT() == false) goto L9;
        JSONObject r4 = new JSONObject();
        com.bytedance.android.shopping.extensions.k.l(r4, "room_id", B());
        com.bytedance.android.shopping.extensions.k.l(r4, "room_unique_key", D());
        Unit r5 = Unit.INSTANCE;
        ECLiveHybridUtil.f("ec.live.didFinishedRoom", r4);
        return;
    }

    public final void d0(final Context r8, final View r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "shoppingCartView");
        final String r4 = y();
        final String r5 = B();
        com.bytedance.android.ec.core.widget.f.c(r9, null, "bind_key_live_cart_card", new EntryController$onLoadShoppingCartView$1(this, r8, r4, r5, r9), 1);
        cl.d r10 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r10 == null) goto L5;
        r9.setOnLongClickListener(new g(r10));
    L5:
        this.E = r9;
    }

    public final void l0(String r15, LiveRoomRedirectPriority r16) {
        LiveRoomRedirectInfo.f.getClass();
        Map r3 = LiveRoomRedirectInfo.a.a(r15);
        if (r3 != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.livecommerce.ability.f r9 = new com.bytedance.android.livesdk.livecommerce.ability.f("LiveBase", "redirect_api_path", new LiveRoomRedirectInfo(r15, r3, r16, 0));
        if (u() == false) goto L9;
        Lazy r0 = LiveDynamicContext.c;
        com.bytedance.android.livesdk.livecommerce.ability.b.a.a(LiveDynamicContext.a.a().a(), m(), r9, A().m, null, null, 24);
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificBehaviorUnload(String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r4, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r4, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r4, "behaviorClassName");
        if (S(r4) == false) goto L6;
        ECLiveEntranceMonitor.trace$default("onSpecificBehaviorUnload behaviorClassName=" + r4 + " isFold=" + r5 + " isFromMsg=" + r6, "EntryController", false, 4, null);
        boolean r7 = r6 ^ true;
        b0(false, r7);
        boolean r8 = ECCartMonitor.a;
        ECCartMonitor.a(new z0(false, r7));
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onSpecificBehaviorLoad(String r5, boolean r6, boolean r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "behaviorClassName");
        Intrinsics.checkNotNullParameter(r8, "extraData");
        super.onSpecificBehaviorLoad(r5, r6, r7, r8);
        if (S(r5) == false) goto L25;
        i r3 = null;
        ECLiveEntranceMonitor.trace$default("onSpecificBehaviorLoad behaviorClassName=" + r5 + " isFold=" + r6 + " isFromMsg=" + r7 + " initCommerceWidget=" + this.p + " extra: " + r8, "EntryController", false, 4, null);
        if (cg4.a.a(r8) == true) goto L7;
    L13:
        if (r7 == false) goto L19;
        this.B = true;
        ECLivePerformanceMonitor r9 = (ECLivePerformanceMonitor) o().getEcLivePerformanceMonitor().getValue();
        if (r9.q == true) goto L19;
        String r10 = r9.p;
        if (r10 == null) goto L19;
        ((HashMap) com.bytedance.android.ec.core.monitor.c.a).remove(r10);
        r9.p = null;
    L19:
        boolean r11 = ECCartMonitor.a;
        ECCartMonitor.a(new z0(true, !r7));
        i r12 = new i(this, r6, r7);
        if (this.p == false) goto L22;
        r12.run();
    L23:
        this.S = r3;
        return;
    L22:
        r3 = r12;
        goto L23
    L7:
        if ((!Intrinsics.areEqual(r8, "null")) == false) goto L13;
        HashMap r13 = com.bytedance.android.ec.core.hybrid.utils.j.a;
        JSONObject r14 = com.bytedance.android.ec.core.hybrid.utils.j.i(r8);
        if (r14 == null) goto L11;
        String r15 = r14.optString("route_rule");
    L12:
        l0(r15, LiveRoomRedirectPriority.TOOL_BAR_CONTROL_MESSAGE);
        goto L13
    L11:
        r15 = null;
        goto L12
    }
}
