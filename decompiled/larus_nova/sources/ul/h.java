package ul;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f550588a = 0;

    public h() {
    }

    static {
    }

    public static int a(long r100, Integer r101, boolean r102, Integer r103, boolean r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r102 = false;
    L9:
        if ((r105 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r105 & 16) == 0) goto L14;
        r104 = true;
    L14:
        if (r103 == null) goto L19;
        if (r103.intValue() <= 0) goto L19;
        return r103.intValue();
    L19:
        if (r100 != 0) goto L25;
        if (r101 != null) goto L23;
    L24:
        return 101;
    L23:
        if (r101.intValue() != 4) goto L24;
    L25:
        if (r100 != 0) goto L32;
        if (r101 == null) goto L32;
        if (r101.intValue() != 4) goto L32;
        return 102;
    L32:
        if (r100 != 1) goto L35;
        return 201;
    L35:
        if (r100 != 9) goto L37;
    L72:
        return 301;
    L37:
        if (r100 == 7) goto L72;
        if (r100 == 8) goto L72;
        if (r100 != 10) goto L45;
        return 302;
    L45:
        if (r100 != 5) goto L48;
        return 601;
    L48:
        if (r100 != 6) goto L51;
        if (r104 == true) goto L51;
        return 703;
    L51:
        if (r100 != 6) goto L54;
        if (r102 == false) goto L54;
        return 702;
    L54:
        if (r100 != 6) goto L58;
        if (r102 == true) goto L58;
        return 701;
    L58:
        if (r100 != 2) goto L61;
        return 901;
    L61:
        if (r100 != 13) goto L64;
        return 1201;
    L64:
        if (r100 != 4) goto L67;
        return 1001;
    L67:
        if (r100 != 12) goto L70;
        return 1101;
    L70:
        if (r100 != 11) goto L87;
        return 1301;
    L87:
        return 0;
    }
}
