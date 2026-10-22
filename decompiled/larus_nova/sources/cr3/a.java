package cr3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f465037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f465038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f465039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f465040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PointF f465041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PointF f465042f;

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r110) {
        float r100 = r110;
        int r101 = 1;
    L4:
        if (r101 > 13) goto L9;
        PointF r102 = this.f465039c;
        float r103 = 3;
        PointF r104 = this.f465041e;
        float r105 = r104.x * r103;
        r102.x = r105;
        PointF r106 = this.f465038b;
        float r107 = ((this.f465042f.x - r104.x) * r103) - r105;
        r106.x = r107;
        PointF r108 = this.f465037a;
        float r109 = (1 - r102.x) - r107;
        r108.x = r109;
        float r111 = ((r102.x + ((r106.x + (r109 * r100)) * r100)) * r100) - r110;
        if (Math.abs(r111) < this.f465040d) goto L9;
        r100 = r100 - (r111 / (this.f465039c.x + (((2 * this.f465038b.x) + ((r103 * this.f465037a.x) * r100)) * r100)));
        r101 = r101 + 1;
    L9:
        PointF r112 = this.f465039c;
        float r113 = 3;
        PointF r114 = this.f465041e;
        float r115 = r114.y * r113;
        r112.y = r115;
        PointF r116 = this.f465038b;
        float r117 = (r113 * (this.f465042f.y - r114.y)) - r115;
        r116.y = r117;
        PointF r118 = this.f465037a;
        float r119 = (1 - r112.y) - r117;
        r118.y = r119;
        return r100 * (r112.y + ((r116.y + (r119 * r100)) * r100));
    }

    public a(float r100, float r101, float r102) {
        PointF r103 = new PointF(r100, r101);
        PointF r104 = new PointF(r102, 1.0f);
        Intrinsics.checkNotNullParameter(r103, "start");
        Intrinsics.checkNotNullParameter(r104, "end");
        this.f465041e = r103;
        this.f465042f = r104;
        float r105 = r103.x;
        boolean r106 = false;
        float r107 = 0;
        if (r105 >= r107) goto L5;
    L7:
        boolean r108 = false;
    L8:
        if (r108 == false) goto L20;
        float r109 = r104.x;
        if (r109 >= r107) goto L12;
    L14:
        if (r106 == false) goto L18;
        this.f465037a = new PointF();
        this.f465038b = new PointF();
        this.f465039c = new PointF();
        this.f465040d = 0.001d;
        return;
    L18:
        throw new IllegalArgumentException("endX value must be in the range [0, 1]".toString());
    L12:
        if (r109 > 1) goto L14;
        r106 = true;
        goto L14
    L20:
        throw new IllegalArgumentException("startX value must be in the range [0, 1]".toString());
    L5:
        if (r105 > 1) goto L7;
        r108 = true;
        goto L8
    }
}
