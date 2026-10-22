package xu7;

import android.animation.ValueAnimator;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes23.dex */
public final class c extends wu7.g {

    public class a extends wu7.c {
        @Override // wu7.f
        public final ValueAnimator d() {
            float[] r100 = {0.0f, 0.35f, 0.7f, 1.0f};
            uu7.c r101 = new uu7.c(this);
            Float r102 = Float.valueOf(1.0f);
            r101.d(r100, wu7.f.f561447z, new Float[]{r102, Float.valueOf(0.0f), r102, r102});
            r101.f551774c = 1300;
            r101.b(r100);
            return r101.a();
        }

        public a() {
        }
    }

    @Override // wu7.g
    public final wu7.f[] l() {
        int[] r100 = {200, 300, 400, 100, 200, 300, 0, 100, 200};
        a[] r101 = new a[9];
        int r102 = 0;
    L3:
        if (r102 >= 9) goto L5;
        a r103 = new a();
        r101[r102] = r103;
        r103.f561453f = r100[r102];
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    public c() {
    }

    @Override // wu7.g, wu7.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Rect r101 = wu7.f.a(r100);
        int r102 = (int) (r101.width() * 0.33f);
        int r103 = (int) (r101.height() * 0.33f);
        int r104 = 0;
    L4:
        if (r104 >= j()) goto L6;
        int r105 = r101.left + ((r104 % 3) * r102);
        int r106 = r101.top + ((r104 / 3) * r103);
        i(r104).f(r105, r106, r105 + r102, r106 + r103);
        r104 = r104 + 1;
        goto L4
    }
}
