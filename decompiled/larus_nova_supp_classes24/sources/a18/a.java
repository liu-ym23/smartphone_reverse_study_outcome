package a18;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.core.graphics.ColorUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a extends c {
    public final float e;
    public final int f;
    public final int g;
    public final int h;
    public int i;
    public float j;
    public float k;
    public float l;

    @Override // a18.c
    public final int d() {
        return this.a.g;
    }

    @Override // a18.c
    public final int e() {
        return this.a.g;
    }

    public a(z08.b r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        super(r2);
        this.e = -90.0f;
        this.f = 90;
        this.g = 180;
        this.h = 360;
        this.i = 1;
    }

    @Override // a18.c
    public final void a(Canvas r5) {
        Intrinsics.checkNotNullParameter(r5, "canvas");
        float r0 = this.a.g / 2.0f;
        r5.translate(r0, r0);
        r5.rotate(this.e);
        float r2 = -r0;
        r5.clipRect(r2, r2, r0, r0);
        this.i = 1;
        z08.b r6 = this.a;
        int r1 = r6.b;
        this.j = r1 * 1.0f;
        this.k = r6.e;
        this.l = (r6.g - r1) / 2.0f;
    }

    @Override // a18.c
    public final void c(Canvas r7, Paint r8, int r9) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Intrinsics.checkNotNullParameter(r8, "paint");
        int r10 = this.a.c;
        int r11 = ColorUtils.setAlphaComponent(r10, (Color.alpha(r10) * this.c) / 255);
        r8.setStyle(Paint.Style.STROKE);
        r8.setStrokeCap(Paint.Cap.BUTT);
        r8.setAntiAlias(true);
        r8.setColor(r11);
        r8.setStrokeWidth(this.j);
        float r12 = this.l;
        float r0 = -r12;
        r7.drawArc(new RectF(r0, r0, r12, r12), 0.0f, this.h, false, r8);
    }

    @Override // a18.c
    public final void b(Canvas r15, Paint r16, float r17, int r19) {
        Intrinsics.checkNotNullParameter(r15, "canvas");
        Intrinsics.checkNotNullParameter(r16, "paint");
        if (0.0f != r17) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        return;
    L8:
        r16.setStyle(Paint.Style.STROKE);
        r16.setStrokeCap(Paint.Cap.BUTT);
        r16.setAntiAlias(true);
        r16.setColor(r19);
        r16.setStrokeWidth(this.j);
        float r2 = this.h;
        float r3 = this.i;
        float r11 = (r2 * 0.0f) * r3;
        if (r17 < 0.0f) goto L11;
        float r0 = r17 - 0.0f;
    L12:
        float r12 = (r0 * r2) * r3;
        float r4 = this.l;
        float r5 = -r4;
        r15.drawArc(new RectF(r5, r5, r4, r4), r11, r12, false, r16);
        if (this.k > 0.0f) goto L15;
        return;
    L15:
        if (Math.abs(r12) >= this.h) goto L19;
        r16.setStyle(Paint.Style.FILL);
        float r6 = this.k;
        float r7 = -r6;
        RectF r13 = new RectF(r7, r7, r6, r6);
        f(r15, r16, this.j, this.k, r11, true, r13);
        f(r15, r16, this.j, this.k, r11 + r12, false, r13);
        return;
    L19:
        return;
    L11:
        r0 = (1 + r17) - 0.0f;
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public final void f(Canvas r13, Paint r14, float r15, float r16, float r17, boolean r19, RectF r110) {
        if (r19 == false) goto L5;
        float r8 = -1.0f;
    L6:
        r13.save();
        r13.rotate(r17);
        float r9 = 2;
        float r10 = r15 / r9;
        float r1 = r8 * r16;
        r13.drawRect((this.l - r10) + r16, Math.min(0.0f, this.i * r1), (this.l + r10) - r16, Math.max(0.0f, r1 * this.i), r14);
        r13.translate((this.l - r10) + r16, 0.0f);
        r13.drawArc(r110, this.g, ((-r8) * this.f) * this.i, true, r14);
        r13.translate(r15 - (r9 * r16), 0.0f);
        r13.drawArc(r110, 0.0f, (r8 * this.f) * this.i, true, r14);
        r13.restore();
        return;
    L5:
        r8 = 1.0f;
        goto L6
    }
}
