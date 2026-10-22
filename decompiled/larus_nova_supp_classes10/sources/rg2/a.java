package rg2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static Map<Class, b<?>> a;

    static {
        c r1 = new c();
        if (a != null) goto L5;
        a = new HashMap();
    L5:
        ((HashMap) a).put(d.class, r1);
    }

    public static <T> T a(Class<T> r1) {
        Map<Class, b<?>> r0 = a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (((HashMap) r0).containsKey(r1) == false) goto L12;
        b r2 = (b) ((HashMap) a).get(r1);
        if (r2 != null) goto L9;
        return null;
    L9:
        return (T) r2.getImpl();
    L12:
        return null;
    }
}
