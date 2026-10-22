package com.bytedance.bdturing.live;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TuringLive {
    private static volatile TuringLive sInstance;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public native String detectImg(byte[] r1, float[] r2);

    public native int init(Config r1);

    public native int release();

    public String versionName() {
        return "1.0.0";
    }

    static {
        INVOKESTATIC_com_bytedance_bdturing_live_TuringLive_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("turing_live");
    }

    public static TuringLive getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(TuringLive.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TuringLive();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TuringLive.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TuringLive() {
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_bdturing_live_TuringLive_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }
}
