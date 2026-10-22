package com.bytedance.mira.util;

import java.lang.reflect.Field;
import xtc.a;

/* JADX INFO: loaded from: classes21.dex */
public class FindLoadedClassWrapperUtils {
    public FindLoadedClassWrapperUtils() {
    }

    static {
        Field r100 = Class.class.getDeclaredField("classLoader");     // Catch: Throwable -> L4
        r100.setAccessible(true);     // Catch: Throwable -> L4
        r100.set(a.class, null);     // Catch: Throwable -> L4
        return;
    }

    public static Class<?> findLoadedClass(ClassLoader r100, String r101) {
        return a.a(r100, r101);
    }
}
