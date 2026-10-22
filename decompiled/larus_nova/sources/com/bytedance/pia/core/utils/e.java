package com.bytedance.pia.core.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes21.dex */
public final class e {
    public static Class<?> a(Object r100, Class<?> r101, int r102) {
        if (r102 >= 0) goto L6;
    L29:
        return null;
    L6:
        if (r101.isInstance(r100) == true) goto L31;
        return null;
    L31:
        Type[] r103 = r100.getClass().getGenericInterfaces();     // Catch: Throwable -> L30
        int r104 = r103.length;     // Catch: Throwable -> L30
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L16;
        Type r106 = r103[r105];     // Catch: Throwable -> L30
        if ((r106 instanceof ParameterizedType) == false) goto L15;
        if (((ParameterizedType) r106).getRawType() != r101) goto L15;
        ParameterizedType r107 = (ParameterizedType) r106;     // Catch: Throwable -> L30
    L17:
        if (r107 != null) goto L23;
        Type r108 = r100.getClass().getGenericSuperclass();     // Catch: Throwable -> L30
        if ((r108 instanceof ParameterizedType) == false) goto L23;
        if (((ParameterizedType) r108).getRawType() != r101) goto L23;
        r107 = (ParameterizedType) r108;     // Catch: Throwable -> L30
    L23:
        if (r107 != null) goto L25;
        return null;
    L25:
        Type[] r109 = r107.getActualTypeArguments();     // Catch: Throwable -> L30
        if (r102 >= r109.length) goto L29;
        return (Class) r109[r102];
    L15:
        r105 = r105 + 1;     // Catch: Throwable -> L30
        goto L9
    L16:
        r107 = null;
        goto L17
    }
}
