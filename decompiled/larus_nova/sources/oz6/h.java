package oz6;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes21.dex */
public final class h extends xz6.a<PointF> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Path f527215k;

    public h(com.bytedance.lottie.d r110, xz6.a<PointF> r111) {
        PointF r100 = r111.f565527b;
        PointF r101 = r111.f565528c;
        super(r110, r100, r101, r111.f565529d, r111.f565530e, r111.f565531f);
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        PointF r102 = r101;
        if (r100.equals(r102.x, r102.y) == false) goto L8;
        boolean r103 = true;
    L9:
        if (r101 == null) goto L22;
        if (r103 == true) goto L22;
        PointF r104 = r100;
        PointF r105 = r101;
        PointF r106 = r111.f565534i;
        PointF r107 = r111.f565535j;
        PathMeasure r108 = wz6.h.f561956a;
        Path r109 = new Path();
        r109.moveTo(r104.x, r104.y);
        if (r106 == null) goto L19;
        if (r107 == null) goto L19;
        if (r106.length() == 0.0f) goto L17;
    L18:
        float r112 = r104.x;
        float r113 = r106.x + r112;
        float r114 = r104.y + r106.y;
        float r115 = r105.x;
        float r116 = r115 + r107.x;
        float r117 = r105.y;
        r109.cubicTo(r113, r114, r116, r117 + r107.y, r115, r117);
    L20:
        this.f527215k = r109;
        return;
    L17:
        if (r107.length() != 0.0f) goto L18;
    L19:
        r109.lineTo(r105.x, r105.y);
    L22:
        return;
    L8:
        r103 = false;
        goto L9
    }
}
