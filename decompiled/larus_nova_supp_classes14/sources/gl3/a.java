package gl3;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a implements Interpolator {
    public int a;
    public final PointF b;
    public final PointF c;

    public static double a(double r14, double r16, double r18) {
        double r2 = 1.0d - r14;
        double r4 = r14 * r14;
        double r6 = r2 * r2;
        return ((((r6 * r2) * 0.0d) + (((r6 * 3.0d) * r14) * r16)) + (((r2 * 3.0d) * r4) * r18)) + ((r4 * r14) * 1.0d);
    }

    public a() {
        this.a = 0;
        this.b = new PointF();
        this.c = new PointF();
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r9) {
        int r0 = this.a;
        float r1 = r9;
    L4:
        if (r0 >= 4096) goto L9;
        r1 = (r0 * 1.0f) / 4096.0f;
        if (a(r1, this.b.x, this.c.x) >= r9) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        this.a = r0;
    L9:
        double r2 = a(r1, this.b.y, this.c.y);
        if (r2 <= 0.999d) goto L13;
        this.a = 0;
        r2 = 1.0d;
    L13:
        return (float) r2;
    }
}
