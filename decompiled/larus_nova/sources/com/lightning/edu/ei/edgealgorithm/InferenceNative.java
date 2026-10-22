package com.lightning.edu.ei.edgealgorithm;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public class InferenceNative {
    public static String TAG = "InferenceNative";

    public InferenceNative() {
    }

    public static native String GetVersion();

    public static native long InitByAssetManger(AssetManager r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, String r108, String r109, String r110, String r111, String r112, String r113);

    public static native Result PredictBitmap(long r100, Bitmap r101, int r102, Params r103);

    public static native Result PredictIntArray(long r100, int[] r101, int r102, int r103, int r104, Params r105);

    public static native void Release(long r100);

    public static native String Version(long r100);

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    static {
        INVOKESTATIC_com_lightning_edu_ei_edgealgorithm_InferenceNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("edge-algorithm");
        loadByteNN("bytenn");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_lightning_edu_ei_edgealgorithm_InferenceNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static void loadByteNN(String r100) {
        INVOKESTATIC_com_lightning_edu_ei_edgealgorithm_InferenceNative_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }
}
