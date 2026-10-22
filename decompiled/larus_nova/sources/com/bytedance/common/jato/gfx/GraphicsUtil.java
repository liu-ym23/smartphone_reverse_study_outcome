package com.bytedance.common.jato.gfx;

import android.os.Build;
import android.os.Looper;
import com.bytedance.common.jato.JatoNativeLoader;
import erc.a;

/* JADX INFO: loaded from: classes15.dex */
public class GraphicsUtil {
    private static boolean sGpuResCleanupEnabled;
    private static boolean sMemReduced;

    public GraphicsUtil() {
    }

    private static native void nativeEnableResourceCleanup();

    private static native void nativeReduceMemUsageForRN();

    public static void enableGpuResourceCleanup() {
        monitor-enter(GraphicsUtil.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sGpuResCleanupEnabled == false) goto L8;
        monitor-exit(GraphicsUtil.class);     // Catch: Throwable -> L15
        return;
    L8:
        sGpuResCleanupEnabled = true;     // Catch: Throwable -> L15
        monitor-exit(GraphicsUtil.class);     // Catch: Throwable -> L15
        if (JatoNativeLoader.loadLibrary() == true) goto L13;
        return;
    L13:
        a.b();
        nativeEnableResourceCleanup();
    }

    public static void optimizeRenderNodeMemory() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 <= 33) goto L5;
        return;
    L5:
        if (r100 < 29) goto L10;
        Looper.getMainLooper().getQueue().addIdleHandler(new AnonymousClass1());
        return;
    }

    private static void reduceMemUsageForRenderNode() {
        monitor-enter(GraphicsUtil.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (sMemReduced == false) goto L8;
        monitor-exit(GraphicsUtil.class);     // Catch: Throwable -> L15
        return;
    L8:
        sMemReduced = true;     // Catch: Throwable -> L15
        monitor-exit(GraphicsUtil.class);     // Catch: Throwable -> L15
        if (JatoNativeLoader.loadLibrary() == true) goto L13;
        return;
    L13:
        nativeReduceMemUsageForRN();
    }

    public static /* synthetic */ void access$000() {
        reduceMemUsageForRenderNode();
    }
}
