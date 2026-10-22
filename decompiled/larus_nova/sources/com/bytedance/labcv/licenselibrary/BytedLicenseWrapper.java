package com.bytedance.labcv.licenselibrary;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class BytedLicenseWrapper implements BytedLicenseInterface {
    private HttpRequestProvider _provider;
    private long mNativeWrapperPtr;

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native void nativeClearParams();

    private native int nativeGetInstanceWithParam(HashMap<String, String> r100);

    private native int nativeGetLicenseWithParams(HashMap<String, String> r100, boolean r101, LicenseCallback r102);

    private native String nativeGetParam(String r100);

    private native void nativeSetParam(String r100, String r101);

    private native int nativeUpdateLicenseWithParams(HashMap<String, String> r100, boolean r101, LicenseCallback r102);

    static {
        INVOKESTATIC_com_bytedance_labcv_licenselibrary_BytedLicenseWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("effect");     // Catch: UnsatisfiedLinkError -> L4
        System.err.println("licenseWrapper_jni: library load!");     // Catch: UnsatisfiedLinkError -> L4
        return;
    L4:
        e = move-exception;
        System.err.println("WARNING: licenseWrapper_jni Could not load library!");
        System.err.print(e);
    }

    @Override // com.bytedance.labcv.licenselibrary.BytedLicenseInterface
    public void clearParams() {
        nativeClearParams();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_labcv_licenselibrary_BytedLicenseWrapper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Override // com.bytedance.labcv.licenselibrary.BytedLicenseInterface
    public String getParam(String r100) {
        return nativeGetParam(r100);
    }

    @Override // com.bytedance.labcv.licenselibrary.BytedLicenseInterface
    public void registerHttpProvider(HttpRequestProvider r100) {
        this._provider = r100;
    }

    public BytedLicenseWrapper(HashMap<String, String> r100, HttpRequestProvider r101) {
        this.mNativeWrapperPtr = 0;
        this._provider = r101;
        nativeGetInstanceWithParam(r100);
    }

    @Override // com.bytedance.labcv.licenselibrary.BytedLicenseInterface
    public void setParam(String r100, String r101) {
        nativeSetParam(r100, r101);
    }

    @Override // com.bytedance.labcv.licenselibrary.BytedLicenseInterface
    public int getLicenseWithParams(HashMap<String, String> r100, boolean r101, LicenseCallback r102) {
        return nativeGetLicenseWithParams(r100, r101, r102);
    }

    @Override // com.bytedance.labcv.licenselibrary.BytedLicenseInterface
    public int updateLicenseWithParams(HashMap<String, String> r100, boolean r101, LicenseCallback r102) {
        return nativeUpdateLicenseWithParams(r100, r101, r102);
    }
}
