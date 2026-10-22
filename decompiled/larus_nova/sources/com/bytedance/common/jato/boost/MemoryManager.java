package com.bytedance.common.jato.boost;

/* JADX INFO: loaded from: classes15.dex */
public class MemoryManager {
    public MemoryManager() {
    }

    private static native void nativePagePreFault(int r100, int r101, boolean r102, boolean r103);
}
