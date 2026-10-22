package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.StrictMode;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import com.ttnet.org.chromium.base.metrics.RecordHistogram;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes41.dex */
@JNINamespace("base::android")
@MainDex
public class SysUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ANDROID_LOW_MEMORY_DEVICE_THRESHOLD_MB = 512;
    private static final int ANDROID_O_LOW_MEMORY_DEVICE_THRESHOLD_MB = 1024;
    private static final int BYTES_PER_GIGABYTE = 1073741824;
    private static final long HIGH_END_DEVICE_DISK_CAPACITY_GB = 24;
    private static final String TAG = "SysUtils";
    private static Integer sAmountOfPhysicalMemoryKB;
    private static Boolean sHighEndDiskDevice;
    private static Boolean sLowEndDevice;

    public interface Natives {
        void logPageFaultCountToTracing();
    }

    private SysUtils() {
    }

    private static boolean detectHighEndDiskDevice() {
        StrictModeContext r100 = StrictModeContext.allowDiskReads();     // Catch: IllegalArgumentException -> L19
    L6:
        if ((new StatFs(Environment.getDataDirectory().getAbsolutePath()).getTotalBytes() / 1073741824) < HIGH_END_DEVICE_DISK_CAPACITY_GB) goto L8;
        boolean r101 = true;
    L9:
        if (r100 == null) goto L11;
        r100.close();     // Catch: IllegalArgumentException -> L19
    L11:
        return r101;
    L8:
        r101 = false;
    L12:
        th = move-exception;
        if (r100 != null) goto L20;
    L18:
        throw th;     // Catch: IllegalArgumentException -> L19
    L20:
        r100.close();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IllegalArgumentException -> L19
    L19:
        return false;
    }

    public static void resetForTesting() {
        sLowEndDevice = null;
        sAmountOfPhysicalMemoryKB = null;
    }

    public static int amountOfPhysicalMemoryKB() {
        if (sAmountOfPhysicalMemoryKB != null) goto L6;
        sAmountOfPhysicalMemoryKB = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
    L6:
        return sAmountOfPhysicalMemoryKB.intValue();
    }

    private static int detectAmountOfPhysicalMemoryKB() {
        Pattern r100 = PatternProtector.compile("^MemTotal:\\s+([0-9]+) kB$");
        StrictMode.ThreadPolicy r101 = StrictMode.allowThreadDiskReads();
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper("/proc/meminfo");     // Catch: Throwable -> L27 Exception -> L32
        BufferedReader r103 = new BufferedReader(r102);     // Catch: Throwable -> L24
    L34:
        String r104 = r103.readLine();     // Catch: Throwable -> L21
        if (r104 == null) goto L14;
        Matcher r105 = r100.matcher(r104);     // Catch: Throwable -> L21
        if (r105.find() == false) goto L34;
        int r106 = Integer.parseInt(r105.group(1));     // Catch: Throwable -> L21
        if (r106 > 1024) goto L17;
        r105.group(1);     // Catch: Throwable -> L21
        goto L30
    L17:
        r103.close();     // Catch: Throwable -> L24
        r102.close();     // Catch: Throwable -> L27 Exception -> L32
        StrictMode.setThreadPolicy(r101);
        return r106;
    L14:
        r103.close();     // Catch: Throwable -> L24
        r102.close();     // Catch: Throwable -> L27 Exception -> L32
    L21:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L27 Exception -> L32
        throw th;     // Catch: Throwable -> L27 Exception -> L32
    L27:
        th = move-exception;
        StrictMode.setThreadPolicy(r101);
        throw th;
    L30:
        StrictMode.setThreadPolicy(r101);
        return 0;
    }

    public static boolean isHighEndDiskDevice() {
        if (sHighEndDiskDevice != null) goto L6;
        sHighEndDiskDevice = Boolean.valueOf(detectHighEndDiskDevice());
    L6:
        return sHighEndDiskDevice.booleanValue();
    }

    public static boolean isLowEndDevice() {
        if (sLowEndDevice != null) goto L6;
        sLowEndDevice = Boolean.valueOf(detectLowEndDevice());
    L6:
        return sLowEndDevice.booleanValue();
    }

    private static boolean detectLowEndDevice() {
        boolean r100 = true;
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.ENABLE_LOW_END_DEVICE_MODE) == false) goto L6;
        return true;
    L6:
        if (CommandLine.getInstance().hasSwitch(BaseSwitches.DISABLE_LOW_END_DEVICE_MODE) == false) goto L8;
        return false;
    L8:
        Integer r101 = Integer.valueOf(detectAmountOfPhysicalMemoryKB());
        sAmountOfPhysicalMemoryKB = r101;
        if (r101.intValue() > 0) goto L12;
    L10:
        boolean r102 = false;
    L20:
        if (ContextUtils.getApplicationContext() == null) goto L22;
        boolean r103 = ((ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity")).isLowRamDevice();
    L23:
        if (r102 == r103) goto L26;
        r100 = false;
    L26:
        RecordHistogram.recordBooleanHistogram("Android.SysUtilsLowEndMatches", r100);
        return r102;
    L22:
        r103 = false;
        goto L23
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L17;
        if ((sAmountOfPhysicalMemoryKB.intValue() / 1024) > 1024) goto L10;
    L15:
        r102 = true;
        goto L20
    L17:
        if ((sAmountOfPhysicalMemoryKB.intValue() / 1024) > 512) goto L10;
        goto L10
    }

    public static boolean isAndroidGo() {
        if (isLowEndDevice() == true) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return true;
    }

    public static boolean isCurrentlyLowMemory() {
        ActivityManager r100 = (ActivityManager) ContextUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();
        r100.getMemoryInfo(r101);
        return r101.lowMemory;
    }

    public static void logPageFaultCountToTracing() {
        SysUtilsJni.get().logPageFaultCountToTracing();
    }

    static {
    }

    public static boolean hasCamera(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        if (r101.hasSystemFeature("android.hardware.camera") == false) goto L5;
    L8:
        return true;
    L5:
        if (r101.hasSystemFeature("android.hardware.camera.any") == true) goto L8;
        return false;
    }

    public static void setAmountOfPhysicalMemoryKBForTesting(int r100) {
        sAmountOfPhysicalMemoryKB = Integer.valueOf(r100);
    }
}
