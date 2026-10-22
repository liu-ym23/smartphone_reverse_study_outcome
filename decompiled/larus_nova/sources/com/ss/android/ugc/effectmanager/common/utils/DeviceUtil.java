package com.ss.android.ugc.effectmanager.common.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class DeviceUtil {
    private static final String CACHE_KEY_CPU_MODEL = "cache_key_cpu_model";
    private static final String CACHE_KEY_MEMORY_INFO = "cache_key_memory_info";
    public static final int DEVICEINFO_UNKNOWN = -1;
    private static final int FILE_BUFFER_SIZE = 1024;
    private static final int MEMORY_COEFFICIENT = 1024;
    private static final Map<String, Object> cachedMap = null;

    public static class MemoryInfo {
        private long availableSize;
        private long totalSize;

        public MemoryInfo() {
        }

        public long getAvailableSize() {
            return this.availableSize;
        }

        public long getTotalSize() {
            return this.totalSize;
        }

        public static /* synthetic */ long access$002(MemoryInfo r100, long r101) {
            r100.totalSize = r101;
            return r101;
        }

        public static /* synthetic */ long access$102(MemoryInfo r100, long r101) {
            r100.availableSize = r101;
            return r101;
        }
    }

    static {
        cachedMap = new ConcurrentHashMap();
    }

    public static String getCpuModel() {
        Map<String, Object> r100 = cachedMap;
        Object r101 = r100.get(CACHE_KEY_CPU_MODEL);
        if (r101 != null) goto L5;
        String r102 = getCpuModelInternal();
        r100.put(CACHE_KEY_CPU_MODEL, r102);
        return r102;
    L5:
        return (String) r101;
    }

    private static synchronized String getCpuModelInternal() {
        monitor-enter(DeviceUtil.class);
        BufferedReader r100 = null;
    L28:
        e = e;
    L29:
        e.printStackTrace();     // Catch: Throwable -> L26
    L24:
        closeSafety(r100);     // Catch: Throwable -> L36
        String r101 = Build.HARDWARE;     // Catch: Throwable -> L36
        monitor-exit(DeviceUtil.class);
        return r101;
    L26:
        th = th;
    L34:
        closeSafety(r100);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L7:
        if (new PolarisFileWrapper("/proc/cpuinfo").exists() == false) goto L24;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"));     // Catch: Throwable -> L26 Exception -> L28
    L43:
        String r103 = r102.readLine();     // Catch: Throwable -> L20 Exception -> L22
        if (r103 == null) goto L19;
        if (r103.contains(":") == false) goto L43;
        String[] r104 = r103.split(":");     // Catch: Throwable -> L20 Exception -> L22
        if (r104[0].contains("Hardware") == false) goto L43;
        String r105 = r104[1];     // Catch: Throwable -> L20 Exception -> L22
        closeSafety(r102);     // Catch: Throwable -> L36
        monitor-exit(DeviceUtil.class);
        return r105;
    L19:
        r100 = r102;
    L22:
        e = e;
        r100 = r102;
    L20:
        th = th;
        r100 = r102;
    L36:
        th = move-exception;
        throw th;
    }

    private DeviceUtil() {
    }

    private static void closeSafety(Closeable r100) {
        if (r100 == null) goto L10;
        r100.close();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static long getAvailableMemory(Context r100) {
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L7
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");     // Catch: Exception -> L7
        if (r102 == null) goto L8;
        r102.getMemoryInfo(r101);     // Catch: Exception -> L7
        long r103 = r101.availMem;     // Catch: Exception -> L7
    L10:
        if (r103 != (-1)) goto L31;
        PolarisFileInputStreamWrapper r104 = null;
        PolarisFileInputStreamWrapper r105 = new PolarisFileInputStreamWrapper("/proc/meminfo");     // Catch: Throwable -> L18 Exception -> L24
        goto L22
    L29:
        long r106 = ((long) parseFileForValue("MemAvailable", r105)) * 1024;
        closeSafety(r105);
        return r106;
    L17:
        r104 = r105;
    L15:
        Throwable th10 = th;
    L20:
        closeSafety(r105);
        throw th10;
    L18:
        th = move-exception;
        r105 = null;
        th10 = th;
    L22:
        closeSafety(r104);
        return r103;
    L31:
        return r103;
    L8:
        r103 = -1;
        goto L10
    }

    public static MemoryInfo getMemoryInfo(Context r100) {
        Map<String, Object> r101 = cachedMap;
        Object r102 = r101.get(CACHE_KEY_MEMORY_INFO);
        if (r102 != null) goto L5;
        MemoryInfo r103 = getMemoryInfoInternal(r100);
        r101.put(CACHE_KEY_MEMORY_INFO, r103);
        return r103;
    L5:
        return (MemoryInfo) r102;
    }

    private static MemoryInfo getMemoryInfoInternal(Context r100) {
        MemoryInfo r101 = new MemoryInfo();
        MemoryInfo.access$002(r101, getTotalMemory(r100));
        MemoryInfo.access$102(r101, getAvailableMemory(r100));
        return r101;
    }

    public static long getTotalMemory(Context r100) {
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();     // Catch: Exception -> L7
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");     // Catch: Exception -> L7
        if (r102 == null) goto L8;
        r102.getMemoryInfo(r101);     // Catch: Exception -> L7
        long r103 = r101.totalMem;     // Catch: Exception -> L7
    L10:
        if (r103 != (-1)) goto L25;
        PolarisFileInputStreamWrapper r104 = null;
    L21:
        th = move-exception;
        PolarisFileInputStreamWrapper r105 = null;
        Throwable th10 = th;
    L23:
        closeSafety(r105);
        throw th10;
    L13:
        if (new PolarisFileWrapper("/proc/meminfo").exists() == false) goto L20;
        r105 = new PolarisFileInputStreamWrapper("/proc/meminfo");     // Catch: Exception -> L27 Throwable -> L21
        goto L20
    L32:
        r103 = ((long) parseFileForValue("MemTotal", r105)) * 1024;
        goto L17
    L18:
        th10 = th;
    L17:
        r104 = r105;
    L20:
        closeSafety(r104);
    L25:
        return r103;
    L8:
        r103 = -1;
        goto L10
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

    public static int parseFileForValue(String r100, FileInputStream r101) {
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
