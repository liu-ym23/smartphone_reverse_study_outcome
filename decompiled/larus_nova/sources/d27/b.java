package d27;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Field> f466538a = null;

    static {
        f466538a = new HashMap();
    }

    public static Field a(Class<?> r100, String r101) {
        String r102 = r100.toString() + "#" + r101;
        Map<String, Field> r103 = f466538a;
        monitor-enter(r103);
        Field r104 = (Field) ((HashMap) r103).get(r102);     // Catch: Throwable -> L27
        monitor-exit(r103);     // Catch: Throwable -> L27
        if (r104 != null) goto L9;
    L12:
        if (r100 == null) goto L25;
        Field r105 = r100.getDeclaredField(r101);     // Catch: NoSuchFieldException -> L24
        if (r105.isAccessible() == true) goto L16;
        r105.setAccessible(true);     // Catch: NoSuchFieldException -> L24
    L16:
        Map<String, Field> r106 = f466538a;     // Catch: NoSuchFieldException -> L24
        monitor-enter(r106);     // Catch: NoSuchFieldException -> L24
        ((HashMap) r106).put(r102, r105);     // Catch: Throwable -> L21
        monitor-exit(r106);     // Catch: Throwable -> L21
    L20:
        return r105;
    L21:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L24
    L24:
        r100 = r100.getSuperclass();
        goto L12
    L25:
        return null;
    L9:
        if (r104.isAccessible() == true) goto L11;
        r104.setAccessible(true);
    L11:
        return r104;
    L27:
        th = move-exception;
        throw th;
    }

    public static Object b(Object r100, String r101) throws IllegalAccessException {
        Field r102 = a(r100.getClass(), r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r102.isAccessible() == true) goto L10;
        r102.setAccessible(true);
    L10:
        return r102.get(r100);
    }

    public static void c(Object r100, String r101, Object r102) throws IllegalAccessException {
        Field r103 = a(r100.getClass(), r101);
        if (r103 != null) goto L5;
        return;
    L5:
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);
    L7:
        r103.set(r100, r102);
    }
}
