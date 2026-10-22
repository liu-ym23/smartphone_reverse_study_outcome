package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.android.SystemUtils;

/* JADX INFO: loaded from: classes22.dex */
public class EglCreateSurfaceFixer {
    private static final String TAG = "NJitCompileOptimizer";
    private static boolean sInited;

    public EglCreateSurfaceFixer() {
    }

    private static native void fix(int r100);

    public static synchronized void fix(Context r100, int r101) {
        monitor-enter(EglCreateSurfaceFixer.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sInited == false) goto L9;
        monitor-exit(EglCreateSurfaceFixer.class);
        return;
    L9:
        sInited = true;     // Catch: Throwable -> L14
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L12;
        fix(r101);     // Catch: Throwable -> L14
    L12:
        monitor-exit(EglCreateSurfaceFixer.class);
    }

    public static synchronized void fixHuawei(Context r100, int r101) {
        monitor-enter(EglCreateSurfaceFixer.class);
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r102 != 26) goto L7;
    L8:
        String r103 = Build.MANUFACTURER;     // Catch: Throwable -> L15
        if (r103.equalsIgnoreCase(SystemUtils.PRODUCT_HUAWEI) == false) goto L11;
    L12:
        fix(r100, r101);     // Catch: Throwable -> L15
    L13:
        monitor-exit(EglCreateSurfaceFixer.class);
        return;
    L11:
        if (r103.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR) == false) goto L13;
    L7:
        if (r102 != 27) goto L13;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized void fixOsOP(Context r100, int r101) {
        monitor-enter(EglCreateSurfaceFixer.class);
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L11
        if (r102 >= 26) goto L7;
    L9:
        monitor-exit(EglCreateSurfaceFixer.class);
        return;
    L7:
        if (r102 > 28) goto L9;
        fix(r100, r101);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
