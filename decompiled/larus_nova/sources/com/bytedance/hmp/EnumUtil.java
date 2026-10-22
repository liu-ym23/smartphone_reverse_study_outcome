package com.bytedance.hmp;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes19.dex */
public class EnumUtil {
    public EnumUtil() {
    }

    public static Object fromValue(Class r100, Object r101) {
        Object[] r102 = r100.getEnumConstants();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        Method r105 = null;
        if (r104 >= r103) goto L18;
        Object r106 = r102[r104];
        r105 = r106.getClass().getMethod("getValue", new Class[0]);     // Catch: NoSuchMethodException -> L8
    L21:
        if (r105.invoke(r106, new Object[0]).equals(r101) == false) goto L17;
        return r106;
    L17:
        r104 = r104 + 1;
        goto L3
    L15:
        e = move-exception;
        e.printStackTrace();
    L13:
        e = move-exception;
        e.printStackTrace();
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L18:
        return null;
    }
}
