package com.huawei.hms.support.gentyref;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes23.dex */
public final class GenericTypeReflector {
    private GenericTypeReflector() {
    }

    public static Class<?> getType(Type r100) {
        if ((r100 instanceof Class) == false) goto L7;
        return (Class) r100;
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L11;
        return (Class) ((ParameterizedType) r100).getRawType();
    L11:
        if ((r100 instanceof TypeVariable) == false) goto L19;
        TypeVariable r101 = (TypeVariable) r100;
        if (r101.getBounds().length != 0) goto L17;
        return Object.class;
    L17:
        return getType(r101.getBounds()[0]);
    L19:
        throw new IllegalArgumentException("not supported: " + r100.getClass());
    }
}
