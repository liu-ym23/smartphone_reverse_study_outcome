package rg2;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<Class, b<?>> f537688a;

    static {
        c r100 = new c();
        if (f537688a != null) goto L5;
        f537688a = new HashMap();
    L5:
        ((HashMap) f537688a).put(d.class, r100);
    }

    public static <T> T a(Class<T> r100) {
        Map<Class, b<?>> r101 = f537688a;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (((HashMap) r101).containsKey(r100) == false) goto L12;
        b r102 = (b) ((HashMap) f537688a).get(r100);
        if (r102 != null) goto L9;
        return null;
    L9:
        return (T) r102.getImpl();
    L12:
        return null;
    }
}
