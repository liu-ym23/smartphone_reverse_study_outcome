package org.bouncycastle.util;

/* JADX INFO: loaded from: classes42.dex */
public class Objects {
    public Objects() {
    }

    public static boolean areEqual(Object r100, Object r101) {
        if (r100 == r101) goto L9;
        if (r100 == null) goto L8;
        if (r101 == null) goto L8;
        if (r100.equals(r101) == true) goto L9;
    L8:
        return false;
    L9:
        return true;
    }

    public static int hashCode(Object r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.hashCode();
    }
}
