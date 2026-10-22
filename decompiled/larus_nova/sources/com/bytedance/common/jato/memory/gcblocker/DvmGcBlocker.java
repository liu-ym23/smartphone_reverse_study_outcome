package com.bytedance.common.jato.memory.gcblocker;

/* JADX INFO: loaded from: classes15.dex */
public class DvmGcBlocker extends AbsGcBlocker {
    private static native void nativeDalvikStartBlockGc();

    private static native void nativeDalvikStopBlockGc();

    private static native void nativeInit();

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void requestBlockGc(long r100) {
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void setHeapLimit(boolean r100, int r101, int r102) {
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void setMaxGcBlockDuration(int r100) {
    }

    public DvmGcBlocker() {
        nativeInit();     // Catch: UnsatisfiedLinkError -> L5
        return;
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void startBlockGc(String r100) {
        nativeDalvikStartBlockGc();     // Catch: UnsatisfiedLinkError -> L4
        return;
    }

    @Override // com.bytedance.common.jato.memory.gcblocker.AbsGcBlocker
    public void stopBlockGc(String r100) {
        nativeDalvikStopBlockGc();     // Catch: UnsatisfiedLinkError -> L4
        return;
    }
}
