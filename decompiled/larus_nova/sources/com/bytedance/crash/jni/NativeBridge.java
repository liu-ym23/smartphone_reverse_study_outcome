package com.bytedance.crash.jni;

import ai4.e;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
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
import xg4.p;
import zg4.f;

/* JADX INFO: loaded from: classes.dex */
public class NativeBridge {
    private static volatile boolean isSoLoaded;

    public NativeBridge() {
    }

    private static native void doRegister(String r100, String r101);

    private static native void doSetDropDataState(int r100);

    private static native void nAnrDumpNativeInfo(long r100);

    private static native long nAnrDumpNativeInit(String r100);

    private static native void nAnrDumpNativeRelease(long r100);

    private static native void nAnrDumpTrace(String r100);

    private static native void nAnrEnterMonitorLooper();

    private static native void nAnrInitOnMainThread();

    public static native void nAnrNativeProfilerDump(long r100, String r101, long r102);

    public static native void nAnrNativeProfilerExit(long r100);

    public static native void nAnrNativeProfilerFormat(String r100, long[] r101);

    public static native int nAnrNativeProfilerJvmStart(long r100);

    public static native String nAnrNativeProfilerRunTest(String r100);

    public static native long nAnrNativeProfilerStart();

    public static native void nAnrNativeProfilerStop(long r100);

    private static native void nCheckSigHandler();

    private static native void nCoredumpNativeInit(String r100);

    private static native long nCrashDumpNativeInfo(long r100);

    private static native void nDumpLogcat(String r100, int r101);

    private static native void nDumpOsMemory(String r100);

    private static native void nDumperLateInit();

    private static native void nEnablePrioriryParams(boolean r100, boolean r101, int r102);

    private static native int nFlock(String r100);

    private static native int nGetApexVersion();

    private static native String nGetBuildID(String r100);

    private static native int nGetFdCount(String r100);

    private static native String nGetFdLeakReason(String r100);

    private static native int nGetFdLimit();

    private static native int nGetJvmMonitorState();

    private static native String nGetMallocType();

    private static native String nGetNativePthreadKeyLeakLibrary(String r100);

    private static native String[] nGetOOMReason(String r100);

    private static native String nGetStackTrace(boolean r100);

    private static native int nGetThreadCount(String r100);

    private static native long nGetThreadCpuTimeMills(int r100);

    private static native String nGetThreadLeakLibrary(String r100);

    private static native String nGetThreadLeakName(String r100);

    private static native long nGetVmRss(String r100);

    private static native long nGetVmSize(String r100, int r101);

    private static native int nGetVmaCount(String r100);

    private static native boolean nIncreaseFdLimit();

    private static native boolean nIs64BitRuntime();

    private static native String nLoadNativeCrashAbortReason(String r100);

    private static native String nLoadNativeCrashBacktrace(String r100);

    private static native NativeCrashSummary nLoadNativeCrashSummary(String r100);

    private static native int nNativePthreadKeyCount(String r100);

    private static native void nNotifyUploadDone();

    private static native void nParseSmaps(String r100);

    private static native void nPriorityMonitorInit(String r100);

    private static native void nRecoverSignalHandler();

    private static native void nResetNativeInfoLatches();

    private static native void nSet64Bit(boolean r100);

    private static native void nSetAlogFlushAddr(long r100);

    private static native void nSetAnrDumpAsync(boolean r100);

    private static native void nSetAnrResendSigquit(boolean r100);

    private static native void nSetAppVersion(String r100);

    private static native void nSetDumpTraceTryCatch(boolean r100);

    private static native boolean nSignalToProcess(int r100, int r101);

    private static native void nStartDumperThread();

    private static native int nStartNativeCrashMonitor(int r100, String r101, String r102, String r103, String r104, String r105, int r106, long r107, long r108, String r110);

    private static native void nStartProfilerJavaLockMonitor();

    private static native long nStringDumperCreate(String r100, int r101);

