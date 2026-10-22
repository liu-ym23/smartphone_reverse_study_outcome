package com.ss.android.agilelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.android.alog.Alog;
import com.bytedance.android.alog.c;
import com.bytedance.android.alog.e;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.ss.android.agilelogger.utils.FormatUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.io.File;
import java.io.FilenameFilter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import nra.a;
import nra.b;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ALog {
    private static final int MSG_ASYNC_FLUSH = 2;
    private static final int MSG_ASYNC_LOG = 1;
    private static volatile Set<String> mBlockTagSet = null;
    private static Alog mainThreadRef = null;
    private static int prio = 3;
    private static Handler sAsyncHandler;
    private static HandlerThread sAsyncLogThread;
    public static ALogConfig sConfig;
    private static volatile boolean sDebug;
    private static volatile a sILogCacheCallback;
    private static volatile List<b> sINativeFuncAddrCallbackList;
    private static Object sInitLock;
    private static volatile boolean sInitSuccess;
    private static boolean sInitialized;
    private static volatile List<c> sLogFileDeleteListeners;
    private static ScheduledExecutorService sOuterExecutorService;
    private static ExecutorService sSingleThreadExecutor;
    private static ArrayList<WeakReference<Alog>> sStandaloneInstances;
    private static final ThreadLocal<Long> sThreadId = null;

    public static class d implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ FormatUtils.TYPE b;
        public final /* synthetic */ Throwable c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ String f;
        public final /* synthetic */ long g;
        public final /* synthetic */ long h;

        public final void a() {
            int r2 = ALog.access$400(this.a);
            FormatUtils.TYPE r0 = this.b;
            if (r0 != null) goto L12;
            Throwable r1 = this.c;
            if (r1 != null) goto L8;
        L33:
            String r3 = this.f;
            String r4 = this.d;
            long r5 = this.g;
            long r7 = this.h;
            Alog r6 = e.a;
            if (r6 == null) goto L37;
            r6.o(r2, r3, r4, r5, r7);
            return;
        L37:
            return;
        L8:
            if (this.d == null) goto L11;
        L11:
            wra.c.a(r1);
            goto L33
        L12:
            FormatUtils.TYPE r8 = FormatUtils.TYPE.BORDER;
            if (r0 != r8) goto L15;
            FormatUtils.c(r8, this.d);
            goto L33
        L15:
            FormatUtils.TYPE r9 = FormatUtils.TYPE.JSON;
            if (r0 != r9) goto L18;
            FormatUtils.c(r9, this.d);
            goto L33
        L18:
            FormatUtils.TYPE r10 = FormatUtils.TYPE.BUNDLE;
            if (r0 != r10) goto L21;
            FormatUtils.b(r10, (Bundle) this.e);
            goto L33
        L21:
            FormatUtils.TYPE r11 = FormatUtils.TYPE.INTENT;
            if (r0 != r11) goto L24;
            FormatUtils.a(r11, (Intent) this.e);
            goto L33
        L24:
            FormatUtils.TYPE r12 = FormatUtils.TYPE.THROWABLE;
            if (r0 != r12) goto L27;
            FormatUtils.e(r12, (Throwable) this.e);
            goto L33
        L27:
            FormatUtils.TYPE r13 = FormatUtils.TYPE.THREAD;
            if (r0 != r13) goto L30;
            FormatUtils.d(r13, (Thread) this.e);
            goto L33
        L30:
            FormatUtils.TYPE r14 = FormatUtils.TYPE.STACKTRACE;
            if (r0 != r14) goto L33;
            FormatUtils.f(r14, (StackTraceElement[]) this.e);
            goto L33
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(int r1, FormatUtils.TYPE r2, Throwable r3, String r4, Object r5, String r6, long r7, long r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r9;
        }
    }

    public static class f extends ThreadLocal<Long> {
        @Override // java.lang.ThreadLocal
        public final Long initialValue() {
            return Long.valueOf(Process.myTid());
        }

        public f() {
        }
    }

    public static class g implements ThreadFactory {
        public g() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r3) {
            PthreadThreadV2 r0 = new PthreadThreadV2(r3, "logger/ALog$2");
            ThreadMethodProxy.setName(r0, "Alog_newthreadpoolimpl");
            return r0;
        }
    }

    public static class j extends TimerTask {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ALog.access$300(this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class l implements FilenameFilter {
        public l() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r1, String r2) {
            return r2.startsWith(".logCache_");
        }
    }

    public static class m implements FilenameFilter {
        public m() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r2, String r3) {
            if (r3.endsWith(".hoting") == false) goto L6;
            return true;
        L6:
            if (r3.endsWith(".hot") == true) goto L8;
            return false;
        L8:
            if (r3.endsWith(".alog.hot") == true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    public ALog() {
    }

    public static void forceLogSharding() {
    }

    private static int level2AlogCoreLevel(int r0) {
        return r0 - 2;
    }

    public static void setPrintStackTrace(boolean r0) {
    }

    public static void setsPackageClassName(String r0) {
    }

    static {
        sINativeFuncAddrCallbackList = new ArrayList();
        sLogFileDeleteListeners = null;
        sOuterExecutorService = null;
        mainThreadRef = null;
        sStandaloneInstances = new ArrayList();
        sSingleThreadExecutor = null;
        sInitialized = false;
        sInitLock = new Object();
        sThreadId = new f();
    }

    public static void asyncFlush() {
        ExecutorService r0 = sSingleThreadExecutor;
        if (r0 == null) goto L5;
        r0.execute(new n());
    L8:
        e.a();
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L11;
        r1.a();
    L11:
        Iterator<WeakReference<Alog>> r2 = sStandaloneInstances.iterator();
    L13:
        if (r2.hasNext() == false) goto L20;
        WeakReference<Alog> r3 = r2.next();
        if (r3 == null) goto L13;
        Alog r4 = r3.get();
        if (r4 == null) goto L13;
        r4.a();
        goto L13
    L20:
        return;
    L5:
        Handler r5 = sAsyncHandler;
        if (r5 == null) goto L8;
        r5.sendEmptyMessage(2);
        goto L8
    }

    public static void destroy() {
        Alog.nativeSetDefaultInstance(0);
        e.a.b();
        e.a = null;
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L6;
        r1.b();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r2 = sSingleThreadExecutor;
        if (r2 == null) goto L12;
        r2.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    public static void flush() {
        ExecutorService r0 = sSingleThreadExecutor;
        if (r0 == null) goto L5;
        r0.execute(new c());
    L5:
        Handler r1 = sAsyncHandler;
        if (r1 == null) goto L8;
        r1.sendEmptyMessage(2);
    L8:
        e.a();
        Alog r2 = mainThreadRef;
        if (r2 == null) goto L12;
        r2.a();
        return;
    }

    public static long getALogSimpleInitFuncAddr() {
        Alog r0 = e.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.f();
    }

    public static long getALogSimpleWriteAsyncFuncAddr() {
        Alog r0 = e.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.g();
    }

    public static long getALogSimpleWriteFuncAddr() {
        Alog r0 = e.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.h();
    }

    public static long getALogWriteFuncAddr() {
        Alog r0 = e.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.e();
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        Alog r0 = e.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        Alog r0 = e.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.d();
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        if (e.a == null) goto L15;
        HashMap<String, String> r0 = new HashMap();
        r0.put("start", Long.toString(com.bytedance.android.alog.b.a));
        r0.put("end", Long.toString(com.bytedance.android.alog.b.b));
        r0.put("reason", com.bytedance.android.alog.b.d);
        if (com.bytedance.android.alog.b.c == null) goto L14;
        StringBuilder r1 = new StringBuilder();
        Iterator r2 = com.bytedance.android.alog.b.c.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        String r3 = (String) r2.next();
        if (r3.endsWith(".alog.hot") == false) goto L12;
        r3 = r3.substring(0, r3.length() - 9);
    L12:
        r1.append(r3);
        r1.append(";");
        goto L8
    L13:
        r0.put("file", r1.toString());
    L14:
        com.bytedance.android.alog.b.d = null;
        com.bytedance.android.alog.b.c = null;
        return r0;
    L15:
        HashMap<String, String> r4 = new HashMap();
        r4.put("reason", "Log.instance does not exist");
        return r4;
    }

    private static long getThreadId() {
        return sThreadId.get().longValue();
    }

    public static void release() {
        Alog.nativeSetDefaultInstance(0);
        e.a.b();
        e.a = null;
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L6;
        r1.b();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r2 = sSingleThreadExecutor;
        if (r2 == null) goto L12;
        r2.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    public static void syncFlush() {
        ExecutorService r0 = sSingleThreadExecutor;
        if (r0 == null) goto L5;
        r0.execute(new a());
    L5:
        Handler r1 = sAsyncHandler;
        if (r1 == null) goto L8;
        r1.sendEmptyMessage(2);
    L8:
        Alog r2 = e.a;
        if (r2 == null) goto L11;
        r2.l();
    L11:
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L14;
        r3.l();
    L14:
        Iterator<WeakReference<Alog>> r4 = sStandaloneInstances.iterator();
    L16:
        if (r4.hasNext() == false) goto L20;
        Alog r5 = r4.next().get();
        if (r5 == null) goto L16;
        r5.l();
        goto L16
    }

    public static /* synthetic */ long access$500() {
        return getThreadId();
    }

    public static String getStatus() {
        return e.b();
    L4:
        return "getStatus exception";
    }

    public static /* synthetic */ a access$200() {
        return sILogCacheCallback;
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static List<b> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static /* synthetic */ void access$000(o r0) {
        handleAsyncLog(r0);
    }

    public static /* synthetic */ void access$100(Queue r0) {
        writeCachedItems(r0);
    }

    public static /* synthetic */ int access$400(int r0) {
        return level2AlogCoreLevel(r0);
    }

    public static synchronized void addLogFileDeleteListener(c r2) {
        monitor-enter(ALog.class);
        if (r2 != null) goto L18;
        monitor-exit(ALog.class);
        return;
    L18:
    L15:
        th = move-exception;
        throw th;
    L8:
        if (sLogFileDeleteListeners != null) goto L11;
        sLogFileDeleteListeners = new CopyOnWriteArrayList();     // Catch: Throwable -> L15
    L11:
        if (sLogFileDeleteListeners.contains(r2) == true) goto L13;
        sLogFileDeleteListeners.add(r2);     // Catch: Throwable -> L15
    L13:
        monitor-exit(ALog.class);
    }

    public static void addMessageInterceptor(com.bytedance.android.alog.d r1) {
        if (r1 != null) goto L5;
        int r2 = Alog.i;
        return;
    L5:
        if (Alog.o != null) goto L8;
        Alog.o = new CopyOnWriteArrayList();
    L8:
        if (((CopyOnWriteArrayList) Alog.o).contains(r1) == true) goto L12;
        ((CopyOnWriteArrayList) Alog.o).add(r1);
        return;
    }

    public static void addNativeFuncAddrCallback(b r1) {
        sINativeFuncAddrCallbackList.add(r1);
    }

    public static void changeLevel(int r2) {
        prio = r2;
        int r0 = level2AlogCoreLevel(r2);
        Alog r1 = e.a;
        if (r1 == null) goto L5;
        r1.j(r0);
    L5:
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L9;
        r3.j(level2AlogCoreLevel(r2));
        return;
    }

    private static void handleAsyncLog(o r9) {
        int r2 = level2AlogCoreLevel(r9.a);
        String r0 = XmlPullParser.NO_NAMESPACE;
        FormatUtils.TYPE r1 = r9.e;
        if (r1 == null) goto L5;
        FormatUtils.TYPE r3 = FormatUtils.TYPE.BORDER;
        if (r1 != r3) goto L16;
        r0 = FormatUtils.c(r3, r9.c);
    L15:
        String r4 = r0;
        String r5 = r9.b;
        long r6 = r9.g;
        long r7 = r9.h;
        Alog r8 = e.a;
        if (r8 == null) goto L37;
        r8.o(r2, r5, r4, r6, r7);
    L37:
        r9.b = null;
        r9.c = null;
        r9.d = null;
        r9.e = null;
        r9.f = null;
        r9.g = -1;
        r9.h = 0;
        r9.i = null;
        Object r10 = o.j;
        monitor-enter(r10);
        int r11 = o.l;     // Catch: Throwable -> L44
        if (r11 >= 50) goto L42;
        r9.i = o.k;     // Catch: Throwable -> L44
        o.k = r9;     // Catch: Throwable -> L44
        o.l = r11 + 1;     // Catch: Throwable -> L44
    L42:
        monitor-exit(r10);     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        throw th;
    L16:
        FormatUtils.TYPE r12 = FormatUtils.TYPE.JSON;
        if (r1 != r12) goto L19;
        r0 = FormatUtils.c(r12, r9.c);
        goto L15
    L19:
        FormatUtils.TYPE r13 = FormatUtils.TYPE.BUNDLE;
        if (r1 != r13) goto L22;
        r0 = FormatUtils.b(r13, (Bundle) r9.f);
        goto L15
    L22:
        FormatUtils.TYPE r14 = FormatUtils.TYPE.INTENT;
        if (r1 != r14) goto L25;
        r0 = FormatUtils.a(r14, (Intent) r9.f);
        goto L15
    L25:
        FormatUtils.TYPE r15 = FormatUtils.TYPE.THROWABLE;
        if (r1 != r15) goto L28;
        r0 = FormatUtils.e(r15, (Throwable) r9.f);
        goto L15
    L28:
        FormatUtils.TYPE r16 = FormatUtils.TYPE.THREAD;
        if (r1 != r16) goto L31;
        r0 = FormatUtils.d(r16, (Thread) r9.f);
        goto L15
    L31:
        FormatUtils.TYPE r17 = FormatUtils.TYPE.STACKTRACE;
        if (r1 != r17) goto L15;
        r0 = FormatUtils.f(r17, (StackTraceElement[]) r9.f);
        goto L15
    L5:
        if (r9.d != null) goto L8;
        r0 = r9.c;
        goto L15
    L8:
        if (r9.c != null) goto L10;
        String r18 = XmlPullParser.NO_NAMESPACE;
    L11:
        r0 = r18 + wra.c.a(r9.d);
        goto L15
    L10:
        r18 = r9.c + "\n";
        goto L11
    }

    private static void handleItemMsg(nra.d r2) {
        String r1 = null;
        switch(e.a[r2.d.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        r1 = XmlPullParser.NO_NAMESPACE;
        goto L12
    L5:
        r1 = FormatUtils.f(r2.d, null);
        goto L12
    L6:
        r1 = FormatUtils.d(r2.d, null);
        goto L12
    L7:
        r1 = FormatUtils.e(r2.d, null);
        goto L12
    L8:
        r1 = FormatUtils.a(r2.d, null);
        goto L12
    L9:
        r1 = FormatUtils.b(r2.d, null);
        goto L12
    L10:
        r1 = FormatUtils.c(r2.d, null);
        goto L12
    L11:
        r1 = wra.c.a(null);
    L12:
        r2.c = r1;
    }

    public static boolean init(ALogConfig r14) {
        boolean r0 = false;
        if (r14 != null) goto L5;
        return false;
    L5:
        sConfig = r14;
        Alog.i(new nra.c());     // Catch: Throwable -> L112
        Object r1 = sInitLock;
        monitor-enter(r1);
    L109:
        th = move-exception;
        throw th;
    L10:
        if (sInitialized == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L109
        return false;
    L13:
        sInitialized = true;     // Catch: Throwable -> L109
        monitor-exit(r1);     // Catch: Throwable -> L109
        prio = r14.getLevel();
        Context r2 = r14.getContext();
        String r3 = nra.e.b();
        if (r3 != null) goto L19;
    L27:
        boolean r4 = false;
    L28:
        boolean r5 = r14.isOffloadMainThreadWrite();
        if (r5 == false) goto L31;
    L34:
        boolean r6 = false;
    L35:
        boolean r7 = r14.enableOffloadInAllProcess();
        boolean r8 = r14.isNewThreadPoolImplementation();
        if (r4 == true) goto L38;
        r14.setMaxDirSize((int) (r14.getMaxDirSize() * r14.getSubProcessMaxDirSizeRatio()));
    L38:
        Alog.a r9 = new Alog.a(r14.getContext());
        r9.b("default");
        r9.b = level2AlogCoreLevel(r14.getLevel());
        r9.c = sDebug;
        r9.e = r14.getLogDirPath();
        r9.f = r14.getPerSize();
        if (r6 == false) goto L41;
        int r10 = (r14.getMaxDirSize() / 3) * 2;
    L42:
        r9.g = r10;
        r9.h = r14.getLogFileExpDays();
        r9.i = r14.getBufferDirPath();
        if (r4 == false) goto L45;
        int r11 = r14.getCacheFileSizeInKB() * 1024;
    L46:
        r9.j = r11;
        if (r4 == false) goto L49;
        int r12 = (r14.getCacheFileSizeInKB() * 3) * 1024;
    L50:
        r9.k = r12;
        Alog.Mode r13 = Alog.Mode.SAFE;
        r9.m = r13.getValue();
        Alog.TimeFormat r15 = Alog.TimeFormat.RAW;
        r9.n = r15.getValue();
        Alog.PrefixFormat r16 = Alog.PrefixFormat.LEGACY;
        r9.o = r16.getValue();
        if (r14.isCompress() == false) goto L53;
        Alog.Compress r17 = Alog.Compress.ZSTD;
    L54:
        r9.p = r17.getValue();
        if (r14.isEncrypt() == false) goto L57;
        Alog.SymCrypt r18 = Alog.SymCrypt.TEA_16;
    L58:
        r9.q = r18.getValue();
        if (r14.isEncrypt() == false) goto L61;
        Alog.AsymCrypt r19 = Alog.AsymCrypt.EC_SECP256K1;
    L62:
        r9.r = r19.getValue();
        r9.s = r14.getPubKey();
        r9.t = r14.isEnableNewCompression();
        Alog r20 = r9.a();
        e.a = r20;
        if (r20 != null) goto L65;
        long r110 = 0;
    L66:
        Alog.nativeSetDefaultInstance(r110);
        if (r5 == false) goto L73;
        if (r7 == true) goto L70;
        if (r4 == false) goto L73;
    L70:
        if (r8 == false) goto L72;
        sSingleThreadExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new g());
        goto L73
    L72:
        PthreadHandlerThreadV2 r21 = new PthreadHandlerThreadV2("Alog_main_delegate");
        sAsyncLogThread = r21;
        ThreadMethodProxy.start(r21);
        sAsyncHandler = new h(sAsyncLogThread.getLooper());
    L73:
        if (r6 == false) goto L87;
        Alog.a r22 = new Alog.a(r14.getContext());
        r22.b("main");
        r22.b = level2AlogCoreLevel(r14.getLevel());
        r22.c = sDebug;
        r22.e = r14.getLogDirPath();
        r22.f = r14.getPerSize() / 2;
        r22.g = r14.getMaxDirSize() / 3;
        r22.h = r14.getLogFileExpDays();
        r22.i = r14.getBufferDirPath();
        r22.j = 32768;
        r22.k = 98304;
        r22.m = r13.getValue();
        r22.n = r15.getValue();
        r22.o = r16.getValue();
        if (r14.isCompress() == false) goto L77;
        Alog.Compress r23 = Alog.Compress.ZSTD;
    L78:
        r22.p = r23.getValue();
        if (r14.isEncrypt() == false) goto L81;
        Alog.SymCrypt r24 = Alog.SymCrypt.TEA_16;
    L82:
        r22.q = r24.getValue();
        if (r14.isEncrypt() == false) goto L85;
        Alog.AsymCrypt r25 = Alog.AsymCrypt.EC_SECP256K1;
    L86:
        r22.r = r25.getValue();
        r22.s = r14.getPubKey();
        r22.t = r14.isEnableNewCompression();
        mainThreadRef = r22.a();
        goto L87
    L85:
        r25 = Alog.AsymCrypt.NONE;
        goto L86
    L81:
        r24 = Alog.SymCrypt.NONE;
        goto L82
    L77:
        r23 = Alog.Compress.NONE;
    L87:
        String r26 = r14.getBufferDirPath();
        String r111 = r14.getLogDirPath();
        if (sILogCacheCallback == null) goto L93;
        Queue r28 = sILogCacheCallback.a();
        if (r28 != null) goto L92;
    L94:
        if (r28 == null) goto L96;
    L97:
        Runnable r29 = new i(r28, r26, r111);
        ScheduledExecutorService r30 = sOuterExecutorService;
        if (r30 != null) goto L100;
        ThreadMethodProxy.start(new PthreadThreadV2(r29, "_ALOG_OPT_"));
    L101:
        r0 = true;
    L102:
        if (r0 == true) goto L107;
        ScheduledExecutorService r31 = sOuterExecutorService;
        if (r31 != null) goto L106;
        new PthreadTimer("_ALOG_OPT_").schedule(new j(r26, r111), 15000);
        goto L107
    L106:
        r31.schedule(new k(r26, r111), 15, TimeUnit.SECONDS);
    L107:
        sInitSuccess = true;
        return true;
    L100:
        r30.execute(r29);
        goto L101
    L96:
        if (getNativeFuncAddrCallbackList().size() <= 0) goto L102;
    L92:
        if (r28.size() != 0) goto L94;
    L93:
        r28 = null;
        goto L94
    L65:
        r110 = r20.h;
        goto L66
    L61:
        r19 = Alog.AsymCrypt.NONE;
        goto L62
    L57:
        r18 = Alog.SymCrypt.NONE;
        goto L58
    L53:
        r17 = Alog.Compress.NONE;
        goto L54
    L49:
        r12 = 65536;
        goto L50
    L45:
        r11 = 32768;
        goto L46
    L41:
        r10 = r14.getMaxDirSize();
        goto L42
    L31:
        if (r14.isMainThreadSpeedUp() == false) goto L34;
        if (r4 == false) goto L34;
        r6 = true;
        goto L35
    L19:
        if (r3.contains(":") == true) goto L27;
        if (r3.equals(r2.getPackageName()) == false) goto L25;
    L26:
        r4 = true;
        goto L28
    L25:
        if (r3.equals(r2.getApplicationInfo().processName) == false) goto L27;
    L112:
        return false;
    }

    public static synchronized void removeLogFileDeleteListener(c r2) {
        monitor-enter(ALog.class);
        if (r2 != null) goto L16;
    L14:
        monitor-exit(ALog.class);
        return;
    L16:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (sLogFileDeleteListeners == null) goto L14;
        sLogFileDeleteListeners.remove(r2);     // Catch: Throwable -> L11
        monitor-exit(ALog.class);
    }

    public static void removeMessageInterceptor(com.bytedance.android.alog.d r1) {
        if (r1 != null) goto L4;
        int r2 = Alog.i;
        return;
    L4:
        if (Alog.o == null) goto L10;
        ((CopyOnWriteArrayList) Alog.o).remove(r1);
        return;
    }

    public static void setBlockTagSet(Set<String> r0) {
        mBlockTagSet = Collections.unmodifiableSet(r0);
    }

    public static void setDebug(boolean r1) {
        sDebug = r1;
        boolean r2 = sDebug;
        Alog r0 = e.a;
        if (r0 == null) goto L5;
        r0.k(r2);
    L5:
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L9;
        r3.k(sDebug);
        return;
    }

    public static void setILogCacheCallback(a r0) {
        sILogCacheCallback = r0;
    }

    public static void setOuterExecutorService(ScheduledExecutorService r0) {
        sOuterExecutorService = r0;
    }

    public static void timedSyncFlush(int r2) {
        ExecutorService r0 = sSingleThreadExecutor;
        if (r0 == null) goto L5;
        r0.execute(new b());
    L5:
        Handler r1 = sAsyncHandler;
        if (r1 == null) goto L8;
        r1.sendEmptyMessage(2);
    L8:
        Alog r3 = e.a;
        if (r3 == null) goto L11;
        r3.m(r2);
    L11:
        Alog r4 = mainThreadRef;
        if (r4 == null) goto L14;
        r4.m(r2);
    L14:
        Iterator<WeakReference<Alog>> r5 = sStandaloneInstances.iterator();
    L16:
        if (r5.hasNext() == false) goto L20;
        Alog r6 = r5.next().get();
        if (r6 == null) goto L16;
        r6.m(r2);
        goto L16
    }

    private static void writeCachedItems(Queue<nra.d> r3) {
        Iterator<nra.d> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        nra.d r0 = r4.next();
        if (checkPrioAndTag(r0.a, r0.b) == false) goto L4;
        handleItemMsg(r0);
        e.c(level2AlogCoreLevel(r0.a), r0.b, r0.c);
        goto L4
    }

    public static /* synthetic */ void access$300(String r0, String r1) {
        removeLegacyFiles(r0, r1);
    }

    public static boolean checkPrioAndTag(int r2, String r3) {
        if (r2 >= prio) goto L5;
        return false;
    L5:
        Set<String> r4 = mBlockTagSet;
        if (r4 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return true;
    L10:
        if (r4.contains(r3) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static p createInstance(String r7, ALogConfig r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        if (sInitSuccess == false) goto L54;
    L25:
        Alog.a r1 = new Alog.a(r8.getContext());
        r1.b(r7);
        r1.b = level2AlogCoreLevel(r8.getLevel());
        r1.c = sDebug;
        ALogConfig r2 = sConfig;
        if (r2 == null) goto L28;
        String r3 = r2.getLogDirPath();
    L29:
        r1.e = r3;
        r1.f = r8.getPerSize();
        r1.g = r8.getMaxDirSize();
        r1.h = r8.getLogFileExpDays();
        ALogConfig r4 = sConfig;
        if (r4 == null) goto L32;
        String r5 = r4.getBufferDirPath();
    L33:
        r1.i = r5;
        r1.j = 65536;
        r1.k = 196608;
        r1.m = Alog.Mode.SAFE.getValue();
        r1.n = Alog.TimeFormat.RAW.getValue();
        r1.o = Alog.PrefixFormat.LEGACY.getValue();
        if (r8.isCompress() == false) goto L36;
        Alog.Compress r6 = Alog.Compress.ZSTD;
    L37:
        r1.p = r6.getValue();
        if (r8.isEncrypt() == false) goto L40;
        Alog.SymCrypt r9 = Alog.SymCrypt.TEA_16;
    L41:
        r1.q = r9.getValue();
        if (r8.isEncrypt() == false) goto L44;
        Alog.AsymCrypt r10 = Alog.AsymCrypt.EC_SECP256K1;
    L45:
        r1.r = r10.getValue();
        r1.s = r8.getPubKey();
        r1.t = r8.isEnableNewCompression();
        Alog r11 = r1.a();
        if (r11 != null) goto L48;
        return null;
    L48:
        sStandaloneInstances.add(new WeakReference(r11));
        return new p(r11, r7);
    L44:
        r10 = Alog.AsymCrypt.NONE;
        goto L45
    L40:
        r9 = Alog.SymCrypt.NONE;
        goto L41
    L36:
        r6 = Alog.Compress.NONE;
        goto L37
    L32:
        r5 = r8.getBufferDirPath();
        goto L33
    L28:
        r3 = r8.getLogDirPath();
        goto L29
    L54:
        monitor-enter(Alog.class);     // Catch: Throwable -> L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L10:
        if (Alog.q == false) goto L52;
        monitor-exit(Alog.class);     // Catch: Throwable -> L24
        goto L25
    L52:
        com.bytedance.librarian.a.e("alog", true, sConfig.getContext());     // Catch: Throwable -> L17
    L18:
        Alog.q = true;     // Catch: Throwable -> L21
        monitor-exit(Alog.class);     // Catch: Throwable -> L24
        goto L25
    L17:
        Intrinsics.checkNotNullParameter("alog", "libName");     // Catch: Throwable -> L21
        FLogger r12 = FLogger.a;     // Catch: Throwable -> L21
        r12.i("Librarian_loadLib", "loadLibrary start libName -> alog");     // Catch: Throwable -> L21
        com.bytedance.librarian.a.c("alog");     // Catch: Throwable -> L21
        r12.i("Librarian_loadLib", "loadLibrary success by librarian -> alog");     // Catch: Throwable -> L21
    L24:
        return null;
    }

    public static void d(String r3, String r4) {
        if (checkPrioAndTag(3, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = nra.e.c();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.n(1, r3, r4);
        return;
    L35:
        e.d(1, r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(3, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(3, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(3, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(3, r3, r4);
        return;
    }

    public static void e(String r8, Throwable r9) {
        if (checkPrioAndTag(6, r8) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r10 = wra.c.a(r9);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(4, r8, r10);
        return;
    L35:
        e.d(4, r8, r10);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r8, null, r9, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r8, null, r9, null, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r8, null, r9, null, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r8, null, r9, null, null);
        return;
    }

    public static List<String> getALogFiles(long r8, long r10) {
        ArrayList r0 = new ArrayList();
        long r9 = r8 * 1000;
        long r6 = r10 * 1000;
        Alog r11 = e.a;     // Catch: Exception -> L12
        int r12 = 0;
        if (r11 == null) goto L6;
        File[] r13 = com.bytedance.android.alog.b.a(r11.b, null, null, r9, r6);     // Catch: Exception -> L12
    L7:
        int r14 = r13.length;     // Catch: Exception -> L12
    L8:
        if (r12 >= r14) goto L11;
        r0.add(r13[r12].getAbsolutePath());     // Catch: Exception -> L12
        r12 = r12 + 1;
        goto L8
    L6:
        r13 = new File[0];     // Catch: Exception -> L12
    L11:
        return r0;
    }

    public static void i(String r3, String r4) {
        if (checkPrioAndTag(4, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = nra.e.c();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.n(2, r3, r4);
        return;
    L35:
        e.d(2, r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(4, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(4, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(4, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(4, r3, r4);
        return;
    }

    private static void removeLegacyFiles(String r4, String r5) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r4);
        int r1 = 0;
        if (r0.exists() == false) goto L9;
        File[] r6 = r0.listFiles(new l());
        if (r6 == null) goto L9;
        int r2 = r6.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r6[r3].delete();
        r3 = r3 + 1;
    L9:
        PolarisFileWrapper r7 = new PolarisFileWrapper(r5);
        if (r7.exists() == false) goto L16;
        File[] r8 = r7.listFiles(new m());
        if (r8 == null) goto L19;
        int r9 = r8.length;
    L14:
        if (r1 >= r9) goto L20;
        r8[r1].delete();
        r1 = r1 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static void v(String r3, String r4) {
        if (checkPrioAndTag(2, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = nra.e.c();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.n(0, r3, r4);
        return;
    L35:
        e.d(0, r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(2, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(2, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(2, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(2, r3, r4);
        return;
    }

    public static void w(String r8, Throwable r9) {
        if (checkPrioAndTag(5, r8) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r10 = wra.c.a(r9);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(3, r8, r10);
        return;
    L35:
        e.d(3, r8, r10);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r8, null, r9, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r8, null, r9, null, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r8, null, r9, null, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r8, null, r9, null, null);
        return;
    }

    public static p createInstance(String r1, Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return createInstance(r1, new ALogConfig.b(r2).a());
    }

    public static void e(String r3, String r4) {
        if (checkPrioAndTag(6, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = nra.e.c();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.n(4, r3, r4);
        return;
    L35:
        e.d(4, r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r3, r4);
        return;
    }

    public static void w(String r3, String r4) {
        if (checkPrioAndTag(5, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = nra.e.c();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.n(3, r3, r4);
        return;
    L35:
        e.d(3, r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r3, r4);
        return;
    }

    public static void bundle(int r8, String r9, Bundle r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.b(FormatUtils.TYPE.BUNDLE, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(r11, r9, r12);
        return;
    L35:
        e.c(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.BUNDLE, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.BUNDLE, r10);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.BUNDLE, r10);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.BUNDLE, r10);
        return;
    }

    public static void e(String r8, String r9, Throwable r10) {
        if (checkPrioAndTag(6, r8) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r11 = r9 + "\n" + wra.c.a(r10);
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L35;
        if (r2 == false) goto L35;
        r12.n(4, r8, r11);
        return;
    L35:
        e.d(4, r8, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r8, r9, r10, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r8, r9, r10, null, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r8, r9, r10, null, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r8, r9, r10, null, null);
        return;
    }

    public static void header(int r8, String r9, String r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.c(FormatUtils.TYPE.BORDER, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(r11, r9, r12);
        return;
    L35:
        e.c(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, r10, null, FormatUtils.TYPE.BORDER, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, r10, null, FormatUtils.TYPE.BORDER, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, r10, null, FormatUtils.TYPE.BORDER, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, r10, null, FormatUtils.TYPE.BORDER, null);
        return;
    }

    public static void intent(int r8, String r9, Intent r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.a(FormatUtils.TYPE.INTENT, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(r11, r9, r12);
        return;
    L35:
        e.c(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.INTENT, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.INTENT, r10);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.INTENT, r10);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.INTENT, r10);
        return;
    }

    public static void json(int r8, String r9, String r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.c(FormatUtils.TYPE.JSON, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(r11, r9, r12);
        return;
    L35:
        e.c(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, r10, null, FormatUtils.TYPE.JSON, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, r10, null, FormatUtils.TYPE.JSON, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, r10, null, FormatUtils.TYPE.JSON, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, r10, null, FormatUtils.TYPE.JSON, null);
        return;
    }

    public static void notifyLogFileDelete(String r2, long r3, int r5) {
        if (sLogFileDeleteListeners != null) goto L5;
        return;
    L5:
        Iterator<c> r0 = sLogFileDeleteListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().a(r2, r3, r5);
        goto L7
    }

    private static void postAsyncLog(int r6, String r7, String r8) {
        postAsyncLog(r6, r7, r8, null, null, null);
    }

    private static void postAsyncLogByThreadPool(int r6, String r7, String r8) {
        postAsyncLogByThreadPool(r6, r7, r8, null, null, null);
    }

    public static void removeObsoleteInstance(String r10, Context r11, boolean r12) {
        String r0 = nra.e.b();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.contains(":") == false) goto L8;
        return;
    L8:
        if (r12 == true) goto L11;
        r0 = r0.concat("-");
    L11:
        ALogConfig r13 = sConfig;
        if (r13 == null) goto L14;
        String r14 = r13.getLogDirPath();
        String r15 = sConfig.getBufferDirPath();
    L18:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r14);
        if (r1.exists() == true) goto L21;
        return;
    L21:
        if (r1.isDirectory() == false) goto L60;
        String r16 = "__" + r10 + ".alog.hot";
        File[] r2 = r1.listFiles();
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L24:
        if (r5 >= r3) goto L33;
        File r6 = r2[r5];
        String r7 = r6.getName();
        if (r7 == null) goto L32;
        if (r7.endsWith(r16) == false) goto L32;
        if (r7.contains(r0) == false) goto L32;
        r6.delete();
    L32:
        r5 = r5 + 1;
        goto L24
    L33:
        PolarisFileWrapper r17 = new PolarisFileWrapper(r15);
        if (r17.exists() == true) goto L36;
        return;
    L36:
        if (r17.isDirectory() == false) goto L61;
        String r18 = "__" + r10;
        File[] r19 = r17.listFiles();
        int r110 = r19.length;
    L39:
        if (r4 >= r110) goto L62;
        File r8 = r19[r4];
        String r9 = r8.getName();
        if (r9 == null) goto L47;
        if (r9.contains(r18) == false) goto L47;
        if (r9.contains(r0) == false) goto L47;
        r8.delete();
    L47:
        r4 = r4 + 1;
        goto L39
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L14:
        PolarisFileWrapper r111 = new PolarisFileWrapper(r11.getFilesDir(), "logs");
        if (r111.exists() == true) goto L17;
        r111.mkdir();
    L17:
        String r112 = r111.getAbsolutePath();
        r15 = wra.a.a(r11);
        r14 = r112;
        goto L18
    }

    public static void stacktrace(int r8, String r9, StackTraceElement[] r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.f(FormatUtils.TYPE.STACKTRACE, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(r11, r9, r12);
        return;
    L35:
        e.c(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.STACKTRACE, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.STACKTRACE, r10);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.STACKTRACE, r10);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.STACKTRACE, r10);
        return;
    }

    public static void statcktrace(int r0, String r1, StackTraceElement[] r2) {
        stacktrace(r0, r1, r2);
    }

    public static void thread(int r8, String r9, Thread r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.d(FormatUtils.TYPE.THREAD, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(r11, r9, r12);
        return;
    L35:
        e.c(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.THREAD, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.THREAD, r10);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.THREAD, r10);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.THREAD, r10);
        return;
    }

    public static void throwable(int r8, String r9, Throwable r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.e(FormatUtils.TYPE.THROWABLE, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.n(r11, r9, r12);
        return;
    L35:
        e.c(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.THROWABLE, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, r10, FormatUtils.TYPE.THROWABLE, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, r10, FormatUtils.TYPE.THROWABLE, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, r10, FormatUtils.TYPE.THROWABLE, null);
        return;
    }

    public static void w(String r8, String r9, Throwable r10) {
        if (checkPrioAndTag(5, r8) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = nra.e.c();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r11 = r9 + "\n" + wra.c.a(r10);
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L35;
        if (r2 == false) goto L35;
        r12.n(3, r8, r11);
        return;
    L35:
        e.d(3, r8, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r8, r9, r10, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r8, r9, r10, null, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r8, r9, r10, null, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r8, r9, r10, null, null);
        return;
    }

    public static List<String> getALogFiles(String r10, String r11, long r12, long r14) {
        ArrayList r0 = new ArrayList();
        long r6 = r12 * 1000;
        long r8 = r14 * 1000;
        Alog r13 = e.a;     // Catch: Exception -> L12
        int r15 = 0;
        if (r13 == null) goto L6;
        File[] r16 = com.bytedance.android.alog.b.a(r13.b, r10, r11, r6, r8);     // Catch: Exception -> L12
    L7:
        int r17 = r16.length;     // Catch: Exception -> L12
    L8:
        if (r15 >= r17) goto L11;
        r0.add(r16[r15].getAbsolutePath());     // Catch: Exception -> L12
        r15 = r15 + 1;
        goto L8
    L6:
        r16 = new File[0];     // Catch: Exception -> L12
    L11:
        return r0;
    }

    public static void println(int r2, String r3, Object r4, FormatUtils.TYPE r5) {
        if (checkPrioAndTag(r2, r3) == false) goto L49;
        int r0 = level2AlogCoreLevel(r2);
        switch(e.a[r5.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L6:
        String r6 = XmlPullParser.NO_NAMESPACE;
    L16:
        ALogConfig r7 = sConfig;
        if (r7 != null) goto L19;
    L24:
        ALogConfig r8 = sConfig;
        if (r8 != null) goto L27;
    L32:
        boolean r9 = nra.e.c();
        if (r9 == true) goto L35;
    L38:
        if (r9 == true) goto L40;
    L43:
        Alog r10 = mainThreadRef;
        if (r10 == null) goto L47;
        if (r9 == false) goto L47;
        r10.n(r0, r3, r6);
        return;
    L47:
        e.c(r0, r3, r6);
        return;
    L40:
        if (sAsyncHandler == null) goto L43;
        postAsyncLog(r2, r3, r6);
        return;
    L35:
        if (sSingleThreadExecutor == null) goto L38;
        postAsyncLogByThreadPool(r2, r3, r6);
        return;
    L27:
        if (r8.enableOffloadInAllThread() == false) goto L32;
        if (sAsyncHandler == null) goto L32;
        postAsyncLog(r2, r3, r6);
        return;
    L19:
        if (r7.enableOffloadInAllThread() == false) goto L24;
        if (sSingleThreadExecutor == null) goto L24;
        postAsyncLogByThreadPool(r2, r3, r6);
        return;
    L7:
        r6 = FormatUtils.f(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) r4);
        goto L16
    L8:
        r6 = FormatUtils.d(FormatUtils.TYPE.THREAD, (Thread) r4);
        goto L16
    L9:
        r6 = FormatUtils.e(FormatUtils.TYPE.THROWABLE, (Throwable) r4);
        goto L16
    L10:
        r6 = FormatUtils.a(FormatUtils.TYPE.INTENT, (Intent) r4);
        goto L16
    L11:
        r6 = FormatUtils.b(FormatUtils.TYPE.BUNDLE, (Bundle) r4);
        goto L16
    L12:
        r6 = FormatUtils.c(FormatUtils.TYPE.JSON, (String) r4);
        goto L16
    L13:
        r6 = FormatUtils.c(FormatUtils.TYPE.BORDER, (String) r4);
        goto L16
    L14:
        r6 = wra.c.a((Throwable) r4);
        goto L16
    L15:
        r6 = (String) r4;
        goto L16
    }

    public static void writeAsyncLog(int r8, String r9, String r10, long r11, long r13) {
        int r1 = level2AlogCoreLevel(r8);
        Alog r0 = e.a;
        if (r0 == null) goto L6;
        r0.o(r1, r9, r10, r11, r13);
        return;
    }

    private static void postAsyncLog(int r3, String r4, String r5, Throwable r6, FormatUtils.TYPE r7, Object r8) {
        Object r0 = o.j;
        monitor-enter(r0);
        o r1 = o.k;     // Catch: Throwable -> L13
        if (r1 == null) goto L9;
        o.k = r1.i;     // Catch: Throwable -> L13
        r1.i = null;     // Catch: Throwable -> L13
        o.l--;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    L11:
        r1.a = r3;
        r1.b = r4;
        r1.c = r5;
        r1.d = r6;
        r1.e = r7;
        r1.f = r8;
        r1.g = getThreadId();
        r1.h = System.currentTimeMillis();
        Message r9 = Message.obtain();
        r9.what = 1;
        r9.obj = r1;
        sAsyncHandler.sendMessage(r9);
        return;
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L13
        r1 = new o();
    L13:
        th = move-exception;
        throw th;
    }

    private static void postAsyncLogByThreadPool(int r13, String r14, String r15, Throwable r16, FormatUtils.TYPE r17, Object r18) {
        long r7 = getThreadId();
        long r9 = System.currentTimeMillis();
        sSingleThreadExecutor.execute(new d(r13, r17, r16, r15, r18, r14, r7, r9));
    }
}
