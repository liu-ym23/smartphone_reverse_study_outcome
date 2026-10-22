package com.ss.android.utils;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.ss.android.ttve.nativePort.TEContentProviderUtils;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VELogUtil;
import java.io.BufferedReader;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes40.dex */
public class TEDeviceInformation {
    private static AtomicReference<String> sCPUModel;

    public TEDeviceInformation() {
    }

    static {
        sCPUModel = new AtomicReference();
    }

    public static String getCPUModel() {
        if (Build.VERSION.SDK_INT < 31) goto L7;
        return Build.SOC_MODEL;
    L7:
        if (VEConfigCenter.getInstance().getValue("ve_enable_cache_cpumodel", false).booleanValue() == false) goto L18;
        AtomicReference<String> r100 = sCPUModel;
        if (r100 != null) goto L11;
    L14:
        sCPUModel.set(readCPUInfo());
    L16:
        return sCPUModel.get();
    L11:
        if (r100.get() == null) goto L14;
        if (TextUtils.isEmpty(sCPUModel.get()) == false) goto L16;
    L18:
        return readCPUInfo();
    }

    public static Integer gpuUsed() {
        return CastIntegerProtector.valueOf(new Debug.MemoryInfo().getMemoryStat("summary.graphics"));
    }

    public static Integer memNative() {
        return CastIntegerProtector.valueOf(new Debug.MemoryInfo().getMemoryStat("summary.native-heap"));
    }

    private static String readCPUInfo() {
        BufferedReader r100 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"));     // Catch: Exception -> L14
    L3:
        String r101 = r100.readLine();     // Catch: Exception -> L14
        if (r101 == null) goto L12;
        String[] r102 = r101.split(":");     // Catch: Exception -> L14
        if (r102.length <= 1) goto L3;
        String r103 = r102[0].trim().replace(" ", "_");     // Catch: Exception -> L14
        String r104 = r102[1].trim();     // Catch: Exception -> L14
        if (r103.equals("Processor") == true) goto L11;
        if (r104.contains("ARMv") == false) goto L3;
    L11:
        return r104;
    L12:
        r100.close();     // Catch: Exception -> L14
        return null;
    L14:
        e = move-exception;
        VELogUtil.e("TEUtil", e.getLocalizedMessage(), e);
        return null;
    }

    public static long availMemMemory() {
        ActivityManager r100 = (ActivityManager) TEContentProviderUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();
        r100.getMemoryInfo(r101);
        return r101.availMem;
    }

    public static long memThreshold() {
        ActivityManager r100 = (ActivityManager) TEContentProviderUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();
        r100.getMemoryInfo(r101);
        return r101.threshold;
    }

    public static long memTotal() {
        ActivityManager r100 = (ActivityManager) TEContentProviderUtils.getApplicationContext().getSystemService("activity");
        ActivityManager.MemoryInfo r101 = new ActivityManager.MemoryInfo();
        r100.getMemoryInfo(r101);
        return r101.totalMem;
    }
}
