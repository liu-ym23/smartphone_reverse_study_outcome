package com.bytedance.common.jato.memory;

/* JADX INFO: loaded from: classes15.dex */
public class NonMovingSpaceOpt {
    public NonMovingSpaceOpt() {
    }

    private static native boolean optimizeNonMovingSpace(int r100, int r101);

    public static native void printHeapStatus();
}
