package op5;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f524724a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f524725b = 0.0f;

    public f() {
    }

    static {
        float r100 = 1.0f / a(1.0f);
        f524724a = r100;
        f524725b = 1.0f - (r100 * a(1.0f));
    }

    public static float a(float r100) {
        float r101 = r100 * 8.0f;
        if (r101 >= 1.0f) goto L6;
        return r101 - (1.0f - ((float) Math.exp(-r101)));
    L6:
        return 0.36787945f + ((1.0f - ((float) Math.exp(1.0f - r101))) * 0.63212055f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        float r101 = f524724a * a(r100);
        if (r101 > 0.0f) goto L5;
        return r101;
    L5:
        return r101 + f524725b;
    }
}
