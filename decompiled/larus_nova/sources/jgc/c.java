package jgc;

/* JADX INFO: loaded from: classes38.dex */
public final class c {
    public static boolean a(Throwable r100) {
        String r101 = r100.toString();     // Catch: Throwable -> L4
    L7:
        if (f.a(r101) == false) goto L9;
    L11:
        return false;
    L9:
        if (r101.contains("ENOSPC") == false) goto L11;
        return true;
    L4:
        th = move-exception;
        th.printStackTrace();
        r101 = "throwable getMsg error";
        goto L7
    }
}
