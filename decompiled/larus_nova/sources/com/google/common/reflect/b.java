package com.google.common.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class b<T> {
    public b() {
    }

    public final Type capture() {
        Type r100 = getClass().getGenericSuperclass();
        com.google.common.base.m.h(r100 instanceof ParameterizedType, "%s isn't parameterized", r100);
        return ((ParameterizedType) r100).getActualTypeArguments()[0];
    }
}
