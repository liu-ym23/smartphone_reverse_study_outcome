package com.larksuite.framework.utils;

import android.os.Build;
import com.ss.android.lark.log.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes24.dex */
public final class b0 {
    public static Field a(Class<?> r100, String r101) {
    L8:
        e = move-exception;
        Log.e("ReflectionUtil", e.getMessage());
        return null;
    L3:
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return r100.getDeclaredField(r101);
    L7:
        return (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r100, new Object[]{r101});
    }

    public static Method b(Class<?> r100, String r101, Class... r102) {
    L8:
        e = move-exception;
        Log.e("ReflectionUtil", e.getMessage());
        return null;
    L3:
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return r100.getDeclaredMethod(r101, new Class[0]);
    L7:
        return (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r100, new Object[]{r101, r102});
    }
}
