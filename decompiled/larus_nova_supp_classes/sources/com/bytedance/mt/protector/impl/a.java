package com.bytedance.mt.protector.impl;

import com.bytedance.mt.protector.ProtectorType;
import com.bytedance.mt.protector.c;
import com.bytedance.mt.protector.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class a<T> {
    private static Class[] typeClasses;

    static {
        typeClasses = new Class[]{Byte.class, Double.class, Float.class, Integer.class, Long.class, Short.class, String.class};
    }

    public a() {
    }

    private static boolean isReturnMatch(Object r6, Class<?> r7) {
        Class<?>[] r0 = typeClasses;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L10;
        Class<?> r4 = r0[r3];
        if (r4.isInstance(r6) == false) goto L9;
        if (r7 != r4) goto L9;
        return true;
    L9:
        r3 = r3 + 1;
        goto L3
    L10:
        return false;
    }

    public static <T> T tryProtect(ProtectorType r0, Throwable r1, Class<?> r2) {
        f r3 = c.a(r0, r1);
        if (r3 != null) goto L5;
        return null;
    L5:
        T r4 = (T) r3.a;
        if (isReturnMatch(r4, r2) == false) goto L8;
        return r4;
    L8:
        return null;
    }
}
