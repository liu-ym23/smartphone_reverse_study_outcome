package com.bytedance.push.utils;

import com.bytedance.common.utility.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Method f267052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Method f267053b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f267054c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Method> f267055d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Class<?>[] f267056e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f267057f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f267058g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Class<?>[] f267059h = null;

    static {
        f267055d = new HashMap();
        f267056e = new Class[0];
        HashMap r100 = new HashMap();
        f267057f = r100;
        f267058g = new HashMap();
        Class<?> r101 = Integer.TYPE;
        Class<?> r102 = Long.TYPE;
        Class<?> r103 = Float.TYPE;
        f267059h = new Class[]{Byte.TYPE, Short.TYPE, Character.TYPE, r101, r102, r103, Double.TYPE};
        f267052a = Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class});     // Catch: Throwable -> L10
        f267053b = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class});     // Catch: Throwable -> L10
        f267054c = Class.class.getDeclaredMethod("getDeclaredMethods", new Class[0]);     // Catch: Throwable -> L10
        Class.class.getDeclaredMethod("getDeclaredConstructor", new Class[]{Class[].class});     // Catch: Throwable -> L10
        Class.class.getDeclaredMethod("forName", new Class[]{String.class});     // Catch: Throwable -> L10
        r100.put(Boolean.TYPE, Boolean.class);     // Catch: Throwable -> L10
        r100.put(Byte.TYPE, Byte.class);     // Catch: Throwable -> L10
        r100.put(Character.TYPE, Character.class);     // Catch: Throwable -> L10
        r100.put(Short.TYPE, Short.class);     // Catch: Throwable -> L10
        r100.put(r101, Integer.class);     // Catch: Throwable -> L10
        r100.put(r102, Long.class);     // Catch: Throwable -> L10
        r100.put(Double.TYPE, Double.class);     // Catch: Throwable -> L10
        r100.put(r103, Float.class);     // Catch: Throwable -> L10
        Class r104 = Void.TYPE;     // Catch: Throwable -> L10
        r100.put(r104, r104);     // Catch: Throwable -> L10
        Iterator r105 = r100.entrySet().iterator();     // Catch: Throwable -> L10
    L5:
        if (r105.hasNext() == false) goto L20;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L10
        Class<?> r107 = (Class) r106.getKey();     // Catch: Throwable -> L10
        Class<?> r108 = (Class) r106.getValue();     // Catch: Throwable -> L10
        if (r107.equals(r108) == true) goto L5;
        f267058g.put(r108, r107);     // Catch: Throwable -> L10
        goto L5
    L20:
        return;
    L10:
        th = move-exception;
        Logger.e("DoubleReflector", "DoubleReflectorinit failed", th);
    }

    public static String g(Class<?>... r100) {
        StringBuilder r101 = new StringBuilder("(");
        int r102 = r100.length;
        boolean r103 = true;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L12;
        Class<?> r105 = r100[r104];
        if (r103 == false) goto L7;
        r103 = false;
    L8:
        if (r105 == null) goto L10;
        r101.append(r105.getCanonicalName());
    L11:
        r104 = r104 + 1;
        goto L3
    L10:
        r101.append("null");
        goto L11
    L7:
        r101.append(",");
        goto L8
    L12:
        r101.append(")");
        return r101.toString();
    }

    public static Method a(Class r110, Object... r111) {
        Class[] r100 = new Class[r111.length];
        int r101 = 0;
    L3:
        Class<?> r102 = null;
        if (r101 >= r111.length) goto L9;
        Object r103 = r111[r101];
        if (r103 == null) goto L8;
        r102 = r103.getClass();
    L8:
        r100[r101] = r102;
        r101 = r101 + 1;
        goto L3
    L9:
        String r112 = r110.getName() + "#enqueueNotificationWithTag" + g(r100) + "#best";
        HashMap<String, Method> r104 = f267055d;
        if (r104.containsKey(r112) == false) goto L16;
        Method r105 = r104.get(r112);
        if (r105 == null) goto L15;
    L17:
        if (r105 == null) goto L79;
    L73:
        return r105;
    L79:
        r105 = b(r110, r100);     // Catch: NoSuchMethodError -> L21
        r104.put(r112, r105);     // Catch: NoSuchMethodError -> L21
    L22:
        if (r105 != null) goto L73;
        r105 = null;
        boolean r106 = true;
    L25:
        Method r107 = f267054c;
        if (r107 != null) goto L77;
    L31:
        Method[] r108 = null;
    L32:
        int r109 = r108.length;
        int r113 = 0;
    L33:
        if (r113 >= r109) goto L69;
        Method r114 = r108[r113];
        if (r106 == true) goto L40;
        if (Modifier.isPrivate(r114.getModifiers()) == false) goto L40;
    L68:
        r113 = r113 + 1;
    L40:
        if (r114.getName().equals("enqueueNotificationWithTag") == false) goto L68;
        Class<?>[] r115 = r114.getParameterTypes();
        if (r115 == null) goto L44;
    L45:
        if (r115 != null) goto L47;
    L50:
        boolean r116 = true;
    L51:
        if (r116 == false) goto L60;
        if (r115 != null) goto L55;
        r115 = f267056e;
    L55:
        int r117 = 0;
    L57:
        if (r117 >= r100.length) goto L62;
        if (i(r100[r117], r115[r117]) == false) goto L60;
        r117 = r117 + 1;
        goto L57
    L62:
        boolean r118 = true;
    L63:
        if (r118 == false) goto L68;
        if (r105 != null) goto L66;
    L67:
        r105 = r114;
        goto L68
    L66:
        if (Float.compare(h(r100, r114.getParameterTypes()), h(r100, r105.getParameterTypes())) >= 0) goto L68;
    L60:
        r118 = false;
        goto L63
    L47:
        if (r100.length == r115.length) goto L50;
    L49:
        r116 = false;
        goto L51
    L44:
        if (r100.length > 0) goto L49;
    L69:
        r110 = r110.getSuperclass();
        if (r110 == null) goto L71;
        r106 = false;
        goto L25
    L71:
        if (r105 == null) goto L74;
        r105.setAccessible(true);
        f267055d.put(r112, r105);
        goto L73
    L74:
        NoSuchMethodError r119 = new NoSuchMethodError(r112);
        f267055d.put(r112, null);
        throw r119;
    L77:
        r108 = (Method[]) r107.invoke(r110, new Object[0]);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        Logger.e("DoubleReflector", "DoubleReflector" + String.format("getMethods %s#%s failed !!!", new Object[]{r110.getName()}), th);
    L21:
        r105 = null;
        goto L22
    L15:
        throw new NoSuchMethodError(r112);
    L16:
        r105 = null;
        goto L17
    }

    public static Method b(Class r100, Class... r101) {
        String r102 = r100.getName() + "#enqueueNotificationWithTag" + g(r101) + "#exact";
        HashMap<String, Method> r103 = f267055d;
        if (r103.containsKey(r102) == false) goto L13;
        Method r104 = r103.get(r102);
        if (r104 == null) goto L8;
        return r104;
    L8:
        throw new NoSuchMethodError(r102);
    L13:
        Method r105 = f(r100, "enqueueNotificationWithTag", r101);     // Catch: Throwable -> L11
        r105.setAccessible(true);     // Catch: Throwable -> L11
        r103.put(r102, r105);     // Catch: Throwable -> L11
        return r105;
    L11:
        f267055d.put(r102, null);
        throw new NoSuchMethodError(r102);
    }

    public static Field c(Class<?> r100, String r101) {
        Field r102 = e(r100, r101);
        if (r102 != null) goto L5;
    L7:
        return r102;
    L5:
        if (r102.isAccessible() == true) goto L7;
        r102.setAccessible(true);
        goto L7
    }

    public static Field e(Class<?> r100, String r101) {
        if (r100 == null) goto L13;
        Method r102 = f267052a;
        if (r102 != null) goto L14;
    L10:
        return null;
    L14:
        return (Field) r102.invoke(r100, new Object[]{r101});
    L8:
        th = move-exception;
        Logger.e("DoubleReflector", "DoubleReflector" + String.format("getField %s#%s failed !!!", new Object[]{r100.getName(), r101}), th);
        goto L10
    L13:
        throw new IllegalArgumentException("The class must not be null !!!");
    }

    public static float h(Class<?>[] r110, Class<?>[] r111) {
        int r100 = r110.length;
        int r101 = 0;
        float r102 = 0.0f;
    L3:
        if (r101 >= r100) goto L33;
        Class<?> r103 = r110[r101];
        Class<?> r104 = r111[r101];
        if (r104.isPrimitive() == true) goto L7;
        float r105 = 0.0f;
    L21:
        if (r103 == null) goto L30;
        if (r104.equals(r103) == true) goto L30;
        if (r104.isInterface() == false) goto L29;
        if (i(r103, r104) == false) goto L29;
        r105 = r105 + 0.25f;
    L29:
        r105 = r105 + 1.0f;
        r103 = r103.getSuperclass();
    L30:
        if (r103 != null) goto L32;
        r105 = r105 + 1.5f;
    L32:
        r102 = r102 + r105;
        r101 = r101 + 1;
        goto L3
    L7:
        if (r103.isPrimitive() == true) goto L9;
        r103 = (Class) ((HashMap) f267058g).get(r103);
        r105 = 0.1f;
    L10:
        int r106 = 0;
    L11:
        if (r103 == r104) goto L32;
        Class<?>[] r112 = f267059h;
        if (r106 >= r112.length) goto L32;
        if (r103 != r112[r106]) goto L19;
        r105 = r105 + 0.1f;
        if (r106 >= (r112.length - 1)) goto L19;
        r103 = r112[r106 + 1];
    L19:
        r106 = r106 + 1;
        goto L11
    L9:
        r105 = 0.0f;
        goto L10
    L33:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean i(Class r100, Class r101) {
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (r100 != null) goto L10;
        return !r101.isPrimitive();
    L10:
        if (r100.isPrimitive() == false) goto L19;
        if (r101.isPrimitive() == true) goto L19;
        if (r100.isPrimitive() == false) goto L16;
        r100 = (Class) ((HashMap) f267057f).get(r100);
    L16:
        if (r100 != null) goto L19;
        return false;
    L19:
        if (r101.isPrimitive() == false) goto L26;
        if (r100.isPrimitive() == true) goto L26;
        r100 = (Class) ((HashMap) f267058g).get(r100);
        if (r100 != null) goto L26;
        return false;
    L26:
        if (r100.equals(r101) == false) goto L29;
        return true;
    L29:
        if (r100.isPrimitive() == false) goto L100;
        if (r101.isPrimitive() == true) goto L33;
        return false;
    L33:
        Class r102 = Integer.TYPE;
        if (r102.equals(r100) == true) goto L36;
        Class r103 = Long.TYPE;
        if (r103.equals(r100) == false) goto L52;
        if (Float.TYPE.equals(r101) == false) goto L48;
    L49:
        return true;
    L48:
        if (Double.TYPE.equals(r101) == true) goto L49;
        return false;
    L52:
        if (Boolean.TYPE.equals(r100) == false) goto L55;
        return false;
    L55:
        if (Double.TYPE.equals(r100) == false) goto L57;
        return false;
    L57:
        Class r104 = Float.TYPE;
        if (r104.equals(r100) == false) goto L62;
        return Double.TYPE.equals(r101);
    L62:
        if (Character.TYPE.equals(r100) == false) goto L74;
        if (r102.equals(r101) == false) goto L66;
    L71:
        return true;
    L66:
        if (r103.equals(r101) == true) goto L71;
        if (r104.equals(r101) == true) goto L71;
        if (Double.TYPE.equals(r101) == true) goto L71;
        return false;
    L74:
        if (Short.TYPE.equals(r100) == false) goto L86;
        if (r102.equals(r101) == false) goto L78;
    L83:
        return true;
    L78:
        if (r103.equals(r101) == true) goto L83;
        if (r104.equals(r101) == true) goto L83;
        if (Double.TYPE.equals(r101) == true) goto L83;
        return false;
    L86:
        if (Byte.TYPE.equals(r100) == true) goto L88;
        return false;
    L88:
        if (Short.TYPE.equals(r101) == false) goto L90;
    L97:
        return true;
    L90:
        if (r102.equals(r101) == true) goto L97;
        if (r103.equals(r101) == true) goto L97;
        if (r104.equals(r101) == true) goto L97;
        if (Double.TYPE.equals(r101) == true) goto L97;
        return false;
    L36:
        if (Long.TYPE.equals(r101) == false) goto L38;
    L41:
        return true;
    L38:
        if (Float.TYPE.equals(r101) == true) goto L41;
        if (Double.TYPE.equals(r101) == true) goto L41;
        return false;
    L100:
        return r101.isAssignableFrom(r100);
    }

    public static Method d(Class<?> r100, String r101, Class<?>... r102) {
        Method r103 = f(r100, r101, r102);
        if (r103 != null) goto L5;
    L7:
        return r103;
    L5:
        if (r103.isAccessible() == true) goto L7;
        r103.setAccessible(true);
        goto L7
    }

    public static Method f(Class<?> r100, String r101, Class<?>... r102) {
        if (r100 == null) goto L11;
        Method r103 = f267053b;
        if (r103 != null) goto L13;
    L8:
        return null;
    L13:
        return (Method) r103.invoke(r100, new Object[]{r101, r102});
    L11:
        throw new IllegalArgumentException("The class must not be null !!!");
    }
}
