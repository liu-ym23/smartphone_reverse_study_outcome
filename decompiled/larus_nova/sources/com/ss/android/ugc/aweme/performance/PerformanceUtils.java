package com.ss.android.ugc.aweme.performance;

import android.app.ActivityManager;
import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.impl.ota.g2.j0;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class PerformanceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f451304a = null;

    static {
        f451304a = Arrays.asList(new String[]{"REDMI 6A", "VIVO 1812", "MRD-LX1F", "VIVO 1908", "MRD-LX1", "AMN-LX9", "TECNO ID3K", "TECNO KB2", "TECNO KB3", "KSA-LX9", "INFINIX X627V"});
    }

    public static int a(Context r110) {
        FileFilter r100 = DeviceUtils.f451303a;
        int r101 = -1;
        int r102 = 0;
        int r103 = -1;
    L119:
        int r104 = DeviceUtils.c("/sys/devices/system/cpu/possible");     // Catch: IOException -> L10 Throwable -> L11
        if (r104 != (-1)) goto L7;
        r104 = DeviceUtils.c("/sys/devices/system/cpu/present");     // Catch: IOException -> L10 Throwable -> L11
    L7:
        if (r104 != (-1)) goto L12;
        r104 = new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(DeviceUtils.f451303a).length;     // Catch: IOException -> L10 Throwable -> L11
    L12:
        if (r102 >= r104) goto L30;
        PolarisFileWrapper r105 = new PolarisFileWrapper("/sys/devices/system/cpu/cpu" + r102 + "/cpufreq/cpuinfo_max_freq");     // Catch: IOException -> L10
        if (r105.exists() == false) goto L29;
        byte[] r106 = new byte[128];     // Catch: IOException -> L10
        PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r105);     // Catch: IOException -> L10
        r107.read(r106);     // Catch: Throwable -> L25 NumberFormatException -> L117
        int r108 = 0;
    L18:
        if (Character.isDigit(r106[r108]) == false) goto L21;
        if (r108 >= 128) goto L21;
        r108 = r108 + 1;     // Catch: Throwable -> L25 NumberFormatException -> L117
    L21:
        Integer r109 = Integer.valueOf(Integer.parseInt(new String(r106, 0, r108)));     // Catch: Throwable -> L25 NumberFormatException -> L117
        if (r109.intValue() <= r103) goto L28;
        r103 = r109.intValue();     // Catch: Throwable -> L25 NumberFormatException -> L117
    L25:
        th = move-exception;
        r107.close();     // Catch: IOException -> L10
        throw th;     // Catch: IOException -> L10
    L28:
        r107.close();     // Catch: IOException -> L10
    L29:
        r102 = r102 + 1;     // Catch: IOException -> L10
        goto L119
    L30:
        if (r103 != (-1)) goto L59;
        PolarisFileInputStreamWrapper r111 = new PolarisFileInputStreamWrapper("/proc/cpuinfo");     // Catch: IOException -> L10
        byte[] r112 = new byte[1024];     // Catch: Throwable -> L48
        int r113 = r111.read(r112);     // Catch: Throwable -> L48 Throwable -> L118
        int r114 = 0;
    L34:
        if (r114 >= r113) goto L52;
        byte r115 = r112[r114];     // Catch: Throwable -> L48 Throwable -> L118
        if (r115 == 10) goto L38;
        if (r114 == 0) goto L38;
    L51:
        r114 = r114 + 1;
    L38:
        if (r115 != 10) goto L40;
        r114 = r114 + 1;     // Catch: Throwable -> L48 Throwable -> L118
    L40:
        int r116 = r114;
    L41:
        if (r116 >= r113) goto L51;
        int r117 = r116 - r114;     // Catch: Throwable -> L48 Throwable -> L118
        if (r112[r116] != "cpu MHz".charAt(r117)) goto L51;
        if (r117 == 6) goto L46;
        r116 = r116 + 1;
        goto L41
    L46:
        int r118 = DeviceUtils.b(r112, r116);     // Catch: Throwable -> L48 Throwable -> L118
    L53:
        int r119 = r118 * 1000;
        if (r119 <= r103) goto L56;
        r103 = r119;
    L56:
        r111.close();     // Catch: IOException -> L10
        goto L59
    L52:
        r118 = -1;
    L48:
        th = move-exception;
        r111.close();     // Catch: IOException -> L10
        throw th;     // Catch: IOException -> L10
    L59:
        r101 = r103;
    L11:
        r104 = -1;
    L60:
        long r120 = r101;
        char r121 = 4;
        if (r120 != (-1)) goto L64;
        char r122 = 0;
    L82:
        FileFilter r123 = DeviceUtils.f451303a;
        ActivityManager.MemoryInfo r124 = new ActivityManager.MemoryInfo();
        ((ActivityManager) r110.getSystemService("activity")).getMemoryInfo(r124);
        long r125 = r124.totalMem;
        if (r125 > 0) goto L86;
        r121 = 0;
    L105:
        if (r122 == 0) goto L116;
        if (r121 == 0) goto L116;
        if (r122 <= 5) goto L115;
        if (r121 <= 6) goto L115;
        if (r122 != 7) goto L114;
        if (r121 != 6) goto L114;
        return 3;
    L114:
        return 2;
    L115:
        return 1;
    L116:
        return 0;
    L86:
        if (r125 > 201326592) goto L89;
        r121 = 1;
        goto L105
    L89:
        if (r125 > 304087040) goto L92;
        r121 = 2;
        goto L105
    L92:
        if (r125 > 536870912) goto L95;
        r121 = 3;
        goto L105
    L95:
        if (r125 <= 1073741824) goto L105;
        if (r125 > 1610612736) goto L101;
        r121 = 5;
        goto L105
    L101:
        if (r125 > j0.G2_OTA_SPACE_RESERVE_BYTES) goto L103;
        r121 = 6;
        goto L105
    L103:
        r121 = 7;
        goto L105
    L64:
        if (r120 > 528000) goto L67;
        r122 = 1;
        goto L82
    L67:
        if (r120 > 620000) goto L70;
        r122 = 2;
        goto L82
    L70:
        if (r120 > 1020000) goto L73;
        r122 = 3;
        goto L82
    L73:
        if (r120 > 1220000) goto L76;
        r122 = 4;
        goto L82
    L76:
        if (r120 > 1620000) goto L79;
        r122 = 5;
        goto L82
    L79:
        if (r120 > 2020000) goto L81;
        r122 = 6;
        goto L82
    L81:
        r122 = 7;
        goto L82
    }
}
