package n86;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements Interpolator {
    public b() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        float r101 = r100 - 1.0f;
        return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
    }
}
