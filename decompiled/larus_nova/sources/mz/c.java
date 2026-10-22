package mz;

/* JADX INFO: loaded from: classes45.dex */
public final class c {
    public static boolean b(String r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.length() == 0) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean a(String r100, String r101) {
        if (b(r100) == true) goto L5;
    L6:
        if (r100 != null) goto L8;
    L10:
        return false;
    L8:
        if (r100.equals(r101) == false) goto L10;
    L9:
        return true;
    L5:
        if (b(r101) == true) goto L9;
        goto L6
    }
}
