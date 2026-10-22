package i84;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f488642a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f488643b = null;

    static {
        f488642a = new t();
        f488643b = new ConcurrentHashMap();
    }

    public static Object a(String r100) throws IllegalArgumentException {
        ConcurrentHashMap r101 = (ConcurrentHashMap) f488643b;
        Object r102 = r101.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        f488642a.getClass();
        String r103 = t.b(r100);
        if (r103 == null) goto L8;
        r101.put(r100, r103);
    L8:
        return r103;
    }
}
