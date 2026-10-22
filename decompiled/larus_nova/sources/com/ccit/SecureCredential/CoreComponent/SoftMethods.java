package com.ccit.SecureCredential.CoreComponent;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public class SoftMethods {
    private static SoftMethods jni;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public native int SOFCheckCertstate();

    public native int SOFDeleteCert(String r100, String r101, String r102);

    public native String SOFEncrypt(String r100, int r101, String r102, int r103, String r104, int r105);

    public native String SOFGenCSR(String r100, String r101, String r102, String r103, int r104);

    public native String SOFGenPartPubkey(String r100, String r101, String r102, String r103, int r104, String r105, int r106);

    public native String SOFGetCertInfo(String r100, int r101, String r102, String r103, int r104);

    public native int SOFImportCert(String r100, String r101, String r102, String r103);

    public native int SOFImportQ1(String r100, String r101, String r102, String r103, int r104, String r105, int r106);

    public native int SOFImportServerCert(String r100);

    public native String SOFInitialize(String r100, int r101, String r102, String r103, String r104, String r105, int r106, String r107, String r108);

    public native String SOFPartSign(String r100, String r101, String r102, String r103, int r104);

    public native String SOFPartSignNew(String r100, int r101, String r102, String r103, String r104, String r105, String r106, int r107, String r108, int r110);

    static {
        jni = new SoftMethods();
    }

    private SoftMethods() {
        INVOKESTATIC_com_ccit_SecureCredential_CoreComponent_SoftMethods_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("CoreCpt");
    }

    public static SoftMethods getInstance() {
        return jni;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ccit_SecureCredential_CoreComponent_SoftMethods_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
