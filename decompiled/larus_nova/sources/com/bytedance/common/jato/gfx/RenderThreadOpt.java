package com.bytedance.common.jato.gfx;

import android.os.Build;
import android.os.Process;
import android.view.FrameMetrics;
import com.bytedance.common.jato.JatoNativeLoader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes15.dex */
public class RenderThreadOpt {
    private static volatile boolean initedFixPositionUpdateCrash;

    public RenderThreadOpt() {
    }

    private static native boolean nativeAddDrawOpOpt(int r100);

    private static native boolean nativeChangeRenderPipelineType(boolean r100);

    private static native boolean nativeCheckNativeForTest();

    private static native boolean nativeDrawPathOpt(int r100);

    private static native ByteBuffer nativeDumpGraphicsMemory();

    private static native boolean nativeEnableFrameCallbackOpt(boolean r100);

    private static native boolean nativeEnablePositionUpdateProxy();

    private static native boolean nativePinImagesOpt(int r100);

    private static native boolean nativePrepareTreeOpt(int r100, boolean r101, boolean r102, boolean r103);

    private static native boolean nativePrepareTreeOptDeinit();

    private static native boolean nativePrintDirty();

    private static native boolean nativeReportFrameOpt(int r100);

    private static native boolean nativeResourceCacheOpt(int r100);

    public static void enablePositionUpdateProxy() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 >= 25) goto L5;
        return;
    L5:
        if (r100 <= 34) goto L8;
        return;
    L8:
        if (Process.is64Bit() == true) goto L11;
        return;
    L11:
        if (initedFixPositionUpdateCrash == false) goto L13;
        return;
    L13:
        nativeEnablePositionUpdateProxy();
        initedFixPositionUpdateCrash = true;
    }

    private static int getFrameDataCount() {
        Constructor r100 = FrameMetrics.class.getConstructor(new Class[0]);     // Catch: Throwable -> L4
        r100.setAccessible(true);     // Catch: Throwable -> L4
        FrameMetrics r101 = (FrameMetrics) r100.newInstance(new Object[0]);     // Catch: Throwable -> L4
        Field r102 = FrameMetrics.class.getDeclaredField("mTimingData");     // Catch: Throwable -> L4
        r102.setAccessible(true);     // Catch: Throwable -> L4
        return ((long[]) r102.get(r101)).length;
    L4:
        return 23;
    }

    public static boolean reportFrameOpt() {
        if (Build.VERSION.SDK_INT >= 24) goto L7;
        return false;
    L7:
        return nativeReportFrameOpt(getFrameDataCount());
    }

    public static boolean checkNativeForTest() {
        return nativeCheckNativeForTest();
    }

    static {
        JatoNativeLoader.loadLibrary();
    }

    public static void addDrawOpOpt(int r100) {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        nativeAddDrawOpOpt(r100);
    }

    public static void drawPathOpt(int r100) {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        nativeDrawPathOpt(r100);
    }

    public static void pinImagesOpt(int r100) {
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        return;
    L6:
        if (Process.is64Bit() == true) goto L8;
        return;
    L8:
        nativePinImagesOpt(r100);
    }

    public static void resourceCacheOpt(int r100) {
        if (Process.is64Bit() == true) goto L5;
        return;
    L5:
        nativeResourceCacheOpt(r100);
    }

    public static boolean setEnableFrameCallbackOpt(boolean r100) {
        if (Process.is64Bit() == true) goto L7;
        return false;
    L7:
        return nativeEnableFrameCallbackOpt(r100);
    }

    public static boolean callPositionLost(Object r100, long r101) {
        return PositionUpdateProxy.positionLost(r100, r101);
    }

    public static boolean prepareTreeOpt(int r100, boolean r101, boolean r102, boolean r103) {
        if (Build.VERSION.SDK_INT >= 28) goto L7;
        return false;
    L7:
        return nativePrepareTreeOpt(r100, r103, r101, r102);
    }

    public static boolean callPositionChanged(Object r100, long r101, int r102, int r103, int r104, int r105) {
        return PositionUpdateProxy.positionChanged(r100, r101, r102, r103, r104, r105);
    }
}
