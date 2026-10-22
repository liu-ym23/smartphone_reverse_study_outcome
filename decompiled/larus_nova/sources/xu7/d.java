package xu7;

import android.animation.ValueAnimator;
import android.os.Build;

/* JADX INFO: loaded from: classes23.dex */
public final class d extends wu7.g {

    public class a extends wu7.b {
        @Override // wu7.f
        public final ValueAnimator d() {
            float[] r100 = {0.0f, 0.5f, 1.0f};
            uu7.c r101 = new uu7.c(this);
            Float r102 = Float.valueOf(0.0f);
            r101.d(r100, wu7.f.f561447z, new Float[]{r102, Float.valueOf(1.0f), r102});
            r101.f551774c = 2000;
            r101.b(r100);
            return r101.a();
        }

        public a() {
            setAlpha(153);
            g(0.0f);
        }
    }

    @Override // wu7.g
    public final wu7.f[] l() {
        return new wu7.f[]{new a(), new a()};
    }

    public d() {
    }

    @Override // wu7.g
    public final void k(wu7.f... r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r100[1].f561453f = 1000;
        return;
    L5:
        r100[1].f561453f = -1000;
    }
}
