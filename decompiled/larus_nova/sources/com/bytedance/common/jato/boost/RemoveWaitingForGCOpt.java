package com.bytedance.common.jato.boost;

import android.os.Build;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class RemoveWaitingForGCOpt {
    private static volatile boolean sInited;

    public RemoveWaitingForGCOpt() {
    }

    private static native boolean nEnable(boolean r100);

    public static boolean enable(boolean r100) {
        if (sInited == false) goto L6;
        return false;
    L6:
        if (Build.VERSION.SDK_INT >= 29) goto L8;
        return false;
    L8:
        JatoNativeLoader.loadLibrary();
        sInited = true;     // Catch: Throwable -> L11
        return nEnable(r100);
    L11:
        return false;
    }
}
