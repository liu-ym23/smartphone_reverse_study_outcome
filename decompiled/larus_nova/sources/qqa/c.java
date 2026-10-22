package qqa;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Method> f534504a = null;

    static {
        f534504a = new HashMap();
    }

    public static Method b(Class r100, Class... r101) throws NoSuchMethodException {
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.toString());
        r102.append("#getLifecycleStateRequest");
        boolean r103 = false;
        if (r101.length <= 0) goto L7;
        int r104 = r101.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L8;
        r102.append(r101[r105].toString());
        r102.append("#");
        r105 = r105 + 1;
    L8:
        String r106 = r102.toString();
        Map<String, Method> r107 = f534504a;
        monitor-enter(r107);
        Method r108 = (Method) ((HashMap) r107).get(r106);     // Catch: Throwable -> L50
        monitor-exit(r107);     // Catch: Throwable -> L50
        if (r108 != null) goto L15;
        Method r109 = r100.getMethod("getLifecycleStateRequest", r101);
        Map<Class<?>, Class<?>> r110 = b.f534502a;
        if (r109 != null) goto L21;
    L25:
        if (r103 == false) goto L39;
        Class<?> r111 = r109.getDeclaringClass();
        if (Modifier.isPublic(r111.getModifiers()) == true) goto L41;
        String r112 = r109.getName();
        Class<?>[] r113 = r109.getParameterTypes();
        Method r114 = a(r111, r112, r113);
        if (r114 != null) goto L40;
        Class<? super Object> r115 = r111.getSuperclass();
    L33:
        if (r115 == null) goto L39;
        if (Modifier.isPublic(r115.getModifiers()) == true) goto L56;
        r115 = r115.getSuperclass();
        goto L33
    L56:
        r109 = r115.getMethod(r112, r113);     // Catch: Throwable -> L53
    L40:
        r109 = r114;
    L41:
        Map<String, Method> r116 = f534504a;
        monitor-enter(r116);
        if (r109 != null) goto L54;
    L45:
        monitor-exit(r116);     // Catch: Throwable -> L47
        return r109;
    L47:
        th = move-exception;
        throw th;
    L54:
        ((HashMap) r116).put(r106, r109);     // Catch: Throwable -> L47
    L39:
        r109 = null;
        goto L41
    L21:
        if (Modifier.isPublic(r109.getModifiers()) == false) goto L25;
        if (r109.isSynthetic() == true) goto L25;
        r103 = true;
        goto L25
    L15:
        if (r108.isAccessible() == true) goto L17;
        r108.setAccessible(true);
    L17:
        return r108;
    L50:
        th = move-exception;
        throw th;
    L7:
        r102.append(Void.class.toString());
        goto L8
    }

    public static Method a(Class<?> r100, String r101, Class<?>... r102) {
    L2:
        if (r100 == null) goto L15;
        Class<?>[] r103 = r100.getInterfaces();
        int r104 = r103.length;
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L14;
        if (Modifier.isPublic(r103[r105].getModifiers()) == false) goto L13;
        return r103[r105].getDeclaredMethod(r101, r102);
    L10:
        Method r106 = a(r103[r105], r101, r102);
        if (r106 == null) goto L13;
        return r106;
    L13:
        r105 = r105 + 1;
        goto L4
    L14:
        r100 = r100.getSuperclass();
        goto L2
    L15:
        return null;
    }
}
