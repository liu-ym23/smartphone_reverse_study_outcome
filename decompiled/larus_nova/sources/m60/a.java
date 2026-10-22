package m60;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    public static <T> int a(T... r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        int r101 = r100.length;
        int r102 = 1;
        int r103 = 0;
    L6:
        if (r103 >= r101) goto L12;
        T r104 = r100[r103];
        if (r104 != null) goto L10;
        int r105 = 0;
    L11:
        r102 = ((r102 << 5) - r102) ^ r105;
        r103 = r103 + 1;
        goto L6
    L10:
        r105 = r104.hashCode();
        goto L11
    L12:
        return r102;
    }
}
