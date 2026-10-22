package n4a;

import android.content.Context;
import android.os.Looper;
import java.util.Vector;

/* JADX INFO: loaded from: classes32.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f517578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Vector<e5> f517579b = null;

    static {
        f517579b = new Vector();
    }

    public static void a(e5 r100) {
        Looper r101 = Looper.getMainLooper();     // Catch: Throwable -> L17
        monitor-enter(r101);     // Catch: Throwable -> L17
        if (r100 != null) goto L7;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L7:
        Vector<e5> r102 = f517579b;     // Catch: Throwable -> L14
        if (r102.contains(r100) == false) goto L11;
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L11:
        r102.add(r100);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    }

    public static boolean b(String[] r100, String r101) {
        if (r101 != null) goto L21;
    L20:
        return false;
    L21:
        int r102 = r100.length;     // Catch: Throwable -> L18
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L20;
        String r104 = r100[r103];     // Catch: Throwable -> L18
        r101 = r101.trim();     // Catch: Throwable -> L18
        if (r101.startsWith("at ") == false) goto L17;
        if (r101.contains(r104 + ".") == false) goto L17;
        if (r101.endsWith(")") == false) goto L17;
        if (r101.contains("uncaughtException") == true) goto L17;
        return true;
    L17:
        r103 = r103 + 1;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    }

    public static String c(Context r100, String r101) {
        return r100.getFilesDir().getAbsolutePath() + "/a/" + r101;
    }
}
