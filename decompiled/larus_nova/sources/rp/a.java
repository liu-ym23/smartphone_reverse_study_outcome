package rp;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f538829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f538830b;

    static {
        f538829a = -1;
    }

    public static boolean a(int r100) {
        if (f538829a == r100) goto L5;
        f538829a = r100;
        f538830b = 0;
    L5:
        long r101 = System.currentTimeMillis();
        if ((r101 - f538830b) >= 500) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        f538830b = r101;
    L11:
        return r102;
    L8:
        r102 = false;
        goto L9
    }
}
