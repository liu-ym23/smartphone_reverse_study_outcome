package gt8;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes26.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f482585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PointF f482586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PointF f482587c;

    public static final class a {
    }

    static {
    }

    public final float a() {
        PointF r100 = this.f482586b;
        float r101 = r100.y;
        PointF r102 = this.f482585a;
        float r103 = r102.y;
        float r104 = (r101 - r103) * (r101 - r103);
        float r105 = r100.x;
        float r106 = r102.x;
        return (float) Math.sqrt(r104 + ((r105 - r106) * (r105 - r106)));
    }

    public final String toString() {
        return "/n1.  " + this.f482585a + "/n；2. " + this.f482586b;
    }

    public a0(float r100, float r101, float r102, float r103) {
        this.f482585a = new PointF(r100, r101);
        this.f482586b = new PointF(r102, r103);
        float r104 = r100 + r102;
        float r105 = 2;
        this.f482587c = new PointF(r104 / r105, (r101 + r103) / r105);
    }
}
