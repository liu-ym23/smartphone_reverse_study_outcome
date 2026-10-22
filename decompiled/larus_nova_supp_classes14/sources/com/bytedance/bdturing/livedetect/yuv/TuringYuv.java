package com.bytedance.bdturing.livedetect.yuv;

import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class TuringYuv {
    public TuringYuv() {
    }

    public static native ImageDataWrapper I420ToBitmap(byte[] r0, byte[] r1, int r2, int r3, int r4);

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static native String readMsg(byte[] r0);

    static {
        INVOKESTATIC_com_bytedance_bdturing_livedetect_yuv_TuringYuv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("yuv");
        INVOKESTATIC_com_bytedance_bdturing_livedetect_yuv_TuringYuv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("TuringYuvUtils");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_bdturing_livedetect_yuv_TuringYuv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }
}
