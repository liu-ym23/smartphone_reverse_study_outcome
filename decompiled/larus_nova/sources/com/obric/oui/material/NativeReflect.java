package com.obric.oui.material;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
class NativeReflect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f401411a = 0;

    public NativeReflect() {
    }

    public native Constructor getDeclaredConstructorNative(Class<?> r100, Class<?>[] r101);

    public native Field getDeclaredFieldNative(Class<?> r100, String r101);

    public native Method getDeclaredMethodNative(Class<?> r100, String r101, Class<?>[] r102);

    static {
        new NativeReflect();
    }
}
