package com.bytedance.android.shopping.new_cart.container;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.GestureDetector;
import android.view.InflateException;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.jedi.ReflectViewModelFactory;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.anchorv3.compat.UserInteractFrameLayout;
import com.bytedance.android.shopping.cart_common.PostFrameTask;
import com.bytedance.android.shopping.new_cart.components.CartBackToTopBtnManageComponent;
import com.bytedance.android.shopping.new_cart.components.CartBodyComponent;
import com.bytedance.android.shopping.new_cart.components.CartEventCenterComponent;
import com.bytedance.android.shopping.new_cart.components.CartLoadMoreComponent;
import com.bytedance.android.shopping.new_cart.components.CartLoadingComponent;
import com.bytedance.android.shopping.new_cart.components.CartPageCallBackComponent;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.android.shopping.new_cart.utils.CartSettingUtils;
import com.bytedance.android.shopping.new_cart.viewmodel.CartState;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.new_cart.widgets.CartRootFrameLayoutContainer;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.android.shopping.new_cart.yata.CartYataAbilityProvider;
import com.bytedance.android.shopping.new_cart.yata.interceptor.TriggerInterceptorImpl;
import com.bytedance.android.shopping.new_cart.yata.processors.CartRenderNodeProcessor;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.yata.biz.popup.PopupLayer;
import com.bytedance.android.shopping.yata.init.AndroidYataBuilderManager;
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
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
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
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00020\u00050\u00042\u00020\u00062\u00020\u00072\u00020\b:\u0001\u000fB\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/container/CartDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/bytedance/android/shopping/new_cart/widgets/CartRootFrameLayoutContainer$a;", "Lcom/bytedance/jedi/arch/JediView;", "Lcom/bytedance/jedi/arch/ViewModelFactoryOwner;", "Lcom/bytedance/android/ec/core/jedi/ReflectViewModelFactory;", "Landroid/content/DialogInterface$OnShowListener;", "Lp83/b;", "Lcom/bytedance/android/shopping/new_cart/container/w;", "Lcom/bytedance/android/shopping/new_cart/router/a;", "cartPrefetchResponse", "", "onCartQuerySuccess", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartDialogFragment extends DialogFragment implements CartRootFrameLayoutContainer.a, JediView, ViewModelFactoryOwner<ReflectViewModelFactory>, DialogInterface.OnShowListener, p83.b, w {
    public static final com.bytedance.kmp.ec.yata.common.perf.c R = null;
    public final Lazy A;
    public com.bytedance.android.shopping.new_cart.manager.c B;
    public View C;
    public CartRootFrameLayoutContainer D;
    public LinearLayout E;
    public View F;
    public View G;
    public final d H;
    public final Lazy I;
    public final Function0<Boolean> J;
    public int K;
    public final GestureDetector L;
    public int M;
    public float N;
    public final Lazy O;
    public final Lazy P;
    public l Q;
    public final ReflectViewModelFactory d;
    public final int e;
    public final Lazy f;
    public final Lazy g;
    public CartObjectContainer h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public AndroidYaTaInstance p;
    public SlcRenderContext q;
    public final Lazy r;
    public final lifecycleAwareLazy s;
    public vf3.c t;
    public boolean u;
    public final AtomicBoolean v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
        public static CartDialogFragment a(CartParams r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "params");
            Intrinsics.checkNotNullParameter(r4, "sessionId");
            CartDialogFragment r0 = new CartDialogFragment();
            Bundle r1 = new Bundle();
            r1.putSerializable("CART_PARAM", r3);
            r1.putString("PrefechSessionId", r4);
            Unit r5 = Unit.INSTANCE;
            r0.setArguments(r1);
            return r0;
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ CartDialogFragment a;

        public b(CartDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r7) {
            Intrinsics.checkNotNullParameter(r7, "animation");
            CartRootFrameLayoutContainer r8 = this.a.D;
            if (r8 == null) goto L5;
            r8.setBorderRadius(0);
        L5:
            View r9 = this.a.F;
            if (r9 == null) goto L8;
            r9.setVisibility(4);
        L8:
            this.a.ga0(true);
            Map<String, ?> r10 = CartDialogFragment.T90(this.a).e.a();
            Object r1 = null;
            if (r10 == null) goto L11;
            Object r11 = r10.get("pull_full_screen_refresh");
        L13:
            if ((r11 instanceof Integer) == false) goto L16;
            r1 = r11;
        L16:
            Integer r2 = (Integer) r1;
            if (r2 != null) goto L20;
            return;
        L20:
            if (r2.intValue() != 1) goto L23;
            CartViewModel.doQuery$default(this.a.Y90(), false, "pull_to_full_screen", null, 4, null);
            return;
        L23:
            return;
        L11:
            r11 = null;
            goto L13
        }
    }

    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public final int a;
        public final int b;
        public final /* synthetic */ CartDialogFragment c;

        public c(CartDialogFragment r1) {
            this.c = r1;
            this.a = 100;
            this.b = 1500;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public final boolean onFling(MotionEvent r3, MotionEvent r4, float r5, float r6) {
            Intrinsics.checkNotNullParameter(r4, "e2");
            float r7 = 0.0f;
            if (r3 == null) goto L5;
            float r0 = r3.getRawY();
        L6:
            float r1 = r0 - r4.getRawY();
            if (r3 == null) goto L10;
            r7 = r3.getRawX();
        L10:
            if (Math.abs(r1) > Math.abs(r7 - r4.getRawX())) goto L12;
            return false;
        L12:
            if (Math.abs(r1) > this.a) goto L14;
            return false;
        L14:
            if (Math.abs(r6) > this.b) goto L16;
            return false;
        L16:
            if (r1 <= 0) goto L22;
            View r8 = this.c.F;
            if (r8 != null) goto L20;
        L23:
            return true;
        L20:
            if (r8.getVisibility() != 0) goto L23;
            this.c.U90();
            goto L23
        L22:
            CartDialogFragment r9 = this.c;
            com.bytedance.kmp.ec.yata.common.perf.c r10 = CartDialogFragment.R;
            r9.ea0();
            goto L23
        L5:
            r0 = 0.0f;
            goto L6
        }
    }

    public static final class d implements ul.c {
        public d() {
        }

        public final void a(boolean r1) {
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ Map a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CartDialogFragment c;
        public final /* synthetic */ com.bytedance.kmp.ec.yata.store.node.c d;

        public e(Map r1, String r2, CartDialogFragment r3, com.bytedance.kmp.ec.yata.store.node.c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.c.ca0().k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.c.ca0(), null, this.d.getKey(), "controlChildTopBarVisibility", this.a, this.b));     // Catch: Throwable -> L4
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
        public final /* synthetic */ Map a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CartDialogFragment c;
        public final /* synthetic */ com.bytedance.kmp.ec.yata.store.node.c d;

        public f(Map r1, String r2, CartDialogFragment r3, com.bytedance.kmp.ec.yata.store.node.c r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.c.ca0().k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(this.c.ca0(), null, this.d.getKey(), "showCartTab", this.a, this.b));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g extends AnimatorListenerAdapter {
        public final /* synthetic */ CartDialogFragment a;

        public g(CartDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r7) {
            Intrinsics.checkNotNullParameter(r7, "animation");
            View r8 = this.a.G;
            if (r8 == null) goto L5;
            r8.setTranslationY(0.0f);
        L5:
            View r9 = this.a.G;
            if (r9 == null) goto L8;
            r9.setVisibility(4);
        L8:
            CartRootFrameLayoutContainer r10 = this.a.D;
            if (r10 == null) goto L11;
            r10.setBorderRadius(com.bytedance.android.shopping.extensions.b.b(20));
        L11:
            this.a.ga0(false);
            Map<String, ?> r11 = CartDialogFragment.T90(this.a).e.a();
            Object r0 = null;
            if (r11 == null) goto L14;
            Object r12 = r11.get("pull_full_screen_refresh");
        L16:
            if ((r12 instanceof Integer) == false) goto L19;
            r0 = r12;
        L19:
            Integer r1 = (Integer) r0;
            if (r1 != null) goto L23;
            return;
        L23:
            if (r1.intValue() != 1) goto L26;
            CartViewModel.doQuery$default(this.a.Y90(), false, "drop_down_to_split_screen", null, 4, null);
            return;
        L26:
            return;
        L14:
            r12 = null;
            goto L16
        }
    }

    public static final class h extends AnimatorListenerAdapter {
        public final /* synthetic */ CartDialogFragment a;

        public h(CartDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            View r3 = this.a.F;
            if (r3 == null) goto L6;
            r3.setVisibility(0);
            return;
        }
    }

    public static final class i implements DialogInterface.OnKeyListener {
        public final /* synthetic */ CartDialogFragment a;

        public i(CartDialogFragment r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r2, int r3, KeyEvent r4) {
            boolean r0 = false;
            if (r3 == 4) goto L5;
        L27:
            return false;
        L5:
            if (r4.getAction() != 1) goto L27;
            CartDialogFragment r5 = this.a;
            com.bytedance.kmp.ec.yata.common.perf.c r6 = CartDialogFragment.R;
            if (r5.fa0() == false) goto L26;
            com.bytedance.android.shopping.new_cart.components.l r7 = (com.bytedance.android.shopping.new_cart.components.l) this.a.o.getValue();
            if (r7 == null) goto L26;
            FrameLayout r8 = r7.d;
            if (r8 != null) goto L13;
        L15:
            if (r0 != true) goto L26;
            com.bytedance.android.shopping.new_cart.components.l r9 = (com.bytedance.android.shopping.new_cart.components.l) this.a.o.getValue();
            if (r9 == null) goto L21;
            PopupLayer r10 = r9.n();
            if (r10 == null) goto L21;
            r10.h(null);
        L21:
            com.bytedance.android.shopping.new_cart.components.l r11 = (com.bytedance.android.shopping.new_cart.components.l) this.a.o.getValue();
            if (r11 == null) goto L24;
            r11.o();
        L24:
            return true;
        L13:
            if (r8.getVisibility() != 0) goto L15;
            r0 = true;
        L26:
            return ((Boolean) this.a.J.invoke()).booleanValue();
        }
    }

    public static final class j implements Runnable {
        public final /* synthetic */ CartDialogFragment a;

        public j(CartDialogFragment r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            s0.e(this.a);     // Catch: Throwable -> L9
            CartDialogFragment r0 = this.a;     // Catch: Throwable -> L9
            if (r0.p == null) goto L5;
            r0.ca0().d();     // Catch: Throwable -> L9
        L5:
            bg3.a r1 = com.bytedance.android.shopping.new_cart.utils.a.a;     // Catch: Throwable -> L9
            com.bytedance.android.shopping.new_cart.utils.a.b.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
            this.a.Y90().onDestroy();     // Catch: Throwable -> L9
            com.bytedance.android.shopping.new_cart.manager.c r2 = this.a.B;     // Catch: Throwable -> L9
            if (r2 == null) goto L12;
            r2.d();     // Catch: Throwable -> L9
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class k implements Runnable {
        public final /* synthetic */ CartDialogFragment a;

        public k(CartDialogFragment r1) {
            this.a = r1;
        }

        public final void a() {
            CartDialogFragment r0 = this.a;
            com.bytedance.kmp.ec.yata.common.perf.c r1 = CartDialogFragment.R;
            CartPageCallBackComponent r2 = r0.W90();
            if (r2 == null) goto L5;
            Boolean r3 = Boolean.valueOf(r2.f);
        L7:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L10;
            bg3.a r4 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.j("WHITE_SCREEN_7S", "CartDialogFragment WHITE_SCREEN 7S", CartDialogFragment.T90(this.a).e.j, 4);
            this.a.u = true;
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

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.container.CartDialogFragment$onCartQuerySuccess$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public final /* synthetic */ CartDialogFragment a;
        public final /* synthetic */ com.bytedance.android.shopping.new_cart.router.a b;

        public AnonymousClass1(CartDialogFragment r1, com.bytedance.android.shopping.new_cart.router.a r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PostFrameTask r0 = new PostFrameTask(new CartDialogFragment$onCartQuerySuccess$1$queryPaintTask$1(this));     // Catch: Throwable -> L4
            Choreographer.getInstance().postFrameCallback(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.container.CartDialogFragment$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C02751 extends MutablePropertyReference0Impl {
        public C02751(CartDialogFragment r7) {
            super(r7, CartDialogFragment.class, "objectContainer", "getObjectContainer()Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", 0);
        }

        public Object get() {
            return CartDialogFragment.T90((CartDialogFragment) ((CallableReference) this).receiver);
        }

        public void set(Object r2) {
            CartObjectContainer r3 = (CartObjectContainer) r2;
            ((CartDialogFragment) ((CallableReference) this).receiver).h = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.container.CartDialogFragment$onViewCreated$5, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class AnonymousClass5 extends MutablePropertyReference1Impl {
        public static final KMutableProperty1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass5();
        }

        public AnonymousClass5() {
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

    public final CartPageCallBackComponent W90() {
        return (CartPageCallBackComponent) this.n.getValue();
    }

    public final CartParams X90() {
        return (CartParams) this.f.getValue();
    }

    public final CartViewModel Y90() {
        return (CartViewModel) this.s.getValue();
    }

    public final float Z90() {
        return ((Number) this.z.getValue()).floatValue();
    }

    public final com.bytedance.kmp.ec.yata.common.perf.d aa0() {
        return (com.bytedance.kmp.ec.yata.common.perf.d) this.r.getValue();
    }

    public final String ba0() {
        return (String) this.g.getValue();
    }

    public final boolean fa0() {
        return ((Boolean) this.A.getValue()).booleanValue();
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r1) {
    }

    static {
        R = new com.bytedance.kmp.ec.yata.common.perf.c("cart_open_schema_timing", "打开Schema");
    }

    public final void U90() {
        CartLoadingComponent r0 = (CartLoadingComponent) this.l.getValue();
        if (r0 != null) goto L5;
    L7:
        CartObjectContainer r1 = this.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L10:
        r1.e.q = 100;
        da0(true);
        AnimatorSet r2 = new AnimatorSet();
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.D, "translationY", new float[]{((Number) this.O.getValue()).intValue() - ((Number) this.P.getValue()).intValue()});
        r3.setDuration(340);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.C, "alpha", new float[]{0.0f});
        r4.setDuration(100);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.G, "alpha", new float[]{1.0f});
        r5.setDuration(160);
        View r10 = this.G;
        if (r10 == null) goto L13;
        r10.setVisibility(0);
    L13:
        View r11 = this.G;
        if (r11 == null) goto L16;
        r11.setAlpha(0.0f);
    L16:
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.F, "alpha", new float[]{0.0f});
        r6.setDuration(100);
        r6.addListener(new b(this));
        r2.playTogether(new Animator[]{r3, r4, r5, r6});
        r2.start();
        return;
    L5:
        if (r0.i != true) goto L7;
    }

    public final AndroidYaTaInstance ca0() {
        AndroidYaTaInstance r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L5:
        return r0;
    }

    public final void dismissAllowingStateLoss() {
        int r0 = com.bytedance.android.shopping.new_cart.utils.c.a;
        CartParams r1 = X90();
        if (r1 == null) goto L5;
        String r2 = r1.getSplitActivityScene();
    L7:
        if (com.bytedance.android.shopping.new_cart.utils.c.a(r2) == false) goto L11;
        nj.d r3 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r3 == null) goto L11;
        getActivity();
        r3.m();
    L11:
        dm.a.a("CartDialogFragment").i("fragment dismissAllowingStateLoss");
        super.dismissAllowingStateLoss();     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r4 = DialogFragmentLancet.sLastShowStack;
        if (r4 == null) goto L21;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L21:
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void ea0() {
        CartLoadingComponent r0 = (CartLoadingComponent) this.l.getValue();
        if (r0 != null) goto L5;
    L7:
        CartObjectContainer r1 = this.h;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L10:
        com.bytedance.android.shopping.new_cart.container.b r2 = r1.e;
        CartParams r3 = X90();
        if (r3 == null) goto L13;
        int r4 = r3.getHeightPercent();
    L14:
        r2.q = r4;
        da0(false);
        AnimatorSet r5 = new AnimatorSet();
        ObjectAnimator r6 = ObjectAnimator.ofFloat(this.D, "translationY", new float[]{Z90()});
        r6.setDuration(340);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this.G, "alpha", new float[]{0.0f});
        r7.setDuration(100);
        r7.addListener(new g(this));
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this.C, "alpha", new float[]{0.6f});
        r8.setDuration(100);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this.F, "alpha", new float[]{1.0f});
        r9.setDuration(260);
        r9.setStartDelay(100);
        r9.addListener(new h(this));
        r5.playTogether(new Animator[]{r6, r8, r7, r9});
        r5.start();
        return;
    L13:
        r4 = 100;
        goto L14
    L5:
        if (r0.i != true) goto L7;
    }

    @Override // com.bytedance.android.shopping.new_cart.container.w
    public final int k4() {
        int r0 = com.bytedance.android.shopping.new_cart.utils.c.a;
        CartParams r1 = X90();
        if (r1 == null) goto L5;
        String r2 = r1.getSplitActivityScene();
    L7:
        if (com.bytedance.android.shopping.new_cart.utils.c.a(r2) == false) goto L12;
        nj.d r3 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r3 == null) goto L13;
        r3.getSpiltWidth();
        return 0;
    L13:
        return 0;
    L12:
        return k1.m(requireContext());
    L5:
        r2 = null;
        goto L7
    }

    public CartDialogFragment() {
        this.d = new ReflectViewModelFactory();
        this.e = com.bytedance.android.shopping.extensions.b.b(5);
        this.f = LazyKt.lazy(new CartDialogFragment$cartParam$2(this));
        this.g = LazyKt.lazy(new CartDialogFragment$prefetchSessionId$2(this));
        this.i = LazyKt.lazy(new CartDialogFragment$cartLoadMoreComponent$2(this));
        this.j = LazyKt.lazy(new CartDialogFragment$bodyComponent$2(this));
        this.k = LazyKt.lazy(new CartDialogFragment$errorComponent$2(this));
        this.l = LazyKt.lazy(new CartDialogFragment$loadingComponent$2(this));
        this.m = LazyKt.lazy(new CartDialogFragment$footerComponent$2(this));
        this.n = LazyKt.lazy(new CartDialogFragment$cartPageCallBackComponent$2(this));
        this.o = LazyKt.lazy(new CartDialogFragment$cartPopLayerComponent$2(this));
        this.r = LazyKt.lazy(new CartDialogFragment$perfManager$2(this));
        final KClass r0 = Reflection.getOrCreateKotlinClass(CartViewModel.class);
        final Function0<String> r1 = new CartDialogFragment$$special$$inlined$viewModel$1(r0);
        final CartDialogFragment$$special$$inlined$viewModel$2 r2 = CartDialogFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.s = new lifecycleAwareLazy(this, r1, new CartDialogFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        this.v = new AtomicBoolean(false);
        this.w = LazyKt.lazy(new CartDialogFragment$isCacheResponseValid$2(this));
        this.x = LazyKt.lazy(new CartDialogFragment$triggerInterceptorImpl$2(this));
        this.y = LazyKt.lazy(new CartDialogFragment$heightPercent$2(this));
        this.z = LazyKt.lazy(new CartDialogFragment$initialTransY$2(this));
        this.A = LazyKt.lazy(new CartDialogFragment$isHalfPanel$2(this));
        this.H = new d();
        this.I = LazyKt.lazy(new CartDialogFragment$foldStatusChangeListener$2(this));
        this.J = new CartDialogFragment$onBackClickListener$1(this);
        this.L = new GestureDetector(getContext(), new c(this));
        this.O = LazyKt.lazy(new CartDialogFragment$headerViewHeight$2(this));
        this.P = LazyKt.lazy(new CartDialogFragment$bodyTitleViewHeight$2(this));
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

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        String r1 = ba0();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        yf3.b.a.remove(r1);
        yf3.b.c.remove(r1);
        yf3.b.b.remove(r1);
        if (this.h == null) goto L25;
        CartPageCallBackComponent r2 = W90();
        if (r2 != null) goto L7;
    L8:
        bg3.a r3 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartViewModel r4 = Y90();
        StringBuilder r5 = new StringBuilder("firstScreen: ");
        CartPageCallBackComponent r6 = W90();
        if (r6 == null) goto L11;
        Boolean r7 = Boolean.valueOf(r6.f);
    L12:
        r5.append(r7);
        r5.append("; errorView: ");
        com.bytedance.android.shopping.new_cart.components.d r8 = (com.bytedance.android.shopping.new_cart.components.d) this.k.getValue();
        if (r8 == null) goto L15;
        Boolean r9 = Boolean.valueOf(r8.c);
    L16:
        r5.append(r9);
        r5.append(" loading: ");
        CartLoadingComponent r10 = (CartLoadingComponent) this.l.getValue();
        if (r10 == null) goto L19;
        Boolean r11 = Boolean.valueOf(r10.i);
    L20:
        r5.append(r11);
        String r12 = r5.toString();
        long r13 = System.currentTimeMillis();
        CartPageCallBackComponent r14 = W90();
        if (r14 == null) goto L23;
        long r15 = r14.k;
    L24:
        com.bytedance.android.shopping.new_cart.utils.a.g(r4, "page_destroy", r12, MapsKt.mapOf(TuplesKt.to("page_time", Long.valueOf(r13 - r15))));
        goto L25
    L23:
        r15 = 0;
        goto L24
    L19:
        r11 = null;
        goto L20
    L15:
        r9 = null;
        goto L16
    L11:
        r7 = null;
        goto L12
    L7:
        if (r2.g != true) goto L8;
    L25:
        vf3.c r16 = this.t;
        if (r16 == null) goto L30;
        SlcRenderContext r17 = r16.c;
        if (r17 == null) goto L30;
        r17.Y.remove(r16.a);
    L30:
        bg3.a r18 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(Y90(), "onDestroy", new j(this), null);
        nj.d r19 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r19 == null) goto L34;
        CartDialogFragment$foldStatusChangeListener$2.a r20 = (CartDialogFragment$foldStatusChangeListener$2.a) this.I.getValue();
        r19.e();
    L34:
        if (fa0() == false) goto L36;
        List r21 = ul.b.a;
        ul.b.a(this.H);
    L36:
        ga0(false);
    }

    public final void onDestroyView() {
        super.onDestroyView();
        boolean r0 = ECServiceManager.a;
        s83.g r1 = (s83.g) ECServiceManager.c(s83.g.class);
        CartParams r2 = X90();
        if (r2 == null) goto L5;
        HashMap<String, String> r3 = r2.getSchemaParams();
    L6:
        r1.t(r3);
        Dialog r4 = getDialog();
        if (r4 == null) goto L18;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L19;
        View r6 = S90(r5);
        if (r6 == null) goto L20;
        ViewTreeObserver r7 = r6.getViewTreeObserver();
        if (r7 != null) goto L15;
        return;
    L15:
        if (r7.isAlive() == false) goto L22;
        r7.removeOnPreDrawListener(this.Q);
        return;
    L22:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        if (this.v.get() == true) goto L19;
        if (getShowsDialog() == false) goto L13;
        Dialog r2 = getDialog();
        if (r2 == null) goto L11;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L11;
        View r4 = S90(r3);
    L12:
        SpringAnimation r0 = new SpringAnimation(r4, DynamicAnimation.TRANSLATION_Y, 0.0f);
        r0.getSpring().setStiffness(798.55f);
        r0.getSpring().setDampingRatio(0.999f);
        r0.setStartVelocity(0.0f);
        r0.start();
    L11:
        r4 = null;
    L13:
        boolean r1 = ECServiceManager.a;
        s83.g r5 = (s83.g) ECServiceManager.c(s83.g.class);
        CartParams r6 = X90();
        if (r6 == null) goto L16;
        HashMap<String, String> r7 = r6.getSchemaParams();
    L17:
        r5.b(r7);
        goto L19
    L16:
        r7 = null;
    L19:
        if (fa0() == false) goto L22;
        List r8 = ul.b.a;
        ul.b.b(this.H);
    L22:
        if (fa0() == false) goto L24;
    L26:
        bg3.a r9 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(Y90(), "onResume", new com.bytedance.android.shopping.new_cart.container.d(this), null);
        this.v.compareAndSet(false, true);
        return;
    L24:
        if (getShowsDialog() == false) goto L26;
        ga0(true);
        goto L26
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        if (fa0() == false) goto L9;
        Dialog r0 = getDialog();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L16;
        r1.setWindowAnimations(2131954184);
        return;
    L16:
        return;
    L15:
        return;
    L9:
        Dialog r2 = getDialog();
        if (r2 == null) goto L18;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L19;
        r3.setWindowAnimations(2131953433);
        return;
    L19:
        return;
    }

    public final ViewModelProvider.Factory getViewModelFactory() {
        return this.d;
    }

    /* JADX INFO: renamed from: getReceiver, reason: collision with other method in class */
    public final IdentitySubscriber m1577getReceiver() {
        return JediView.DefaultImpls.getReceiver(this);
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static final /* synthetic */ CartObjectContainer T90(CartDialogFragment r1) {
        CartObjectContainer r2 = r1.h;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        return r2;
    }

    public final void V90(com.bytedance.android.shopping.new_cart.router.a r9) {
        if (getContext() == null) goto L49;
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L7;
    L8:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
    L13:
        Map<String, Map<String, Long>> r2 = yf3.b.a;
        yf3.b.a(ba0(), "OnCartQuerySuccess");
        long r3 = 0;
        boolean r4 = false;
        if ((!Intrinsics.areEqual(r9.a, ba0())) == false) goto L23;
        CartPageCallBackComponent r5 = W90();
        if (r5 != null) goto L18;
    L33:
        if (r4 == true) goto L35;
        return;
    L35:
        com.bytedance.kmp.ec.yata.common.protocol.data.e r10 = r9.b;
        if (this.u == false) goto L45;
        CartPageCallBackComponent r6 = W90();
        if (r6 == null) goto L45;
        if (r6.f != true) goto L45;
        bg3.a r7 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartViewModel r8 = Y90();
        String r11 = "success: " + com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r10);
        long r12 = System.currentTimeMillis();
        CartPageCallBackComponent r13 = W90();
        if (r13 == null) goto L44;
        r3 = r13.k;
    L44:
        com.bytedance.android.shopping.new_cart.utils.a.g(r8, "long first query", r11, MapsKt.mapOf(TuplesKt.to("page_time", Long.valueOf(r12 - r3))));
    L45:
        CartPageCallBackComponent r14 = W90();
        if (r14 == null) goto L51;
        r14.u("first_enter", com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r10), r10);
        return;
    L51:
        return;
    L18:
        if (r5.f != true) goto L33;
        bg3.a r15 = com.bytedance.android.shopping.new_cart.utils.a.a;
        String r16 = "onCartQuerySuccess " + r9.a + " not match " + ba0();
        CartObjectContainer r17 = this.h;
        if (r17 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L22:
        com.bytedance.android.shopping.new_cart.utils.a.j("cart-prefetch-mismatch", r16, r17.e.j, 4);
        goto L33
    L23:
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r18 = r9.b;
        CartObjectContainer r19 = this.h;
        if (r19 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L26:
        r19.e.l.a = false;
        CartObjectContainer r20 = this.h;
        if (r20 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L29:
        r20.e.l.c = true;
        bg3.a r21 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(Y90(), "onCartQuerySuccess", new CartDialogFragment$queryFirstPaint$1(this, r18), new com.bytedance.android.shopping.new_cart.container.k(this));
        vf3.a r22 = Y90().getMultiUpdateImpl();
        if (r22 == null) goto L32;
        r22.r(0, r18);
    L32:
        yf3.b.a(ba0(), "OnQueryEnd");
        r4 = true;
        goto L33
    L11:
        if (r1.isDestroyed() != true) goto L13;
        return;
    L7:
        if (r0.isFinishing() != true) goto L8;
        return;
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.CartRootFrameLayoutContainer.a
    public final void c(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (r4.getAction() != 1) goto L5;
    L6:
        CartObjectContainer r0 = this.h;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L9:
        List r1 = CollectionsKt.toList(r0.e.e);
        if ((true ^ r1.isEmpty()) == false) goto L23;
        Iterator r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L24;
        v r3 = (v) r2.next();
        if (r3 == null) goto L13;
        r3.c(r4);
        goto L13
    L24:
        return;
    L23:
        return;
    L5:
        if (r4.getAction() == 3) goto L6;
    }

    public final void da0(boolean r9) {
        AndroidYaTaInstance r0 = this.p;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L5:
        List r1 = r0.n("body");
        if (r1 == null) goto L22;
        Iterator r2 = r1.iterator();
    L9:
        if (r2.hasNext() == false) goto L20;
        Object r4 = r2.next();
        com.bytedance.kmp.ec.yata.store.node.b r5 = ((com.bytedance.kmp.ec.yata.store.node.c) r4).getParent();
        if ((r5 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L13;
        r5 = null;
    L13:
        com.bytedance.kmp.ec.yata.store.node.c r6 = (com.bytedance.kmp.ec.yata.store.node.c) r5;
        if (r6 == null) goto L16;
        String r7 = r6.getNodeName();
    L18:
        if (Intrinsics.areEqual(r7, "cart_top_bar") == false) goto L9;
    L21:
        com.bytedance.kmp.ec.yata.store.node.c r8 = (com.bytedance.kmp.ec.yata.store.node.c) r4;
    L23:
        AndroidYaTaInstance r3 = this.p;
        if (r3 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L26:
        List r10 = r3.n("body");
        if (r10 == null) goto L42;
        Iterator r11 = r10.iterator();
    L30:
        if (r11.hasNext() == false) goto L40;
        Object r12 = r11.next();
        com.bytedance.kmp.ec.yata.store.node.c r13 = (com.bytedance.kmp.ec.yata.store.node.c) r12;
        if ((r13 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L34;
        r13 = null;
    L34:
        if (r13 == null) goto L36;
        String r14 = r13.getNodeName();
    L38:
        if (Intrinsics.areEqual(r14, "cart_tab") == false) goto L30;
    L41:
        com.bytedance.kmp.ec.yata.store.node.c r15 = (com.bytedance.kmp.ec.yata.store.node.c) r12;
    L43:
        if (r8 == null) goto L45;
        com.bytedance.kmp.ec.yata.store.node.b r16 = r8.getParent();
    L47:
        if ((r16 instanceof com.bytedance.kmp.ec.yata.store.node.c) == true) goto L50;
        r16 = null;
    L50:
        if (((com.bytedance.kmp.ec.yata.store.node.c) r16) == null) goto L56;
        Map r17 = MapsKt.mapOf(TuplesKt.to("show", Boolean.valueOf(r9)));
        if (r9 == false) goto L54;
        String r18 = "show_cart_to_top";
    L55:
        bg3.a r19 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(Y90(), r18, new e(r17, r18, this, r8), null);
        goto L56
    L54:
        r18 = "hide_cart_to_top";
    L56:
        if (r15 == null) goto L69;
        Map r20 = MapsKt.mapOf(TuplesKt.to("show", Boolean.valueOf(r9)));
        if (r9 == false) goto L60;
        String r21 = "show_cart_tab";
    L61:
        bg3.a r22 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(Y90(), r21, new f(r20, r21, this, r15), null);
        return;
    L60:
        r21 = "hide_cart_tab";
        goto L61
    L69:
        return;
    L45:
        r16 = null;
        goto L47
    L36:
        r14 = null;
        goto L38
    L40:
        r12 = null;
        goto L41
    L42:
        r15 = null;
        goto L43
    L16:
        r7 = null;
        goto L18
    L20:
        r4 = null;
        goto L21
    L22:
        r8 = null;
        goto L23
    }

    public final void ga0(boolean r5) {
        View r0 = getView();
        if ((r0 instanceof FrameLayout) == true) goto L5;
        r0 = null;
    L5:
        FrameLayout r1 = (FrameLayout) r0;
        if (r1 == null) goto L19;
        if (r5 == false) goto L13;
        int r6 = ECSdk.a;
        IAdapterService r7 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r7 == null) goto L20;
        com.bytedance.android.ec.adapter.api.j r8 = r7.getLiveWindowService();
        if (r8 == null) goto L21;
        com.bytedance.android.ec.adapter.api.a r2 = new com.bytedance.android.ec.adapter.api.a();
        Intrinsics.checkNotNullParameter("product_cart_page", "<set-?>");
        r2.a = "product_cart_page";
        Unit r3 = Unit.INSTANCE;
        r8.a(this, r1, r2);
        return;
    L21:
        return;
    L20:
        return;
    L13:
        int r9 = ECSdk.a;
        IAdapterService r10 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r10 == null) goto L23;
        com.bytedance.android.ec.adapter.api.j r11 = r10.getLiveWindowService();
        if (r11 == null) goto L24;
        r11.stopShowFloat();
        return;
    L24:
        return;
    L23:
        return;
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onCartQuerySuccess(com.bytedance.android.shopping.new_cart.router.a r3) {
        Intrinsics.checkNotNullParameter(r3, "cartPrefetchResponse");
        com.bytedance.android.shopping.new_cart.monitor.a.c();
        CartObjectContainer r0 = this.h;
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
        V90(r3);
        goto L9
    }

    public final void onCreate(Bundle r2) {
        CartTemplateMgr.preload(requireContext());
        CartTemplateMgr.INSTANCE.injectCustomWidget();
        super.onCreate(r2);
        setStyle(1, 2131952006);
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        r3.putBoolean("CART_LOAD_AGAIN", true);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onViewCreated(final View r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r24, FreqActions.ACTION_VIEW);
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r24, r25);
        int r0 = com.bytedance.android.shopping.new_cart.monitor.a.a;
        com.bytedance.android.shopping.new_cart.monitor.a.b(fa0());
        Map<String, Map<String, Long>> r1 = yf3.b.a;
        yf3.b.a(ba0(), "OnCreate");
        CartViewModel r2 = Y90();
        com.bytedance.android.shopping.new_cart.container.b r3 = new com.bytedance.android.shopping.new_cart.container.b(new CartDialogFragment$registerComponents$1(this), ba0(), fa0(), 11774);
        r3.b(X90());
        final CartObjectContainer r6 = new CartObjectContainer(r2, null, r3, this, this);
        KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r4 = Reflection.getOrCreateKotlinClass(CartBodyComponent.class);
        Function0<CartBodyComponent> r5 = new CartDialogFragment$registerComponents$2$1(r6);
        Boolean r7 = Boolean.FALSE;
        r6.c(r4, r7, r5);
        r6.c(Reflection.getOrCreateKotlinClass(CartLoadMoreComponent.class), r7, new CartDialogFragment$registerComponents$2$2(r6));
        r6.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.d.class), r7, new CartDialogFragment$registerComponents$$inlined$apply$lambda$1(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.g.class), r7, new CartDialogFragment$registerComponents$$inlined$apply$lambda$2(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.l.class), r7, new CartDialogFragment$registerComponents$$inlined$apply$lambda$3(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(CartLoadingComponent.class), r7, new CartDialogFragment$registerComponents$$inlined$apply$lambda$4(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.f.class), r7, new CartDialogFragment$registerComponents$$inlined$apply$lambda$5(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(CartPageCallBackComponent.class), r7, new CartDialogFragment$registerComponents$$inlined$apply$lambda$6(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(vf3.a.class), r7, new CartDialogFragment$registerComponents$2$9(r6));
        KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r8 = Reflection.getOrCreateKotlinClass(CartSliceCustomWidgetAdapterComponent.class);
        Boolean r10 = Boolean.TRUE;
        r6.c(r8, r10, new CartDialogFragment$registerComponents$2$10(r6));
        r6.c(Reflection.getOrCreateKotlinClass(CartBackToTopBtnManageComponent.class), r7, new CartDialogFragment$registerComponents$$inlined$apply$lambda$7(r6, this));
        Unit r9 = Unit.INSTANCE;
        this.h = r6;
        CartViewModel r11 = Y90();
        CartObjectContainer r12 = this.h;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        r11.onCreate(r12);
        YataPageInfo r13 = null;
        if ((r24 instanceof CartRootFrameLayoutContainer) == true) goto L8;
        Object r14 = null;
    L9:
        CartRootFrameLayoutContainer r15 = (CartRootFrameLayoutContainer) r14;
        if (r15 == null) goto L12;
        r15.b(this);
    L12:
        Lazy r16 = BtmSDKWrapper.a;
        CartParams r17 = X90();
        if (r17 == null) goto L17;
        HashMap<String, String> r18 = r17.getSchemaParams();
        if (r18 == null) goto L17;
        String r19 = r18.get("source_btm_token");
    L18:
        BtmSDKWrapper.b(this, "a1.b4001", r19);
        CreateSliceRenderInfo r110 = new CreateSliceRenderInfo(X90());
        r110.a(requireContext());
        yf3.b.a(ba0(), "SliceInitEnd");
        com.bytedance.android.bcm.api.b.e(PageFinder.via(this), "page_show", new BcmParams());
        AbsPerfMonitor.c(aa0(), R);
        yf3.b.a(ba0(), "OnQueryStart");
        CartPageCallBackComponent r20 = W90();
        if (r20 == null) goto L21;
        Intrinsics.checkNotNullParameter("first_enter", "scene");
        com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.components.k(r20, "first_enter", true, null));
    L21:
        yf3.b.a(ba0(), "InitView");
        View r21 = r24.findViewById(2131368571);
        if (r21 == null) goto L25;
        wg.a.h(r21, ECAppInfoService.e.i());
        r21.setOnClickListener(com.bytedance.android.shopping.new_cart.container.j.a);
    L25:
        if (ECAppInfoService.e.i() == false) goto L27;
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), CartDialogFragment$initView$2.INSTANCE, null, new CartDialogFragment$initView$3(this, r24), 2, null);
    L27:
        this.D = (CartRootFrameLayoutContainer) r24.findViewById(2131365249);
        if (fa0() == false) goto L66;
        this.C = r24.findViewById(2131389274);
        this.E = (LinearLayout) r24.findViewById(2131365247);
        this.F = r24.findViewById(2131365242);
        this.G = r24.findViewById(2131365245);
        if (ViewCompat.isLaidOut(r24) == true) goto L32;
    L36:
        r24.addOnLayoutChangeListener(new com.bytedance.android.shopping.new_cart.container.i(this, r24));
    L37:
        CartRootFrameLayoutContainer r22 = this.D;
        if (r22 == null) goto L40;
        r22.setBorderRadius(com.bytedance.android.shopping.extensions.b.b(20));
    L40:
        View r23 = this.G;
        if (r23 == null) goto L43;
        r23.setVisibility(4);
    L43:
        CartObjectContainer r26 = this.h;
        if (r26 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L46:
        com.bytedance.android.shopping.new_cart.container.b r27 = r26.e;
        CartParams r28 = X90();
        if (r28 == null) goto L49;
        int r29 = r28.getHeightPercent();
    L50:
        r27.q = r29;
        View r30 = this.C;
        if (r30 == null) goto L53;
        r30.setOnClickListener(new com.bytedance.android.shopping.new_cart.container.f(this));
    L53:
        View r31 = this.F;
        if (r31 == null) goto L56;
        r31.setOnTouchListener(new com.bytedance.android.shopping.new_cart.container.g(this));
    L56:
        View r32 = this.G;
        if (r32 == null) goto L59;
        r32.setOnTouchListener(new com.bytedance.android.shopping.new_cart.container.h(this));
    L59:
        com.bytedance.android.shopping.new_cart.components.f r33 = (com.bytedance.android.shopping.new_cart.components.f) this.m.getValue();
        if (r33 == null) goto L66;
        LinearLayout r34 = r33.d;
        if (r34 == null) goto L66;
        ViewTreeObserver r35 = r34.getViewTreeObserver();
        if (r35 == null) goto L66;
        r35.addOnGlobalLayoutListener(new com.bytedance.android.shopping.new_cart.container.e(r35, this));
        goto L66
    L49:
        r29 = 100;
        goto L50
    L32:
        if (r24.isLayoutRequested() == true) goto L36;
        UserInteractFrameLayout r36 = this.D;
        if (r36 == null) goto L37;
        r36.setTranslationY(Z90());
    L66:
        CartObjectContainer r37 = this.h;
        if (r37 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L69:
        r37.e.j = PageFinder.via(BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        CartViewModel r38 = Y90();
        Context r39 = requireContext();
        CartParams r40 = X90();
        if (r40 == null) goto L72;
        String r41 = r40.getSplitActivityScene();
    L73:
        r38.setCustomDataCenter(new com.bytedance.android.shopping.new_cart.yata.customdata.a(r39, r41));
        CartBodyComponent r42 = (CartBodyComponent) this.j.getValue();
        if (r42 == null) goto L76;
        RecyclerView r111 = r42.q();
    L77:
        com.bytedance.android.shopping.new_cart.components.f r43 = (com.bytedance.android.shopping.new_cart.components.f) this.m.getValue();
        if (r43 == null) goto L80;
        LinearLayout r112 = r43.d;
    L81:
        if (r111 == null) goto L100;
        if (r112 == null) goto L100;
        CartObjectContainer r44 = this.h;
        if (r44 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L86:
        CartBodyComponent r45 = (CartBodyComponent) this.j.getValue();
        if (r45 == null) goto L89;
        CartLinkedScrollViewV2 r210 = r45.p();
    L90:
        CartParams r46 = X90();
        if (r46 == null) goto L95;
        HashMap<String, String> r47 = r46.getSchemaParams();
        if (r47 == null) goto L95;
        String r48 = r47.get("bottom_offset");
    L96:
        com.bytedance.android.shopping.new_cart.manager.c r49 = new com.bytedance.android.shopping.new_cart.manager.c(r44, r111, r112, r210, com.bytedance.android.shopping.extensions.k.r(r48, 0), 32);
        UserInteractFrameLayout r50 = this.D;
        if (r50 == null) goto L99;
        r49.b(r50);
    L99:
        r49.c();
        this.B = r49;
    L95:
        r48 = null;
        goto L96
    L89:
        r210 = null;
    L100:
        yf3.b.a(ba0(), "YataInit");
        aa0().h();
        int r51 = AndroidYataBuilderManager.a;
        CartObjectContainer r52 = this.h;
        if (r52 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L103:
        CartYataAbilityProvider r53 = new CartYataAbilityProvider(r52);
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r54 = r110.a;
        CartObjectContainer r55 = this.h;
        if (r55 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L106:
        CartParams r56 = r55.e.c;
        if (r56 == null) goto L109;
        r13 = r56.getPageInfo();
    L109:
        com.bytedance.kmp.ec.yata.b r57 = AndroidYataBuilderManager.a("yata_cart", r53, r54, r13, C02761.INSTANCE);
        com.bytedance.kmp.ec.yata.b.c(r57, (LinearLayout) r24.findViewById(2131365245));
        CartBodyComponent r58 = (CartBodyComponent) this.j.getValue();
        if (r58 == null) goto L114;
        RecyclerView r59 = r58.q();
        if (r59 == null) goto L114;
        com.bytedance.kmp.ec.yata.b.a(r57, r59);
    L114:
        com.bytedance.android.shopping.new_cart.components.f r60 = (com.bytedance.android.shopping.new_cart.components.f) this.m.getValue();
        if (r60 == null) goto L118;
        LinearLayout r61 = r60.d;
        if (r61 == null) goto L118;
    L119:
        com.bytedance.kmp.ec.yata.b.b(r57, r61);
        com.bytedance.kmp.ec.yata.b.d(r57, "save_card_sticky", (LinearLayout) r24.findViewById(2131385090));
        r57.e((FrameLayout) r24.findViewById(2131372736));
        com.bytedance.kmp.ec.yata.b.d(r57, "pendant_container", (LinearLayout) r24.findViewById(2131382098));
        LinearLayout r62 = (LinearLayout) r24.findViewById(2131365242);
        if (r62 != null) goto L122;
        r62 = new LinearLayout(getContext());
    L122:
        com.bytedance.kmp.ec.yata.b.d(r57, "body_title", r62);
        this.p = r57.a;
        final CartObjectContainer r63 = this.h;
        if (r63 != null) goto L125;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L125:
        r63.c(Reflection.getOrCreateKotlinClass(CartEventCenterComponent.class), r10, new CartDialogFragment$registerComponentsImmediately$1$1(r63));
        vf3.a r64 = Y90().getMultiUpdateImpl();
        if (r64 == null) goto L131;
        AndroidYaTaInstance r65 = this.p;
        if (r65 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L130:
        r65.E(r64);
    L131:
        AndroidYaTaInstance r66 = this.p;
        if (r66 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L134:
        r66.D((TriggerInterceptorImpl) this.x.getValue());
        Lazy r67 = CartSettingUtils.a;
        Function0<Unit> r68 = new AnonymousClass4(this);
        Intrinsics.checkNotNullParameter(r68, "action");
        r68.invoke();
        aa0().g();
        AndroidYaTaInstance r69 = this.p;
        if (r69 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L137:
        CartViewModel r70 = Y90();
        CartObjectContainer r71 = this.h;
        if (r71 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L140:
        r69.c(new CartRenderNodeProcessor(r70, r71));
        yf3.b.a(ba0(), "InitSlcRenderContext");
        AndroidYaTaInstance r72 = this.p;
        if (r72 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L143:
        SlcRenderContext r73 = (SlcRenderContext) r72.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        this.q = r73;
        if (r73 == null) goto L146;
        r73.O = com.bytedance.android.ec.core.opt.ab.t.b();
    L146:
        SlcRenderContext r74 = this.q;
        if (r74 == null) goto L149;
        r74.s(com.bytedance.android.ec.core.opt.ab.t.c());
    L149:
        vf3.c r75 = new vf3.c(Y90(), this.q);
        this.t = r75;
        SlcRenderContext r76 = r75.c;
        if (r76 == null) goto L153;
        r76.Y.add(r75.a);
    L153:
        if (r25 == null) goto L157;
        if (r25.getBoolean("CART_LOAD_AGAIN") != true) goto L157;
    L159:
        yf3.b.a(ba0(), "ViewModelSubscribe");
        ISubscriber.DefaultImpls.selectSubscribe$default(this, Y90(), AnonymousClass5.INSTANCE, null, new AnonymousClass6(this), 2, null);
        yf3.b.a(ba0(), "EventBusRegister");
        s0.c(this);
        if (r25 != null) goto L162;
    L170:
        bg3.a r77 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.e(7000, new k(this));
        nj.d r78 = com.bytedance.android.ec.sdk.helper.d.b.getPadSplitService();
        if (r78 == null) goto L173;
        CartDialogFragment$foldStatusChangeListener$2.a r79 = (CartDialogFragment$foldStatusChangeListener$2.a) this.I.getValue();
        r78.b();
    L173:
        yf3.b.a(ba0(), "OnCreateEnd");
        com.bytedance.android.shopping.new_cart.monitor.a.a();
        return;
    L162:
        if (r25.getBoolean("CART_LOAD_AGAIN") != true) goto L170;
        bg3.a r80 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartObjectContainer r81 = this.h;
        if (r81 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L166:
        com.bytedance.android.shopping.new_cart.utils.a.j("CART_LOAD_AGAIN", "CartDialogFragment savedInstanceState LoadAgain", r81.e.j, 4);
        CartObjectContainer r82 = this.h;
        if (r82 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L169:
        r82.e.n = true;
        CartViewModel.doQuery$default(Y90(), true, "first_enter", null, 4, null);
    L157:
        if (((Boolean) this.w.getValue()).booleanValue() == false) goto L159;
        Choreographer.getInstance().postFrameCallback(new m(this));
    L118:
        r61 = (LinearLayout) r24.findViewById(2131365244);
        goto L119
    L80:
        r112 = null;
        goto L81
    L76:
        r111 = null;
        goto L77
    L72:
        r41 = null;
    L17:
        r19 = null;
        goto L18
    L8:
        r14 = r24;
        goto L9
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
    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
        View r6 = null;
    L10:
        Dialog r0 = getDialog();
        if (r0 == null) goto L15;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L15;
        r1.setBackgroundDrawableResource(2131101135);
    L15:
        Dialog r2 = getDialog();
        if (r2 == null) goto L22;
        Window r7 = r2.getWindow();
        if (r7 == null) goto L22;
        View r8 = S90(r7);
        if (r8 == null) goto L22;
        r8.setPadding(0, 0, 0, 0);
    L22:
        Dialog r9 = getDialog();
        if (r9 == null) goto L27;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L27;
        WindowManager.LayoutParams r11 = r10.getAttributes();
    L29:
        if (r11 == null) goto L31;
        r11.width = -1;
    L31:
        if (r11 == null) goto L33;
        r11.height = -1;
    L33:
        Dialog r12 = getDialog();
        if (r12 == null) goto L38;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L38;
        r13.setAttributes(r11);
    L38:
        Dialog r14 = getDialog();
        if (r14 == null) goto L41;
        r14.setOnDismissListener(this);
    L41:
        Dialog r15 = getDialog();
        if (r15 == null) goto L44;
        r15.setOnShowListener(this);
    L44:
        Dialog r16 = getDialog();
        if (r16 == null) goto L47;
        r16.setOnKeyListener(new i(this));
    L47:
        Dialog r17 = getDialog();
        if (r17 == null) goto L52;
        Window r18 = r17.getWindow();
        if (r18 == null) goto L52;
        Ref.ObjectRef r19 = new Ref.ObjectRef();
        r19.element = null;
        this.Q = new l(r18, r19);
        S90(r18).getViewTreeObserver().addOnPreDrawListener(this.Q);
    L52:
        Dialog r20 = getDialog();
        if (r20 == null) goto L57;
        Window r21 = r20.getWindow();
        if (r21 == null) goto L57;
        com.bytedance.android.shopping.extensions.m.a(r21, true);
    L57:
        return r6;
    L27:
        r11 = null;
        goto L29
    L4:
        if (fa0() == false) goto L6;
        r6 = th.a.c(requireContext(), 2131560616, r4, false);     // Catch: InflateException -> L8
    L58:
        goto L10
    L6:
        r6 = th.a.c(requireContext(), 2131563705, r4, false);     // Catch: InflateException -> L8
        goto L58
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
