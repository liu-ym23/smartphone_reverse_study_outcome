package com.bytedance.crash.util;

import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static Field a(Class r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 28) goto L5;
    L10:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L48;
        Map<String, Field> r103 = f.f203411a;
        String r104 = r100.toString() + "#mLastProcessState";
        Map<String, Field> r105 = f.f203411a;
        monitor-enter(r105);
        Field r106 = (Field) ((HashMap) r105).get(r104);     // Catch: Throwable -> L41
        monitor-exit(r105);     // Catch: Throwable -> L41
        if (r106 != null) goto L24;
    L27:
        if (r100 == null) goto L59;
        Field r107 = r100.getDeclaredField("mLastProcessState");     // Catch: NoSuchFieldException -> L39
        if (r107.isAccessible() == true) goto L31;
        r107.setAccessible(true);     // Catch: NoSuchFieldException -> L39
    L31:
        Map<String, Field> r108 = f.f203411a;     // Catch: NoSuchFieldException -> L39
        monitor-enter(r108);     // Catch: NoSuchFieldException -> L39
        ((HashMap) r108).put(r104, r107);     // Catch: Throwable -> L36
        monitor-exit(r108);     // Catch: Throwable -> L36
    L58:
        return r107;
    L36:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L39
    L39:
        r100 = r100.getSuperclass();
        goto L27
    L59:
        return null;
    L24:
        if (r106.isAccessible() == true) goto L40;
        r106.setAccessible(true);
    L40:
        return r106;
    L41:
        th = move-exception;
        throw th;
    L48:
        Field r109 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r100, new Object[]{"mLastProcessState"});     // Catch: Throwable -> L15
        r109.setAccessible(true);     // Catch: Throwable -> L15
        return r109;
    L15:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L44
        return null;
    L57:
        return null;
    L5:
        if (r101 == 27) goto L7;
    L9:
        r102 = false;
        goto L12
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static Method b(Class r100, String r101) throws NoSuchMethodException {
        Method r102 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{r101, null});     // Catch: Throwable -> L5
        r102.setAccessible(true);     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
