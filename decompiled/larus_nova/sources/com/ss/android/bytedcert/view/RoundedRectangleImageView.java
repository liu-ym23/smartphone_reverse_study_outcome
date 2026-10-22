package com.ss.android.bytedcert.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes34.dex */
public class RoundedRectangleImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f407778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f407779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f407780c;

    public final void a() {
        this.f407779b = new Path();
        this.f407780c = new RectF();
        setWillNotDraw(false);
    }

    public float getCornerRadius() {
        return this.f407778a;
    }

    public RoundedRectangleImageView(Context r100) {
        super(r100);
        this.f407778a = 0.0f;
        a();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Drawable r101 = getDrawable();
        if (r101 != null) goto L6;
        return;
    L6:
        if ((r101 instanceof BitmapDrawable) == true) goto L8;
        super.onDraw(r100);
        return;
    L8:
        if (((BitmapDrawable) r101).getBitmap() != null) goto L10;
        return;
    L10:
        this.f407780c.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f407779b.reset();
        Path r102 = this.f407779b;
        RectF r103 = this.f407780c;
        float r104 = this.f407778a;
        r102.addRoundRect(r103, r104, r104, Path.Direction.CW);
        r100.save();
        r100.clipPath(this.f407779b);
        super.onDraw(r100);
        r100.restore();
    }

    public void setCornerRadius(float r100) {
        this.f407778a = r100;
        invalidate();
    }

    public RoundedRectangleImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f407778a = 0.0f;
        a();
    }

    public RoundedRectangleImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f407778a = 0.0f;
        a();
    }
}
