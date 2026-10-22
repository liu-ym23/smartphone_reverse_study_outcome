package qfc;

import android.graphics.PointF;
import android.graphics.RectF;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f532854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f532855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f532856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f532857d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f532858e;

    public interface a {
    }

    public final RectF a() {
        RectF r100 = new RectF(this.f532854a);
        r100.offset(this.f532856c.x - r100.centerX(), this.f532856c.y - r100.centerY());
        int r101 = this.f532855b;
        PointF r102 = this.f532856c;
        com.ss.android.photoeditor.util.b.d(r100, r101, r102.x, r102.y);
        return r100;
    }

    public final boolean b() {
        if (((this.f532855b / 90) % 2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final float e() {
        if (b() == false) goto L7;
        return this.f532854a.height();
    L7:
        return this.f532854a.width();
    }

    public y(y r100) {
        this.f532854a = new RectF(r100.f532854a);
        PointF r101 = r100.f532856c;
        this.f532856c = new PointF(r101.x, r101.y);
        this.f532855b = r100.f532855b;
    }

    public final void d(y r100) {
        RectF r101 = r100.f532854a;
        this.f532854a.set(r101);
        PointF r102 = r100.f532856c;
        this.f532856c.set(r102);
        this.f532855b = r100.f532855b;
        a r103 = this.f532858e;
        if (r103 == null) goto L6;
        ((j.a) r103).f532797a.f532796e = true;
        return;
    }

    public y(RectF r100, PointF r101) {
        this.f532854a = new RectF(r100);
        this.f532855b = 0;
        this.f532856c = r101;
    }

    public final void c(float r100, float r101, float r102, float r110) {
        if (((this.f532855b / 90) % 2) != 1) goto L5;
        float r103 = r100;
        float r104 = r101;
    L6:
        Log.d("PhotoEditScale", "Center before = " + this.f532856c.x + ", scaleCenterX =" + r102 + ", scaleWidth = " + r100);
        PointF r105 = this.f532856c;
        r105.x = ((r105.x - r102) * r100) + r102;
        r105.y = ((r105.y - r110) * r101) + r110;
        StringBuilder r106 = new StringBuilder("Center after = ");
        r106.append(this.f532856c.x);
        Log.d("PhotoEditScale", r106.toString());
        RectF r107 = this.f532854a;
        r107.bottom *= r103;
        r107.top *= r103;
        r107.left *= r104;
        r107.right *= r104;
        a r108 = this.f532858e;
        if (r108 == null) goto L10;
        ((j.a) r108).f532797a.f532796e = true;
        return;
    L10:
        return;
    L5:
        r104 = r100;
        r103 = r101;
        goto L6
    }
}
