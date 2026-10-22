package yhc;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes40.dex */
public final class h0 implements Interpolator {
    public h0() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        return (float) ((Math.pow(2.0d, (-10.0f) * r100) * Math.sin((((double) (r100 - 0.365f)) * 6.283185307179586d) / ((double) 1.46f))) + 1.0d);
    }
}
