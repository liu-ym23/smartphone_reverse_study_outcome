package com.bytedance.bdinstall.nativeManager;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class NativeLogManager {
    public NativeLogManager() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native String getDA0Result(String r100);

    public static native int[] getDI0Result(String[] r100);

    public static native String getDM0Result(String r100);

    public static native String getDSSL0Result();

    public static native byte[] getMMMapResult(Map<String, JSONObject> r100, int r101, int r102, String r103);

    static {
        INVOKESTATIC_com_bytedance_bdinstall_nativeManager_NativeLogManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("nativelog");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_bdinstall_nativeManager_NativeLogManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
