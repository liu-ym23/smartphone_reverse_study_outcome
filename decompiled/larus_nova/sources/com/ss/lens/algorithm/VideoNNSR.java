package com.ss.lens.algorithm;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class VideoNNSR {
    private long mNativePtr;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native int nativeGetVideoNNSrOutput(long r100);

    private native long nativeInitVideoNNSr(int r100, int r101, String r102, String r103, String r104, boolean r105);

    private native void nativeReleaseVideoNNSr(long r100);

    private native int nativeVideoNNSrOesProcess(long r100, int r101, float[] r102, boolean r103);

    private native int nativeVideoNNSrProcess(long r100, int r101, boolean r102);

    static {
        INVOKESTATIC_com_ss_lens_algorithm_VideoNNSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L4
        INVOKESTATIC_com_ss_lens_algorithm_VideoNNSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L4
        INVOKESTATIC_com_ss_lens_algorithm_VideoNNSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L4
    L13:
        INVOKESTATIC_com_ss_lens_algorithm_VideoNNSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public int GetVideoNNSrOutput() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return nativeGetVideoNNSrOutput(r100);
    }

    public void ReleaseVideoNNSr() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseVideoNNSr(r100);
    }

    public VideoNNSR() {
        this.mNativePtr = 0;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_VideoNNSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public int VideoNNSrProcess(int r100, boolean r101) {
        long r102 = this.mNativePtr;
        if (r102 != 0) goto L7;
        return -1;
    L7:
        return nativeVideoNNSrProcess(r102, r100, r101);
    }

    public int VideoNNSrOesProcess(int r100, float[] r101, boolean r102) {
        long r103 = this.mNativePtr;
        if (r103 != 0) goto L7;
        return -1;
    L7:
        return nativeVideoNNSrOesProcess(r103, r100, r101, r102);
    }

    public boolean InitVideoNNSr(int r100, int r101, String r102, String r103, String r104, boolean r105) {
        if (r100 <= 0) goto L17;
        if (r101 <= 0) goto L17;
        if (r102.isEmpty() == true) goto L17;
        if (r103.isEmpty() == true) goto L17;
        if (r104.isEmpty() == true) goto L17;
        long r106 = nativeInitVideoNNSr(r100, r101, r102, r103, r104, r105);
        this.mNativePtr = r106;
        if (r106 != 0) goto L15;
        return false;
    L15:
        return true;
    L17:
        return false;
    }
}
