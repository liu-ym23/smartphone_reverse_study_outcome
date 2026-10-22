package n4a;

import android.content.Context;
import java.io.InputStream;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public final class t0 {
    public static n0 a() {
        return (n0) new WeakReference(new n0()).get();
    }

    public static void b(Context r100, n0 r101, String r102, int r103, int r104, String r105) {
        r101.f517545a = p.c(r100, r102);
        r101.f517548d = r103;
        r101.f517546b = r104;
        r101.f517547c = r105;
    }

    public static byte[] c(h0 r100, String r101) {
        byte[] r102 = new byte[0];
        InputStream r103 = null;
        h0.e r104 = r100.a(r101);     // Catch: Throwable -> L37
        if (r104 != null) goto L65;
        if (r104 != null) goto L73;
    L36:
        return r102;
    L73:
        r104.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.printStackTrace();
        goto L36
    L65:
        InputStream r105 = r104.f517333a[0];     // Catch: Throwable -> L29
        if (r105 != null) goto L83;
        if (r105 == null) goto L87;
        r105.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
    L87:
        r104.close();     // Catch: Throwable -> L14
    L16:
        return r102;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    L83:
        r102 = new byte[r105.available()];     // Catch: Throwable -> L27
        r105.read(r102);     // Catch: Throwable -> L27
        r105.close();     // Catch: Throwable -> L20
    L75:
        r104.close();     // Catch: Throwable -> L24
    L26:
        return r102;
    L24:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = move-exception;
        th.printStackTrace();
    L27:
        th = th;
        r103 = r105;
    L77:
        r.f(th, "sui", "rdS");     // Catch: Throwable -> L51
        if (r103 != null) goto L81;
    L45:
        if (r104 != null) goto L71;
    L50:
        return r102;
    L71:
        r104.close();     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();
        goto L50
    L81:
        r103.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.printStackTrace();
    L51:
        th = move-exception;
        if (r103 != null) goto L67;
    L57:
        if (r104 == null) goto L89;
        r104.close();     // Catch: Throwable -> L60
        throw th;
    L60:
        th = move-exception;
        th.printStackTrace();
        throw th;
    L89:
        throw th;
    L67:
        r103.close();     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        th.printStackTrace();
    L29:
        th = th;
    L37:
        th = th;
        r104 = null;
        goto L77
    }
}
