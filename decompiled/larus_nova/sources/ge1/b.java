package ge1;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f481011a = null;

    static {
        f481011a = new Object[0];
    }

    public static int a(long[] r100, int r101, long r102) {
        int r103 = r101 - 1;
        int r104 = 0;
    L3:
        if (r104 > r103) goto L11;
        int r105 = (r104 + r103) >>> 1;
        long r106 = r100[r105];
        if (r106 < r102) goto L6;
        if (r106 <= r102) goto L9;
        r103 = r105 - 1;
        goto L3
    L9:
        return r105;
    L6:
        r104 = r105 + 1;
        goto L3
    L11:
        return ~r104;
    }
}
