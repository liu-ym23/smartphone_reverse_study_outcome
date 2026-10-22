package sob;

import java.lang.reflect.Method;
import java.util.Iterator;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f542817a = 0;

    static {
    }

    public static Method a(Class r100, Object[] r101) {
        Iterator r102 = ArrayIteratorKt.iterator(r100.getDeclaredMethods());
    L4:
        if (r102.hasNext() == false) goto L28;
        Method r103 = (Method) r102.next();
        if (Intrinsics.areEqual(r103.getName(), "forceToEnd") == false) goto L4;
        Class<?>[] r104 = r103.getParameterTypes();
        boolean r105 = false;
        if (r104 == null) goto L24;
        if (r104.length == 0) goto L24;
        if (r104.length != r101.length) goto L26;
        int r106 = r104.length;
        int r107 = 0;
    L16:
        if (r107 >= r106) goto L25;
        Object r108 = r101[r107];
        if (r108 == null) goto L22;
        if (r104[r107].isAssignableFrom(r108.getClass()) == false) goto L26;
    L22:
        r107 = r107 + 1;
    L25:
        r105 = true;
    L26:
        if (r105 == false) goto L4;
        return r103;
    L24:
        if (r101.length != 0) goto L26;
    L28:
        Class r109 = r100.getSuperclass();
        if (r109 != null) goto L43;
        return null;
    L43:
        return a(r109, r101);
    }
}
