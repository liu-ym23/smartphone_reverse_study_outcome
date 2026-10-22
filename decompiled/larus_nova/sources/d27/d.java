package d27;

import java.io.Closeable;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static void a(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void b(String r100) {
        int r101 = 0;
        Object[] r102 = {r100, 493, -1, -1};
        Class r103 = e27.a.a();     // Catch: Exception -> L13
        Class[] r104 = new Class[4];     // Catch: Exception -> L13
    L4:
        Class<?> r105 = null;
        if (r101 >= 4) goto L11;
        Object r106 = r102[r101];     // Catch: Exception -> L13
        if (r106 == null) goto L10;
        r105 = r106.getClass();     // Catch: Exception -> L13
    L10:
        r104[r101] = r105;     // Catch: Exception -> L13
        r101 = r101 + 1;     // Catch: Exception -> L13
        goto L4
    L11:
        e27.a.b(r103, r104).invoke(null, r102);     // Catch: Exception -> L13
        return;
    }
}
