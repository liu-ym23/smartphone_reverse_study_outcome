package com.ss.android.ttve.log;

import com.ss.android.ttve.nativePort.TECodecNativeLibsLoader;
import qgc.a;

/* JADX INFO: loaded from: classes38.dex */
public class TELog2ClientInvoker {
    public TELog2ClientInvoker() {
    }

    public static native void nativeInit();

    public static native void nativeSetIsToLogcat(boolean r100);

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

    public static boolean onNativeCallback_checkJni(byte[] r100) {
        if (r100 == null) goto L6;
        r100[0] = 1;
        return true;
    L6:
        a.a(4, "onCheckJni data is null");
        return false;
    }

    public static void onNativeCallback_logToLocal(int r100, String r101) {
        a.a(r100, r101);
    }
}
