package com.bytedance.bmmt.base;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.MatchResult;

/* JADX INFO: loaded from: classes8.dex */
public class DeviceInfoAndroid {
    public static final int BUFFER_SIZE = 8192;
    private static final FileFilter CPU_FILTER = null;
    private static final String CPU_MANUFACTURER_PATTERN = "Hardware[\\s]*:[\\s]*([\\S\\s]*)\n";
    public static final int DEVICE_INFO_UNKNOWN = -1;
    private static final int ERROR_RESULT = -1;
    private static final String MEMORY_INFO_PATH = "/proc/meminfo";
    public static final String MEMTOTAL_PATTERN = "MemTotal[\\s]*:[\\s]*(\\d+)[\\s]*kB\n";
    private static String RomVersion = "";
    private static final String TAG = "DeviceInfo";
    private static String sCpuModel = "";

    public DeviceInfoAndroid() {
    }

    public static int getCPUMaxFrequency() {
        int r100 = -1;
        int r101 = 0;
        int r102 = -1;
    L44:
        if (r101 >= getNumberOfCPUCores()) goto L29;
        PolarisFileWrapper r103 = new PolarisFileWrapper("/sys/devices/system/cpu/cpu" + r101 + "/cpufreq/cpuinfo_max_freq");     // Catch: IOException -> L43
        if (r103.exists() == false) goto L28;
        if (r103.canRead() == false) goto L28;
        byte[] r104 = new byte[128];     // Catch: IOException -> L43
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper(r103);     // Catch: IOException -> L43
        int r106 = r105.read(r104);     // Catch: NumberFormatException -> L42 Throwable -> L25
        if (r106 == (-1)) goto L24;
        if (r106 > 128) goto L24;
        int r107 = 0;
    L15:
        if (Character.isDigit(r104[r107]) == false) goto L18;
        if (r107 >= 128) goto L18;
        r107 = r107 + 1;     // Catch: NumberFormatException -> L42 Throwable -> L25
    L18:
        Integer r108 = Integer.valueOf(Integer.parseInt(new String(r104, 0, r107, "UTF-8")));     // Catch: NumberFormatException -> L42 Throwable -> L25
        if (r108.intValue() <= r102) goto L21;
        r102 = r108.intValue();     // Catch: NumberFormatException -> L42 Throwable -> L25
    L24:
        throw new NumberFormatException();     // Catch: NumberFormatException -> L42 Throwable -> L25
    L25:
        th = move-exception;
        r105.close();     // Catch: IOException -> L43
        throw th;     // Catch: IOException -> L43
    L21:
        r105.close();     // Catch: IOException -> L43
    L28:
        r101 = r101 + 1;     // Catch: IOException -> L43
        goto L44
    L29:
        if (r102 != (-1)) goto L39;
        PolarisFileInputStreamWrapper r109 = new PolarisFileInputStreamWrapper("/proc/cpuinfo");     // Catch: IOException -> L43
        int r110 = parseFileForValue("cpu MHz", r109) * 1000;
        if (r110 <= r102) goto L35;
        r102 = r110;
    L35:
        r109.close();     // Catch: IOException -> L43
        goto L39
    L36:
        th = move-exception;
        r109.close();     // Catch: IOException -> L43
        throw th;     // Catch: IOException -> L43
    L39:
        r100 = r102;
    L41:
        return r100 / 1000;
    }

    public static int getNumberOfCPUCores() {
        int r100 = getCoresFromFileInfo("/sys/devices/system/cpu/possible");     // Catch: Throwable -> L13
        if (r100 != (-1)) goto L6;
        r100 = getCoresFromFileInfo("/sys/devices/system/cpu/present");     // Catch: Throwable -> L13
    L6:
        if (r100 != (-1)) goto L12;
        File[] r101 = new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(CPU_FILTER);     // Catch: Throwable -> L13
        if (r101 == null) goto L16;
        return r101.length;
    L16:
        return -1;
    L12:
        return r100;
    L18:
        return -1;
    }

