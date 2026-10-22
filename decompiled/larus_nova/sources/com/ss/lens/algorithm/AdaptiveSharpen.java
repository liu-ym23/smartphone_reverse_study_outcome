package com.ss.lens.algorithm;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class AdaptiveSharpen {
    private static boolean isLibLoaded;
    private long mNativePtr;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native int nativeAdaptiveSharpenProcess(long r100, int r101, int r102, int r103, float[] r104, boolean r105, int r106, float r107, float r110, float r111, int r112);

    private native int nativeGetAdaptiveSharpenOutput(long r100);

    private native long nativeInitAdaptiveSharpen(boolean r100, int r101, int r102, int r103);

    private native void nativeReleaseAdaptiveSharpen(long r100);

    public int GetAdaptiveSharpenOutput() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return nativeGetAdaptiveSharpenOutput(r100);
    }

    public void ReleaseAdaptiveSharpen() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseAdaptiveSharpen(r100);
    }

    public AdaptiveSharpen() {
        this.mNativePtr = 0;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_AdaptiveSharpen_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public synchronized boolean InitAdaptiveSharpen(boolean r100, int r101, int r102, int r103) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (isLibLoaded == false) goto L29;
    L16:
        long r104 = nativeInitAdaptiveSharpen(r100, r101, r102, r103);     // Catch: Throwable -> L23
        this.mNativePtr = r104;     // Catch: Throwable -> L23
        if (r104 != 0) goto L21;
        monitor-exit(this);
        return false;
    L21:
        monitor-exit(this);
        return true;
    L29:
        INVOKESTATIC_com_ss_lens_algorithm_AdaptiveSharpen_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L23
        INVOKESTATIC_com_ss_lens_algorithm_AdaptiveSharpen_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L23
        INVOKESTATIC_com_ss_lens_algorithm_AdaptiveSharpen_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L23
    L26:
        INVOKESTATIC_com_ss_lens_algorithm_AdaptiveSharpen_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L23
        isLibLoaded = true;     // Catch: Throwable -> L23
        goto L16
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        return false;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
        goto L26
    }

    public int AdaptiveSharpenProcess(int r110, int r111, int r112, boolean r113, int r114, float r210, float r211, float r212, int r213) {
        long r100 = this.mNativePtr;
        if (r100 == 0) goto L9;
        if (r111 <= 0) goto L11;
        if (r112 > 0) goto L8;
        return -1;
    L8:
        return nativeAdaptiveSharpenProcess(r100, r110, r111, r112, null, r113, r114, r210, r211, r212, r213);
    L11:
        return -1;
    L9:
        return -1;
    }

    public int AdaptiveSharpenOesProcess(int r110, int r111, int r112, float[] r113, boolean r114, int r210, float r211, float r212, float r213, int r214) {
        long r100 = this.mNativePtr;
        if (r100 == 0) goto L9;
        if (r111 <= 0) goto L11;
        if (r112 > 0) goto L8;
        return -1;
    L8:
        return nativeAdaptiveSharpenProcess(r100, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214);
    L11:
        return -1;
    L9:
        return -1;
    }
}
