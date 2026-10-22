package i75;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public static boolean b(int r1, int r2) {
        if ((r1 * r2) >= ((com.bytedance.ee.util.ui.n.t() * com.bytedance.ee.util.ui.n.v()) * 20)) goto L5;
        return true;
    L5:
        return false;
    }

    public static float a(int r5, int r6, float r7, float r8) {
        if (r7 != 0.0f) goto L5;
    L25:
        return 2.0f;
    L5:
        if (r8 == 0.0f) goto L25;
        if (r5 == 0) goto L25;
        if (r6 == 0) goto L25;
        int r1 = (int) r8;
        int r2 = (int) r7;
        if (r1 == 0) goto L18;
        if (r2 == 0) goto L18;
        if ((r1 / r2) <= 2) goto L16;
    L17:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L25;
        if (r8 <= r7) goto L24;
        return r5 / r7;
    L24:
        return r6 / r8;
    L16:
        if ((r2 / r1) > 2) goto L17;
    L18:
        r3 = false;
        goto L19
    }
}
