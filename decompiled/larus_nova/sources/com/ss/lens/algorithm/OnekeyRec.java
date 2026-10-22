package com.ss.lens.algorithm;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class OnekeyRec {
    private static boolean isLibLoaded;
    private long mNativePtr;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native int nativeGetOnekeyRecOutput(long r100);

    private native long nativeInitOnekeyRec(String r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, int r107, int r108);

    private native int nativeOnekeyRecProcess(long r100, int r101, int r102, int r103, float[] r104, boolean r105);

    private native void nativeReleaseOnekeyRec(long r100);

    public int GetOnekeyRecOutput() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return nativeGetOnekeyRecOutput(r100);
    }

    public void ReleaseOnekeyRec() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseOnekeyRec(r100);
    }

    public OnekeyRec() {
        this.mNativePtr = 0;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_OnekeyRec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public int OnekeyRecProcess(int r100, int r110, int r111, float[] r112, boolean r113) {
        long r101 = this.mNativePtr;
        if (r101 == 0) goto L9;
        if (r110 <= 0) goto L11;
        if (r111 > 0) goto L8;
        return -1;
    L8:
        return nativeOnekeyRecProcess(r101, r100, r110, r111, r112, r113);
    L11:
        return -1;
    L9:
        return -1;
    }

    public synchronized boolean InitOnekeyRec(String r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r110, int r111, int r112) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (isLibLoaded == true) goto L17;
        INVOKESTATIC_com_ss_lens_algorithm_OnekeyRec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
        INVOKESTATIC_com_ss_lens_algorithm_OnekeyRec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
        INVOKESTATIC_com_ss_lens_algorithm_OnekeyRec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
    L31:
        INVOKESTATIC_com_ss_lens_algorithm_OnekeyRec_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L27
        isLibLoaded = true;     // Catch: Throwable -> L27
        goto L17
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L27
    L17:
        if (r100.isEmpty() == false) goto L20;
        monitor-exit(this);
        return false;
    L20:
        long r106 = nativeInitOnekeyRec(r100, r101, r102, r103, r104, r105, r110, r111, r112);     // Catch: Throwable -> L27
        this.mNativePtr = r106;     // Catch: Throwable -> L27
        if (r106 != 0) goto L25;
        monitor-exit(this);
        return false;
    L25:
        monitor-exit(this);
        return true;
    }
}
