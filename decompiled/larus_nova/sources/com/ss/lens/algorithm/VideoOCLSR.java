package com.ss.lens.algorithm;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class VideoOCLSR {
    private static boolean isLibLoaded;
    private static LibLoaderListener mLoaderListener;
    private long mNativePtr;

    public interface LibLoaderListener {
        boolean onLoader(String r100);
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native int nativeGetVideoOclSrOutput(long r100);

    private native long nativeInitVideoOclSr(String r100, int r101, boolean r102, boolean r103, int r104, int r105);

    private native void nativeReleaseVideoOclSr(long r100);

    private native int nativeVideoOclSrOesProcess(long r100, int r101, int r102, int r103, float[] r104, boolean r105);

    private native int nativeVideoOclSrProcess(long r100, int r101, int r102, int r103, boolean r104);

    public int GetVideoOclSrOutput() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L7;
        return -1;
    L7:
        return nativeGetVideoOclSrOutput(r100);
    }

    public void ReleaseVideoOclSr() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleaseVideoOclSr(r100);
    }

    public VideoOCLSR() {
        this.mNativePtr = 0;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static synchronized void setOutLoader(LibLoaderListener r100) {
        monitor-enter(VideoOCLSR.class);
        mLoaderListener = r100;     // Catch: Throwable -> L7
        monitor-exit(VideoOCLSR.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean InitVideoOclSr(String r110, int r111, boolean r112) {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (isLibLoaded == true) goto L26;
        LibLoaderListener r100 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        if (r100 == null) goto L9;
        r100.onLoader("c++_shared");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        mLoaderListener.onLoader("fastcv");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        mLoaderListener.onLoader("bytenn");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
    L41:
    L44:
        LibLoaderListener r101 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L37
        if (r101 != null) goto L16;
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L37
    L20:
        isLibLoaded = true;     // Catch: Throwable -> L37
        goto L26
    L16:
        if (r101.onLoader("lens") == true) goto L20;
        monitor-exit(this);
        return false;
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
        return false;
    L9:
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
    L26:
        if (r110.isEmpty() == false) goto L30;
        monitor-exit(this);
        return false;
    L30:
        long r113 = nativeInitVideoOclSr(r110, r111, r112, true, 720, 1440);     // Catch: Throwable -> L37
        this.mNativePtr = r113;     // Catch: Throwable -> L37
        if (r113 != 0) goto L35;
        monitor-exit(this);
        return false;
    L35:
        monitor-exit(this);
        return true;
    }

    public int VideoOclSrProcess(int r100, int r101, int r110, boolean r111) {
        long r102 = this.mNativePtr;
        if (r102 == 0) goto L9;
        if (r101 <= 0) goto L11;
        if (r110 > 0) goto L8;
        return -1;
    L8:
        return nativeVideoOclSrProcess(r102, r100, r101, r110, r111);
    L11:
        return -1;
    L9:
        return -1;
    }

    public synchronized boolean InitVideoOclSr(String r110, int r111, boolean r112, int r113, int r114) {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L5:
        if (isLibLoaded == true) goto L26;
        LibLoaderListener r100 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        if (r100 == null) goto L9;
        r100.onLoader("c++_shared");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        mLoaderListener.onLoader("fastcv");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        mLoaderListener.onLoader("bytenn");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
    L40:
    L43:
        LibLoaderListener r101 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L37
        if (r101 != null) goto L16;
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L37
    L20:
        isLibLoaded = true;     // Catch: Throwable -> L37
        goto L26
    L16:
        if (r101.onLoader("lens") == true) goto L20;
        monitor-exit(this);
        return false;
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
        return false;
    L9:
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L37
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L37
    L26:
        if (r110.isEmpty() == false) goto L30;
        monitor-exit(this);
        return false;
    L30:
        long r115 = nativeInitVideoOclSr(r110, r111, r112, true, r113, r114);     // Catch: Throwable -> L37
        this.mNativePtr = r115;     // Catch: Throwable -> L37
        if (r115 != 0) goto L35;
        monitor-exit(this);
        return false;
    L35:
        monitor-exit(this);
        return true;
    }

    public int VideoOclSrOesProcess(int r100, int r110, int r111, float[] r112, boolean r113) {
        long r101 = this.mNativePtr;
        if (r101 == 0) goto L9;
        if (r110 <= 0) goto L11;
        if (r111 > 0) goto L8;
        return -1;
    L8:
        return nativeVideoOclSrOesProcess(r101, r100, r110, r111, r112, r113);
    L11:
        return -1;
    L9:
        return -1;
    }

    public synchronized boolean InitVideoOclSr(String r100, int r101, boolean r102, boolean r103, int r104, int r110) {
        monitor-enter(this);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (isLibLoaded == true) goto L26;
        LibLoaderListener r105 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L36
        if (r105 == null) goto L9;
        r105.onLoader("c++_shared");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L36
        mLoaderListener.onLoader("fastcv");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L36
        mLoaderListener.onLoader("bytenn");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L36
    L39:
    L43:
        LibLoaderListener r106 = mLoaderListener;     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L36
        if (r106 != null) goto L16;
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L21 Throwable -> L36
    L20:
        isLibLoaded = true;     // Catch: Throwable -> L36
        goto L26
    L16:
        if (r106.onLoader("lens") == true) goto L20;
        monitor-exit(this);
        return false;
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L36
        return false;
    L9:
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L36
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L36
        INVOKESTATIC_com_ss_lens_algorithm_VideoOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L11 Throwable -> L36
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L36
    L26:
        if (r100.isEmpty() == false) goto L29;
        monitor-exit(this);
        return false;
    L29:
        long r107 = nativeInitVideoOclSr(r100, r101, r102, r103, r104, r110);     // Catch: Throwable -> L36
        this.mNativePtr = r107;     // Catch: Throwable -> L36
        if (r107 != 0) goto L34;
        monitor-exit(this);
        return false;
    L34:
        monitor-exit(this);
        return true;
    }
}
