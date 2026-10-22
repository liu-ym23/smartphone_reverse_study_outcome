package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class z1 {
    protected static String LIBNAME;

    public z1() {
    }

    public static synchronized void a(Context r100, int r110, Map<String, String> r111) {
        monitor-enter(z1.class);
        int r101 = 0;
        n2.f515246f.f515172a.set(0);     // Catch: Throwable -> L26
        n2.b(r100, LIBNAME);     // Catch: Throwable -> L26
        ArrayList r102 = new ArrayList();     // Catch: Throwable -> L26
        if (r111 == null) goto L15;
        Iterator<Map.Entry<String, String>> r112 = r111.entrySet().iterator();     // Catch: Throwable -> L26
    L8:
        if (r112.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r112.next();     // Catch: Throwable -> L26
        String r104 = r103.getKey();     // Catch: Throwable -> L26
        String r105 = r103.getValue();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r104) == true) goto L8;
        if (TextUtils.isEmpty(r105) == true) goto L8;
        r102.add(r104);     // Catch: Throwable -> L26
        r102.add(r105);     // Catch: Throwable -> L26
        goto L8
    L14:
        String[] r106 = (String[]) r102.toArray(new String[0]);     // Catch: Throwable -> L26
    L16:
        String[] r107 = r106;
        j2 r108 = n2.f515246f;     // Catch: Throwable -> L26
        int r113 = (((byte) r110) & 15) << 28;     // Catch: Throwable -> L26
        int r114 = 0;
    L18:
        if (r101 >= r108.f515172a.size()) goto L23;
        if (r108.f515172a.get(r101) == false) goto L22;
        r114 = r114 | (1 << r101);     // Catch: Throwable -> L26
    L22:
        r101 = r101 + 1;     // Catch: Throwable -> L26
        goto L18
    L23:
        p2.a(83886081, r113 | r114, 0, null, r107);     // Catch: Throwable -> L26
        monitor-exit(z1.class);
        return;
    L15:
        r106 = null;
    L26:
        th = move-exception;
        throw th;
    }
}
