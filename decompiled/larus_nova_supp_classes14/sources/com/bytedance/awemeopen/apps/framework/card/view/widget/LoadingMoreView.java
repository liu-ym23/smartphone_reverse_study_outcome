package com.bytedance.awemeopen.apps.framework.card.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import y54.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class LoadingMoreView extends View {
    public static final float j = 0.0f;
    public final Paint a;
    public final Path b;
    public int c;
    public int d;
    public int e;
    public final int f;
    public float g;
    public final int h;
    public final float i;

    static {
        j = n0.a(a.a(), 2.0f);
    }

    public LoadingMoreView(Context r2) {
        this(r2, null);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r6) {
        this.b.reset();
        float r1 = 0.0f;
        if (this.g == 0.0f) goto L9;
        Path r0 = this.b;
        float r2 = this.c >> 1;
        float r3 = j;
        r0.moveTo(r2, r3);
        float r4 = (this.c >> 1) - (this.e * this.g);
        if (r4 < 0.0f) goto L8;
        r1 = r4;
    L8:
        this.b.lineTo(r1, this.d >> 1);
        this.b.lineTo(this.c >> 1, this.d - r3);
    L10:
        r6.drawPath(this.b, this.a);
        super.onDraw(r6);
        return;
    L9:
        Path r5 = this.b;
        float r7 = this.c * 0.5f;
        float r8 = j;
        r5.moveTo(r7, r8);
        this.b.lineTo(this.c * 0.5f, this.d - r8);
        goto L10
    }

    public void setMoveSpace(float r2) {
        float r3 = (Math.abs(r2) * 2.0f) / this.h;
        this.g = r3;
        float r0 = this.i;
        if (r3 < r0) goto L5;
        this.g = r0;
    L5:
        invalidate();
    }

    public LoadingMoreView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        this.c = View.MeasureSpec.getSize(r1);
        this.d = View.MeasureSpec.getSize(r2);
        this.e = this.c >> this.f;
    }

    public LoadingMoreView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.c = -1;
        this.d = -1;
        this.e = -1;
        this.f = 1;
        int r5 = a.a().getResources().getColor(2131100338);
        this.g = 0.0f;
        this.i = 0.8f;
        Paint r0 = new Paint();
        this.a = r0;
        r0.setColor(r5);
        r0.setStyle(Paint.Style.STROKE);
        r0.setAntiAlias(true);
        r0.setStrokeWidth(5.0f);
        r0.setStrokeCap(Paint.Cap.ROUND);
        this.b = new Path();
        Resources r6 = r2.getResources();
        this.h = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).widthPixels;
    }
}
