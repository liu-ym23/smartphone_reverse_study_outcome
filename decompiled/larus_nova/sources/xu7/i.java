package xu7;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes23.dex */
public final class i extends wu7.b {
    @Override // wu7.f
    public final ValueAnimator d() {
        float[] r100 = {0.0f, 1.0f};
        uu7.c r101 = new uu7.c(this);
        r101.d(r100, wu7.f.f561447z, new Float[]{Float.valueOf(0.0f), Float.valueOf(1.0f)});
        r101.e(r100, wu7.f.A, new Integer[]{255, 0});
        r101.f551774c = 1000;
        r101.b(r100);
        return r101.a();
    }

    public i() {
        g(0.0f);
    }
}
