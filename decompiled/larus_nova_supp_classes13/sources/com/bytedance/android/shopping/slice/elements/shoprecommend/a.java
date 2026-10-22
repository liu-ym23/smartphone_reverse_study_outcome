package com.bytedance.android.shopping.slice.elements.shoprecommend;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcRenderContext;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.scroll.SlcScrollElementView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends SlcScrollElementView {
    public int f;
    public int g;
    public int h;
    public long i;
    public Function1<? super Integer, Unit> j;
    public float k;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.slice.elements.shoprecommend.a$a, reason: collision with other inner class name */
    public static final class RunnableC0187a implements Runnable {
        public final /* synthetic */ a a;

        public RunnableC0187a(a r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.widget.HorizontalScrollView, com.bytedance.android.shopping.slice.elements.shoprecommend.a] */
        /* JADX WARN: Type inference failed for: r2v0, types: [android.widget.HorizontalScrollView, com.bytedance.android.shopping.slice.elements.shoprecommend.a] */
        /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View, com.bytedance.android.shopping.slice.elements.shoprecommend.a] */
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
        public final void a() {
            ?? r0 = this.a;
            int r1 = r0.getWidth();
            ?? r2 = this.a;
            r0.f = r1 * r2.h;
            r2.scrollTo(r2.f, 0);
            if (this.a.getChildCount() <= 0) goto L13;
            int r3 = com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(this.a), 0)).size();
            ?? r4 = this.a;
            if (r3 <= r4.h) goto L14;
            Object r5 = ListProtector.get(com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a((View) ListProtector.get(com.bytedance.commerce.base.view.b.a(r4), 0)), this.a.h)), 0);
            if ((r5 instanceof ki3.a) == true) goto L9;
            r5 = null;
        L9:
            SlcScrollElementView r6 = (ki3.a) r5;
            if (r6 == null) goto L15;
            r6.scrollTo(0, 0);
            return;
        L15:
            return;
        L14:
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

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        if (this.h >= 0) goto L6;
        setPosition(0);
        this.i = System.currentTimeMillis();
        return;
    L6:
        long r2 = System.currentTimeMillis() - this.i;
        BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this);
        if (r0 == null) goto L11;
        SlcTemplateContext r4 = r0.a;
        if (r4 == null) goto L11;
        SlcTemplateContext.e(r4, new SlcCommonAction("tracker", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_name", "pdp_shop_recommend_tab_duration"), TuplesKt.to("params", MapsKt.mapOf(new Pair[]{TuplesKt.to("shop_recommend_tab_index", Integer.valueOf(this.h)), TuplesKt.to("shop_recommend_tab_duration", Long.valueOf(r2))}))})), this, null, null, 24);
    L11:
        this.i = System.currentTimeMillis();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getBaseScrollX() {
        return getScrollX() - this.f;
    }

    public final int getTabCount() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, null, 6, 0);
        setOverScrollMode(2);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.h = -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setPosition(int r2) {
        this.h = r2;
        post(new c(this));
        Function1<? super Integer, Unit> r3 = this.j;
        if (r3 == null) goto L6;
        Unit r4 = (Unit) r3.invoke(Integer.valueOf(this.h));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(int r1) {
        c();
        setPosition(r1);
        post(new RunnableC0187a(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTouchEvent(MotionEvent r8) {
        Intrinsics.checkNotNullParameter(r8, "ev");
        int r0 = getWidth();
        int r1 = r8.getAction();
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L11;
        if (this.k != 0.0f) goto L11;
        this.k = r8.getX();
    L11:
        return super/*android.widget.HorizontalScrollView*/.onTouchEvent(r8);
    L13:
        if (getScrollX() >= (getChildAt(0).getWidth() - getWidth())) goto L15;
    L18:
        int r9 = getBaseScrollX();
        if (r9 <= (r0 / 4)) goto L21;
        smoothScrollTo(this.f + r0, 0);
        this.f += r0;
        c();
        int r10 = this.h;
        d(r10 + 1, r10);
        setPosition(this.h + 1);
    L27:
        this.k = 0.0f;
        return true;
    L21:
        if (r9 <= 0) goto L23;
        smoothScrollTo(this.f + 0, 0);
        goto L27
    L23:
        int r2 = -r0;
        if (r9 <= (r2 / 4)) goto L26;
        smoothScrollTo(this.f + 0, 0);
        goto L27
    L26:
        smoothScrollTo(r2 + this.f, 0);
        this.f -= r0;
        post(new b(this, this.h - 1));
        c();
        int r11 = this.h;
        d(r11 - 1, r11);
        setPosition(this.h - 1);
        goto L27
    L15:
        if ((r8.getX() - this.k) >= 0) goto L18;
        callOnClick();
        this.k = 0.0f;
        return true;
    }

    public final void setOnTabChangeListener(Function1<? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.j = r2;
    }

    public final void setTabCount(int r1) {
        this.g = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(int r8, int r9) {
        BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this);
        if (r0 == null) goto L8;
        SlcTemplateContext r1 = r0.a;
        if (r1 == null) goto L9;
        SlcTemplateContext.e(r1, new SlcCommonAction("tracker", MapsKt.mapOf(new Pair[]{TuplesKt.to("event_name", "pdp_shop_recommend_tab_slide"), TuplesKt.to("params", MapsKt.mapOf(new Pair[]{TuplesKt.to("shop_recommend_tab_index", Integer.valueOf(r8)), TuplesKt.to("shop_recommend_last_tab_index", Integer.valueOf(r9))}))})), this, null, null, 24);
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onScrollChanged(int r2, int r3, int r4, int r5) {
        super.onScrollChanged(r2, r3, r4, r5);
        float r6 = r2;
        BaseSlcViewManager r7 = SlcViewExtensionsKt.g(this);
        View r8 = null;
        if (r7 == null) goto L9;
        SlcTemplateContext r9 = r7.a;
        if (r9 == null) goto L9;
        if (r9.w == null) goto L9;
        View r10 = SlcRenderContext.f(this, "iesec_pdp_shop_recommend_bottom_slider_core");
    L10:
        BaseSlcViewManager r11 = SlcViewExtensionsKt.g(this);
        if (r11 == null) goto L17;
        SlcTemplateContext r12 = r11.a;
        if (r12 == null) goto L17;
        if (r12.w == null) goto L17;
        r8 = SlcRenderContext.f(this, "iesec_pdp_shop_recommend_bottom_slider");
    L17:
        if (r10 == null) goto L21;
        if (r8 == null) goto L22;
        r10.setX((r8.getWidth() - r10.getWidth()) * (r6 / ((this.g - 1) * getWidth())));
        requestLayout();
        return;
    L22:
        return;
    L21:
        return;
    L9:
        r10 = null;
        goto L10
    }
}
