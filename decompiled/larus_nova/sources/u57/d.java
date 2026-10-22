package u57;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Method> f548876a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap<Class<?>, Class<?>> f548877b = null;

    static {
        f548876a = new HashMap();
        HashMap<Class<?>, Class<?>> r100 = new HashMap();
        f548877b = r100;
        r100.put(Boolean.TYPE, Boolean.class);
        r100.put(Byte.TYPE, Byte.class);
        r100.put(Character.TYPE, Character.class);
        r100.put(Short.TYPE, Short.class);
        r100.put(Integer.TYPE, Integer.class);
        r100.put(Long.TYPE, Long.class);
        r100.put(Double.TYPE, Double.class);
        r100.put(Float.TYPE, Float.class);
        r100.put(Void.TYPE, Void.class);
    }

    public static Object b(Class r100, Object... r101) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object[] r102 = b.f548873a;
        if (r101.length != 0) goto L7;
        r101 = b.f548873a;
    L7:
        if (r101.length == 0) goto L16;
        Class<?>[] r103 = new Class[r101.length];
        int r104 = 0;
    L10:
        if (r104 >= r101.length) goto L17;
        Object r105 = r101[r104];
        if (r105 != null) goto L14;
        Class<?> r106 = null;
    L15:
        r103[r104] = r106;
        r104 = r104 + 1;
        goto L10
    L14:
        r106 = r105.getClass();
    L17:
        Object[] r107 = b.f548873a;
        if (r103.length != 0) goto L22;
        r103 = b.f548874b;
    L22:
        if (r101.length != 0) goto L25;
        r101 = b.f548873a;
    L25:
        Method r108 = a(r100, "currentActivityThread", r103);
        if (r108 != null) goto L28;
        return null;
    L28:
        return r108.invoke(null, r101);
    L16:
        r103 = b.f548874b;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Method a(Class<?> r110, String r111, Class... r112) {
        if (r110 == null) goto L91;
        if ((!TextUtils.isEmpty(r111)) == false) goto L89;
        StringBuilder r100 = new StringBuilder();
        r100.append(r110.toString());
        r100.append("#");
        r100.append(r111);
        if (r112 != null) goto L9;
    L13:
        r100.append(Void.class.toString());
    L14:
        String r101 = r100.toString();
        Map<String, Method> r102 = f548876a;
        monitor-enter(r102);
        Method r103 = (Method) ((HashMap) r102).get(r101);     // Catch: Throwable -> L85
        monitor-exit(r102);     // Catch: Throwable -> L85
        if (r103 != null) goto L20;
        Method r104 = r103;
        Class<?> r105 = r110;
    L24:
        if (r105 == null) goto L83;
        if (e.a() == false) goto L32;
        p57.f r106 = c.f548875a;     // Catch: NoSuchMethodException -> L34
        if (r106 == null) goto L32;
        r104 = r106.a(r105, r111, r112);     // Catch: NoSuchMethodException -> L34
        if (r104 != null) goto L35;
        r104 = r105.getDeclaredMethod(r111, r112);     // Catch: NoSuchMethodException -> L34
    L32:
        r104 = r105.getDeclaredMethod(r111, r112);     // Catch: NoSuchMethodException -> L34
    L35:
        if (r104 != null) goto L73;
        Method[] r107 = r105.getDeclaredMethods();
        if (r107 == null) goto L73;
        int r108 = r107.length;
        int r109 = 0;
    L39:
        if (r109 >= r108) goto L73;
        Method r113 = r107[r109];
        if (r113 == null) goto L72;
        if (TextUtils.equals(r113.getName(), r111) == false) goto L72;
        Class<?>[] r114 = r113.getParameterTypes();
        if (r112 == null) goto L72;
        if (r112.length != r114.length) goto L72;
        int r115 = 0;
        boolean r116 = true;
    L50:
        if (r115 >= r112.length) goto L70;
        Class r117 = r112[r115];
        Class<?> r118 = r114[r115];
        if (r118 != null) goto L54;
        boolean r119 = false;
    L67:
        if (r119 == true) goto L69;
        r116 = false;
    L69:
        r115 = r115 + 1;
        goto L50
    L54:
        if (r117 != null) goto L57;
        r119 = !r118.isPrimitive();
        goto L67
    L57:
        if (r117.isPrimitive() == true) goto L59;
    L61:
        boolean r120 = r118.isPrimitive();
        Class r121 = r118;
        if (r120 == false) goto L66;
        r121 = r118;
        if (r117.isPrimitive() == true) goto L66;
        r121 = f548877b.get(r118);
    L66:
        r119 = r121.isAssignableFrom(r117);
        goto L67
    L59:
        if (r118.isPrimitive() == true) goto L61;
        r117 = (Class) f548877b.get(r117);
        goto L61
    L70:
        if (r116 == false) goto L72;
        r104 = r113;
    L72:
        r109 = r109 + 1;
    L73:
        if (r104 != null) goto L74;
        r105 = r105.getSuperclass();
        goto L24
    L74:
        r104.setAccessible(true);
        Map<String, Method> r122 = f548876a;
        monitor-enter(r122);
        ((HashMap) r122).put(r101, r104);     // Catch: Throwable -> L79
        monitor-exit(r122);     // Catch: Throwable -> L79
        return r104;
    L79:
        th = move-exception;
        throw th;
    L83:
        return null;
    L20:
        if (r103.isAccessible() == true) goto L22;
        r103.setAccessible(true);
    L22:
        return r103;
    L85:
        th = move-exception;
        throw th;
    L9:
        if (r112.length <= 0) goto L13;
        int r123 = r112.length;
        int r124 = 0;
    L11:
        if (r124 >= r123) goto L14;
        r100.append(r112[r124].toString());
        r100.append("#");
        r124 = r124 + 1;
        goto L11
    L89:
        throw new IllegalArgumentException("The method name must not be blank");
    L91:
        throw new IllegalArgumentException("The class must not be null");
    }
}
