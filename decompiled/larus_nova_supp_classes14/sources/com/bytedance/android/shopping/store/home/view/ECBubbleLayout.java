package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.shopping.store.tabkit.view.RedDotView;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECBubbleLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "a", "Lkotlin/Lazy;", "getIconView", "()Lcom/bytedance/android/ui/ec/widget/ecdraweeview/ECDraweeView;", "iconView", "b", "getBubbleView", "bubbleView", "Lcom/bytedance/android/shopping/store/tabkit/view/RedDotView;", "c", "getRedDotView", "()Lcom/bytedance/android/shopping/store/tabkit/view/RedDotView;", "redDotView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECBubbleLayout extends FrameLayout {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;

    public ECBubbleLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECBubbleLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final ECDraweeView getBubbleView() {
        return (ECDraweeView) this.b.getValue();
    }

    private final ECDraweeView getIconView() {
        return (ECDraweeView) this.a.getValue();
    }

    private final RedDotView getRedDotView() {
        return (RedDotView) this.c.getValue();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        setMeasuredDimension(getIconView().getMeasuredWidth(), getIconView().getMeasuredHeight());
    }

    public ECBubbleLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new ECBubbleLayout$iconView$2(this));
        this.b = LazyKt.lazy(new ECBubbleLayout$bubbleView$2(this));
        this.c = LazyKt.lazy(new ECBubbleLayout$redDotView$2(this));
        setClipChildren(false);
    }

    public static void a(int r3, int r4, View r5) {
        r5.layout(r4 - (r5.getMeasuredWidth() / 2), r3 - (r5.getMeasuredHeight() / 2), (r4 - (r5.getMeasuredWidth() / 2)) + r5.getMeasuredWidth(), (r3 - (r5.getMeasuredHeight() / 2)) + r5.getMeasuredHeight());
    }

    public /* synthetic */ ECBubbleLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        int r6 = getIconView().getRight();
        int r7 = getIconView().getTop();
        a(r7, r6, getRedDotView());
        a(r7, r6, getBubbleView());
    }
}