    static {
        CPU_FILTER = new AnonymousClass1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.InputStream, java.lang.Process] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.InputStream] */
    public static String GetCpuModel() {
        if (sCpuModel.isEmpty() == false) goto L5;
        String r100 = "";
        ?? r101 = 0;
        r101 = 0;
        Process r102 = new ProcessBuilder(new String[]{"/system/bin/cat", "/proc/cpuinfo"}).start();     // Catch: Throwable -> L31 IOException -> L33
        r101 = r102.getInputStream();     // Catch: IOException -> L29 Throwable -> L50
        if (r101 == 0) goto L20;
        Scanner r103 = new Scanner(r101, "UTF-8");     // Catch: IOException -> L29 Throwable -> L50
        if (r103.findWithinHorizon(CPU_MANUFACTURER_PATTERN, 3000) == null) goto L19;
        MatchResult r104 = r103.match();     // Catch: IOException -> L29 Throwable -> L50
        if (r104.groupCount() <= 0) goto L19;
        r100 = r104.group(1);     // Catch: NumberFormatException -> L17 IOException -> L29 Throwable -> L50
    L17:
        e = move-exception;
        e.getMessage();     // Catch: IOException -> L29 Throwable -> L50
    L19:
        r103.close();     // Catch: IOException -> L29 Throwable -> L50
    L20:
        if (r101 != 0) goto L76;
    L25:
        r102.destroy();     // Catch: Exception -> L27
    L62:
    L44:
        if (r100.isEmpty() == true) goto L46;
    L48:
        sCpuModel = r100;
        return r100;
    L46:
        if (Build.VERSION.SDK_INT < 31) goto L48;
        r100 = Build.SOC_MODEL;
        goto L48
    L76:
        r101.close();     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.getMessage();
    L29:
        e = e;
    L35:
        e.getMessage();     // Catch: Throwable -> L50
        if (r101 != 0) goto L72;
    L41:
        if (r102 == null) goto L44;
        r102.destroy();     // Catch: Exception -> L27
        goto L62
    L72:
        r101.close();     // Catch: Exception -> L39
    L39:
        e = move-exception;
        e.getMessage();
        goto L41
    L27:
        e = move-exception;
        e.getMessage();
    L33:
        e = e;
        r102 = null;
    L31:
        th = th;
    L51:
        if (0 != 0) goto L68;
    L56:
        if (0 == 0) goto L79;
        r101.destroy();     // Catch: Exception -> L59
        throw th;
    L59:
        e = move-exception;
        e.getMessage();
        throw th;
    L79:
        throw th;
    L68:
        r101.close();     // Catch: Exception -> L54
    L54:
        e = move-exception;
        e.getMessage();
    L50:
        th = th;
        goto L51
    L5:
        return sCpuModel;
    }

    public static String GetDeviceBrand() {
        String r100 = Build.MANUFACTURER;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public static String GetDeviceModel() {
        String r100 = Build.MODEL;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public static String getAppRootPath() {
        Context r100 = ContextUtils.getApplicationContext();     // Catch: Exception -> L8
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getFilesDir().getAbsolutePath();
    L8:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    public static String getGpuName() {
        if (Build.VERSION.SDK_INT < 22) goto L5;
        String r100 = GPUUtil.getGPURenderer();
    L6:
        if (r100 != null) goto L9;
        return "null-null";
    L9:
        return r100;
    L5:
        r100 = GPUUtil.getGPURendererFallback();
        goto L6
    }

    public static String getRomVersionName() {
        if (TextUtils.isEmpty(RomVersion) == false) goto L6;
        RomVersion = DeviceUtil.getPhoneSystem(Build.BRAND);
    L6:
        return RomVersion;
    }

    public static String getSdkVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    public static String getCpuName() {
        String r100 = GetCpuModel();
        if (r100 == null) goto L10;
        if (r100.isEmpty() == true) goto L10;
        return r100 + i.f25853b + Build.HARDWARE;
    L10:
        if (Build.VERSION.SDK_INT < 31) goto L14;
        return Build.SOC_MODEL + i.f25853b + Build.HARDWARE;
    L14:
        return Build.HARDWARE;
    }

    public static int getCpuThreads() {
        return getNumberOfCPUCores();
    }

    public static String getSystemDefaultLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static int getMemSize() {
        Context r100 = ContextUtils.getApplicationContext();     // Catch: Throwable -> L12 Exception -> L14
        if (r100 != null) goto L6;
        return -1;
    L6:
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();     // Catch: Throwable -> L12 Exception -> L14
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");     // Catch: Throwable -> L12 Exception -> L14
        if (r102 != null) goto L9;
        return -1;
    L9:
        r102.getMemoryInfo(r101);     // Catch: Throwable -> L12 Exception -> L14
    L11:
        return (int) Math.ceil((((r101.totalMem * 1.024d) / 1024.0d) / 1024.0d) / 1024.0d);
    L12:
        th = move-exception;
        throw th;
    L14:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        return (int) Math.ceil(((((-1) * 1.024d) / 1024.0d) / 1024.0d) / 1024.0d);
    }

    public static String getAndroidBuildId() {
        return Build.ID;
    }

    public static String getBrand() {
        return Build.BRAND;
    }

    public static String getBuildRelease() {
        return Build.VERSION.RELEASE;
    }

    public static String getBuildType() {
        return Build.TYPE;
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getProduct() {
        return Build.PRODUCT;
    }

    private static int getCoresFromFileInfo(String r100) {
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L10 IOException -> L14
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102, "UTF-8"));     // Catch: Throwable -> L7 IOException -> L9
        String r104 = r103.readLine();     // Catch: Throwable -> L7 IOException -> L9
        r103.close();     // Catch: Throwable -> L7 IOException -> L9
        int r105 = getCoresFromFileString(r104);     // Catch: Throwable -> L7 IOException -> L9
        r102.close();     // Catch: IOException -> L19
    L6:
        return r105;
    L9:
        r101 = r102;
    L7:
        th = th;
        r101 = r102;
    L11:
        if (r101 != null) goto L26;
    L13:
        throw th;
    L26:
        r101.close();     // Catch: IOException -> L20
        goto L13
    L10:
        th = th;
    L15:
        if (r101 == null) goto L32;
        r101.close();     // Catch: IOException -> L21
        return -1;
    L33:
        return -1;
    L32:
        return -1;
    }

    private static int getCoresFromFileString(String r100) {
        if (r100 != null) goto L4;
        return -1;
    L4:
        if (r100.matches("0-[\\d]+$") == true) goto L7;
        return -1;
    L7:
        return CastIntegerProtector.valueOf(r100.substring(2)).intValue() + 1;
    }

    private static int extractValue(byte[] r100, int r101) {
    L3:
        if (r101 >= r100.length) goto L17;
        byte r102 = r100[r101];
        if (r102 == 10) goto L24;
        if (Character.isDigit(r102) == true) goto L8;
        r101 = r101 + 1;
        goto L3
    L8:
        int r103 = r101 + 1;
    L10:
        if (r103 >= r100.length) goto L15;
        if (Character.isDigit(r100[r103]) == false) goto L15;
        r103 = r103 + 1;
    L15:
        return CastIntegerProtector.parseInt(new String(r100, 0, r101, r103 - r101));
    L24:
        return -1;
    L17:
        return -1;
    }

    public static String getValueFromCpuInfoFile(String r100, String r101) {
        BufferedReader r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper("/proc/cpuinfo");     // Catch: Throwable -> L29 Exception -> L31
        BufferedReader r104 = new BufferedReader(new InputStreamReader(r103, Charset.defaultCharset()));     // Catch: Exception -> L27 Throwable -> L42
    L69:
        String r105 = r104.readLine();     // Catch: Throwable -> L23 Exception -> L25
        if (r105 != null) goto L8;
    L60:
        r104.close();     // Catch: Exception -> L17
    L19:
        r103.close();     // Catch: Exception -> L21
    L65:
    L41:
        return r101;
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L8:
        if (r105.contains(":") == false) goto L69;
        String[] r106 = r105.split(":");     // Catch: Throwable -> L23 Exception -> L25
        if (r106.length <= 1) goto L69;
        if (r106[0].contains(r100) == false) goto L69;
        r101 = r106[1];     // Catch: Throwable -> L23 Exception -> L25
        goto L60
    L25:
        e = e;
        r102 = r104;
    L33:
        e.printStackTrace();     // Catch: Throwable -> L42
        if (r102 != null) goto L56;
    L39:
        if (r103 == null) goto L41;
        r103.close();     // Catch: Exception -> L21
        goto L65
    L56:
        r102.close();     // Catch: Exception -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
    L23:
        th = th;
        r102 = r104;
    L43:
        if (r102 != null) goto L54;
    L48:
        if (r103 == null) goto L78;
        r103.close();     // Catch: Exception -> L51
        throw th;
    L51:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L78:
        throw th;
    L54:
        r102.close();     // Catch: Exception -> L46
    L46:
        e = move-exception;
        e.printStackTrace();
    L27:
        e = e;
    L42:
        th = th;
        goto L43
    L21:
        e = move-exception;
        e.printStackTrace();
    L31:
        e = e;
        r103 = null;
    L29:
        th = th;
        r103 = null;
        goto L43
    }

    private static int parseFileForValue(String r100, FileInputStream r101) {
        byte[] r102 = new byte[1024];
        int r103 = r101.read(r102);     // Catch: Throwable -> L23
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L32;
        byte r105 = r102[r104];     // Catch: Throwable -> L23
        if (r105 == 10) goto L8;
        if (r104 == 0) goto L8;
    L20:
        r104 = r104 + 1;
    L8:
        if (r105 != 10) goto L10;
        r104 = r104 + 1;     // Catch: Throwable -> L23
    L10:
        int r106 = r104;
    L11:
        if (r106 >= r103) goto L20;
        int r107 = r106 - r104;     // Catch: Throwable -> L23
        if (r102[r106] != r100.charAt(r107)) goto L20;
        if (r107 == (r100.length() - 1)) goto L17;
        r106 = r106 + 1;
        goto L11
    L17:
        return extractValue(r102, r106);
    L32:
        return -1;
    L21:
        return -1;
    }
}
