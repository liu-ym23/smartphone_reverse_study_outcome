package com.ss.lens.algorithm;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class PictureOCLSR {
    private static boolean isLibLoaded;
    private long mNativePtr;
    private int maxHeight;
    private int maxWidth;
    private int minHeight;
    private int minWidth;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native long nativeInitPictureOclSr(String r100, int r101, int r102, int r103);

    private native int nativePictureOclSrProcess(long r100, Bitmap r101, Bitmap r102);

    private native void nativeReleasePictureOclSr(long r100);

    public void ReleasePictureOclSr() {
        long r100 = this.mNativePtr;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeReleasePictureOclSr(r100);
    }

    public PictureOCLSR() {
        this.mNativePtr = 0;
        this.maxHeight = 1080;
        this.minHeight = 500;
        this.maxWidth = 600;
        this.minWidth = 360;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public synchronized boolean InitPictureOclSr(String r100) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (isLibLoaded == true) goto L17;
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
    L31:
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L27
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
        long r101 = nativeInitPictureOclSr(r100, this.maxHeight, this.maxWidth, 4);     // Catch: Throwable -> L27
        this.mNativePtr = r101;     // Catch: Throwable -> L27
        if (r101 != 0) goto L25;
        monitor-exit(this);
        return false;
    L25:
        monitor-exit(this);
        return true;
    }

    public boolean IsSrSupport(Bitmap r100) {
        if (r100.getConfig() == Bitmap.Config.RGB_565) goto L5;
        return false;
    L5:
        int r101 = r100.getWidth();
        int r102 = r100.getHeight();
        if ((r101 % 2) != 0) goto L24;
        if ((r102 % 2) != 0) goto L24;
        if (r101 < this.minWidth) goto L22;
        if (r101 > this.maxWidth) goto L22;
        if (r102 < this.minHeight) goto L22;
        if (r102 > this.maxHeight) goto L22;
        return true;
    L22:
        return false;
    L24:
        return false;
    }

    public synchronized boolean InitPictureOclSr(String r100, int r101) {
        monitor-enter(this);
    L27:
        th = move-exception;
        throw th;
    L5:
        if (isLibLoaded == true) goto L17;
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L8 Throwable -> L27
    L31:
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L12 Throwable -> L27
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
        long r102 = nativeInitPictureOclSr(r100, this.maxHeight, this.maxWidth, r101);     // Catch: Throwable -> L27
        this.mNativePtr = r102;     // Catch: Throwable -> L27
        if (r102 != 0) goto L25;
        monitor-exit(this);
        return false;
    L25:
        monitor-exit(this);
        return true;
    }

    public synchronized int PictureOclSrProcess(Bitmap r100, Bitmap r101) {
        monitor-enter(this);
        int r102 = r100.getWidth();     // Catch: Throwable -> L31
        int r103 = r100.getHeight();     // Catch: Throwable -> L31
        if ((r102 % 2) != 0) goto L29;
        if ((r103 % 2) != 0) goto L29;
        if (r102 < this.minWidth) goto L26;
        if (r102 > this.maxWidth) goto L26;
        if (r103 < this.minHeight) goto L26;
        if (r103 > this.maxHeight) goto L26;
        int r104 = nativePictureOclSrProcess(this.mNativePtr, r100, r101);     // Catch: Throwable -> L31
        if (r104 == 0) goto L22;
        Integer.valueOf(r104).toString();     // Catch: Throwable -> L31
        monitor-exit(this);
        return -1;
    L22:
        monitor-exit(this);
        return 0;
    L26:
        monitor-exit(this);
        return -1;
    L29:
        monitor-exit(this);
        return -1;
    L31:
        th = move-exception;
        throw th;
    }

    public synchronized boolean InitPictureOclSr(String r100, int r101, int r102, int r103, int r104, int r105) {
        monitor-enter(this);
        if (r102 > r103) goto L36;
        if (r104 > r105) goto L36;
        if (r102 <= 0) goto L36;
        if (r104 <= 0) goto L36;
    L33:
        th = move-exception;
        throw th;
    L11:
        if (isLibLoaded == false) goto L38;
    L22:
        this.maxHeight = r105;     // Catch: Throwable -> L33
        this.minHeight = r104;     // Catch: Throwable -> L33
        this.maxWidth = r103;     // Catch: Throwable -> L33
        this.minWidth = r102;     // Catch: Throwable -> L33
        if (r100.isEmpty() == false) goto L26;
        monitor-exit(this);
        return false;
    L26:
        long r106 = nativeInitPictureOclSr(r100, this.maxHeight, this.maxWidth, r101);     // Catch: Throwable -> L33
        this.mNativePtr = r106;     // Catch: Throwable -> L33
        if (r106 != 0) goto L31;
        monitor-exit(this);
        return false;
    L31:
        monitor-exit(this);
        return true;
    L38:
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("c++_shared");     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L33
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bytenn");     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L33
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("fastcv");     // Catch: UnsatisfiedLinkError -> L14 Throwable -> L33
    L41:
        INVOKESTATIC_com_ss_lens_algorithm_PictureOCLSR_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("lens");     // Catch: UnsatisfiedLinkError -> L18 Throwable -> L33
        isLibLoaded = true;     // Catch: Throwable -> L33
        goto L22
    L18:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L33
    L36:
        monitor-exit(this);
        return false;
    }
}
