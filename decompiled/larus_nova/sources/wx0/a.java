package wx0;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f561754a;

    /* JADX INFO: renamed from: wx0.a$a, reason: collision with other inner class name */
    public static final class C8169a {
    }

    static {
    }

    public a() {
        this.f561754a = new RectF();
    }

    public static RectF b(float r100, float r101, RectF r102) {
        float r103 = r101 * 1.0f;
        float r104 = RangesKt.coerceAtMost(r103, r100 * 1.0f);
        RectF r105 = new RectF(r102);
        Matrix r106 = new Matrix();
        float r107 = r104 / r103;
        if (r104 < r103) goto L5;
        float r108 = 0.0f;
    L6:
        r106.postScale(r107, 1.0f);
        r106.postTranslate(r108, 0.0f);
        r106.mapRect(r105);
        return r105;
    L5:
        r108 = 1.0f - r107;
        goto L6
    }

    public static RectF a(float r100, float r101, float r102, RectF r103) {
        float r104 = r100 * 1.0f;
        float r105 = r102 * r104;
        float r106 = RangesKt.coerceAtMost(r105, r101 * 1.0f);
        RectF r107 = new RectF(r103);
        Matrix r108 = new Matrix();
        float r109 = r106 / r105;
        r108.postScale(r109, (r104 * 1.0f) / r104);
        r108.postTranslate((1.0f - r109) / 2.0f, 0.0f);
        r108.mapRect(r107);
        jy0.b.d("DefaultStream2VisibleAreaConvert", "computeRule1Pos visibleRelativePos = " + r107.left + ", " + r107.top + ", " + r107.right + ", " + r107.bottom);
        return r107;
    }
}
