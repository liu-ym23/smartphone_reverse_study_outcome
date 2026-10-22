package com.ss.android.agilelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import com.bytedance.android.alog.Alog;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.agilelogger.utils.FormatUtils;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import com.ss.bytertc.engine.utils.LogUtil;
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

/* JADX INFO: loaded from: classes.dex */
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
    private static volatile nra.a sILogCacheCallback;
    private static volatile List<nra.b> sINativeFuncAddrCallbackList;
    private static Object sInitLock;
    private static volatile boolean sInitSuccess;
    private static boolean sInitialized;
    private static volatile List<com.bytedance.android.alog.c> sLogFileDeleteListeners;
    private static ScheduledExecutorService sOuterExecutorService;
    private static ExecutorService sSingleThreadExecutor;
    private static ArrayList<WeakReference<Alog>> sStandaloneInstances;
    private static final ThreadLocal<Long> sThreadId = null;

    /* JADX INFO: loaded from: classes34.dex */
    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.alog.e.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.alog.e.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.alog.e.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f406395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FormatUtils.TYPE f406396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Throwable f406397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f406398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f406399e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f406400f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f406401g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ long f406402h;

        public final void a() {
            int r100 = ALog.access$400(this.f406395a);
            FormatUtils.TYPE r101 = this.f406396b;
            if (r101 != null) goto L12;
            Throwable r102 = this.f406397c;
            if (r102 != null) goto L8;
        L33:
            String r103 = this.f406400f;
            String r104 = this.f406398d;
            long r105 = this.f406401g;
            long r106 = this.f406402h;
            Alog r107 = com.bytedance.android.alog.e.f38378a;
            if (r107 == null) goto L37;
            r107.o(r100, r103, r104, r105, r106);
            return;
        L37:
            return;
        L8:
            if (this.f406398d == null) goto L11;
        L11:
            wra.c.a(r102);
            goto L33
        L12:
            FormatUtils.TYPE r108 = FormatUtils.TYPE.BORDER;
            if (r101 != r108) goto L15;
            FormatUtils.c(r108, this.f406398d);
            goto L33
        L15:
            FormatUtils.TYPE r109 = FormatUtils.TYPE.JSON;
            if (r101 != r109) goto L18;
            FormatUtils.c(r109, this.f406398d);
            goto L33
        L18:
            FormatUtils.TYPE r110 = FormatUtils.TYPE.BUNDLE;
            if (r101 != r110) goto L21;
            FormatUtils.b(r110, (Bundle) this.f406399e);
            goto L33
        L21:
            FormatUtils.TYPE r111 = FormatUtils.TYPE.INTENT;
            if (r101 != r111) goto L24;
            FormatUtils.a(r111, (Intent) this.f406399e);
            goto L33
        L24:
            FormatUtils.TYPE r112 = FormatUtils.TYPE.THROWABLE;
            if (r101 != r112) goto L27;
            FormatUtils.e(r112, (Throwable) this.f406399e);
            goto L33
        L27:
            FormatUtils.TYPE r113 = FormatUtils.TYPE.THREAD;
            if (r101 != r113) goto L30;
            FormatUtils.d(r113, (Thread) this.f406399e);
            goto L33
        L30:
            FormatUtils.TYPE r114 = FormatUtils.TYPE.STACKTRACE;
            if (r101 != r114) goto L33;
            FormatUtils.f(r114, (StackTraceElement[]) this.f406399e);
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

        public d(int r100, FormatUtils.TYPE r101, Throwable r102, String r103, Object r104, String r105, long r106, long r107) {
            this.f406395a = r100;
            this.f406396b = r101;
            this.f406397c = r102;
            this.f406398d = r103;
            this.f406399e = r104;
            this.f406400f = r105;
            this.f406401g = r106;
            this.f406402h = r107;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f406403a = null;

        static {
            int[] r100 = new int[FormatUtils.TYPE.values().length];
            f406403a = r100;
            r100[FormatUtils.TYPE.MSG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f406403a[FormatUtils.TYPE.STACKTRACE_STR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f406403a[FormatUtils.TYPE.BORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f406403a[FormatUtils.TYPE.JSON.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f406403a[FormatUtils.TYPE.BUNDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f406403a[FormatUtils.TYPE.INTENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f406403a[FormatUtils.TYPE.THROWABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f406403a[FormatUtils.TYPE.THREAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f406403a[FormatUtils.TYPE.STACKTRACE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
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
        public final Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(r100, "logger/ALog$2");
            ThreadMethodProxy.setName(r101, "Alog_newthreadpoolimpl");
            return r101;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class h extends Handler {
        public h(Looper r100) {
            super(r100);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            int r101 = r100.what;
            if (r101 != 1) goto L5;
            Object r102 = r100.obj;
            if (r102 != null) goto L11;
            return;
        L11:
            if ((r102 instanceof o) == false) goto L16;
            ALog.access$000((o) r102);
            return;
        L16:
            return;
        L5:
            if (r101 != 2) goto L17;
            com.bytedance.android.alog.e.a();
            return;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Queue f406404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f406405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f406406c;

        public final void a() {
            Queue r100 = this.f406404a;
            if (r100 == null) goto L5;
            ALog.access$100(r100);
            ALog.access$200().b();
        L5:
            Iterator<nra.b> r101 = ALog.getNativeFuncAddrCallbackList().iterator();
        L7:
            if (r101.hasNext() == false) goto L20;
            nra.b r102 = r101.next();
            if (r102 == null) goto L7;
            Alog r103 = com.bytedance.android.alog.e.f38378a;
            if (r103 == null) goto L13;
            long r104 = r103.e();
        L14:
            r102.a(r104);
            goto L7
        L13:
            r104 = 0;
            goto L14
        L20:
            Thread.sleep(15000);     // Catch: Exception -> L19
        L17:
            ALog.access$300(this.f406405b, this.f406406c);
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

        public i(Queue r100, String r101, String r102) {
            this.f406404a = r100;
            this.f406405b = r101;
            this.f406406c = r102;
        }
    }

    public static class j extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f406407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f406408b;

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            ALog.access$300(this.f406407a, this.f406408b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(String r100, String r101) {
            this.f406407a = r100;
            this.f406408b = r101;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f406409a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f406410b;

        @Override // java.lang.Runnable
        public final void run() {
            ALog.access$300(this.f406409a, this.f406410b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public k(String r100, String r101) {
            this.f406409a = r100;
            this.f406410b = r101;
        }
    }

    public static class l implements FilenameFilter {
        public l() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            return r101.startsWith(".logCache_");
        }
    }

    public static class m implements FilenameFilter {
        public m() {
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File r100, String r101) {
            if (r101.endsWith(".hoting") == false) goto L6;
            return true;
        L6:
            if (r101.endsWith(".hot") == true) goto L8;
            return false;
        L8:
            if (r101.endsWith(".alog.hot") == true) goto L12;
            return true;
        L12:
            return false;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.bytedance.android.alog.e.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: loaded from: classes34.dex */
    public static class o {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final Object f406411j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static o f406412k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static int f406413l;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f406414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f406415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f406416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f406417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public FormatUtils.TYPE f406418e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f406419f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f406420g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f406421h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public o f406422i;

        static {
            f406411j = new Object();
            f406413l = 0;
        }

        public o() {
            this.f406418e = null;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static class p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static ExecutorService f406423b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Alog f406424a;

        public class a implements ThreadFactory {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f406425a;

            public a(String r100) {
                this.f406425a = r100;
            }

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable r100) {
                PthreadThreadV2 r101 = new PthreadThreadV2(r100, "ALog$LogInstance$1");
                ThreadMethodProxy.setName(r101, "Alog_instance-" + this.f406425a);
                return r101;
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f406426a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f406427b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f406428c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f406429d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ p f406430e;

            @Override // java.lang.Runnable
            public final void run() {
                int r100 = ALog.access$400(4);     // Catch: Throwable -> L5
                this.f406430e.f406424a.o(r100, this.f406426a, this.f406427b, this.f406428c, this.f406429d);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L9;
                return;
            L9:
                throw th;
            }

            public b(p r100, String r101, String r102, long r103, long r104) {
                this.f406430e = r100;
                this.f406426a = r101;
                this.f406427b = r102;
                this.f406428c = r103;
                this.f406429d = r104;
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f406431a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f406432b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f406433c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f406434d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ p f406435e;

            @Override // java.lang.Runnable
            public final void run() {
                int r100 = ALog.access$400(5);     // Catch: Throwable -> L5
                this.f406435e.f406424a.o(r100, this.f406431a, this.f406432b, this.f406433c, this.f406434d);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L9;
                return;
            L9:
                throw th;
            }

            public c(p r100, String r101, String r102, long r103, long r104) {
                this.f406435e = r100;
                this.f406431a = r101;
                this.f406432b = r102;
                this.f406433c = r103;
                this.f406434d = r104;
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f406436a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f406437b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f406438c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f406439d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ p f406440e;

            @Override // java.lang.Runnable
            public final void run() {
                int r100 = ALog.access$400(6);     // Catch: Throwable -> L5
                this.f406440e.f406424a.o(r100, this.f406436a, this.f406437b, this.f406438c, this.f406439d);     // Catch: Throwable -> L5
                return;
            L5:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L9;
                return;
            L9:
                throw th;
            }

            public d(p r100, String r101, String r102, long r103, long r104) {
                this.f406440e = r100;
                this.f406436a = r101;
                this.f406437b = r102;
                this.f406438c = r103;
                this.f406439d = r104;
            }
        }

        public p(Alog r100, String r101) {
            this.f406424a = r100;
            f406423b = PThreadExecutorsUtils.newSingleThreadExecutor(new a(r101));
        }

        public final void a(String r110, String r111) {
            long r100 = ALog.access$500();
            long r101 = System.currentTimeMillis();
            if (ALog.checkPrioAndTag(6, r110) == false) goto L6;
            f406423b.submit(new d(this, r110, r111, r100, r101));
            return;
        }

        public final void b(String r110, String r111) {
            long r100 = ALog.access$500();
            long r101 = System.currentTimeMillis();
            if (ALog.checkPrioAndTag(4, r110) == false) goto L6;
            f406423b.submit(new b(this, r110, r111, r100, r101));
            return;
        }

        public final void c(String r110, String r111) {
            long r100 = ALog.access$500();
            long r101 = System.currentTimeMillis();
            if (ALog.checkPrioAndTag(5, r110) == false) goto L6;
            f406423b.submit(new c(this, r110, r111, r100, r101));
            return;
        }
    }

    public ALog() {
    }

    public static void forceLogSharding() {
    }

    private static int level2AlogCoreLevel(int r100) {
        return r100 - 2;
    }

    public static void setPrintStackTrace(boolean r100) {
    }

    public static void setsPackageClassName(String r100) {
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
        ExecutorService r100 = sSingleThreadExecutor;
        if (r100 == null) goto L5;
        r100.execute(new n());
    L8:
        com.bytedance.android.alog.e.a();
        Alog r101 = mainThreadRef;
        if (r101 == null) goto L11;
        r101.a();
    L11:
        Iterator<WeakReference<Alog>> r102 = sStandaloneInstances.iterator();
    L13:
        if (r102.hasNext() == false) goto L20;
        WeakReference<Alog> r103 = r102.next();
        if (r103 == null) goto L13;
        Alog r104 = r103.get();
        if (r104 == null) goto L13;
        r104.a();
        goto L13
    L20:
        return;
    L5:
        Handler r105 = sAsyncHandler;
        if (r105 == null) goto L8;
        r105.sendEmptyMessage(2);
        goto L8
    }

    public static void destroy() {
        Alog.nativeSetDefaultInstance(0);
        com.bytedance.android.alog.e.f38378a.b();
        com.bytedance.android.alog.e.f38378a = null;
        Alog r100 = mainThreadRef;
        if (r100 == null) goto L6;
        r100.b();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r101 = sSingleThreadExecutor;
        if (r101 == null) goto L12;
        r101.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    public static void flush() {
        ExecutorService r100 = sSingleThreadExecutor;
        if (r100 == null) goto L5;
        r100.execute(new c());
    L5:
        Handler r101 = sAsyncHandler;
        if (r101 == null) goto L8;
        r101.sendEmptyMessage(2);
    L8:
        com.bytedance.android.alog.e.a();
        Alog r102 = mainThreadRef;
        if (r102 == null) goto L12;
        r102.a();
        return;
    }

    public static long getALogSimpleInitFuncAddr() {
        Alog r100 = com.bytedance.android.alog.e.f38378a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f();
    }

    public static long getALogSimpleWriteAsyncFuncAddr() {
        Alog r100 = com.bytedance.android.alog.e.f38378a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.g();
    }

    public static long getALogSimpleWriteFuncAddr() {
        Alog r100 = com.bytedance.android.alog.e.f38378a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.h();
    }

    public static long getALogWriteFuncAddr() {
        Alog r100 = com.bytedance.android.alog.e.f38378a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.e();
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        Alog r100 = com.bytedance.android.alog.e.f38378a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.c();
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        Alog r100 = com.bytedance.android.alog.e.f38378a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.d();
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        if (com.bytedance.android.alog.e.f38378a == null) goto L15;
        HashMap<String, String> r100 = new HashMap();
        r100.put("start", Long.toString(com.bytedance.android.alog.b.f38370a));
        r100.put("end", Long.toString(com.bytedance.android.alog.b.f38371b));
        r100.put("reason", com.bytedance.android.alog.b.f38373d);
        if (com.bytedance.android.alog.b.f38372c == null) goto L14;
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = com.bytedance.android.alog.b.f38372c.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        if (r103.endsWith(".alog.hot") == false) goto L12;
        r103 = r103.substring(0, r103.length() - 9);
    L12:
        r101.append(r103);
        r101.append(com.alipay.sdk.m.u.i.f25853b);
        goto L8
    L13:
        r100.put("file", r101.toString());
    L14:
        com.bytedance.android.alog.b.f38373d = null;
        com.bytedance.android.alog.b.f38372c = null;
        return r100;
    L15:
        HashMap<String, String> r104 = new HashMap();
        r104.put("reason", "Log.instance does not exist");
        return r104;
    }

    private static long getThreadId() {
        return sThreadId.get().longValue();
    }

    public static void release() {
        Alog.nativeSetDefaultInstance(0);
        com.bytedance.android.alog.e.f38378a.b();
        com.bytedance.android.alog.e.f38378a = null;
        Alog r100 = mainThreadRef;
        if (r100 == null) goto L6;
        r100.b();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r101 = sSingleThreadExecutor;
        if (r101 == null) goto L12;
        r101.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    public static void syncFlush() {
        ExecutorService r100 = sSingleThreadExecutor;
        if (r100 == null) goto L5;
        r100.execute(new a());
    L5:
        Handler r101 = sAsyncHandler;
        if (r101 == null) goto L8;
        r101.sendEmptyMessage(2);
    L8:
        Alog r102 = com.bytedance.android.alog.e.f38378a;
        if (r102 == null) goto L11;
        r102.l();
    L11:
        Alog r103 = mainThreadRef;
        if (r103 == null) goto L14;
        r103.l();
    L14:
        Iterator<WeakReference<Alog>> r104 = sStandaloneInstances.iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        Alog r105 = r104.next().get();
        if (r105 == null) goto L16;
        r105.l();
        goto L16
    }

    public static /* synthetic */ long access$500() {
        return getThreadId();
    }

    public static String getStatus() {
        return com.bytedance.android.alog.e.b();
    L4:
        return "getStatus exception";
    }

    public static /* synthetic */ nra.a access$200() {
        return sILogCacheCallback;
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static List<nra.b> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static /* synthetic */ void access$000(o r100) {
        handleAsyncLog(r100);
    }

    public static /* synthetic */ void access$100(Queue r100) {
        writeCachedItems(r100);
    }

    public static /* synthetic */ int access$400(int r100) {
        return level2AlogCoreLevel(r100);
    }

    public static synchronized void addLogFileDeleteListener(com.bytedance.android.alog.c r100) {
        monitor-enter(ALog.class);
        if (r100 != null) goto L18;
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
        if (sLogFileDeleteListeners.contains(r100) == true) goto L13;
        sLogFileDeleteListeners.add(r100);     // Catch: Throwable -> L15
    L13:
        monitor-exit(ALog.class);
    }

    public static void addMessageInterceptor(com.bytedance.android.alog.d r100) {
        if (r100 != null) goto L5;
        int r101 = Alog.f38325i;
        return;
    L5:
        if (Alog.f38331o != null) goto L8;
        Alog.f38331o = new CopyOnWriteArrayList();
    L8:
        if (((CopyOnWriteArrayList) Alog.f38331o).contains(r100) == true) goto L12;
        ((CopyOnWriteArrayList) Alog.f38331o).add(r100);
        return;
    }

    public static void addNativeFuncAddrCallback(nra.b r100) {
        sINativeFuncAddrCallbackList.add(r100);
    }

    public static void changeLevel(int r100) {
        prio = r100;
        int r101 = level2AlogCoreLevel(r100);
        Alog r102 = com.bytedance.android.alog.e.f38378a;
        if (r102 == null) goto L5;
        r102.j(r101);
    L5:
        Alog r103 = mainThreadRef;
        if (r103 == null) goto L9;
        r103.j(level2AlogCoreLevel(r100));
        return;
    }

    private static void handleAsyncLog(o r100) {
        int r101 = level2AlogCoreLevel(r100.f406414a);
        String r102 = "";
        FormatUtils.TYPE r103 = r100.f406418e;
        if (r103 == null) goto L5;
        FormatUtils.TYPE r104 = FormatUtils.TYPE.BORDER;
        if (r103 != r104) goto L16;
        r102 = FormatUtils.c(r104, r100.f406416c);
    L15:
        String r105 = r102;
        String r106 = r100.f406415b;
        long r107 = r100.f406420g;
        long r108 = r100.f406421h;
        Alog r109 = com.bytedance.android.alog.e.f38378a;
        if (r109 == null) goto L37;
        r109.o(r101, r106, r105, r107, r108);
    L37:
        r100.f406415b = null;
        r100.f406416c = null;
        r100.f406417d = null;
        r100.f406418e = null;
        r100.f406419f = null;
        r100.f406420g = -1;
        r100.f406421h = 0;
        r100.f406422i = null;
        Object r110 = o.f406411j;
        monitor-enter(r110);
        int r111 = o.f406413l;     // Catch: Throwable -> L44
        if (r111 >= 50) goto L42;
        r100.f406422i = o.f406412k;     // Catch: Throwable -> L44
        o.f406412k = r100;     // Catch: Throwable -> L44
        o.f406413l = r111 + 1;     // Catch: Throwable -> L44
    L42:
        monitor-exit(r110);     // Catch: Throwable -> L44
        return;
    L44:
        th = move-exception;
        throw th;
    L16:
        FormatUtils.TYPE r112 = FormatUtils.TYPE.JSON;
        if (r103 != r112) goto L19;
        r102 = FormatUtils.c(r112, r100.f406416c);
        goto L15
    L19:
        FormatUtils.TYPE r113 = FormatUtils.TYPE.BUNDLE;
        if (r103 != r113) goto L22;
        r102 = FormatUtils.b(r113, (Bundle) r100.f406419f);
        goto L15
    L22:
        FormatUtils.TYPE r114 = FormatUtils.TYPE.INTENT;
        if (r103 != r114) goto L25;
        r102 = FormatUtils.a(r114, (Intent) r100.f406419f);
        goto L15
    L25:
        FormatUtils.TYPE r115 = FormatUtils.TYPE.THROWABLE;
        if (r103 != r115) goto L28;
        r102 = FormatUtils.e(r115, (Throwable) r100.f406419f);
        goto L15
    L28:
        FormatUtils.TYPE r116 = FormatUtils.TYPE.THREAD;
        if (r103 != r116) goto L31;
        r102 = FormatUtils.d(r116, (Thread) r100.f406419f);
        goto L15
    L31:
        FormatUtils.TYPE r117 = FormatUtils.TYPE.STACKTRACE;
        if (r103 != r117) goto L15;
        r102 = FormatUtils.f(r117, (StackTraceElement[]) r100.f406419f);
        goto L15
    L5:
        if (r100.f406417d != null) goto L8;
        r102 = r100.f406416c;
        goto L15
    L8:
        if (r100.f406416c != null) goto L10;
        String r118 = "";
    L11:
        r102 = r118 + wra.c.a(r100.f406417d);
        goto L15
    L10:
        r118 = r100.f406416c + "\n";
        goto L11
    }

    private static void handleItemMsg(nra.d r100) {
        String r101 = null;
        switch(e.f406403a[r100.f520270d.ordinal()]) {
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
        r101 = "";
        goto L12
    L5:
        r101 = FormatUtils.f(r100.f520270d, null);
        goto L12
    L6:
        r101 = FormatUtils.d(r100.f520270d, null);
        goto L12
    L7:
        r101 = FormatUtils.e(r100.f520270d, null);
        goto L12
    L8:
        r101 = FormatUtils.a(r100.f520270d, null);
        goto L12
    L9:
        r101 = FormatUtils.b(r100.f520270d, null);
        goto L12
    L10:
        r101 = FormatUtils.c(r100.f520270d, null);
        goto L12
    L11:
        r101 = wra.c.a(null);
    L12:
        r100.f520269c = r101;
    }

    public static boolean init(ALogConfig r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
        return false;
    L5:
        sConfig = r110;
        Alog.i(new nra.c());     // Catch: Throwable -> L112
        Object r101 = sInitLock;
        monitor-enter(r101);
    L109:
        th = move-exception;
        throw th;
    L10:
        if (sInitialized == false) goto L13;
        monitor-exit(r101);     // Catch: Throwable -> L109
        return false;
    L13:
        sInitialized = true;     // Catch: Throwable -> L109
        monitor-exit(r101);     // Catch: Throwable -> L109
        prio = r110.getLevel();
        Context r102 = r110.getContext();
        String r103 = nra.e.b();
        if (r103 != null) goto L19;
    L27:
        boolean r104 = false;
    L28:
        boolean r105 = r110.isOffloadMainThreadWrite();
        if (r105 == false) goto L31;
    L34:
        boolean r106 = false;
    L35:
        boolean r107 = r110.enableOffloadInAllProcess();
        boolean r108 = r110.isNewThreadPoolImplementation();
        if (r104 == true) goto L38;
        r110.setMaxDirSize((int) (r110.getMaxDirSize() * r110.getSubProcessMaxDirSizeRatio()));
    L38:
        Alog.a r109 = new Alog.a(r110.getContext());
        r109.b("default");
        r109.f38349b = level2AlogCoreLevel(r110.getLevel());
        r109.f38350c = sDebug;
        r109.f38352e = r110.getLogDirPath();
        r109.f38353f = r110.getPerSize();
        if (r106 == false) goto L41;
        int r111 = (r110.getMaxDirSize() / 3) * 2;
    L42:
        r109.f38354g = r111;
        r109.f38355h = r110.getLogFileExpDays();
        r109.f38356i = r110.getBufferDirPath();
        if (r104 == false) goto L45;
        int r112 = r110.getCacheFileSizeInKB() * 1024;
    L46:
        r109.f38357j = r112;
        if (r104 == false) goto L49;
        int r113 = (r110.getCacheFileSizeInKB() * 3) * 1024;
    L50:
        r109.f38358k = r113;
        Alog.Mode r114 = Alog.Mode.SAFE;
        r109.f38360m = r114.getValue();
        Alog.TimeFormat r115 = Alog.TimeFormat.RAW;
        r109.f38361n = r115.getValue();
        Alog.PrefixFormat r116 = Alog.PrefixFormat.LEGACY;
        r109.f38362o = r116.getValue();
        if (r110.isCompress() == false) goto L53;
        Alog.Compress r117 = Alog.Compress.ZSTD;
    L54:
        r109.f38363p = r117.getValue();
        if (r110.isEncrypt() == false) goto L57;
        Alog.SymCrypt r118 = Alog.SymCrypt.TEA_16;
    L58:
        r109.f38364q = r118.getValue();
        if (r110.isEncrypt() == false) goto L61;
        Alog.AsymCrypt r119 = Alog.AsymCrypt.EC_SECP256K1;
    L62:
        r109.f38365r = r119.getValue();
        r109.f38366s = r110.getPubKey();
        r109.f38367t = r110.isEnableNewCompression();
        Alog r120 = r109.a();
        com.bytedance.android.alog.e.f38378a = r120;
        if (r120 != null) goto L65;
        long r121 = 0;
    L66:
        Alog.nativeSetDefaultInstance(r121);
        if (r105 == false) goto L73;
        if (r107 == true) goto L70;
        if (r104 == false) goto L73;
    L70:
        if (r108 == false) goto L72;
        sSingleThreadExecutor = PThreadExecutorsUtils.newSingleThreadExecutor(new g());
        goto L73
    L72:
        PthreadHandlerThreadV2 r122 = new PthreadHandlerThreadV2("Alog_main_delegate");
        sAsyncLogThread = r122;
        ThreadMethodProxy.start(r122);
        sAsyncHandler = new h(sAsyncLogThread.getLooper());
    L73:
        if (r106 == false) goto L87;
        Alog.a r123 = new Alog.a(r110.getContext());
        r123.b(PullConfiguration.PROCESS_NAME_MAIN);
        r123.f38349b = level2AlogCoreLevel(r110.getLevel());
        r123.f38350c = sDebug;
        r123.f38352e = r110.getLogDirPath();
        r123.f38353f = r110.getPerSize() / 2;
        r123.f38354g = r110.getMaxDirSize() / 3;
        r123.f38355h = r110.getLogFileExpDays();
        r123.f38356i = r110.getBufferDirPath();
        r123.f38357j = 32768;
        r123.f38358k = 98304;
        r123.f38360m = r114.getValue();
        r123.f38361n = r115.getValue();
        r123.f38362o = r116.getValue();
        if (r110.isCompress() == false) goto L77;
        Alog.Compress r124 = Alog.Compress.ZSTD;
    L78:
        r123.f38363p = r124.getValue();
        if (r110.isEncrypt() == false) goto L81;
        Alog.SymCrypt r125 = Alog.SymCrypt.TEA_16;
    L82:
        r123.f38364q = r125.getValue();
        if (r110.isEncrypt() == false) goto L85;
        Alog.AsymCrypt r126 = Alog.AsymCrypt.EC_SECP256K1;
    L86:
        r123.f38365r = r126.getValue();
        r123.f38366s = r110.getPubKey();
        r123.f38367t = r110.isEnableNewCompression();
        mainThreadRef = r123.a();
        goto L87
    L85:
        r126 = Alog.AsymCrypt.NONE;
        goto L86
    L81:
        r125 = Alog.SymCrypt.NONE;
        goto L82
    L77:
        r124 = Alog.Compress.NONE;
    L87:
        String r127 = r110.getBufferDirPath();
        String r128 = r110.getLogDirPath();
        if (sILogCacheCallback == null) goto L93;
        Queue<nra.d> r129 = sILogCacheCallback.a();
        if (r129 != null) goto L92;
    L94:
        if (r129 == null) goto L96;
    L97:
        i r130 = new i(r129, r127, r128);
        ScheduledExecutorService r131 = sOuterExecutorService;
        if (r131 != null) goto L100;
        ThreadMethodProxy.start(new PthreadThreadV2(r130, "_ALOG_OPT_"));
    L101:
        r100 = true;
    L102:
        if (r100 == true) goto L107;
        ScheduledExecutorService r132 = sOuterExecutorService;
        if (r132 != null) goto L106;
        new PthreadTimer("_ALOG_OPT_").schedule(new j(r127, r128), 15000);
        goto L107
    L106:
        r132.schedule(new k(r127, r128), 15, TimeUnit.SECONDS);
    L107:
        sInitSuccess = true;
        return true;
    L100:
        r131.execute(r130);
        goto L101
    L96:
        if (getNativeFuncAddrCallbackList().size() <= 0) goto L102;
    L92:
        if (r129.size() != 0) goto L94;
    L93:
        r129 = null;
        goto L94
    L65:
        r121 = r120.f38341h;
        goto L66
    L61:
        r119 = Alog.AsymCrypt.NONE;
        goto L62
    L57:
        r118 = Alog.SymCrypt.NONE;
        goto L58
    L53:
        r117 = Alog.Compress.NONE;
        goto L54
    L49:
        r113 = 65536;
        goto L50
    L45:
        r112 = 32768;
        goto L46
    L41:
        r111 = r110.getMaxDirSize();
        goto L42
    L31:
        if (r110.isMainThreadSpeedUp() == false) goto L34;
        if (r104 == false) goto L34;
        r106 = true;
        goto L35
    L19:
        if (r103.contains(":") == true) goto L27;
        if (r103.equals(r102.getPackageName()) == false) goto L25;
    L26:
        r104 = true;
        goto L28
    L25:
        if (r103.equals(r102.getApplicationInfo().processName) == false) goto L27;
    L112:
        return false;
    }

    public static synchronized void removeLogFileDeleteListener(com.bytedance.android.alog.c r100) {
        monitor-enter(ALog.class);
        if (r100 != null) goto L16;
    L14:
        monitor-exit(ALog.class);
        return;
    L16:
    L11:
        th = move-exception;
        throw th;
    L6:
        if (sLogFileDeleteListeners == null) goto L14;
        sLogFileDeleteListeners.remove(r100);     // Catch: Throwable -> L11
        monitor-exit(ALog.class);
    }

    public static void removeMessageInterceptor(com.bytedance.android.alog.d r100) {
        if (r100 != null) goto L4;
        int r101 = Alog.f38325i;
        return;
    L4:
        if (Alog.f38331o == null) goto L10;
        ((CopyOnWriteArrayList) Alog.f38331o).remove(r100);
        return;
    }

    public static void setBlockTagSet(Set<String> r100) {
        mBlockTagSet = Collections.unmodifiableSet(r100);
    }

    public static void setDebug(boolean r100) {
        sDebug = r100;
        boolean r101 = sDebug;
        Alog r102 = com.bytedance.android.alog.e.f38378a;
        if (r102 == null) goto L5;
        r102.k(r101);
    L5:
        Alog r103 = mainThreadRef;
        if (r103 == null) goto L9;
        r103.k(sDebug);
        return;
    }

    public static void setILogCacheCallback(nra.a r100) {
        sILogCacheCallback = r100;
    }

    public static void setOuterExecutorService(ScheduledExecutorService r100) {
        sOuterExecutorService = r100;
    }

    public static void timedSyncFlush(int r100) {
        ExecutorService r101 = sSingleThreadExecutor;
        if (r101 == null) goto L5;
        r101.execute(new b());
    L5:
        Handler r102 = sAsyncHandler;
        if (r102 == null) goto L8;
        r102.sendEmptyMessage(2);
    L8:
        Alog r103 = com.bytedance.android.alog.e.f38378a;
        if (r103 == null) goto L11;
        r103.m(r100);
    L11:
        Alog r104 = mainThreadRef;
        if (r104 == null) goto L14;
        r104.m(r100);
    L14:
        Iterator<WeakReference<Alog>> r105 = sStandaloneInstances.iterator();
    L16:
        if (r105.hasNext() == false) goto L20;
        Alog r106 = r105.next().get();
        if (r106 == null) goto L16;
        r106.m(r100);
        goto L16
    }

    private static void writeCachedItems(Queue<nra.d> r100) {
        Iterator<nra.d> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        nra.d r102 = r101.next();
        if (checkPrioAndTag(r102.f520267a, r102.f520268b) == false) goto L4;
        handleItemMsg(r102);
        com.bytedance.android.alog.e.c(level2AlogCoreLevel(r102.f520267a), r102.f520268b, r102.f520269c);
        goto L4
    }

    public static /* synthetic */ void access$300(String r100, String r101) {
        removeLegacyFiles(r100, r101);
    }

    public static boolean checkPrioAndTag(int r100, String r101) {
        if (r100 >= prio) goto L5;
        return false;
    L5:
        Set<String> r102 = mBlockTagSet;
        if (r102 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return true;
    L10:
        if (r102.contains(r101) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static p createInstance(String r100, ALogConfig r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        if (sInitSuccess == false) goto L54;
    L25:
        Alog.a r102 = new Alog.a(r101.getContext());
        r102.b(r100);
        r102.f38349b = level2AlogCoreLevel(r101.getLevel());
        r102.f38350c = sDebug;
        ALogConfig r103 = sConfig;
        if (r103 == null) goto L28;
        String r104 = r103.getLogDirPath();
    L29:
        r102.f38352e = r104;
        r102.f38353f = r101.getPerSize();
        r102.f38354g = r101.getMaxDirSize();
        r102.f38355h = r101.getLogFileExpDays();
        ALogConfig r105 = sConfig;
        if (r105 == null) goto L32;
        String r106 = r105.getBufferDirPath();
    L33:
        r102.f38356i = r106;
        r102.f38357j = 65536;
        r102.f38358k = ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        r102.f38360m = Alog.Mode.SAFE.getValue();
        r102.f38361n = Alog.TimeFormat.RAW.getValue();
        r102.f38362o = Alog.PrefixFormat.LEGACY.getValue();
        if (r101.isCompress() == false) goto L36;
        Alog.Compress r107 = Alog.Compress.ZSTD;
    L37:
        r102.f38363p = r107.getValue();
        if (r101.isEncrypt() == false) goto L40;
        Alog.SymCrypt r108 = Alog.SymCrypt.TEA_16;
    L41:
        r102.f38364q = r108.getValue();
        if (r101.isEncrypt() == false) goto L44;
        Alog.AsymCrypt r109 = Alog.AsymCrypt.EC_SECP256K1;
    L45:
        r102.f38365r = r109.getValue();
        r102.f38366s = r101.getPubKey();
        r102.f38367t = r101.isEnableNewCompression();
        Alog r110 = r102.a();
        if (r110 != null) goto L48;
        return null;
    L48:
        sStandaloneInstances.add(new WeakReference(r110));
        return new p(r110, r100);
    L44:
        r109 = Alog.AsymCrypt.NONE;
        goto L45
    L40:
        r108 = Alog.SymCrypt.NONE;
        goto L41
    L36:
        r107 = Alog.Compress.NONE;
        goto L37
    L32:
        r106 = r101.getBufferDirPath();
        goto L33
    L28:
        r104 = r101.getLogDirPath();
        goto L29
    L54:
        monitor-enter(Alog.class);     // Catch: Throwable -> L24
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L10:
        if (Alog.f38333q == false) goto L52;
        monitor-exit(Alog.class);     // Catch: Throwable -> L24
        goto L25
    L52:
        com.bytedance.librarian.a.e(CloudControlInf.ALOG, true, sConfig.getContext());     // Catch: Throwable -> L17
    L18:
        Alog.f38333q = true;     // Catch: Throwable -> L21
        monitor-exit(Alog.class);     // Catch: Throwable -> L24
        goto L25
    L17:
        Intrinsics.checkNotNullParameter(CloudControlInf.ALOG, "libName");     // Catch: Throwable -> L21
        FLogger r111 = FLogger.f375446a;     // Catch: Throwable -> L21
        r111.i("Librarian_loadLib", "loadLibrary start libName -> alog");     // Catch: Throwable -> L21
        com.bytedance.librarian.a.c(CloudControlInf.ALOG);     // Catch: Throwable -> L21
        r111.i("Librarian_loadLib", "loadLibrary success by librarian -> alog");     // Catch: Throwable -> L21
    L24:
        return null;
    }

    public static void d(String r100, String r101) {
        if (checkPrioAndTag(3, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        Alog r105 = mainThreadRef;
        if (r105 == null) goto L35;
        if (r104 == false) goto L35;
        r105.n(1, r100, r101);
        return;
    L35:
        com.bytedance.android.alog.e.d(1, r100, r101);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(3, r100, r101);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(3, r100, r101);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(3, r100, r101);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(3, r100, r101);
        return;
    }

    public static void e(String r100, Throwable r101) {
        if (checkPrioAndTag(6, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        String r105 = wra.c.a(r101);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(4, r100, r105);
        return;
    L35:
        com.bytedance.android.alog.e.d(4, r100, r105);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r100, null, r101, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r100, null, r101, null, null);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r100, null, r101, null, null);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r100, null, r101, null, null);
        return;
    }

    public static List<String> getALogFiles(long r100, long r110) {
        ArrayList r101 = new ArrayList();
        long r102 = r100 * 1000;
        long r103 = r110 * 1000;
        Alog r111 = com.bytedance.android.alog.e.f38378a;     // Catch: Exception -> L12
        int r112 = 0;
        if (r111 == null) goto L6;
        File[] r104 = com.bytedance.android.alog.b.a(r111.f38335b, null, null, r102, r103);     // Catch: Exception -> L12
    L7:
        int r105 = r104.length;     // Catch: Exception -> L12
    L8:
        if (r112 >= r105) goto L11;
        r101.add(r104[r112].getAbsolutePath());     // Catch: Exception -> L12
        r112 = r112 + 1;
        goto L8
    L6:
        r104 = new File[0];     // Catch: Exception -> L12
    L11:
        return r101;
    }

    public static void i(String r100, String r101) {
        if (checkPrioAndTag(4, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        Alog r105 = mainThreadRef;
        if (r105 == null) goto L35;
        if (r104 == false) goto L35;
        r105.n(2, r100, r101);
        return;
    L35:
        com.bytedance.android.alog.e.d(2, r100, r101);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(4, r100, r101);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(4, r100, r101);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(4, r100, r101);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(4, r100, r101);
        return;
    }

    private static void removeLegacyFiles(String r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
        int r103 = 0;
        if (r102.exists() == false) goto L9;
        File[] r104 = r102.listFiles(new l());
        if (r104 == null) goto L9;
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L9;
        r104[r106].delete();
        r106 = r106 + 1;
    L9:
        PolarisFileWrapper r107 = new PolarisFileWrapper(r101);
        if (r107.exists() == false) goto L16;
        File[] r108 = r107.listFiles(new m());
        if (r108 == null) goto L19;
        int r109 = r108.length;
    L14:
        if (r103 >= r109) goto L20;
        r108[r103].delete();
        r103 = r103 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    public static void v(String r100, String r101) {
        if (checkPrioAndTag(2, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        Alog r105 = mainThreadRef;
        if (r105 == null) goto L35;
        if (r104 == false) goto L35;
        r105.n(0, r100, r101);
        return;
    L35:
        com.bytedance.android.alog.e.d(0, r100, r101);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(2, r100, r101);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(2, r100, r101);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(2, r100, r101);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(2, r100, r101);
        return;
    }

    public static void w(String r100, Throwable r101) {
        if (checkPrioAndTag(5, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        String r105 = wra.c.a(r101);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(3, r100, r105);
        return;
    L35:
        com.bytedance.android.alog.e.d(3, r100, r105);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r100, null, r101, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r100, null, r101, null, null);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r100, null, r101, null, null);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r100, null, r101, null, null);
        return;
    }

    public static p createInstance(String r100, Context r101) {
        if (r101 != null) goto L6;
        return null;
    L6:
        return createInstance(r100, new ALogConfig.b(r101).a());
    }

    public static void e(String r100, String r101) {
        if (checkPrioAndTag(6, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        Alog r105 = mainThreadRef;
        if (r105 == null) goto L35;
        if (r104 == false) goto L35;
        r105.n(4, r100, r101);
        return;
    L35:
        com.bytedance.android.alog.e.d(4, r100, r101);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r100, r101);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r100, r101);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r100, r101);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r100, r101);
        return;
    }

    public static void w(String r100, String r101) {
        if (checkPrioAndTag(5, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        Alog r105 = mainThreadRef;
        if (r105 == null) goto L35;
        if (r104 == false) goto L35;
        r105.n(3, r100, r101);
        return;
    L35:
        com.bytedance.android.alog.e.d(3, r100, r101);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r100, r101);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r100, r101);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r100, r101);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r100, r101);
        return;
    }

    public static void bundle(int r100, String r101, Bundle r110) {
        if (checkPrioAndTag(r100, r101) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        int r105 = level2AlogCoreLevel(r100);
        String r111 = FormatUtils.b(FormatUtils.TYPE.BUNDLE, r110);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(r105, r101, r111);
        return;
    L35:
        com.bytedance.android.alog.e.c(r105, r101, r111);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.BUNDLE, r110);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r100, r101, null, null, FormatUtils.TYPE.BUNDLE, r110);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.BUNDLE, r110);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r100, r101, null, null, FormatUtils.TYPE.BUNDLE, r110);
        return;
    }

    public static void e(String r100, String r101, Throwable r110) {
        if (checkPrioAndTag(6, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        String r105 = r101 + "\n" + wra.c.a(r110);
        Alog r111 = mainThreadRef;
        if (r111 == null) goto L35;
        if (r104 == false) goto L35;
        r111.n(4, r100, r105);
        return;
    L35:
        com.bytedance.android.alog.e.d(4, r100, r105);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r100, r101, r110, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r100, r101, r110, null, null);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r100, r101, r110, null, null);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r100, r101, r110, null, null);
        return;
    }

    public static void header(int r100, String r101, String r110) {
        if (checkPrioAndTag(r100, r101) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        int r105 = level2AlogCoreLevel(r100);
        String r111 = FormatUtils.c(FormatUtils.TYPE.BORDER, r110);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(r105, r101, r111);
        return;
    L35:
        com.bytedance.android.alog.e.c(r105, r101, r111);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r100, r101, r110, null, FormatUtils.TYPE.BORDER, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r100, r101, r110, null, FormatUtils.TYPE.BORDER, null);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r100, r101, r110, null, FormatUtils.TYPE.BORDER, null);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r100, r101, r110, null, FormatUtils.TYPE.BORDER, null);
        return;
    }

    public static void intent(int r100, String r101, Intent r110) {
        if (checkPrioAndTag(r100, r101) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        int r105 = level2AlogCoreLevel(r100);
        String r111 = FormatUtils.a(FormatUtils.TYPE.INTENT, r110);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(r105, r101, r111);
        return;
    L35:
        com.bytedance.android.alog.e.c(r105, r101, r111);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.INTENT, r110);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r100, r101, null, null, FormatUtils.TYPE.INTENT, r110);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.INTENT, r110);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r100, r101, null, null, FormatUtils.TYPE.INTENT, r110);
        return;
    }

    public static void json(int r100, String r101, String r110) {
        if (checkPrioAndTag(r100, r101) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        int r105 = level2AlogCoreLevel(r100);
        String r111 = FormatUtils.c(FormatUtils.TYPE.JSON, r110);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(r105, r101, r111);
        return;
    L35:
        com.bytedance.android.alog.e.c(r105, r101, r111);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r100, r101, r110, null, FormatUtils.TYPE.JSON, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r100, r101, r110, null, FormatUtils.TYPE.JSON, null);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r100, r101, r110, null, FormatUtils.TYPE.JSON, null);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r100, r101, r110, null, FormatUtils.TYPE.JSON, null);
        return;
    }

    public static void notifyLogFileDelete(String r100, long r101, int r102) {
        if (sLogFileDeleteListeners != null) goto L5;
        return;
    L5:
        Iterator<com.bytedance.android.alog.c> r103 = sLogFileDeleteListeners.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().a(r100, r101, r102);
        goto L7
    }

    private static void postAsyncLog(int r100, String r101, String r102) {
        postAsyncLog(r100, r101, r102, null, null, null);
    }

    private static void postAsyncLogByThreadPool(int r100, String r101, String r102) {
        postAsyncLogByThreadPool(r100, r101, r102, null, null, null);
    }

    public static void removeObsoleteInstance(String r110, Context r111, boolean r112) {
        String r100 = nra.e.b();
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.contains(":") == false) goto L8;
        return;
    L8:
        if (r112 == true) goto L11;
        r100 = r100.concat("-");
    L11:
        ALogConfig r113 = sConfig;
        if (r113 == null) goto L14;
        String r114 = r113.getLogDirPath();
        String r115 = sConfig.getBufferDirPath();
    L18:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r114);
        if (r101.exists() == true) goto L21;
        return;
    L21:
        if (r101.isDirectory() == false) goto L60;
        String r116 = "__" + r110 + ".alog.hot";
        File[] r102 = r101.listFiles();
        int r103 = r102.length;
        int r104 = 0;
        int r105 = 0;
    L24:
        if (r105 >= r103) goto L33;
        File r106 = r102[r105];
        String r107 = r106.getName();
        if (r107 == null) goto L32;
        if (r107.endsWith(r116) == false) goto L32;
        if (r107.contains(r100) == false) goto L32;
        r106.delete();
    L32:
        r105 = r105 + 1;
        goto L24
    L33:
        PolarisFileWrapper r117 = new PolarisFileWrapper(r115);
        if (r117.exists() == true) goto L36;
        return;
    L36:
        if (r117.isDirectory() == false) goto L61;
        String r118 = "__" + r110;
        File[] r119 = r117.listFiles();
        int r120 = r119.length;
    L39:
        if (r104 >= r120) goto L62;
        File r108 = r119[r104];
        String r109 = r108.getName();
        if (r109 == null) goto L47;
        if (r109.contains(r118) == false) goto L47;
        if (r109.contains(r100) == false) goto L47;
        r108.delete();
    L47:
        r104 = r104 + 1;
        goto L39
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L14:
        PolarisFileWrapper r121 = new PolarisFileWrapper(r111.getFilesDir(), LogUtil.DIR_TAIL);
        if (r121.exists() == true) goto L17;
        r121.mkdir();
    L17:
        String r122 = r121.getAbsolutePath();
        r115 = wra.a.a(r111);
        r114 = r122;
        goto L18
    }

    public static void stacktrace(int r100, String r101, StackTraceElement[] r110) {
        if (checkPrioAndTag(r100, r101) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        int r105 = level2AlogCoreLevel(r100);
        String r111 = FormatUtils.f(FormatUtils.TYPE.STACKTRACE, r110);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(r105, r101, r111);
        return;
    L35:
        com.bytedance.android.alog.e.c(r105, r101, r111);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.STACKTRACE, r110);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r100, r101, null, null, FormatUtils.TYPE.STACKTRACE, r110);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.STACKTRACE, r110);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r100, r101, null, null, FormatUtils.TYPE.STACKTRACE, r110);
        return;
    }

    public static void statcktrace(int r100, String r101, StackTraceElement[] r102) {
        stacktrace(r100, r101, r102);
    }

    public static void thread(int r100, String r101, Thread r110) {
        if (checkPrioAndTag(r100, r101) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        int r105 = level2AlogCoreLevel(r100);
        String r111 = FormatUtils.d(FormatUtils.TYPE.THREAD, r110);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(r105, r101, r111);
        return;
    L35:
        com.bytedance.android.alog.e.c(r105, r101, r111);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.THREAD, r110);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r100, r101, null, null, FormatUtils.TYPE.THREAD, r110);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.THREAD, r110);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r100, r101, null, null, FormatUtils.TYPE.THREAD, r110);
        return;
    }

    public static void throwable(int r100, String r101, Throwable r110) {
        if (checkPrioAndTag(r100, r101) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        int r105 = level2AlogCoreLevel(r100);
        String r111 = FormatUtils.e(FormatUtils.TYPE.THROWABLE, r110);
        Alog r106 = mainThreadRef;
        if (r106 == null) goto L35;
        if (r104 == false) goto L35;
        r106.n(r105, r101, r111);
        return;
    L35:
        com.bytedance.android.alog.e.c(r105, r101, r111);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r100, r101, null, null, FormatUtils.TYPE.THROWABLE, r110);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r100, r101, null, r110, FormatUtils.TYPE.THROWABLE, null);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r100, r101, null, r110, FormatUtils.TYPE.THROWABLE, null);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r100, r101, null, r110, FormatUtils.TYPE.THROWABLE, null);
        return;
    }

    public static void w(String r100, String r101, Throwable r110) {
        if (checkPrioAndTag(5, r100) == false) goto L37;
        ALogConfig r102 = sConfig;
        if (r102 != null) goto L7;
    L12:
        ALogConfig r103 = sConfig;
        if (r103 != null) goto L15;
    L20:
        boolean r104 = nra.e.c();
        if (r104 == true) goto L23;
    L26:
        if (r104 == true) goto L28;
    L31:
        String r105 = r101 + "\n" + wra.c.a(r110);
        Alog r111 = mainThreadRef;
        if (r111 == null) goto L35;
        if (r104 == false) goto L35;
        r111.n(3, r100, r105);
        return;
    L35:
        com.bytedance.android.alog.e.d(3, r100, r105);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r100, r101, r110, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r100, r101, r110, null, null);
        return;
    L15:
        if (r103.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r100, r101, r110, null, null);
        return;
    L7:
        if (r102.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r100, r101, r110, null, null);
        return;
    }

    public static List<String> getALogFiles(String r110, String r111, long r112, long r113) {
        ArrayList r100 = new ArrayList();
        long r101 = r112 * 1000;
        long r102 = r113 * 1000;
        Alog r114 = com.bytedance.android.alog.e.f38378a;     // Catch: Exception -> L12
        int r115 = 0;
        if (r114 == null) goto L6;
        File[] r116 = com.bytedance.android.alog.b.a(r114.f38335b, r110, r111, r101, r102);     // Catch: Exception -> L12
    L7:
        int r117 = r116.length;     // Catch: Exception -> L12
    L8:
        if (r115 >= r117) goto L11;
        r100.add(r116[r115].getAbsolutePath());     // Catch: Exception -> L12
        r115 = r115 + 1;
        goto L8
    L6:
        r116 = new File[0];     // Catch: Exception -> L12
    L11:
        return r100;
    }

    public static void println(int r100, String r101, Object r102, FormatUtils.TYPE r103) {
        if (checkPrioAndTag(r100, r101) == false) goto L49;
        int r104 = level2AlogCoreLevel(r100);
        switch(e.f406403a[r103.ordinal()]) {
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
        String r105 = "";
    L16:
        ALogConfig r106 = sConfig;
        if (r106 != null) goto L19;
    L24:
        ALogConfig r107 = sConfig;
        if (r107 != null) goto L27;
    L32:
        boolean r108 = nra.e.c();
        if (r108 == true) goto L35;
    L38:
        if (r108 == true) goto L40;
    L43:
        Alog r109 = mainThreadRef;
        if (r109 == null) goto L47;
        if (r108 == false) goto L47;
        r109.n(r104, r101, r105);
        return;
    L47:
        com.bytedance.android.alog.e.c(r104, r101, r105);
        return;
    L40:
        if (sAsyncHandler == null) goto L43;
        postAsyncLog(r100, r101, r105);
        return;
    L35:
        if (sSingleThreadExecutor == null) goto L38;
        postAsyncLogByThreadPool(r100, r101, r105);
        return;
    L27:
        if (r107.enableOffloadInAllThread() == false) goto L32;
        if (sAsyncHandler == null) goto L32;
        postAsyncLog(r100, r101, r105);
        return;
    L19:
        if (r106.enableOffloadInAllThread() == false) goto L24;
        if (sSingleThreadExecutor == null) goto L24;
        postAsyncLogByThreadPool(r100, r101, r105);
        return;
    L7:
        r105 = FormatUtils.f(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) r102);
        goto L16
    L8:
        r105 = FormatUtils.d(FormatUtils.TYPE.THREAD, (Thread) r102);
        goto L16
    L9:
        r105 = FormatUtils.e(FormatUtils.TYPE.THROWABLE, (Throwable) r102);
        goto L16
    L10:
        r105 = FormatUtils.a(FormatUtils.TYPE.INTENT, (Intent) r102);
        goto L16
    L11:
        r105 = FormatUtils.b(FormatUtils.TYPE.BUNDLE, (Bundle) r102);
        goto L16
    L12:
        r105 = FormatUtils.c(FormatUtils.TYPE.JSON, (String) r102);
        goto L16
    L13:
        r105 = FormatUtils.c(FormatUtils.TYPE.BORDER, (String) r102);
        goto L16
    L14:
        r105 = wra.c.a((Throwable) r102);
        goto L16
    L15:
        r105 = (String) r102;
        goto L16
    }

    public static void writeAsyncLog(int r100, String r101, String r110, long r111, long r112) {
        int r102 = level2AlogCoreLevel(r100);
        Alog r103 = com.bytedance.android.alog.e.f38378a;
        if (r103 == null) goto L6;
        r103.o(r102, r101, r110, r111, r112);
        return;
    }

    private static void postAsyncLog(int r100, String r101, String r102, Throwable r103, FormatUtils.TYPE r104, Object r105) {
        Object r106 = o.f406411j;
        monitor-enter(r106);
        o r107 = o.f406412k;     // Catch: Throwable -> L13
        if (r107 == null) goto L9;
        o.f406412k = r107.f406422i;     // Catch: Throwable -> L13
        r107.f406422i = null;     // Catch: Throwable -> L13
        o.f406413l--;     // Catch: Throwable -> L13
        monitor-exit(r106);     // Catch: Throwable -> L13
    L11:
        r107.f406414a = r100;
        r107.f406415b = r101;
        r107.f406416c = r102;
        r107.f406417d = r103;
        r107.f406418e = r104;
        r107.f406419f = r105;
        r107.f406420g = getThreadId();
        r107.f406421h = System.currentTimeMillis();
        Message r108 = Message.obtain();
        r108.what = 1;
        r108.obj = r107;
        sAsyncHandler.sendMessage(r108);
        return;
    L9:
        monitor-exit(r106);     // Catch: Throwable -> L13
        r107 = new o();
    L13:
        th = move-exception;
        throw th;
    }

    private static void postAsyncLogByThreadPool(int r110, String r111, String r112, Throwable r113, FormatUtils.TYPE r114, Object r115) {
        long r100 = getThreadId();
        long r101 = System.currentTimeMillis();
        sSingleThreadExecutor.execute(new d(r110, r114, r113, r112, r115, r111, r100, r101));
    }
}
