package com.ss.android.lark.image.utils;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes36.dex */
public final class e {
    public static Object a(Object r100, String r101) {
        Class<?> r102 = r100.getClass();
    L4:
        if (r102 == Object.class) goto L8;
        Field r103 = r102.getDeclaredField(r101);     // Catch: Exception -> L7
    L9:
        r103.setAccessible(true);
        return r103.get(r100);
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        r102 = r102.getSuperclass();
        goto L4
    L8:
        r103 = null;
        goto L9
    }

    public static boolean b(Object r100, String r101, Object r102) {
        Class<?> r103 = r100.getClass();     // Catch: NullPointerException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
    L4:
        if (r103 == Object.class) goto L14;
        Field r104 = r103.getDeclaredField(r101);     // Catch: Exception -> L7
    L15:
        r104.setAccessible(true);     // Catch: NullPointerException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        r104.set(r100, r102);     // Catch: NullPointerException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        return true;
    L7:
        r103 = r103.getSuperclass();     // Catch: NullPointerException -> L8 IllegalAccessException -> L10 IllegalArgumentException -> L12
        goto L4
    L14:
        r104 = null;
    L10:
        e = e;
    L17:
        e.printStackTrace();
        return false;
    L12:
        e = e;
    L8:
        e = e;
        goto L17
    }
}
