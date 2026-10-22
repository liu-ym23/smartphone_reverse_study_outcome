package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.android.bytehook.ByteHook;

/* JADX INFO: loaded from: classes22.dex */
public class HuaweiWebViewIncludeJavaStack {
    public HuaweiWebViewIncludeJavaStack() {
    }

    private static native int nStart();

    public static int start(Context r100) {
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L6;
        ByteHook.init();
        return nStart();
    L6:
        return -1;
    }
}
