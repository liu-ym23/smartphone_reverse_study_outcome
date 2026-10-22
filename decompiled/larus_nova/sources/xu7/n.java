package xu7;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.os.Build;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.ECStoreJsbErrorCode;
import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes23.dex */
public final class n extends wu7.g {

    public class a extends wu7.c {
        public final int E;

        @Override // wu7.f
        public final ValueAnimator d() {
            float[] r100 = {0.0f, 0.25f, 0.5f, 0.51f, 0.75f, 1.0f};
            uu7.c r101 = new uu7.c(this);
            int r102 = 0;
            r101.e(r100, wu7.f.f561442u, new Integer[]{0, -90, Integer.valueOf(NetError.ERR_WRONG_VERSION_ON_EARLY_DATA), -180, Integer.valueOf(ECStoreJsbErrorCode.PATTERN_EXCEPTION), -360});
            Float r103 = Float.valueOf(0.0f);
            Float r110 = Float.valueOf(0.75f);
            r101.d(r100, wu7.f.f561444w, new Float[]{r103, r110, r110, r110, r103, r103});
            r101.d(r100, wu7.f.f561445x, new Float[]{r103, r103, r110, r110, r110, r103});
            Float r104 = Float.valueOf(1.0f);
            Float r105 = Float.valueOf(0.5f);
            r101.d(r100, wu7.f.f561447z, new Float[]{r104, r105, r104, r104, r105, r104});
            r101.f551774c = 1800;
            r101.b(r100);
            if (Build.VERSION.SDK_INT < 24) goto L10;
            int r106 = this.E;
            if (r106 < 0) goto L8;
            r102 = r106;
        L8:
            r101.f551775d = r102;
        L10:
            return r101.a();
        }

        public a(int r100) {
            this.E = r100;
        }
    }

    @Override // wu7.g
    public final wu7.f[] l() {
        return new wu7.f[]{new a(0), new a(3)};
    }

    public n() {
    }

    @Override // wu7.g
    public final void k(wu7.f... r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        r100[1].f561453f = -900;
        return;
    }

    @Override // wu7.g, wu7.f, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect r100) {
        Rect r101 = wu7.f.a(r100);
        super.onBoundsChange(r101);
        int r102 = 0;
    L4:
        if (r102 >= j()) goto L6;
        wu7.f r103 = i(r102);
        int r104 = r101.left;
        r103.f(r104, r101.top, (r101.width() / 4) + r104, r101.top + (r101.height() / 4));
        r102 = r102 + 1;
        goto L4
    }
}
