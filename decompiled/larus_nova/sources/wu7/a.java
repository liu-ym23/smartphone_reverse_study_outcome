package wu7;

import android.graphics.Canvas;
import android.graphics.Rect;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a extends g {
    public a() {
    }

    @Override // wu7.g
    public final void h(Canvas r100) {
        int r101 = 0;
    L4:
        if (r101 >= j()) goto L6;
        f r102 = i(r101);
        int r103 = r100.save();
        r100.rotate((r101 * 360) / j(), getBounds().centerX(), getBounds().centerY());
        r102.draw(r100);
        r100.restoreToCount(r103);
        r101 = r101 + 1;
        goto L4
    }

    @Override // wu7.g, wu7.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Rect r101 = f.a(r100);
        int r102 = (int) (((((double) r101.width()) * 3.141592653589793d) / 3.5999999046325684d) / ((double) j()));
        int r103 = r101.centerX() - r102;
        int r104 = r101.centerX() + r102;
        int r105 = 0;
    L4:
        if (r105 >= j()) goto L6;
        f r106 = i(r105);
        int r107 = r101.top;
        r106.f(r103, r107, r104, (r102 * 2) + r107);
        r105 = r105 + 1;
        goto L4
    }
}
