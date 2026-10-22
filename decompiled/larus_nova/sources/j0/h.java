package j0;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends v0.a<PointF> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Path f496765o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final v0.a<PointF> f496766p;

    /* JADX WARN: Multi-variable type inference failed */
    public final void d() {
        T r100 = this.f552276c;
        if (r100 == 0) goto L9;
        T r101 = this.f552275b;
        if (r101 == 0) goto L9;
        if (((PointF) r101).equals(((PointF) r100).x, ((PointF) r100).y) == false) goto L9;
        boolean r102 = true;
    L10:
        T r103 = this.f552276c;
        if (r103 == 0) goto L24;
        if (r102 == true) goto L25;
        PointF r104 = (PointF) this.f552275b;
        PointF r105 = (PointF) r103;
        v0.a<PointF> r106 = this.f496766p;
        PointF r107 = r106.f552286m;
        PointF r108 = r106.f552287n;
        u0.f.a r109 = u0.f.f548112a;
        Path r110 = new Path();
        r110.moveTo(r104.x, r104.y);
        if (r107 == null) goto L21;
        if (r108 == null) goto L21;
        if (r107.length() == 0.0f) goto L19;
    L20:
        float r111 = r104.x;
        float r112 = r107.x + r111;
        float r113 = r104.y + r107.y;
        float r114 = r105.x;
        float r115 = r114 + r108.x;
        float r116 = r105.y;
        r110.cubicTo(r112, r113, r115, r116 + r108.y, r114, r116);
    L22:
        this.f496765o = r110;
        return;
    L19:
        if (r108.length() != 0.0f) goto L20;
    L21:
        r110.lineTo(r105.x, r105.y);
        goto L22
    L25:
        return;
    L24:
        return;
    L9:
        r102 = false;
        goto L10
    }

    public h(LottieComposition r100, v0.a<PointF> r101) {
        super(r100, r101.f552275b, r101.f552276c, r101.f552277d, r101.f552278e, r101.f552279f);
        this.f496766p = r101;
        d();
    }
}
