package com.bytedance.common.jato.jit;

import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class JitCompileMethodPriority {
    public JitCompileMethodPriority() {
    }

    public static native void adjustJitCodeCacheGcThreshold(int r100);

    public static native void increaseCodeCache(int r100);

    public static native void keepJitCodeCacheMethod(String[] r100);

    public static native void osrPriorityNative(boolean r100, String[] r101);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void osrPriority(boolean r100, String[] r101) {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        osrPriorityNative(r100, r101);
    }
}
