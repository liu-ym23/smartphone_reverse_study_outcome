package oz6;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class l extends a<sz6.g, Path> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final sz6.g f527221g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f527222h;

    public l(List<xz6.a<sz6.g>> r100) {
        super(r100);
        this.f527221g = new sz6.g();
        this.f527222h = new Path();
    }

    @Override // oz6.a
    public final Path f(xz6.a<sz6.g> r110, float r210) {
        sz6.g r100 = r110.f565527b;
        sz6.g r101 = r110.f565528c;
        sz6.g r102 = this.f527221g;
        if (r102.f543970b != null) goto L6;
        r102.f543970b = new PointF();
    L6:
        if (r100.f543971c == false) goto L8;
    L11:
        boolean r103 = true;
    L12:
        r102.f543971c = r103;
        if (((ArrayList) r100.f543969a).size() == ((ArrayList) r101.f543969a).size()) goto L16;
        com.bytedance.lottie.c.b("Curves must have the same number of control points. Shape 1: " + ((ArrayList) r100.f543969a).size() + "\tShape 2: " + ((ArrayList) r101.f543969a).size());
    L16:
        if (((ArrayList) r102.f543969a).isEmpty() == false) goto L20;
        int r104 = Math.min(((ArrayList) r100.f543969a).size(), ((ArrayList) r101.f543969a).size());
        int r105 = 0;
    L18:
        if (r105 >= r104) goto L20;
        ((ArrayList) r102.f543969a).add(new qz6.a());
        r105 = r105 + 1;
    L20:
        PointF r106 = r100.f543970b;
        PointF r107 = r101.f543970b;
        float r108 = r106.x;
        float r109 = r108 + ((r107.x - r108) * r210);
        float r111 = r106.y;
        float r112 = r111 + ((r107.y - r111) * r210);
        if (r102.f543970b != null) goto L23;
        r102.f543970b = new PointF();
    L23:
        r102.f543970b.set(r109, r112);
        int r113 = ((ArrayList) r102.f543969a).size() - 1;
    L24:
        if (r113 < 0) goto L26;
        qz6.a r114 = (qz6.a) ListProtector.get(r100.f543969a, r113);
        qz6.a r115 = (qz6.a) ListProtector.get(r101.f543969a, r113);
        PointF r116 = r114.f535354a;
        PointF r117 = r114.f535355b;
        PointF r118 = r114.f535356c;
        PointF r119 = r115.f535354a;
        PointF r120 = r115.f535355b;
        PointF r121 = r115.f535356c;
        qz6.a r122 = (qz6.a) ListProtector.get(r102.f543969a, r113);
        float r123 = r116.x;
        float r124 = r123 + ((r119.x - r123) * r210);
        float r125 = r116.y;
        r122.f535354a.set(r124, r125 + ((r119.y - r125) * r210));
        qz6.a r126 = (qz6.a) ListProtector.get(r102.f543969a, r113);
        float r127 = r117.x;
        float r128 = r127 + ((r120.x - r127) * r210);
        float r129 = r117.y;
        r126.f535355b.set(r128, r129 + ((r120.y - r129) * r210));
        qz6.a r130 = (qz6.a) ListProtector.get(r102.f543969a, r113);
        float r131 = r118.x;
        float r132 = r131 + ((r121.x - r131) * r210);
        float r133 = r118.y;
        r130.f535356c.set(r132, r133 + ((r121.y - r133) * r210));
        r113 = r113 - 1;
        goto L24
    L26:
        sz6.g r134 = this.f527221g;
        Path r135 = this.f527222h;
        r135.reset();
        PointF r136 = r134.f543970b;
        r135.moveTo(r136.x, r136.y);
        float r137 = r136.x;
        float r138 = r136.y;
        Object[] r139 = wz6.f.a.f561954b.f561955a;
        Object r140 = r139[0];
        if (r140 == null) goto L29;
        r139[0] = null;
    L36:
        PointF r141 = (PointF) r140;
        if (r141 != null) goto L39;
        r141 = new PointF(r137, r138);
    L40:
        PointF r142 = r141;
        int r143 = 0;
    L42:
        if (r143 >= ((ArrayList) r134.f543969a).size()) goto L50;
        qz6.a r144 = (qz6.a) ListProtector.get(r134.f543969a, r143);
        PointF r145 = r144.f535354a;
        PointF r146 = r144.f535355b;
        PointF r147 = r144.f535356c;
        if (r145.equals(r142) == true) goto L46;
    L48:
        r135.cubicTo(r145.x, r145.y, r146.x, r146.y, r147.x, r147.y);
    L49:
        r142.set(r147.x, r147.y);
        r143 = r143 + 1;
        goto L42
    L46:
        if (r146.equals(r147) == false) goto L48;
        r135.lineTo(r147.x, r147.y);
        goto L49
    L50:
        Object[] r148 = wz6.f.a.f561954b.f561955a;
        if (r148[0] != null) goto L54;
        r148[0] = r142;
    L60:
        if (r134.f543971c == false) goto L63;
        r135.close();
    L63:
        return this.f527222h;
    L54:
        if (r148[1] != null) goto L57;
        r148[1] = r142;
        goto L60
    L57:
        if (r148[2] != null) goto L60;
        r148[2] = r142;
        goto L60
    L39:
        r141.x = r137;
        r141.y = r138;
        goto L40
    L29:
        r140 = r139[1];
        if (r140 == null) goto L32;
        r139[1] = null;
        goto L36
    L32:
        r140 = r139[2];
        if (r140 == null) goto L35;
        r139[2] = null;
        goto L36
    L35:
        r140 = null;
        goto L36
    L8:
        if (r101.f543971c == true) goto L11;
        r103 = false;
        goto L12
    }
}
