package ow7;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static boolean a(String r100, String r101) {
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        return true;
    L6:
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        return r100.equals(r101);
    L12:
        if (r100 != null) goto L19;
        if (r101.trim().length() == 0) goto L23;
        return false;
    L23:
        return true;
    L19:
        if (r100.trim().length() == 0) goto L24;
        return false;
    L24:
        return true;
    }
}
