package com.bytedance.apm.profiler;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class Profiler {
    private static native boolean nAttachThread(int r0);

    private static native boolean nCheck();

    private static native void nClear();

    private static native boolean nDetachThread(int r0);

    private static native String nDump(long r0, long r2);

    private static native String nGetStack(int r0);

    private static native boolean nInit();

    private static native void nSetAlog(long r0);

    private static native boolean nStart(int r0);

    private static native boolean nStop();

    static {
        new AtomicReference(null);
    }

    public Profiler() {
    }
}
