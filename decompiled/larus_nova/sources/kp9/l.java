package kp9;

/* JADX INFO: loaded from: classes30.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f505563a;

    static {
    }

    public static boolean a() {
        long r100 = System.currentTimeMillis();
        if ((r100 - f505563a) >= 500) goto L6;
        return true;
    L6:
        f505563a = r100;
        return false;
    }
}
