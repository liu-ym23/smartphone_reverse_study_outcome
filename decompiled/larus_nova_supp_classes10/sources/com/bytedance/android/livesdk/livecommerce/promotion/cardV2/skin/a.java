package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.skin;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends Drawable {
    public final Paint a;
    public final RectF b;
    public float c;
    public float d;
    public float e;
    public float f;
    public final int[] g;
    public final float[] h;
    public final float i;
    public final float j;

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    public final void a() {
        if (this.b.isEmpty() == false) goto L5;
        return;
    L5:
        float r0 = this.b.width();
        float r1 = this.b.height();
        float r2 = this.b.centerX();
        float r3 = this.b.centerY();
        double r4 = ((double) (90 - this.i)) * 0.017453292519943295d;
        double r6 = Math.abs(((double) r0) * Math.cos(r4)) + Math.abs(((double) r1) * Math.sin(r4));
        double r5 = r2;
        double r7 = r6 / 2.0d;
        this.c = (float) (r5 - (Math.cos(r4) * r7));
        double r8 = r3;
        this.d = ((float) ((Math.sin(r4) * r7) + r8)) + this.j;
        this.e = (float) (r5 + (Math.cos(r4) * r7));
        this.f = ((float) (r8 - (r7 * Math.sin(r4)))) + this.j;
        this.a.setShader(new LinearGradient(this.c, this.d, this.e, this.f, this.g, this.h, Shader.TileMode.CLAMP));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas r3) {
        Intrinsics.checkNotNullParameter(r3, "canvas");
        r3.drawRect(this.b, this.a);
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "bounds");
        super.onBoundsChange(r2);
        this.b.set(r2);
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

    public a(int[] r2, float[] r3, float r4, float r5) {
        Intrinsics.checkNotNullParameter(r2, "colors");
        Intrinsics.checkNotNullParameter(r3, "positions");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.a = new Paint(1);
        this.b = new RectF();
        a();
    }
}
