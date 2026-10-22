package d27;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Method> f466544a = null;

    static {
        f466544a = new HashMap();
    }

    public static Method c(String r100) {
        Map<String, Method> r101 = f466544a;
        monitor-enter(r101);
        Method r102 = (Method) ((HashMap) r101).get(r100);     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        if (r102 != null) goto L8;
        return null;
    L8:
        if (r102.isAccessible() == true) goto L10;
        r102.setAccessible(true);
    L10:
        return r102;
    L15:
        th = move-exception;
        throw th;
    }

    public static Object d(Class r100, Object... r101) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (r101.length <= 0) goto L5;
        Object[] r102 = r101;
    L6:
        int r103 = 0;
        if (r101.length != 0) goto L9;
        Class<?>[] r104 = c.f466539a;
    L18:
        StringBuilder r105 = new StringBuilder();
        r105.append(r100.toString());
        r105.append("#currentActivityThread");
        if (r104.length <= 0) goto L23;
        int r106 = r104.length;
    L21:
        if (r103 >= r106) goto L24;
        r105.append(r104[r103].toString());
        r105.append("#");
        r103 = r103 + 1;
    L24:
        String r107 = r105.toString();
        Method r108 = c(r107);
        if (r108 == null) goto L45;
    L36:
        if (r108 == null) goto L44;
        if (r102.length > 0) goto L42;
        r102 = c.f466540b;
    L42:
        return r108.invoke(null, r102);
    L44:
        throw new NoSuchMethodException("No such accessible method: currentActivityThread() on object: ".concat(r100.getName()));
    L45:
        r108 = r100.getMethod("currentActivityThread", r104);     // Catch: NoSuchMethodException -> L35
        e.c(r108);     // Catch: NoSuchMethodException -> L35
        Map<String, Method> r109 = f466544a;     // Catch: NoSuchMethodException -> L35
        monitor-enter(r109);     // Catch: NoSuchMethodException -> L35
        ((HashMap) r109).put(r107, r108);     // Catch: Throwable -> L32
        monitor-exit(r109);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: NoSuchMethodException -> L35
    L35:
        r108 = b(r100, r107, r104);
        goto L36
    L23:
        r105.append(Void.class.toString());
        goto L24
    L9:
        Class<?>[] r110 = new Class[r101.length];
        int r111 = 0;
    L11:
        if (r111 >= r101.length) goto L17;
        Object r112 = r101[r111];
        if (r112 != null) goto L15;
        Class<?> r113 = null;
    L16:
        r110[r111] = r113;
        r111 = r111 + 1;
        goto L11
    L15:
        r113 = r112.getClass();
        goto L16
    L17:
        r104 = r110;
        goto L18
    L5:
        r102 = c.f466540b;
        goto L6
    }

    public static Method a(Class<?> r100, String r101, Class<?>... r102) {
    L2:
        if (r100 == null) goto L16;
        Class<?>[] r103 = r100.getInterfaces();
        int r104 = 0;
    L5:
        if (r104 >= r103.length) goto L15;
        if (Modifier.isPublic(r103[r104].getModifiers()) == false) goto L14;
        return r103[r104].getDeclaredMethod(r101, r102);
    L11:
        Method r105 = a(r103[r104], r101, r102);
        if (r105 == null) goto L14;
        return r105;
    L14:
        r104 = r104 + 1;
        goto L5
    L15:
        r100 = r100.getSuperclass();
        goto L2
    L16:
        return null;
    }

    public static Method b(Class r110, String r111, Class... r112) {
        Method[] r113 = r110.getMethods();
        int r100 = r113.length;
        Method r101 = null;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L73;
        Method r103 = r113[r102];
        if (r103.getName().equals("currentActivityThread") == false) goto L72;
        Class<?>[] r104 = r103.getParameterTypes();
        Class<?>[] r105 = e.f466541a;
        byte r106 = 1;
        if (r112 != null) goto L11;
        if (r104 == null) goto L11;
        if (r104.length <= 0) goto L11;
    L19:
        boolean r107 = false;
    L21:
        if (r107 == false) goto L34;
        Class<?>[] r108 = c.f466539a;
        if (r112 != null) goto L26;
        Class[] r114 = r108;
    L27:
        if (r104 != null) goto L29;
        r104 = r108;
    L29:
        int r109 = 0;
    L31:
        if (r109 >= r114.length) goto L36;
        if (e.b(r114[r109], r104[r109]) == false) goto L34;
        r109 = r109 + 1;
        goto L31
    L36:
        boolean r115 = true;
    L37:
        if (r115 == false) goto L72;
        Class<?>[] r116 = e.f466541a;
        if (Modifier.isPublic(r103.getModifiers()) == true) goto L41;
    L43:
        boolean r117 = false;
    L44:
        if (r117 == false) goto L59;
        Class<?> r118 = r103.getDeclaringClass();
        if (Modifier.isPublic(r118.getModifiers()) == true) goto L61;
        String r119 = r103.getName();
        Class<?>[] r120 = r103.getParameterTypes();
        Method r121 = a(r118, r119, r120);
        if (r121 != null) goto L60;
        Class<? super Object> r122 = r118.getSuperclass();
    L52:
        if (r122 == null) goto L59;
        if (Modifier.isPublic(r122.getModifiers()) == true) goto L85;
        r122 = r122.getSuperclass();
        goto L52
    L85:
        r103 = r122.getMethod(r119, r120);     // Catch: Exception -> L57
    L60:
        r103 = r121;
    L61:
        if (r103 == null) goto L72;
        if (r101 == null) goto L71;
        Class<?>[] r123 = r103.getParameterTypes();
        Class<?>[] r124 = r101.getParameterTypes();
        float r125 = e.a(r112, r123);
        float r126 = e.a(r112, r124);
        if (r125 >= r126) goto L67;
        r106 = -1;
    L70:
        if (r106 >= 0) goto L72;
    L67:
        if (r126 < r125) goto L70;
        r106 = 0;
    L71:
        r101 = r103;
    L59:
        r103 = null;
        goto L61
    L41:
        if (r103.isSynthetic() == true) goto L43;
        r117 = true;
        goto L44
    L26:
        r114 = r112;
    L34:
        r115 = false;
    L11:
        if (r104 != null) goto L15;
        if (r112 == null) goto L15;
        if (r112.length > 0) goto L19;
    L15:
        if (r112 == null) goto L20;
        if (r104 == null) goto L20;
        if (r112.length != r104.length) goto L19;
    L20:
        r107 = true;
    L72:
        r102 = r102 + 1;
        goto L3
    L73:
        if (r101 == null) goto L75;
        e.c(r101);
    L75:
        Map<String, Method> r127 = f466544a;
        monitor-enter(r127);
        ((HashMap) r127).put(r111, r101);     // Catch: Throwable -> L80
        monitor-exit(r127);     // Catch: Throwable -> L80
        return r101;
    L80:
        th = move-exception;
        throw th;
    }
}
