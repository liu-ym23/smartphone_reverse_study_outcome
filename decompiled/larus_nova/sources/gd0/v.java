package gd0;

/* JADX INFO: loaded from: classes46.dex */
public final class v {
    public static boolean a(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static int b(int r100, int r101) {
        if (a(r100, r101) == true) goto L5;
        return r100;
    L5:
        return r100 ^ r101;
    }
}
