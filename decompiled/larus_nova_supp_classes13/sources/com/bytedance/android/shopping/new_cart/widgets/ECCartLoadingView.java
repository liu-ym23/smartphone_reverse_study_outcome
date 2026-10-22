package com.bytedance.android.shopping.new_cart.widgets;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.new_cart.container.CartObjectContainer;
import com.bytedance.android.shopping.new_cart.utils.CartViewExtentionsKt;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000e\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\nR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006)"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/ECCartLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "need", "", "setNeedHint", "Landroid/view/View;", "a", "Lkotlin/Lazy;", "getMainLayout", "()Landroid/view/View;", "mainLayout", "e", "getLoadingLayout", "loadingLayout", "Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "f", "getBallAnimationView", "()Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "ballAnimationView", "Landroid/widget/ImageView;", "g", "getIvWireframe", "()Landroid/widget/ImageView;", "ivWireframe", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "i", "Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "getCartObjectContainer", "()Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;", "setCartObjectContainer", "(Lcom/bytedance/android/shopping/new_cart/container/CartObjectContainer;)V", "cartObjectContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECCartLoadingView extends ConstraintLayout {
    public static final /* synthetic */ int l = 0;
    public final Lazy a;
    public View b;
    public LinearLayout c;
    public LinearLayout d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final AtomicBoolean h;
    public CartObjectContainer i;
    public ValueAnimator j;
    public View k;

    public ECCartLoadingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECCartLoadingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ECDuxLoadingAnimationView getBallAnimationView() {
        return (ECDuxLoadingAnimationView) this.f.getValue();
    }

    private final ImageView getIvWireframe() {
        return (ImageView) this.g.getValue();
    }

    private final View getLoadingLayout() {
        return (View) this.e.getValue();
    }

    private final View getMainLayout() {
        return (View) this.a.getValue();
    }

    public final void U5() {
        ValueAnimator r0 = this.j;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
        r0.removeAllListeners();
        r0.cancel();
        r0.end();
    L5:
        this.j = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5() {
        int r0 = com.bytedance.ies.xbridge.base.utils.c.a;
        int r1 = com.bytedance.ies.xbridge.base.utils.c.a(getContext());
        this.b = getMainLayout().findViewById(2131374270);
        CartObjectContainer r2 = this.i;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L6:
        if (r2.e.p == true) goto L15;
        View r3 = this.b;
        if (r3 == null) goto L15;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L12;
        r4 = null;
    L12:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 == null) goto L15;
        r5.topMargin = r1;
        r3.setLayoutParams(r5);
    L15:
        View r6 = this.b;
        if (r6 == null) goto L23;
        View r7 = r6.findViewById(2131376031);
        if (r7 == null) goto L23;
        CartObjectContainer r8 = this.i;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L22:
        wg.a.h(r7, r8.e.k);
        r7.setOnClickListener(new f(r7, this));
    L23:
        this.d = (LinearLayout) getMainLayout().findViewById(2131373139);
        this.c = (LinearLayout) getMainLayout().findViewById(2131387986);
        CartObjectContainer r9 = this.i;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L27:
        if (r9.e.p == false) goto L31;
        LinearLayout r10 = this.c;
        if (r10 == null) goto L49;
        ExtensionsKt.gone(r10);
    L49:
        CartViewExtentionsKt.d(getIvWireframe());
        return;
    L31:
        LinearLayout r11 = this.c;
        if (r11 == null) goto L34;
        ExtensionsKt.visible(r11);
    L34:
        LinearLayout r12 = this.c;
        if (r12 == null) goto L37;
        ViewExtensionsKt.g(r12, 0.0f, 0.0f, 20.0f, 20.0f);
    L37:
        View r13 = V5(64, 26, 14);
        View r14 = V5(64, 26, 14);
        View r15 = V5(96, 26, 14);
        LinearLayout r16 = this.c;
        if (r16 == null) goto L40;
        r16.addView(r13);
    L40:
        LinearLayout r17 = this.c;
        if (r17 == null) goto L43;
        r17.addView(r14);
    L43:
        LinearLayout r18 = this.c;
        if (r18 == null) goto L46;
        r18.addView(r15);
    L46:
        View r19 = V5(112, 44, 44);
        LinearLayout r20 = this.d;
        if (r20 == null) goto L49;
        r20.addView(r19);
        goto L49
    }

    public final CartObjectContainer getCartObjectContainer() {
        CartObjectContainer r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cartObjectContainer");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        U5();
        View r0 = this.k;
        if (r0 == null) goto L5;
        r0.setTranslationX(0.0f);
    L5:
        this.k = null;
    }

    public static final /* synthetic */ ECDuxLoadingAnimationView R5(ECCartLoadingView r0) {
        return r0.getBallAnimationView();
    }

    public static final /* synthetic */ View S5(ECCartLoadingView r0) {
        return r0.getLoadingLayout();
    }

    public static final /* synthetic */ View T5(ECCartLoadingView r0) {
        return r0.getMainLayout();
    }

    public final void setCartObjectContainer(CartObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.i = r2;
    }

    public final void setNeedHint(boolean r2) {
        this.h.set(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECCartLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new ECCartLoadingView$mainLayout$2(this));
        this.e = LazyKt.lazy(new ECCartLoadingView$loadingLayout$2(this));
        this.f = LazyKt.lazy(new ECCartLoadingView$ballAnimationView$2(this));
        this.g = LazyKt.lazy(new ECCartLoadingView$ivWireframe$2(this));
        this.h = new AtomicBoolean(true);
        LayoutInflater.from(r2).inflate(2131560399, this, true);
        if ((r2 instanceof LifecycleOwner) == false) goto L6;
        DefaultLifecycleObserver r5 = new ECCartLoadingView$observer$1(this);
        ((LifecycleOwner) r2).getLifecycle().addObserver(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View V5(int r4, int r5, int r6) {
        View r0 = new View(getContext());
        GradientDrawable r1 = new GradientDrawable();
        r1.setShape(0);
        r1.setCornerRadius(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6)));
        r1.setColor(ColorProtector.parseColor("#0D161823"));
        Unit r7 = Unit.INSTANCE;
        r0.setBackground(r1);
        ConstraintLayout.LayoutParams r8 = new ConstraintLayout.LayoutParams(com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r4)), com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r5)));
        r8.setMarginEnd(com.bytedance.android.shopping.extensions.b.b(8));
        r0.setLayoutParams(r8);
        return r0;
    }

    public /* synthetic */ ECCartLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
