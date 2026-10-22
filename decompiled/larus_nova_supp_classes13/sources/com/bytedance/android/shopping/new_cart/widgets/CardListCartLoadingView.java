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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001e\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0018\u001a\u0004\b\u001d\u0010\u001aR\u001b\u0010#\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0018\u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010'¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/CardListCartLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "need", "", "setNeedHint", "Lcom/bytedance/android/shopping/new_cart/widgets/l;", "a", "Lcom/bytedance/android/shopping/new_cart/widgets/l;", "getViewState", "()Lcom/bytedance/android/shopping/new_cart/widgets/l;", "setViewState", "(Lcom/bytedance/android/shopping/new_cart/widgets/l;)V", "viewState", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "b", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "getViewAction", "()Lcom/bytedance/android/shopping/new_cart/widgets/k;", "setViewAction", "(Lcom/bytedance/android/shopping/new_cart/widgets/k;)V", "viewAction", "Landroid/view/View;", "c", "Lkotlin/Lazy;", "getMainLayout", "()Landroid/view/View;", "mainLayout", "g", "getLoadingLayout", "loadingLayout", "Landroid/widget/ImageView;", "h", "getIvWireframe", "()Landroid/widget/ImageView;", "ivWireframe", "Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "i", "getBallAnimationView", "()Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "ballAnimationView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListCartLoadingView extends ConstraintLayout {
    public static final /* synthetic */ int m = 0;
    public l a;
    public k b;
    public final Lazy c;
    public View d;
    public LinearLayout e;
    public LinearLayout f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final AtomicBoolean j;
    public ValueAnimator k;
    public View l;

    public CardListCartLoadingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardListCartLoadingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ECDuxLoadingAnimationView getBallAnimationView() {
        return (ECDuxLoadingAnimationView) this.i.getValue();
    }

    private final ImageView getIvWireframe() {
        return (ImageView) this.h.getValue();
    }

    private final View getLoadingLayout() {
        return (View) this.g.getValue();
    }

    private final View getMainLayout() {
        return (View) this.c.getValue();
    }

    public final void U5() {
        ValueAnimator r0 = this.k;
        if (r0 == null) goto L5;
        r0.removeAllUpdateListeners();
        r0.cancel();
        r0.end();
    L5:
        this.k = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y5() {
        int r0 = com.bytedance.ies.xbridge.base.utils.c.a;
        int r1 = com.bytedance.ies.xbridge.base.utils.c.a(getContext());
        this.d = getMainLayout().findViewById(2131374270);
        k r2 = this.b;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L6:
        if (((Boolean) r2.d.invoke()).booleanValue() == true) goto L15;
        View r3 = this.d;
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
        View r6 = this.d;
        if (r6 == null) goto L23;
        View r7 = r6.findViewById(2131376031);
        if (r7 == null) goto L23;
        k r8 = this.b;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L22:
        wg.a.h(r7, ((Boolean) r8.a.invoke()).booleanValue());
        r7.setOnClickListener(new a(this));
    L23:
        this.f = (LinearLayout) getMainLayout().findViewById(2131373139);
        this.e = (LinearLayout) getMainLayout().findViewById(2131387986);
        k r9 = this.b;
        if (r9 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L27:
        if (((Boolean) r9.d.invoke()).booleanValue() == false) goto L31;
        LinearLayout r10 = this.e;
        if (r10 == null) goto L46;
        ExtensionsKt.gone(r10);
    L46:
        CartViewExtentionsKt.d(getIvWireframe());
        return;
    L31:
        LinearLayout r11 = this.e;
        if (r11 == null) goto L34;
        ExtensionsKt.visible(r11);
    L34:
        View r12 = V5(64, 26, 14);
        View r13 = V5(64, 26, 14);
        View r14 = V5(96, 26, 14);
        LinearLayout r15 = this.e;
        if (r15 == null) goto L37;
        r15.addView(r12);
    L37:
        LinearLayout r16 = this.e;
        if (r16 == null) goto L40;
        r16.addView(r13);
    L40:
        LinearLayout r17 = this.e;
        if (r17 == null) goto L43;
        r17.addView(r14);
    L43:
        View r18 = V5(112, 44, 44);
        LinearLayout r19 = this.f;
        if (r19 == null) goto L46;
        r19.addView(r18);
        goto L46
    }

    public final void Z5() {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCartLoadingView$startLoading$1(this));
    }

    public final void b6() {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCartLoadingView$stopLoading$1(this));
    }

    public final k getViewAction() {
        k r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r0;
    }

    public final l getViewState() {
        l r0 = this.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        U5();
        View r0 = this.l;
        if (r0 == null) goto L5;
        r0.setTranslationX(0.0f);
    L5:
        this.l = null;
    }

    public static final /* synthetic */ ECDuxLoadingAnimationView R5(CardListCartLoadingView r0) {
        return r0.getBallAnimationView();
    }

    public static final /* synthetic */ View S5(CardListCartLoadingView r0) {
        return r0.getLoadingLayout();
    }

    public static final /* synthetic */ View T5(CardListCartLoadingView r0) {
        return r0.getMainLayout();
    }

    public final void setNeedHint(boolean r2) {
        this.j.set(r2);
    }

    public final void setViewAction(k r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b = r2;
    }

    public final void setViewState(l r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardListCartLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new CardListCartLoadingView$mainLayout$2(this));
        this.g = LazyKt.lazy(new CardListCartLoadingView$loadingLayout$2(this));
        this.h = LazyKt.lazy(new CardListCartLoadingView$ivWireframe$2(this));
        this.i = LazyKt.lazy(new CardListCartLoadingView$ballAnimationView$2(this));
        this.j = new AtomicBoolean(true);
        LayoutInflater.from(r2).inflate(2131559253, this, true);
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

    public /* synthetic */ CardListCartLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
