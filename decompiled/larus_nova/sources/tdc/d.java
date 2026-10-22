package tdc;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.ImageView;
import com.google.android.material.animation.MatrixEvaluator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MatrixEvaluator f545547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f545548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Matrix f545549d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f545550a = null;

        static {
            int[] r100 = new int[ImageView.ScaleType.values().length];
            r100[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[ImageView.ScaleType.FIT_START.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[ImageView.ScaleType.FIT_END.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[ImageView.ScaleType.CENTER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ImageView.ScaleType.CENTER_CROP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f545550a = r100;
        }
    }

    public d(tdc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f545547b = new MatrixEvaluator();
        this.f545548c = a(r100.e(), r100.c(), r100.b());
        this.f545549d = a(r100.e(), r100.d(), r100.a());
    }

    public static Matrix a(long r100, Rect r110, ImageView.ScaleType r111) {
        int r101 = (int) (r100 >> 32);
        int r112 = (int) r100;
        int r102 = r110.width();
        int r103 = r110.height();
        int r104 = r110.left;
        int r113 = r110.top;
        Matrix r105 = new Matrix();
        if (r101 == 0) goto L37;
        if (r112 == 0) goto L37;
        if (r103 == 0) goto L37;
        if (r102 == 0) goto L37;
        int[] r106 = a.f545550a;
        int r107 = r106[r111.ordinal()];
        if (r107 == 4) goto L35;
        float r108 = 0.0f;
        if (r107 == 5) goto L31;
        if (r107 == 6) goto L25;
        RectF r109 = new RectF(0.0f, 0.0f, r101, r112);
        RectF r114 = new RectF(0.0f, 0.0f, r102, r103);
        int r115 = r106[r111.ordinal()];
        if (r115 != 1) goto L17;
        Matrix.ScaleToFit r116 = Matrix.ScaleToFit.CENTER;
    L24:
        r105.setRectToRect(r109, r114, r116);
    L36:
        r105.postTranslate(r104, r113);
        goto L37
    L17:
        if (r115 != 2) goto L19;
        r116 = Matrix.ScaleToFit.START;
        goto L24
    L19:
        if (r115 == 3) goto L21;
        r116 = Matrix.ScaleToFit.END;
        goto L24
    L21:
        r116 = Matrix.ScaleToFit.END;
        goto L24
    L25:
        if (r101 > r102) goto L28;
        if (r112 > r103) goto L28;
        float r117 = 1.0f;
    L29:
        float r118 = MathKt.roundToInt((r102 - (r101 * r117)) * 0.5f);
        float r119 = MathKt.roundToInt((r103 - (r112 * r117)) * 0.5f);
        r105.setScale(r117, r117);
        r105.postTranslate(r118, r119);
    L28:
        r117 = RangesKt.coerceAtMost(r102 / r101, r103 / r112);
        goto L29
    L31:
        if ((r101 * r103) <= (r102 * r112)) goto L33;
        float r120 = r103 / r112;
        r108 = (r102 - (r101 * r120)) * 0.5f;
        float r121 = 0.0f;
    L34:
        r105.setScale(r120, r120);
        r105.postTranslate(MathKt.roundToInt(r108), MathKt.roundToInt(r121));
        goto L36
    L33:
        r120 = r102 / r101;
        r121 = (r103 - (r112 * r120)) * 0.5f;
        goto L34
    L35:
        r105.setTranslate(MathKt.roundToInt((r102 - r101) * 0.5f), MathKt.roundToInt((r103 - r112) * 0.5f));
    L37:
        return r105;
    }
}
