package com.bytedance.common.jato.memory.gcblocker;

import android.os.Build;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class GcBlocker extends AbsGcBlocker {
    private static long HEAP_SIZE_LIMIT = 209715200;
    private static long MAX_HEAP_SIZE = 536870912;
    private final HashMap<String, Integer> mTokens;

    private static native int nativeCreateToken(boolean r100);

    private static native void nativeReleaseToken(int r100);

    private static native void nativeRequestBlockGc(long r100);

    private static native void nativeSetHeapLimit(boolean r100, int r101, int r102);

    private static native void nativeSetIsSupportApex(boolean r100);

    private static native void nativeSetMaxGcBlockTime(int r100);

    private static native int nativeStartBlockGc(int r100);

    private static native void nativeStopBlockGc(int r100);

    private static boolean checkHeapSizeLimit() {
        boolean r100 = true;
        if (HEAP_SIZE_LIMIT > 0) goto L5;
        return true;
    L5:
        long r101 = Runtime.getRuntime().totalMemory();
        if (Build.VERSION.SDK_INT < 29) goto L11;
        if (r101 < MAX_HEAP_SIZE) goto L11;
        return true;
    L11:
        if (r101 < HEAP_SIZE_LIMIT) goto L14;
        r100 = false;
    L14:
        if (r100 == false) goto L16;
    L16:
        return r100;
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void requestBlockGc(long r100) {
        if (checkHeapSizeLimit() == true) goto L5;
        return;
    L5:
        if (this.mDisabled == false) goto L7;
        return;
    L7:
        if (r100 > 0) goto L9;
        return;
    L9:
        if (r100 > 5000) goto L15;
        nativeRequestBlockGc(r100);
        return;
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void setMaxGcBlockDuration(int r100) {
        nativeSetMaxGcBlockTime(r100);
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void startBlockGc(String r100) {
        if (checkHeapSizeLimit() == true) goto L5;
        return;
    L5:
        if (this.mDisabled == true) goto L23;
        HashMap<String, Integer> r101 = this.mTokens;
        monitor-enter(r101);
        Integer r102 = this.mTokens.get(r100);     // Catch: Throwable -> L17
        if (r102 != null) goto L11;
        r102 = Integer.valueOf(nativeCreateToken(false));     // Catch: Throwable -> L17
        this.mTokens.put(r100, r102);     // Catch: Throwable -> L17
    L11:
        if (r102 != null) goto L13;
    L15:
        monitor-exit(r101);     // Catch: Throwable -> L17
        return;
    L13:
        if (r102.intValue() < 0) goto L15;
        nativeStartBlockGc(r102.intValue());     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void stopBlockGc(String r100) {
        HashMap<String, Integer> r101 = this.mTokens;
        monitor-enter(r101);
        Integer r102 = this.mTokens.remove(r100);     // Catch: Throwable -> L11
        if (r102 != null) goto L7;
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L7:
        if (r102.intValue() < 0) goto L9;
        nativeStopBlockGc(r102.intValue());     // Catch: Throwable -> L11
        nativeReleaseToken(r102.intValue());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void setHeapLimit(boolean r100, int r101, int r102) {
        nativeSetHeapLimit(r100, r101, r102);
    }

    public GcBlocker(int r100, boolean r101, int r102, int r103, boolean r104) {
        this.mTokens = new HashMap();
        nativeSetIsSupportApex(r104);
        nativeSetMaxGcBlockTime(r100);
        if (r103 <= 0) goto L6;
        nativeSetHeapLimit(r101, r102, r103);
        return;
    }
}
