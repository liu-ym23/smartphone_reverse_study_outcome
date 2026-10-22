package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes41.dex */
public class CpuUtils {
    private static final FileFilter CPU_FILTER = null;
    private static String TAG;
    private static int sCpuCores;
    private static final Object sCpuCoresLock = null;
    private static String sCpuDirectory;
    private static String sCpuInfoPath;
    private static String sCpuModelTitle;
    private static String sCpuPossiblePath;
    private static String sCpuPresentPath;
    private static String sCpuVendorTag;
    private static boolean sInitialized;
    private static String sModel;
    private static final Object sModelLock = null;

    public CpuUtils() {
    }

    public static /* synthetic */ boolean a(File r100) {
        return lambda$static$0(r100);
    }

    private static boolean fetchCPUModel() {
        String r100 = null;
        PolarisFileReaderWrapper r101 = new PolarisFileReaderWrapper(sCpuInfoPath);     // Catch: Throwable -> L31 Exception -> L33
    L96:
        BufferedReader r102 = new BufferedReader(r101);     // Catch: Throwable -> L28 Exception -> L30
    L77:
        String r103 = r102.readLine();     // Catch: Exception -> L71 Throwable -> L52
        if (r103 == null) goto L12;
        if (r103.contains(sCpuModelTitle) == false) goto L77;
        if (r103.contains(":") == false) goto L77;
        r100 = r103.substring(r103.indexOf(58) + 1).trim();     // Catch: Exception -> L71 Throwable -> L52
    L12:
        if (r100 != null) goto L14;
    L16:
        if (r100 == null) goto L93;
        Object r104 = sModelLock;
        monitor-enter(r104);
        sModel = r100;     // Catch: Throwable -> L22
        monitor-exit(r104);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L93:
        r102.close();     // Catch: Exception -> L69
    L87:
        r101.close();     // Catch: Exception -> L70
    L27:
        return true;
    L14:
        if (r100.contains(sCpuVendorTag) == false) goto L16;
        r100 = r100.substring((r100.indexOf(sCpuVendorTag) + sCpuVendorTag.length()) + 1).trim();     // Catch: Exception -> L71 Throwable -> L52
    L35:
        if (0 == 0) goto L44;
        Object r105 = sModelLock;
        monitor-enter(r105);
        sModel = null;     // Catch: Throwable -> L41
        monitor-exit(r105);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    L44:
        if (r102 != null) goto L85;
    L48:
        if (r101 == null) goto L106;
        r101.close();     // Catch: Exception -> L72
        return false;
    L107:
        return false;
    L106:
        return false;
    L85:
        r102.close();     // Catch: Exception -> L47
        goto L48
    L30:
        r102 = null;
    L28:
        th = th;
        BufferedReader r106 = null;
    L53:
        if (0 == 0) goto L62;
        Object r107 = sModelLock;
        monitor-enter(r107);
        sModel = null;     // Catch: Throwable -> L59
        monitor-exit(r107);     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        throw th;
    L62:
        if (r106 != null) goto L79;
    L66:
        if (r101 == null) goto L104;
        r101.close();     // Catch: Exception -> L73
        throw th;
    L105:
        throw th;
    L104:
        throw th;
    L79:
        r106.close();     // Catch: Exception -> L65
    L52:
        th = th;
    L33:
        r101 = null;
        r102 = null;
    L31:
        th = th;
        r101 = null;
        r106 = null;
        goto L53
    }

    static {
        TAG = "CpuUtils";
        sCpuInfoPath = "/proc/cpuinfo";
        sCpuPossiblePath = "/sys/devices/system/cpu/possible";
        sCpuPresentPath = "/sys/devices/system/cpu/present";
        sCpuDirectory = "/sys/devices/system/cpu/";
        sCpuModelTitle = "Hardware";
        sCpuVendorTag = Constants.OperatorKey.KEY_VENDOR;
        sModel = "unknown";
        sModelLock = new Object();
        sCpuCoresLock = new Object();
        CPU_FILTER = new b();
    }

