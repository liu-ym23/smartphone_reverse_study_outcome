package com.bytedance.crash.jni;

import ai4.e;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.crash.NativeCrashSummary;
import com.bytedance.crash.crash.c;
import com.bytedance.crash.i;
import com.bytedance.crash.k;
import com.bytedance.crash.m0;
import com.bytedance.crash.monitor.a;
import com.bytedance.crash.monitor.d;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.u;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.v;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import org.xmlpull.v1.XmlPullParser;
import xg4.p;
import zg4.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class NativeBridge {
    private static volatile boolean isSoLoaded;

    public NativeBridge() {
    }

    private static native void doRegister(String r0, String r1);

    private static native void doSetDropDataState(int r0);

    private static native void nAnrDumpNativeInfo(long r0);

    private static native long nAnrDumpNativeInit(String r0);

    private static native void nAnrDumpNativeRelease(long r0);

    private static native void nAnrDumpTrace(String r0);

    private static native void nAnrEnterMonitorLooper();

    private static native void nAnrInitOnMainThread();

    public static native void nAnrNativeProfilerDump(long r0, String r2, long r3);

    public static native void nAnrNativeProfilerExit(long r0);

    public static native void nAnrNativeProfilerFormat(String r0, long[] r1);

    public static native int nAnrNativeProfilerJvmStart(long r0);

    public static native String nAnrNativeProfilerRunTest(String r0);

    public static native long nAnrNativeProfilerStart();

    public static native void nAnrNativeProfilerStop(long r0);

    private static native void nCheckSigHandler();

    private static native void nCoredumpNativeInit(String r0);

    private static native long nCrashDumpNativeInfo(long r0);

    private static native void nDumpLogcat(String r0, int r1);

    private static native void nDumpOsMemory(String r0);

    private static native void nDumperLateInit();

    private static native void nEnablePrioriryParams(boolean r0, boolean r1, int r2);

    private static native int nFlock(String r0);

    private static native int nGetApexVersion();

    private static native String nGetBuildID(String r0);

    private static native int nGetFdCount(String r0);

    private static native String nGetFdLeakReason(String r0);

    private static native int nGetFdLimit();

    private static native int nGetJvmMonitorState();

    private static native String nGetMallocType();

    private static native String nGetNativePthreadKeyLeakLibrary(String r0);

    private static native String[] nGetOOMReason(String r0);

    private static native String nGetStackTrace(boolean r0);

    private static native int nGetThreadCount(String r0);

    private static native long nGetThreadCpuTimeMills(int r0);

    private static native String nGetThreadLeakLibrary(String r0);

    private static native String nGetThreadLeakName(String r0);

    private static native long nGetVmRss(String r0);

    private static native long nGetVmSize(String r0, int r1);

    private static native int nGetVmaCount(String r0);

    private static native boolean nIncreaseFdLimit();

    private static native boolean nIs64BitRuntime();

    private static native String nLoadNativeCrashAbortReason(String r0);

    private static native String nLoadNativeCrashBacktrace(String r0);

    private static native NativeCrashSummary nLoadNativeCrashSummary(String r0);

    private static native int nNativePthreadKeyCount(String r0);

    private static native void nNotifyUploadDone();

    private static native void nParseSmaps(String r0);

    private static native void nPriorityMonitorInit(String r0);

    private static native void nRecoverSignalHandler();

    private static native void nResetNativeInfoLatches();

    private static native void nSet64Bit(boolean r0);

    private static native void nSetAlogFlushAddr(long r0);

    private static native void nSetAnrDumpAsync(boolean r0);

    private static native void nSetAnrResendSigquit(boolean r0);

    private static native void nSetAppVersion(String r0);

    private static native void nSetDumpTraceTryCatch(boolean r0);

    private static native boolean nSignalToProcess(int r0, int r1);

    private static native void nStartDumperThread();

    private static native int nStartNativeCrashMonitor(int r0, String r1, String r2, String r3, String r4, String r5, int r6, long r7, long r9, String r11);

    private static native void nStartProfilerJavaLockMonitor();

    private static native long nStringDumperCreate(String r0, int r1);

    private static native void nStringDumperDumpByteArray(long r0, byte[] r2, int r3);

    private static native void nStringDumperDumpCharArray(long r0, char[] r2, int r3);

    private static native void nStringDumperDumpString(long r0, String r2, int r3);

    private static native void nStringDumperFlushBuffer(long r0);

    private static native void nStringDumperRelease(long r0);

    private static native void nUnFlock(int r0);

    private static native int nativeDumpHprof(int r0, String r1);

    private static native void nativeDumpTags(String r0);

    private static native String[] nativeGetFdListForAPM();

    private static native String[] nativeGetTags();

    private static native void unRegister(String r0);

    public static boolean G() {
        if (isSoLoaded == true) goto L5;
        return false;
    L5:
        return nIs64BitRuntime();
    }

    public static void L() {
        if (isSoLoaded == false) goto L6;
        nNotifyUploadDone();
        return;
    }

    public static void W() {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetDumpTraceTryCatch(false);
    }

    public static void Y() {
        if (isSoLoaded == false) goto L6;
        nStartDumperThread();
        return;
    }

    public static void a0() {
        if (isSoLoaded == false) goto L6;
        nStartProfilerJavaLockMonitor();
        return;
    }

    public static void g() {
        if (isSoLoaded == false) goto L6;
        nAnrEnterMonitorLooper();
        return;
    }

    public static void h() {
        if (isSoLoaded == false) goto L6;
        nAnrInitOnMainThread();
        return;
    }

    public static void o() {
        if (isSoLoaded == false) goto L6;
        nDumperLateInit();
        return;
    }

    public static int q() {
        if (isSoLoaded == true) goto L9;
        return -1;
    L9:
        return nGetApexVersion();
    L11:
        return -1;
    }

    public static int t() {
        if (isSoLoaded == false) goto L7;
        return nGetFdLimit();
    L7:
        if (Build.VERSION.SDK_INT <= 27) goto L9;
        return 32768;
    L9:
        return 1024;
    }

    public static int u() {
        if (isSoLoaded == true) goto L9;
        return -1;
    L9:
        return nGetJvmMonitorState();
    L11:
        return -1;
    }

    public static String v() {
        if (isSoLoaded == true) goto L9;
        return null;
    L9:
        return nGetMallocType();
    L11:
        return null;
    }

    public static String y() {
        if (isSoLoaded == true) goto L9;
        return null;
    L9:
        return nGetStackTrace(true);
    L8:
        return null;
    }

    public static HashMap<String, String> z() {
        String[] r0 = nativeGetTags();
        HashMap<String, String> r1 = new HashMap();
        if (r0 != null) goto L15;
        return r1;
    L15:
        if (r0.length >= 1) goto L8;
        return r1;
    L8:
        int r2 = 0;
    L10:
        if (r2 >= r0.length) goto L13;
        r1.put(r0[r2], r0[r2 + 1]);     // Catch: Throwable -> L14
        r2 = r2 + 2;
    L13:
        return r1;
    }

    public static boolean H() {
        return isSoLoaded;
    }

    public static int A(String r1) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nGetThreadCount(r1);
    }

    public static String B(File r1) {
        if (isSoLoaded == false) goto L5;
        String r2 = nGetThreadLeakLibrary(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return "unknown";
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static String C(File r1) {
        if (isSoLoaded == false) goto L5;
        String r2 = nGetThreadLeakName(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return "unknown";
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static long D(String r2) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nGetVmRss(r2);
    }

    public static int F(String r1) {
        if (isSoLoaded == true) goto L7;
        return 0;
    L7:
        return nGetVmaCount(r1);
    }

    public static String I(String r1) {
        if (isSoLoaded == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashAbortReason(r1);
    }

    public static String J(String r1) {
        if (isSoLoaded == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashBacktrace(r1);
    }

    public static NativeCrashSummary K(String r1) {
        if (isSoLoaded == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashSummary(r1);
    }

    public static void M(String r1) {
        if (isSoLoaded == false) goto L6;
        nParseSmaps(r1);
        return;
    }

    public static void N(String r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        if (r1.length() <= 0) goto L9;
        nPriorityMonitorInit(r1);
        return;
    }

    public static void P(String r1) {
        if (isSoLoaded == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return;
    L8:
        unRegister(r1);
    }

    public static void Q(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSet64Bit(r1);
    }

    public static void R(long r1) {
        if (isSoLoaded == false) goto L6;
        nSetAlogFlushAddr(r1);
        return;
    }

    public static void S(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrDumpAsync(r1);
    }

    public static void T(boolean r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrResendSigquit(r1);
    }

    public static void U(String r1) {
        if (isSoLoaded == false) goto L6;
        nSetAppVersion(r1);
        return;
    }

    public static void V(int r1) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        doSetDropDataState(r1);
    }

    public static String a(String r1) {
        if (isSoLoaded == true) goto L5;
        return null;
    L5:
        return nGetBuildID(r1);
    }

    public static int b(String r1) {
        if (isSoLoaded == true) goto L7;
        return 0;
    L7:
        return nNativePthreadKeyCount(r1);
    }

    public static void c(long r1) {
        if (isSoLoaded == false) goto L6;
        nAnrDumpNativeInfo(r1);
        return;
    }

    public static void d(long r1) {
        if (isSoLoaded == false) goto L6;
        nAnrDumpNativeRelease(r1);
        return;
    }

    public static void e(String r1) {
        if (isSoLoaded == false) goto L6;
        nAnrDumpTrace(r1);
        return;
    }

    public static void e0(long r1) {
        if (isSoLoaded == false) goto L6;
        nStringDumperFlushBuffer(r1);
        return;
    }

    public static long f(String r2) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nAnrDumpNativeInit(r2);
    }

    public static void f0(long r1) {
        if (isSoLoaded == false) goto L6;
        nStringDumperRelease(r1);
        return;
    }

    public static void g0(int r1) {
        if (isSoLoaded == false) goto L6;
        nUnFlock(r1);
        return;
    }

    public static void i(String r1) {
        if (isSoLoaded == false) goto L6;
        nCoredumpNativeInit(r1);
        return;
    }

    public static long j(long r1) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nCrashDumpNativeInfo(r1);
    }

    public static void k(String r1) {
        if (isSoLoaded == true) goto L8;
        return;
    L8:
        nativeDumpHprof(Build.VERSION.SDK_INT, r1);     // Catch: Throwable -> L7
        return;
    }

    public static void m(String r2) {
        if (isSoLoaded == false) goto L6;
        nDumpOsMemory(r2);
        SystemClock.sleep(1000);
        return;
    }

    public static void n(String r1) {
        if (isSoLoaded == true) goto L8;
        return;
    L8:
        nativeDumpTags(r1);     // Catch: Throwable -> L7
        return;
    }

    public static int p(String r1) {
        if (isSoLoaded == true) goto L5;
        return -1;
    L5:
        return nFlock(r1);
    }

    public static int r(String r1) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nGetFdCount(r1);
    }

    public static String s(File r1) {
        if (isSoLoaded == false) goto L5;
        String r2 = nGetFdLeakReason(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return "unknown";
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static String[] w(String r1) {
        if (isSoLoaded == true) goto L7;
        return null;
    L7:
        return nGetOOMReason(r1);
    }

    public static String x(File r1) {
        if (isSoLoaded == false) goto L5;
        String r2 = nGetNativePthreadKeyLeakLibrary(r1.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return "unknown";
    L10:
        return r2;
    L5:
        r2 = null;
        goto L7
    }

    public static long E(String r1, boolean r2) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nGetVmSize(r1, r2 ? 1 : 0);
    }

    public static void O(String r1, String r2) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        doRegister(r1, r2);
    }

    public static void Z(Context r13, File r14) {
        if (isSoLoaded == false) goto L12;
        String r3 = r14.getAbsolutePath();
        String r2 = r13.getApplicationInfo().nativeLibraryDir;
        PolarisFileWrapper r15 = f.e.b;
        if (r15.exists() == true) goto L7;
        r15.mkdirs();
    L7:
        String r4 = new PolarisFileWrapper(r15, c.a()).getAbsolutePath();
        int r1 = Build.VERSION.SDK_INT;
        e.b();
        PolarisFileWrapper r16 = e.d;
        if (r16 != null) goto L10;
        String r17 = XmlPullParser.NO_NAMESPACE;
    L11:
        nStartNativeCrashMonitor(r1, r2, r3, r4, r17, i.e(r13).getAbsolutePath(), 4020259, i.b(), i.a().f, i.j);
        return;
    L10:
        r17 = r16.getAbsolutePath();
        goto L11
    L12:
        ch4.c.b("npth so load fail", new Exception());
    }

    public static long b0(String r1, int r2) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nStringDumperCreate(r1, r2);
    }

    private static void handleCrashFromDumperThread(long r12, int r14) {
        i.i = true;
        c r0 = c.d;
        if (r0 == null) goto L39;
        com.bytedance.crash.crash.f r1 = r0.b;
        r1.getClass();
        if (r12 > 0) goto L47;
    L23:
        r1.a.a(r12, false, com.bytedance.crash.crash.f.b, com.bytedance.crash.crash.f.c, r14);
        if (r12 <= 0) goto L59;
        String r13 = J(r1.a.a.getAbsolutePath());
        if (TextUtils.isEmpty(r13) == true) goto L60;
        Iterator<d> r15 = d.o.iterator();
    L29:
        if (r15.hasNext() == false) goto L61;
        d r16 = r15.next();
        if (r16 == null) goto L29;
        Iterator<ICrashCallback> r17 = r16.c.f(CrashType.NATIVE).iterator();
    L34:
        if (r17.hasNext() == false) goto L29;
        ICrashCallback r2 = r17.next();
        r2.onCrash(CrashType.NATIVE, r13, null);     // Catch: Throwable -> L38
        goto L34
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L47:
        a r3 = j.a;     // Catch: Throwable -> L22
        if (r3 == null) goto L23;
        m0 r4 = r3.c;     // Catch: Throwable -> L22
        CrashType r5 = CrashType.NATIVE;     // Catch: Throwable -> L22
        ListMap<CrashType, v> r6 = r4.j;     // Catch: Throwable -> L22
        monitor-enter(r6);     // Catch: Throwable -> L22
        List<v> r7 = r4.j.getList(r5);     // Catch: Throwable -> L19
        monitor-exit(r6);     // Catch: Throwable -> L19
        Iterator<v> r8 = r7.iterator();     // Catch: Throwable -> L22
    L15:
        if (r8.hasNext() == false) goto L23;
        v r9 = r8.next();     // Catch: Throwable -> L22
        CrashType r10 = CrashType.LAUNCH;     // Catch: Throwable -> L40
        r9.a();     // Catch: Throwable -> L40
        goto L15
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    }

    public static void l(String r2, boolean r3) {
        if (isSoLoaded == false) goto L18;
        if (Build.VERSION.SDK_INT != 23) goto L12;
        String r0 = Build.MANUFACTURER;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r0) == true) goto L12;
        if (r0.toLowerCase(Locale.getDefault()).contains("oppo") == false) goto L12;
        return;
    L12:
        nDumpLogcat(r2, 1);
        if (r3 == false) goto L19;
        SystemClock.sleep(1000);
        return;
    L19:
        return;
    }

    private static void reportAnrEventFromNative(int r9, int r10) {
        p r0 = p.h;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L39;
        a r2 = j.a;     // Catch: Throwable -> L28
        if (r2 == null) goto L34;
        Iterator r3 = ((CopyOnWriteArrayList) r2.c.l).iterator();     // Catch: Throwable -> L28
    L13:
        if (r3.hasNext() == false) goto L34;
        ((u) r3.next()).a();     // Catch: Throwable -> L27
    L34:
        long r4 = System.currentTimeMillis();     // Catch: Throwable -> L24
        if (k.b == false) goto L20;
        p.h.c(r4, r9, r10);     // Catch: Throwable -> L24
    L33:
        return;
    L20:
        p r5 = p.h;     // Catch: Throwable -> L24
        if ((r4 - r5.g) < 5000) goto L33;
        r5.g = r4;     // Catch: Throwable -> L24
        r5.a(r4, true, null, r9, r10);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        xg4.a.c(th);
        return;
    L39:
        return;
    L5:
        if (r0.e == false) goto L7;
        r1 = true;
        goto L8
    }

    public static void X(boolean r1, boolean r2, int r3) {
        if (isSoLoaded == false) goto L6;
        nEnablePrioriryParams(r1, r2, r3);
        return;
    }

    public static void c0(long r1, char[] r3, int r4) {
        if (isSoLoaded == false) goto L6;
        nStringDumperDumpCharArray(r1, r3, r4);
        return;
    }

    public static void d0(long r1, String r3, int r4) {
        if (isSoLoaded == false) goto L6;
        nStringDumperDumpString(r1, r3, r4);
        return;
    }
}
