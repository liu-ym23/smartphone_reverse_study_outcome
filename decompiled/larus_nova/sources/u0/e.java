package u0;

import android.graphics.PointF;
import i0.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f548111a = null;

    public static class a extends ThreadLocal<PointF> {
        @Override // java.lang.ThreadLocal
        public final PointF initialValue() {
            return new PointF();
        }

        public a() {
        }
    }

    static {
        f548111a = new a();
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

    public static void d(m0.e r100, int r101, List<m0.e> r102, m0.e r103, k r104) {
        if (r100.a(r104.getName(), r101) == false) goto L6;
        String r105 = r104.getName();
        r103.getClass();
        m0.e r106 = new m0.e(r103);
        r106.f511470a.add(r105);
        m0.e r107 = new m0.e(r106);
        r107.f511471b = r104;
        ((ArrayList) r102).add(r107);
        return;
    }
}
