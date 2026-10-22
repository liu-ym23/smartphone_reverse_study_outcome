package com.bytedance.security.Sword;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public class Sword {
    public static final int BC_METHOD_AES_CBC_KS_v1 = 1;
    public static final int BC_METHOD_AES_CBC_KS_v2 = 20;
    public static final int BC_METHOD_RC4_KS = 3;

    public Sword() {
    }

    public static native byte[] GenKeySeed();

    public static native int GetCryptoMethod();

    public static native int IsSupportedMethod(int r100);

    public static native byte[] WBCKGenKeySeed();

    public static native int WBCKGetCryptoMethod();

    public static native byte[] WBCKPacked(byte[] r100, int r101, byte[] r102, int r103);

    public static native byte[] WBCKPackedNaked(byte[] r100, int r101, byte[] r102, int r103);

    public static native byte[] WBCKUnpacked(byte[] r100, int r101, byte[] r102);

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native byte[] clientPacked(byte[] r100, int r101);

    public static native String clientPackedBase64(byte[] r100, int r101);

    public static native byte[] clientPackedNaked(byte[] r100, int r101, int r102, byte[] r103);

    public static native String clientPackedNakedBase64(byte[] r100, int r101, int r102, byte[] r103);

    public static native byte[] clientUnpacked(byte[] r100, int r101);

    public static native byte[] clientUnpackedBase64(String r100);

    public static native byte[] clientUnpackedNaked(byte[] r100, int r101, int r102, byte[] r103);

    public static native byte[] clientUnpackedNakedBase64(String r100, int r101, String r102);

    static {
        INVOKESTATIC_com_bytedance_security_Sword_Sword_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bdsword");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_security_Sword_Sword_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
