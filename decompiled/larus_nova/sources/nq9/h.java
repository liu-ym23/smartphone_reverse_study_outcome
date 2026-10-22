package nq9;

/* JADX INFO: loaded from: classes31.dex */
public final class h {
    public static final boolean a(Integer r100, Integer r101) {
        if (r100 != null) goto L5;
    L16:
        return false;
    L5:
        if (r100.intValue() != 2) goto L16;
        if (r101 != null) goto L10;
    L11:
        if (r101 != null) goto L14;
        return true;
    L14:
        if (r101.intValue() == 4) goto L16;
        return true;
    L10:
        if (r101.intValue() == 1) goto L16;
        goto L11
    }
}
