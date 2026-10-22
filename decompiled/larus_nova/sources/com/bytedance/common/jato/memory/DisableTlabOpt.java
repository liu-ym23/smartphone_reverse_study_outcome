package com.bytedance.common.jato.memory;

import com.bytedance.common.jato.JatoNativeLoader;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes15.dex */
public class DisableTlabOpt {
    private static Field nativePeerField;

    public DisableTlabOpt() {
    }

    private static native Thread[] getNativeThreadList();

    private static native void nativeDisableTlab(long[] r100);

    private static native void nativeEnableTlab();

    static {
        Field r100 = Thread.class.getDeclaredField("nativePeer");     // Catch: Exception -> L4
        nativePeerField = r100;     // Catch: Exception -> L4
        r100.setAccessible(true);     // Catch: Exception -> L4
        JatoNativeLoader.loadLibrary();     // Catch: Exception -> L4
        return;
    L4:
        nativePeerField = null;
    }
}
