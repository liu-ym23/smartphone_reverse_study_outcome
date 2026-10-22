package mqc;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    public static <T> boolean a(T[] r100, T[] r101) {
        if (r101 != null) goto L5;
        return true;
    L5:
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L27;
        Object r104 = r101[r103];
        if (r100 == null) goto L20;
        int r105 = 0;
    L12:
        if (r105 >= r100.length) goto L20;
        T r106 = r100[r105];
        if (r106 == r104) goto L21;
        if (r106 == null) goto L19;
        if (r106.equals(r104) == true) goto L21;
    L19:
        r105 = r105 + 1;
    L21:
        if (r105 == (-1)) goto L23;
        boolean r107 = true;
    L24:
        if (r107 == false) goto L25;
        r103 = r103 + 1;
        goto L6
    L25:
        return false;
    L23:
        r107 = false;
    L20:
        r105 = -1;
        goto L21
    L27:
        return true;
    }
}
