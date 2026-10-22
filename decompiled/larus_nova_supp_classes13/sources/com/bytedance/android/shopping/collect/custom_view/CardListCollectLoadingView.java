package com.bytedance.android.shopping.collect.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.shopping.new_cart.widgets.k;
import com.bytedance.android.shopping.new_cart.widgets.l;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010(\u001a\u00020'¢\u0006\u0004\b)\u0010*R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\u001d\u0010\"\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010!¨\u0006+"}, d2 = {"Lcom/bytedance/android/shopping/collect/custom_view/CardListCollectLoadingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/new_cart/widgets/l;", "a", "Lcom/bytedance/android/shopping/new_cart/widgets/l;", "getViewState", "()Lcom/bytedance/android/shopping/new_cart/widgets/l;", "setViewState", "(Lcom/bytedance/android/shopping/new_cart/widgets/l;)V", "viewState", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "b", "Lcom/bytedance/android/shopping/new_cart/widgets/k;", "getViewAction", "()Lcom/bytedance/android/shopping/new_cart/widgets/k;", "setViewAction", "(Lcom/bytedance/android/shopping/new_cart/widgets/k;)V", "viewAction", "Landroid/view/View;", "c", "Lkotlin/Lazy;", "getSkeletonContainer", "()Landroid/view/View;", "skeletonContainer", "d", "getTitle", "title", "e", "getSkeletonView", "skeletonView", "Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "f", "getBallAnimationView", "()Lcom/bytedance/android/ui/ec/widget/loading/ECDuxLoadingAnimationView;", "ballAnimationView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListCollectLoadingView extends ConstraintLayout {
    public l a;
    public k b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;

    public CardListCollectLoadingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CardListCollectLoadingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ECDuxLoadingAnimationView getBallAnimationView() {
        return (ECDuxLoadingAnimationView) this.f.getValue();
    }

    private final View getSkeletonContainer() {
        return (View) this.c.getValue();
    }

    private final View getSkeletonView() {
        return (View) this.e.getValue();
    }

    private final View getTitle() {
        return (View) this.d.getValue();
    }

    public final void V5() {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCollectLoadingView$stopLoading$1(this));
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

    public final void T5() {
        View r0 = getTitle();
        if (r0 == null) goto L8;
        k r2 = this.b;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L7:
        wg.a.h(r0, ((Boolean) r2.a.invoke()).booleanValue());
    L8:
        View r1 = getSkeletonView();
        if (r1 == null) goto L17;
        k r3 = this.b;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L14:
        if (((Boolean) r3.c.invoke()).booleanValue() == false) goto L16;
        r1.setBackgroundResource(2131234318);
        goto L17
    L16:
        r1.setBackgroundResource(2131234319);
    L17:
        requestLayout();
    }

    public static final /* synthetic */ ECDuxLoadingAnimationView R5(CardListCollectLoadingView r0) {
        return r0.getBallAnimationView();
    }

    public static final /* synthetic */ View S5(CardListCollectLoadingView r0) {
        return r0.getSkeletonContainer();
    }

    public final void U5(final boolean r2) {
        com.bytedance.android.shopping.card_list.utils.a.HandlerC0036a r0 = com.bytedance.android.shopping.card_list.utils.a.a;
        com.bytedance.android.shopping.card_list.utils.a.b(new CardListCollectLoadingView$startLoading$1(this, r2));
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
    public CardListCollectLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = LazyKt.lazy(new CardListCollectLoadingView$skeletonContainer$2(this));
        this.d = LazyKt.lazy(new CardListCollectLoadingView$title$2(this));
        this.e = LazyKt.lazy(new CardListCollectLoadingView$skeletonView$2(this));
        this.f = LazyKt.lazy(new CardListCollectLoadingView$ballAnimationView$2(this));
        LayoutInflater.from(r2).inflate(2131559254, this, true);
    }

    public /* synthetic */ CardListCollectLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
