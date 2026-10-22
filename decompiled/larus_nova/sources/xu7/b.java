package xu7;

import android.animation.ValueAnimator;
import android.os.Build;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;

/* JADX INFO: loaded from: classes23.dex */
public final class b extends wu7.a {

    public class a extends wu7.b {
        @Override // wu7.f
        public final ValueAnimator d() {
            float[] r100 = {0.0f, 0.5f, 1.0f};
            uu7.c r101 = new uu7.c(this);
            Float r102 = Float.valueOf(0.0f);
            r101.d(r100, wu7.f.f561447z, new Float[]{r102, Float.valueOf(1.0f), r102});
            r101.f551774c = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
            r101.b(r100);
            return r101.a();
        }

        public a() {
            g(0.0f);
        }
    }

    @Override // wu7.g
    public final wu7.f[] l() {
        a[] r100 = new a[12];
        int r101 = 0;
    L3:
        if (r101 >= 12) goto L9;
        a r102 = new a();
        r100[r101] = r102;
        if (Build.VERSION.SDK_INT < 24) goto L7;
        r102.f561453f = r101 * 100;
    L8:
        r101 = r101 + 1;
        goto L3
    L7:
        r102.f561453f = (r101 * 100) - 1200;
        goto L8
    L9:
        return r100;
    }

    public b() {
    }
}
