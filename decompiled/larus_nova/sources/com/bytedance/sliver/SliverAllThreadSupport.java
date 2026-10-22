package com.bytedance.sliver;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
final class SliverAllThreadSupport {
    static final int SLIVER_GROUP_CACHE_SIZE = 50000;
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 21;
    private static Sliver.i filter;
    private static volatile boolean isRunning;
    private static volatile boolean isStart;
    private static final Thread mainThread = null;
    private static int samplingRateMs;
    private static ThreadGroup systemThreadGroup;
    private static final List<b> threadGroups = null;
    private static Handler threadHandler;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f270308a;

        public final void a() {
            if (SliverAllThreadSupport.access$000(this.f270308a) == true) goto L5;
            return;
        L5:
            Iterator r100 = SliverAllThreadSupport.access$100().iterator();
        L7:
            if (r100.hasNext() == false) goto L30;
            b r101 = (b) r100.next();
            String r102 = this.f270308a;
            monitor-enter(r101);
            BufferedWriter r103 = new BufferedWriter(new PolarisFileWriterWrapper(r102, true));     // Catch: Throwable -> L21
            Iterator<Thread> r104 = r101.f270311c.iterator();     // Catch: Throwable -> L20
        L13:
            if (r104.hasNext() == false) goto L18;
            Thread r105 = r104.next();     // Catch: Throwable -> L20
            long r106 = Sliver.getThreadPeer(r105);     // Catch: Throwable -> L20
            if (r106 == 0) goto L13;
            r103.write("# thread_info:" + SliverAllThreadSupport.access$800(r106) + ":" + r105.getName() + "\n");     // Catch: Throwable -> L20
            goto L13
        L18:
            r103.flush();     // Catch: Throwable -> L20
        L40:
            r103.close();     // Catch: Throwable -> L25 IOException -> L35
        L25:
            th = move-exception;
            throw th;
        L28:
            monitor-exit(r101);
        L22:
            if (r103 == null) goto L28;
        L21:
            r103 = null;
            goto L22
        L30:
            Iterator r107 = SliverAllThreadSupport.access$100().iterator();
        L32:
            if (r107.hasNext() == false) goto L34;
            ((b) r107.next()).a(this.f270308a);
            goto L32
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

        public a(String r100) {
            this.f270308a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f270309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f270310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final HashSet<Thread> f270311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile long f270312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f270313e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Sliver.Mode f270314f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f270315g;

        public final synchronized void b() {
            monitor-enter(this);
            c();     // Catch: Throwable -> L26
            if (this.f270312d != 0) goto L9;
            monitor-exit(this);
            return;
        L9:
            if (this.f270315g == true) goto L12;
            monitor-exit(this);
            return;
        L12:
            ArrayList r100 = new ArrayList(this.f270311c.size());     // Catch: Throwable -> L26
            ArrayList r101 = new ArrayList(this.f270311c.size());     // Catch: Throwable -> L26
            Iterator<Thread> r102 = this.f270311c.iterator();     // Catch: Throwable -> L26
        L14:
            if (r102.hasNext() == false) goto L19;
            Thread r103 = r102.next();     // Catch: Throwable -> L26
            long r104 = Sliver.getThreadPeer(r103);     // Catch: Throwable -> L26
            if (r104 == 0) goto L14;
            r100.add(Long.valueOf(r104));     // Catch: Throwable -> L26
            r101.add(r103);     // Catch: Throwable -> L26
            goto L14
        L19:
            long[] r105 = new long[r100.size()];     // Catch: Throwable -> L26
            int r106 = 0;
        L21:
            if (r106 >= r100.size()) goto L23;
            r105[r106] = ((Long) ListProtector.get(r100, r106)).longValue();     // Catch: Throwable -> L26
            r106 = r106 + 1;     // Catch: Throwable -> L26
            goto L21
        L23:
            SliverAllThreadSupport.access$500(this.f270312d, (Thread[]) r101.toArray(new Thread[0]), r105);     // Catch: Throwable -> L26
            this.f270315g = false;     // Catch: Throwable -> L26
            monitor-exit(this);
            return;
        L26:
            th = move-exception;
            throw th;
        }

        public final synchronized void c() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f270312d == 0) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f270312d = SliverAllThreadSupport.access$600(this.f270310b, this.f270313e, Sliver.mode2Int(this.f270314f), this.f270309a);     // Catch: Throwable -> L11
            monitor-exit(this);
        }

