package com.ss.mediakit.medialoader;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLLibraryManagerWrapper {
    public static final int LOADBASELIB = 4;
    public static final int LOADP2PLIB = 1;
    public static final int LOADSSL = 32;
    public static final int LOADTTNETLIB = 2;
    public static final int LOADV1LIB = 8;
    public static final int LOADV2LIB = 16;
    public static final int LOADVCN = 64;

    public AVMDLLibraryManagerWrapper() {
    }

    public static void setBoringSSLDependency(boolean r100) {
        AVMDLLibraryManager.setBoringSSLDependency(r100);
    }

    public static void setEnableV2(boolean r100) {
        AVMDLLibraryManager.setEnableV2(r100);
    }

    public static void setLibraryLoadLevel(int r100) {
        AVMDLLibraryManager.setLibraryLoadLevel(r100);
    }

    public static void setLibraryLoader(IAVMDLLibraryLoader r100) {
        AVMDLLibraryManager.setLibraryLoader(r100);
    }

    public static void setNeedBase(boolean r100) {
        AVMDLLibraryManager.setNeedBase(r100);
    }

    public static void setNeedP2pLib(boolean r100) {
        AVMDLLibraryManager.setNeedP2PLib(r100);
    }

    public static void setNeedTTnetLib(boolean r100) {
        AVMDLLibraryManager.setNeedTTnetLib(r100);
    }

    public static void setUseShadowVersion(boolean r100) {
        AVMDLLibraryManager.setUseShadowVersion(r100);
    }

    public static void setVcnDependency(boolean r100) {
        AVMDLLibraryManager.setVcnDependency(r100);
    }
}
