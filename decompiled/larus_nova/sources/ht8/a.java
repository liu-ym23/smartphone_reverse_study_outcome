package ht8;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.exifinterface.media.ExifInterface;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f487145a = 0;

    static {
    }

    public static void d(RectF r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        e(r100, 0.0f, 0.0f, r101, r101);
    }

    public static RectF a(PointF r100, PointF r101, PointF r102, PointF r103) {
        Intrinsics.checkNotNullParameter(r100, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        Intrinsics.checkNotNullParameter(r101, "B");
        Intrinsics.checkNotNullParameter(r102, "C");
        Intrinsics.checkNotNullParameter(r103, "D");
        if (Math.abs(r100.x - r101.x) >= 3.0f) goto L24;
        if (r100.x >= r102.x) goto L15;
        if (r100.y < r101.y) goto L11;
        r100 = r101;
    L11:
        if (r102.y > r103.y) goto L63;
        r102 = r103;
    L63:
        return new RectF(r100.x, r100.y, r102.x, r102.y);
    L15:
        if (r102.y < r103.y) goto L19;
        r102 = r103;
    L19:
        if (r100.y > r101.y) goto L22;
        r100 = r101;
    L22:
        PointF r104 = r102;
        r102 = r100;
        r100 = r104;
        goto L63
    L24:
        if (Math.abs(r100.x - r102.x) >= 3.0f) goto L44;
        if (r100.x >= r101.x) goto L36;
        if (r100.y < r102.y) goto L32;
        r100 = r102;
    L32:
        if (r101.y > r103.y) goto L52;
        r101 = r103;
    L52:
        r102 = r101;
        goto L63
    L36:
        if (r101.y < r103.y) goto L40;
        r101 = r103;
    L40:
        if (r100.y > r102.y) goto L61;
        r100 = r102;
    L61:
        r102 = r100;
        r100 = r101;
        goto L63
    L44:
        if (r100.x >= r101.x) goto L54;
        if (r100.y < r103.y) goto L50;
        r100 = r103;
    L50:
        if (r102.y <= r101.y) goto L52;
        r101 = r102;
        goto L52
    L54:
        if (r101.y < r102.y) goto L58;
        r101 = r102;
    L58:
        if (r100.y > r103.y) goto L61;
        r100 = r103;
        goto L61
    }

    public static void b(PointF r100, float r101, float r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "point");
        double r102 = r111 * 0.017453292f;
        float r112 = (float) (((((double) (r100.x - r101)) * Math.cos(r102)) - (((double) (r100.y - r110)) * Math.sin(r102))) + ((double) r101));
        float r103 = (float) (((((double) (r100.x - r101)) * Math.sin(r102)) + (((double) (r100.y - r110)) * Math.cos(r102))) + ((double) r110));
        r100.x = r112;
        r100.y = r103;
    }

    public static void c(RectF r100, int r101, float r102, float r103) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        PointF r104 = new PointF(r100.left, r100.top);
        PointF r105 = new PointF(r100.right, r100.top);
        PointF r106 = new PointF(r100.left, r100.bottom);
        PointF r107 = new PointF(r100.right, r100.bottom);
        b(r104, r102, r103, r101);
        b(r105, r102, r103, r101);
        b(r106, r102, r103, r101);
        b(r107, r102, r103, r101);
        r100.set(a(r104, r105, r106, r107));
    }

    public static void e(RectF r100, float r101, float r102, float r103, float r104) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        r100.left = ((r100.left - r101) * r103) + r101;
        r100.right = ((r100.right - r101) * r103) + r101;
        r100.top = ((r100.top - r102) * r104) + r102;
        r100.bottom = ((r100.bottom - r102) * r104) + r102;
    }
}