    private static native void nStringDumperDumpByteArray(long r100, byte[] r101, int r102);

    private static native void nStringDumperDumpCharArray(long r100, char[] r101, int r102);

    private static native void nStringDumperDumpString(long r100, String r101, int r102);

    private static native void nStringDumperFlushBuffer(long r100);

    private static native void nStringDumperRelease(long r100);

    private static native void nUnFlock(int r100);

    private static native int nativeDumpHprof(int r100, String r101);

    private static native void nativeDumpTags(String r100);

    private static native String[] nativeGetFdListForAPM();

    private static native String[] nativeGetTags();

    private static native void unRegister(String r100);

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
        String[] r100 = nativeGetTags();
        HashMap<String, String> r101 = new HashMap();
        if (r100 != null) goto L15;
        return r101;
    L15:
        if (r100.length >= 1) goto L8;
        return r101;
    L8:
        int r102 = 0;
    L10:
        if (r102 >= r100.length) goto L13;
        r101.put(r100[r102], r100[r102 + 1]);     // Catch: Throwable -> L14
        r102 = r102 + 2;
    L13:
        return r101;
    }

    public static boolean H() {
        return isSoLoaded;
    }

    public static int A(String r100) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nGetThreadCount(r100);
    }

    public static String B(File r100) {
        if (isSoLoaded == false) goto L5;
        String r101 = nGetThreadLeakLibrary(r100.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return "unknown";
    L10:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public static String C(File r100) {
        if (isSoLoaded == false) goto L5;
        String r101 = nGetThreadLeakName(r100.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return "unknown";
    L10:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public static long D(String r100) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nGetVmRss(r100);
    }

    public static int F(String r100) {
        if (isSoLoaded == true) goto L7;
        return 0;
    L7:
        return nGetVmaCount(r100);
    }

    public static String I(String r100) {
        if (isSoLoaded == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashAbortReason(r100);
    }

    public static String J(String r100) {
        if (isSoLoaded == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashBacktrace(r100);
    }

    public static NativeCrashSummary K(String r100) {
        if (isSoLoaded == true) goto L5;
        return null;
    L5:
        return nLoadNativeCrashSummary(r100);
    }

    public static void M(String r100) {
        if (isSoLoaded == false) goto L6;
        nParseSmaps(r100);
        return;
    }

    public static void N(String r100) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        if (r100.length() <= 0) goto L9;
        nPriorityMonitorInit(r100);
        return;
    }

    public static void P(String r100) {
        if (isSoLoaded == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        unRegister(r100);
    }

    public static void Q(boolean r100) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSet64Bit(r100);
    }

    public static void R(long r100) {
        if (isSoLoaded == false) goto L6;
        nSetAlogFlushAddr(r100);
        return;
    }

    public static void S(boolean r100) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrDumpAsync(r100);
    }

    public static void T(boolean r100) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        nSetAnrResendSigquit(r100);
    }

    public static void U(String r100) {
        if (isSoLoaded == false) goto L6;
        nSetAppVersion(r100);
        return;
    }

    public static void V(int r100) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        doSetDropDataState(r100);
    }

    public static String a(String r100) {
        if (isSoLoaded == true) goto L5;
        return null;
    L5:
        return nGetBuildID(r100);
    }

    public static int b(String r100) {
        if (isSoLoaded == true) goto L7;
        return 0;
    L7:
        return nNativePthreadKeyCount(r100);
    }

    public static void c(long r100) {
        if (isSoLoaded == false) goto L6;
        nAnrDumpNativeInfo(r100);
        return;
    }

    public static void d(long r100) {
        if (isSoLoaded == false) goto L6;
        nAnrDumpNativeRelease(r100);
        return;
    }

    public static void e(String r100) {
        if (isSoLoaded == false) goto L6;
        nAnrDumpTrace(r100);
        return;
    }

    public static void e0(long r100) {
        if (isSoLoaded == false) goto L6;
        nStringDumperFlushBuffer(r100);
        return;
    }

    public static long f(String r100) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nAnrDumpNativeInit(r100);
    }

    public static void f0(long r100) {
        if (isSoLoaded == false) goto L6;
        nStringDumperRelease(r100);
        return;
    }

    public static void g0(int r100) {
        if (isSoLoaded == false) goto L6;
        nUnFlock(r100);
        return;
    }

    public static void i(String r100) {
        if (isSoLoaded == false) goto L6;
        nCoredumpNativeInit(r100);
        return;
    }

    public static long j(long r100) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nCrashDumpNativeInfo(r100);
    }

    public static void k(String r100) {
        if (isSoLoaded == true) goto L8;
        return;
    L8:
        nativeDumpHprof(Build.VERSION.SDK_INT, r100);     // Catch: Throwable -> L7
        return;
    }

    public static void m(String r100) {
        if (isSoLoaded == false) goto L6;
        nDumpOsMemory(r100);
        SystemClock.sleep(1000);
        return;
    }

    public static void n(String r100) {
        if (isSoLoaded == true) goto L8;
        return;
    L8:
        nativeDumpTags(r100);     // Catch: Throwable -> L7
        return;
    }

    public static int p(String r100) {
        if (isSoLoaded == true) goto L5;
        return -1;
    L5:
        return nFlock(r100);
    }

    public static int r(String r100) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nGetFdCount(r100);
    }

    public static String s(File r100) {
        if (isSoLoaded == false) goto L5;
        String r101 = nGetFdLeakReason(r100.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return "unknown";
    L10:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public static String[] w(String r100) {
        if (isSoLoaded == true) goto L7;
        return null;
    L7:
        return nGetOOMReason(r100);
    }

    public static String x(File r100) {
        if (isSoLoaded == false) goto L5;
        String r101 = nGetNativePthreadKeyLeakLibrary(r100.getAbsolutePath());
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return "unknown";
    L10:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public static long E(String r100, boolean r101) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nGetVmSize(r100, r101 ? 1 : 0);
    }

    public static void O(String r100, String r101) {
        if (isSoLoaded == true) goto L5;
        return;
    L5:
        doRegister(r100, r101);
    }

    public static void Z(Context r110, File r111) {
        if (isSoLoaded == false) goto L12;
        String r100 = r111.getAbsolutePath();
        String r101 = r110.getApplicationInfo().nativeLibraryDir;
        PolarisFileWrapper r112 = f.f572067e.f572069b;
        if (r112.exists() == true) goto L7;
        r112.mkdirs();
    L7:
        String r102 = new PolarisFileWrapper(r112, c.a()).getAbsolutePath();
        int r103 = Build.VERSION.SDK_INT;
        e.b();
        PolarisFileWrapper r113 = e.f3757d;
        if (r113 != null) goto L10;
        String r114 = "";
    L11:
        nStartNativeCrashMonitor(r103, r101, r100, r102, r114, i.e(r110).getAbsolutePath(), 4020259, i.b(), i.a().f203226f, i.f203220j);
        return;
    L10:
        r114 = r113.getAbsolutePath();
        goto L11
    L12:
        ch4.c.b("npth so load fail", new Exception());
    }

    public static long b0(String r100, int r101) {
        if (isSoLoaded == true) goto L5;
        return 0;
    L5:
        return nStringDumperCreate(r100, r101);
    }

    private static void handleCrashFromDumperThread(long r110, int r111) {
        i.f203219i = true;
        c r100 = c.f203123d;
        if (r100 == null) goto L39;
        com.bytedance.crash.crash.f r101 = r100.f203125b;
        r101.getClass();
        if (r110 > 0) goto L47;
    L23:
        r101.f203141a.a(r110, false, com.bytedance.crash.crash.f.f203139b, com.bytedance.crash.crash.f.f203140c, r111);
        if (r110 <= 0) goto L59;
        String r112 = J(r101.f203141a.f203098a.getAbsolutePath());
        if (TextUtils.isEmpty(r112) == true) goto L60;
        Iterator<d> r113 = d.f203274o.iterator();
    L29:
        if (r113.hasNext() == false) goto L61;
        d r114 = r113.next();
        if (r114 == null) goto L29;
        Iterator<ICrashCallback> r115 = r114.f203291c.f(CrashType.NATIVE).iterator();
    L34:
        if (r115.hasNext() == false) goto L29;
        ICrashCallback r102 = r115.next();
        r102.onCrash(CrashType.NATIVE, r112, null);     // Catch: Throwable -> L38
        goto L34
    L61:
        return;
    L60:
        return;
    L59:
        return;
    L47:
        a r103 = j.f203315a;     // Catch: Throwable -> L22
        if (r103 == null) goto L23;
        m0 r104 = r103.f203291c;     // Catch: Throwable -> L22
        CrashType r105 = CrashType.NATIVE;     // Catch: Throwable -> L22
        ListMap<CrashType, v> r106 = r104.f203247j;     // Catch: Throwable -> L22
        monitor-enter(r106);     // Catch: Throwable -> L22
        List<v> r107 = r104.f203247j.getList(r105);     // Catch: Throwable -> L19
        monitor-exit(r106);     // Catch: Throwable -> L19
        Iterator<v> r108 = r107.iterator();     // Catch: Throwable -> L22
    L15:
        if (r108.hasNext() == false) goto L23;
        v r109 = r108.next();     // Catch: Throwable -> L22
        CrashType r116 = CrashType.LAUNCH;     // Catch: Throwable -> L40
        r109.a();     // Catch: Throwable -> L40
        goto L15
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    }

    public static void l(String r100, boolean r101) {
        if (isSoLoaded == false) goto L18;
        if (Build.VERSION.SDK_INT != 23) goto L12;
        String r102 = Build.MANUFACTURER;     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (r102.toLowerCase(Locale.getDefault()).contains(AppConstants.CHANNEL_OPPO) == false) goto L12;
        return;
    L12:
        nDumpLogcat(r100, 1);
        if (r101 == false) goto L19;
        SystemClock.sleep(1000);
        return;
    L19:
        return;
    }

    private static void reportAnrEventFromNative(int r100, int r110) {
        p r101 = p.f563716h;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L39;
        a r103 = j.f203315a;     // Catch: Throwable -> L28
        if (r103 == null) goto L34;
        Iterator r104 = ((CopyOnWriteArrayList) r103.f203291c.f203249l).iterator();     // Catch: Throwable -> L28
    L13:
        if (r104.hasNext() == false) goto L34;
        ((u) r104.next()).a();     // Catch: Throwable -> L27
    L34:
        long r105 = System.currentTimeMillis();     // Catch: Throwable -> L24
        if (k.f203232b == false) goto L20;
        p.f563716h.c(r105, r100, r110);     // Catch: Throwable -> L24
    L33:
        return;
    L20:
        p r106 = p.f563716h;     // Catch: Throwable -> L24
        if ((r105 - r106.f563727g) < 5000) goto L33;
        r106.f563727g = r105;     // Catch: Throwable -> L24
        r106.a(r105, true, null, r100, r110);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        xg4.a.c(th);
        return;
    L39:
        return;
    L5:
        if (r101.f563725e == false) goto L7;
        r102 = true;
        goto L8
    }

    public static void X(boolean r100, boolean r101, int r102) {
        if (isSoLoaded == false) goto L6;
        nEnablePrioriryParams(r100, r101, r102);
        return;
    }

    public static void c0(long r100, char[] r101, int r102) {
        if (isSoLoaded == false) goto L6;
        nStringDumperDumpCharArray(r100, r101, r102);
        return;
    }

    public static void d0(long r100, String r101, int r102) {
        if (isSoLoaded == false) goto L6;
        nStringDumperDumpString(r100, r101, r102);
        return;
    }
}
