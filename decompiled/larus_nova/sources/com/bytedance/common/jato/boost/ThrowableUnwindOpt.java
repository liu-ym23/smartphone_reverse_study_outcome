package com.bytedance.common.jato.boost;

import android.os.Build;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes3.dex */
public class ThrowableUnwindOpt {
    public ThrowableUnwindOpt() {
    }

    private static native boolean optimizeFileExistUnwind();

    public static void doOptimize() {
        if (Build.VERSION.SDK_INT > 28) goto L5;
        return;
    L5:
        JatoNativeLoader.loadLibrary();
        optimizeFileExistUnwind();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
