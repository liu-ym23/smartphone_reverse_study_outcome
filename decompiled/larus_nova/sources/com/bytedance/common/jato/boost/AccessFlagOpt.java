package com.bytedance.common.jato.boost;

import android.os.Build;
import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.common.jato.JatoXL;

/* JADX INFO: loaded from: classes15.dex */
public class AccessFlagOpt {
    public AccessFlagOpt() {
    }

    private static native boolean nativeDisable();

    private static native boolean nativeDisableMember();

    private static native boolean nativeEnable();

    private static native boolean nativeEnableMember();

    public static boolean disable() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        if (JatoXL.isInited() == true) goto L7;
        return false;
    L7:
        if (Process.is64Bit() == true) goto L9;
        return false;
    L9:
        if (JatoNativeLoader.isLoaded() == true) goto L11;
        return false;
    L11:
        return nativeDisable();
    }

    public static boolean enable() {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return false;
    L5:
        if (JatoXL.isInited() == true) goto L7;
        return false;
    L7:
        if (Process.is64Bit() == true) goto L9;
        return false;
    L9:
        if (JatoNativeLoader.isLoaded() == true) goto L11;
        return false;
    L11:
        return nativeEnable();
    }
}
