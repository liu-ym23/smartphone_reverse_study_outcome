package i75;

/* JADX INFO: loaded from: classes16.dex */
public final class m {
    public static boolean b(int r100, int r101) {
        if ((r100 * r101) >= ((com.bytedance.ee.util.ui.n.t() * com.bytedance.ee.util.ui.n.v()) * 20)) goto L5;
        return true;
    L5:
        return false;
    }

    public static float a(int r100, int r101, float r102, float r103) {
        if (r102 != 0.0f) goto L5;
    L25:
        return 2.0f;
    L5:
        if (r103 == 0.0f) goto L25;
        if (r100 == 0) goto L25;
        if (r101 == 0) goto L25;
        int r104 = (int) r103;
        int r105 = (int) r102;
        if (r104 == 0) goto L18;
        if (r105 == 0) goto L18;
        if ((r104 / r105) <= 2) goto L16;
    L17:
        boolean r106 = true;
    L19:
        if (r106 == false) goto L25;
        if (r103 <= r102) goto L24;
        return r100 / r102;
    L24:
        return r101 / r103;
    L16:
        if ((r105 / r104) > 2) goto L17;
    L18:
        r106 = false;
        goto L19
    }
}
