package com.bytedance.android.shopping.collect.slice.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.NestedScrollingParent3;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.elements.flexbox.SlcFlexElementView;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u000fR\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/collect/slice/widgets/ProductCardContainerView;", "Lcom/bytedance/android/ecom/arch/slice/render/elements/flexbox/SlcFlexElementView;", "Landroidx/core/view/NestedScrollingParent3;", "Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", "k", "Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", "getSlcTemplateContext", "()Lcom/bytedance/android/ecom/arch/slice/render/context/SlcTemplateContext;", "slcTemplateContext", "Lcom/bytedance/android/shopping/collect/slice/a;", "l", "Lcom/bytedance/android/shopping/collect/slice/a;", "getActions", "()Lcom/bytedance/android/shopping/collect/slice/a;", "actions", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ProductCardContainerView extends SlcFlexElementView implements NestedScrollingParent3 {
    public final Scroller e;
    public int f;
    public int g;
    public int h;
    public int i;
    public List<String> j;
    public final SlcTemplateContext k;
    public final com.bytedance.android.shopping.collect.slice.a l;

    public static final class a {
    }

    static {
    }

    public final void onNestedPreScroll(View r1, int r2, int r3, int[] r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r4, "consumed");
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r1, "target");
    }

    public final void onNestedScroll(View r1, int r2, int r3, int r4, int r5, int r6, int[] r7) {
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r7, "consumed");
    }

    public final void onNestedScrollAccepted(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
    }

    public final boolean onStartNestedScroll(View r1, View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r1, "child");
        Intrinsics.checkNotNullParameter(r2, "target");
        return true;
    }

    public final void onStopNestedScroll(View r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "target");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        com.bytedance.android.shopping.collect.slice.a r0 = this.l;
        if (r0 == null) goto L5;
        Function0<ProductCardContainerView> r2 = r0.a;
    L6:
        if (r2 != null) goto L8;
    L10:
        this.e.forceFinished(true);
        setTranslationX(0.0f);
        return;
    L8:
        if (Intrinsics.areEqual((ProductCardContainerView) r0.a.invoke(), this) == false) goto L10;
        this.l.b.invoke(null);
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void computeScroll() {
        super/*android.view.ViewGroup*/.computeScroll();
        if (this.e.computeScrollOffset() == false) goto L6;
        setTranslationX(this.e.getCurrX());
        invalidate();
        return;
    }

    public final com.bytedance.android.shopping.collect.slice.a getActions() {
        return this.l;
    }

    public final SlcTemplateContext getSlcTemplateContext() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.view.ViewGroup*/.onAttachedToWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r7) {
        Object r0 = this.k.w.g("yataInstance");
        Function0<ProductCardContainerView> r2 = null;
        if ((r0 instanceof AndroidYaTaInstance) == true) goto L5;
        r0 = null;
    L5:
        AndroidYaTaInstance r1 = (AndroidYaTaInstance) r0;
        if (r1 == null) goto L12;
        Object r3 = r1.i("is_from_guest");
        if (r3 == null) goto L12;
        String r4 = r3.toString();
        if (r4 == null) goto L12;
        boolean r5 = k.n(r4, false);
    L13:
        if (r5 == true) goto L15;
        if (r7 != null) goto L18;
        return false;
    L18:
        com.bytedance.android.shopping.collect.slice.a r6 = this.l;
        if (r6 == null) goto L23;
        Function1<ProductCardContainerView, Unit> r8 = r6.d;
        if (r8 == null) goto L23;
        r8.invoke(this);
    L23:
        com.bytedance.android.shopping.collect.slice.a r9 = this.l;
        if (r9 == null) goto L27;
        r2 = r9.a;
    L27:
        if (r2 != null) goto L29;
    L35:
        int r10 = (int) getTranslationX();
        int r11 = (int) r7.getRawX();
        int r12 = r7.getAction();
        if (r12 != 0) goto L38;
        this.h = r11;
        this.f = r11;
        this.i = 0;
    L57:
        if (this.i != 1) goto L59;
    L60:
        return true;
    L59:
        if (super/*com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout*/.dispatchTouchEvent(r7) == true) goto L60;
        return false;
    L38:
        if (r12 == 1) goto L46;
        if (r12 != 2) goto L41;
        int r13 = this.f - r11;
        this.f = r11;
        if (Math.abs(r11 - this.h) <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L57;
        getParent().requestDisallowInterceptTouchEvent(true);
        setTranslationX(-Math.min(this.g, Math.max(0, r13 - r10)));
        this.i = 1;
        goto L57
    L41:
        if (r12 != 3) goto L57;
    L46:
        this.f = 0;
        this.h = 0;
        if (this.i != 1) goto L57;
        if (ECSettingKeys.s() == false) goto L52;
        cancelLongPress();
    L52:
        if (Math.abs(r10) >= (this.g / 2)) goto L54;
        g(this, false);
        goto L57
    L54:
        g(this, true);
        goto L57
    L29:
        if (r9.a.invoke() == null) goto L35;
        if ((!Intrinsics.areEqual((ProductCardContainerView) this.l.a.invoke(), this)) == false) goto L35;
        ProductCardContainerView r14 = (ProductCardContainerView) this.l.a.invoke();
        if (r14 == null) goto L35;
        g(r14, false);
        goto L35
    L15:
        return super/*com.bytedance.android.ecom.arch.slice.render.widget.yoga.SlcYogaLayout*/.dispatchTouchEvent(r7);
    L12:
        r5 = false;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(ProductCardContainerView r7, boolean r8) {
        int r1 = (int) r7.getTranslationX();
        if (r8 == false) goto L12;
        com.bytedance.android.shopping.collect.slice.a r9 = r7.l;
        if (r9 == null) goto L9;
        Function1<ProductCardContainerView, Unit> r10 = r9.b;
        if (r10 == null) goto L9;
        r10.invoke(r7);
    L9:
        r7.e.startScroll(r1, 0, (-r7.g) - r1, 0, 200);
        BaseSlcViewManager r11 = SlcViewExtensionsKt.g(r7);
        if (r11 == null) goto L20;
        r11.a.d(new SlcCommonAction("collectListDeleteShow", null, 2, null), r7, r11.l(), null, null);
    L20:
        r7.invalidate();
        return;
    L12:
        r7.e.startScroll(r1, 0, -r1, 0, 200);
        com.bytedance.android.shopping.collect.slice.a r12 = r7.l;
        if (r12 == null) goto L15;
        Function0<ProductCardContainerView> r0 = r12.a;
    L16:
        if (r0 == null) goto L20;
        if (Intrinsics.areEqual((ProductCardContainerView) r12.a.invoke(), r7) == false) goto L20;
        r7.l.b.invoke(null);
        goto L20
    L15:
        r0 = null;
        goto L16
    }

    public ProductCardContainerView(Context r3, SlcTemplateContext r4, com.bytedance.android.shopping.collect.slice.a r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.k = r4;
        this.l = r5;
        this.e = new Scroller(r3);
        Resources r6 = Resources.getSystem();
        this.g = MathKt.roundToInt(TypedValue.applyDimension(1, 210, WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics())));
        this.j = CollectionsKt.emptyList();
    }
}