    private static boolean fetchCPUCores() {
        if (fetchCoresFromFile(sCpuPossiblePath) == false) goto L5;
        return true;
    L5:
        if (fetchCoresFromFile(sCpuPresentPath) == false) goto L7;
        return true;
    L7:
        if (fetchCoresFromFileList() == true) goto L14;
        return false;
    L14:
        return true;
    }

    private static boolean fetchCoresFromFileList() {
        File[] r100 = new PolarisFileWrapper(sCpuDirectory).listFiles(CPU_FILTER);
        if (r100 == null) goto L13;
        Object r101 = sCpuCoresLock;
        monitor-enter(r101);
        sCpuCores = r100.length;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        return true;
    L10:
        th = move-exception;
        throw th;
    L13:
        return false;
    }

    public static String getCPUCores() {
        Object r100 = sCpuCoresLock;
        monitor-enter(r100);
        String r101 = String.valueOf(sCpuCores);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static String getCPUModel() {
        Object r100 = sModelLock;
        monitor-enter(r100);
        String r101 = sModel;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static void initialize() {
        if (sInitialized == false) goto L6;
        return;
    L6:
        if (fetchCPUModel() == false) goto L8;
    L10:
        sInitialized = true;
        return;
    L8:
        if (fetchCPUCores() == true) goto L10;
    }

    private static boolean fetchCoresFromFile(String r100) {
        BufferedReader r101 = null;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r100);     // Catch: Throwable -> L29 Exception -> L38
        BufferedReader r103 = new BufferedReader(r102);     // Catch: Throwable -> L27 Exception -> L50
        String r104 = r103.readLine();     // Catch: Throwable -> L24 Exception -> L26
        if (TextUtils.isEmpty(r104) == false) goto L8;
    L11:
        int r105 = -1;
    L12:
        if (r105 == (-1)) goto L58;
        Object r106 = sCpuCoresLock;
        monitor-enter(r106);
        sCpuCores = r105;     // Catch: Throwable -> L18
        monitor-exit(r106);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    L58:
        r103.close();     // Catch: Exception -> L47
    L54:
        r102.close();     // Catch: Exception -> L48
    L23:
        return true;
    L8:
        if (r104.startsWith("0-") == false) goto L11;
        r105 = getFirstInteger(r104.substring(2)) + 1;
        goto L12
    L26:
        r101 = r103;
    L24:
        Throwable th10 = th;
    L31:
        if (r103 != null) goto L64;
    L35:
        if (r102 == null) goto L72;
        r102.close();     // Catch: Exception -> L49
        throw th10;
    L73:
        throw th10;
    L72:
        throw th10;
    L64:
        r103.close();     // Catch: Exception -> L34
        goto L35
    L27:
        th = move-exception;
        th10 = th;
        r103 = null;
    L39:
        if (r101 != null) goto L52;
    L43:
        if (r102 == null) goto L74;
        r102.close();     // Catch: Exception -> L51
        return false;
    L75:
        return false;
    L74:
        return false;
    L52:
        r101.close();     // Catch: Exception -> L42
        goto L43
    L38:
        r102 = null;
    L29:
        th = move-exception;
        r102 = null;
        th10 = th;
        r103 = null;
        goto L31
    }

    private static int getFirstInteger(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L25;
        int r101 = 0;
    L6:
        if (r101 >= r100.length()) goto L17;
        if (Character.isDigit(r100.charAt(r101)) == true) goto L9;
        r101 = r101 + 1;
        goto L6
    L9:
        int r102 = r101 + 1;
    L11:
        if (r102 < r100.length()) goto L13;
    L21:
        return CastIntegerProtector.parseInt(r100.substring(r101, r102));
    L26:
        return 0;
    L13:
        if (Character.isDigit(r100.charAt(r102)) == false) goto L21;
        r102 = r102 + 1;
        goto L11
    L17:
        r101 = 0;
        r102 = 0;
        goto L21
    L25:
        return 0;
    }

    private static /* synthetic */ boolean lambda$static$0(File r100) {
        String r101 = r100.getName();
        if (r101.startsWith("cpu") == false) goto L13;
        int r102 = 3;
    L6:
        if (r102 >= r101.length()) goto L11;
        if (Character.isDigit(r101.charAt(r102)) == false) goto L9;
        r102 = r102 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    L13:
        return false;
    }
}
