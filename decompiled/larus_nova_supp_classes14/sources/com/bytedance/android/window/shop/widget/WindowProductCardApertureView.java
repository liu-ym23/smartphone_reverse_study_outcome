package com.bytedance.android.window.shop.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002R$\u0010\f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00028\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/window/shop/widget/WindowProductCardApertureView;", "Landroid/view/View;", "", "value", "", "setCurrentSpeedExternal", "radius", "setOutlineRadius", "a", "F", "setCurrentSpeed", "(F)V", "currentSpeed", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "b", "Lkotlin/Lazy;", "getAnimator", "()Landroid/animation/ObjectAnimator;", "animator", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductCardApertureView extends View {
    public float a;
    public final Lazy b;
    public SweepGradient c;
    public final Paint d;
    public final Paint e;
    public final RectF f;
    public final Path g;
    public final float h;

    public static final class a {
    }

    static {
    }

    public WindowProductCardApertureView(Context r4) {
        this(r4, null, 0.0f, 6);
    }

    public WindowProductCardApertureView(Context r3, AttributeSet r4) {
        this(r3, r4, 0.0f, 4);
    }

    private final ObjectAnimator getAnimator() {
        return (ObjectAnimator) this.b.getValue();
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getAnimator().isStarted() == true) goto L6;
        getAnimator().start();
        return;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        getAnimator().cancel();
        super.onDetachedFromWindow();
    }

    private final void setCurrentSpeed(float r1) {
        this.a = r1;
        invalidate();
    }

    private final void setCurrentSpeedExternal(float r1) {
        setCurrentSpeed(r1);
    }

    private final void setOutlineRadius(float r4) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(com.bytedance.android.ec.window.base.utils.c.c(getContext(), 2131101883));
        r0.setCornerRadius(a(r4 + 1.0f));
        Unit r5 = Unit.INSTANCE;
        setBackground(r0);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
    }

    public final float a(float r3) {
        Resources r0 = getResources();
        return r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r11) {
        Intrinsics.checkNotNullParameter(r11, "canvas");
        super.onDraw(r11);
        r11.save();
        r11.rotate(this.a, getWidth() / 2.0f, getHeight() / 2.0f);
        if (this.c != null) goto L5;
        SweepGradient r5 = new SweepGradient(getWidth() / 2.0f, getHeight() / 2.0f, new int[]{com.bytedance.android.ec.window.base.utils.c.c(getContext(), 2131101880), com.bytedance.android.ec.window.base.utils.c.c(getContext(), 2131101884), com.bytedance.android.ec.window.base.utils.c.c(getContext(), 2131101881), com.bytedance.android.ec.window.base.utils.c.c(getContext(), 2131101882), com.bytedance.android.ec.window.base.utils.c.c(getContext(), 2131101884), com.bytedance.android.ec.window.base.utils.c.c(getContext(), 2131101882), com.bytedance.android.ec.window.base.utils.c.c(getContext(), 2131101880)}, new float[]{0.0f, 0.17f, 0.19f, 0.58f, 0.6f, 0.84f, 1.0f});
        this.c = r5;
        this.d.setShader(r5);
    L5:
        float r0 = getWidth() / 2.0f;
        float r1 = getHeight() / 2.0f;
        r11.drawCircle(r0, r1, (float) Math.sqrt((r0 * r0) + (r1 * r1)), this.d);
        r11.restore();
        this.g.reset();
        Path r2 = this.g;
        RectF r3 = this.f;
        float r4 = this.h;
        r2.addRoundRect(r3, r4, r4, Path.Direction.CW);
        r11.drawPath(this.g, this.e);
    }

    @Override // android.view.View
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);
        setMeasuredDimension(View.resolveSize(getWidth(), r2), View.resolveSize(getHeight(), r3));
    }

    public WindowProductCardApertureView(Context r3, AttributeSet r4, float r5, int r6) {
        if ((r6 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r5 = 8.0f;
    L8:
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4);
        this.b = LazyKt.lazy(new WindowProductCardApertureView$animator$2(this));
        this.d = new Paint(1);
        Paint r7 = new Paint(1);
        r7.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Unit r8 = Unit.INSTANCE;
        this.e = r7;
        this.f = new RectF();
        this.g = new Path();
        this.h = a(r5);
        setLayerType(1, null);
        setOutlineRadius(r5);
        getAnimator().start();
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.c = null;
        float r5 = a(2.0f);
        this.f.set(r5, r5, r1 - r5, r2 - r5);
    }
}
