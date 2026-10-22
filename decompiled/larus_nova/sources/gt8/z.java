package gt8;

import android.graphics.PointF;
import android.graphics.RectF;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f482676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f482677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f482678c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f482679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f482680e;

    public interface a {
        void a();
    }

    public final RectF a() {
        RectF r100 = new RectF(this.f482676a);
        r100.offset(this.f482678c.x - r100.centerX(), this.f482678c.y - r100.centerY());
        int r101 = ht8.a.f487145a;
        int r102 = this.f482677b;
        PointF r103 = this.f482678c;
        ht8.a.c(r100, r102, r103.x, r103.y);
        return r100;
    }

    public final boolean b() {
        if (((this.f482677b / 90) % 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final float e() {
        if (b() == false) goto L6;
        return this.f482676a.height();
    L6:
        return this.f482676a.width();
    }

    public z(z r100) {
        Intrinsics.checkNotNullParameter(r100, "imageShowLocationHelper");
        this.f482679d = new RectF();
        this.f482676a = new RectF(r100.f482676a);
        PointF r101 = r100.f482678c;
        this.f482678c = new PointF(r101.x, r101.y);
        this.f482677b = r100.f482677b;
    }

    public final void d(z r100) {
        Intrinsics.checkNotNullParameter(r100, "imageShowLocation");
        this.f482676a = new RectF(r100.f482676a);
        PointF r101 = r100.f482678c;
        this.f482678c = new PointF(r101.x, r101.y);
        this.f482677b = r100.f482677b;
        a r102 = this.f482680e;
        if (r102 == null) goto L6;
        Intrinsics.checkNotNull(r102);
        r102.a();
        return;
    }

    public z(RectF r100, int r101, PointF r102) {
        Intrinsics.checkNotNullParameter(r102, "center");
        this.f482679d = new RectF();
        this.f482676a = new RectF(r100);
        this.f482677b = r101;
        this.f482678c = r102;
    }

    public final void c(float r100, float r101, float r102, float r110) {
        if (((this.f482677b / 90) % 2) != 1) goto L5;
        float r103 = r100;
        float r104 = r101;
    L6:
        FLogger r105 = FLogger.f375446a;
        r105.d("PhotoEditScale", "Center before = " + this.f482678c.x + ", scaleCenterX =" + r102 + ", scaleWidth = " + r100);
        PointF r106 = this.f482678c;
        r106.x = ((r106.x - r102) * r100) + r102;
        r106.y = ((r106.y - r110) * r101) + r110;
        StringBuilder r107 = new StringBuilder("Center after = ");
        r107.append(this.f482678c.x);
        r105.d("PhotoEditScale", r107.toString());
        RectF r108 = this.f482676a;
        r108.bottom *= r103;
        r108.top *= r103;
        r108.left *= r104;
        r108.right *= r104;
        a r109 = this.f482680e;
        if (r109 == null) goto L10;
        Intrinsics.checkNotNull(r109);
        r109.a();
        return;
    L10:
        return;
    L5:
        r104 = r100;
        r103 = r101;
        goto L6
    }
}
