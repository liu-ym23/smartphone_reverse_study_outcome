package com.bytedance.android.ui.base.widget.round;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0007H\u0016J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\u0007H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R$\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011¨\u0006*"}, d2 = {"Lcom/bytedance/android/ui/base/widget/round/RoundFrameLayoutLite;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clipPath", "Landroid/graphics/Path;", "value", "", "leftBottomRadius", "getLeftBottomRadius", "()F", "setLeftBottomRadius", "(F)V", "leftTopRadius", "getLeftTopRadius", "setLeftTopRadius", "radius", "", "rectF", "Landroid/graphics/RectF;", "rightBottomRadius", "getRightBottomRadius", "setRightBottomRadius", "rightTopRadius", "getRightTopRadius", "setRightTopRadius", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setBackground", "background", "Landroid/graphics/drawable/Drawable;", "setBackgroundColor", "color", "setBackgroundResource", "resid", "ui-base-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoundFrameLayoutLite extends FrameLayout {
    private final Path clipPath;
    private float leftBottomRadius;
    private float leftTopRadius;
    private final float[] radius;
    private final RectF rectF;
    private float rightBottomRadius;
    private float rightTopRadius;

    public RoundFrameLayoutLite(Context r7) {
        this(r7, null, 0, 6, null);
    }

    public RoundFrameLayoutLite(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public final float getLeftBottomRadius() {
        return this.leftBottomRadius;
    }

    public final float getLeftTopRadius() {
        return this.leftTopRadius;
    }

    public final float getRightBottomRadius() {
        return this.rightBottomRadius;
    }

    public final float getRightTopRadius() {
        return this.rightTopRadius;
    }

    @Override // android.view.View
    public void draw(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        this.clipPath.reset();
        this.rectF.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        float[] r0 = this.radius;
        float r1 = this.leftTopRadius;
        r0[0] = r1;
        r0[1] = r1;
        float r2 = this.rightTopRadius;
        r0[2] = r2;
        r0[3] = r2;
        float r3 = this.leftBottomRadius;
        r0[4] = r3;
        r0[5] = r3;
        float r4 = this.rightBottomRadius;
        r0[6] = r4;
        r0[7] = r4;
        this.clipPath.addRoundRect(this.rectF, r0, Path.Direction.CW);
        r5.clipPath(this.clipPath);
        super.draw(r5);
    }

    @Override // android.view.View
    public void setBackground(Drawable r1) {
        super.setBackground(r1);
    }

    @Override // android.view.View
    public void setBackgroundColor(int r1) {
        super.setBackgroundColor(r1);
    }

    @Override // android.view.View
    public void setBackgroundResource(int r1) {
        super.setBackgroundResource(r1);
    }

    public final void setLeftBottomRadius(float r1) {
        this.leftBottomRadius = r1;
        invalidate();
    }

    public final void setLeftTopRadius(float r1) {
        this.leftTopRadius = r1;
        invalidate();
    }

    public final void setRightBottomRadius(float r1) {
        this.rightBottomRadius = r1;
        invalidate();
    }

    public final void setRightTopRadius(float r1) {
        this.rightTopRadius = r1;
        invalidate();
    }

    public RoundFrameLayoutLite(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.clipPath = new Path();
        this.rectF = new RectF();
        this.radius = new float[8];
        if (r3 == null) goto L5;
        TypedArray r5 = r2.obtainStyledAttributes(r3, new int[]{2130972516, 2130972524, 2130973797, 2130973805});
        setLeftTopRadius(r5.getDimension(1, 0.0f));
        setRightTopRadius(r5.getDimension(3, 0.0f));
        setLeftBottomRadius(r5.getDimension(0, 0.0f));
        setRightBottomRadius(r5.getDimension(2, 0.0f));
        r5.recycle();
    L5:
        setWillNotDraw(false);
    }

    public /* synthetic */ RoundFrameLayoutLite(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
