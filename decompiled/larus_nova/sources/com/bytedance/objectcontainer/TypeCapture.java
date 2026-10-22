package com.bytedance.objectcontainer;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes21.dex */
public abstract class TypeCapture<T> {
    public TypeCapture() {
    }

    public final Type capture() {
        Type r100 = getClass().getGenericSuperclass();
        if ((r100 instanceof ParameterizedType) == false) goto L7;
        return ((ParameterizedType) r100).getActualTypeArguments()[0];
    L7:
        throw new IllegalArgumentException(TypeToken.format("%s isn't parameterized", new Object[]{r100}));
    }
}
