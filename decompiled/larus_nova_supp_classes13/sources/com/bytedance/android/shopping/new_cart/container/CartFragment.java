package com.bytedance.android.shopping.new_cart.container;

import android.os.Bundle;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.BtmSDKWrapper;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.shopping.jedi.JediBaseFragment;
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
import com.bytedance.android.shopping.new_cart.widgets.CartRootFrameLayoutContainer;
import com.bytedance.android.shopping.new_cart.widgets.nest.CartLinkedScrollViewV2;
import com.bytedance.android.shopping.new_cart.yata.CartYataAbilityProvider;
import com.bytedance.android.shopping.new_cart.yata.interceptor.TriggerInterceptorImpl;
import com.bytedance.android.shopping.new_cart.yata.processors.CartRenderNodeProcessor;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.slice.action.entity.CheckLoginParam;
import com.bytedance.android.shopping.track.TrackCatcher;
import com.bytedance.android.shopping.yata.init.AndroidYataBuilderManager;
import com.bytedance.jedi.arch.ISubscriber;
import com.bytedance.jedi.arch.lifecycleAwareLazy;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KMutableProperty1;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u000bB\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/container/CartFragment;", "Lcom/bytedance/android/shopping/jedi/JediBaseFragment;", "Lcom/bytedance/android/shopping/new_cart/widgets/CartRootFrameLayoutContainer$a;", "", "Lcom/bytedance/android/shopping/new_cart/container/w;", "Lcom/bytedance/android/shopping/new_cart/router/a;", "cartPrefetchResponse", "", "onCartQuerySuccess", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartFragment extends JediBaseFragment implements CartRootFrameLayoutContainer.a, w {
    public static final com.bytedance.kmp.ec.yata.common.perf.c B = null;
    public com.bytedance.android.shopping.new_cart.manager.c A;
    public final Lazy g;
    public final Lazy h;
    public CartObjectContainer i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public AndroidYaTaInstance p;
    public SlcRenderContext q;
    public final Lazy r;
    public final Lazy s;
    public final lifecycleAwareLazy t;
    public vf3.c u;
    public boolean v;
    public final AtomicBoolean w;
    public final Lazy x;
    public View y;
    public int z;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ CartFragment a;

        public b(CartFragment r1) {
            this.a = r1;
        }

        public final void a() {
            s0.e(this.a);
            AndroidYaTaInstance r0 = this.a.p;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
        L5:
            r0.d();
            bg3.a r1 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.b.removeCallbacksAndMessages(null);
            this.a.W90().onDestroy();
            com.bytedance.android.shopping.new_cart.manager.c r2 = this.a.A;
            if (r2 == null) goto L8;
            r2.d();
        L8:
            com.bytedance.android.shopping.new_cart.components.f r3 = (com.bytedance.android.shopping.new_cart.components.f) this.a.n.getValue();
            if (r3 == null) goto L12;
            ((ArrayList) r3.b).clear();
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

    public static final class c implements Runnable {
        public final /* synthetic */ CartFragment a;

        public c(CartFragment r1) {
            this.a = r1;
        }

        public final void a() {
            CartFragment r0 = this.a;
            com.bytedance.kmp.ec.yata.common.perf.c r1 = CartFragment.B;
            CartPageCallBackComponent r2 = r0.U90();
            if (r2 == null) goto L5;
            Boolean r3 = Boolean.valueOf(r2.f);
        L7:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L10;
            bg3.a r4 = com.bytedance.android.shopping.new_cart.utils.a.a;
            com.bytedance.android.shopping.new_cart.utils.a.j("WHITE_SCREEN_7S", "CartFragment WHITE_SCREEN 7S", CartFragment.S90(this.a).e.j, 4);
            this.a.v = true;
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

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.container.CartFragment$onViewCreated$6, reason: invalid class name */
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

    public final CartPageCallBackComponent U90() {
        return (CartPageCallBackComponent) this.o.getValue();
    }

    public final CartParams V90() {
        return (CartParams) this.g.getValue();
    }

    public final CartViewModel W90() {
        return (CartViewModel) this.t.getValue();
    }

    public final com.bytedance.kmp.ec.yata.common.perf.d X90() {
        return (com.bytedance.kmp.ec.yata.common.perf.d) this.r.getValue();
    }

    public final String Y90() {
        return (String) this.h.getValue();
    }

    static {
        B = new com.bytedance.kmp.ec.yata.common.perf.c("cart_open_schema_timing", "打开Schema");
    }

    public CartFragment() {
        this.g = LazyKt.lazy(new CartFragment$cartParam$2(this));
        this.h = LazyKt.lazy(new CartFragment$prefetchSessionId$2(this));
        this.j = LazyKt.lazy(new CartFragment$cartLoadMoreComponent$2(this));
        this.k = LazyKt.lazy(new CartFragment$bodyComponent$2(this));
        this.l = LazyKt.lazy(new CartFragment$errorComponent$2(this));
        this.m = LazyKt.lazy(new CartFragment$loadingComponent$2(this));
        this.n = LazyKt.lazy(new CartFragment$footerComponent$2(this));
        this.o = LazyKt.lazy(new CartFragment$cartPageCallBackComponent$2(this));
        this.r = LazyKt.lazy(new CartFragment$perfManager$2(this));
        this.s = LazyKt.lazy(new CartFragment$triggerInterceptorImpl$2(this));
        final KClass r0 = Reflection.getOrCreateKotlinClass(CartViewModel.class);
        final Function0<String> r1 = new CartFragment$$special$$inlined$viewModel$1(r0);
        final CartFragment$$special$$inlined$viewModel$2 r2 = CartFragment$$special$$inlined$viewModel$2.INSTANCE;
        this.t = new lifecycleAwareLazy(this, r1, new CartFragment$$special$$inlined$viewModel$3(this, r1, r0, r2));
        this.w = new AtomicBoolean(false);
        this.x = LazyKt.lazy(new CartFragment$isCacheResponseValid$2(this));
    }

    @Override // com.bytedance.android.shopping.new_cart.container.w
    public final int k4() {
        return k1.m(requireContext());
    }

    public final void onDestroy() {
        super.onDestroy();
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        String r1 = Y90();
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        yf3.b.a.remove(r1);
        yf3.b.c.remove(r1);
        yf3.b.b.remove(r1);
        CartPageCallBackComponent r2 = U90();
        if (r2 != null) goto L5;
    L6:
        bg3.a r3 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartViewModel r4 = W90();
        StringBuilder r5 = new StringBuilder("firstScreen: ");
        CartPageCallBackComponent r6 = U90();
        if (r6 == null) goto L9;
        Boolean r7 = Boolean.valueOf(r6.f);
    L10:
        r5.append(r7);
        r5.append("; errorView: ");
        com.bytedance.android.shopping.new_cart.components.d r8 = (com.bytedance.android.shopping.new_cart.components.d) this.l.getValue();
        if (r8 == null) goto L13;
        Boolean r9 = Boolean.valueOf(r8.c);
    L14:
        r5.append(r9);
        r5.append(" loading: ");
        CartLoadingComponent r10 = (CartLoadingComponent) this.m.getValue();
        if (r10 == null) goto L17;
        Boolean r11 = Boolean.valueOf(r10.i);
    L18:
        r5.append(r11);
        String r12 = r5.toString();
        long r13 = System.currentTimeMillis();
        CartPageCallBackComponent r14 = U90();
        if (r14 == null) goto L21;
        long r15 = r14.k;
    L22:
        com.bytedance.android.shopping.new_cart.utils.a.g(r4, "page_destroy", r12, MapsKt.mapOf(TuplesKt.to("page_time", Long.valueOf(r13 - r15))));
    L23:
        vf3.c r16 = this.u;
        if (r16 == null) goto L28;
        SlcRenderContext r17 = r16.c;
        if (r17 == null) goto L28;
        r17.Y.remove(r16.a);
    L28:
        Lazy r18 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L31;
        TrackCatcher.b("cart");
    L31:
        bg3.a r19 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(W90(), "onDestroy", new b(this), null);
        return;
    L21:
        r15 = 0;
        goto L22
    L17:
        r11 = null;
        goto L18
    L13:
        r9 = null;
        goto L14
    L9:
        r7 = null;
        goto L10
    L5:
        if (r2.g == true) goto L23;
        goto L6
    }

    public final void onResume() {
        super.onResume();
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(W90(), "onResume", new o(this), null);
        this.w.compareAndSet(false, true);
    }

    public static final /* synthetic */ CartObjectContainer S90(CartFragment r1) {
        CartObjectContainer r2 = r1.i;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        return r2;
    }

    public final void T90(com.bytedance.android.shopping.new_cart.router.a r13) {
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        yf3.b.a(Y90(), "OnCartQuerySuccess");
        long r2 = 0;
        boolean r4 = false;
        if ((!Intrinsics.areEqual(r13.a, Y90())) == false) goto L13;
        CartPageCallBackComponent r1 = U90();
        if (r1 != null) goto L7;
    L12:
        int r3 = com.bytedance.android.shopping.new_cart.monitor.a.a;
        Intrinsics.checkNotNullParameter("cart-prefetch-mismatch", "errorMessage");
        com.bytedance.android.shopping.base.event.a.d("cart", "render", CheckLoginParam.KEY_FAILED, "cart-prefetch-mismatch", true, null, 32);
    L23:
        if (r4 == true) goto L25;
        return;
    L25:
        com.bytedance.kmp.ec.yata.common.protocol.data.e r14 = r13.b;
        if (this.v == false) goto L35;
        CartPageCallBackComponent r5 = U90();
        if (r5 == null) goto L35;
        if (r5.f != true) goto L35;
        bg3.a r6 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartViewModel r7 = W90();
        String r8 = "success: " + com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r14);
        long r9 = System.currentTimeMillis();
        CartPageCallBackComponent r10 = U90();
        if (r10 == null) goto L34;
        r2 = r10.k;
    L34:
        com.bytedance.android.shopping.new_cart.utils.a.g(r7, "long first query", r8, MapsKt.mapOf(TuplesKt.to("page_time", Long.valueOf(r9 - r2))));
    L35:
        CartPageCallBackComponent r11 = U90();
        if (r11 == null) goto L39;
        r11.u("first_enter", com.bytedance.kmp.ec.yata.common.protocol.data.f.d(r14), r14);
        return;
    L39:
        return;
    L7:
        if (r1.f != true) goto L12;
        bg3.a r12 = com.bytedance.android.shopping.new_cart.utils.a.a;
        String r15 = "onCartQuerySuccess " + r13.a + " not match " + Y90();
        CartObjectContainer r16 = this.i;
        if (r16 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L11:
        com.bytedance.android.shopping.new_cart.utils.a.j("cart-prefetch-mismatch", r15, r16.e.j, 4);
        goto L12
    L13:
        Lazy r17 = CartCommonLog.a;
        CartCommonLog.a("NewCartStarter", CartFragment$queryFirstPaint$1.INSTANCE);
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r18 = r13.b;
        CartObjectContainer r19 = this.i;
        if (r19 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L16:
        r19.e.l.a = false;
        CartObjectContainer r20 = this.i;
        if (r20 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L19:
        r20.e.l.c = true;
        bg3.a r21 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(W90(), "onCartQuerySuccess", new CartFragment$queryFirstPaint$2(this, r18), new q(this));
        vf3.a r22 = W90().getMultiUpdateImpl();
        if (r22 == null) goto L22;
        r22.r(0, r18);
    L22:
        yf3.b.a(Y90(), "OnQueryEnd");
        r4 = true;
        goto L23
    }

    @Override // com.bytedance.android.shopping.new_cart.widgets.CartRootFrameLayoutContainer.a
    public final void c(MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "ev");
        if (r4.getAction() != 1) goto L5;
    L6:
        CartObjectContainer r0 = this.i;
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

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public final void onCartQuerySuccess(final com.bytedance.android.shopping.new_cart.router.a r3) {
        Intrinsics.checkNotNullParameter(r3, "cartPrefetchResponse");
        com.bytedance.android.shopping.new_cart.monitor.a.c();
        CartObjectContainer r0 = this.i;
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
        T90(r3);
        goto L9
    }

    public final void onCreate(Bundle r2) {
        CartTemplateMgr.preload(requireContext());
        CartTemplateMgr.INSTANCE.injectCustomWidget();
        super.onCreate(r2);
    }

    public final void onSaveInstanceState(Bundle r3) {
        Intrinsics.checkNotNullParameter(r3, "outState");
        super.onSaveInstanceState(r3);
        r3.putBoolean("CART_LOAD_AGAIN", true);
    }

    public final void onViewCreated(final View r24, Bundle r25) {
        Intrinsics.checkNotNullParameter(r24, FreqActions.ACTION_VIEW);
        super.onViewCreated(r24, r25);
        com.bytedance.android.shopping.new_cart.monitor.a.b(false);
        Map<String, Map<String, Long>> r0 = yf3.b.a;
        yf3.b.a(Y90(), "OnCreate");
        CartViewModel r1 = W90();
        com.bytedance.android.shopping.new_cart.container.b r3 = new com.bytedance.android.shopping.new_cart.container.b(new CartFragment$registerComponents$1(this), Y90(), false, 15742);
        r3.b(V90());
        final CartObjectContainer r6 = new CartObjectContainer(r1, null, r3, this, this);
        KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r2 = Reflection.getOrCreateKotlinClass(CartBodyComponent.class);
        Function0<CartBodyComponent> r4 = new CartFragment$registerComponents$2$1(r6);
        Boolean r5 = Boolean.FALSE;
        r6.c(r2, r5, r4);
        r6.c(Reflection.getOrCreateKotlinClass(CartLoadMoreComponent.class), r5, new CartFragment$registerComponents$2$2(r6));
        r6.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.d.class), r5, new CartFragment$registerComponents$$inlined$apply$lambda$1(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.g.class), r5, new CartFragment$registerComponents$$inlined$apply$lambda$2(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.l.class), r5, new CartFragment$registerComponents$$inlined$apply$lambda$3(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(CartLoadingComponent.class), r5, new CartFragment$registerComponents$$inlined$apply$lambda$4(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.shopping.new_cart.components.f.class), r5, new CartFragment$registerComponents$$inlined$apply$lambda$5(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(CartPageCallBackComponent.class), r5, new CartFragment$registerComponents$$inlined$apply$lambda$6(r6, this));
        r6.c(Reflection.getOrCreateKotlinClass(vf3.a.class), r5, new CartFragment$registerComponents$2$9(r6));
        KClass<? extends com.bytedance.android.shopping.new_cart.components.a> r7 = Reflection.getOrCreateKotlinClass(CartSliceCustomWidgetAdapterComponent.class);
        Boolean r11 = Boolean.TRUE;
        r6.c(r7, r11, new CartFragment$registerComponents$2$10(r6));
        r6.c(Reflection.getOrCreateKotlinClass(CartBackToTopBtnManageComponent.class), r5, new CartFragment$registerComponents$$inlined$apply$lambda$7(r6, this));
        Unit r8 = Unit.INSTANCE;
        this.i = r6;
        CartViewModel r9 = W90();
        CartObjectContainer r10 = this.i;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L5:
        r9.onCreate(r10);
        YataPageInfo r13 = null;
        if ((r24 instanceof CartRootFrameLayoutContainer) == true) goto L8;
        Object r12 = null;
    L9:
        CartRootFrameLayoutContainer r14 = (CartRootFrameLayoutContainer) r12;
        if (r14 == null) goto L12;
        r14.b(this);
    L12:
        Lazy r15 = BtmSDKWrapper.a;
        int r16 = s.a;
        CartParams r17 = V90();
        if (r17 == null) goto L17;
        HashMap<String, String> r18 = r17.getSchemaParams();
        if (r18 == null) goto L17;
        String r19 = r18.get("source_btm_token");
    L18:
        BtmSDKWrapper.b(this, "a1.b98956", r19);
        CreateSliceRenderInfo r110 = new CreateSliceRenderInfo(V90());
        r110.a(requireContext());
        yf3.b.a(Y90(), "SliceInitEnd");
        com.bytedance.android.bcm.api.b.e(PageFinder.via(this), "page_show", new BcmParams());
        AbsPerfMonitor.c(X90(), B);
        yf3.b.a(Y90(), "OnQueryStart");
        CartPageCallBackComponent r20 = U90();
        if (r20 == null) goto L21;
        Intrinsics.checkNotNullParameter("first_enter", "scene");
        com.bytedance.android.shopping.new_cart.utils.a.f(new com.bytedance.android.shopping.new_cart.components.k(r20, "first_enter", true, null));
    L21:
        yf3.b.a(Y90(), "InitView");
        View r21 = r24.findViewById(2131368571);
        if (r21 == null) goto L25;
        wg.a.h(r21, ECAppInfoService.e.i());
        r21.setOnClickListener(p.a);
    L25:
        if (ECAppInfoService.e.i() == false) goto L27;
        ISubscriber.DefaultImpls.selectSubscribe$default(this, W90(), CartFragment$initView$2.INSTANCE, null, new CartFragment$initView$3(this, r24), 2, null);
    L27:
        this.y = r24.findViewById(2131365249);
        int r22 = CartFooterRoundCornerHelper.a;
        com.bytedance.android.shopping.new_cart.components.f r23 = (com.bytedance.android.shopping.new_cart.components.f) this.n.getValue();
        CartBodyComponent r26 = (CartBodyComponent) this.k.getValue();
        if (r26 == null) goto L30;
        CartLinkedScrollViewV2 r27 = r26.p();
    L32:
        if ((r27 instanceof CartLinkedScrollViewV2) == true) goto L34;
        r27 = null;
    L34:
        CartFooterRoundCornerHelper.a(r24, r23, r27, new C02771(this));
        CartObjectContainer r28 = this.i;
        if (r28 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L37:
        r28.e.j = PageFinder.via(BtmSDK.INSTANCE.getPageId(PageFinder.via(this)));
        W90().setCustomDataCenter(new com.bytedance.android.shopping.new_cart.yata.customdata.a(requireContext(), null));
        CartBodyComponent r29 = (CartBodyComponent) this.k.getValue();
        if (r29 == null) goto L40;
        RecyclerView r111 = r29.q();
    L41:
        com.bytedance.android.shopping.new_cart.components.f r30 = (com.bytedance.android.shopping.new_cart.components.f) this.n.getValue();
        if (r30 == null) goto L44;
        LinearLayout r112 = r30.d;
    L45:
        if (r111 == null) goto L64;
        if (r112 == null) goto L64;
        CartObjectContainer r31 = this.i;
        if (r31 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L50:
        CartBodyComponent r32 = (CartBodyComponent) this.k.getValue();
        if (r32 == null) goto L53;
        CartLinkedScrollViewV2 r210 = r32.p();
    L54:
        CartParams r33 = V90();
        if (r33 == null) goto L59;
        HashMap<String, String> r34 = r33.getSchemaParams();
        if (r34 == null) goto L59;
        String r35 = r34.get("bottom_offset");
    L60:
        com.bytedance.android.shopping.new_cart.manager.c r36 = new com.bytedance.android.shopping.new_cart.manager.c(r31, r111, r112, r210, com.bytedance.android.shopping.extensions.k.r(r35, 0), 32);
        View r37 = this.y;
        if (r37 == null) goto L63;
        r36.b(r37);
    L63:
        r36.c();
        this.A = r36;
        CartFooterRoundCornerHelper.b(getView(), this.A);
    L59:
        r35 = null;
        goto L60
    L53:
        r210 = null;
    L64:
        yf3.b.a(Y90(), "YataInit");
        X90().h();
        int r38 = AndroidYataBuilderManager.a;
        CartObjectContainer r39 = this.i;
        if (r39 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L67:
        CartYataAbilityProvider r40 = new CartYataAbilityProvider(r39);
        com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r41 = r110.a;
        CartObjectContainer r42 = this.i;
        if (r42 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L70:
        CartParams r43 = r42.e.c;
        if (r43 == null) goto L73;
        r13 = r43.getPageInfo();
    L73:
        com.bytedance.kmp.ec.yata.b r44 = AndroidYataBuilderManager.a("yata_cart", r40, r41, r13, AnonymousClass2.INSTANCE);
        com.bytedance.kmp.ec.yata.b.c(r44, (LinearLayout) r24.findViewById(2131365245));
        CartBodyComponent r45 = (CartBodyComponent) this.k.getValue();
        if (r45 == null) goto L78;
        RecyclerView r46 = r45.q();
        if (r46 == null) goto L78;
        com.bytedance.kmp.ec.yata.b.a(r44, r46);
    L78:
        com.bytedance.android.shopping.new_cart.components.f r47 = (com.bytedance.android.shopping.new_cart.components.f) this.n.getValue();
        if (r47 == null) goto L82;
        LinearLayout r48 = r47.d;
        if (r48 == null) goto L82;
    L83:
        com.bytedance.kmp.ec.yata.b.b(r44, r48);
        com.bytedance.kmp.ec.yata.b.d(r44, "save_card_sticky", (LinearLayout) r24.findViewById(2131385090));
        r44.e((FrameLayout) r24.findViewById(2131372736));
        com.bytedance.kmp.ec.yata.b.d(r44, "pendant_container", (LinearLayout) r24.findViewById(2131382098));
        this.p = r44.a;
        final CartObjectContainer r49 = this.i;
        if (r49 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L86:
        r49.c(Reflection.getOrCreateKotlinClass(CartEventCenterComponent.class), r11, new CartFragment$registerComponentsImmediately$1$1(r49));
        vf3.a r50 = W90().getMultiUpdateImpl();
        if (r50 == null) goto L92;
        AndroidYaTaInstance r51 = this.p;
        if (r51 != null) goto L91;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L91:
        r51.E(r50);
    L92:
        AndroidYaTaInstance r52 = this.p;
        if (r52 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L95:
        r52.D((TriggerInterceptorImpl) this.s.getValue());
        Lazy r53 = CartSettingUtils.a;
        Function0<Unit> r54 = new AnonymousClass5(this);
        Intrinsics.checkNotNullParameter(r54, "action");
        r54.invoke();
        X90().g();
        AndroidYaTaInstance r55 = this.p;
        if (r55 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L98:
        CartViewModel r56 = W90();
        CartObjectContainer r57 = this.i;
        if (r57 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L101:
        r55.c(new CartRenderNodeProcessor(r56, r57));
        yf3.b.a(Y90(), "InitSlcRenderContext");
        AndroidYaTaInstance r58 = this.p;
        if (r58 != null) goto L104;
        Intrinsics.throwUninitializedPropertyAccessException("yataInstance");
    L104:
        SlcRenderContext r59 = (SlcRenderContext) r58.I(Reflection.getOrCreateKotlinClass(SlcRenderContext.class));
        this.q = r59;
        if (r59 == null) goto L107;
        r59.O = com.bytedance.android.ec.core.opt.ab.t.b();
    L107:
        SlcRenderContext r60 = this.q;
        if (r60 == null) goto L110;
        r60.s(com.bytedance.android.ec.core.opt.ab.t.c());
    L110:
        vf3.c r61 = new vf3.c(W90(), this.q);
        this.u = r61;
        SlcRenderContext r62 = r61.c;
        if (r62 == null) goto L114;
        r62.Y.add(r61.a);
    L114:
        if (r25 == null) goto L118;
        if (r25.getBoolean("CART_LOAD_AGAIN") != true) goto L118;
    L120:
        yf3.b.a(Y90(), "ViewModelSubscribe");
        ISubscriber.DefaultImpls.selectSubscribe$default(this, W90(), AnonymousClass6.INSTANCE, null, new AnonymousClass7(this), 2, null);
        yf3.b.a(Y90(), "EventBusRegister");
        s0.c(this);
        if (r25 != null) goto L123;
    L131:
        bg3.a r63 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.e(7000, new c(this));
        yf3.b.a(Y90(), "OnCreateEnd");
        com.bytedance.android.shopping.new_cart.monitor.a.a();
        return;
    L123:
        if (r25.getBoolean("CART_LOAD_AGAIN") != true) goto L131;
        bg3.a r64 = com.bytedance.android.shopping.new_cart.utils.a.a;
        CartObjectContainer r65 = this.i;
        if (r65 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L127:
        com.bytedance.android.shopping.new_cart.utils.a.j("CART_LOAD_AGAIN", "CartFragment savedInstanceState LoadAgain", r65.e.j, 4);
        CartObjectContainer r66 = this.i;
        if (r66 != null) goto L130;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L130:
        r66.e.n = true;
        CartViewModel.doQuery$default(W90(), true, "first_enter", null, 4, null);
    L118:
        if (((Boolean) this.x.getValue()).booleanValue() == false) goto L120;
        Choreographer.getInstance().postFrameCallback(new CartFragment$startCacheRender$1(this));
    L82:
        r48 = (LinearLayout) r24.findViewById(2131365244);
        goto L83
    L44:
        r112 = null;
        goto L45
    L40:
        r111 = null;
        goto L41
    L30:
        r27 = null;
    L17:
        r19 = null;
        goto L18
    L8:
        r12 = r24;
        goto L9
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return th.a.c(requireContext(), 2131563705, r3, false);
    L5:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return null;
    }
}
