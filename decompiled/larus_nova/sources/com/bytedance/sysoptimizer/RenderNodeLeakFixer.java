package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes22.dex */
public class RenderNodeLeakFixer {
    private static boolean sInited;

    public RenderNodeLeakFixer() {
    }

    private static native void fixRenderNodeLeak();

    public static void fix(Context r100) {
        if (sInited == false) goto L5;
        return;
    L5:
        sInited = true;
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        fixRenderNodeLeak();
        return;
    }

    public static void fixAndroidN(Context r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 != 24) goto L5;
    L6:
        fix(r100);
        return;
    L5:
        if (r101 == 25) goto L6;
    }
}
