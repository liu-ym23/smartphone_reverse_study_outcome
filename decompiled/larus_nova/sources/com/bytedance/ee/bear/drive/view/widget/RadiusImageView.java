package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: classes16.dex */
public class RadiusImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f225955d = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f225956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f225957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f225958c;

    static {
        f225955d = com.bytedance.ee.util.ui.n.d(4);
    }

    public RadiusImageView(Context r100) {
        super(r100);
        this.f225956a = new Path();
        this.f225957b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f225958c = f225955d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        this.f225957b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.f225956a.reset();
        Path r101 = this.f225956a;
        RectF r102 = this.f225957b;
        float r103 = this.f225958c;
        r101.addRoundRect(r102, r103, r103, Path.Direction.CW);
        r100.clipPath(this.f225956a);
        super.onDraw(r100);
    }

    public void setRadius(float r100) {
        this.f225958c = r100;
        invalidate();
    }

    public RadiusImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f225956a = new Path();
        this.f225957b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f225958c = f225955d;
    }

    public RadiusImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f225956a = new Path();
        this.f225957b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.f225958c = f225955d;
    }
}
