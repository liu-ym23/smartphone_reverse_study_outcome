package z53;

/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f570100a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f570101b;

    public static boolean a(int r100, long r101) {
        if (f570100a == r100) goto L5;
        f570100a = r100;
        f570101b = 0;
    L5:
        long r102 = System.currentTimeMillis();
        if ((r102 - f570101b) >= r101) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        f570101b = r102;
    L11:
        return r103;
    L8:
        r103 = false;
        goto L9
    }
}
