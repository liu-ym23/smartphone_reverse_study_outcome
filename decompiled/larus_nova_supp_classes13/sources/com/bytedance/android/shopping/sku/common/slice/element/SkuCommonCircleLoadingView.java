package com.bytedance.android.shopping.sku.common.slice.element;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/slice/element/SkuCommonCircleLoadingView;", "Landroid/widget/FrameLayout;", "", "visibility", "", "setVisibility", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuCommonCircleLoadingView extends FrameLayout {
    public final RotateAnimation a;
    public boolean b;

    public SkuCommonCircleLoadingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SkuCommonCircleLoadingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.a.cancel();
        this.b = false;
    }

    @Override // android.view.View
    public void setVisibility(int r1) {
        super.setVisibility(r1);
        if (r1 == 0) goto L5;
        this.a.cancel();
        this.b = false;
        return;
    L5:
        if (this.b == true) goto L11;
        this.b = true;
        this.a.start();
        return;
    }

    public SkuCommonCircleLoadingView(Context r8, AttributeSet r9, int r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, r10);
        ImageView r11 = new ImageView(r8);
        r11.setAnimation(AnimationUtils.loadAnimation(r8, 2130772625));
        r11.setImageResource(2131248236);
        r11.setBackgroundColor(0);
        RotateAnimation r12 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.a = r12;
        r12.setRepeatCount(-1);
        r12.setDuration(600);
        r12.setInterpolator(new LinearInterpolator());
        r11.setAnimation(r12);
        removeAllViews();
        addView(r11, new FrameLayout.LayoutParams(-1, -1));
        if (this.b == true) goto L7;
        this.b = true;
        r12.start();
        return;
    }

    public /* synthetic */ SkuCommonCircleLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
