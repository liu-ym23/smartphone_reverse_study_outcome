package s6a;

import android.util.SparseArray;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BaseInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f540876a = null;

    public static class a extends SparseArray<BaseInterpolator> {
        public a() {
            put(0, new LinearInterpolator());
            put(1, new AccelerateInterpolator());
            put(2, new DecelerateInterpolator());
            put(3, new AccelerateDecelerateInterpolator());
        }
    }

    /* JADX INFO: renamed from: s6a.b$b, reason: collision with other inner class name */
    public static class InterpolatorC7576b implements Interpolator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f540877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f540878b;

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            int r101 = this.f540878b;
            if (r101 != 1) goto L5;
            int r102 = this.f540877a;
            int r103 = ((int) (r100 * r102)) + 1;
            if (r103 > r102) goto L28;
        L25:
            float r104 = r103;
        L17:
            return r104 / r102;
        L28:
            r103 = r102;
            goto L25
        L5:
            if (r101 != 2) goto L7;
            r102 = this.f540877a;
            r103 = (int) (r100 * r102);
            if (r103 != r102) goto L25;
            r103 = r103 - 1;
            goto L25
        L7:
            if (r101 != 3) goto L9;
            int r105 = this.f540877a;
            int r106 = (int) (r100 * r105);
            if (r106 != r105) goto L21;
            r106 = r106 - 1;
        L21:
            r104 = r106;
            r102 = r105 - 1;
            goto L17
        L9:
            if (r101 == 4) goto L12;
            return 0.0f;
        L12:
            int r107 = this.f540877a;
            int r108 = ((int) (r100 * r107)) + 1;
            if (r108 <= r107) goto L15;
            r108 = r107;
        L15:
            r104 = r108;
            r102 = r107 + 1;
            goto L17
        }

        public InterpolatorC7576b(int r100, int r101) {
            this.f540877a = r100;
            this.f540878b = r101;
        }
    }

    public b() {
    }

    static {
        f540876a = new a();
    }

    public static Interpolator a(s6a.a r100) {
        int r101 = r100.f540864e;
        switch(r101) {
            case 0: goto L24;
            case 1: goto L24;
            case 2: goto L24;
            case 3: goto L24;
            case 4: goto L18;
            case 5: goto L9;
            case 6: goto L7;
            default: goto L4;
        };
    L4:
        LLog.DTHROW(new RuntimeException("layout animation don't support interpolator:" + r101));
        return f540876a.get(0);
    L7:
        return new InterpolatorC7576b((int) r100.f540865f, r100.f540869j);
    L9:
        if (b(r100.f540865f) == true) goto L11;
    L15:
        LLog.w("InterpolatorFactory", "Invalid cubic-bezier control points x1=" + r100.f540865f + ", x2=" + r100.f540867h + ", fallback to linear.");
        return f540876a.get(0);
    L11:
        if (b(r100.f540867h) == false) goto L15;
        return PathInterpolatorCompat.create(r100.f540865f, r100.f540866g, r100.f540867h, r100.f540868i);
    L18:
        if (b(r100.f540865f) == true) goto L22;
        LLog.w("InterpolatorFactory", "Invalid square-bezier control point x=" + r100.f540865f + ", fallback to linear.");
        return f540876a.get(0);
    L22:
        return PathInterpolatorCompat.create(r100.f540865f, r100.f540866g);
    L24:
        return f540876a.get(r101);
    }

    public static boolean b(float r100) {
        if (Float.isNaN(r100) == false) goto L5;
    L11:
        return false;
    L5:
        if (Float.isInfinite(r100) == true) goto L11;
        if (r100 < 0.0f) goto L11;
        if (r100 > 1.0f) goto L11;
        return true;
    }
}
