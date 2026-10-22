package com.ss.mediakit.medialoader;

import com.larus.utils.logger.FLogger;
import com.ss.mediakit.vcnlib.VcnlibloadWrapper;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
class AVMDLLibraryManager {
    private static final String BaseLibName = "avmdlbase";
    private static final String CryptoName = "ttcrypto";
    public static final int MediaLoadBase = 4;
    public static final int MediaLoadBoringssl = 32;
    public static final int MediaLoadP2P = 1;
    public static final int MediaLoadTTNet = 2;
    public static final int MediaLoadV1 = 8;
    public static final int MediaLoadV2 = 16;
    public static final int MediaLoadVcn = 64;
    private static final String P2PLibName = "avmdlp2p";
    private static final String SSLName = "ttboringssl";
    private static final String ShadowVerName = "avmdls";
    private static final String TTNetLibName = "avmdlttnet";
    private static final String V1LibName = "avmdl";
    private static final String V2LibName = "avmdlv2";
    private static final String VcnName = "vcn";
    private static boolean dependBoringSSl = true;
    private static boolean dependVcn = true;
    private static boolean enableV2 = false;
    private static IAVMDLLibraryLoader libraryLoader = null;
    private static int loadLevel = 0;
    private static boolean needBase = true;
    private static boolean needP2PLib;
    private static boolean needTTnetLib;
    private static boolean useShadowVersion;

    public AVMDLLibraryManager() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static synchronized boolean loadLibraries() {
        monitor-enter(AVMDLLibraryManager.class);
        tryLoadSSL();     // Catch: Throwable -> L25
        tryLoadVcn();     // Catch: Throwable -> L25
        if (needBase == false) goto L7;
        tryLoadLibray(4);     // Catch: Throwable -> L25
    L7:
        boolean r100 = false;
        if (enableV2 == false) goto L16;
        boolean r101 = tryLoadLibray(16);     // Catch: Throwable -> L25
        if (r101 == false) goto L13;
    L15:
        r100 = r101;
        goto L16
    L13:
        if (useShadowVersion == false) goto L15;
        useShadowVersion = false;     // Catch: Throwable -> L25
        r100 = tryLoadLibray(16);     // Catch: Throwable -> L25
    L16:
        if (r100 == true) goto L23;
        r100 = tryLoadLibray(8);     // Catch: Throwable -> L25
        if (needP2PLib == false) goto L21;
        tryLoadLibray(1);     // Catch: Throwable -> L25
    L21:
        if (needTTnetLib == false) goto L23;
        tryLoadLibray(2);     // Catch: Throwable -> L25
    L23:
        monitor-exit(AVMDLLibraryManager.class);
        return r100;
    L25:
        th = move-exception;
        throw th;
    }

    private static boolean tryLoadSSL() {
        if (shouldLoadLib(32) == false) goto L7;
        boolean r100 = libraryLoader.loadLibrary(CryptoName);
        if (r100 == false) goto L8;
        r100 = libraryLoader.loadLibrary(SSLName);
    L8:
        if (r100 == true) goto L18;
    L13:
        e = move-exception;
        e.toString();
        return r100;
    L10:
        if (dependBoringSSl == false) goto L19;
        pc4.a.b();     // Catch: Exception -> L13
        return true;
    L19:
        return r100;
    L18:
        return r100;
    L7:
        r100 = false;
        goto L8
    }

    private static boolean tryLoadVcn() {
        if (dependVcn == true) goto L7;
        return true;
    L7:
        if (shouldLoadLib(64) == false) goto L9;
        boolean r100 = libraryLoader.loadLibrary(VcnName);
    L10:
        if (r100 == true) goto L15;
        boolean r101 = VcnlibloadWrapper.tryLoadVcnlib();
        if (r101 == true) goto L14;
        return r101;
    L14:
        return VcnlibloadWrapper.tryLoadVcnverifylib();
    L15:
        return r100;
    L9:
        r100 = false;
        goto L10
    }

    @JvmStatic
    public static void INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLLibraryManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static synchronized void setBoringSSLDependency(boolean r100) {
        monitor-enter(AVMDLLibraryManager.class);
        dependBoringSSl = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setEnableV2(boolean r100) {
        monitor-enter(AVMDLLibraryManager.class);
        enableV2 = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setLibraryLoadLevel(int r100) {
        monitor-enter(AVMDLLibraryManager.class);
        loadLevel = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setLibraryLoader(IAVMDLLibraryLoader r100) {
        monitor-enter(AVMDLLibraryManager.class);
        libraryLoader = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setNeedBase(boolean r100) {
        monitor-enter(AVMDLLibraryManager.class);
        needBase = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setNeedP2PLib(boolean r100) {
        monitor-enter(AVMDLLibraryManager.class);
        needP2PLib = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setNeedTTnetLib(boolean r100) {
        monitor-enter(AVMDLLibraryManager.class);
        needTTnetLib = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setUseShadowVersion(boolean r100) {
        monitor-enter(AVMDLLibraryManager.class);
        useShadowVersion = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setVcnDependency(boolean r100) {
        monitor-enter(AVMDLLibraryManager.class);
        dependVcn = r100;     // Catch: Throwable -> L7
        monitor-exit(AVMDLLibraryManager.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean shouldLoadLib(int r100) {
        if (libraryLoader != null) goto L5;
        return false;
    L5:
        if (r100 > 0) goto L8;
        return false;
    L8:
        if ((loadLevel & r100) != r100) goto L11;
        return true;
    L11:
        return false;
    }

    private static boolean tryLoadLibray(int r100) {
        boolean r101 = false;
        boolean r102 = true;
        if (r100 != 1) goto L5;
        String r103 = P2PLibName;
    L22:
        if (shouldLoadLib(r100) == false) goto L24;
        r101 = libraryLoader.loadLibrary(r103);
    L24:
        if (r101 == false) goto L32;
    L29:
        r102 = r101;
    L31:
        return r102;
    L32:
        INVOKESTATIC_com_ss_mediakit_medialoader_AVMDLLibraryManager_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r103);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.toString();
        goto L29
    L5:
        if (r100 != 2) goto L7;
        r103 = TTNetLibName;
        goto L22
    L7:
        if (r100 != 4) goto L9;
        r103 = BaseLibName;
        goto L22
    L9:
        if (r100 != 8) goto L11;
        r103 = V1LibName;
        goto L22
    L11:
        if (r100 == 16) goto L14;
        return false;
    L14:
        if (useShadowVersion == false) goto L16;
        r103 = ShadowVerName;
        goto L22
    L16:
        r103 = V2LibName;
        goto L22
    }
}
