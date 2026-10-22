package com.bytedance.android.shopping.card_list.slice.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.util.SlcDimensExtensionsKt;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundLinearlayout;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.components.s;
import com.bytedance.android.shopping.new_cart.utils.CartCommonLog;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BottomButtonContainerView extends SlcRoundLinearlayout {
    public final Lazy a;
    public final int b;
    public int c;

    private final CardListSliceCustomWidgetAdapterComponent getProvider() {
        return (CardListSliceCustomWidgetAdapterComponent) this.a.getValue();
    }

    private final int getScreenWidth() {
        CardListSliceCustomWidgetAdapterComponent r0 = getProvider();
        if (r0 == null) goto L11;
        s r1 = r0.i;
        if (r1 == null) goto L11;
        Function0<Integer> r2 = r1.h;
        if (r2 == null) goto L11;
        Integer r3 = (Integer) r2.invoke();
        if (r3 == null) goto L11;
        return r3.intValue();
    L11:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(final MotionEvent r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        int r1 = r6.getAction();
        if (r1 != 0) goto L8;
        this.c = (int) r6.getRawX();
    L32:
        return super/*android.widget.LinearLayout*/.dispatchTouchEvent(r6);
    L8:
        if (r1 != 1) goto L10;
        final int r2 = Math.abs(((int) r6.getRawX()) - this.c);
        Lazy r4 = CartCommonLog.a;
        CartCommonLog.a("BottomButtonContainerView", new AnonymousClass2(this, r2, r6));
        if (r2 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L32;
        CardListSliceCustomWidgetAdapterComponent r7 = getProvider();
        if (r7 == null) goto L29;
        s r8 = r7.i;
        if (r8 == null) goto L29;
        Function0<WeakReference<ProductCardContainerView>> r9 = r8.a;
        if (r9 == null) goto L29;
        WeakReference r10 = (WeakReference) r9.invoke();
        if (r10 == null) goto L29;
        ProductCardContainerView r11 = (ProductCardContainerView) r10.get();
        if (r11 == null) goto L29;
        ProductCardContainerView.i(r11, false);
    L29:
        return true;
    L10:
        if (r1 != 2) goto L32;
        final int r0 = Math.abs(((int) r6.getRawX()) - this.c);
        Lazy r3 = CartCommonLog.a;
        CartCommonLog.a("BottomButtonContainerView", new AnonymousClass1(this, r0, r6));
        if (r0 <= ViewConfiguration.get(getContext()).getScaledTouchSlop()) goto L32;
        getParent().requestDisallowInterceptTouchEvent(true);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomButtonContainerView(Context r3, final SlcTemplateContext r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "slcTemplateContext");
        super(r3, null, 0);
        this.a = LazyKt.lazy(new BottomButtonContainerView$provider$2(r4));
        this.b = 70;
        setOrientation(0);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.ViewGroup, com.bytedance.android.shopping.card_list.slice.widgets.ProductCardContainerView] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public static final void b(final BottomButtonContainerView r5, final View r6, String r7, com.bytedance.android.ecom.arch.slice.render.context.b r8, int r9) {
        r5.getClass();
        ViewParent r0 = r6.getParent();
        final ?? r2 = 0;
        r2 = 0;
        r2 = 0;
        r2 = 0;
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        r1.setLayoutDirection(0);
    L8:
        CardListSliceCustomWidgetAdapterComponent r3 = r5.getProvider();
        if (r3 == null) goto L17;
        s r4 = r3.i;
        if (r4 == null) goto L17;
        Function0<WeakReference<ProductCardContainerView>> r10 = r4.a;
        if (r10 == null) goto L17;
        WeakReference r11 = (WeakReference) r10.invoke();
        if (r11 == null) goto L17;
        r2 = (ProductCardContainerView) r11.get();
    L17:
        if (r2 == 0) goto L19;
        final float r12 = r2.getTranslationX();
    L20:
        if (r2 == 0) goto L22;
        int r13 = r2.getWidth();
    L23:
        ValueAnimator r14 = ValueAnimator.ofInt(new int[]{0, r13 - (SlcDimensExtensionsKt.a(Integer.valueOf(r5.b), r8) * r9)});
        r14.setDuration(200);
        r14.addUpdateListener(new BottomButtonContainerView$startButtonAnimation$$inlined$apply$lambda$1(r5, r6, r2, r12));
        r14.addListener(new b(r5, r6, r7));
        r14.start();
        return;
    L22:
        r13 = r5.getScreenWidth();
        goto L23
    L19:
        r12 = 0.0f;
        goto L20
    }
}
