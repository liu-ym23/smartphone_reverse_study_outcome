package com.bytedance.common.jato.gc;

/* JADX INFO: loaded from: classes15.dex */
public class GCInfo {
    public GCInfo() {
    }

    private static native long nativeGetCapacity();

    private static native double nativeGetForegroundHeapGrowthMultiplier();

    private static native long nativeGetGrowthLimit();

    private static native long nativeGetInitialHeapSize();

    private static native long nativeGetLargeObjectThreshold();

    private static native int nativeGetLastGCCause();

    private static native int nativeGetLastGCType();

    private static native long nativeGetMaxFree();

    private static native long nativeGetMinFree();

    private static native int nativeGetNextGCType();

    private static native long nativeGetStopForNativeAllocs();

    private static native long nativeGetTargetFootprint();

    private static native double nativeGetTargetUtilization();

    private static native long nativeGetTotalPausedTime();

    private static native long nativeGetTotalWaitTime();

    private static native boolean nativeInit(long r100);

    private static native boolean nativeSetForegroundHeapGrowthMultiplier(double r100);

    private static native boolean nativeSetMaxFree(long r100);

    private static native boolean nativeSetMinFree(long r100);

    private static native boolean nativeSetNextGCType(int r100);

    private static native boolean nativeSetStopForNativeAllocs(long r100);

    private static native boolean nativeSetTargetFootprint(long r100);

    private static native boolean nativeSetTargetUtilization(double r100);
}
