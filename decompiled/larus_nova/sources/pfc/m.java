package pfc;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes38.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f529084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f529085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f529086c;

    public final float a() {
        PointF r100 = this.f529085b;
        float r101 = r100.y;
        PointF r102 = this.f529084a;
        float r103 = r102.y;
        float r104 = (r101 - r103) * (r101 - r103);
        float r105 = r100.x;
        float r106 = r102.x;
        return (float) Math.sqrt(r104 + ((r105 - r106) * (r105 - r106)));
    }

    public final float b() {
        PointF r100 = this.f529084a;
        float r101 = r100.x;
        PointF r102 = this.f529085b;
        return (float) Math.atan(((double) (r100.y - r102.y)) / (r101 - r102.x));
    }

    public final String toString() {
        return "/n1.  " + this.f529084a.toString() + "/n；2. " + this.f529085b.toString();
    }

    public final void d(m r100) {
        PointF r101 = this.f529084a;
        PointF r102 = r100.f529084a;
        r101.x = r102.x;
        r101.y = r102.y;
        PointF r103 = this.f529085b;
        PointF r104 = r100.f529085b;
        float r105 = r104.x;
        r103.x = r105;
        float r106 = r104.y;
        r103.y = r106;
        PointF r107 = this.f529086c;
        r107.x = (r101.x + r105) / 2.0f;
        r107.y = (r101.y + r106) / 2.0f;
    }

    public m(float r100, float r101, float r102, float r103) {
        this.f529084a = new PointF(r100, r101);
        this.f529085b = new PointF(r102, r103);
        this.f529086c = new PointF((r100 + r102) / 2.0f, (r101 + r103) / 2.0f);
    }

    public final void c(float r100, float r101, float r102, float r103) {
        PointF r104 = this.f529084a;
        r104.x = r100;
        r104.y = r101;
        PointF r105 = this.f529085b;
        r105.x = r102;
        r105.y = r103;
        PointF r106 = this.f529086c;
        r106.x = (r104.x + r102) / 2.0f;
        r106.y = (r104.y + r103) / 2.0f;
    }
}