        public final synchronized void a(String r100) {
            monitor-enter(this);
            SliverAllThreadSupport.access$900(this.f270312d, r100);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public b(int r100, int r101, int r102, Sliver.Mode r103) {
            this.f270312d = 0;
            this.f270315g = false;
            this.f270309a = r100;
            this.f270310b = r101;
            this.f270311c = new HashSet();
            this.f270313e = r102;
            this.f270314f = r103;
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f270316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Thread> f270317b;

        public final void a() {
            List<Thread> r100 = SliverAllThreadSupport.access$200();
            if (this.f270317b != null) goto L5;
            b(r100);
        L43:
            this.f270317b = r100;
            Iterator r101 = SliverAllThreadSupport.access$100().iterator();
        L45:
            if (r101.hasNext() == false) goto L47;
            ((b) r101.next()).b();
            goto L45
        L47:
            SliverAllThreadSupport.access$300().postDelayed(this, this.f270316a);
            return;
        L5:
            ArrayList r102 = new ArrayList();
            ArrayList r103 = new ArrayList();
            Iterator<Thread> r104 = r100.iterator();
        L7:
            if (r104.hasNext() == false) goto L11;
            Thread r105 = r104.next();
            if (this.f270317b.contains(r105) == true) goto L7;
            r102.add(r105);
            goto L7
        L11:
            Iterator<Thread> r106 = this.f270317b.iterator();
        L13:
            if (r106.hasNext() == false) goto L17;
            Thread r107 = r106.next();
            if (r100.contains(r107) == true) goto L13;
            r103.add(r107);
            goto L13
        L17:
            Iterator r108 = r103.iterator();
        L19:
            if (r108.hasNext() == false) goto L42;
            Thread r109 = (Thread) r108.next();
            int r110 = 1;
        L22:
            if (r110 >= SliverAllThreadSupport.access$100().size()) goto L19;
            b r111 = (b) ListProtector.get(SliverAllThreadSupport.access$100(), r110);
            monitor-enter(r111);
        L39:
            th = move-exception;
            throw th;
        L26:
            if (r111.f270311c.isEmpty() == false) goto L30;
            monitor-exit(r111);
        L35:
            boolean r112 = false;
        L36:
            if (r112 == true) goto L19;
            r110 = r110 + 1;
            goto L22
        L30:
            if (r111.f270311c.remove(r109) == false) goto L34;
            r111.f270315g = true;     // Catch: Throwable -> L39
            monitor-exit(r111);
            r112 = true;
            goto L36
        L34:
            monitor-exit(r111);
            goto L35
        L42:
            b(r102);
            goto L43
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

        public c(int r100) {
            this.f270316a = r100;
        }

        public static void b(List r100) {
            int r101 = r100.size();
            int r102 = 0;
        L3:
            int r103 = 1;
        L4:
            if (r102 >= r101) goto L15;
            SliverAllThreadSupport.access$400();
            b r104 = (b) ListProtector.get(SliverAllThreadSupport.access$100(), r103);
            Thread r105 = (Thread) ListProtector.get(r100, r102);
            monitor-enter(r104);
            r104.f270311c.add(r105);     // Catch: Throwable -> L12
            r104.f270315g = true;     // Catch: Throwable -> L12
            monitor-exit(r104);
            r102 = r102 + 1;
            r103 = r103 + 1;
            if (r103 < SliverAllThreadSupport.access$100().size()) goto L4;
        L12:
            th = move-exception;
            throw th;
        }
    }

    public SliverAllThreadSupport() {
    }

    public static /* synthetic */ Sliver.i access$400() {
        return null;
    }

    private static boolean initSystemThreadGroup() {
        if (systemThreadGroup != null) goto L9;
        Field r100 = ThreadGroup.class.getDeclaredField("systemThreadGroup");     // Catch: Throwable -> L7
        r100.setAccessible(true);     // Catch: Throwable -> L7
        systemThreadGroup = (ThreadGroup) r100.get(null);     // Catch: Throwable -> L7
    L9:
        if (systemThreadGroup != null) goto L15;
        return false;
    L15:
        return true;
    }

    private static native void nClearSliverGroup(long r100);

    private static native void nDumpSliverGroup(long r100, String r101);

    private static native int nGetThreadId(long r100);

    private static native void nNotifySliverGroup(long r100, Thread[] r101, long[] r102);

    private static native void nPauseSliverGroup(long r100);

    private static native void nResumeSliverGroup(long r100);

    private static native long nStartSliverGroup(int r100, int r101, int r102, int r103);

    private static native void nStopSliverGroup(long r100);

    static {
        threadGroups = new LinkedList();
        mainThread = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
        isStart = false;
        isRunning = false;
        samplingRateMs = 10;
        threadHandler = null;
        systemThreadGroup = null;
    }

    public static boolean clearAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        Iterator<b> r100 = threadGroups.iterator();
    L8:
        if (r100.hasNext() == false) goto L17;
        b r101 = r100.next();
        monitor-enter(r101);
        access$1200(r101.f270312d);     // Catch: Throwable -> L14
        monitor-exit(r101);
    L14:
        th = move-exception;
        throw th;
    L17:
        return true;
    }

    private static synchronized void deleteThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
        Handler r100 = threadHandler;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.removeCallbacksAndMessages(null);     // Catch: Throwable -> L9
        ThreadMethodProxy.quitSafely(threadHandler.getLooper());     // Catch: Throwable -> L9
        threadHandler = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(SliverAllThreadSupport.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private static List<Thread> getAllThread() {
        int r100 = systemThreadGroup.activeCount();
        Thread[] r101 = new Thread[r100 + (r100 / 2)];
        int r102 = systemThreadGroup.enumerate(r101);
        ArrayList r103 = new ArrayList(r102);
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L12;
        Thread r105 = r101[r104];
        if (r105 == mainThread) goto L11;
        if (r105.getName().contains("sliver") == true) goto L11;
        r103.add(r101[r104]);
    L11:
        r104 = r104 + 1;
        goto L3
    L12:
        return r103;
    }

    private static synchronized Handler newThreadHandler() {
        monitor-enter(SliverAllThreadSupport.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (threadHandler != null) goto L7;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("sliver_check_thread");     // Catch: Throwable -> L10
        ThreadMethodProxy.start(r100);     // Catch: Throwable -> L10
        threadHandler = new Handler(r100.getLooper());     // Catch: Throwable -> L10
    L7:
        Handler r101 = threadHandler;     // Catch: Throwable -> L10
        monitor-exit(SliverAllThreadSupport.class);
        return r101;
    }

    public static boolean pauseAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == true) goto L8;
        return false;
    L8:
        Iterator<b> r100 = threadGroups.iterator();
    L10:
        if (r100.hasNext() == false) goto L19;
        b r101 = r100.next();
        monitor-enter(r101);
        access$1000(r101.f270312d);     // Catch: Throwable -> L16
        monitor-exit(r101);
    L16:
        th = move-exception;
        throw th;
    L19:
        deleteThreadHandler();
        isRunning = false;
        return true;
    }

    public static boolean resumeAll() {
        if (isStart == true) goto L6;
        return false;
    L6:
        if (isRunning == false) goto L8;
        return false;
    L8:
        Iterator<b> r100 = threadGroups.iterator();
    L10:
        if (r100.hasNext() == false) goto L19;
        b r101 = r100.next();
        monitor-enter(r101);
        access$1100(r101.f270312d);     // Catch: Throwable -> L16
        monitor-exit(r101);
    L16:
        th = move-exception;
        throw th;
    L19:
        newThreadHandler().post(new c(samplingRateMs));
        isRunning = true;
        return true;
    }

    public static boolean stopAll() {
        if (isStart == true) goto L5;
        return false;
    L5:
        Iterator<b> r100 = threadGroups.iterator();
    L7:
        if (r100.hasNext() == false) goto L21;
        b r101 = r100.next();
        monitor-enter(r101);
    L18:
        th = move-exception;
        throw th;
    L12:
        if (r101.f270312d == 0) goto L13;
        access$700(r101.f270312d);     // Catch: Throwable -> L18
        monitor-exit(r101);
        goto L7
    L13:
        monitor-exit(r101);
        goto L7
    L21:
        threadGroups.clear();
        deleteThreadHandler();
        isStart = false;
        isRunning = false;
        return true;
    }

    public static /* synthetic */ List access$200() {
        return getAllThread();
    }

    public static /* synthetic */ Handler access$300() {
        return newThreadHandler();
    }

    public static /* synthetic */ List access$100() {
        return threadGroups;
    }

    public static boolean isStart() {
        return isStart;
    }

    public static /* synthetic */ boolean access$000(String r100) {
        return dumpHeader(r100);
    }

    public static /* synthetic */ void access$1000(long r100) {
        nPauseSliverGroup(r100);
    }

    public static /* synthetic */ void access$1100(long r100) {
        nResumeSliverGroup(r100);
    }

    public static /* synthetic */ void access$1200(long r100) {
        nClearSliverGroup(r100);
    }

    public static /* synthetic */ void access$700(long r100) {
        nStopSliverGroup(r100);
    }

    public static /* synthetic */ int access$800(long r100) {
        return nGetThreadId(r100);
    }

    private static boolean dumpHeader(String r100) {
        BufferedWriter r101 = null;
        BufferedWriter r102 = new BufferedWriter(new PolarisFileWriterWrapper(r100));     // Catch: Throwable -> L14
        r102.write("# sliver\n");     // Catch: Throwable -> L8
        r102.write("# pid:" + Process.myPid() + "\n");     // Catch: Throwable -> L8
        r102.flush();     // Catch: Throwable -> L8
        r102.close();     // Catch: IOException -> L13
        return true;
    L24:
        return true;
    L8:
        r101 = r102;
    L9:
        if (r101 == null) goto L25;
        r101.close();     // Catch: IOException -> L15
        return false;
    L26:
        return false;
    L25:
        return false;
    }

    public static /* synthetic */ void access$900(long r100, String r101) {
        nDumpSliverGroup(r100, r101);
    }

    public static boolean dumpAll(String r100, boolean r101) {
        if (isStart == true) goto L6;
        return false;
    L6:
        a r102 = new a(r100);
        if (r101 == false) goto L9;
        r102.run();
        return true;
    L9:
        newThreadHandler().post(r102);
        return true;
    }

    public static /* synthetic */ void access$500(long r100, Thread[] r101, long[] r102) {
        nNotifySliverGroup(r100, r101, r102);
    }

    public static /* synthetic */ long access$600(int r100, int r101, int r102, int r103) {
        return nStartSliverGroup(r100, r101, r102, r103);
    }

    public static boolean startAll(int r100, int r101, int r102, Sliver.Mode r103, Sliver.i r104) {
        if (Build.VERSION.SDK_INT <= 31) goto L6;
        return false;
    L6:
        if (isStart == false) goto L9;
        return false;
    L9:
        if (initSystemThreadGroup() == true) goto L11;
        return false;
    L11:
        samplingRateMs = r101;
        List<b> r105 = threadGroups;
        r105.clear();
        int r106 = Math.max(r100, 2);
        b r107 = new b(0, r101, r102, r103);
        Thread r108 = mainThread;
        monitor-enter(r107);
        r107.f270311c.add(r108);     // Catch: Throwable -> L20
        r107.f270315g = true;     // Catch: Throwable -> L20
        monitor-exit(r107);
        r107.b();
        r105.add(r107);
        int r109 = 1;
    L16:
        if (r109 >= r106) goto L18;
        threadGroups.add(new b(r109, r101, r102, r103));
        r109 = r109 + 1;
        goto L16
    L18:
        newThreadHandler().post(new c(r101 * 5));
        isStart = true;
        isRunning = true;
        return true;
    L20:
        th = move-exception;
        throw th;
    }
}
