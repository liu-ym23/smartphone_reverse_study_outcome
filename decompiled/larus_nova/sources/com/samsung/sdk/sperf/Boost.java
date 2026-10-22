package com.samsung.sdk.sperf;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
class Boost {
    private static final int ERROR = -1;
    private static final String NATIVE_BOOST_LIBRARY_NAME = "perfsdk.performance.samsung";
    private static boolean isLoadLib;

    public Boost() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static boolean init() {
        if (isLoadLib == false) goto L15;
        return true;
    L15:
        INVOKESTATIC_com_samsung_sdk_sperf_Boost_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(NATIVE_BOOST_LIBRARY_NAME);     // Catch: Exception -> L8 UnsatisfiedLinkError -> L10
        isLoadLib = true;     // Catch: Exception -> L8 UnsatisfiedLinkError -> L10
    L14:
        return isLoadLib;
    L8:
        e = move-exception;
        SPerfUtil.log("Library has problem");
        e.printStackTrace();
    L12:
        isLoadLib = false;
    L10:
        e = move-exception;
        SPerfUtil.log("ERROR : Library load fail.. not exist or check permission");
        e.printStackTrace();
        goto L12
    }

    public static native int releaseBoost();

    public static native int releaseBoost(int r100);

    public static int releaseNativeBoost() {
        if (isLoadLib == true) goto L6;
        SPerfUtil.log("ERR : Native Library load Fail... request boost not available");
        return -1;
    L6:
        releaseBoost();
        SPerfUtil.log("release all boost");
        int r100 = 0;
    L8:
        if (r100 >= 11) goto L19;
        BoostResource r101 = BoostLevelControl.getBoostResource(r100);
        if (r101 == null) goto L18;
        int r102 = r101.getDefaultLevel();
        if (r102 == 64532198) goto L18;
        int r103 = BoostLevelControl.getRealBoostLevel(r102, r100);
        if (CustomParams.getBoostType(r100) != 1) goto L17;
        requestBoost(r100, r103, PerformanceManager.getPid());
        goto L18
    L17:
        requestBoost(r100, r103, 0);
    L18:
        r100 = r100 + 1;
        goto L8
    L19:
        return 0;
    }

    public static int releaseNativeBoost(int r100, int r101) {
        if (isLoadLib == true) goto L6;
        SPerfUtil.log("ERR : Native Library load Fail... request boost not available");
        return -1;
    L6:
        BoostResource r102 = BoostLevelControl.getBoostResource(r100);
        if (r102 != null) goto L9;
        return -1;
    L9:
        int r103 = r102.getDefaultLevel();
        if (r103 != 64532198) goto L12;
        releaseBoost(r100);
    L16:
        SPerfUtil.log("release all boost");
        return 0;
    L12:
        int r104 = BoostLevelControl.getRealBoostLevel(r103, r100);
        if (r101 >= 0) goto L15;
        requestBoost(r100, r104, 0);
        goto L16
    L15:
        requestBoost(r100, r104, r101);
        goto L16
    }

    public static native int requestBoost(int r100, int r101, int r102);

    public static int requestNativeBoost(BoostObject r100) {
        if (isLoadLib == true) goto L6;
        SPerfUtil.log("ERR : Native Library load Fail... request boost not available");
        return -1;
    L6:
        int r101 = 0;
    L8:
        if (r101 >= 11) goto L20;
        int r102 = BoostLevelControl.getRealBoostLevel(r100, r101);
        int r103 = r100.getTimeout(r101);
        if (r102 == 64532198) goto L19;
        if (r103 == 64532198) goto L19;
        if (r103 != 99999999) goto L15;
        r103 = -1;
    L15:
        SPerfUtil.log("acquire boost - type : " + r101 + "   value : " + r102 + "   timeouts : " + r103);
        if (CustomParams.getBoostType(r101) != 1) goto L18;
        r103 = PerformanceManager.getPid();
        SPerfManager.startTaskReleaseHandler(r101, r103);
    L18:
        requestBoost(r101, r102, r103);
    L19:
        r101 = r101 + 1;
        goto L8
    L20:
        return 0;
    }

    public static int requestNativeBoostForProcess(BoostObject r100) {
        if (isLoadLib == true) goto L6;
        SPerfUtil.log("ERR : Native Library load Fail... request boost not available");
        return -1;
    L6:
        int r101 = 0;
    L8:
        if (r101 >= 11) goto L17;
        int r102 = BoostLevelControl.getRealBoostLevel(r100, r101);
        int r103 = r100.getTimeout(r101);
        if (r102 == 64532198) goto L16;
        if (r103 == 64532198) goto L16;
        if (r103 != 99999999) goto L15;
        r103 = -1;
    L15:
        SPerfUtil.log("acquire boost - type : " + r101 + "   value : " + r102 + "   timeouts : " + r103);
        requestBoost(r101, r102, r103);
    L16:
        r101 = r101 + 1;
        goto L8
    L17:
        return 0;
    }

    public static int setNativePkgName(String r100) {
        if (r100 != null) goto L5;
        SPerfUtil.log("ERR : PkgName is Null.. check it again");
        return -1;
    L5:
        setPkgName(r100);
        SPerfUtil.log("Unique Pkg Name set : ".concat(r100));
        return 0;
    }

    public static native int setPkgName(String r100);

    @JvmStatic
    public static void INVOKESTATIC_com_samsung_sdk_sperf_Boost_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
