package com.bytedance.ee.bear.drive.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class RadiusImageView extends AppCompatImageView {
    public static final float d = 0.0f;
    public final Path a;
    public final RectF b;
    public float c;

    static {
        d = com.bytedance.ee.util.ui.n.d(4);
    }

    public RadiusImageView(Context r2) {
        super(r2);
        this.a = new Path();
        this.b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.c = d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r5) {
        this.b.set(0.0f, 0.0f, getWidth(), getHeight());
        this.a.reset();
        Path r0 = this.a;
        RectF r1 = this.b;
        float r2 = this.c;
        r0.addRoundRect(r1, r2, r2, Path.Direction.CW);
        r5.clipPath(this.a);
        super/*android.widget.ImageView*/.onDraw(r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setRadius(float r1) {
        this.c = r1;
        invalidate();
    }

    public RadiusImageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = new Path();
        this.b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.c = d;
    }

    public RadiusImageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new Path();
        this.b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        this.c = d;
    }
}
