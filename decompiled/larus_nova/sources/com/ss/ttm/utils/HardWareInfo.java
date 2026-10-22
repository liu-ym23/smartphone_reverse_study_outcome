package com.ss.ttm.utils;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.facebook.keyframes.model.KFImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes40.dex */
public class HardWareInfo {
    private static final int ATOM = 1;
    public static final int CPU_FAMILY_ARM = 1;
    public static final int CPU_FAMILY_MIPS = 3;
    public static final int CPU_FAMILY_UNKNOWN = 0;
    public static final int CPU_FAMILY_X86 = 2;
    private static final int NEON = 0;
    private static int[] mArmArchitecture;
    private static int mCpuType;

    static {
        mArmArchitecture = new int[3];
    }

    public HardWareInfo() {
    }

    private static boolean isAndroidJB2() {
        return true;
    }

    public static int[] getCpuArchitecture() {
        PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper("/proc/cpuinfo");     // Catch: Exception -> L38
        InputStreamReader r101 = new InputStreamReader(r100);     // Catch: Exception -> L38
        BufferedReader r102 = new BufferedReader(r101);     // Catch: Exception -> L38
    L43:
        String r103 = r102.readLine();     // Catch: Throwable -> L35
        if (r103 == null) goto L7;
        String[] r104 = r103.replace("\t", "").split(":");     // Catch: Throwable -> L35
        if (r104.length != 2) goto L43;
        String r110 = r104[0].trim();     // Catch: Throwable -> L35
        String r105 = r104[1].trim();     // Catch: Throwable -> L35
        if (r110.compareTo("Processor") == 0) goto L14;
        if (r110.compareToIgnoreCase("Features") == 0) goto L24;
        if (r110.compareToIgnoreCase("model name") == 0) goto L29;
        if (r110.compareToIgnoreCase("cpu family") != 0) goto L43;
        mArmArchitecture[1] = Integer.parseInt(r105);     // Catch: Throwable -> L35
        goto L43
    L29:
        if (r105.contains("Intel") == false) goto L43;
        int[] r106 = mArmArchitecture;     // Catch: Throwable -> L35
        r106[0] = 2;     // Catch: Throwable -> L35
        r106[2] = 1;     // Catch: Throwable -> L35
        goto L43
    L24:
        if (r105.contains("neon") == false) goto L43;
        mArmArchitecture[2] = 0;     // Catch: Throwable -> L35
        goto L43
    L14:
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L35
        int r112 = r105.indexOf("ARMv") + 4;     // Catch: Throwable -> L35
    L16:
        if (r112 >= r105.length()) goto L20;
        String r113 = r105.charAt(r112) + "";     // Catch: Throwable -> L35
        if (r113.matches("\\d") == false) goto L20;
        r111.append(r113);     // Catch: Throwable -> L35
        r112 = r112 + 1;     // Catch: Throwable -> L35
    L20:
        int[] r107 = mArmArchitecture;     // Catch: Throwable -> L35
        r107[0] = 1;     // Catch: Throwable -> L35
        r107[1] = Integer.parseInt(r111.toString());     // Catch: Throwable -> L35
        goto L43
    L7:
        r102.close();     // Catch: Exception -> L38
        r101.close();     // Catch: Exception -> L38
        r100.close();     // Catch: Exception -> L38
    L41:
        return mArmArchitecture;
    L35:
        th = move-exception;
        r102.close();     // Catch: Exception -> L38
        r101.close();     // Catch: Exception -> L38
        r100.close();     // Catch: Exception -> L38
        throw th;     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L41
    }

    public static int getCpuFamily() {
        if (mCpuType != 0) goto L6;
        getCpuInfo();
        mCpuType = mArmArchitecture[0];
    L6:
        return mCpuType;
    }

