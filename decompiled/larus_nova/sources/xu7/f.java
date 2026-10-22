package xu7;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes23.dex */
public final class f extends wu7.g {

    public class a extends wu7.c {
        @Override // wu7.f
        public final ValueAnimator d() {
            float[] r100 = {0.0f, 0.1f, 0.25f, 0.75f, 0.9f, 1.0f};
            uu7.c r101 = new uu7.c(this);
            r101.e(r100, wu7.f.A, new Integer[]{0, 0, 255, 255, 0, 0});
            r101.e(r100, wu7.f.f561441t, new Integer[]{-180, -180, 0, 0, 0, 0});
            r101.e(r100, wu7.f.f561443v, new Integer[]{0, 0, 0, 0, 180, 180});
            r101.f551774c = 2400;
            r101.f551773b = new LinearInterpolator();
            return r101.a();
        }

        public a() {
            setAlpha(0);
            this.f561454g = -180;
        }
    }

    @Override // wu7.g
    public final wu7.f[] l() {
        a[] r100 = new a[4];
        int r101 = 0;
    L3:
        if (r101 >= 4) goto L9;
        a r102 = new a();
        r100[r101] = r102;
        if (Build.VERSION.SDK_INT < 24) goto L7;
        r102.f561453f = r101 * 300;
    L8:
        r101 = r101 + 1;
        goto L3
    L7:
        r102.f561453f = (r101 * 300) - 1200;
        goto L8
    L9:
        return r100;
    }

    public f() {
    }

    @Override // wu7.g
    public final void h(Canvas r100) {
        Rect r101 = wu7.f.a(getBounds());
        int r102 = 0;
    L4:
        if (r102 >= j()) goto L6;
        int r103 = r100.save();
        r100.rotate((r102 * 90) + 45, r101.centerX(), r101.centerY());
        i(r102).draw(r100);
        r100.restoreToCount(r103);
        r102 = r102 + 1;
        goto L4
    }

    @Override // wu7.g, wu7.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Rect r101 = wu7.f.a(r100);
        int r102 = Math.min(r101.width(), r101.height()) / 2;
        int r103 = (r101.left + r102) + 1;
        int r104 = (r101.top + r102) + 1;
        int r105 = 0;
    L4:
        if (r105 >= j()) goto L6;
        wu7.f r106 = i(r105);
        r106.f(r101.left, r101.top, r103, r104);
        Rect r107 = r106.f561463p;
        r106.f561451d = r107.right;
        r106.f561452e = r107.bottom;
        r105 = r105 + 1;
        goto L4
    }
}
