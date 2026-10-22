package c04;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static final Map<Integer, Map<Integer, f>> a = null;

    static {
        a = new LinkedHashMap();
    }

    public static f a(int r4, int r5) {
        Map<Integer, Map<Integer, f>> r0 = a;
        LinkedHashMap r2 = (LinkedHashMap) r0;
        if (((Map) r2.get(Integer.valueOf(r4))) != null) goto L5;
        r0.put(Integer.valueOf(r4), new LinkedHashMap());
    L5:
        Map r1 = (Map) r2.get(Integer.valueOf(r4));
        if (r1 == null) goto L8;
        f r3 = (f) r1.get(Integer.valueOf(r5));
    L9:
        if (r3 != null) goto L13;
        r3 = new f();
        Map r6 = (Map) r2.get(Integer.valueOf(r4));
        if (r6 == null) goto L13;
        f r7 = (f) r6.put(Integer.valueOf(r5), r3);
    L13:
        return r3;
    L8:
        r3 = null;
        goto L9
    }
}
