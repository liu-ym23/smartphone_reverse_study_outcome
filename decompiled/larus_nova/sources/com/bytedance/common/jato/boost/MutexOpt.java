package com.bytedance.common.jato.boost;

import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class MutexOpt {
    public MutexOpt() {
    }

    private static native void exclusiveLockSpinOptInternal(int r100);

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void exclusiveLockSpinOpt(int r100) {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        exclusiveLockSpinOptInternal(r100);
    }
}
