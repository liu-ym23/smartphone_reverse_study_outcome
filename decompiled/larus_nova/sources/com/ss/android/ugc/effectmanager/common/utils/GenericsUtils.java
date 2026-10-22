package com.ss.android.ugc.effectmanager.common.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes40.dex */
public class GenericsUtils {
    public GenericsUtils() {
    }

    public static Class getSuperClassGenericType(Class r100) {
        return getSuperClassGenericType(r100, 0);
    }

    public static Class getSuperClassGenericType(Class r100, int r101) throws IndexOutOfBoundsException {
        Type r102 = r100.getGenericSuperclass();
        if ((r102 instanceof ParameterizedType) == true) goto L6;
        return Object.class;
    L6:
        Type[] r103 = ((ParameterizedType) r102).getActualTypeArguments();
        if (r101 >= r103.length) goto L16;
        if (r101 < 0) goto L18;
        Type r104 = r103[r101];
        if ((r104 instanceof Class) == true) goto L15;
        return Object.class;
    L15:
        return (Class) r104;
    L18:
        return Object.class;
    L16:
        return Object.class;
    }
}
