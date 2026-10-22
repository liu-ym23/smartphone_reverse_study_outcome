package com.bytedance.common.jato.boost;

import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes3.dex */
public class CpusetManager {
    public static final int CLUSTOR_TYPE_BIG = 2;
    public static final int CLUSTOR_TYPE_LITTLE = 1;
    private static int[] bigCoreNum;
    private static int[] littleCoreNum;
    private static boolean mHasInited;
    private static final Object mInitLock = null;

    public CpusetManager() {
    }

    public static void bindBigCore() {
        bindCore(-1, 2);
    }

    public static void bindLittleCore() {
        bindCore(-1, 1);
    }

    public static void resetCoreBind() {
        resetCoreBind(-1);
    }

    private static native void resetCpuSetTid(int r100);

    private static native void setCpuSetTid(int r100, int[] r101);

    static {
        mInitLock = new Object();
        mHasInited = false;
    }

    private static boolean isReady() {
        if (littleCoreNum != null) goto L5;
    L7:
        return false;
    L5:
        if (bigCoreNum == null) goto L7;
        return true;
    }

    public static void init() {
        boolean r100 = CpuFreqFetcher.fetch();
        Object r101 = mInitLock;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (mHasInited == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L8:
        if (r100 == false) goto L10;
        littleCoreNum = CpuFreqFetcher.getSmallCoreNum();     // Catch: Throwable -> L13
        bigCoreNum = CpuFreqFetcher.getBigCoreNum();     // Catch: Throwable -> L13
    L10:
        mHasInited = true;     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public static void bindBigCore(int r100) {
        bindCore(r100, 2);
    }

    public static void bindLittleCore(int r100) {
        bindCore(r100, 1);
    }

    public static void resetCoreBind(int r100) {
        if (JatoNativeLoader.loadLibrary() == true) goto L5;
        return;
    L5:
        Object r101 = mInitLock;
        monitor-enter(r101);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (isReady() == false) goto L10;
        resetCpuSetTid(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L12
    }

    private static void bindCore(int r100, int r101) {
        if (JatoNativeLoader.loadLibrary() == true) goto L5;
        return;
    L5:
        Object r102 = mInitLock;
        monitor-enter(r102);
        if (r101 != 2) goto L13;
        int[] r103 = bigCoreNum;     // Catch: Throwable -> L10
    L16:
        if (r103 != null) goto L18;
    L20:
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L18:
        if (isReady() == false) goto L20;
        setCpuSetTid(r100, r103);     // Catch: Throwable -> L10
        goto L20
    L13:
        if (r101 != 1) goto L15;
        r103 = littleCoreNum;     // Catch: Throwable -> L10
        goto L16
    L15:
        r103 = null;
    L10:
        th = move-exception;
        throw th;
    }
}
