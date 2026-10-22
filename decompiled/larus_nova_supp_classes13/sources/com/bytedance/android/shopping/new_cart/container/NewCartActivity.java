package com.bytedance.android.shopping.new_cart.container;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.feedback.IECFeedbackService;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.new_cart.components.CartBackToTopBtnManageComponent;
import com.bytedance.android.shopping.new_cart.components.CartBodyComponent;
import com.bytedance.android.shopping.new_cart.components.CartEventCenterComponent;
import com.bytedance.android.shopping.new_cart.components.CartLoadMoreComponent;
import com.bytedance.android.shopping.new_cart.components.CartLoadingComponent;
import com.bytedance.android.shopping.new_cart.components.CartPageCallBackComponent;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.viewmodel.CartState;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.android.shopping.new_cart.yata.CartYataAbilityProvider;
import com.bytedance.android.shopping.new_cart.yata.interceptor.TriggerInterceptorImpl;
import com.bytedance.android.shopping.new_cart.yata.processors.CartRenderNodeProcessor;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.android.shopping.yata.init.AndroidYataBuilderManager;
import com.bytedance.ies.uikit.base.AbsActivity;
import com.bytedance.jedi.arch.Async;
import com.bytedance.jedi.arch.IReceiver;
import com.bytedance.jedi.arch.ISubscriber;
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
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.gyf.barlibrary.ImmersionBar;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0001\fB\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/container/NewCartActivity;", "Lcom/bytedance/ies/uikit/base/AbsActivity;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Lcom/bytedance/android/shopping/new_cart/container/w;", "Lcom/bytedance/android/shopping/new_cart/router/a;", "cartPrefetchResponse", "", "onCartQuerySuccess", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewCartActivity extends AbsActivity implements JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, w {
    public static final com.bytedance.kmp.ec.yata.common.perf.c F = null;
    public static final com.bytedance.kmp.ec.yata.common.perf.c G = null;
    public static final com.bytedance.kmp.ec.yata.common.perf.c H = null;
    public boolean A;
    public boolean B;
    public final Lazy C;
    public final Lazy D;
    public int E;
    public CartObjectContainer j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public ImmersionBar q;
    public final ReflectViewModelFactory r;
    public AndroidYaTaInstance s;
    public SlcRenderContext t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final lifecycleAwareLazy x;
    public vf3.c y;
    public com.bytedance.android.shopping.new_cart.manager.c z;

    public static final class a {
        public static void a(Context r3, CartParams r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "sessionId");
            Intent r0 = new Intent(r3, NewCartActivity.class);
            Bundle r1 = new Bundle();
            r1.putSerializable("CART_PARAM", r4);
            r1.putSerializable("PrefechSessionId", r5);
            Unit r6 = Unit.INSTANCE;
            r0.putExtras(r1);
            r3.startActivity(r0);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ NewCartActivity a;

        public b(NewCartActivity r1) {
            this.a = r1;
        }

        public final void a() {
            NewCartActivity r0 = this.a;
            com.bytedance.kmp.ec.yata.common.perf.c r1 = NewCartActivity.F;
            CartPageCallBackComponent r2 = r0.C1();
            if (r2 == null) goto L5;
            Boolean r3 = Boolean.valueOf(r2.f);
        L7:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L10;
            bg3.a r4 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.j("WHITE_SCREEN_7S", "CartActivity WHITE_SCREEN 7S", NewCartActivity.A1(this.a).e.j, 4);
            this.a.A = true;
            return;
        L10:
            return;
        L5:
            r3 = null;
            goto L7
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
        public final /* synthetic */ NewCartActivity a;

        public c(NewCartActivity r1) {
            this.a = r1;
        }

        public final void a() {
            dm.a.a("ECCartLoadingView").i("NewCartActivity destroy");
            NewCartActivity r0 = this.a;
            com.bytedance.kmp.ec.yata.common.perf.c r1 = NewCartActivity.F;
            CartPageCallBackComponent r2 = r0.C1();
            if (r2 == null) goto L5;
            r2.w("destroy", null);
        L5:
            ImmersionBar r3 = this.a.q;
            if (r3 == null) goto L8;
            r3.destroy();
        L8:
            s0.e(this.a);
            AndroidYaTaInstance r4 = this.a.s;
            if (r4 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
        L11:
            r4.d();
            bg3.a r5 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.b.removeCallbacksAndMessages(null);
            this.a.F1().onDestroy();
            com.bytedance.android.shopping.new_cart.manager.c r6 = this.a.z;
            if (r6 == null) goto L15;
            r6.d();
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

    public static final class d implements Runnable {
        public final /* synthetic */ NewCartActivity a;

        public d(NewCartActivity r1) {
            this.a = r1;
        }

        public final void a() {
            NewCartActivity r0 = this.a;
            if (r0.B == false) goto L5;
            CartViewModel.doQuery$default(r0.F1(), false, "page_back", null, 4, null);
        L5:
            Iterator<T> r1 = NewCartActivity.A1(this.a).e.e.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            ((v) r1.next()).onResume();
            goto L7
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

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.container.NewCartActivity$onCreate$6, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass6 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass6();
        }

        public AnonymousClass6() {
            super(CartState.class, "hasMore", "getHasMore()Z", 0);
        }

        public Object get(Object r1) {
            return Boolean.valueOf(((CartState) r1).a);
        }

        public void set(Object r1, Object r2) {
            boolean r3 = ((Boolean) r2).booleanValue();
            ((CartState) r1).a = r3;
        }
    }

    public final CartPageCallBackComponent C1() {
        return (CartPageCallBackComponent) this.p.getValue();
    }

    public final CartParams D1() {
        return (CartParams) this.v.getValue();
    }

    public final CartViewModel F1() {
        return (CartViewModel) this.x.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.perf.d G1() {
        return (com.bytedance.kmp.ec.yata.common.perf.d) this.u.getValue();
    }

    public final String H1() {
        return (String) this.w.getValue();
    }

    static {
        F = new com.bytedance.kmp.ec.yata.common.perf.c("cart_open_schema_timing", "打开Schema");
        G = new com.bytedance.kmp.ec.yata.common.perf.c("cart_query_net_timing", "首屏网络请求");
        H = new com.bytedance.kmp.ec.yata.common.perf.c("cart_query_deserialize_timing", "Query序列化");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772248);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(NewCartActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
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
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(NewCartActivity.class.getName()));
    L5:
        super.onDestroy();
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        String r1 = H1();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        yf3.b.a.remove(r1);
        yf3.b.c.remove(r1);
        yf3.b.b.remove(r1);
        CartPageCallBackComponent r2 = C1();
        if (r2 != null) goto L8;
    L9:
        bg3.a r3 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartViewModel r4 = F1();
        StringBuilder r5 = new StringBuilder("firstScreen: ");
        CartPageCallBackComponent r6 = C1();
        if (r6 == null) goto L12;
        Boolean r7 = Boolean.valueOf(r6.f);
    L13:
        r5.append(r7);
        r5.append("; errorView: ");
        com.bytedance.android.shopping.new_cart.components.d r8 = (com.bytedance.android.shopping.new_cart.components.d) this.m.getValue();
        if (r8 == null) goto L16;
        Boolean r9 = Boolean.valueOf(r8.c);
    L17:
        r5.append(r9);
        r5.append(" loading: ");
        CartLoadingComponent r10 = (CartLoadingComponent) this.n.getValue();
        if (r10 == null) goto L20;
        Boolean r11 = Boolean.valueOf(r10.i);
    L21:
        r5.append(r11);
        String r12 = r5.toString();
        long r13 = System.currentTimeMillis();
        CartPageCallBackComponent r14 = C1();
        if (r14 == null) goto L24;
        long r15 = r14.k;
    L25:
        com.bytedance.android.shopping.new_cart.utils.a.g(r4, "page_destroy", r12, MapsKt.mapOf(TuplesKt.to("page_time", Long.valueOf(r13 - r15))));
    L26:
        vf3.c r16 = this.y;
        if (r16 == null) goto L31;
        SlcRenderContext r17 = r16.c;
        if (r17 == null) goto L31;
        r17.Y.remove(r16.a);
    L31:
        Lazy r18 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L34;
        TrackCatcher.b("cart");
    L34:
        bg3.a r19 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(F1(), "onDestroy", new c(this), null);
        return;
    L24:
        r15 = 0;
        goto L25
    L20:
        r11 = null;
        goto L21
    L16:
        r9 = null;
        goto L17
    L12:
        r7 = null;
        goto L13
    L8:
        if (r2.g == true) goto L26;
        goto L9
    }

    public NewCartActivity() {
        this.k = LazyKt.lazy(new NewCartActivity$cartLoadMoreComponent$2(this));
        this.l = LazyKt.lazy(new NewCartActivity$bodyComponent$2(this));
        this.m = LazyKt.lazy(new NewCartActivity$errorComponent$2(this));
        this.n = LazyKt.lazy(new NewCartActivity$loadingComponent$2(this));
        this.o = LazyKt.lazy(new NewCartActivity$footerComponent$2(this));
        this.p = LazyKt.lazy(new NewCartActivity$cartPageCallBackComponent$2(this));
        this.r = new ReflectViewModelFactory();
        this.u = LazyKt.lazy(new NewCartActivity$perfManager$2(this));
        this.v = LazyKt.lazy(new NewCartActivity$cartParam$2(this));
        this.w = LazyKt.lazy(new NewCartActivity$prefetchSessionId$2(this));
        final KClass r0 = Reflection.getOrCreateKotlinClass(CartViewModel.class);
        final NewCartActivity$$special$$inlined$viewModel$1 r1 = NewCartActivity$$special$$inlined$viewModel$1.INSTANCE;
        this.x = new lifecycleAwareLazy(this, new NewCartActivity$$special$$inlined$viewModel$2(this, r0, r1, r0));
        this.C = LazyKt.lazy(new NewCartActivity$triggerInterceptorImpl$2(this));
        this.D = LazyKt.lazy(new NewCartActivity$isCacheResponseValid$2(this));
        Lazy r2 = BtmSDKWrapper.a;
        BtmSDKWrapper.c(NewCartActivity.class, "a1.b4001");
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.new_cart.container.w
    public final int k4() {
        return k1.m(this);
    }

    public final void onResume() {
        super.onResume();
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(F1(), "onResume", new d(this), null);
        this.B = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        z1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public final void y1() {
        super.y1();
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(F1(), "setStatusBarColor", new a0(this), null);
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.r;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m1658getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public static final /* synthetic */ CartObjectContainer A1(NewCartActivity r1) {
        CartObjectContainer r2 = r1.j;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        return r2;
    }

    public static View z1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void B1(com.bytedance.android.shopping.new_cart.router.a r9) {
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        yf3.b.a(H1(), "OnCartQuerySuccess");
        long r2 = 0;
        boolean r4 = false;
        if ((!Intrinsics.areEqual(r9.a, H1())) == false) goto L12;
        CartPageCallBackComponent r1 = C1();
        if (r1 != null) goto L7;
    L22:
        if (r4 == true) goto L24;
        return;
    L24:
        com.bytedance.kmp.ec.yata.common.protocol.data.e r10 = r9.b;
        if (this.A == false) goto L34;
        CartPageCallBackComponent r3 = C1();
        if (r3 == null) goto L34;
        if (r3.f != true) goto L34;
        bg3.a r5 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartViewModel r6 = F1();
        String r7 = "success: " + com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r10);
        long r8 = System.currentTimeMillis();
        CartPageCallBackComponent r11 = C1();
        if (r11 == null) goto L33;
        r2 = r11.k;
    L33:
        com.bytedance.android.shopping.new_cart.utils.a.g(r6, "long first query", r7, MapsKt.mapOf(TuplesKt.to("page_time", Long.valueOf(r8 - r2))));
    L34:
        CartPageCallBackComponent r12 = C1();
        if (r12 == null) goto L38;
        r12.u("first_enter", com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r10), r10);
        return;
    L38:
        return;
    L7:
        if (r1.f != true) goto L22;
        bg3.a r13 = com.bytedance.android.shopping.new_cart.utils.a.a;
        String r14 = "onCartQuerySuccess " + r9.a + " not match " + H1();
        CartObjectContainer r15 = this.j;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L11:
        com.bytedance.android.shopping.new_cart.utils.a.j("cart-prefetch-mismatch", r14, r15.e.j, 4);
        goto L22
    L12:
        Lazy r16 = CartCommonLog.a;
        CartCommonLog.a("NewCartStarter", NewCartActivity$queryFirstPaint$1.INSTANCE);
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r17 = r9.b;
        CartObjectContainer r18 = this.j;
        if (r18 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L15:
        r18.e.l.a = false;
        CartObjectContainer r19 = this.j;
        if (r19 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L18:
        r19.e.l.c = true;
        bg3.a r20 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(F1(), "onCartQuerySuccess", new NewCartActivity$queryFirstPaint$2(this, r17), new z(this));
        vf3.a r21 = F1().getMultiUpdateImpl();
        if (r21 == null) goto L21;
        r21.r(0, r17);
    L21:
        yf3.b.a(H1(), "OnQueryEnd");
        r4 = true;
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        if (r4 != null) goto L5;
    L6:
        if (r4 != null) goto L8;
    L21:
        return super/*android.app.Activity*/.dispatchTouchEvent(r4);
    L8:
        if (r4.getAction() != 3) goto L21;
    L9:
        CartObjectContainer r1 = this.j;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L12:
        List r2 = CollectionsKt.toList(r1.e.e);
        if ((true ^ r2.isEmpty()) == false) goto L21;
        Iterator r0 = r2.iterator();
    L16:
        if (r0.hasNext() == false) goto L21;
        v r3 = (v) r0.next();
        if (r3 == null) goto L16;
        r3.c(r4);
        goto L16
    L5:
        if (r4.getAction() == 1) goto L9;
        goto L6
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onCartQuerySuccess(final com.bytedance.android.shopping.new_cart.router.a r3) {
        Intrinsics.checkNotNullParameter(r3, "cartPrefetchResponse");
        com.bytedance.android.shopping.new_cart.monitor.a.c();
        CartObjectContainer r0 = this.j;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L6:
        if (r0.e.l.a == false) goto L8;
        bg3.a r1 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.f(new AnonymousClass1(this, r3));
    L9:
        s0.d(r3.getClass());
        return;
    L8:
        B1(r3);
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r15) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L123
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L123
    L8:
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        yf3.b.a(H1(), "OnCreate");
        CartViewModel r3 = F1();
        com.bytedance.android.shopping.new_cart.container.b r5 = new com.bytedance.android.shopping.new_cart.container.b(new NewCartActivity$registerComponents$1(this), H1(), false, 15870);
        r5.b(D1());
        final CartObjectContainer r1 = new CartObjectContainer(r3, this, r5, null, this);
        KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r2 = Reflection.getOrCreateKotlinClass(CartBodyComponent.class);
        Function0<CartBodyComponent> r4 = new NewCartActivity$registerComponents$2$1(r1);
        Boolean r6 = Boolean.FALSE;
        r1.c(r2, r6, r4);
        r1.c(Reflection.getOrCreateKotlinClass(CartLoadMoreComponent.class), r6, new NewCartActivity$registerComponents$2$2(r1));
        r1.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.d.class), r6, new NewCartActivity$registerComponents$$inlined$apply$lambda$1(r1, this));
        r1.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.g.class), r6, new NewCartActivity$registerComponents$$inlined$apply$lambda$2(r1, this));
        r1.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.l.class), r6, new NewCartActivity$registerComponents$$inlined$apply$lambda$3(r1, this));
        r1.c(Reflection.getOrCreateKotlinClass(CartLoadingComponent.class), r6, new NewCartActivity$registerComponents$$inlined$apply$lambda$4(r1, this));
        r1.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.f.class), r6, new NewCartActivity$registerComponents$$inlined$apply$lambda$5(r1, this));
        r1.c(Reflection.getOrCreateKotlinClass(CartPageCallBackComponent.class), r6, new NewCartActivity$registerComponents$$inlined$apply$lambda$6(r1, this));
        r1.c(Reflection.getOrCreateKotlinClass(vf3.a.class), r6, new NewCartActivity$registerComponents$2$9(r1));
        KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r7 = Reflection.getOrCreateKotlinClass(CartSliceCustomWidgetAdapterComponent.class);
        Boolean r8 = Boolean.TRUE;
        r1.c(r7, r8, new NewCartActivity$registerComponents$2$10(r1));
        r1.c(Reflection.getOrCreateKotlinClass(CartBackToTopBtnManageComponent.class), r6, new NewCartActivity$registerComponents$$inlined$apply$lambda$7(r1, this));
        Unit r9 = Unit.INSTANCE;
        this.j = r1;
        CartViewModel r10 = F1();
        CartObjectContainer r11 = this.j;
        if (r11 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L11:
        r10.onCreate(r11);
        CartTemplateMgr.preload(this);
        CartTemplateMgr.INSTANCE.injectCustomWidget();
        CreateSliceRenderInfo r12 = new CreateSliceRenderInfo(D1());
        r12.a(this);
        yf3.b.a(H1(), "SliceInitEnd");
        overridePendingTransition(2130772267, 2130772253);
        super.onCreate(r15);
        com.bytedance.android.shopping.new_cart.monitor.a.b(false);
        Lazy r13 = BtmSDKWrapper.a;
        CartParams r14 = D1();
        if (r14 == null) goto L16;
        HashMap<String, String> r16 = r14.getSchemaParams();
        if (r16 == null) goto L16;
        String r17 = r16.get("source_btm_token");
    L17:
        BtmSDKWrapper.a(this, "a1.b4001", r17);
        com.bytedance.android.bcm.api.b.e(PageFinder.via(this), "page_show", new BcmParams());
        AbsPerfMonitor.c(G1(), F);
        setContentView(2131563705);
        yf3.b.a(H1(), "OnQueryStart");
        CartPageCallBackComponent r18 = C1();
        if (r18 == null) goto L20;
        Intrinsics.checkNotNullParameter("first_enter", "scene");
        com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.components.k(r18, "first_enter", true, null));
    L20:
        yf3.b.a(H1(), "InitView");
        View r19 = findViewById(2131368571);
        ECAppInfoService r20 = ECAppInfoService.e;
        wg.a.h(r19, r20.i());
        r19.setOnClickListener(y.a);
        if (r20.i() == false) goto L23;
        ISubscriber.DefaultImpls.selectSubscribe$default(this, F1(), NewCartActivity$initView$2.INSTANCE, null, new NewCartActivity$initView$3(this), 2, null);
    L23:
        int r21 = CartFooterRoundCornerHelper.a;
        View r22 = z1(getWindow());
        com.bytedance.android.shopping.new_cart.components.f r23 = (com.bytedance.android.shopping.new_cart.components.f) this.o.getValue();
        CartBodyComponent r24 = (CartBodyComponent) this.l.getValue();
        if (r24 == null) goto L26;
        CartLinkedScrollViewV2 r25 = r24.p();
    L28:
        if ((r25 instanceof CartLinkedScrollViewV2) == true) goto L30;
        r25 = null;
    L30:
        CartFooterRoundCornerHelper.a(r22, r23, r25, new C02801(this));
        CartObjectContainer r26 = this.j;
        if (r26 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L33:
        r26.e.j = PageFinder.via(BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        F1().setCustomDataCenter(new com.bytedance.android.shopping.new_cart.yata.customdata.a(this, null));
        CartBodyComponent r27 = (CartBodyComponent) this.l.getValue();
        if (r27 == null) goto L51;
        RecyclerView r28 = r27.q();
        if (r28 == null) goto L51;
        CartObjectContainer r29 = this.j;
        if (r29 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L40:
        com.bytedance.android.shopping.new_cart.components.f r30 = (com.bytedance.android.shopping.new_cart.components.f) this.o.getValue();
        if (r30 == null) goto L45;
        View r31 = r30.d;
        if (r31 == null) goto L45;
    L46:
        View r110 = r31;
        CartBodyComponent r32 = (CartBodyComponent) this.l.getValue();
        if (r32 == null) goto L49;
        CartLinkedScrollViewV2 r111 = r32.p();
    L50:
        com.bytedance.android.shopping.new_cart.manager.c r33 = new com.bytedance.android.shopping.new_cart.manager.c(r29, r28, r110, r111, 0, 48);
        r33.b(findViewById(2131365249));
        r33.c();
        this.z = r33;
        CartFooterRoundCornerHelper.b(z1(getWindow()), this.z);
        goto L51
    L49:
        r111 = null;
    L45:
        r31 = findViewById(2131365244);
    L51:
        yf3.b.a(H1(), "YataInit");
        G1().h();
        int r34 = AndroidYataBuilderManager.a;
        CartObjectContainer r35 = this.j;
        if (r35 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L54:
        CartYataAbilityProvider r36 = new CartYataAbilityProvider(r35);
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r37 = r12.a;
        CartObjectContainer r38 = this.j;
        if (r38 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L57:
        CartParams r39 = r38.e.c;
        if (r39 == null) goto L60;
        YataPageInfo r40 = r39.getPageInfo();
    L61:
        com.bytedance.kmp.ec.yata.b r41 = AndroidYataBuilderManager.a("yata_cart", r36, r37, r40, AnonymousClass2.INSTANCE);
        com.bytedance.kmp.ec.yata.b.c(r41, (LinearLayout) findViewById(2131365245));
        CartBodyComponent r42 = (CartBodyComponent) this.l.getValue();
        if (r42 == null) goto L66;
        RecyclerView r43 = r42.q();
        if (r43 == null) goto L66;
        com.bytedance.kmp.ec.yata.b.a(r41, r43);
    L66:
        com.bytedance.android.shopping.new_cart.components.f r44 = (com.bytedance.android.shopping.new_cart.components.f) this.o.getValue();
        if (r44 == null) goto L70;
        LinearLayout r45 = r44.d;
        if (r45 == null) goto L70;
    L71:
        com.bytedance.kmp.ec.yata.b.b(r41, r45);
        com.bytedance.kmp.ec.yata.b.d(r41, "save_card_sticky", (LinearLayout) findViewById(2131385090));
        r41.e((FrameLayout) findViewById(2131372736));
        com.bytedance.kmp.ec.yata.b.d(r41, "pendant_container", (LinearLayout) findViewById(2131382098));
        this.s = r41.a;
        final CartObjectContainer r46 = this.j;
        if (r46 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L74:
        r46.c(Reflection.getOrCreateKotlinClass(CartEventCenterComponent.class), r8, new NewCartActivity$registerComponentsImmediately$1$1(r46));
        vf3.a r47 = F1().getMultiUpdateImpl();
        if (r47 == null) goto L80;
        AndroidYaTaInstance r48 = this.s;
        if (r48 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L79:
        r48.E(r47);
    L80:
        AndroidYaTaInstance r49 = this.s;
        if (r49 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L83:
        r49.D((TriggerInterceptorImpl) this.C.getValue());
        Lazy r50 = CartSettingUtils.a;
        Function0<Unit> r51 = new AnonymousClass5(this);
        Intrinsics.checkNotNullParameter(r51, "action");
        r51.invoke();
        G1().g();
        AndroidYaTaInstance r52 = this.s;
        if (r52 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L86:
        CartViewModel r53 = F1();
        CartObjectContainer r54 = this.j;
        if (r54 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L89:
        r52.c(new CartRenderNodeProcessor(r53, r54));
        yf3.b.a(H1(), "InitSlcRenderContext");
        AndroidYaTaInstance r55 = this.s;
        if (r55 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L92:
        SlcRenderContext r56 = (SlcRenderContext) r55.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        this.t = r56;
        if (r56 == null) goto L95;
        r56.O = com.bytedance.android.ec.core.opt.ab.t.b();
    L95:
        SlcRenderContext r57 = this.t;
        if (r57 == null) goto L98;
        r57.s(com.bytedance.android.ec.core.opt.ab.t.c());
    L98:
        vf3.c r58 = new vf3.c(F1(), this.t);
        this.y = r58;
        SlcRenderContext r59 = r58.c;
        if (r59 == null) goto L102;
        r59.Y.add(r58.a);
    L102:
        if (r15 == null) goto L106;
        if (r15.getBoolean("CART_LOAD_AGAIN") != true) goto L106;
    L108:
        yf3.b.a(H1(), "ViewModelSubscribe");
        ISubscriber.DefaultImpls.selectSubscribe$default(this, F1(), AnonymousClass6.INSTANCE, null, new AnonymousClass7(this), 2, null);
        yf3.b.a(H1(), "EventBusRegister");
        s0.c(this);
        if (r15 != null) goto L111;
    L119:
        bg3.a r112 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.e(7000, new b(this));
        yf3.b.a(H1(), "OnCreateEnd");
        com.bytedance.android.shopping.new_cart.monitor.a.a();
        int r113 = ECSdk.a;
        IECFeedbackService r114 = (IECFeedbackService) ECSdk.a(IECFeedbackService.class);
        if (r114 == null) goto L126;
        r114.registerScreenCapture(this, null);
        return;
    L126:
        return;
    L111:
        if (r15.getBoolean("CART_LOAD_AGAIN") != true) goto L119;
        bg3.a r115 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartObjectContainer r116 = this.j;
        if (r116 != null) goto L115;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L115:
        com.bytedance.android.shopping.new_cart.utils.a.j("CART_LOAD_AGAIN", "CartActivity savedInstanceState LoadAgain", r116.e.j, 4);
        CartObjectContainer r117 = this.j;
        if (r117 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L118:
        r117.e.n = true;
        CartViewModel.doQuery$default(F1(), true, "first_enter", null, 4, null);
    L106:
        if (((Boolean) this.D.getValue()).booleanValue() == false) goto L108;
        Choreographer.getInstance().postFrameCallback(new NewCartActivity$startCacheRender$1(this));
    L70:
        r45 = (LinearLayout) findViewById(2131365244);
        goto L71
    L60:
        r40 = null;
        goto L61
    L26:
        r25 = null;
    L16:
        r17 = null;
        goto L17
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        r3.putBoolean("CART_LOAD_AGAIN", true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSaveInstanceState(Bundle r2, PersistableBundle r3) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        Intrinsics.checkNotNullParameter(r3, "outPersistentState");
        super/*android.app.Activity*/.onSaveInstanceState(r2, r3);
        r2.putBoolean("CART_LOAD_AGAIN", true);
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
