package qqa;

import java.util.HashSet;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f534505a = null;

    static {
        f534505a = new Object[0];
    }

    public static void a(Class<?> r100, HashSet<Class<?>> r101) {
    L2:
        if (r100 == null) goto L10;
        Class<?>[] r102 = r100.getInterfaces();
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        Class<?> r105 = r102[r104];
        if (r101.add(r105) == false) goto L8;
        a(r105, r101);
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        r100 = r100.getSuperclass();
        goto L2
    }
}
