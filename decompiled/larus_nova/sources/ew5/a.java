package ew5;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f474601a = 0;

    static {
    }

    public static long a(Long r100, Long r101) {
        long r102 = 0;
        if (r100 == null) goto L5;
        long r103 = r100.longValue();
    L7:
        if (r103 <= 0) goto L10;
        if (r100 == null) goto L18;
        r102 = r100.longValue();
    L18:
        if (r102 < 1000000000000000L) goto L21;
        return r102 / 1000000;
    L21:
        if (r102 >= 1000000000000L) goto L23;
        return r102;
    L23:
        return r102 / 1000;
    L10:
        if (r101 == null) goto L12;
        long r104 = r101.longValue();
    L14:
        if (r104 <= 0) goto L18;
        if (r101 == null) goto L18;
        r102 = r101.longValue();
        goto L18
    L12:
        r104 = 0;
        goto L14
    L5:
        r103 = 0;
        goto L7
    }
}
