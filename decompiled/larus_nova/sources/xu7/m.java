package xu7;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes23.dex */
public final class m extends wu7.g {

    public class a extends wu7.b {
        @Override // wu7.f
        public final ValueAnimator d() {
            float[] r100 = {0.0f, 0.4f, 0.8f, 1.0f};
            uu7.c r101 = new uu7.c(this);
            Float r102 = Float.valueOf(0.0f);
            r101.d(r100, wu7.f.f561447z, new Float[]{r102, Float.valueOf(1.0f), r102, r102});
            r101.f551774c = 1400;
            r101.b(r100);
            return r101.a();
        }

        public a() {
            g(0.0f);
        }
    }

    @Override // wu7.g
    public final wu7.f[] l() {
        return new wu7.f[]{new a(), new a(), new a()};
    }

    public m() {
    }

    @Override // wu7.g
    public final void k(wu7.f... r100) {
        r100[1].f561453f = 160;
        r100[2].f561453f = 320;
    }

    @Override // wu7.g, wu7.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Rect r101 = wu7.f.a(r100);
        int r102 = r101.width() / 8;
        int r103 = r101.centerY() - r102;
        int r104 = r101.centerY() + r102;
        int r105 = 0;
    L4:
        if (r105 >= j()) goto L6;
        int r106 = ((r101.width() * r105) / 3) + r101.left;
        i(r105).f(r106, r103, (r102 * 2) + r106, r104);
        r105 = r105 + 1;
        goto L4
    }
}
