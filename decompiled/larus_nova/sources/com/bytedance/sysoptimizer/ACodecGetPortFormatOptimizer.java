package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.bytedance.android.bytehook.ByteHook;

/* JADX INFO: loaded from: classes22.dex */
public class ACodecGetPortFormatOptimizer {
    public ACodecGetPortFormatOptimizer() {
    }

    private static native void aCodecGetPortFormatOptimizer();

    private static native void aCodecGetPortFormatOptimizerByByteCode();

    private static boolean isUnderAndroidPAndAboveM() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 28) goto L5;
    L7:
        return false;
    L5:
        if (r100 <= 23) goto L7;
        return true;
    }

    public static void fixACodecGetPortFormat(Context r100) {
        if (isUnderAndroidPAndAboveM() == true) goto L5;
        return;
    L5:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ByteHook.init();
        aCodecGetPortFormatOptimizer();
        aCodecGetPortFormatOptimizerByByteCode();
        return;
    }
}
