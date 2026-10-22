package com.obric.common.oea.foundation.blur;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes33.dex */
public class NativeReflect {
    public NativeReflect() {
    }

    public native Constructor getDeclaredConstructorNative(Class<?> r100, Class<?>[] r101);

    public native Field getDeclaredFieldNative(Class<?> r100, String r101);

    public native Method getDeclaredMethodNative(Class<?> r100, String r101, Class<?>[] r102);

    static {
        new NativeReflect();
    }
}
