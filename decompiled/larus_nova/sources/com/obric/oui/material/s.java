package com.obric.oui.material;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class s {
    public static <T> ConcurrentHashMap<String, T> a(Class<?> r100, Class<?> r101) {
        ConcurrentHashMap<String, T> r102 = new ConcurrentHashMap();
        f(r100, r100.getDeclaredFields(), r101, r102);     // Catch: Throwable -> L5
    L6:
        return r102;
    }

    public static <T> ConcurrentHashMap<String, T> b(Object r100, Class<?> r101) {
        ConcurrentHashMap<String, T> r102 = new ConcurrentHashMap();
        if (r100 != null) goto L8;
    L7:
        return r102;
    L8:
        f(r100, r100.getClass().getDeclaredFields(), r101, r102);     // Catch: Throwable -> L6
        goto L7
    }

    public static <T> T c(String r100, Map<String, T> r101) {
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        String r102 = r100.toLowerCase(Locale.ROOT).trim();
        if (r102.length() != 0) goto L10;
        return null;
    L10:
        return r101.get(r102);
    L11:
        return null;
    }

    public static <T> void e(ConcurrentHashMap<String, T> r100, Map<String, ? extends T> r101, boolean r102) {
        if (r100 == null) goto L19;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isEmpty() == true) goto L31;
        Iterator<Map.Entry<String, ? extends T>> r103 = r101.entrySet().iterator();
    L9:
        if (r103.hasNext() == false) goto L32;
        Map.Entry<String, ? extends T> r104 = r103.next();
        String r105 = r104.getKey();
        if (r105 == null) goto L9;
        String r106 = r105.toLowerCase(Locale.ROOT).trim();
        if (r106.length() == 0) goto L9;
        if (r102 == true) goto L17;
        r100.putIfAbsent(r106, r104.getValue());
        goto L9
    L17:
        r100.put(r106, r104.getValue());
        goto L9
    L32:
        return;
    L31:
        return;
    }

    public static <T> void d(ConcurrentHashMap<String, T> r100, Object r101, Class<?> r102, boolean r103) {
        e(r100, b(r101, r102), r103);
    }

    public static void f(Object r100, Field[] r101, Class r102, ConcurrentHashMap r110) throws Exception {
        int r103 = r101.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L50;
        Field r105 = r101[r104];
        Class<?> r106 = r105.getType();
        if (r102.isAssignableFrom(r106) == false) goto L8;
    L42:
        boolean r107 = true;
    L44:
        if (r107 == false) goto L49;
        r105.setAccessible(true);
        Object r108 = r105.get(r100);
        if (r108 == null) goto L49;
        r110.put(r105.getName().toLowerCase(Locale.ROOT), r108);
    L49:
        r104 = r104 + 1;
        goto L3
    L8:
        if (r106.isPrimitive() == true) goto L11;
    L43:
        r107 = false;
        goto L44
    L11:
        if (r106 != Float.TYPE) goto L15;
        if (r102 == Float.class) goto L42;
    L15:
        if (r106 != Integer.TYPE) goto L19;
        if (r102 == Integer.class) goto L42;
    L19:
        if (r106 != Boolean.TYPE) goto L23;
        if (r102 == Boolean.class) goto L42;
    L23:
        if (r106 != Long.TYPE) goto L27;
        if (r102 == Long.class) goto L42;
    L27:
        if (r106 != Double.TYPE) goto L31;
        if (r102 == Double.class) goto L42;
    L31:
        if (r106 != Short.TYPE) goto L35;
        if (r102 == Short.class) goto L42;
    L35:
        if (r106 != Byte.TYPE) goto L39;
        if (r102 == Byte.class) goto L42;
    L39:
        if (r106 != Character.TYPE) goto L43;
        if (r102 != Character.class) goto L43;
    }
}
