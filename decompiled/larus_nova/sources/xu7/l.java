package xu7;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;

/* JADX INFO: loaded from: classes23.dex */
public final class l extends wu7.c {
    @Override // wu7.f
    public final ValueAnimator d() {
        float[] r100 = {0.0f, 0.5f, 1.0f};
        uu7.c r101 = new uu7.c(this);
        r101.e(r100, wu7.f.f561441t, new Integer[]{0, -180, -180});
        r101.e(r100, wu7.f.f561443v, new Integer[]{0, 0, -180});
        r101.f551774c = AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME;
        r101.b(r100);
        return r101.a();
    }

    public l() {
    }

    @Override // wu7.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Rect r101 = wu7.f.a(r100);
        f(r101.left, r101.top, r101.right, r101.bottom);
    }
}
