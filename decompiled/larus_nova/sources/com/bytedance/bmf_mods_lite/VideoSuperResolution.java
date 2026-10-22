package com.bytedance.bmf_mods_lite;

import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.android.agilelogger.ALog;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class VideoSuperResolution {
    private native long nativeCreateSuperResolution();

    private native int nativeInitSuperResolution(long r100, int r101, int r102, int r103, int r104, int r105, int r106, String r107, String r110, String r111);

    private native void nativeReleaseSuperResolution(long r100);

    private native int nativeSuperResolutionGetResultTexture(long r100);

    private native int nativeSuperResolutionOesProcess(long r100, int r101, float[] r102, int r103, int r104, int r105, int r106, int r107, int r110, int r111, long r112);

    private native int nativeSuperResolutionOesProcessMultiScale(long r100, int r101, float[] r102, int r103, int r104, int r105, int r106, int r107, int r110, int r111, long r112, int r113, int r114);

    private native int nativeSuperResolutionProcess(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110, long r111);

    private native int nativeSuperResolutionProcessBitmap(long r100, Bitmap r101, Bitmap r102);

    private native int nativeSuperResolutionProcessMultiScale(long r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110, long r111, int r112, int r113);

    private native int nativeSuperResolutionProcessYuv(long r100, long r101, long r102, long r103, int r104, int r110, int r111, int r112);

    static {
        a();     // Catch: Throwable -> L5
        ALog.i("bmf VideoSuperResolution", "VideoSuperResolution is initialized");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        ALog.i("bmf VideoSuperResolution", "VideoSuperResolution initialize occurs error, the msg = " + th.getMessage());
    }

    @JvmStatic
    public static void a() {
        Intrinsics.checkNotNullParameter("bmf_hydra_lite", "libName");
        FLogger r100 = FLogger.f375446a;
        r100.i("Librarian_loadLib", "loadLibrary start libName -> bmf_hydra_lite");
        a.c("bmf_hydra_lite");
        r100.i("Librarian_loadLib", "loadLibrary success by librarian -> bmf_hydra_lite");
    }

    public VideoSuperResolution() {
        ALog.i("bmf VideoSuperResolution", "New VideoSuperResolution");
    }
}
