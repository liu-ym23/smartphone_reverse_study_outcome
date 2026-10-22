package com.bytedance.common.jato.boost;

import android.os.Build;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class HiddenApiOpt {
    public HiddenApiOpt() {
    }

    private static native boolean nOptimize();

    public static void doOptimize() {
        if (Build.VERSION.SDK_INT > 30) goto L5;
        return;
    L5:
        JatoNativeLoader.loadLibrary();
        nOptimize();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}
