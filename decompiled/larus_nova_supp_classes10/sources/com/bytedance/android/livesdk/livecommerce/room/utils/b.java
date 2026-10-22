package com.bytedance.android.livesdk.livecommerce.room.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static final Map<String, Field> a = null;

    static {
        a = new HashMap();
    }

    public static Object a(Object r8) throws IllegalAccessException {
        Class<?> r1 = r8.getClass();
        String r2 = r1.toString() + "#mTargetActivity";
        Map<String, Field> r3 = a;
        monitor-enter(r3);
        Field r4 = (Field) ((HashMap) r3).get(r2);     // Catch: Throwable -> L31
        monitor-exit(r3);     // Catch: Throwable -> L31
        if (r4 != null) goto L9;
    L11:
        if (r1 == null) goto L24;
        r4 = r1.getDeclaredField("mTargetActivity");     // Catch: NoSuchFieldException -> L23
        if (r4.isAccessible() == true) goto L15;
        r4.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L15:
        Map<String, Field> r6 = a;     // Catch: NoSuchFieldException -> L23
        monitor-enter(r6);     // Catch: NoSuchFieldException -> L23
        ((HashMap) r6).put(r2, r4);     // Catch: Throwable -> L20
        monitor-exit(r6);     // Catch: Throwable -> L20
    L25:
        if (r4 != null) goto L27;
        return null;
    L27:
        if (r4.isAccessible() == true) goto L30;
        r4.setAccessible(true);
    L30:
        return r4.get(r8);
    L20:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L23
    L23:
        r1 = r1.getSuperclass();
        goto L11
    L24:
        r4 = null;
        goto L25
    L9:
        if (r4.isAccessible() == true) goto L25;
        r4.setAccessible(true);
    L31:
        th = move-exception;
        throw th;
    }
}
