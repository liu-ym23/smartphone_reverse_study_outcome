package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.monitor.a;
import com.bytedance.crash.monitor.j;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.nativeCrash.MTKBufferOpt;
import com.bytedance.crash.npth_repair.nativeCrash.ScudoVmaLeakFixer;
import com.bytedance.crash.protector.CrashProtectorConfig;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.upload.e;
import com.bytedance.crash.upload.f;
import com.bytedance.crash.upload.g;
import com.bytedance.crash.util.ListMap;
import com.bytedance.crash.util.t;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fh4.d;
import fh4.h;
import fh4.k;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import wh4.c;
import xg4.n;
import xg4.p;
import yh4.b;
import zg4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class Npth {
    private static final m0 sCachedDataCenter = null;

    public Npth() {
    }

    public static long getFileSize(String r2) {
        return 0;
    }

    public static long getFolderSize(String r2) {
        return 0;
    }

    public static boolean hasCrash() {
        return false;
    }

    public static boolean hasCrashWhenNativeCrash() {
        return false;
    }

    public static void openANRMonitor() {
    }

    public static void openJavaCrashMonitor() {
    }

    public static boolean openNativeCrashMonitor() {
        return false;
    }

    public static void optProcessTrackDisk() {
    }

    public static void pause() {
        d.e = true;
        h.b = true;
    }

    public static void registerCrashCallbackOnDrop(a r0, CrashType r1) {
    }

    public static void reportError(String r0) {
    }

    public static void resume() {
        d.e = false;
        h.b = false;
    }

    public static void setANRCheckEnable(boolean r0) {
    }

    public static void setAlogFlushAddr(long r0) {
    }

    public static void setAlogLogDirAddr(long r0) {
    }

    public static void setAlogWriteAddr(long r0) {
    }

    public static void setCloseBgAnr(boolean r0) {
    }

    public static void setCrashMonitorService(o r0) {
    }

    public static void setInitAnrAhead(boolean r0) {
    }

    public static void setLogcatImpl(c r0) {
    }

    public static void setNetworkCallback(yh4.c r0) {
    }

    public static void setNpthInitOptEnable(boolean r0) {
    }

    public static void setOpenDumpTraceOpt(boolean r0) {
    }

    public static void setRequestHeaderProvider(yh4.d r0) {
    }

    public static void setRequestIntercept(e r0) {
    }

    public static void setRequestPermission(f r0) {
    }

    public static void setScriptStackCallback(w r0) {
    }

    public static void setTerminateMonitorDelayTime(long r0) {
    }

    public static void setTerminateOpt(boolean r0) {
    }

    public static void setUrlConnectionInterceptor(b r0) {
    }

    public static void stopEnsure() {
    }

    public static void stopUpload() {
    }

    static {
        sCachedDataCenter = a.p;
    }

    public static void clean() {
        Iterator r0 = fh4.f.i.iterator();     // Catch: Throwable -> L8
    L4:
        if (r0.hasNext() == false) goto L13;
        fh4.f r1 = (fh4.f) r0.next();     // Catch: Throwable -> L8
        r1.c.clear();     // Catch: Throwable -> L8
        r1.b.clear();     // Catch: Throwable -> L8
    L13:
        return;
    }

    public static int fixScudoVmaLeak() {
        boolean r0 = nh4.a.g;
        Context r1 = i.getContext();
        if (r1 == null) goto L5;
        int r2 = NpthRepair.a(r1, false);
    L6:
        if (r2 != 0) goto L11;
        r2 = ScudoVmaLeakFixer.a();
        a r3 = j.a;     // Catch: Throwable -> L12
        if (r3 == null) goto L11;
        String r4 = String.valueOf(r2);     // Catch: Throwable -> L12
        r3.c.b("fix_scudo", r4);     // Catch: Throwable -> L12
    L11:
        return r2;
    L5:
        r2 = -7;
        goto L6
    }

    public static boolean isInit() {
        if (j.a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isStopUpload() {
        boolean r0 = i.c;
        return false;
    }

    public static boolean isANREnable() {
        return d0.d();
    }

    public static boolean isJavaCrashEnable() {
        return d0.d();
    }

    public static boolean isNativeCrashEnable() {
        return d0.d();
    }

    public static boolean isRunning() {
        if (d0.d() == false) goto L13;
        p r0 = p.h;
        if (r0 != null) goto L8;
        return false;
    L8:
        if (r0.e == false) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    public static void stopAnr() {
        if (d0.d() == false) goto L22;
        p r0 = p.h;
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.e == false) goto L20;
        r0.e = false;
        r0.b.getClass();
        xg4.i r2 = r0.c;
        if (r2.a == false) goto L12;
        r2.a = false;
        r2.b.stopWatching();
    L12:
        long r3 = r0.d.a;
        if (r3 == 0) goto L15;
        NativeBridge.nAnrNativeProfilerExit(r3);
    L15:
        ih4.c r1 = ih4.c.c;
        r1.b = false;
        r1.a.b = null;
        com.bytedance.apm.block.j.a r4 = com.bytedance.apm.block.j.h;
        if (r4 == null) goto L21;
        r4.removeMessageObserver(r1);
        return;
    L21:
        return;
    L20:
        return;
    }

    public static ConfigManager getConfigManager() {
        return a0.a;
    }

    public static void addImportTags(Map<? extends String, ? extends String> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == false) goto L6;
        return;
    L6:
        if (d0.d() == true) goto L8;
        ((ConcurrentHashMap) i0.a).putAll(r2);
        return;
    L8:
        Map<String, String> r0 = i0.a;
        ((ConcurrentHashMap) r0).putAll(r2);
        wh4.b.post(new j0(new HashMap(r0)));
    }

    public static boolean addNativeProtectorConfig(JSONObject r5) {
        monitor-enter(com.bytedance.crash.protector.b.class);
        CrashProtectorConfig r1 = new CrashProtectorConfig();     // Catch: Throwable -> L25
        boolean r3 = false;
        if (CrashProtectorConfig.a(r5) == true) goto L9;
        monitor-exit(com.bytedance.crash.protector.b.class);
    L24:
        return r3;
    L9:
        r1.d();     // Catch: Throwable -> L25
        String r6 = r5.optString("scope");     // Catch: Throwable -> L25
        if (CrashProtectorConfig.c(r6) == false) goto L18;
        Iterator r2 = r1.a.iterator();     // Catch: Throwable -> L25
    L14:
        if (r2.hasNext() == false) goto L18;
        if (((String) r2.next()).equals(r6) == false) goto L14;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L22;
        monitor-exit(com.bytedance.crash.protector.b.class);
        goto L24
    L22:
        r3 = com.bytedance.crash.protector.b.b(r1.d, r1.e);     // Catch: Throwable -> L25
        monitor-exit(com.bytedance.crash.protector.b.class);
    L18:
        r7 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public static void addTags(Map<? extends String, ? extends String> r2) {
        m0 r0 = sCachedDataCenter;
        Map<String, String> r1 = i0.a;
        if (r2 == null) goto L11;
        if (r2.isEmpty() == true) goto L12;
        r0.c(r2);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void addWhiteLogType(String r1) {
        fh4.f.j.add(r1);
    }

    public static void customActivityName(lh4.a r0) {
        bi4.a.d().getClass();
    }

    public static void dumpHprof(String r0) {
        NativeBridge.k(r0);
    }

    public static void enableGwpAsan(boolean r13) {
        if (r13 == false) goto L38;
    L32:
        e = move-exception;
        com.bytedance.crash.util.p.c("GwpAsanStart err:" + e);
        return;
    L4:
        if (NativeBridge.G() == true) goto L6;
        com.bytedance.crash.util.p.a("xasan 32bit app Not supported");     // Catch: IOException -> L32
        return;
    L6:
        qh4.a r14 = qh4.a.e();     // Catch: IOException -> L32
        if (((oh4.b) r14).g == false) goto L9;
        com.bytedance.crash.util.p.a("xasan has init");     // Catch: IOException -> L32
        return;
    L9:
        int r0 = Build.VERSION.SDK_INT;     // Catch: IOException -> L32
        if (r0 > 34) goto L41;
        StringBuilder r1 = new StringBuilder();     // Catch: IOException -> L32
        uh4.b r2 = uh4.b.h;     // Catch: IOException -> L32
        r1.append(r2.a.getAbsolutePath());     // Catch: IOException -> L32
        r1.append("/");     // Catch: IOException -> L32
        r1.append(com.bytedance.crash.crash.c.a());     // Catch: IOException -> L32
        String r3 = r1.toString();     // Catch: IOException -> L32
        if (r2.a.exists() == true) goto L14;
        r2.a.mkdirs();     // Catch: IOException -> L32
    L14:
        String r4 = i.c();     // Catch: IOException -> L32
        PolarisFileWrapper r5 = new PolarisFileWrapper(r4, "xasan.config");     // Catch: IOException -> L32
        if (r5.exists() == true) goto L17;
        r5.createNewFile();     // Catch: IOException -> L32
    L17:
        JSONArray r6 = com.bytedance.crash.monitor.b.g;     // Catch: IOException -> L32
        String[] r7 = {"enableXasan", "debug", "maxSimultaneousAlloc", "sampleRate", "monitorAllocSize", "monitorType", "monitorBugType", "soName"};     // Catch: IOException -> L32
        if (r6 != null) goto L20;
    L29:
        String r8 = null;
    L30:
        com.bytedance.crash.util.h.h(r5, r8, false);     // Catch: IOException -> L32
        NativeResourceMonitor.b(r0, r3, r4);     // Catch: IOException -> L32
        ((oh4.b) r14).g = true;     // Catch: IOException -> L32
        return;
    L20:
        if (r6.length() >= 10) goto L29;
        StringBuilder r9 = new StringBuilder();     // Catch: IOException -> L32
        int r10 = 0;
    L24:
        if (r10 >= r6.length()) goto L28;
        if (r10 >= r7.length) goto L28;
        r9.append(r7[r10]);     // Catch: IOException -> L32
        r9.append("=");     // Catch: IOException -> L32
        r9.append(r6.optString(r10));     // Catch: IOException -> L32
        r9.append("\n");     // Catch: IOException -> L32
        r10 = r10 + 1;     // Catch: IOException -> L32
    L28:
        r8 = r9.toString();     // Catch: IOException -> L32
        goto L30
    L41:
        return;
    }

    public static void ignoreExceptionTag(boolean r0) {
        m0.s = r0;
    }

    public static int optMtkBuffer(int r3) {
        boolean r0 = nh4.a.g;
        monitor-enter(nh4.a.class);
        Context r1 = i.getContext();     // Catch: Throwable -> L14
        if (r1 == null) goto L7;
        int r2 = NpthRepair.a(r1, false);     // Catch: Throwable -> L14
    L8:
        if (r2 != 0) goto L12;
        r2 = MTKBufferOpt.a(r3);     // Catch: Throwable -> L14
        monitor-exit(nh4.a.class);
    L13:
        return r2;
    L12:
        monitor-exit(nh4.a.class);
        goto L13
    L7:
        r2 = -7;
    L14:
        th = move-exception;
        throw th;
    }

    public static void registerANRCallback(l r1) {
        ((CopyOnWriteArrayList) sCachedDataCenter.i).add(r1);
    }

    public static void registerAnrUploadCallback(m r1) {
        ((CopyOnWriteArrayList) sCachedDataCenter.m).add(r1);
    }

    public static void registerExceptionTriggerCallback(q r3) {
        monitor-enter(com.bytedance.crash.monitor.b.class);
        if (r3 != null) goto L14;
    L12:
        monitor-exit(com.bytedance.crash.monitor.b.class);
        return;
    L14:
    L9:
        th = move-exception;
        throw th;
    L6:
        if (com.bytedance.crash.monitor.b.i.equals("none") == true) goto L12;
        r3.b();     // Catch: Throwable -> L9
        goto L12
    }

    public static void registerHprofCallback(IOOMCallback r1) {
        ((CopyOnWriteArrayList) sCachedDataCenter.h).add(r1);
    }

    public static void registerOOMCallback(IOOMCallback r1) {
        ((CopyOnWriteArrayList) sCachedDataCenter.g).add(r1);
    }

    public static void registerPreANRCallback(u r1) {
        ((CopyOnWriteArrayList) sCachedDataCenter.l).add(r1);
    }

    public static void removeCustomCrashReasonArray(String r1) {
        ((ConcurrentHashMap) sCachedDataCenter.n).remove(r1);
    }

    public static void removeImportTag(String r0) {
        i0.c(r0);
    }

    public static void removeTag(String r2) {
        m0 r0 = sCachedDataCenter;
        Map<String, String> r1 = i0.a;
        if (NativeBridge.H() == true) goto L5;
    L10:
        r0.a.remove(r2);
        return;
    L5:
        if (r0.q == false) goto L10;
        if (r0.r == false) goto L9;
        NativeBridge.P(r2);
        return;
    L9:
        r0.a.remove(r2);
    }

    public static void reportDartError(String r1) {
        if (d0.d() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        bh4.a.a(r1, null, null, null);
        return;
    }

    public static void reportError(Throwable r0) {
        a0.a.isReportErrorEnable();
    }

    public static void setANRImprovementOpt(boolean r0) {
        k.d = r0;
    }

    public static void setAlogFlushV2Addr(long r1) {
        wg4.a.b r0 = wg4.a.a;
        NativeBridge.R(r1);
    }

    public static void setAnrDisableDumpData(boolean r0) {
        p.j = !r0;
    }

    public static void setAnrMonitorOpt(boolean r0) {
        k.a = r0;
    }

    public static void setAnrResendSigquit(boolean r0) {
        NativeBridge.T(r0);
    }

    public static void setApplication(Application r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (i.a().c != null) goto L8;
        i.a().c = r1;
        return;
    }

    public static void setBusiness(String r0) {
        i.h = r0;
    }

    public static void setCrashAccessibilityEnable(boolean r0) {
        ai4.e.b = r0;
    }

    public static void setCrashFilter(ICrashFilter r1) {
        sCachedDataCenter.p = r1;
    }

    public static void setCrashUploadCallback(c r0) {
        sCachedDataCenter.getClass();
    }

    public static void setCurProcessName(String r0) {
        com.bytedance.crash.util.b.a = r0;
    }

    public static void setDomainName(String r1) {
        wh4.a.a(new URL(r1).getHost());     // Catch: Throwable -> L4
        return;
    }

    public static void setDumpAnrAsync(boolean r0) {
        d0.d = r0;
    }

    public static void setEncryptImpl(p r0) {
        if (r0 == null) goto L4;
        i.d = r0;
        return;
    L4:
        boolean r1 = i.c;
    }

    public static void setFixDumpStack(boolean r0) {
        nh4.a.g = r0;
        nh4.a.h = false;
    }

    public static void setIgnoreHandler(hh4.a r1) {
        com.bytedance.crash.crash.d.f.add(r1);
    }

    public static void setMaxCacheSize(int r0) {
        if (r0 <= 0) goto L4;
        fh4.f.e = r0;
        return;
    L4:
        int r1 = fh4.f.e;
    }

    public static void setOpenNewAnrMonitor(boolean r0) {
        k.b = r0;
    }

    public static void setQueueLimitSize(int r0) {
        if (r0 > 0) goto L4;
        fh4.f.g = true;
        return;
    L4:
        fh4.f.f = r0;
    }

    public static void setTagCacheService(x r2) {
        Map<String, String> r3 = i0.a;
        m0 r0 = sCachedDataCenter;
        if (NativeBridge.H() == true) goto L5;
    L7:
        Map r1 = r0.a;
    L8:
        HashMap r4 = new HashMap(r1);
        if (r4.isEmpty() == true) goto L12;
        r0.c(r4);     // Catch: Throwable -> L14
    L12:
        r0.a.clear();
        return;
    L5:
        if (r0.q == false) goto L7;
        r1 = NativeBridge.z();
        goto L8
    }

    public static void setTagOpt(boolean r2) {
        m0 r0 = sCachedDataCenter;
        if (r0.q == true) goto L10;
        if (r2 == false) goto L10;
        r0.q = true;
        if (r0.a.isEmpty() == true) goto L10;
        if (NativeBridge.H() == false) goto L10;
        r0.r = false;
        wh4.b.post(new l0(r0));
    L10:
        r0.q = r2;
    }

    public static void setUploadDelayTime(long r0) {
        g.a = r0;
    }

    public static void setUseLocalDomain(boolean r0) {
        com.bytedance.crash.monitor.b.h = r0;
    }

    public static int startOptMtkBuffer(int r3) {
        boolean r0 = nh4.a.g;
        monitor-enter(nh4.a.class);
        Context r1 = i.getContext();     // Catch: Throwable -> L14
        if (r1 == null) goto L7;
        int r2 = NpthRepair.a(r1, false);     // Catch: Throwable -> L14
    L8:
        if (r2 != 0) goto L12;
        r2 = MTKBufferOpt.a(r3);     // Catch: Throwable -> L14
        monitor-exit(nh4.a.class);
    L13:
        return r2;
    L12:
        monitor-exit(nh4.a.class);
        goto L13
    L7:
        r2 = -7;
    L14:
        th = move-exception;
        throw th;
    }

    public static void unregisterPreANRCallback(u r1) {
        ((CopyOnWriteArrayList) sCachedDataCenter.l).remove(r1);
    }

    public static void addAttachLongUserData(AttachUserData r1, CrashType r2) {
        sCachedDataCenter.a(r1, r2);
    }

    public static void addAttachUserData(AttachUserData r1, CrashType r2) {
        sCachedDataCenter.a(r1, r2);
    }

    public static void addCustomCrashReasonArray(String r4, String r5) {
        m0 r0 = sCachedDataCenter;
        if (r5 != null) goto L6;
        r0.getClass();
        return;
    L6:
        if (((ConcurrentHashMap) r0.n).containsKey(r4) == true) goto L17;
        Map<String, LinkedList<String>> r1 = r0.n;
        monitor-enter(r1);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (((ConcurrentHashMap) r0.n).containsKey(r4) == true) goto L12;
        Map<String, LinkedList<String>> r2 = r0.n;     // Catch: Throwable -> L14
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;     // Catch: Throwable -> L14
        r3.put(r4, new LinkedList());     // Catch: Throwable -> L14
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L14
    L17:
        LinkedList r6 = (LinkedList) ((ConcurrentHashMap) r0.n).get(r4);
        if (r6 == null) goto L42;
        monitor-enter(r6);
    L34:
        th = move-exception;
        throw th;
    L22:
        if (r6.contains(r5) == false) goto L26;
        monitor-exit(r6);     // Catch: Throwable -> L34
        return;
    L26:
        if (((ConcurrentHashMap) r0.o).containsKey(r4) == false) goto L31;
        int r7 = ((Integer) ((ConcurrentHashMap) r0.o).get(r4)).intValue();     // Catch: Throwable -> L34
        if (r6.size() <= r7) goto L30;
        r6.removeFirst();     // Catch: Throwable -> L34
    L30:
        r6.add(r5);     // Catch: Throwable -> L34
    L32:
        monitor-exit(r6);     // Catch: Throwable -> L34
        return;
    L31:
        r6.add(r5);     // Catch: Throwable -> L34
        goto L32
    }

    public static void addImportTag(String r2, String r3) {
        if (r2 != null) goto L4;
        Map<String, String> r4 = i0.a;
        return;
    L4:
        if (r3 != null) goto L6;
        i0.c(r2);
        return;
    L6:
        Map<String, String> r0 = i0.a;
        ((ConcurrentHashMap) r0).put(r2, r3);
        if (d0.d() == false) goto L13;
        wh4.b.post(new h0(new HashMap(r0)));
        return;
    }

    public static void addTag(String r2, String r3) {
        m0 r0 = sCachedDataCenter;
        Map<String, String> r1 = i0.a;
        r0.b(r2, r3);
    }

    public static void addUserCrashInfoCallback(y r4, CrashType r5) {
        if (r4 == null) goto L14;
        m0 r0 = sCachedDataCenter;
        ListMap<CrashType, y> r1 = r0.k;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r5 != CrashType.ALL) goto L8;
        r0.k.addMulti(r4, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L8:
        r0.k.add(r5, r4);     // Catch: Throwable -> L11
        goto L9
    }

    public static synchronized void init(Context r4, ICommonParams r5) {
        monitor-enter(Npth.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit() == false) goto L9;
        monitor-exit(Npth.class);
        return;
    L9:
        if (ch4.b.d != null) goto L11;
        ch4.b.d = new ch4.b();     // Catch: Throwable -> L18
    L11:
        a r6 = j.b(r4, r5);     // Catch: Throwable -> L18
        r6.l = new com.bytedance.crash.dumper.j(r5);     // Catch: Throwable -> L18
        new b();     // Catch: Throwable -> L18
        wh4.b.post(new a(r6));     // Catch: Throwable -> L18
        if (ch4.b.d != null) goto L22;
    L16:
        monitor-exit(Npth.class);
        return;
    L22:
        long r7 = SystemClock.uptimeMillis();     // Catch: Throwable -> L21
        ch4.b r1 = ch4.b.d;     // Catch: Throwable -> L21
        long r8 = r7 - r1.b;     // Catch: Throwable -> L21
        r1.a.put("total", r8);     // Catch: Throwable -> L21
    L15:
        wh4.b.post(new ch4.a());     // Catch: Throwable -> L18
        goto L16
    }

    public static synchronized void initMiniApp(Context r8, ICommonParams r9) {
        monitor-enter(Npth.class);
        d0.a = true;     // Catch: Throwable -> L8
        init(r8, r9, true, false, true, true);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void registerCrashCallback(ICrashCallback r4, CrashType r5) {
        m0 r0 = sCachedDataCenter;
        ListMap<CrashType, ICrashCallback> r1 = r0.e;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        r0.e.addMulti(r4, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L7:
        r0.e.add(r5, r4);     // Catch: Throwable -> L10
        goto L8
    }

    public static void registerCrashInfoCallback(b r4, CrashType r5) {
        m0 r0 = sCachedDataCenter;
        ListMap<CrashType, b> r1 = r0.f;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        r0.f.addMulti(r4, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L7:
        r0.f.add(r5, r4);     // Catch: Throwable -> L10
        goto L8
    }

    public static void registerPreCrashCallback(v r4, CrashType r5) {
        m0 r0 = sCachedDataCenter;
        ListMap<CrashType, v> r1 = r0.j;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r5 != CrashType.ALL) goto L7;
        r0.j.addMulti(r4, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L7:
        r0.j.add(r5, r4);     // Catch: Throwable -> L10
        goto L8
    }

    public static void registerSdk(int r1, String r2) {
        sCachedDataCenter.b.put(Integer.valueOf(r1), r2);
    }

    public static void removeAttachLongUserData(AttachUserData r3, CrashType r4) {
        m0 r0 = sCachedDataCenter;
        if (r3 == null) goto L15;
        ListMap<CrashType, AttachUserData> r1 = r0.d;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r4 != CrashType.ALL) goto L9;
        r0.d.removeAll(r3);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L9:
        r0.d.removeInList(r4, r3);     // Catch: Throwable -> L12
        goto L10
    L15:
        r0.getClass();
    }

    public static void removeAttachUserData(AttachUserData r3, CrashType r4) {
        m0 r0 = sCachedDataCenter;
        if (r3 == null) goto L15;
        ListMap<CrashType, AttachUserData> r1 = r0.d;
        monitor-enter(r1);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r4 != CrashType.ALL) goto L9;
        r0.d.removeAll(r3);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L9:
        r0.d.removeInList(r4, r3);     // Catch: Throwable -> L12
        goto L10
    L15:
        r0.getClass();
    }

    public static void removeCrashInfoCallback(y r3, CrashType r4) {
        if (r3 == null) goto L14;
        m0 r0 = sCachedDataCenter;
        ListMap<CrashType, y> r1 = r0.k;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r4 != CrashType.ALL) goto L8;
        r0.k.removeAll(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L8:
        r0.k.removeInList(r4, r3);     // Catch: Throwable -> L11
        goto L9
    }

    public static void reportBizException(String r1, k r2) {
        reportBizException(r1, r2, false);
    }

    public static void setAnrInfoFileObserver(String r0, t r1) {
        wh4.b.post(new n(r0));
    }

    public static void setAttachUserData(AttachUserData r0, CrashType r1) {
        addAttachUserData(r0, r1);
    }

    public static void setCustomCrashReasonArrayLimit(String r1, int r2) {
        Map<String, Integer> r0 = sCachedDataCenter.o;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r0;
        r3.put(r1, Integer.valueOf(r2));
    }

    public static void unregisterCrashCallback(ICrashCallback r3, CrashType r4) {
        m0 r0 = sCachedDataCenter;
        ListMap<CrashType, ICrashCallback> r1 = r0.e;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r4 != CrashType.ALL) goto L7;
        r0.e.removeAll(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L7:
        r0.e.removeInList(r4, r3);     // Catch: Throwable -> L10
        goto L8
    }

    public static void unregisterHprofCallback(IOOMCallback r0, CrashType r1) {
        ((CopyOnWriteArrayList) sCachedDataCenter.h).remove(r0);
    }

    public static void unregisterOOMCallback(IOOMCallback r0, CrashType r1) {
        ((CopyOnWriteArrayList) sCachedDataCenter.g).remove(r0);
    }

    public static void unregisterPreCrashCallback(v r3, CrashType r4) {
        m0 r0 = sCachedDataCenter;
        ListMap<CrashType, v> r1 = r0.j;
        monitor-enter(r1);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r4 != CrashType.ALL) goto L7;
        r0.j.removeAll(r3);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L7:
        r0.j.removeInList(r4, r3);     // Catch: Throwable -> L10
        goto L8
    }

    public static void registerSdk(String r1, String r2) {
        sCachedDataCenter.c.put(r1, r2);
    }

    public static void enableALogCollector(String r1, wg4.c r2, wg4.d r3) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return;
    L5:
        if (new PolarisFileWrapper(r1).exists() == false) goto L13;
        wg4.a.b r0 = wg4.a.a;
        if (TextUtils.isEmpty(r1) == false) goto L9;
        return;
    L9:
        if (wg4.a.a != null) goto L15;
        wg4.a.a = new wg4.a.b(r1, r2, r3);
        return;
    L15:
        return;
    }

    public static void reportBizException(String r3, k r4, boolean r5) {
        if (r3 == null) goto L25;
        if (r4 == null) goto L26;
        fh4.b r6 = fh4.c.e.a;
        boolean r0 = true;
        if (r6 != null) goto L8;
        boolean r2 = false;
    L9:
        if (r2 == false) goto L23;
        if (r6 != null) goto L12;
    L20:
        r0 = false;
    L21:
        if (r0 == true) goto L23;
        return;
    L12:
        if (r6.a == false) goto L20;
        Set r7 = r6.b;
        if (r7 != null) goto L17;
        boolean r8 = false;
    L18:
        if (r8 == false) goto L20;
    L17:
        r8 = r7.contains(r3);
    L23:
        r4.getException();
        return;
    L8:
        r2 = true;
        goto L9
    L26:
        return;
    }

    public static void reportGameException(String r8, String r9, String r10) {
        if (d0.d() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L13;
        if (TextUtils.isEmpty(r9) == false) goto L13;
        if (TextUtils.isEmpty(r8) == false) goto L13;
        return;
    L13:
        if (gh4.a.a == true) goto L19;
        long r3 = System.currentTimeMillis();
        wh4.b.post(new gh4.a.a(ThreadMethodProxy.currentThread().getName(), r3, r8, r9, r10));
        return;
    }

    public static void scanNativeCrash(Context r4, a r5, String[] r6) {
        File[] r7 = new PolarisFileWrapper(i.e(r4), "crash").listFiles();
        if (r7 != null) goto L28;
        ArrayList r8 = null;
    L16:
        if (r8 != null) goto L18;
        return;
    L18:
        Iterator r9 = r8.iterator();
    L20:
        if (r9.hasNext() == false) goto L26;
        CrashSummary r10 = (CrashSummary) r9.next();
        if (r10 == null) goto L20;
        r10.getCrashType();
        r10.getStartTime();
        r10.getCrashTime();
        r10.getProcessName();
        r10.getStackTrace();
        throw null;
    L26:
        return;
    L28:
        t.a();     // Catch: Throwable -> L8
    L8:
        ConfigManager r1 = a0.a;     // Catch: Throwable -> L27
        com.bytedance.librarian.a.e("npth", true, i.getContext());     // Catch: Throwable -> L27
    L9:
        r8 = new ArrayList();
        int r2 = r7.length;
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L16;
        CrashSummary r11 = CrashSummary.loadFromDirectory(r7[r3], true);
        if (r11 == null) goto L15;
        r8.add(r11);
    L15:
        r3 = r3 + 1;
        goto L10
    }

    public static synchronized void initMiniApp(Context r8, ICommonParams r9, int r10, String r11) {
        monitor-enter(Npth.class);
        d0.a = true;     // Catch: Throwable -> L8
        d0.b = r10;     // Catch: Throwable -> L8
        d0.c = r11;     // Catch: Throwable -> L8
        init(r8, r9, true, true, true, true);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void reportBizException(String r1, Throwable r2, String r3, Map<String, String> r4) {
        if (r1 == null) goto L7;
        if (r2 == null) goto L8;
        reportBizException(r1, r2, r3, r4, false);
        return;
    L8:
        return;
    }

    public static void reportDartError(String r1, Map<? extends String, ? extends String> r2, Map<String, String> r3, IUploadCallback r4) {
        if (d0.d() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        bh4.a.a(r1, r2, r3, r4);
        return;
    }

    public static synchronized void init(Context r7, ICommonParams r8, boolean r9, boolean r10, boolean r11) {
        monitor-enter(Npth.class);
        init(r7, r8, r9, r9, r10, r11);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized com.bytedance.crash.monitor.f initSDK(Context r8, String r9, int r10, long r11, String r13) {
        monitor-enter(Npth.class);
        com.bytedance.crash.monitor.f r12 = j.a(r8, r9, r10, r11, r13);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    public static void reportBizException(String r7, Throwable r8, String r9, Map<String, String> r10, boolean r11) {
        if (r7 == null) goto L7;
        if (r8 == null) goto L8;
        fh4.c.e.b(r7, r8, r9, r10, null, r11);
        return;
    L8:
        return;
    }

    public static void reportBizException(String r6, Throwable r7, String r8, Map<String, String> r9, Map<String, String> r10) {
        if (r6 == null) goto L7;
        if (r7 == null) goto L8;
        reportBizException(r6, r7, r8, r9, r10, false);
        return;
    L8:
        return;
    }

    public static synchronized void init(Context r9, ICommonParams r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        monitor-enter(Npth.class);
        init(r9, r10, r11, r12, r13, r14, 0);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void reportBizException(String r7, Throwable r8, String r9, Map<String, String> r10, Map<String, String> r11, boolean r12) {
        if (r7 == null) goto L7;
        if (r8 == null) goto L8;
        fh4.c.e.b(r7, r8, r9, r10, r11, r12);
        return;
    L8:
        return;
    }

    public static synchronized void init(Context r11, ICommonParams r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17) {
        monitor-enter(Npth.class);
        init(null, r11, r12, r13, r14, r15, r16, r17);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Application r0, Context r1, ICommonParams r2, boolean r3, boolean r4, boolean r5, boolean r6, long r7) {
        monitor-enter(Npth.class);
        init(r1, r2);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
