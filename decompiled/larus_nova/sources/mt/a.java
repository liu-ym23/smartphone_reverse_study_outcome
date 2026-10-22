package mt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {
    static {
    }

    public static int a(int r100) {
        if (r100 > 1) goto L6;
        return r100;
    L6:
        return a(r100 - 1) + a(r100 - 2);
    }
}
