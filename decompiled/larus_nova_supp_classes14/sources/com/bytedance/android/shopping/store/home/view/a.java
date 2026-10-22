package com.bytedance.android.shopping.store.home.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends Drawable {
    public final Paint a;
    public final Paint b;
    public SweepGradient c;
    public final float d;
    public final float e;
    public final RectF f;
    public int[] g;
    public float h;
    public final Integer i;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void a() {
        SweepGradient r2 = new SweepGradient((getBounds().width() * this.d) + getBounds().left, (getBounds().height() * this.e) + getBounds().top, this.g, null);
        this.c = r2;
        r2.setLocalMatrix(null);
        this.a.setShader(this.c);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        Rect r0 = getBounds();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        Integer r1 = this.i;
        if (r1 == null) goto L11;
        this.b.setColor(r1.intValue());
        float r2 = this.h;
        if (r2 <= 0) goto L10;
        RectF r3 = this.f;
        r3.left = r0.left;
        r3.top = r0.top;
        r3.right = r0.right;
        r3.bottom = r0.bottom;
        r6.drawRoundRect(r3, r2, r2, this.b);
        goto L11
    L10:
        r6.drawRect(r0, this.b);
    L11:
        float r4 = this.h;
        if (r4 <= 0) goto L14;
        RectF r5 = this.f;
        r5.left = r0.left;
        r5.top = r0.top;
        r5.right = r0.right;
        r5.bottom = r0.bottom;
        r6.drawRoundRect(r5, r4, r4, this.a);
        return;
    L14:
        r6.drawRect(r0, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        a();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int r2) {
        this.a.setAlpha(r2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r2) {
        this.a.setColorFilter(r2);
        invalidateSelf();
    }

    public a(int[] r2, float r3, Integer r4) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        this.g = r2;
        this.h = 0.0f;
        this.i = r4;
        Paint r5 = new Paint(1);
        r5.setStyle(Paint.Style.STROKE);
        r5.setStrokeWidth(r3);
        Unit r6 = Unit.INSTANCE;
        this.a = r5;
        Paint r7 = new Paint(1);
        r7.setStyle(Paint.Style.FILL);
        this.b = r7;
        this.d = 0.5f;
        this.e = 0.5f;
        this.f = new RectF();
    }
}
