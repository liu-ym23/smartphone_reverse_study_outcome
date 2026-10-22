package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class HeapGCOptimizer {
    private static final long GB = 1073741824;
    private static final long KB = 1024;
    private static final long MB = 1048576;
    private static final String TAG = "HeapGCOptimizer";
    private static long currentRegionSpaces = 0;
    private static final Pattern numPattern = null;
    private static final String numRegEx = "[^0-9]";
    private static boolean sGlobalSwitchOff = false;
    private static boolean sInited = false;
    private static int sMaxAPISupport = 33;
    private static boolean sShrinkInited;
    private static Timer sVssCheckTimer;
    private static VssConfig sVssConfig;

    /* JADX INFO: renamed from: com.bytedance.sysoptimizer.HeapGCOptimizer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class VssCheckAndShrinkTask extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            com_bytedance_sysoptimizer_HeapGCOptimizer$VssCheckAndShrinkTask_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_bytedance_sysoptimizer_HeapGCOptimizer$VssCheckAndShrinkTask__run$___twin___() {
            if ((HeapGCOptimizer.access$100() - ((long) HeapGCOptimizer.access$200().shrinkStep)) >= HeapGCOptimizer.access$200().lowerLimit) goto L6;
            HeapGCOptimizer.access$100();
            HeapGCOptimizer.access$300();
            return;
        L6:
            long r100 = HeapGCOptimizer.access$400();
            if (r100 >= 0) goto L10;
            HeapGCOptimizer.access$300();
            return;
        L10:
            float r101 = r100 / 4.2949673E9f;
            long r102 = r100 / 1048576;
            double r103 = r101;
            if (r103 < 1.0d) goto L13;
        L19:
            if (r103 < 1.0d) goto L21;
            return;
        L21:
            if (r101 >= HeapGCOptimizer.access$200().periodOfLessMemoryUsage) goto L26;
            HeapGCOptimizer.access$600(-1, HeapGCOptimizer.access$200().periodOfCheck * 2);
            return;
        L26:
            return;
        L13:
            if (r101 <= HeapGCOptimizer.access$200().periodOfShrink) goto L19;
            if (HeapGCOptimizer.access$500(((long) HeapGCOptimizer.access$200().shrinkStep) * 1048576) == true) goto L18;
            HeapGCOptimizer.access$300();
            return;
        L18:
            HeapGCOptimizer.access$102(HeapGCOptimizer.access$100() - ((long) HeapGCOptimizer.access$200().shrinkStep));
            int r104 = HeapGCOptimizer.access$200().shrinkStep;
            HeapGCOptimizer.access$100();
            HeapGCOptimizer.access$600(-1, HeapGCOptimizer.access$200().periodOfCheck / 2);
        }

        private VssCheckAndShrinkTask() {
        }

        public /* synthetic */ VssCheckAndShrinkTask(AnonymousClass1 r100) {
            this();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_bytedance_sysoptimizer_HeapGCOptimizer$VssCheckAndShrinkTask_com_larus_apm_impl_protector_RunnableLancet_run(VssCheckAndShrinkTask r100) {
            r100.com_bytedance_sysoptimizer_HeapGCOptimizer$VssCheckAndShrinkTask__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class VssConfig {
        public int firstDelay;
        public int lowerLimit;
        public int periodOfCheck;
        public float periodOfLessMemoryUsage;
        public float periodOfShrink;
        public int shrinkStep;

        public VssConfig() {
            this.firstDelay = 30;
            this.periodOfCheck = 30;
            this.periodOfShrink = 0.65f;
            this.periodOfLessMemoryUsage = 0.45f;
            this.shrinkStep = 125;
            this.lowerLimit = 384;
        }
    }

    public HeapGCOptimizer() {
    }

    private static native long getCurrentRegionSpaceSize();

    private static native boolean heap_expand(int r100, boolean r101);

    private static native boolean init(int r100);

    private static native boolean init_4shrink_region_space(int r100);

    private static native boolean init_shrink_region_space_step_size(long r100);

    private static native boolean optimize(int r100, float r101, float r102, float r103);

    private static native boolean shrink_regionspace_vss(long r100);

    static {
        numPattern = PatternProtector.compile(numRegEx);
        sVssConfig = new VssConfig();
    }

    private static long readVssSize() {
        long r100 = -1;
        PolarisFileInputStreamWrapper r101 = null;
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/status");     // Catch: Throwable -> L17
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102));     // Catch: Throwable -> L15
    L26:
        String r104 = r103.readLine();     // Catch: Throwable -> L23
        if (r104 == null) goto L11;
        String r105 = r104.toLowerCase();     // Catch: Throwable -> L23
        if (r105.contains("vmsize") == false) goto L26;
        r100 = ((long) Integer.parseInt(numPattern.matcher(r105).replaceAll("").trim())) * 1024;
    L11:
        r102.close();     // Catch: IOException -> L13
        r103.close();     // Catch: IOException -> L13
    L22:
        return r100;
    L16:
        r101 = r102;
    L18:
        if (r101 == null) goto L20;
        r101.close();     // Catch: IOException -> L13
    L20:
        if (r103 == null) goto L22;
        r103.close();     // Catch: IOException -> L13
    L15:
        r103 = null;
    L17:
        r103 = null;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public static boolean shouldSkipHeapOptimize() {
        if (Build.VERSION.SDK_INT <= sMaxAPISupport) goto L5;
    L8:
        return true;
    L5:
        if (sGlobalSwitchOff == true) goto L8;
        return false;
    }

    private static void stopVssCheckTimer() {
        Timer r100 = sVssCheckTimer;
        if (r100 == null) goto L6;
        r100.cancel();
        sVssCheckTimer = null;
        return;
    }

    public static /* synthetic */ long access$400() {
        return readVssSize();
    }

    public static /* synthetic */ long access$100() {
        return currentRegionSpaces;
    }

    public static /* synthetic */ VssConfig access$200() {
        return sVssConfig;
    }

    public static /* synthetic */ void access$300() {
        stopVssCheckTimer();
    }

    public static /* synthetic */ long access$102(long r100) {
        currentRegionSpaces = r100;
        return r100;
    }

    public static /* synthetic */ boolean access$500(long r100) {
        return shrink_regionspace_vss(r100);
    }

    public static synchronized void heapOptimizeSwitchOff(boolean r100) {
        monitor-enter(HeapGCOptimizer.class);
        sGlobalSwitchOff = r100;     // Catch: Throwable -> L7
        monitor-exit(HeapGCOptimizer.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setHeapOptMaxAPISupport(int r100) {
        monitor-enter(HeapGCOptimizer.class);
        sMaxAPISupport = r100;     // Catch: Throwable -> L7
        monitor-exit(HeapGCOptimizer.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void access$600(int r100, int r101) {
        startVssCheckTimer(r100, r101);
    }

    public static synchronized void initOptimizeRegionSpaceVSS(Context r100, int r101) {
        monitor-enter(HeapGCOptimizer.class);
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L23
        if (r102 >= 26) goto L7;
    L21:
        monitor-exit(HeapGCOptimizer.class);
        return;
    L7:
        if (sGlobalSwitchOff == true) goto L21;
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L27;
    L19:
        monitor-exit(HeapGCOptimizer.class);
        return;
    L27:
        if (sShrinkInited == true) goto L17;
        if (init_4shrink_region_space(r102) == false) goto L17;
        sShrinkInited = true;     // Catch: Throwable -> L26 Throwable -> L23
    L17:
        if (sShrinkInited == false) goto L19;
        init_shrink_region_space_step_size(r101);     // Catch: Throwable -> L26 Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public static synchronized void optimizeRegionSpaceVSS(Context r100, VssConfig r101) {
        monitor-enter(HeapGCOptimizer.class);
        int r102 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L32
        if (r102 >= 26) goto L7;
    L30:
        monitor-exit(HeapGCOptimizer.class);
        return;
    L7:
        if (sGlobalSwitchOff == true) goto L30;
        if (r102 >= 23) goto L12;
    L15:
        sVssConfig = r101;     // Catch: Throwable -> L32
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L36;
    L28:
        monitor-exit(HeapGCOptimizer.class);
        return;
    L36:
        if (sShrinkInited == true) goto L23;
        if (init_4shrink_region_space(r102) == false) goto L23;
        sShrinkInited = true;     // Catch: Throwable -> L35 Throwable -> L32
    L23:
        if (sShrinkInited == false) goto L28;
        VssConfig r103 = sVssConfig;     // Catch: Throwable -> L35 Throwable -> L32
        if (r103.periodOfCheck != (-1)) goto L27;
        shrink_regionspace_vss(((long) r103.shrinkStep) * 1048576);     // Catch: Throwable -> L35 Throwable -> L32
        goto L28
    L27:
        currentRegionSpaces = getCurrentRegionSpaceSize() / 1048576;     // Catch: Throwable -> L35 Throwable -> L32
        startVssCheckTimer(r101.firstDelay, sVssConfig.periodOfCheck);     // Catch: Throwable -> L35 Throwable -> L32
        goto L28
    L12:
        if (Process.is64Bit() == false) goto L15;
        monitor-exit(HeapGCOptimizer.class);
        return;
    L32:
        th = move-exception;
        throw th;
    }

    private static void startVssCheckTimer(int r100, int r101) {
        if (sVssCheckTimer == null) goto L5;
        stopVssCheckTimer();
    L5:
        if (r101 <= 0) goto L7;
        PthreadTimer r102 = new PthreadTimer(TAG);
        sVssCheckTimer = r102;
        AnonymousClass1 r103 = null;
        if (r100 <= 0) goto L12;
        if (r100 <= r101) goto L12;
        r102.schedule(new VssCheckAndShrinkTask(r103), r100 * 1000, r101 * 1000);
        return;
    L12:
        long r104 = r101 * 1000;
        r102.schedule(new VssCheckAndShrinkTask(r103), r104, r104);
        return;
    }

    public static synchronized void heapExpand(Context r100, int r101, boolean r102) {
        monitor-enter(HeapGCOptimizer.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (shouldSkipHeapOptimize() == false) goto L9;
        monitor-exit(HeapGCOptimizer.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L26;
    L18:
        monitor-exit(HeapGCOptimizer.class);
        return;
    L26:
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L23 Throwable -> L20
        if (sInited == true) goto L16;
        if (init(r103) == false) goto L16;
        sInited = true;     // Catch: Throwable -> L23 Throwable -> L20
    L16:
        if (sInited == false) goto L18;
        heap_expand(r101, r102);     // Catch: Throwable -> L23 Throwable -> L20
        goto L18
    }

    public static synchronized void optimize(Context r100, float r101, float r102, float r103) {
        monitor-enter(HeapGCOptimizer.class);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (shouldSkipHeapOptimize() == false) goto L9;
        monitor-exit(HeapGCOptimizer.class);
        return;
    L9:
        if (SysOptimizer.loadOptimizerLibrary(r100) == true) goto L26;
    L18:
        monitor-exit(HeapGCOptimizer.class);
        return;
    L26:
        int r104 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L23 Throwable -> L20
        if (sInited == true) goto L16;
        if (init(r104) == false) goto L16;
        sInited = true;     // Catch: Throwable -> L23 Throwable -> L20
    L16:
        if (sInited == false) goto L18;
        optimize(r104, r101, r102, r103);     // Catch: Throwable -> L23 Throwable -> L20
        goto L18
    }
}
