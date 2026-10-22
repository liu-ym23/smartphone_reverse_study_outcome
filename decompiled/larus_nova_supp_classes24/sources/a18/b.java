package a18;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends c {
    public float e;
    public float f;
    public float g;

    @Override // a18.c
    public final int e() {
        return -1;
    }

    @Override // a18.c
    public final int d() {
        return this.a.b;
    }

    public b(z08.b r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        super(r2);
        this.e = 300.0f;
    }

    @Override // a18.c
    public final void a(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Rect r0 = r7.getClipBounds();
        this.e = r0.width();
        float r1 = this.a.b;
        r7.translate(r0.width() / 2.0f, (r0.height() / 2.0f) + Math.max(0.0f, (r0.height() - this.a.b) / 2.0f));
        float r2 = this.e;
        float r3 = 2;
        r7.clipRect((-r2) / r3, (-r1) / r3, r2 / r3, r1 / r3);
        z08.b r8 = this.a;
        this.f = r8.b * 1.0f;
        this.g = r8.e;
    }

    @Override // a18.c
    public final void c(Canvas r13, Paint r14, int r15) {
        Intrinsics.checkNotNullParameter(r13, "canvas");
        Intrinsics.checkNotNullParameter(r14, "paint");
        float r1 = 2;
        float r0 = ((-this.e) / r1) + this.g;
        float r11 = -r0;
        r14.setStyle(Paint.Style.FILL);
        r14.setAntiAlias(true);
        r14.setColor(r15);
        float r16 = this.f;
        r13.drawRect(r0, (-r16) / r1, r11, r16 / r1, r14);
        float r2 = this.g;
        float r3 = -r2;
        RectF r17 = new RectF(r3, r3, r2, r2);
        f(r13, r14, this.f, this.g, r0, true, r17);
        f(r13, r14, this.f, this.g, r11, false, r17);
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
        float r2 = this.e;
        float r3 = 2;
        float r4 = this.g;
        float r5 = ((-r2) / r3) + r4;
        float r6 = r2 - (r4 * r3);
        float r7 = r5 + (0.0f * r6);
        float r12 = r5 + (r6 * r17);
        r16.setStyle(Paint.Style.FILL);
        r16.setAntiAlias(true);
        r16.setColor(r19);
        float r0 = this.f;
        r15.drawRect(r7, (-r0) / r3, r12, r0 / r3, r16);
        float r8 = this.g;
        float r9 = -r8;
        RectF r13 = new RectF(r9, r9, r8, r8);
        f(r15, r16, this.f, this.g, r7, true, r13);
        f(r15, r16, this.f, this.g, r12 - 1, false, r13);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void f(Canvas r12, Paint r13, float r14, float r15, float r16, boolean r17, RectF r19) {
        r12.save();
        r12.translate(r16, 0.0f);
        if (r17 == true) goto L5;
        r12.rotate(180.0f);
    L5:
        float r4 = 2;
        float r8 = ((-r14) / r4) + r15;
        float r9 = (r14 / r4) - r15;
        r12.drawRect(-r15, r8, 0.0f, r9, r13);
        r12.save();
        r12.translate(0.0f, r8);
        r12.drawArc(r19, 180.0f, 90.0f, true, r13);
        r12.restore();
        r12.translate(0.0f, r9);
        r12.drawArc(r19, 180.0f, -90.0f, true, r13);
        r12.restore();
    }
}
