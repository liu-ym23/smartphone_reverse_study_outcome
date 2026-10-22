package z82;

/* JADX INFO: loaded from: classes9.dex */
public final class h {
    public static final Integer a(int r100, Float r101) {
        if (r101 != null) goto L4;
        return null;
    L4:
        if (r101.floatValue() <= 0.0f) goto L11;
        if (r100 != 0) goto L8;
        return null;
    L8:
        return Integer.valueOf((int) (r100 / r101.floatValue()));
    L11:
        return null;
    }

    public static final Integer b(int r100, Float r101) {
        if (r101 != null) goto L4;
        return null;
    L4:
        if (r101.floatValue() <= 0.0f) goto L11;
        if (r100 != 0) goto L8;
        return null;
    L8:
        return Integer.valueOf((int) (r100 * r101.floatValue()));
    L11:
        return null;
    }
}
