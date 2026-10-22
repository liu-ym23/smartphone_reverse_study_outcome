package com.bytedance.common.jato.debug;

/* JADX INFO: loaded from: classes15.dex */
public class DebugOptimizer {
    public DebugOptimizer() {
    }

    public static native void closeArtMethodExitHook();

    public static native void closeInstrumentationCrashFix();

    private static native void openArtMethodExitHook();

    private static native void openInstrumentationCrashFix();
}
