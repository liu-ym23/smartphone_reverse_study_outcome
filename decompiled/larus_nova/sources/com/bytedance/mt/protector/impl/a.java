package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.f;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {
    private static Class[] typeClasses;

    static {
        typeClasses = new Class[]{Byte.class, Double.class, Float.class, Integer.class, Long.class, Short.class, String.class};
    }

    public a() {
    }

    private static boolean isReturnMatch(Object r100, Class<?> r101) {
        Class<?>[] r102 = typeClasses;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L10;
        Class<?> r105 = r102[r104];
        if (r105.isInstance(r100) == false) goto L9;
        if (r101 != r105) goto L9;
        return true;
    L9:
        r104 = r104 + 1;
        goto L3
    L10:
        return false;
    }

    public static <T> T tryProtect(ProtectorType r100, Throwable r101, Class<?> r102) {
        f r103 = c.a(r100, r101);
        if (r103 != null) goto L5;
        return null;
    L5:
        T r104 = (T) r103.f265674a;
        if (isReturnMatch(r104, r102) == false) goto L8;
        return r104;
    L8:
        return null;
    }
}
