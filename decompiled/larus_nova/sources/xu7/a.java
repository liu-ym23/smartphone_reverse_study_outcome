package xu7;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes23.dex */
public final class a extends wu7.g {

    /* JADX INFO: renamed from: xu7.a$a, reason: collision with other inner class name */
    public class C8275a extends wu7.b {
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

        public C8275a() {
            g(0.0f);
        }
    }

    @Override // wu7.g, wu7.f
    public final ValueAnimator d() {
        uu7.c r100 = new uu7.c(this);
        r100.e(new float[]{0.0f, 1.0f}, wu7.f.f561442u, new Integer[]{0, 360});
        r100.f551774c = 2000;
        r100.f551773b = new LinearInterpolator();
        return r100.a();
    }

    @Override // wu7.g
    public final wu7.f[] l() {
        return new wu7.f[]{new C8275a(), new C8275a()};
    }

    public a() {
    }

    @Override // wu7.g
    public final void k(wu7.f... r100) {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        r100[1].f561453f = 1000;
        return;
    L5:
        r100[1].f561453f = -1000;
    }

    @Override // wu7.g, wu7.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Rect r101 = wu7.f.a(r100);
        int r102 = (int) (r101.width() * 0.6f);
        wu7.f r103 = i(0);
        int r104 = r101.right;
        int r105 = r101.top;
        r103.f(r104 - r102, r105, r104, r105 + r102);
        wu7.f r106 = i(1);
        int r107 = r101.right;
        int r108 = r101.bottom;
        r106.f(r107 - r102, r108 - r102, r107, r108);
    }
}
