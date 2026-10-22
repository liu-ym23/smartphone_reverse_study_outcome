package uk9;

/* JADX INFO: loaded from: classes30.dex */
public final class a {
    public static final int a(int r100) {
        if (r100 != 3) goto L5;
        return 1;
    L5:
        if (r100 == 4) goto L9;
        return 2;
    L9:
        return 4;
    }

    public static final int c(int r100, int r101) {
        if (r100 != 4) goto L5;
        return 1;
    L5:
        if (r100 != 12) goto L11;
        return 2;
    L11:
        return r101;
    }

    public static int b(int r100, int r101) {
        int r102 = a(r100);
        if (r101 == 12) goto L5;
        int r103 = 1;
    L7:
        return r102 * r103;
    L5:
        r103 = 2;
        goto L7
    }
}
