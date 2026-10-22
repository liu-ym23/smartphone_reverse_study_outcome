package com.bytedance.common.jato.util;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public class JNIHook {
    public JNIHook() {
    }

    public static void init() {
    }

    private static native void nativeInit(Method r100, int r101);

    private static native void nativePlaceHolder();

    private native void nativeStub();

    static {
        nativePlaceHolder();
        Method r100 = JNIHook.class.getDeclaredMethod("nativePlaceHolder", new Class[0]);     // Catch: NoSuchMethodException -> L5
        nativeInit(r100, r100.getModifiers());     // Catch: NoSuchMethodException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }
}
