package qqa;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f534502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f534503b = null;

    static {
        Class r100 = Integer.TYPE;
        Class r101 = Long.TYPE;
        Class r102 = Float.TYPE;
        f534502a = new HashMap();
        HashMap r103 = new HashMap();
        f534503b = r103;
        r103.put(Boolean.TYPE, Boolean.class);
        r103.put(Byte.TYPE, Byte.class);
        r103.put(Character.TYPE, Character.class);
        r103.put(Short.TYPE, Short.class);
        r103.put(r100, Integer.class);
        r103.put(r101, Long.class);
        r103.put(Double.TYPE, Double.class);
        r103.put(r102, Float.class);
        Class r104 = Void.TYPE;
        r103.put(r104, r104);
        Iterator r105 = r103.keySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L10;
        Class<?> r106 = (Class) r105.next();
        Class<?> r107 = f534503b.get(r106);
        if (r107 == null) goto L4;
        if (r106.equals(r107) == true) goto L4;
        f534502a.put(r107, r106);
        goto L4
    }
}
