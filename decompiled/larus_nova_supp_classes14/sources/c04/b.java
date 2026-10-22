package c04;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements Interpolator {
    public final PointF a;
    public final PointF b;
    public final PointF c;
    public final PointF d;
    public final PointF e;

    public static float[] a() {
        return new float[]{0.66f, 0.0f, 0.34f, 1.0f};
    }

    public b() {
        float r0 = a()[0];
        float r1 = a()[1];
        float r2 = a()[2];
        float r3 = a()[3];
        PointF r4 = new PointF(r0, r1);
        PointF r5 = new PointF(r2, r3);
        this.c = new PointF();
        this.d = new PointF();
        this.e = new PointF();
        float r6 = r4.x;
        if (r6 < 0.0f) goto L15;
        if (r6 > 1.0f) goto L15;
        float r7 = r5.x;
        if (r7 < 0.0f) goto L13;
        if (r7 > 1.0f) goto L13;
        this.a = r4;
        this.b = r5;
        return;
    L13:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]");
    L15:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]");
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r11) {
        int r0 = 1;
        float r1 = r11;
    L4:
        if (r0 >= 14) goto L9;
        PointF r2 = this.e;
        PointF r5 = this.a;
        float r6 = r5.x * 3.0f;
        r2.x = r6;
        PointF r7 = this.d;
        float r8 = ((this.b.x - r5.x) * 3.0f) - r6;
        r7.x = r8;
        PointF r9 = this.c;
        float r10 = (1.0f - r2.x) - r8;
        r9.x = r10;
        float r3 = ((r2.x + ((r7.x + (r10 * r1)) * r1)) * r1) - r11;
        if (Math.abs(r3) < 0.001d) goto L9;
        r1 = r1 - (r3 / (this.e.x + (((this.d.x * 2.0f) + ((this.c.x * 3.0f) * r1)) * r1)));
        r0 = r0 + 1;
    L9:
        PointF r12 = this.e;
        PointF r4 = this.a;
        float r13 = r4.y * 3.0f;
        r12.y = r13;
        PointF r14 = this.d;
        float r15 = ((this.b.y - r4.y) * 3.0f) - r13;
        r14.y = r15;
        PointF r16 = this.c;
        float r17 = (1.0f - r12.y) - r15;
        r16.y = r17;
        return r1 * (r12.y + ((r14.y + (r17 * r1)) * r1));
    }
}
