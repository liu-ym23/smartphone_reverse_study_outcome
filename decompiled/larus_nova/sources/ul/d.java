package ul;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f550586a = 0;

    public d() {
    }

    static {
    }

    public static int a(long r100, boolean r101, Integer r102) {
        if (r102 != null) goto L38;
        if (r101 == false) goto L6;
        return 2;
    L6:
        if (r101 == true) goto L23;
        if (r100 != 0) goto L10;
    L21:
        return 1;
    L10:
        if (r100 == 1) goto L21;
        if (r100 == 10) goto L21;
        if (r100 == 9) goto L21;
        if (r100 == 8) goto L21;
        if (r100 == 7) goto L21;
        if (r100 == 5) goto L21;
    L23:
        if (r100 != 4) goto L25;
    L36:
        return 3;
    L25:
        if (r100 == 2) goto L36;
        if (r100 == 11) goto L36;
        if (r100 == 6) goto L36;
        if (r100 == 12) goto L36;
        if (r100 == 13) goto L36;
        return 0;
    L38:
        return r102.intValue();
    }

    public static /* synthetic */ int b(long r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r101 = false;
    L6:
        return a(r100, r101, null);
    }
}
