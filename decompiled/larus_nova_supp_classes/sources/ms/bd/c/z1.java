package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class z1 {
    protected static String LIBNAME;

    public z1() {
    }

    public static synchronized void a(Context r9, int r10, Map<String, String> r11) {
        monitor-enter(z1.class);
        int r2 = 0;
        n2.f.a.set(0);     // Catch: Throwable -> L26
        n2.b(r9, LIBNAME);     // Catch: Throwable -> L26
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L26
        if (r11 == null) goto L15;
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();     // Catch: Throwable -> L26
    L8:
        if (r13.hasNext() == false) goto L14;
        Map.Entry<String, String> r1 = r13.next();     // Catch: Throwable -> L26
        String r3 = r1.getKey();     // Catch: Throwable -> L26
        String r4 = r1.getValue();     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r3) == true) goto L8;
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r12.add(r3);     // Catch: Throwable -> L26
        r12.add(r4);     // Catch: Throwable -> L26
        goto L8
    L14:
        String[] r14 = (String[]) r12.toArray(new String[0]);     // Catch: Throwable -> L26
    L16:
        String[] r8 = r14;
        j2 r15 = n2.f;     // Catch: Throwable -> L26
        int r16 = (((byte) r10) & 15) << 28;     // Catch: Throwable -> L26
        int r17 = 0;
    L18:
        if (r2 >= r15.a.size()) goto L23;
        if (r15.a.get(r2) == false) goto L22;
        r17 = r17 | (1 << r2);     // Catch: Throwable -> L26
    L22:
        r2 = r2 + 1;     // Catch: Throwable -> L26
        goto L18
    L23:
        p2.a(83886081, r16 | r17, 0, null, r8);     // Catch: Throwable -> L26
        monitor-exit(z1.class);
        return;
    L15:
        r14 = null;
    L26:
        th = move-exception;
        throw th;
    }
}
