package com.bytedance.dux.drawable;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/dux/drawable/RotatingDrawable;", "Landroidx/appcompat/graphics/drawable/DrawableWrapper;", "Landroid/graphics/drawable/Animatable;", "dux_release"}, k = 1, mv = {1, 7, 1})
public class RotatingDrawable extends DrawableWrapper implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f205012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ValueAnimator f205013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f205014c;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RotatingDrawable f205015a;

        public a(RotatingDrawable r100) {
            this.f205015a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            RotatingDrawable r101 = this.f205015a;
            Object r102 = r100.getAnimatedValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
            r101.f205012a = ((Integer) r102).intValue();
            this.f205015a.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        this.f205014c = false;
        ValueAnimator r100 = this.f205013b;
        r100.removeAllUpdateListeners();
        r100.cancel();
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        ValueAnimator r100 = this.f205013b;
        r100.setInterpolator(new LinearInterpolator());
        r100.setDuration(1000);
        r100.setRepeatMode(1);
        r100.setRepeatCount(-1);
        r100.addUpdateListener(new a(this));
        this.f205013b.start();
        this.f205014c = true;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f205014c;
    }

    public RotatingDrawable(Drawable r100) {
        super(r100);
        this.f205013b = ValueAnimator.ofInt(new int[]{0, 360});
        new Matrix();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (getWrappedDrawable() != null) goto L5;
        return;
    L5:
        r100.save();
        r100.rotate(this.f205012a, (getBounds().left + getBounds().right) / 2.0f, (getBounds().top + getBounds().bottom) / 2.0f);
        getWrappedDrawable().draw(r100);
        r100.restore();
    }

    @Override // androidx.appcompat.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "bounds");
        super.onBoundsChange(r100);
        if (r100.width() >= r100.height()) goto L5;
        r100.width();
        getWrappedDrawable().getIntrinsicWidth();
        return;
    L5:
        r100.height();
        getWrappedDrawable().getIntrinsicHeight();
    }
}
