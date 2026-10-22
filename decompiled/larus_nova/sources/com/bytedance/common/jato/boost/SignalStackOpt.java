package com.bytedance.common.jato.boost;

import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class SignalStackOpt {
    public SignalStackOpt() {
    }

    private static native void signalStackOptInternal();

    public static void signalStackOpt() {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        signalStackOptInternal();
    }

    static {
        JatoNativeLoader.loadLibrary();
    }
}
