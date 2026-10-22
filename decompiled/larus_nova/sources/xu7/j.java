package xu7;

import android.animation.ValueAnimator;
import android.view.animation.PathInterpolator;

/* JADX INFO: loaded from: classes23.dex */
public final class j extends wu7.d {
    @Override // wu7.f
    public final ValueAnimator d() {
        float[] r100 = {0.0f, 0.7f, 1.0f};
        uu7.c r101 = new uu7.c(this);
        Float r102 = Float.valueOf(1.0f);
        r101.d(r100, wu7.f.f561447z, new Float[]{Float.valueOf(0.0f), r102, r102});
        r101.e(r100, wu7.f.A, new Integer[]{255, 178, 0});
        r101.f551774c = 1000;
        vu7.a r103 = new vu7.a(new PathInterpolator(0.21f, 0.53f, 0.56f, 0.8f), new float[0]);
        r103.f557364b = r100;
        r101.f551773b = r103;
        return r101.a();
    }

    public j() {
        g(0.0f);
    }
}
