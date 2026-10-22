package com.bytedance.bdturing.livedetect.yuv;

import com.bytedance.bdturing.livedetect.camera.ImageDataWrapper;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class TuringYuv {
    public TuringYuv() {
    }

    public static native ImageDataWrapper I420ToBitmap(byte[] r100, byte[] r101, int r102, int r103, int r104);

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native String readMsg(byte[] r100);

    static {
        INVOKESTATIC_com_bytedance_bdturing_livedetect_yuv_TuringYuv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("yuv");
        INVOKESTATIC_com_bytedance_bdturing_livedetect_yuv_TuringYuv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("TuringYuvUtils");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_bdturing_livedetect_yuv_TuringYuv_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
