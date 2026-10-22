package ed0;

import android.graphics.PointF;
import com.bytedance.android.live.liveinteract.utils.EPointF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {
    static {
    }

    public static float a(PointF r100, PointF r110, EPointF r111) {
        Intrinsics.checkNotNullParameter(r100, "originPoint");
        Intrinsics.checkNotNullParameter(r110, "pointA");
        Intrinsics.checkNotNullParameter(r111, "pointB");
        Intrinsics.checkNotNullParameter(r100, "originPoint");
        Intrinsics.checkNotNullParameter(r110, "pointA");
        Intrinsics.checkNotNullParameter(r111, "pointB");
        PointF r101 = new PointF(r110.x - r100.x, r110.y - r100.y);
        PointF r102 = new PointF(((PointF) r111).x - r100.x, ((PointF) r111).y - r100.y);
        float r103 = (r101.x * r102.y) - (r101.y * r102.x);
        Intrinsics.checkNotNullParameter(r100, "originPoint");
        Intrinsics.checkNotNullParameter(r110, "pointA");
        Intrinsics.checkNotNullParameter(r111, "pointB");
        PointF r104 = new PointF(r110.x - r100.x, r110.y - r100.y);
        PointF r105 = new PointF(((PointF) r111).x - r100.x, ((PointF) r111).y - r100.y);
        Intrinsics.checkNotNullParameter(r100, "originPoint");
        Intrinsics.checkNotNullParameter(r110, "pointA");
        Intrinsics.checkNotNullParameter(r111, "pointB");
        PointF r106 = new PointF(r110.x - r100.x, r110.y - r100.y);
        PointF r112 = new PointF(((PointF) r111).x - r100.x, ((PointF) r111).y - r100.y);
        float r107 = (r106.x * r112.x) + (r106.y * r112.y);
        float r113 = r104.x;
        float r114 = r104.y;
        double r115 = Math.sqrt((r113 * r113) + (r114 * r114));
        float r108 = r105.x;
        float r109 = r105.y;
        float r116 = 0;
        float r117 = (float) Math.toDegrees(Math.acos(((double) r107) / (r115 * Math.sqrt((r108 * r108) + (r109 * r109)))));
        if (r103 <= r116) goto L6;
        return r117;
    L6:
        return r116 - r117;
    }
}
