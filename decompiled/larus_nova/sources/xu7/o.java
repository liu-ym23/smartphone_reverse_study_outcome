package xu7;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;

/* JADX INFO: loaded from: classes23.dex */
public final class o extends wu7.g {

    public class a extends wu7.c {
        @Override // wu7.f
        public final ValueAnimator d() {
            float[] r100 = {0.0f, 0.2f, 0.4f, 1.0f};
            uu7.c r101 = new uu7.c(this);
            Float r102 = Float.valueOf(0.4f);
            r101.d(r100, wu7.f.f561446y, new Float[]{r102, Float.valueOf(1.0f), r102, r102});
            r101.f551774c = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
            r101.b(r100);
            return r101.a();
        }

        public a() {
            this.f561450c = 0.4f;
        }
    }

    @Override // wu7.g
    public final wu7.f[] l() {
        a[] r100 = new a[5];
        int r101 = 0;
    L3:
        if (r101 >= 5) goto L9;
        a r102 = new a();
        r100[r101] = r102;
        if (Build.VERSION.SDK_INT < 24) goto L7;
        r102.f561453f = (r101 * 100) + 600;
    L8:
        r101 = r101 + 1;
        goto L3
    L7:
        r102.f561453f = (r101 * 100) - 1200;
        goto L8
    L9:
        return r100;
    }

    public o() {
    }

    @Override // wu7.g, wu7.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        super.onBoundsChange(r100);
        Rect r101 = wu7.f.a(r100);
        int r102 = r101.width() / j();
        int r103 = ((r101.width() / 5) * 3) / 5;
        int r104 = 0;
    L4:
        if (r104 >= j()) goto L6;
        wu7.f r105 = i(r104);
        int r106 = (r101.left + (r104 * r102)) + (r102 / 5);
        int r107 = r101.top;
        r105.f(r106, r107, r106 + r103, r101.bottom);
        r104 = r104 + 1;
        goto L4
    }
}
