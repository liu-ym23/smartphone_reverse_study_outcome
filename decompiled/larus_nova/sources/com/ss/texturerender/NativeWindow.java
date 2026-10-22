package com.ss.texturerender;

import android.view.Surface;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public class NativeWindow {
    private static boolean isLibLoaded;
    private final String TAG;
    private long mHandle;
    private Surface mSurface;
    private int mTexType;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native int nativeGetFormat(Surface r100);

    private static native int nativeGetHeight(long r100);

    private static native int nativeGetSurfaceFormat(long r100);

    private static native int nativeGetWidth(long r100);

    private static native int nativeReleaseSurface(long r100);

    private static native int nativeSetBuffersGeometry(long r100, int r101, int r102, int r103);

    private static native long nativeSetSurface(Surface r100);

    static {
        INVOKESTATIC_com_ss_texturerender_NativeWindow_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("texturerender_native");     // Catch: Throwable -> L5 Exception -> L7
    L4:
        TextureRenderLog.d(-1, "TR_NativeWindow", "load texturerender_native success");
        isLibLoaded = true;
        return;
    L5:
        th = move-exception;
        TextureRenderLog.d(-1, "TR_NativeWindow", "load texturerender_native success");
        isLibLoaded = true;
        throw th;
    L7:
        e = move-exception;
        TextureRenderLog.e(-1, "TR_NativeWindow", "load texturerender_native fail,error:" + e.toString());     // Catch: Throwable -> L5
        goto L4
    }

    public int getHeight() {
        long r100 = this.mHandle;
        if (r100 > 0) goto L7;
        return -1;
    L7:
        return nativeGetHeight(r100);
    }

    public int getSurfaceFormat() {
        long r100 = this.mHandle;
        if (r100 > 0) goto L7;
        return -1;
    L7:
        return nativeGetSurfaceFormat(r100);
    }

    public int getWidth() {
        long r100 = this.mHandle;
        if (r100 > 0) goto L7;
        return -1;
    L7:
        return nativeGetWidth(r100);
    }

    public int releaseWindow() {
        long r100 = this.mHandle;
        if (r100 > 0) goto L6;
        return -1;
    L6:
        int r101 = nativeReleaseSurface(r100);
        this.mHandle = 0;
        return r101;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_texturerender_NativeWindow_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static int getFormat(Surface r100) {
        if (isLibLoaded == true) goto L7;
        TextureRenderLog.d(-1, "TR_NativeWindow", "lib not loaded");
        return -1;
    L7:
        return nativeGetFormat(r100);
    }

    public NativeWindow(int r100, Surface r101) {
        this.mSurface = null;
        this.mHandle = 0;
        String r102 = TextureRenderLog.getLogTag(this);
        this.TAG = r102;
        if (isLibLoaded == true) goto L6;
        TextureRenderLog.d(this.mTexType, r102, "lib not loaded");
        return;
    L6:
        this.mSurface = r101;
        this.mHandle = nativeSetSurface(r101);
        this.mTexType = r100;
    }

    public int setBuffersGeometry(int r100, int r101, int r102) {
        if (this.mHandle > 0) goto L6;
        return -1;
    L6:
        TextureRenderLog.d(this.mTexType, this.TAG, "setBuffersGeometry,w:" + r100 + ",h:" + r101 + ",fmt:" + r102);
        return nativeSetBuffersGeometry(this.mHandle, r100, r101, r102);
    }
}
