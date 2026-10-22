package j0;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class l extends a<o0.g, Path> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final o0.g f496773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Path f496774l;

    public l(List<v0.a<o0.g>> r100) {
        super(r100);
        this.f496773k = new o0.g();
        this.f496774l = new Path();
    }

    @Override // j0.a
    public final Path h(v0.a<o0.g> r110, float r111) {
        o0.g r100 = r110.f552275b;
        o0.g r112 = r110.f552276c;
        o0.g r101 = this.f496773k;
        if (r101.f521591b != null) goto L5;
        r101.f521591b = new PointF();
    L5:
        int r102 = 0;
        if (r100.f521592c == false) goto L8;
    L11:
        boolean r103 = true;
    L12:
        r101.f521592c = r103;
        if (((ArrayList) r100.f521590a).size() == ((ArrayList) r112.f521590a).size()) goto L16;
        com.airbnb.lottie.f.b("Curves must have the same number of control points. Shape 1: " + ((ArrayList) r100.f521590a).size() + "\tShape 2: " + ((ArrayList) r112.f521590a).size());
    L16:
        if (((ArrayList) r101.f521590a).isEmpty() == false) goto L20;
        int r104 = Math.min(((ArrayList) r100.f521590a).size(), ((ArrayList) r112.f521590a).size());
        int r105 = 0;
    L18:
        if (r105 >= r104) goto L20;
        ((ArrayList) r101.f521590a).add(new m0.a());
        r105 = r105 + 1;
    L20:
        PointF r106 = r100.f521591b;
        PointF r107 = r112.f521591b;
        float r108 = r106.x;
        float r109 = r107.x;
        u0.e.a r113 = u0.e.f548111a;
        float r114 = r108 + ((r109 - r108) * r111);
        float r115 = r106.y;
        float r116 = r115 + ((r107.y - r115) * r111);
        if (r101.f521591b != null) goto L23;
        r101.f521591b = new PointF();
    L23:
        r101.f521591b.set(r114, r116);
        int r117 = ((ArrayList) r101.f521590a).size() - 1;
    L24:
        if (r117 < 0) goto L26;
        m0.a r118 = (m0.a) ListProtector.get(r100.f521590a, r117);
        m0.a r119 = (m0.a) ListProtector.get(r112.f521590a, r117);
        PointF r120 = r118.f511449a;
        PointF r121 = r118.f511450b;
        PointF r122 = r118.f511451c;
        PointF r123 = r119.f511449a;
        PointF r124 = r119.f511450b;
        PointF r125 = r119.f511451c;
        m0.a r126 = (m0.a) ListProtector.get(r101.f521590a, r117);
        float r127 = r120.x;
        float r128 = r127 + ((r123.x - r127) * r111);
        float r129 = r120.y;
        r126.f511449a.set(r128, r129 + ((r123.y - r129) * r111));
        m0.a r130 = (m0.a) ListProtector.get(r101.f521590a, r117);
        float r131 = r121.x;
        float r132 = r131 + ((r124.x - r131) * r111);
        float r133 = r121.y;
        r130.f511450b.set(r132, r133 + ((r124.y - r133) * r111));
        m0.a r134 = (m0.a) ListProtector.get(r101.f521590a, r117);
        float r135 = r122.x;
        float r136 = r135 + ((r125.x - r135) * r111);
        float r137 = r122.y;
        r134.f511451c.set(r136, r137 + ((r125.y - r137) * r111));
        r117 = r117 - 1;
        goto L24
    L26:
        o0.g r138 = this.f496773k;
        Path r139 = this.f496774l;
        r139.reset();
        PointF r140 = r138.f521591b;
        r139.moveTo(r140.x, r140.y);
        if (r0.c.a.f535397a == false) goto L29;
        PointF r141 = u0.e.f548111a.get();
        r141.set(r140.x, r140.y);
    L31:
        if (r102 >= ((ArrayList) r138.f521590a).size()) goto L40;
        m0.a r142 = (m0.a) ListProtector.get(r138.f521590a, r102);
        PointF r143 = r142.f511449a;
        PointF r144 = r142.f511450b;
        PointF r145 = r142.f511451c;
        if (r143.equals(r141) == true) goto L35;
    L37:
        r139.cubicTo(r143.x, r143.y, r144.x, r144.y, r145.x, r145.y);
    L38:
        r141.set(r145.x, r145.y);
        r102 = r102 + 1;
        goto L31
    L35:
        if (r144.equals(r145) == false) goto L37;
        r139.lineTo(r145.x, r145.y);
        goto L38
    L40:
        if (r138.f521592c == false) goto L43;
        r139.close();
    L43:
        return this.f496774l;
    L29:
        r141 = new PointF(r140.x, r140.y);
        goto L31
    L8:
        if (r112.f521592c == true) goto L11;
        r103 = false;
        goto L12
    }
}
