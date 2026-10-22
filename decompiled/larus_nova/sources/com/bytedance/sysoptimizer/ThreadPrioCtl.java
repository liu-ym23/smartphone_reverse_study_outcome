package com.bytedance.sysoptimizer;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes22.dex */
public class ThreadPrioCtl {
    private static final long DELAY_MASK = -256;
    private static final int DELAY_RIGHT_MOVE_TIME = 8;
    private static final int MAX_TASK_COMM_LEN = 16;
    private static final long PRIO_MASK = 255;
    private static final int SECOND_TO_MILLISECOND = 1000;
    private static final String TAG = "ThreadPrioCtrl";
    private static volatile boolean isOptDone;
    private static char[] sComm;
    private static int sFgActivityCount;
    private static long sOptStartTime;
    private static ScheduledExecutorService sScheduledExecutorService;
    private static int sTargetThreadNum;
    private static Map<String, String> sTargetThreadPrioInfo;
    private static boolean sUseNativeImpl;

    public ThreadPrioCtl() {
    }

    private static native void nChangeThreadPrios(String[] r100, String[] r101, int r102, long r103);

    public static /* synthetic */ int access$008() {
        int r100 = sFgActivityCount;
        sFgActivityCount = r100 + 1;
        return r100;
    }

    public static /* synthetic */ int access$010() {
        int r100 = sFgActivityCount;
        sFgActivityCount = r100 - 1;
        return r100;
    }

    private static void changeThreadPrios() {
        if (isOptDone == false) goto L5;
        return;
    L5:
        monitor-enter(ThreadPrioCtl.class);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (isOptDone == true) goto L12;
        isOptDone = true;     // Catch: Throwable -> L14
        if (sUseNativeImpl == false) goto L11;
        nChangeThreadPrios((String[]) sTargetThreadPrioInfo.keySet().toArray(new String[0]), (String[]) sTargetThreadPrioInfo.values().toArray(new String[0]), sTargetThreadNum, sOptStartTime);     // Catch: Throwable -> L14
        goto L12
    L11:
        changeThreadPriosJava();     // Catch: Throwable -> L14
    L12:
        monitor-exit(ThreadPrioCtl.class);     // Catch: Throwable -> L14
    }

    private static void changeThreadPriosJava() {
        PolarisFileWrapper r100 = new PolarisFileWrapper("/proc/self/task");
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.isDirectory() == false) goto L34;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L35;
        int r102 = r101.length;
        int r103 = 0;
        int r104 = 0;
    L9:
        if (r103 >= r102) goto L36;
        File r105 = r101[r103];
        if (r104 >= sTargetThreadNum) goto L12;
        final int r106 = CastIntegerProtector.parseInt(r105.getName());
        String r107 = getThreadName(r106);
        if (sTargetThreadPrioInfo.keySet().contains(r107) == false) goto L24;
        r104 = r104 + 1;
        Process.getThreadPriority(r106);
        long r108 = CastLongProtector.parseLong(sTargetThreadPrioInfo.get(r107));
        final int r109 = ((int) (255 & r108)) - 20;
        int r110 = (int) ((r108 & DELAY_MASK) >> 8);
        long r111 = System.currentTimeMillis();
        long r112 = sOptStartTime;
        long r113 = r110 * 1000;
        if ((r111 - r112) > r113) goto L18;
        int r114 = (int) (((r112 + r113) - System.currentTimeMillis()) / 1000);
    L20:
        if (r114 == 0) goto L27;
        sScheduledExecutorService.schedule(new AnonymousClass1(r106, r109), r114, TimeUnit.SECONDS);
        goto L24
    L27:
        Process.setThreadPriority(r106, r109);     // Catch: Exception -> L26
    L22:
        Process.getThreadPriority(r106);
        goto L24
    L18:
        r114 = 0;
    L24:
        r103 = r103 + 1;
        goto L9
    L12:
        return;
    L36:
        return;
    L35:
        return;
    }

    public static /* synthetic */ int access$000() {
        return sFgActivityCount;
    }

    public static /* synthetic */ void access$100() {
        changeThreadPrios();
    }

    public static /* synthetic */ ScheduledExecutorService access$200() {
        return sScheduledExecutorService;
    }

    public static /* synthetic */ boolean access$302(boolean r100) {
        isOptDone = r100;
        return r100;
    }

    private static String getThreadName(int r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper("/proc/self/task/" + r100 + "/comm");
        if (r101.exists() == false) goto L33;
        PolarisFileReaderWrapper r102 = new PolarisFileReaderWrapper(r101);     // Catch: IOException -> L22
        int r103 = r102.read(sComm);     // Catch: Throwable -> L14
        if (r103 > 0) goto L8;
    L12:
        r102.close();     // Catch: IOException -> L22
        return "Unknown";
    L8:
        if (r103 > 16) goto L12;
        String r104 = new String(sComm, 0, r103 - 1);     // Catch: Throwable -> L14
        r102.close();     // Catch: IOException -> L22
        return r104;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L19
    L21:
        throw th;     // Catch: IOException -> L22
    L19:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        return "Unknown";
    L33:
        return "Unknown";
    }

    public static void startOpt(Context r100, ScheduledExecutorService r101, Map<String, String> r102, int r103, boolean r104) {
        sScheduledExecutorService = r101;
        sTargetThreadPrioInfo = r102;
        sOptStartTime = System.currentTimeMillis();
        sTargetThreadNum = r103;
        sUseNativeImpl = r104;
        if (r104 == true) goto L9;
        sComm = new char[16];
    L9:
        SysOptimizer.loadOptimizerLibrary(r100);     // Catch: Exception -> L8
        changeThreadPrios();     // Catch: Exception -> L8
    L6:
        ((Application) r100.getApplicationContext()).registerActivityLifecycleCallbacks(new AnonymousClass2());
    }
}
