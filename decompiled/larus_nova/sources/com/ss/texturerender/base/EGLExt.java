package com.ss.texturerender.base;

import android.hardware.HardwareBuffer;
import android.opengl.EGLDisplay;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.texturerender.TextureRenderLog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class EGLExt {
    private static boolean isLibLoaded;

    public EGLExt() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native int nAddReleaseFence();

    private static native int nBindHardwareBufferToTexture(long r100, HardwareBuffer r101, int r102, int r103);

    private static native long nCreateEGLImage(HardwareBuffer r100);

    private static native HardwareBuffer nCreateHardwareBuffer(int r100, int r101, int r102, int r103, long r104);

    private static native long nCreateHardwareBufferEglPool(int r100);

    private static native void nDestroyEGLImage(long r100);

    private static native void nDestroyHardwareBuffer(HardwareBuffer r100);

    private static native void nDestroyHardwareBufferEglPool(long r100);

    private static native int nGetOrCreateTextureByHardwareBuffer(long r100, HardwareBuffer r101, int r102, int r103, int r104);

    private static native int nGetTextureByHardwareBuffer(long r100, HardwareBuffer r101, int r102, int r103, int r104, int r105);

    private static native int nGlEGLImageTargetTexture2DOES(int r100, long r101);

    private static native int nSyncForRelease(int r100, long r101);

    static {
        INVOKESTATIC_com_ss_texturerender_base_EGLExt_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("texturerender_native");     // Catch: Throwable -> L5 Exception -> L7
    L4:
        TextureRenderLog.d(-1, "EGLExt", "load texturerender_native success");
        isLibLoaded = true;
        return;
    L5:
        th = move-exception;
        TextureRenderLog.d(-1, "EGLExt", "load texturerender_native success");
        isLibLoaded = true;
        throw th;
    L7:
        e = move-exception;
        TextureRenderLog.e(-1, "EGLExt", "load texturerender_native fail,error:" + e.toString());     // Catch: Throwable -> L5
        goto L4
    }

    public static int addReleaseFence() {
        return nAddReleaseFence();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_texturerender_base_EGLExt_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static long createEGLImage(HardwareBuffer r100) {
        return nCreateEGLImage(r100);
    }

    public static long createHardwareBufferEglPool(int r100) {
        if (isLibLoaded == false) goto L8;
        if (r100 > 0) goto L7;
        return -1;
    L7:
        return nCreateHardwareBufferEglPool(r100);
    L8:
        return -1;
    }

    public static void destroyEGLImage(long r100) {
        nDestroyEGLImage(r100);
    }

    public static void destroyHardwareBuffer(HardwareBuffer r100) {
        nDestroyHardwareBuffer(r100);
    }

    public static void destroyHardwareBufferEglPool(long r100) {
        if (r100 == 0) goto L6;
        nDestroyHardwareBufferEglPool(r100);
        return;
    }

    public static int glEGLImageTargetTexture2DOES(int r100, long r101) {
        return nGlEGLImageTargetTexture2DOES(r100, r101);
    }

    public static int syncForRelease(int r100, long r101) {
        return nSyncForRelease(r100, r101);
    }

    public static int bindHardwareBufferToTexture(EGLDisplay r100, HardwareBuffer r101, int r102, int r103) {
        if (r100 == null) goto L10;
        if (r101 == null) goto L12;
        if (r102 != 0) goto L6;
        return -1;
    L6:
        if (isLibLoaded == true) goto L9;
        return -1;
    L9:
        return nBindHardwareBufferToTexture(r100.getNativeHandle(), r101, r102, r103);
    L12:
        return -1;
    L10:
        return -1;
    }

    public static HardwareBuffer createHardwareBuffer(int r100, int r101, int r102, int r103, long r104) {
        return nCreateHardwareBuffer(r100, r101, r102, r103, r104);
    }

    public static int getOrCreateTextureByHardwareBuffer(long r100, HardwareBuffer r101, int r102, int r103, int r104) {
        if (r100 == 0) goto L8;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return nGetOrCreateTextureByHardwareBuffer(r100, r101, r102, r103, r104);
    L8:
        return -1;
    }

    public static int getTextureByHardwareBuffer(long r100, HardwareBuffer r101, int r102, int r103, int r104, int r105) {
        if (r100 == 0) goto L8;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return nGetTextureByHardwareBuffer(r100, r101, r102, r103, r104, r105);
    L8:
        return -1;
    }
}
