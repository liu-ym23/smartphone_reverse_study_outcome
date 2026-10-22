package com.bytedance.reparo.core;

import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class PatchConstructorHelper {
    private static Map<String, Class> sOriginClassMap;

    public PatchConstructorHelper() {
    }

    static {
        sOriginClassMap = new HashMap();
    }

    public static void collectConstructorClass(Constructor r100) {
        Class r101 = r100.getDeclaringClass();
        String r102 = r101.getName();
        sOriginClassMap.put(r102, r101);
    }

    public static void changeInstanceDeclaringClass(String r100, Object r101) {
        if (n.h() == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return;
    L12:
        if (sOriginClassMap.containsKey(r100) == true) goto L14;
        return;
    L14:
        Class r102 = sOriginClassMap.get(r100);
        if (r102.isInstance(r101) == false) goto L17;
        return;
    L17:
        monitor-enter(r101);
        Field r103 = Object.class.getDeclaredField("shadow$_klass_");     // Catch: Throwable -> L20 Exception -> L22
        r103.setAccessible(true);     // Catch: Throwable -> L20 Exception -> L22
        r103.set(r101, r102);     // Catch: Throwable -> L20 Exception -> L22
    L24:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }
}
