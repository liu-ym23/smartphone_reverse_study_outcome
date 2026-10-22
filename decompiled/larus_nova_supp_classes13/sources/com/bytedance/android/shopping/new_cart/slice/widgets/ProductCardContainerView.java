package com.bytedance.android.shopping.new_cart.slice.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.container.b0;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import com.bytedance.android.shopping.new_cart.viewmodel.CartViewModel;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.larus.apm.impl.protector.RunnableProtector;
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
    public final Lazy k;
    public long l;
    public long m;
    public List<String> n;
    public String o;
    public final b0 p;
    public final CartObjectContainer q;

    public static final class a implements Runnable {
        public final /* synthetic */ ProductCardContainerView a;

        public a(ProductCardContainerView r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [android.view.ViewGroup, com.bytedance.android.shopping.new_cart.slice.widgets.ProductCardContainerView] */
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
        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.e.computeScrollOffset() == false) goto L9;
            ?? r0 = this.a;     // Catch: Throwable -> L6
            r0.setTranslationX(r0.e.getCurrX());     // Catch: Throwable -> L6
            this.a.invalidate();     // Catch: Throwable -> L6
            return;
        }
    }

    private final CartViewModel getCartVM() {
        return (CartViewModel) this.k.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        b0 r0 = this.p;
        if (r0 == null) goto L7;
        Function1<WeakReference<ProductCardContainerView>, Unit> r1 = r0.b;
        if (r1 == null) goto L7;
        r1.invoke(new WeakReference(null));
        Unit r2 = Unit.INSTANCE;
    L7:
        this.e.forceFinished(true);
        setTranslationX(0.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        super/*android.view.ViewGroup*/.computeScroll();
        bg3.a r0 = com.bytedance.android.shopping.new_cart.utils.a.a;
        com.bytedance.android.shopping.new_cart.utils.a.c(getCartVM(), "productContainerComputeScroll", new a(this), null);
    }

    public final b0 getActions() {
        return this.p;
    }

    public final CartObjectContainer getObjectContainer() {
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(final MotionEvent r12) {
        if (r12 != null) goto L5;
        return false;
    L5:
        b0 r1 = this.p;
        if (r1 == null) goto L16;
        Function0<WeakReference<ProductCardContainerView>> r2 = r1.a;
        if (r2 == null) goto L16;
        WeakReference r3 = (WeakReference) r2.invoke();
        if (r3 == null) goto L16;
        ProductCardContainerView r4 = (ProductCardContainerView) r3.get();
        if (r4 == null) goto L16;
        if ((!Intrinsics.areEqual(r4, this)) == false) goto L16;
        g(r4, false);
    L16:
        Lazy r5 = CartCommonLog.a;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass3(r12));
        int r6 = (int) getTranslationX();
        int r7 = (int) r12.getRawX();
        int r8 = r12.getAction();
        if (r8 != 0) goto L19;
        this.l = System.currentTimeMillis();
        this.h = (int) r12.getRawX();
        this.i = (int) r12.getRawY();
        this.f = (int) r12.getRawX();
    L51:
        return super/*com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout*/.dispatchTouchEvent(r12);
    L19:
        if (r8 == 1) goto L27;
        if (r8 != 2) goto L51;
        int r9 = this.f - r7;
        this.f = r7;
        int r10 = Math.abs(r7 - this.h);
        int r11 = Math.abs(((int) r12.getRawY()) - this.i);
        if (r10 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L51;
        if (r10 <= r11) goto L51;
        getParent().requestDisallowInterceptTouchEvent(true);
        setTranslationX(-Math.min(this.g, Math.max(0, r9 - r6)));
        return true;
    L27:
        this.m = System.currentTimeMillis();
        final int r13 = r7 - this.h;
        CartCommonLog.a("ProductCardContainerView", new AnonymousClass4(this, r13));
        if (Math.abs(r13) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L51;
        CartObjectContainer r14 = this.q;
        if (r14 == null) goto L36;
        com.bytedance.android.shopping.new_cart.container.b r15 = r14.e;
        if (r15 == null) goto L36;
        Map<String, ?> r16 = r15.a();
        if (r16 == null) goto L36;
        Object r17 = r16.get("new_del_express");
    L37:
        boolean r18 = com.bytedance.android.ecom.arch.slice.render.util.b.a(r17);
        if ((this.m - this.l) >= this.j) goto L44;
        if (r18 == false) goto L44;
        if (r13 >= 0) goto L42;
        g(this, true);
        CartCommonLog.a("ProductCardContainerView", AnonymousClass5.INSTANCE);
    L48:
        return true;
    L42:
        g(this, false);
        CartCommonLog.a("ProductCardContainerView", AnonymousClass6.INSTANCE);
    L44:
        if (Math.abs(r6) >= (this.g / 2)) goto L46;
        g(this, false);
    L47:
        CartCommonLog.a("ProductCardContainerView", AnonymousClass7.INSTANCE);
        goto L48
    L46:
        g(this, true);
    L36:
        r17 = null;
        goto L37
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(ProductCardContainerView r7, boolean r8) {
        int r1 = (int) r7.getTranslationX();
        if (r8 == false) goto L15;
        b0 r9 = r7.p;
        if (r9 == null) goto L9;
        Function1<WeakReference<ProductCardContainerView>, Unit> r10 = r9.b;
        if (r10 == null) goto L9;
        r10.invoke(new WeakReference(r7));
    L9:
        r7.e.startScroll(r1, 0, (-r7.g) - r1, 0, 200);
        Iterator<T> r11 = r7.n.iterator();
    L11:
        if (r11.hasNext() == false) goto L20;
        String r0 = (String) r11.next();
        CartViewModel r2 = r7.getCartVM();
        if (r2 == null) goto L11;
        CartViewModel.doEventAction$default(r2, "cart_list_tab_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("tab_name", r0), TuplesKt.to(PdpOpenThirdParam.KEY_PRODUCT_ID, r7.o)}), null, 4, null);
    L20:
        r7.invalidate();
        return;
    L15:
        r7.e.startScroll(r1, 0, -r1, 0, 200);
        b0 r12 = r7.p;
        if (r12 == null) goto L20;
        Function1<WeakReference<ProductCardContainerView>, Unit> r13 = r12.b;
        if (r13 == null) goto L20;
        r13.invoke(new WeakReference(null));
        goto L20
    }

    public ProductCardContainerView(Context r3, b0 r4, CartObjectContainer r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        this.p = r4;
        this.q = r5;
        this.e = new Scroller(r3);
        Resources r6 = Resources.getSystem();
        this.g = MathKt.roundToInt(TypedValue.applyDimension(1, 210, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        this.j = 400;
        this.k = LazyKt.lazy(new ProductCardContainerView$cartVM$2(this));
        this.n = CollectionsKt.emptyList();
        this.o = "";
    }
}
