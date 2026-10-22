package com.bytedance.android.window.shop.innerflow.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowInnerFlowAddShopCartView;", "Lcom/bytedance/android/window/shop/innerflow/widget/ECWindowAddShopCartView;", "Landroid/widget/TextView;", "getAndAddDotTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowAddShopCartView extends ECWindowAddShopCartView {
    public ECWindowInnerFlowAddShopCartView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECWindowInnerFlowAddShopCartView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // com.bytedance.android.window.shop.innerflow.widget.ECWindowAddShopCartView
    public final FrameLayout.LayoutParams b() {
        FrameLayout.LayoutParams r0 = super.b();
        r0.gravity = 17;
        return r0;
    }

    @Override // com.bytedance.android.window.shop.innerflow.widget.ECWindowAddShopCartView
    public TextView getAndAddDotTextView() {
        View r0 = LayoutInflater.from(getContext()).inflate(2131560889, this, false);
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (r1 == null) goto L7;
        ((FrameLayout.LayoutParams) r1).gravity = 53;
        addView(r0);
        return (TextView) r0;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    public ECWindowInnerFlowAddShopCartView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECWindowInnerFlowAddShopCartView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
