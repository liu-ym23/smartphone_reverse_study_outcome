package com.ss.android.ttve.nativePort;

/* JADX INFO: loaded from: classes38.dex */
public class TELogcat {
    public TELogcat() {
    }

    private static native void nativeLog(byte r100, String r101, String r102);

    private static native void nativeSetLogLevel(byte r100);

    private static native void nativeSetLogWriteFunction(long r100);

    static {
        TECodecNativeLibsLoader.LoadStatus r100 = TECodecNativeLibsLoader.f449953a;
        monitor-enter(TECodecNativeLibsLoader.class);
        TECodecNativeLibsLoader.d();     // Catch: Throwable -> L7
        monitor-exit(TECodecNativeLibsLoader.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setLogLevel(byte r100) {
        nativeSetLogLevel(r100);
    }

    public static void setLogWriteFunction(long r100) {
        nativeSetLogWriteFunction(r100);
    }

    public static void Log(byte r100, String r101, String r102) {
        nativeLog(r100, r101, r102);
    }
}
