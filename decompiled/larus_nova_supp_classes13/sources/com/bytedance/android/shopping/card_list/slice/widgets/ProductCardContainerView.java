package com.bytedance.android.shopping.card_list.slice.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.s;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ProductCardContainerView extends SlcFlexElementView {
    public final Scroller e;
    public int f;
    public int g;
    public int h;
    public int i;
    public final int j;
    public List<String> k;
    public String l;
    public long m;
    public long n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public final Lazy t;

    private final s getActions() {
        return (s) this.r.getValue();
    }

    private final String getMonitorId() {
        return (String) this.q.getValue();
    }

    private final CardListObjectContainer getObjectContainer() {
        return (CardListObjectContainer) this.p.getValue();
    }

    private final CardListSliceCustomWidgetAdapterComponent getProvider() {
        return (CardListSliceCustomWidgetAdapterComponent) this.o.getValue();
    }

    private final CardListTrackerComponent getTrackerComponent() {
        return (CardListTrackerComponent) this.s.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        super/*android.view.ViewGroup*/.computeScroll();
        CardListRunCatchExtKt.a(getMonitorId(), "productContainerComputeScroll", new AnonymousClass1(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        s r0 = getActions();
        if (r0 == null) goto L7;
        Function1<WeakReference<ProductCardContainerView>, Unit> r1 = r0.b;
        if (r1 == null) goto L7;
        r1.invoke(new WeakReference(null));
        Unit r2 = Unit.INSTANCE;
    L7:
        this.e.forceFinished(true);
        setTranslationX(0.0f);
    }

    public static final /* synthetic */ CardListObjectContainer g(ProductCardContainerView r0) {
        return r0.getObjectContainer();
    }

    public static final /* synthetic */ CardListSliceCustomWidgetAdapterComponent h(ProductCardContainerView r0) {
        return r0.getProvider();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(final MotionEvent r12) {
        if (r12 != null) goto L5;
        return false;
    L5:
        s r1 = getActions();
        if (r1 == null) goto L17;
        Function0<WeakReference<ProductCardContainerView>> r2 = r1.a;
        if (r2 == null) goto L17;
        WeakReference r3 = (WeakReference) r2.invoke();
        if (r3 == null) goto L17;
        ProductCardContainerView r4 = (ProductCardContainerView) r3.get();
        if (r4 == null) goto L17;
        if ((!Intrinsics.areEqual(r4, this)) == false) goto L17;
        i(r4, false);
    L17:
        if (((Boolean) this.t.getValue()).booleanValue() == true) goto L19;
        s r5 = getActions();
        if (r5 == null) goto L25;
        Function1<WeakReference<ProductCardContainerView>, Unit> r6 = r5.g;
        if (r6 == null) goto L25;
        r6.invoke(new WeakReference(this));
    L25:
        Lazy r7 = CartCommonLog.a;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass4(r12));
        int r8 = (int) getTranslationX();
        int r9 = (int) r12.getRawX();
        int r10 = r12.getAction();
        if (r10 != 0) goto L28;
        this.m = System.currentTimeMillis();
        this.h = (int) r12.getRawX();
        this.i = (int) r12.getRawY();
        this.f = (int) r12.getRawX();
    L61:
        return super/*com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout*/.dispatchTouchEvent(r12);
    L28:
        if (r10 == 1) goto L36;
        if (r10 != 2) goto L61;
        int r11 = this.f - r9;
        this.f = r9;
        int r13 = Math.abs(r9 - this.h);
        int r14 = Math.abs(((int) r12.getRawY()) - this.i);
        if (r13 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L61;
        if (r13 <= r14) goto L61;
        getParent().requestDisallowInterceptTouchEvent(true);
        setTranslationX(-Math.min(this.g, Math.max(0, r11 - r8)));
        return true;
    L36:
        this.n = System.currentTimeMillis();
        final int r15 = r9 - this.h;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass5(this, r15));
        if (Math.abs(r15) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L61;
        CardListObjectContainer r16 = getObjectContainer();
        if (r16 == null) goto L45;
        com.bytedance.android.shopping.card_list.common_params.a r17 = r16.e;
        if (r17 == null) goto L45;
        Map<String, ?> r18 = r17.a();
        if (r18 == null) goto L45;
        Object r19 = r18.get("new_del_express");
    L46:
        boolean r110 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r19);
        if ((this.n - this.m) >= this.j) goto L53;
        if (r110 == false) goto L53;
        if (r15 >= 0) goto L51;
        i(this, true);
        CartCommonLog.a("ProductCardContainerView", AnonymousClass6.INSTANCE);
    L57:
        cancelLongPress();
        return true;
    L51:
        i(this, false);
        CartCommonLog.a("ProductCardContainerView", AnonymousClass7.INSTANCE);
    L53:
        if (Math.abs(r8) >= (this.g / 2)) goto L55;
        i(this, false);
    L56:
        CartCommonLog.a("ProductCardContainerView", AnonymousClass8.INSTANCE);
        goto L57
    L55:
        i(this, true);
    L45:
        r19 = null;
        goto L46
    L19:
        return super/*com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout*/.dispatchTouchEvent(r12);
    }

    public ProductCardContainerView(Context r3, final SlcTemplateContext r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.e = new Scroller(r3);
        Resources r0 = Resources.getSystem();
        this.g = MathKt.roundToInt(TypedValue.applyDimension(1, 210, WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics())));
        this.j = 400;
        this.k = CollectionsKt.emptyList();
        this.l = "";
        this.o = LazyKt.lazy(new ProductCardContainerView$provider$2(r4));
        this.p = LazyKt.lazy(new ProductCardContainerView$objectContainer$2(this));
        this.q = LazyKt.lazy(new ProductCardContainerView$monitorId$2(this));
        this.r = LazyKt.lazy(new ProductCardContainerView$actions$2(this));
        this.s = LazyKt.lazy(new ProductCardContainerView$trackerComponent$2(this));
        this.t = LazyKt.lazy(new ProductCardContainerView$isFromGuest$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(ProductCardContainerView r13, boolean r14) {
        int r1 = (int) r13.getTranslationX();
        if (r14 == false) goto L41;
        s r15 = r13.getActions();
        if (r15 == null) goto L9;
        Function1<WeakReference<ProductCardContainerView>, Unit> r16 = r15.b;
        if (r16 == null) goto L9;
        r16.invoke(new WeakReference(r13));
    L9:
        r13.e.startScroll(r1, 0, (-r13.g) - r1, 0, 200);
        Iterator<T> r17 = r13.k.iterator();
    L11:
        if (r17.hasNext() == false) goto L30;
        String r0 = (String) r17.next();
        CardListObjectContainer r2 = r13.getObjectContainer();
        if (r2 == null) goto L17;
        CardListContainerConfig r3 = r2.f;
        if (r3 == null) goto L17;
        LauncherBizType r4 = r3.getBizType();
    L19:
        if (r4 != LauncherBizType.CART) goto L11;
        CardListObjectContainer r5 = r13.getObjectContainer();
        if (r5 == null) goto L26;
        CardListContainerConfig r6 = r5.f;
        if (r6 == null) goto L26;
        String r7 = r6.getStandardShowEventName();
        if (r7 == null) goto L26;
    L27:
        CardListTrackerComponent r8 = r13.getTrackerComponent();
        if (r8 == null) goto L11;
        CardListTrackerComponent.h(r8, r7, MapsKt.mapOf(new Pair[]{TuplesKt.to("tab_name", r0), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r13.l)}), 4);
    L26:
        r7 = "card_list_tab_show";
    L17:
        r4 = null;
        goto L19
    L30:
        CardListObjectContainer r18 = r13.getObjectContainer();
        if (r18 == null) goto L35;
        CardListContainerConfig r19 = r18.f;
        if (r19 == null) goto L35;
        LauncherBizType r110 = r19.getBizType();
    L37:
        if (r110 != LauncherBizType.COLLECT) goto L46;
        BaseSlcViewManager r111 = SlcViewExtensionsKt.g(r13);
        if (r111 == null) goto L46;
        r111.a.d(new SlcCommonAction("collectListDeleteShow", null, 2, null), r13, r111.l(), null, null);
    L46:
        r13.invalidate();
        return;
    L35:
        r110 = null;
        goto L37
    L41:
        r13.e.startScroll(r1, 0, -r1, 0, 200);
        s r112 = r13.getActions();
        if (r112 == null) goto L46;
        Function1<WeakReference<ProductCardContainerView>, Unit> r113 = r112.b;
        if (r113 == null) goto L46;
        r113.invoke(new WeakReference(null));
        goto L46
    }
}
