package com.lynx.tasm.performance.longtasktiming;

import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;

/* JADX INFO: loaded from: classes32.dex */
public class LynxLongTaskMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f383545a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f383546b;

    public LynxLongTaskMonitor() {
    }

    private static native void nativeDidProcessTask();

    private static native void nativeUpdateLongTaskTimingIfNeed(String r100, String r101, String r102);

    private static native void nativeWillProcessTask(String r100, String r101, String r102, int r103);

    static {
        f383545a = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_LONG_TASK_TIMING, false);
        f383546b = false;
    }

    public static void a() {
        if (f383545a == true) goto L5;
        boolean r100 = false;
    L9:
        if (r100 == false) goto L12;
        nativeDidProcessTask();
        return;
    L12:
        return;
    L5:
        if (f383546b == true) goto L7;
        f383546b = LynxEnv.inst().isNativeLibraryLoaded();
    L7:
        r100 = f383546b;
        goto L9
    }

    public static boolean b(String r100, int r101, LynxBooleanOption r102) {
        if (r102 != LynxBooleanOption.FALSE) goto L5;
        return false;
    L5:
        if (f383545a == true) goto L7;
        boolean r103 = false;
    L11:
        if (r103 == false) goto L15;
        nativeWillProcessTask("platform_func_task", r100, null, r101);
        return true;
    L15:
        return false;
    L7:
        if (f383546b == true) goto L9;
        f383546b = LynxEnv.inst().isNativeLibraryLoaded();
    L9:
        r103 = f383546b;
        goto L11
    }
}
