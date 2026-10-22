package com.bytedance.common.jato.threads;

/* JADX INFO: loaded from: classes15.dex */
public class ThreadNative {
    public ThreadNative() {
    }

    public static native void nativeBiasedMainThread(int r100, int r101, int r102, int r103);

    public static native ThreadInfo[] nativeGetAllThreadInfo(boolean r100);

    public static native int[] nativeGetThreadStats(int r100);

    public static native int nativeGetThreadTid(Thread r100);

    public static native boolean nativeResumeThread(int r100);

    public static native boolean nativeResumeThreadByName(String r100);

    public static native boolean nativeSuspendThread(int r100);

    public static native boolean nativeSuspendThreadByName(String r100);
}
