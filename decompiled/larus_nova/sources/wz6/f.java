package wz6;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;
import nz6.j;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    public static class a extends g<PointF> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f561954b = null;

        @Override // wz6.g
        public final Object[] a() {
            return new PointF[3];
        }

        static {
            f561954b = new a();
        }

        public a() {
        }
    }

    public static PointF a(PointF r100, PointF r101) {
        return new PointF(r100.x + r101.x, r100.y + r101.y);
    }

    public static int c(float r100, float r101) {
        int r102 = (int) r100;
        int r103 = (int) r101;
        int r104 = r102 / r103;
        if ((r102 ^ r103) < 0) goto L5;
        boolean r105 = true;
    L6:
        int r106 = r102 % r103;
        if (r105 == true) goto L11;
        if (r106 == 0) goto L11;
        r104 = r104 - 1;
    L11:
        return r102 - (r103 * r104);
    L5:
        r105 = false;
        goto L6
    }

    public static float b(float r100, float r101, float r102) {
        return Math.max(r101, Math.min(r102, r100));
    }

    public static void d(qz6.e r100, int r101, List<qz6.e> r102, qz6.e r103, j r104) {
        if (r100.a(r104.getName(), r101) == false) goto L6;
        String r105 = r104.getName();
        r103.getClass();
        qz6.e r106 = new qz6.e(r103);
        r106.f535375a.add(r105);
        qz6.e r107 = new qz6.e(r106);
        r107.f535376b = r104;
        ((ArrayList) r102).add(r107);
        return;
    }
}
