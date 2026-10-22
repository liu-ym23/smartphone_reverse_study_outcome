package com.bytedance.sysoptimizer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.anr.AnrListener;
import com.bytedance.sysoptimizer.anr.AnrManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class AnrThreadPriorityOpt {
    private static final String TAG = "AnrThreadPriorityOpt";
    private static final String THREAD_PRIORTY_INTENT = "debug_thread_priorty_intent";
    private static HashMap<Integer, Integer> lastThreadPriortyMap;
    private static AnrListener mAnrListener;
    private static DebugBroadcastReceiver myBroadcastReceiver;
    private static boolean sDebug;
    private static boolean sEnableLockOpt;
    private static volatile boolean sInit;
    private static List<String> sThreadPriortyWhiteList;
    private static boolean sUseNative;

    public static class DebugBroadcastReceiver extends BroadcastReceiver {
        private static final String TAG = "AnrOptTaskReceiver";

        private DebugBroadcastReceiver() {
        }

        public /* synthetic */ DebugBroadcastReceiver(AnonymousClass1 r100) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, Intent r101) {
            String r102 = r101.getAction();
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.equals(AnrThreadPriorityOpt.THREAD_PRIORTY_INTENT) == false) goto L10;
            AnrThreadPriorityOpt.getAllThreadPriorty();
            return;
        }
    }

    public AnrThreadPriorityOpt() {
    }

    private static native HashMap<Integer, Integer> nativeGetAllThreadPriority(List<String> r100, boolean r101);

    static {
        sThreadPriortyWhiteList = new ArrayList();
        lastThreadPriortyMap = new HashMap();
        myBroadcastReceiver = new DebugBroadcastReceiver(null);
        sInit = false;
        sDebug = false;
        sEnableLockOpt = false;
        sUseNative = false;
        mAnrListener = new AnonymousClass1();
    }

    public static HashMap<Integer, Integer> getAllThreadPriorty() {
        if (sUseNative == true) goto L5;
        long r100 = Debug.threadCpuTimeNanos();
        HashMap<Integer, Integer> r101 = new HashMap();
        PolarisFileWrapper r102 = new PolarisFileWrapper("/proc/self/task");
        if (r102.exists() == true) goto L9;
    L25:
        long r103 = (Debug.threadCpuTimeNanos() - r100) / 1000000;
        return r101;
    L9:
        if (r102.isDirectory() == false) goto L25;
        File[] r104 = r102.listFiles();
        if (r104 == null) goto L25;
        int r105 = r104.length;
        int r106 = 0;
    L13:
        if (r106 >= r105) goto L25;
        int r107 = CastIntegerProtector.parseInt(r104[r106].getName());     // Catch: Exception -> L22
        int r108 = Process.getThreadPriority(r107);     // Catch: Exception -> L22
        if (r108 >= 0) goto L24;
        String r109 = getThreadName(r107).replaceAll("\\d+", "*");     // Catch: Exception -> L22
        if (sThreadPriortyWhiteList.contains(r109) == true) goto L24;
        r101.put(Integer.valueOf(r107), Integer.valueOf(r108));     // Catch: Exception -> L22
    L24:
        r106 = r106 + 1;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L5:
        return nativeGetAllThreadPriority(sThreadPriortyWhiteList, sDebug);
    }

    public static /* synthetic */ HashMap access$100() {
        return lastThreadPriortyMap;
    }

    public static /* synthetic */ boolean access$300() {
        return sEnableLockOpt;
    }

    public static /* synthetic */ boolean access$400() {
        return sDebug;
    }

    public static /* synthetic */ HashMap access$102(HashMap r100) {
        lastThreadPriortyMap = r100;
        return r100;
    }

    public static /* synthetic */ void access$200(HashMap r100) {
        setThreadPriorty(r100);
    }

    public static /* synthetic */ void access$500(HashMap r100) {
        restoreThreadPriorty(r100);
    }

    public static void enableLockOpt(Boolean r100) {
        sEnableLockOpt = r100.booleanValue();
    }

    private static String getThreadName(int r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper("/proc/self/task/" + r100 + "/comm");
        if (r101.exists() == false) goto L27;
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper(r101));     // Catch: IOException -> L16
        String r103 = r102.readLine();     // Catch: Throwable -> L8
        r102.close();     // Catch: IOException -> L16
        return r103;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        r102.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: IOException -> L16
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L16
    L16:
        e = move-exception;
        e.printStackTrace();
        return "Unknown";
    L27:
        return "Unknown";
    }

    private static void restoreThreadPriorty(HashMap<Integer, Integer> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L25;
        Iterator<Map.Entry<Integer, Integer>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        Map.Entry<Integer, Integer> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        int r104 = r102.getValue().intValue();
        if (Process.getThreadPriority(r103) != 0) goto L7;
        Process.setThreadPriority(r103, r104);     // Catch: Throwable -> L13
        goto L7
    L14:
        r100.clear();
        return;
    }

    private static void setThreadPriorty(HashMap<Integer, Integer> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() <= 0) goto L29;
        int r101 = Process.myPid();
        Iterator<Map.Entry<Integer, Integer>> r102 = r100.entrySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L30;
        int r103 = r102.next().getKey().intValue();
        if (r101 == r103) goto L18;
        if (Process.getThreadPriority(r103) >= 0) goto L7;
        Process.setThreadPriority(r103, 0);     // Catch: Throwable -> L16
        goto L7
    L18:
        Process.setThreadPriority(r103, -20);     // Catch: Throwable -> L16
        goto L7
    L30:
        return;
    }

    private static void localTestDebug(Context r100, Boolean r101) {
        if (r101.booleanValue() == false) goto L6;
        IntentFilter r102 = new IntentFilter();
        r102.addAction(THREAD_PRIORTY_INTENT);
        INVOKEVIRTUAL_com_bytedance_sysoptimizer_AnrThreadPriorityOpt_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, myBroadcastReceiver, r102);
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_sysoptimizer_AnrThreadPriorityOpt_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    public static void init(Context r100, List<String> r101, boolean r102, boolean r103) {
        if (sInit == true) goto L9;
        SysOptimizer.loadOptimizerLibrary(r100);
        sInit = true;
        sDebug = r103;
        sUseNative = r102;
        if (r101 == null) goto L7;
        sThreadPriortyWhiteList = r101;
    L7:
        localTestDebug(r100, Boolean.valueOf(r103));
        AnrManager.getInstance().registerListener(mAnrListener);
        return;
    }
}
