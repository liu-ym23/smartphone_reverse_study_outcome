package com.bytedance.common.jato.boost;

import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class ClassMethodAndFieldPreload {
    public ClassMethodAndFieldPreload() {
    }

    private static native void optimizeInternal();

    public static void optimize() {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        optimizeInternal();
    }

    static {
        JatoNativeLoader.loadLibrary();
    }
}
