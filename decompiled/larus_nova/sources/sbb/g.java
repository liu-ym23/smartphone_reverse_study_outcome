package sbb;

/* JADX INFO: loaded from: classes35.dex */
public final class g {
    public static boolean a(int r100) {
        if (r100 != 114) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b(int r100) {
        if (r100 != 113) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L8;
        return true;
    L8:
        if (a(r100) == true) goto L13;
        return false;
    L13:
        return true;
    L5:
        r101 = false;
        goto L6
    }
}
