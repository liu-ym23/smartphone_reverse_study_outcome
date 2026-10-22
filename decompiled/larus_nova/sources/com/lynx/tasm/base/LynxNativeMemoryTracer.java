package com.lynx.tasm.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;

/* JADX INFO: loaded from: classes32.dex */
public class LynxNativeMemoryTracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f381846a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f381847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f381848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f381849d;

    public static class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101.getAction().endsWith("LYNX_MEMORY_TRACING_START") == false) goto L9;
            int r102 = r101.getIntExtra("min_watched_size", -1);
            if (r102 <= 0) goto L7;
            LynxNativeMemoryTracer.b(r102);
            return;
        L7:
            LynxNativeMemoryTracer.b(LynxNativeMemoryTracer.f381846a);
            return;
        L9:
            if (r101.getAction().endsWith("LYNX_MEMORY_TRACING_STOP") == false) goto L12;
            LynxNativeMemoryTracer.c();
            return;
        L12:
            if (r101.getAction().endsWith("LYNX_MEMORY_TRACING_REPORT") == false) goto L21;
            String r103 = r101.getStringExtra("report_dir");
            if (r103 != null) goto L16;
            r103 = r100.getExternalFilesDir(null).getPath() + "/memory-reports";
        L16:
            LynxNativeMemoryTracer.d(r103);
            return;
        }
    }

    public LynxNativeMemoryTracer() {
    }

    private static native void nativeStartTracing(int r100);

    private static native void nativeStopTracing();

    private static native void nativeWriteRecordsToFile(String r100);

    public static void c() {
        if (f381848c == true) goto L5;
        return;
    L5:
        nativeStopTracing();
        f381848c = false;
    }

    public static void a(Context r110) {
        IntentFilter r100 = new IntentFilter();
        r100.addAction(r110.getPackageName() + ".LYNX_MEMORY_TRACING_START");
        r100.addAction(r110.getPackageName() + ".LYNX_MEMORY_TRACING_STOP");
        r100.addAction(r110.getPackageName() + ".LYNX_MEMORY_TRACING_REPORT");
        a r101 = new a();
        if (Build.VERSION.SDK_INT < 34) goto L37;
        if (r110.getApplicationInfo().targetSdkVersion < 34) goto L37;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L71;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L71:
    L31:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r100, 4);
    L64:
        f381847b = true;
        return;
    L35:
        throw e;
    L11:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r100, 4, null, null, 3, r110).result;     // Catch: Exception -> L31
        if (r102 == 1) goto L20;
        if (r102 == 2) goto L19;
        if (r102 == 3) goto L70;
        r110.registerReceiver(r101, r100, 4);     // Catch: Exception -> L31
    L70:
        goto L64
    L19:
        new Intent();     // Catch: Exception -> L31
        goto L70
    L20:
        r110.registerReceiver(r101, r100, 4);     // Catch: Exception -> L31
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L25;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L31
        r110.registerReceiver(r101, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L31
        goto L70
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L27;
    L29:
        r110.registerReceiver(r101, r100, 4);     // Catch: Exception -> L31
        goto L70
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L29;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L31
        ContextCompat.registerReceiver(r110, r101, r100, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L31
    L37:
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L68;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L68:
    L60:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L66;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r100);
        goto L64
    L66:
        throw e;
    L40:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L51;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r100) == false) goto L51;
        int r103 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r100, 0, null, null, 2, r110).result;     // Catch: Exception -> L60
        if (r103 == 1) goto L49;
        if (r103 == 2) goto L48;
        if (r103 == 3) goto L67;
        r110.registerReceiver(r101, r100);     // Catch: Exception -> L60
    L67:
        goto L64
    L48:
        new Intent();     // Catch: Exception -> L60
        goto L67
    L49:
        r110.registerReceiver(r101, r100);     // Catch: Exception -> L60
    L51:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L54;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L60
        r110.registerReceiver(r101, r100, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L60
        goto L67
    L54:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L56;
    L58:
        r110.registerReceiver(r101, r100);     // Catch: Exception -> L60
        goto L67
    L56:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r100) == false) goto L58;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L60
        ContextCompat.registerReceiver(r110, r101, r100, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L60
        goto L67
    }

    public static void b(int r100) {
        if (f381847b == true) goto L5;
        return;
    L5:
        f381849d = 0;
        nativeStartTracing(r100);
        f381848c = true;
    }

    public static void d(String r100) {
        if (f381848c == true) goto L5;
        return;
    L5:
        if (r100 == null) goto L23;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == false) goto L14;
        if (r101.isDirectory() == true) goto L14;
        throw new IllegalArgumentException(r100.concat(" is not a directory"));
    L14:
        if (r101.exists() == false) goto L16;
    L20:
        String r102 = r101.getPath() + "/lynx-native-memory-report-" + f381849d;
        f381849d++;
        nativeWriteRecordsToFile(r102);
        return;
    L16:
        if (r101.mkdirs() == true) goto L20;
        throw new IllegalArgumentException("can not create directory '" + r100 + "'");
    L23:
        throw new NullPointerException("filePath is null");
    }
}
