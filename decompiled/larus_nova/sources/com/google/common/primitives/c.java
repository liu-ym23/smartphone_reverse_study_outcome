package com.google.common.primitives;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f275660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<?>, Class<?>> f275661b = null;

    static {
        LinkedHashMap r100 = new LinkedHashMap(16);
        LinkedHashMap r101 = new LinkedHashMap(16);
        Class r102 = Boolean.TYPE;
        r100.put(r102, Boolean.class);
        r101.put(Boolean.class, r102);
        Class r103 = Byte.TYPE;
        r100.put(r103, Byte.class);
        r101.put(Byte.class, r103);
        Class r104 = Character.TYPE;
        r100.put(r104, Character.class);
        r101.put(Character.class, r104);
        Class r105 = Double.TYPE;
        r100.put(r105, Double.class);
        r101.put(Double.class, r105);
        Class r106 = Float.TYPE;
        r100.put(r106, Float.class);
        r101.put(Float.class, r106);
        Class r107 = Integer.TYPE;
        r100.put(r107, Integer.class);
        r101.put(Integer.class, r107);
        Class r108 = Long.TYPE;
        r100.put(r108, Long.class);
        r101.put(Long.class, r108);
        Class r109 = Short.TYPE;
        r100.put(r109, Short.class);
        r101.put(Short.class, r109);
        Class r110 = Void.TYPE;
        r100.put(r110, Void.class);
        r101.put(Void.class, r110);
        f275660a = Collections.unmodifiableMap(r100);
        f275661b = Collections.unmodifiableMap(r101);
    }

    public static <T> Class<T> a(Class<T> r100) {
        r100.getClass();
        Class<T> r101 = (Class) f275660a.get(r100);
        if (r101 != null) goto L6;
        return r100;
    L6:
        return r101;
    }
}