    public static int[] getCpuInfo() {
        PolarisFileInputStreamWrapper r100 = new PolarisFileInputStreamWrapper("/proc/cpuinfo");     // Catch: Exception -> L51
        InputStreamReader r101 = new InputStreamReader(r100);     // Catch: Exception -> L51
        BufferedReader r102 = new BufferedReader(r101);     // Catch: Exception -> L51
    L56:
        String r103 = r102.readLine();     // Catch: Throwable -> L48
        if (r103 == null) goto L47;
        String[] r104 = r103.replaceAll("\t", "").toLowerCase(Locale.US).split(":");     // Catch: Throwable -> L48
        if (r104.length != 2) goto L56;
        String r105 = r104[0].trim();     // Catch: Throwable -> L48
        String r106 = r104[1].trim();     // Catch: Throwable -> L48
        if (r106 == null) goto L56;
        if (r105 == null) goto L56;
        if (r105.compareTo("processor") == 0) goto L18;
        if (r105.compareToIgnoreCase(KFImage.FEATURES_JSON_FIELD) == 0) goto L29;
        if (r105.compareToIgnoreCase("model name") != 0) goto L56;
        if (r106.contains("intel") == true) goto L43;
        if (r106.contains("arm") == false) goto L56;
        mArmArchitecture[0] = 1;     // Catch: Throwable -> L48
        goto L47
    L43:
        mArmArchitecture[0] = 2;     // Catch: Throwable -> L48
        goto L47
    L29:
        if (r106.contains("neon") == true) goto L38;
        if (r106.contains("thumb") == true) goto L38;
        if (r106.contains("vfpv") == true) goto L38;
        if (r106.contains("asimd") == true) goto L38;
        if (r106.contains("simd") == false) goto L56;
    L38:
        mArmArchitecture[0] = 1;     // Catch: Throwable -> L48
        goto L56
    L18:
        if (r106.contains("armv") == true) goto L25;
        if (r106.contains("aarch64") == true) goto L25;
        if (r106.contains("intel") == false) goto L56;
        mArmArchitecture[0] = 2;     // Catch: Throwable -> L48
    L25:
        mArmArchitecture[0] = 1;     // Catch: Throwable -> L48
    L47:
        r102.close();     // Catch: Exception -> L51
        r101.close();     // Catch: Exception -> L51
        r100.close();     // Catch: Exception -> L51
    L54:
        return mArmArchitecture;
    L48:
        th = move-exception;
        r102.close();     // Catch: Exception -> L51
        r101.close();     // Catch: Exception -> L51
        r100.close();     // Catch: Exception -> L51
        throw th;     // Catch: Exception -> L51
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L54
    }

    public static long getProcessCpuInfo() {
        BufferedReader r100 = null;
        BufferedReader r101 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/stat")), 1000);     // Catch: Throwable -> L17 IOException -> L30
        String r102 = r101.readLine();     // Catch: Throwable -> L14 IOException -> L16
        r101.close();     // Catch: Throwable -> L14 IOException -> L16
        String[] r103 = r102.split(" ");     // Catch: Throwable -> L14 IOException -> L16
        r101.close();     // Catch: Exception -> L7
    L35:
        return ((CastLongProtector.parseLong(r103[13]) + CastLongProtector.parseLong(r103[14])) + CastLongProtector.parseLong(r103[15])) + CastLongProtector.parseLong(r103[16]);
    L13:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L16:
        r100 = r101;
    L14:
        th = th;
        r100 = r101;
    L18:
        if (r100 != null) goto L37;
    L23:
        throw th;
    L37:
        r100.close();     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L17:
        th = th;
    L24:
        if (r100 != null) goto L31;
    L29:
        return 0;
    L31:
        r100.close();     // Catch: Exception -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L29
    }

    private static long getAvailableStorageSize(Context r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (Environment.getDataDirectory() != null) goto L8;
        return -1;
    L8:
        return getDirectoryAvailableSize(r100.getFilesDir().getParent());
    }

    private static long getDirectoryAvailableSize(String r100) {
        StatFs r101 = new StatFs(r100);     // Catch: IllegalArgumentException -> L9
        if (isAndroidJB2() == false) goto L5;
        long r102 = r101.getBlockSizeLong();     // Catch: IllegalArgumentException -> L9
        long r103 = r101.getAvailableBlocksLong();     // Catch: IllegalArgumentException -> L9
    L8:
        return r102 * r103;
    L5:
        r102 = r101.getBlockSize();     // Catch: IllegalArgumentException -> L9
        r103 = r101.getAvailableBlocks();     // Catch: IllegalArgumentException -> L9
    L9:
        return -1;
    }

    private static long getDirectoryTotalSize(String r100) {
        StatFs r101 = new StatFs(r100);     // Catch: IllegalArgumentException -> L9
        if (isAndroidJB2() == false) goto L5;
        long r102 = r101.getBlockSizeLong();     // Catch: IllegalArgumentException -> L9
        long r103 = r101.getBlockCountLong();     // Catch: IllegalArgumentException -> L9
    L8:
        return r102 * r103;
    L5:
        r102 = r101.getBlockSize();     // Catch: IllegalArgumentException -> L9
        r103 = r101.getBlockCount();     // Catch: IllegalArgumentException -> L9
    L9:
        return -1;
    }

    public static long[] getSDCardSize(Context r100) {
        long[] r101 = new long[2];
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L5;
        long r102 = getAvailableStorageSize(r100);
        r101[0] = getTotalStorageSize(r100);
        r101[1] = r102;
    L5:
        return r101;
    }

    private static long getTotalStorageSize(Context r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (Environment.getDataDirectory() != null) goto L8;
        return -1;
    L8:
        return getDirectoryTotalSize(r100.getFilesDir().getParent());
    }
}
