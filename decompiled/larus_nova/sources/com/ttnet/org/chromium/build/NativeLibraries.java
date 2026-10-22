package com.ttnet.org.chromium.build;

/* JADX INFO: loaded from: classes41.dex */
public class NativeLibraries {
    public static final int CPU_FAMILY_ARM = 1;
    public static final int CPU_FAMILY_MIPS = 2;
    public static final int CPU_FAMILY_UNKNOWN = 0;
    public static final int CPU_FAMILY_X86 = 3;
    public static String[] LIBRARIES = null;
    public static int sCpuFamily = 1;
    public static boolean sUseLibraryInZipFile;
    public static boolean sUseLinker;
    public static boolean sUseModernLinker;

    static {
        LIBRARIES = new String[0];
    }

    public NativeLibraries() {
    }
}
