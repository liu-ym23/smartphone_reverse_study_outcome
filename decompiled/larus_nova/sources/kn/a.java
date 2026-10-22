package kn;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f504133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f504134b;

    static {
        f504133a = -1;
    }

    public static boolean a(int r100) {
        if (f504133a == r100) goto L5;
        f504133a = r100;
        f504134b = 0;
    L5:
        long r101 = System.currentTimeMillis();
        if ((r101 - f504134b) >= 500) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        f504134b = r101;
    L11:
        return r102;
    L8:
        r102 = false;
        goto L9
    }
}
