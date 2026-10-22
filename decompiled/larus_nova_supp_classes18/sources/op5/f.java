package op5;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Interpolator {
    public static final float a = 0.0f;
    public static final float b = 0.0f;

    public f() {
    }

    static {
        float r1 = 1.0f / a(1.0f);
        a = r1;
        b = 1.0f - (r1 * a(1.0f));
    }

    public static float a(float r3) {
        float r4 = r3 * 8.0f;
        if (r4 >= 1.0f) goto L6;
        return r4 - (1.0f - ((float) Math.exp(-r4)));
    L6:
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - r4))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r2) {
        float r0 = a * a(r2);
        if (r0 > 0.0f) goto L5;
        return r0;
    L5:
        return r0 + b;
    }
}
