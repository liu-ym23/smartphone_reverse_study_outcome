package com.bytedance.android.ui.base.widget.drawable;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import com.bytedance.apm.constant.UploadTypeInf;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0016J\b\u0010\u001a\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ui/base/widget/drawable/RotatingDrawable;", "Lcom/bytedance/android/ui/base/widget/drawable/ECDrawableWrapper;", "Landroid/graphics/drawable/Animatable;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "isRunning", "", "rotate", "", "targetScale", "getTargetScale", "()F", "setTargetScale", "(F)V", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", UploadTypeInf.START, "stop", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RotatingDrawable extends ECDrawableWrapper implements Animatable {
    private boolean isRunning;
    private float rotate;
    private float targetScale;
    private final ValueAnimator valueAnimator;

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.isRunning = false;
        ValueAnimator r0 = this.valueAnimator;
        r0.removeAllUpdateListeners();
        r0.cancel();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        ValueAnimator r0 = this.valueAnimator;
        r0.setInterpolator(new LinearInterpolator());
        r0.setDuration(1000);
        r0.setRepeatMode(1);
        r0.setRepeatCount(-1);
        r0.addUpdateListener(new RotatingDrawable$start$$inlined$apply$lambda$1(this));
        this.valueAnimator.start();
        this.isRunning = true;
    }

    public final float getTargetScale() {
        return this.targetScale;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.isRunning;
    }

    public RotatingDrawable(Drawable r1) {
        super(r1);
        this.valueAnimator = ValueAnimator.ofInt(new int[]{0, 360});
    }

    public static final /* synthetic */ float access$getRotate$p(RotatingDrawable r0) {
        return r0.rotate;
    }

    @Override // com.bytedance.android.ui.base.widget.drawable.ECDrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        if (getWrappedDrawable() != null) goto L5;
        return;
    L5:
        r6.save();
        r6.rotate(this.rotate, (getBounds().left + getBounds().right) / 2.0f, (getBounds().top + getBounds().bottom) / 2.0f);
        getWrappedDrawable().draw(r6);
        r6.restore();
    }

    @Override // com.bytedance.android.ui.base.widget.drawable.ECDrawableWrapper, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect r3) {
        Intrinsics.checkNotNullParameter(r3, "bounds");
        super.onBoundsChange(r3);
        if (r3.width() >= r3.height()) goto L8;
        if (getWrappedDrawable().getIntrinsicWidth() == 0) goto L11;
        this.targetScale = r3.width() / getWrappedDrawable().getIntrinsicWidth();
        return;
    L11:
        return;
    L8:
        if (getWrappedDrawable().getIntrinsicHeight() == 0) goto L13;
        this.targetScale = r3.height() / getWrappedDrawable().getIntrinsicHeight();
        return;
    }

    public final void setTargetScale(float r1) {
        this.targetScale = r1;
    }

    public static final /* synthetic */ void access$setRotate$p(RotatingDrawable r0, float r1) {
        r0.rotate = r1;
    }
}
