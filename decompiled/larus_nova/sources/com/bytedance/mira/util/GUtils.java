package com.bytedance.mira.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class GUtils {
    public static final Class<?>[] EMPTY_CLASS_ARRAY = null;
    public static final Object[] EMPTY_OBJECT_ARRAY = null;
    private static final String TAG = null;

    static {
        TAG = "GUtils";
        EMPTY_OBJECT_ARRAY = new Object[0];
        EMPTY_CLASS_ARRAY = new Class[0];
    }

    private GUtils() {
    }

    public static List<Class<?>> getAllInterfaces(Class<?> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        LinkedHashSet r101 = new LinkedHashSet();
        getAllInterfaces(r100, r101);
        return new ArrayList(r101);
    }

    public static Class<?>[] nullToEmpty(Class<?>[] r100) {
        if (r100 == null) goto L8;
        if (r100.length == 0) goto L8;
        return r100;
    L8:
        return EMPTY_CLASS_ARRAY;
    }

    public static Class<?>[] toClass(Object... r100) {
        if (r100 == null) goto L16;
        if (r100.length == 0) goto L16;
        Class<?>[] r101 = new Class[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L14;
        Object r103 = r100[r102];
        if (r103 != null) goto L12;
        Class<?> r104 = null;
    L13:
        r101[r102] = r104;
        r102 = r102 + 1;
        goto L8
    L12:
        r104 = r103.getClass();
        goto L13
    L14:
        return r101;
    L16:
        return EMPTY_CLASS_ARRAY;
    }

    public static Object[] nullToEmpty(Object[] r100) {
        if (r100 == null) goto L8;
        if (r100.length == 0) goto L8;
        return r100;
    L8:
        return EMPTY_OBJECT_ARRAY;
    }

    private static void getAllInterfaces(Class<?> r100, HashSet<Class<?>> r101) {
    L2:
        if (r100 == null) goto L10;
        Class<?>[] r102 = r100.getInterfaces();
        int r103 = r102.length;
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L9;
        Class<?> r105 = r102[r104];
        if (r101.add(r105) == false) goto L8;
        getAllInterfaces(r105, r101);
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        r100 = r100.getSuperclass();
        goto L2
    }

    public static boolean isSameLength(Object[] r100, Object[] r101) {
        if (r100 != null) goto L6;
        if (r101 == null) goto L6;
        if (r101.length <= 0) goto L6;
        return false;
    L6:
        if (r101 != null) goto L10;
        if (r100 == null) goto L10;
        if (r100.length <= 0) goto L10;
        return false;
    L10:
        if (r100 == null) goto L16;
        if (r101 != null) goto L13;
        return true;
    L13:
        if (r100.length == r101.length) goto L21;
        return false;
    L21:
        return true;
    L16:
        return true;
    }
}
