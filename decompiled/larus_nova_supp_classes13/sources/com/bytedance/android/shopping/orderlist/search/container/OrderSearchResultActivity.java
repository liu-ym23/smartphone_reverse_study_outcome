package com.bytedance.android.shopping.orderlist.search.container;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.core.utils.i0;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.host.api.service.IECHostService;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.base.event.EventActionImpl;
import com.bytedance.android.shopping.orderlist.common.controller.OrderBottomBarHandler;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonPageConfig;
import com.bytedance.android.shopping.orderlist.common.controller.OrderCommonTemplateManager;
import com.bytedance.android.shopping.orderlist.common.eventcenter.core.OrderCommonEventCenter;
import com.bytedance.android.shopping.orderlist.common.freq.OrderFreqControlManager;
import com.bytedance.android.shopping.orderlist.common.freq.OrderFreqControlManager$frequencyProcess$1;
import com.bytedance.android.shopping.orderlist.common.monitor.business.OrderCommonBusinessMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.error.OrderCommonErrorMonitorKt;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.FirstScreenPoint;
import com.bytedance.android.shopping.orderlist.common.monitor.firstscreen.OrderCommonFirstScreenMonitor;
import com.bytedance.android.shopping.orderlist.common.monitor.fps.OrderCommonDropFrameMonitor;
import com.bytedance.android.shopping.orderlist.common.utils.OrderAppletPageScene;
import com.bytedance.android.shopping.orderlist.common.utils.OrderCommonLog;
import com.bytedance.android.shopping.orderlist.common.utils.k;
import com.bytedance.android.shopping.orderlist.common.utils.o;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonHeadBarView;
import com.bytedance.android.shopping.orderlist.common.widgets.state.OrderCommonMaskView;
import com.bytedance.android.shopping.orderlist.search.starter.OrderSearchResultParams;
import com.bytedance.android.shopping.orderlist.search.viewmodel.OrderSearchResultViewModel;
import com.bytedance.android.shopping.orderlist.search.widget.linkedlist.OrderSearchResultLinkedScrollView;
import com.bytedance.android.shopping.orderlist.search.yata.ability.OrderSearchResultDefaultAbilityProvider;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.yata.init.AndroidYataBuilderManager;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.IdentitySubscriber;
import com.bytedance.jedi.arch.JediView;
import com.bytedance.jedi.arch.JediViewModel;
import com.bytedance.jedi.arch.LifecycleOwnerHolder;
import com.bytedance.jedi.arch.Middleware;
import com.bytedance.jedi.arch.ReceiverHolder;
import com.bytedance.jedi.arch.State;
import com.bytedance.jedi.arch.SubscriptionConfig;
import com.bytedance.jedi.arch.Tuple1;
import com.bytedance.jedi.arch.Tuple2;
import com.bytedance.jedi.arch.Tuple3;
import com.bytedance.jedi.arch.Tuple4;
import com.bytedance.jedi.arch.Tuple5;
import com.bytedance.jedi.arch.ViewModelFactoryOwner;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u0007:\u0001\u000eB\u0007¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/search/container/OrderSearchResultActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Lcom/bytedance/android/shopping/orderlist/common/controller/f;", "Leg3/a;", "Lc53/d;", "Lcom/bytedance/android/shopping/orderlist/search/starter/a;", "event", "", "onOrderSearchResultQuerySuccess", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderSearchResultActivity extends AbsActivity implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, com.bytedance.android.shopping.orderlist.common.controller.f, eg3.a, c53.d {
    public static final /* synthetic */ int F = 0;
    public final Lazy A;
    public ig3.a B;
    public OrderCommonDropFrameMonitor C;
    public OrderCommonDropFrameMonitor D;
    public final /* synthetic */ c53.b E;
    public Map<Integer, View> j;
    public final ReflectViewModelFactory k;
    public final lifecycleAwareLazy l;
    public com.bytedance.kmp.ec.yata.view.render.delegate.v2.a m;
    public AndroidYaTaInstance n;
    public SlcRenderContext o;
    public OrderSearchResultEventCenter p;
    public final Lazy q;
    public boolean r;
    public final List<Function0<Unit>> s;
    public OrderSearchRequestType t;
    public ImmersionBar u;
    public OrderSearchResultLinkedScrollView v;
    public View w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.android.shopping.orderlist.search.container.a G1() {
        return (com.bytedance.android.shopping.orderlist.search.container.a) this.A.getValue();
    }

    public final OrderSearchResultStateController H1() {
        return (OrderSearchResultStateController) this.y.getValue();
    }

    public final OrderSearchResultViewModel I1() {
        return (OrderSearchResultViewModel) this.l.getValue();
    }

    @Override // eg3.a
    public final OrderBottomBarHandler Md() {
        return null;
    }

    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.E.add(r2);
        return r2;
    }

    public final void doClear() {
        this.E.doClear();
    }

    public final void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.E.remove(r2);
    }

    @Override // eg3.a
    public final OrderCommonBusinessMonitor T50() {
        ig3.a r0 = this.B;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.c;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0114 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        Lazy r2 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultActivity", AnonymousClass1.INSTANCE);
        super.finish();
        overridePendingTransition(0, 2130772248);
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r3 = FLogger.a;
        r3.i("ActivityLancet", "finish ".concat(OrderSearchResultActivity.class.getName()));
        long r4 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r4));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r3.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r3.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r3.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r3.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r3.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r3.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r4 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(OrderSearchResultActivity.class.getName()));
    L5:
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onDestroy", new C03091(this));
    }

    public final void onPause() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultActivity", C03111.INSTANCE);
        super.onPause();
        k r1 = (k) this.z.getValue();
        r1.getClass();
        i0 r2 = i0.f;
        i0.b.remove(r1.c);
        Context r3 = r1.c;
        r2.getClass();
        i0.b(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onRestart() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultActivity", C03121.INSTANCE);
        super/*android.app.Activity*/.onRestart();
    }

    public final void onResume() {
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultActivity", C03131.INSTANCE);
        super.onResume();
        k r1 = (k) this.z.getValue();
        r1.getClass();
        i0 r2 = i0.f;
        i0.b.put(r1.c, r1.a);
        Context r3 = r1.c;
        r2.getClass();
        i0.a(r3);
    }

    public OrderSearchResultActivity() {
        this.E = new c53.b();
        this.j = new LinkedHashMap();
        this.k = new ReflectViewModelFactory();
        final KClass r0 = Reflection.getOrCreateKotlinClass(OrderSearchResultViewModel.class);
        final OrderSearchResultActivity$$special$$inlined$viewModel$1 r1 = OrderSearchResultActivity$$special$$inlined$viewModel$1.INSTANCE;
        this.l = new lifecycleAwareLazy(this, new OrderSearchResultActivity$$special$$inlined$viewModel$2(this, r0, r1, r0));
        this.q = LazyKt.lazy(new OrderSearchResultActivity$yataAbilityProvider$2(this));
        this.r = true;
        this.s = new ArrayList();
        this.t = OrderSearchRequestType.FIRST_REQUEST;
        this.x = LazyKt.lazy(new OrderSearchResultActivity$freqManager$2(this));
        this.y = LazyKt.lazy(new OrderSearchResultActivity$stateController$2(this));
        this.z = LazyKt.lazy(new OrderSearchResultActivity$screenShotComponent$2(this));
        this.A = LazyKt.lazy(new OrderSearchResultActivity$refreshHelper$2(this));
    }

    public final LifecycleOwner getLifecycleOwner() {
        return JediView.DefaultImpls.getLifecycleOwner(this);
    }

    public final LifecycleOwnerHolder getLifecycleOwnerHolder() {
        return JediView.DefaultImpls.getLifecycleOwnerHolder(this);
    }

    public final IReceiver getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public final ReceiverHolder<IdentitySubscriber> getReceiverHolder() {
        return JediView.DefaultImpls.getReceiverHolder(this);
    }

    public final boolean getUniqueOnlyGlobal() {
        return JediView.DefaultImpls.getUniqueOnlyGlobal(this);
    }

    public final void onStart() {
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onStart", new C03151(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onStop", new C03161(this));
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public final void y1() {
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-setStatusBarColor", new OrderSearchResultActivity$setStatusBarColor$1(this));
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.k;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m2362getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public static final /* synthetic */ void C1(OrderSearchResultActivity r0) {
        super.onStart();
    }

    public static final /* synthetic */ void D1(OrderSearchResultActivity r0) {
        super.onStop();
    }

    public static final /* synthetic */ void F1(OrderSearchResultActivity r0) {
        super.y1();
    }

    public static final /* synthetic */ void z1(OrderSearchResultActivity r0) {
        super.onDestroy();
    }

    public final void K1(SlcRenderContext r3) {
        if (r3 == null) goto L4;
        r3.f = OrderCommonPageConfig.b(false);
    L4:
        if (r3 == null) goto L6;
        Lazy r0 = OrderCommonPageConfig.a;
        r3.j = ECSettingKeys.F().getClickDebounceSwitch();
    L6:
        if (r3 == null) goto L9;
        Lazy r1 = OrderCommonPageConfig.a;
        r3.k = ECSettingKeys.F().getClickDebounceDuration();
    L9:
        if (r3 == null) goto L11;
        r3.g = true;
    L11:
        if (r3 == null) goto L13;
        r3.y = true;
    L13:
        if (r3 == null) goto L16;
        r3.p(MapsKt.mapOf(TuplesKt.to("system_font_scale", Float.valueOf(com.bytedance.android.shopping.extensions.k.e(ECAppInfoService.e.getCurrentFontScale(), 1.0f)))));
        return;
    }

    @Override // com.bytedance.android.shopping.orderlist.common.controller.f
    public final void PC(final boolean r3) {
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onUpScreenFinish", new OrderSearchResultActivity$onUpScreenFinish$1(this, r3));
    }

    public final View _$_findCachedViewById(int r3) {
        if (this.j != null) goto L5;
        this.j = new LinkedHashMap();
    L5:
        View r0 = this.j.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.j.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public final Disposable ignore(Disposable r3) {
        Intrinsics.checkNotNullParameter(r3, "disposable");
        this.E.getClass();
        Intrinsics.checkNotNullParameter(r3, "disposable");
        return r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        Lazy r0 = OrderCommonLog.a;
        OrderCommonLog.c("OrderSearchResultActivity", OrderSearchResultActivity$initData$1.INSTANCE);
        Intent r1 = getIntent();
        Map<String, String> r2 = null;
        if (r1 == null) goto L15;
        Bundle r3 = r1.getExtras();
        if (r3 == null) goto L15;
        String r4 = r3.getString("PrefetchSessionId");
    L16:
        I1().getStaticState().c = r4;
        int r5 = ECSdk.a;
        IECHostService r6 = (IECHostService) ECSdk.a(IECHostService.class);
        if (r6 == null) goto L19;
        com.bytedance.android.shopping.orderlist.common.utils.b r7 = com.bytedance.android.shopping.orderlist.common.utils.e.a(r6, OrderAppletPageScene.PAGE_INTERNAL);
        I1().getStaticState().d = r7.a;
        I1().getStaticState().e = Boolean.valueOf(r7.b);
    L19:
        Intent r8 = getIntent();
        if (r8 == null) goto L24;
        Bundle r9 = r8.getExtras();
        if (r9 == null) goto L24;
        Object r11 = r9.get("ORDER_SEARCH_PARAM");
    L26:
        if ((r11 instanceof OrderSearchResultParams) == true) goto L28;
        r11 = null;
    L28:
        OrderSearchResultParams r12 = (OrderSearchResultParams) r11;
        BtmSDK r13 = BtmSDK.INSTANCE;
        if (r12 == null) goto L31;
        String r14 = r12.getSourceBtmToken();
    L32:
        r13.registerBtmPageOnCreate(this, "a1.b5418.c0.d0", r14);
        if (r12 == null) goto L35;
        I1().getStaticState().g = r12;
    L35:
        Intent r15 = getIntent();
        if (r15 == null) goto L40;
        Bundle r16 = r15.getExtras();
        if (r16 == null) goto L40;
        Object r17 = r16.get("ORDER_SEARCH_LOAD_AGAIN");
    L42:
        if ((r17 instanceof Boolean) == true) goto L44;
        r17 = null;
    L44:
        Boolean r18 = (Boolean) r17;
        if (r18 == null) goto L47;
        I1().getStaticState().a = r18.booleanValue();
    L47:
        I1().setBtmPageFinder(PageFinder.via(r13.getPageId(PageFinder.via(this))));
        Map<String, ig3.a> r19 = ig3.a.h;
        this.B = ig3.a.C0206a.a(I1().getStaticState().c);
        MonitorScenes r20 = MonitorScenes.ORDER_LIST_PAGE;
        this.C = new OrderCommonDropFrameMonitor(r20, "gul");
        this.D = new OrderCommonDropFrameMonitor(r20, "yata");
        ig3.a r21 = this.B;
        if (r21 == null) goto L52;
        OrderCommonFirstScreenMonitor r22 = r21.a;
        if (r22 == null) goto L52;
        r22.a(FirstScreenPoint.CONTAINER_INIT_END);
    L52:
        ig3.a r23 = this.B;
        if (r23 == null) goto L57;
        OrderCommonFirstScreenMonitor r24 = r23.a;
        if (r24 == null) goto L57;
        r24.a(FirstScreenPoint.PAGE_INIT_START);
    L57:
        ig3.a r25 = this.B;
        if (r25 == null) goto L62;
        OrderCommonFirstScreenMonitor r26 = r25.a;
        if (r26 == null) goto L62;
        r26.f(MapsKt.emptyMap(), this);
    L62:
        I1().doFirstScreenQuery(this, this.B);
        OrderCommonTemplateManager.b("yata_order_search_result", this);
        OrderCommonTemplateManager.a();
        overridePendingTransition(2130772267, 2130772253);
        super.onCreate(r10);
        setContentView(2131564137);
        Lazy r110 = UIUtils.a;
        UIUtils.g(getWindow(), "#F5F6F9");
        this.v = (OrderSearchResultLinkedScrollView) findViewById(2131381642);
        this.w = findViewById(2131381639);
        ig3.a r111 = this.B;
        if (r111 == null) goto L68;
        OrderCommonFirstScreenMonitor r112 = r111.a;
        if (r112 == null) goto L68;
        r112.a(FirstScreenPoint.YATA_INIT_START);
    L68:
        if (ECSettingKeys.G() == false) goto L70;
        int r113 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.e;
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r114 = com.bytedance.kmp.ec.yata.view.render.delegate.v2.a.a.a(this, "yata_order_search_result");
        K1(this.o);
        Unit r27 = Unit.INSTANCE;
        this.m = r114;
    L70:
        OrderCommonLog.c("OrderSearchResultActivity", OrderSearchResultActivity$initYataInstance$1.INSTANCE);
        int r115 = AndroidYataBuilderManager.a;
        com.bytedance.kmp.ec.yata.b r116 = AndroidYataBuilderManager.a("yata_order_search_result", (OrderSearchResultDefaultAbilityProvider) this.q.getValue(), this.m, null, OrderSearchResultActivity$initYataInstance$2.INSTANCE);
        com.bytedance.kmp.ec.yata.b.c(r116, (LinearLayout) findViewById(2131381644));
        OrderSearchResultLinkedScrollView r28 = this.v;
        if (r28 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L73:
        com.bytedance.kmp.ec.yata.b.a(r116, r28.getYataRecyclerView());
        com.bytedance.kmp.ec.yata.b.b(r116, (LinearLayout) findViewById(2131381643));
        AndroidYaTaInstance r117 = r116.a;
        this.n = r117;
        if (r117 == null) goto L76;
        SlcRenderContext r118 = (SlcRenderContext) r117.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
    L77:
        this.o = r118;
        if (ECSettingKeys.G() == true) goto L80;
        K1(this.o);
    L80:
        ig3.a r119 = this.B;
        if (r119 == null) goto L85;
        OrderCommonFirstScreenMonitor r120 = r119.a;
        if (r120 == null) goto L85;
        r120.a(FirstScreenPoint.YATA_INIT_END);
    L85:
        OrderCommonLog.c("OrderSearchResultActivity", OrderSearchResultActivity$initTracker$1.INSTANCE);
        lg3.a r121 = I1().getTracker();
        String r29 = I1().getStaticState().c;
        if (r29 != null) goto L88;
        r29 = "no_session";
    L88:
        boolean r30 = I1().getStaticState().a;
        OrderSearchResultParams r31 = I1().getStaticState().g;
        AndroidYaTaInstance r32 = this.n;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r29, "sessionId");
        new WeakReference(r32);
        EventActionImpl r122 = r121.a;
        Pair[] r33 = new Pair[4];
        r33[0] = TuplesKt.to("session_id", r29);
        r33[1] = TuplesKt.to("is_activity_reload", Boolean.valueOf(r30));
        if (r31 == null) goto L91;
        String r34 = r31.getEnterFrom();
    L92:
        r33[2] = TuplesKt.to(SimilarProductParam.ENTER_FROM, r34);
        if (r31 == null) goto L97;
        Map<String, String> r35 = r31.getSchemaParamsMap();
        if (r35 == null) goto L97;
        String r36 = r35.get("history_path");
    L98:
        if (r36 != null) goto L100;
    L103:
        boolean r37 = true;
    L104:
        if (r37 == false) goto L108;
        if (r31 == null) goto L107;
        r36 = r31.getEnterFrom();
        goto L108
    L107:
        r36 = null;
    L108:
        r33[3] = TuplesKt.to("previous_page", r36);
        r122.appendEventParams(MapsKt.mapOf(r33));
        ig3.a r123 = this.B;
        if (r123 == null) goto L111;
        r123.c = new OrderCommonBusinessMonitor(new WeakReference(I1().getTracker()));
    L111:
        ig3.a r124 = this.B;
        if (r124 == null) goto L114;
        r124.d = new hg3.b(new WeakReference(I1().getTracker()), null);
    L114:
        OrderFreqControlManager r125 = (OrderFreqControlManager) this.x.getValue();
        AndroidYaTaInstance r38 = this.n;
        r125.getClass();
        if (r38 == null) goto L117;
        r38.c(new OrderFreqControlManager$frequencyProcess$1(r125));
    L117:
        OrderCommonLog.c("OrderSearchResultActivity", OrderSearchResultActivity$initFunctionRegister$1.INSTANCE);
        OrderSearchResultViewModel r39 = I1();
        AndroidYaTaInstance r40 = this.n;
        OrderSearchResultLinkedScrollView r41 = this.v;
        if (r41 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L120:
        OrderSearchResultEventCenter r126 = new OrderSearchResultEventCenter(this, r39, r40, r41);
        this.p = r126;
        OrderCommonEventCenter r127 = r126.b;
        if (r127 == null) goto L123;
        r127.a();
    L123:
        OrderCommonLog.c("OrderSearchResultActivity", OrderSearchResultActivity$initView$1.INSTANCE);
        OrderSearchResultLinkedScrollView r128 = this.v;
        if (r128 != null) goto L126;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L126:
        r128.a("OrderSearchResultActivity", new OrderSearchResultActivity$initView$2(this));
        OrderCommonLog.c("OrderSearchResultActivity", OrderSearchResultActivity$initClick$1.INSTANCE);
        wg.a.h(_$_findCachedViewById(2131368571), ECAppInfoService.e.i());
        ((TextView) _$_findCachedViewById(2131368571)).setOnClickListener(b.a);
        View r129 = this.w;
        if (r129 == null) goto L129;
        r129.setOnClickListener(new OrderSearchResultActivity$initClick$3(this));
    L129:
        ((OrderCommonHeadBarView) _$_findCachedViewById(2131381646)).setStyle(OrderCommonHeadBarView.HeadBarStyle.ORDER_SEARCH_RESULT);
        ((OrderCommonHeadBarView) _$_findCachedViewById(2131381646)).setClickIconBackListener(new OrderSearchResultActivity$initClick$4(this));
        ((OrderCommonMaskView) _$_findCachedViewById(2131381648)).setOnClickListener(new c(this));
        OrderSearchResultLinkedScrollView r130 = this.v;
        if (r130 != null) goto L132;
        Intrinsics.throwUninitializedPropertyAccessException("linkedScrollView");
    L132:
        r130.setErrorRetryListener(new OrderSearchResultActivity$initClick$6(this));
        sA(false, null);
        s0.c(this);
        if (ECSettingKeys.I() == true) goto L141;
        OrderSearchResultEventCenter r131 = this.p;
        if (r131 == null) goto L141;
        OrderCommonEventCenter r132 = r131.b;
        if (r132 == null) goto L141;
        com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c r133 = (com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge.c) r132.a.getValue();
        if (r133 == null) goto L141;
        r133.preload();
    L141:
        ig3.a r134 = this.B;
        if (r134 == null) goto L146;
        OrderCommonFirstScreenMonitor r135 = r134.a;
        if (r135 == null) goto L146;
        r135.a(FirstScreenPoint.PAGE_INIT_END);
    L146:
        lg3.a r136 = I1().getTracker();
        if (r136.b == true) goto L160;
        r136.b = true;
        OrderSearchResultParams r42 = r136.d.getStaticState().g;
        if (r42 == null) goto L152;
        r2 = r42.getSchemaParamsMap();
    L152:
        if (r2 == null) goto L158;
        String r43 = r2.get("log_pv");
        if (r43 == null) goto L158;
        JSONObject r44 = z1.g(o.a(r43));
        if (r44 == null) goto L158;
        Map<String, ? extends Object> r45 = z1.j(r44);
    L159:
        r136.b("page_view", r45);
    L158:
        r45 = MapsKt.emptyMap();
    L160:
        ((OrderFreqControlManager) this.x.getValue()).b();
        return;
    L100:
        if (StringsKt.isBlank(r36) == true) goto L103;
        r37 = false;
    L97:
        r36 = null;
        goto L98
    L91:
        r34 = null;
        goto L92
    L76:
        r118 = null;
    L40:
        r17 = null;
        goto L42
    L31:
        r14 = null;
    L24:
        r11 = null;
    L15:
        r4 = null;
        goto L16
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onOrderSearchResultQuerySuccess(final com.bytedance.android.shopping.orderlist.search.starter.a r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onOrderSearchResultQuerySuccess", new C03101(this, r3));
    }

    public final void onSaveInstanceState(final Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onSaveInstanceState1", new C03141(this, r3));
    }

    public static final /* synthetic */ void A1(OrderSearchResultActivity r0, Bundle r1) {
        super.onSaveInstanceState(r1);
    }

    public final void onSaveInstanceState(final Bundle r3, final PersistableBundle r4) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        Intrinsics.checkNotNullParameter(r4, "outPersistentState");
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onSaveInstanceState2", new AnonymousClass2(this, r3, r4));
    }

    @Override // com.bytedance.android.shopping.orderlist.common.controller.f
    public final void sA(final boolean r3, final com.bytedance.kmp.ec.yata.common.biz.callback.a r4) {
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onRequestStart", new OrderSearchResultActivity$onRequestStart$1(this, r3, r4));
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, R> R withState(VM1 r2, Function1<? super S1, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Function1<? super PROP1, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void B1(OrderSearchResultActivity r0, Bundle r1, PersistableBundle r2) {
        super/*android.app.Activity*/.onSaveInstanceState(r1, r2);
    }

    public final <S extends State> Disposable subscribe(JediViewModel<S> r2, SubscriptionConfig<S> r3, Function2<? super IdentitySubscriber, ? super S, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$subscribe");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "subscriber");
        return JediView.DefaultImpls.subscribe(this, r2, r3, r4);
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, R> R withState(VM1 r2, VM2 r3, Function2<? super S1, ? super S2, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "viewModel2");
        Intrinsics.checkNotNullParameter(r4, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3, r4);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Middleware<S2, PROP2> r3, Function2<? super PROP1, ? super PROP2, ? extends R> r4) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "middleware2");
        Intrinsics.checkNotNullParameter(r4, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.orderlist.common.controller.f
    public final void Ti(final boolean r9, final boolean r10, final gg3.c r11, final com.bytedance.kmp.ec.yata.common.biz.callback.a r12) {
        Intrinsics.checkNotNullParameter(r11, "response");
        OrderCommonErrorMonitorKt.c(I1().getTracker(), "OrderSearchResultActivity-onRequestEnd", new OrderSearchResultActivity$onRequestEnd$1(this, r9, r10, r11, r12));
    }

    public final <S extends State, A> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, SubscriptionConfig<Tuple1<A>> r4, Function2<? super IdentitySubscriber, ? super A, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5);
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, R> R withState(VM1 r2, VM2 r3, VM3 r4, Function3<? super S1, ? super S2, ? super S3, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "viewModel2");
        Intrinsics.checkNotNullParameter(r4, "viewModel3");
        Intrinsics.checkNotNullParameter(r5, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3, r4, r5);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Middleware<S2, PROP2> r3, Middleware<S3, PROP3> r4, Function3<? super PROP1, ? super PROP2, ? super PROP3, ? extends R> r5) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "middleware2");
        Intrinsics.checkNotNullParameter(r4, "middleware3");
        Intrinsics.checkNotNullParameter(r5, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3, r4, r5);
    }

    public final <S extends State, A, B> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, KProperty1<S, ? extends B> r4, SubscriptionConfig<Tuple2<A, B>> r5, Function3<? super IdentitySubscriber, ? super A, ? super B, Unit> r6) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "config");
        Intrinsics.checkNotNullParameter(r6, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5, r6);
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, R> R withState(VM1 r2, VM2 r3, VM3 r4, VM4 r5, Function4<? super S1, ? super S2, ? super S3, ? super S4, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "viewModel2");
        Intrinsics.checkNotNullParameter(r4, "viewModel3");
        Intrinsics.checkNotNullParameter(r5, "viewModel4");
        Intrinsics.checkNotNullParameter(r6, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3, r4, r5, r6);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Middleware<S2, PROP2> r3, Middleware<S3, PROP3> r4, Middleware<S4, PROP4> r5, Function4<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? extends R> r6) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "middleware2");
        Intrinsics.checkNotNullParameter(r4, "middleware3");
        Intrinsics.checkNotNullParameter(r5, "middleware4");
        Intrinsics.checkNotNullParameter(r6, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3, r4, r5, r6);
    }

    public final <S extends State, T> Disposable asyncSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends Async<? extends T>> r3, SubscriptionConfig<Tuple1<Async<T>>> r4, Function2<? super IdentitySubscriber, ? super Throwable, Unit> r5, Function1<? super IdentitySubscriber, Unit> r6, Function2<? super IdentitySubscriber, ? super T, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "$this$asyncSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop");
        Intrinsics.checkNotNullParameter(r4, "config");
        return JediView.DefaultImpls.asyncSubscribe(this, r2, r3, r4, r5, r6, r7);
    }

    public final <S extends State, A, B, C> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, KProperty1<S, ? extends B> r4, KProperty1<S, ? extends C> r5, SubscriptionConfig<Tuple3<A, B, C>> r6, Function4<? super IdentitySubscriber, ? super A, ? super B, ? super C, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r7, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5, r6, r7);
    }

    public final <VM1 extends JediViewModel<S1>, S1 extends State, VM2 extends JediViewModel<S2>, S2 extends State, VM3 extends JediViewModel<S3>, S3 extends State, VM4 extends JediViewModel<S4>, S4 extends State, VM5 extends JediViewModel<S5>, S5 extends State, R> R withState(VM1 r2, VM2 r3, VM3 r4, VM4 r5, VM5 r6, Function5<? super S1, ? super S2, ? super S3, ? super S4, ? super S5, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r2, "viewModel1");
        Intrinsics.checkNotNullParameter(r3, "viewModel2");
        Intrinsics.checkNotNullParameter(r4, "viewModel3");
        Intrinsics.checkNotNullParameter(r5, "viewModel4");
        Intrinsics.checkNotNullParameter(r6, "viewModel5");
        Intrinsics.checkNotNullParameter(r7, "block");
        return (R) JediView.DefaultImpls.withState(this, r2, r3, r4, r5, r6, r7);
    }

    public final <M1 extends Middleware<S1, PROP1>, PROP1 extends State, S1 extends State, M2 extends Middleware<S2, PROP2>, PROP2 extends State, S2 extends State, M3 extends Middleware<S3, PROP3>, PROP3 extends State, S3 extends State, M4 extends Middleware<S4, PROP4>, PROP4 extends State, S4 extends State, M5 extends Middleware<S5, PROP5>, PROP5 extends State, S5 extends State, R> R withSubstate(Middleware<S1, PROP1> r2, Middleware<S2, PROP2> r3, Middleware<S3, PROP3> r4, Middleware<S4, PROP4> r5, Middleware<S5, PROP5> r6, Function5<? super PROP1, ? super PROP2, ? super PROP3, ? super PROP4, ? super PROP5, ? extends R> r7) {
        Intrinsics.checkNotNullParameter(r2, "middleware1");
        Intrinsics.checkNotNullParameter(r3, "middleware2");
        Intrinsics.checkNotNullParameter(r4, "middleware3");
        Intrinsics.checkNotNullParameter(r5, "middleware4");
        Intrinsics.checkNotNullParameter(r6, "middleware5");
        Intrinsics.checkNotNullParameter(r7, "block");
        return (R) JediView.DefaultImpls.withSubstate(this, r2, r3, r4, r5, r6, r7);
    }

    public final <S extends State, A, B, C, D> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, KProperty1<S, ? extends B> r4, KProperty1<S, ? extends C> r5, KProperty1<S, ? extends D> r6, SubscriptionConfig<Tuple4<A, B, C, D>> r7, Function5<? super IdentitySubscriber, ? super A, ? super B, ? super C, ? super D, Unit> r8) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        Intrinsics.checkNotNullParameter(r6, "prop4");
        Intrinsics.checkNotNullParameter(r7, "config");
        Intrinsics.checkNotNullParameter(r8, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5, r6, r7, r8);
    }

    public final <S extends State, A, B, C, D, E> Disposable selectSubscribe(JediViewModel<S> r2, KProperty1<S, ? extends A> r3, KProperty1<S, ? extends B> r4, KProperty1<S, ? extends C> r5, KProperty1<S, ? extends D> r6, KProperty1<S, ? extends E> r7, SubscriptionConfig<Tuple5<A, B, C, D, E>> r8, Function6<? super IdentitySubscriber, ? super A, ? super B, ? super C, ? super D, ? super E, Unit> r9) {
        Intrinsics.checkNotNullParameter(r2, "$this$selectSubscribe");
        Intrinsics.checkNotNullParameter(r3, "prop1");
        Intrinsics.checkNotNullParameter(r4, "prop2");
        Intrinsics.checkNotNullParameter(r5, "prop3");
        Intrinsics.checkNotNullParameter(r6, "prop4");
        Intrinsics.checkNotNullParameter(r7, "prop5");
        Intrinsics.checkNotNullParameter(r8, "config");
        Intrinsics.checkNotNullParameter(r9, "subscriber");
        return JediView.DefaultImpls.selectSubscribe(this, r2, r3, r4, r5, r6, r7, r8, r9);
    }
}
