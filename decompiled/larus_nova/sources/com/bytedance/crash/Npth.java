package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.npth_repair.NpthRepair;
import com.bytedance.crash.npth_repair.nativeCrash.MTKBufferOpt;
import com.bytedance.crash.npth_repair.nativeCrash.ScudoVmaLeakFixer;
import com.bytedance.crash.protector.CrashProtectorConfig;
import com.bytedance.crash.resource.NativeResourceMonitor;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.util.ListMap;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.huawei.hms.framework.common.ContainerUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
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

/* JADX INFO: loaded from: classes.dex */
public final class Npth {
    private static final m0 sCachedDataCenter = null;

    /* JADX INFO: loaded from: classes3.dex */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.crash.monitor.a f203095a;

        @Override // java.lang.Runnable
        public final void run() {
            new zg4.d(this.f203095a).c();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(com.bytedance.crash.monitor.a r100) {
            this.f203095a = r100;
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public static class b extends z {
        public b() {
        }
    }

    public Npth() {
    }

    public static long getFileSize(String r100) {
        return 0;
    }

    public static long getFolderSize(String r100) {
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
        fh4.d.f477005e = true;
        fh4.h.f477039b = true;
    }

    public static void registerCrashCallbackOnDrop(com.bytedance.crash.a r100, CrashType r101) {
    }

    public static void reportError(String r100) {
    }

    public static void resume() {
        fh4.d.f477005e = false;
        fh4.h.f477039b = false;
    }

    public static void setANRCheckEnable(boolean r100) {
    }

    public static void setAlogFlushAddr(long r100) {
    }

    public static void setAlogLogDirAddr(long r100) {
    }

    public static void setAlogWriteAddr(long r100) {
    }

    public static void setCloseBgAnr(boolean r100) {
    }

    public static void setCrashMonitorService(o r100) {
    }

    public static void setInitAnrAhead(boolean r100) {
    }

    public static void setLogcatImpl(wh4.c r100) {
    }

    public static void setNetworkCallback(yh4.c r100) {
    }

    public static void setNpthInitOptEnable(boolean r100) {
    }

    public static void setOpenDumpTraceOpt(boolean r100) {
    }

    public static void setRequestHeaderProvider(yh4.d r100) {
    }

    public static void setRequestIntercept(com.bytedance.crash.upload.e r100) {
    }

    public static void setRequestPermission(com.bytedance.crash.upload.f r100) {
    }

    public static void setScriptStackCallback(w r100) {
    }

    public static void setTerminateMonitorDelayTime(long r100) {
    }

    public static void setTerminateOpt(boolean r100) {
    }

    public static void setUrlConnectionInterceptor(yh4.b r100) {
    }

    public static void stopEnsure() {
    }

    public static void stopUpload() {
    }

    static {
        sCachedDataCenter = com.bytedance.crash.monitor.a.f203264p;
    }

    public static void clean() {
        Iterator<fh4.f> r100 = fh4.f.f477015i.iterator();     // Catch: Throwable -> L8
    L4:
        if (r100.hasNext() == false) goto L13;
        fh4.f r101 = r100.next();     // Catch: Throwable -> L8
        r101.f477019c.clear();     // Catch: Throwable -> L8
        r101.f477018b.clear();     // Catch: Throwable -> L8
    L13:
        return;
    }

    public static int fixScudoVmaLeak() {
        boolean r100 = nh4.a.f519163g;
        Context r101 = i.getContext();
        if (r101 == null) goto L5;
        int r102 = NpthRepair.a(r101, false);
    L6:
        if (r102 != 0) goto L11;
        r102 = ScudoVmaLeakFixer.a();
        com.bytedance.crash.monitor.a r103 = com.bytedance.crash.monitor.j.f203315a;     // Catch: Throwable -> L12
        if (r103 == null) goto L11;
        String r104 = String.valueOf(r102);     // Catch: Throwable -> L12
        r103.f203291c.b("fix_scudo", r104);     // Catch: Throwable -> L12
    L11:
        return r102;
    L5:
        r102 = -7;
        goto L6
    }

    public static boolean isInit() {
        if (com.bytedance.crash.monitor.j.f203315a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isStopUpload() {
        boolean r100 = zg4.i.f572087c;
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
        xg4.p r100 = xg4.p.f563716h;
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r100.f563725e == false) goto L12;
        return true;
    L12:
        return false;
    L13:
        return false;
    }

    public static void stopAnr() {
        if (d0.d() == false) goto L22;
        xg4.p r100 = xg4.p.f563716h;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.f563725e == false) goto L20;
        r100.f563725e = false;
        r100.f563722b.getClass();
        xg4.i r101 = r100.f563723c;
        if (r101.f563655a == false) goto L12;
        r101.f563655a = false;
        r101.f563656b.stopWatching();
    L12:
        long r102 = r100.f563724d.f563729a;
        if (r102 == 0) goto L15;
        NativeBridge.nAnrNativeProfilerExit(r102);
    L15:
        ih4.c r103 = ih4.c.f489850c;
        r103.f489852b = false;
        r103.f489851a.f489811b = null;
        com.bytedance.apm.block.j.a r104 = com.bytedance.apm.block.j.f190356h;
        if (r104 == null) goto L21;
        r104.removeMessageObserver(r103);
        return;
    L21:
        return;
    L20:
        return;
    }

    public static ConfigManager getConfigManager() {
        return a0.f203096a;
    }

    public static void addImportTags(Map<? extends String, ? extends String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == false) goto L6;
        return;
    L6:
        if (d0.d() == true) goto L8;
        ((ConcurrentHashMap) i0.f203227a).putAll(r100);
        return;
    L8:
        Map<String, String> r101 = i0.f203227a;
        ((ConcurrentHashMap) r101).putAll(r100);
        wh4.b.post(new j0(new HashMap(r101)));
    }

    public static boolean addNativeProtectorConfig(JSONObject r100) {
        monitor-enter(com.bytedance.crash.protector.b.class);
        CrashProtectorConfig r101 = new CrashProtectorConfig();     // Catch: Throwable -> L25
        boolean r102 = false;
        if (CrashProtectorConfig.a(r100) == true) goto L9;
        monitor-exit(com.bytedance.crash.protector.b.class);
    L24:
        return r102;
    L9:
        r101.d();     // Catch: Throwable -> L25
        String r103 = r100.optString("scope");     // Catch: Throwable -> L25
        if (CrashProtectorConfig.c(r103) == false) goto L18;
        Iterator<String> r104 = r101.f203337a.iterator();     // Catch: Throwable -> L25
    L14:
        if (r104.hasNext() == false) goto L18;
        if (r104.next().equals(r103) == false) goto L14;
        boolean r105 = true;
    L19:
        if (r105 == true) goto L22;
        monitor-exit(com.bytedance.crash.protector.b.class);
        goto L24
    L22:
        r102 = com.bytedance.crash.protector.b.b(r101.f203340d, r101.f203341e);     // Catch: Throwable -> L25
        monitor-exit(com.bytedance.crash.protector.b.class);
    L18:
        r105 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public static void addTags(Map<? extends String, ? extends String> r100) {
        m0 r101 = sCachedDataCenter;
        Map<String, String> r102 = i0.f203227a;
        if (r100 == null) goto L11;
        if (r100.isEmpty() == true) goto L12;
        r101.c(r100);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static void addWhiteLogType(String r100) {
        fh4.f.f477016j.add(r100);
    }

    public static void customActivityName(lh4.a r100) {
        bi4.a.d().getClass();
    }

    public static void dumpHprof(String r100) {
        NativeBridge.k(r100);
    }

    public static void enableGwpAsan(boolean r110) {
        if (r110 == false) goto L38;
    L32:
        e = move-exception;
        com.bytedance.crash.util.p.c("GwpAsanStart err:" + e);
        return;
    L4:
        if (NativeBridge.G() == true) goto L6;
        com.bytedance.crash.util.p.a("xasan 32bit app Not supported");     // Catch: IOException -> L32
        return;
    L6:
        qh4.a r111 = qh4.a.e();     // Catch: IOException -> L32
        if (r111.f523276g == false) goto L9;
        com.bytedance.crash.util.p.a("xasan has init");     // Catch: IOException -> L32
        return;
    L9:
        int r100 = Build.VERSION.SDK_INT;     // Catch: IOException -> L32
        if (r100 > 34) goto L41;
        StringBuilder r101 = new StringBuilder();     // Catch: IOException -> L32
        uh4.b r102 = uh4.b.f550093h;     // Catch: IOException -> L32
        r101.append(r102.f550094a.getAbsolutePath());     // Catch: IOException -> L32
        r101.append(HTTP.URL_DEFAULT);     // Catch: IOException -> L32
        r101.append(com.bytedance.crash.crash.c.a());     // Catch: IOException -> L32
        String r103 = r101.toString();     // Catch: IOException -> L32
        if (r102.f550094a.exists() == true) goto L14;
        r102.f550094a.mkdirs();     // Catch: IOException -> L32
    L14:
        String r104 = i.c();     // Catch: IOException -> L32
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, "xasan.config");     // Catch: IOException -> L32
        if (r105.exists() == true) goto L17;
        r105.createNewFile();     // Catch: IOException -> L32
    L17:
        JSONArray r106 = com.bytedance.crash.monitor.b.f203266g;     // Catch: IOException -> L32
        String[] r107 = {"enableXasan", "debug", "maxSimultaneousAlloc", "sampleRate", "monitorAllocSize", "monitorType", "monitorBugType", "soName"};     // Catch: IOException -> L32
        if (r106 != null) goto L20;
    L29:
        String r108 = null;
    L30:
        com.bytedance.crash.util.h.h(r105, r108, false);     // Catch: IOException -> L32
        NativeResourceMonitor.b(r100, r103, r104);     // Catch: IOException -> L32
        r111.f523276g = true;     // Catch: IOException -> L32
        return;
    L20:
        if (r106.length() >= 10) goto L29;
        StringBuilder r109 = new StringBuilder();     // Catch: IOException -> L32
        int r112 = 0;
    L24:
        if (r112 >= r106.length()) goto L28;
        if (r112 >= r107.length) goto L28;
        r109.append(r107[r112]);     // Catch: IOException -> L32
        r109.append(ContainerUtils.KEY_VALUE_DELIMITER);     // Catch: IOException -> L32
        r109.append(r106.optString(r112));     // Catch: IOException -> L32
        r109.append("\n");     // Catch: IOException -> L32
        r112 = r112 + 1;     // Catch: IOException -> L32
    L28:
        r108 = r109.toString();     // Catch: IOException -> L32
        goto L30
    L41:
        return;
    }

    public static void ignoreExceptionTag(boolean r100) {
        m0.f203237s = r100;
    }

    public static int optMtkBuffer(int r100) {
        boolean r101 = nh4.a.f519163g;
        monitor-enter(nh4.a.class);
        Context r102 = i.getContext();     // Catch: Throwable -> L14
        if (r102 == null) goto L7;
        int r103 = NpthRepair.a(r102, false);     // Catch: Throwable -> L14
    L8:
        if (r103 != 0) goto L12;
        r103 = MTKBufferOpt.a(r100);     // Catch: Throwable -> L14
        monitor-exit(nh4.a.class);
    L13:
        return r103;
    L12:
        monitor-exit(nh4.a.class);
        goto L13
    L7:
        r103 = -7;
    L14:
        th = move-exception;
        throw th;
    }

    public static void registerANRCallback(l r100) {
        ((CopyOnWriteArrayList) sCachedDataCenter.f203246i).add(r100);
    }

    public static void registerAnrUploadCallback(m r100) {
        ((CopyOnWriteArrayList) sCachedDataCenter.f203250m).add(r100);
    }

    public static void registerExceptionTriggerCallback(q r100) {
        monitor-enter(com.bytedance.crash.monitor.b.class);
        if (r100 != null) goto L14;
    L12:
        monitor-exit(com.bytedance.crash.monitor.b.class);
        return;
    L14:
    L9:
        th = move-exception;
        throw th;
    L6:
        if (com.bytedance.crash.monitor.b.f203268i.equals("none") == true) goto L12;
        r100.b();     // Catch: Throwable -> L9
        goto L12
    }

    public static void registerHprofCallback(IOOMCallback r100) {
        ((CopyOnWriteArrayList) sCachedDataCenter.f203245h).add(r100);
    }

    public static void registerOOMCallback(IOOMCallback r100) {
        ((CopyOnWriteArrayList) sCachedDataCenter.f203244g).add(r100);
    }

    public static void registerPreANRCallback(u r100) {
        ((CopyOnWriteArrayList) sCachedDataCenter.f203249l).add(r100);
    }

    public static void removeCustomCrashReasonArray(String r100) {
        ((ConcurrentHashMap) sCachedDataCenter.f203251n).remove(r100);
    }

    public static void removeImportTag(String r100) {
        i0.c(r100);
    }

    public static void removeTag(String r100) {
        m0 r101 = sCachedDataCenter;
        Map<String, String> r102 = i0.f203227a;
        if (NativeBridge.H() == true) goto L5;
    L10:
        r101.f203238a.remove(r100);
        return;
    L5:
        if (r101.f203254q == false) goto L10;
        if (r101.f203255r == false) goto L9;
        NativeBridge.P(r100);
        return;
    L9:
        r101.f203238a.remove(r100);
    }

    public static void reportDartError(String r100) {
        if (d0.d() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        bh4.a.a(r100, null, null, null);
        return;
    }

    public static void reportError(Throwable r100) {
        a0.f203096a.isReportErrorEnable();
    }

    public static void setANRImprovementOpt(boolean r100) {
        k.f203234d = r100;
    }

    public static void setAlogFlushV2Addr(long r100) {
        wg4.a.b r101 = wg4.a.f559547a;
        NativeBridge.R(r100);
    }

    public static void setAnrDisableDumpData(boolean r100) {
        xg4.p.f563718j = !r100;
    }

    public static void setAnrMonitorOpt(boolean r100) {
        k.f203231a = r100;
    }

    public static void setAnrResendSigquit(boolean r100) {
        NativeBridge.T(r100);
    }

    public static void setApplication(Application r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (i.a().f203223c != null) goto L8;
        i.a().f203223c = r100;
        return;
    }

    public static void setBusiness(String r100) {
        i.f203218h = r100;
    }

    public static void setCrashAccessibilityEnable(boolean r100) {
        ai4.e.f3755b = r100;
    }

    public static void setCrashFilter(ICrashFilter r100) {
        sCachedDataCenter.f203253p = r100;
    }

    public static void setCrashUploadCallback(c r100) {
        sCachedDataCenter.getClass();
    }

    public static void setCurProcessName(String r100) {
        com.bytedance.crash.util.b.f203406a = r100;
    }

    public static void setDomainName(String r100) {
        wh4.a.a(new URL(r100).getHost());     // Catch: Throwable -> L4
        return;
    }

    public static void setDumpAnrAsync(boolean r100) {
        d0.f203146d = r100;
    }

    public static void setEncryptImpl(p r100) {
        if (r100 == null) goto L4;
        zg4.i.f572088d = r100;
        return;
    L4:
        boolean r101 = zg4.i.f572087c;
    }

    public static void setFixDumpStack(boolean r100) {
        nh4.a.f519163g = r100;
        nh4.a.f519164h = false;
    }

    public static void setIgnoreHandler(hh4.a r100) {
        com.bytedance.crash.crash.d.f203130f.add(r100);
    }

    public static void setMaxCacheSize(int r100) {
        if (r100 <= 0) goto L4;
        fh4.f.f477011e = r100;
        return;
    L4:
        int r101 = fh4.f.f477011e;
    }

    public static void setOpenNewAnrMonitor(boolean r100) {
        k.f203232b = r100;
    }

    public static void setQueueLimitSize(int r100) {
        if (r100 > 0) goto L4;
        fh4.f.f477013g = true;
        return;
    L4:
        fh4.f.f477012f = r100;
    }

    public static void setTagCacheService(x r100) {
        Map<String, String> r101 = i0.f203227a;
        m0 r102 = sCachedDataCenter;
        if (NativeBridge.H() == true) goto L5;
    L7:
        Map r103 = r102.f203238a;
    L8:
        HashMap r104 = new HashMap(r103);
        if (r104.isEmpty() == true) goto L12;
        r102.c(r104);     // Catch: Throwable -> L14
    L12:
        r102.f203238a.clear();
        return;
    L5:
        if (r102.f203254q == false) goto L7;
        r103 = NativeBridge.z();
        goto L8
    }

    public static void setTagOpt(boolean r100) {
        m0 r101 = sCachedDataCenter;
        if (r101.f203254q == true) goto L10;
        if (r100 == false) goto L10;
        r101.f203254q = true;
        if (r101.f203238a.isEmpty() == true) goto L10;
        if (NativeBridge.H() == false) goto L10;
        r101.f203255r = false;
        wh4.b.post(new l0(r101));
    L10:
        r101.f203254q = r100;
    }

    public static void setUploadDelayTime(long r100) {
        com.bytedance.crash.upload.g.f203360a = r100;
    }

    public static void setUseLocalDomain(boolean r100) {
        com.bytedance.crash.monitor.b.f203267h = r100;
    }

    public static int startOptMtkBuffer(int r100) {
        boolean r101 = nh4.a.f519163g;
        monitor-enter(nh4.a.class);
        Context r102 = i.getContext();     // Catch: Throwable -> L14
        if (r102 == null) goto L7;
        int r103 = NpthRepair.a(r102, false);     // Catch: Throwable -> L14
    L8:
        if (r103 != 0) goto L12;
        r103 = MTKBufferOpt.a(r100);     // Catch: Throwable -> L14
        monitor-exit(nh4.a.class);
    L13:
        return r103;
    L12:
        monitor-exit(nh4.a.class);
        goto L13
    L7:
        r103 = -7;
    L14:
        th = move-exception;
        throw th;
    }

    public static void unregisterPreANRCallback(u r100) {
        ((CopyOnWriteArrayList) sCachedDataCenter.f203249l).remove(r100);
    }

    public static void addAttachLongUserData(AttachUserData r100, CrashType r101) {
        sCachedDataCenter.a(r100, r101);
    }

    public static void addAttachUserData(AttachUserData r100, CrashType r101) {
        sCachedDataCenter.a(r100, r101);
    }

    public static void addCustomCrashReasonArray(String r100, String r101) {
        m0 r102 = sCachedDataCenter;
        if (r101 != null) goto L6;
        r102.getClass();
        return;
    L6:
        if (((ConcurrentHashMap) r102.f203251n).containsKey(r100) == true) goto L17;
        Map<String, LinkedList<String>> r103 = r102.f203251n;
        monitor-enter(r103);
    L14:
        th = move-exception;
        throw th;
    L10:
        if (((ConcurrentHashMap) r102.f203251n).containsKey(r100) == true) goto L12;
        Map<String, LinkedList<String>> r104 = r102.f203251n;     // Catch: Throwable -> L14
        ConcurrentHashMap r105 = (ConcurrentHashMap) r104;     // Catch: Throwable -> L14
        r105.put(r100, new LinkedList());     // Catch: Throwable -> L14
    L12:
        monitor-exit(r103);     // Catch: Throwable -> L14
    L17:
        LinkedList r106 = (LinkedList) ((ConcurrentHashMap) r102.f203251n).get(r100);
        if (r106 == null) goto L42;
        monitor-enter(r106);
    L34:
        th = move-exception;
        throw th;
    L22:
        if (r106.contains(r101) == false) goto L26;
        monitor-exit(r106);     // Catch: Throwable -> L34
        return;
    L26:
        if (((ConcurrentHashMap) r102.f203252o).containsKey(r100) == false) goto L31;
        int r107 = ((Integer) ((ConcurrentHashMap) r102.f203252o).get(r100)).intValue();     // Catch: Throwable -> L34
        if (r106.size() <= r107) goto L30;
        r106.removeFirst();     // Catch: Throwable -> L34
    L30:
        r106.add(r101);     // Catch: Throwable -> L34
    L32:
        monitor-exit(r106);     // Catch: Throwable -> L34
        return;
    L31:
        r106.add(r101);     // Catch: Throwable -> L34
        goto L32
    }

    public static void addImportTag(String r100, String r101) {
        if (r100 != null) goto L4;
        Map<String, String> r102 = i0.f203227a;
        return;
    L4:
        if (r101 != null) goto L6;
        i0.c(r100);
        return;
    L6:
        Map<String, String> r103 = i0.f203227a;
        ((ConcurrentHashMap) r103).put(r100, r101);
        if (d0.d() == false) goto L13;
        wh4.b.post(new h0(new HashMap(r103)));
        return;
    }

    public static void addTag(String r100, String r101) {
        m0 r102 = sCachedDataCenter;
        Map<String, String> r103 = i0.f203227a;
        r102.b(r100, r101);
    }

    public static void addUserCrashInfoCallback(y r100, CrashType r101) {
        if (r100 == null) goto L14;
        m0 r102 = sCachedDataCenter;
        ListMap<CrashType, y> r103 = r102.f203248k;
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r101 != CrashType.ALL) goto L8;
        r102.f203248k.addMulti(r100, new CrashType[]{CrashType.ANR, CrashType.LAUNCH, CrashType.JAVA, CrashType.DART, CrashType.GAME, CrashType.NATIVE});     // Catch: Throwable -> L11
    L9:
        monitor-exit(r103);     // Catch: Throwable -> L11
        return;
    L8:
        r102.f203248k.add(r101, r100);     // Catch: Throwable -> L11
        goto L9
    }

    public static synchronized void init(Context r100, ICommonParams r101) {
        monitor-enter(Npth.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (isInit() == false) goto L9;
        monitor-exit(Npth.class);
        return;
    L9:
        if (ch4.b.f23762d != null) goto L11;
        ch4.b.f23762d = new ch4.b();     // Catch: Throwable -> L18
    L11:
        com.bytedance.crash.monitor.a r102 = com.bytedance.crash.monitor.j.b(r100, r101);     // Catch: Throwable -> L18
        r102.f203300l = new com.bytedance.crash.dumper.j(r101);     // Catch: Throwable -> L18
        new b();     // Catch: Throwable -> L18
        wh4.b.post(new a(r102));     // Catch: Throwable -> L18
        if (ch4.b.f23762d != null) goto L22;
    L16:
        monitor-exit(Npth.class);
        return;
    L22:
        long r103 = SystemClock.uptimeMillis();     // Catch: Throwable -> L21
        ch4.b r104 = ch4.b.f23762d;     // Catch: Throwable -> L21
        long r105 = r103 - r104.f23764b;     // Catch: Throwable -> L21
        r104.f23763a.put("total", r105);     // Catch: Throwable -> L21
    L15:
        wh4.b.post(new ch4.a());     // Catch: Throwable -> L18
        goto L16
    }

    public static synchronized void initMiniApp(Context r100, ICommonParams r101) {
        monitor-enter(Npth.class);
        d0.f203143a = true;     // Catch: Throwable -> L8
        init(r100, r101, true, false, true, true);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void registerCrashCallback(ICrashCallback r100, CrashType r101) {
        m0 r102 = sCachedDataCenter;
        ListMap<CrashType, ICrashCallback> r103 = r102.f203242e;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101 != CrashType.ALL) goto L7;
        r102.f203242e.addMulti(r100, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L7:
        r102.f203242e.add(r101, r100);     // Catch: Throwable -> L10
        goto L8
    }

    public static void registerCrashInfoCallback(com.bytedance.crash.b r100, CrashType r101) {
        m0 r102 = sCachedDataCenter;
        ListMap<CrashType, com.bytedance.crash.b> r103 = r102.f203243f;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101 != CrashType.ALL) goto L7;
        r102.f203243f.addMulti(r100, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L7:
        r102.f203243f.add(r101, r100);     // Catch: Throwable -> L10
        goto L8
    }

    public static void registerPreCrashCallback(v r100, CrashType r101) {
        m0 r102 = sCachedDataCenter;
        ListMap<CrashType, v> r103 = r102.f203247j;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101 != CrashType.ALL) goto L7;
        r102.f203247j.addMulti(r100, new CrashType[]{CrashType.NATIVE, CrashType.ANR, CrashType.JAVA, CrashType.LAUNCH});     // Catch: Throwable -> L10
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L7:
        r102.f203247j.add(r101, r100);     // Catch: Throwable -> L10
        goto L8
    }

    public static void registerSdk(int r100, String r101) {
        sCachedDataCenter.f203239b.put(Integer.valueOf(r100), r101);
    }

    public static void removeAttachLongUserData(AttachUserData r100, CrashType r101) {
        m0 r102 = sCachedDataCenter;
        if (r100 == null) goto L15;
        ListMap<CrashType, AttachUserData> r103 = r102.f203241d;
        monitor-enter(r103);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r101 != CrashType.ALL) goto L9;
        r102.f203241d.removeAll(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r103);     // Catch: Throwable -> L12
        return;
    L9:
        r102.f203241d.removeInList(r101, r100);     // Catch: Throwable -> L12
        goto L10
    L15:
        r102.getClass();
    }

    public static void removeAttachUserData(AttachUserData r100, CrashType r101) {
        m0 r102 = sCachedDataCenter;
        if (r100 == null) goto L15;
        ListMap<CrashType, AttachUserData> r103 = r102.f203241d;
        monitor-enter(r103);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (r101 != CrashType.ALL) goto L9;
        r102.f203241d.removeAll(r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r103);     // Catch: Throwable -> L12
        return;
    L9:
        r102.f203241d.removeInList(r101, r100);     // Catch: Throwable -> L12
        goto L10
    L15:
        r102.getClass();
    }

    public static void removeCrashInfoCallback(y r100, CrashType r101) {
        if (r100 == null) goto L14;
        m0 r102 = sCachedDataCenter;
        ListMap<CrashType, y> r103 = r102.f203248k;
        monitor-enter(r103);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r101 != CrashType.ALL) goto L8;
        r102.f203248k.removeAll(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r103);     // Catch: Throwable -> L11
        return;
    L8:
        r102.f203248k.removeInList(r101, r100);     // Catch: Throwable -> L11
        goto L9
    }

    public static void reportBizException(String r100, fh4.k r101) {
        reportBizException(r100, r101, false);
    }

    public static void setAnrInfoFileObserver(String r100, t r101) {
        wh4.b.post(new xg4.n(r100));
    }

    public static void setAttachUserData(AttachUserData r100, CrashType r101) {
        addAttachUserData(r100, r101);
    }

    public static void setCustomCrashReasonArrayLimit(String r100, int r101) {
        Map<String, Integer> r102 = sCachedDataCenter.f203252o;
        ConcurrentHashMap r103 = (ConcurrentHashMap) r102;
        r103.put(r100, Integer.valueOf(r101));
    }

    public static void unregisterCrashCallback(ICrashCallback r100, CrashType r101) {
        m0 r102 = sCachedDataCenter;
        ListMap<CrashType, ICrashCallback> r103 = r102.f203242e;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101 != CrashType.ALL) goto L7;
        r102.f203242e.removeAll(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L7:
        r102.f203242e.removeInList(r101, r100);     // Catch: Throwable -> L10
        goto L8
    }

    public static void unregisterHprofCallback(IOOMCallback r100, CrashType r101) {
        ((CopyOnWriteArrayList) sCachedDataCenter.f203245h).remove(r100);
    }

    public static void unregisterOOMCallback(IOOMCallback r100, CrashType r101) {
        ((CopyOnWriteArrayList) sCachedDataCenter.f203244g).remove(r100);
    }

    public static void unregisterPreCrashCallback(v r100, CrashType r101) {
        m0 r102 = sCachedDataCenter;
        ListMap<CrashType, v> r103 = r102.f203247j;
        monitor-enter(r103);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r101 != CrashType.ALL) goto L7;
        r102.f203247j.removeAll(r100);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r103);     // Catch: Throwable -> L10
        return;
    L7:
        r102.f203247j.removeInList(r101, r100);     // Catch: Throwable -> L10
        goto L8
    }

    public static void registerSdk(String r100, String r101) {
        sCachedDataCenter.f203240c.put(r100, r101);
    }

    public static void enableALogCollector(String r100, wg4.c r101, wg4.d r102) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (new PolarisFileWrapper(r100).exists() == false) goto L13;
        wg4.a.b r103 = wg4.a.f559547a;
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return;
    L9:
        if (wg4.a.f559547a != null) goto L15;
        wg4.a.f559547a = new wg4.a.b(r100, r101, r102);
        return;
    L15:
        return;
    }

    public static void reportBizException(String r100, fh4.k r101, boolean r102) {
        if (r100 == null) goto L25;
        if (r101 == null) goto L26;
        fh4.b r103 = fh4.c.f476992e.f476993a;
        boolean r104 = true;
        if (r103 != null) goto L8;
        boolean r105 = false;
    L9:
        if (r105 == false) goto L23;
        if (r103 != null) goto L12;
    L20:
        r104 = false;
    L21:
        if (r104 == true) goto L23;
        return;
    L12:
        if (r103.f476990a == false) goto L20;
        Set<String> r106 = r103.f476991b;
        if (r106 != null) goto L17;
        boolean r107 = false;
    L18:
        if (r107 == false) goto L20;
    L17:
        r107 = r106.contains(r100);
    L23:
        r101.getException();
        return;
    L8:
        r105 = true;
        goto L9
    L26:
        return;
    }

    public static void reportGameException(String r100, String r101, String r110) {
        if (d0.d() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L13;
        if (TextUtils.isEmpty(r101) == false) goto L13;
        if (TextUtils.isEmpty(r100) == false) goto L13;
        return;
    L13:
        if (gh4.a.f481274a == true) goto L19;
        long r102 = System.currentTimeMillis();
        wh4.b.post(new gh4.a.RunnableC6021a(ThreadMethodProxy.currentThread().getName(), r102, r100, r101, r110));
        return;
    }

    public static void scanNativeCrash(Context r100, com.bytedance.crash.a r101, String[] r102) {
        File[] r103 = new PolarisFileWrapper(i.e(r100), "crash").listFiles();
        if (r103 != null) goto L28;
        ArrayList r104 = null;
    L16:
        if (r104 != null) goto L18;
        return;
    L18:
        Iterator r105 = r104.iterator();
    L20:
        if (r105.hasNext() == false) goto L26;
        CrashSummary r106 = (CrashSummary) r105.next();
        if (r106 == null) goto L20;
        r106.getCrashType();
        r106.getStartTime();
        r106.getCrashTime();
        r106.getProcessName();
        r106.getStackTrace();
        throw null;
    L26:
        return;
    L28:
        com.bytedance.crash.util.t.a();     // Catch: Throwable -> L8
    L8:
        ConfigManager r107 = a0.f203096a;     // Catch: Throwable -> L27
        com.bytedance.librarian.a.e("npth", true, i.getContext());     // Catch: Throwable -> L27
    L9:
        r104 = new ArrayList();
        int r108 = r103.length;
        int r109 = 0;
    L10:
        if (r109 >= r108) goto L16;
        CrashSummary r110 = CrashSummary.loadFromDirectory(r103[r109], true);
        if (r110 == null) goto L15;
        r104.add(r110);
    L15:
        r109 = r109 + 1;
        goto L10
    }

    public static synchronized void initMiniApp(Context r100, ICommonParams r101, int r110, String r111) {
        monitor-enter(Npth.class);
        d0.f203143a = true;     // Catch: Throwable -> L8
        d0.f203144b = r110;     // Catch: Throwable -> L8
        d0.f203145c = r111;     // Catch: Throwable -> L8
        init(r100, r101, true, true, true, true);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void reportBizException(String r100, Throwable r101, String r102, Map<String, String> r103) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        reportBizException(r100, r101, r102, r103, false);
        return;
    L8:
        return;
    }

    public static void reportDartError(String r100, Map<? extends String, ? extends String> r101, Map<String, String> r102, IUploadCallback r103) {
        if (d0.d() == true) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        bh4.a.a(r100, r101, r102, r103);
        return;
    }

    public static synchronized void init(Context r100, ICommonParams r101, boolean r102, boolean r110, boolean r111) {
        monitor-enter(Npth.class);
        init(r100, r101, r102, r102, r110, r111);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized com.bytedance.crash.monitor.f initSDK(Context r100, String r101, int r110, long r111, String r112) {
        monitor-enter(Npth.class);
        com.bytedance.crash.monitor.f r102 = com.bytedance.crash.monitor.j.a(r100, r101, r110, r111, r112);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return r102;
    L8:
        th = move-exception;
        throw th;
    }

    public static void reportBizException(String r100, Throwable r101, String r102, Map<String, String> r110, boolean r111) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        fh4.c.f476992e.b(r100, r101, r102, r110, null, r111);
        return;
    L8:
        return;
    }

    public static void reportBizException(String r100, Throwable r101, String r102, Map<String, String> r103, Map<String, String> r110) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        reportBizException(r100, r101, r102, r103, r110, false);
        return;
    L8:
        return;
    }

    public static synchronized void init(Context r100, ICommonParams r110, boolean r111, boolean r112, boolean r113, boolean r114) {
        monitor-enter(Npth.class);
        init(r100, r110, r111, r112, r113, r114, 0);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void reportBizException(String r100, Throwable r101, String r102, Map<String, String> r110, Map<String, String> r111, boolean r112) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        fh4.c.f476992e.b(r100, r101, r102, r110, r111, r112);
        return;
    L8:
        return;
    }

    public static synchronized void init(Context r110, ICommonParams r111, boolean r112, boolean r113, boolean r114, boolean r115, long r116) {
        monitor-enter(Npth.class);
        init(null, r110, r111, r112, r113, r114, r115, r116);     // Catch: Throwable -> L8
        monitor-exit(Npth.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Application r100, Context r101, ICommonParams r102, boolean r103, boolean r104, boolean r105, boolean r106, long r107) {
        monitor-enter(Npth.class);
        init(r101, r102);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
