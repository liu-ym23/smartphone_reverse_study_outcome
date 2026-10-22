package com.bytedance.apm.block.trace;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import es3.h;
import es3.m;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MethodCollector {
    public static final int DEFAULT_STACK_DEPTH = 5;
    public static final int METHOD_ID_DISPATCH = 1048574;
    private static final int METHOD_ID_MAX = 1048575;
    private static final int STATUS_DEFAULT = Integer.MAX_VALUE;
    private static final int STATUS_EXPIRED_START = -2;
    private static final int STATUS_NO_PERMIT = -4;
    private static final int STATUS_OUT_RELEASE = -3;
    private static final int STATUS_READY = 1;
    private static final int STATUS_STARTED = 2;
    private static final int STATUS_STOPPED = -1;
    private static final String TAG = "MethodCollector";
    private static boolean assertIn;
    private static Runnable checkStartExpiredRunnable;
    private static boolean isPauseUpdateTime;
    private static b27.a looperMonitorListener;
    private static long[] sBuffer;
    private static volatile long sCurrentDiffTime;
    private static volatile long sDiffTime;
    private static volatile boolean sDontRecord;
    private static Handler sHandler;
    private static int sIndex;
    private static g sIndexRecordHead;
    private static g sIndexRecordTail;
    private static MethodCollector sInstance;
    private static int sLastIndex;
    private static Thread sMainThread;
    private static volatile Runnable sReleaseOnMainThread;
    private static HandlerThread sTimerUpdateThread;
    private static Runnable sUpdateDiffTimeRunnable;
    private static volatile int status;
    private static final Object statusLock = null;
    private static Object updateTimeLock;

    public static class a extends b27.a {
        public final void a() {
            ((b27.a) this).a = false;
            MethodCollector.access$300();
        }

        public final boolean c() {
            if (MethodCollector.access$000() == null) goto L6;
            MethodCollector.access$000().run();
            MethodCollector.access$002(null);
        L6:
            if (MethodCollector.access$100() >= 1) goto L10;
            return false;
        L10:
            return true;
        }

        public a() {
        }

        public final void b(String r1) {
            ((b27.a) this).a = true;
            MethodCollector.access$200();
        }
    }

    public static class b implements Runnable {
        public b() {
        }

        public static void a() {
        L16:
        L15:
            return;
        L3:
            if (MethodCollector.access$400() == true) goto L7;
            if (MethodCollector.access$100() <= (-1)) goto L7;
            MethodCollector.access$502(MethodCollector.access$600() - MethodCollector.access$700());     // Catch: InterruptedException -> L15
            MethodCollector.access$502(MethodCollector.access$500() & 8796093022207L);     // Catch: InterruptedException -> L15
            SystemClock.sleep(5);     // Catch: InterruptedException -> L15
        L7:
            Object r0 = MethodCollector.access$800();     // Catch: InterruptedException -> L15
            monitor-enter(r0);     // Catch: InterruptedException -> L15
            MethodCollector.access$800().wait();     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L15
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
    }

    public static class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MethodCollector.access$900();     // Catch: Throwable -> L4
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
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MethodCollector.access$1000().removeCallbacksAndMessages(null);     // Catch: Throwable -> L4
            b27.e.h(MethodCollector.access$1100());     // Catch: Throwable -> L4
            MethodCollector.access$1200().quit();     // Catch: Throwable -> L4
            MethodCollector.access$1302(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MethodCollector.access$1000().removeCallbacksAndMessages(null);     // Catch: Throwable -> L4
            b27.e.h(MethodCollector.access$1100());     // Catch: Throwable -> L4
            MethodCollector.access$1200().quit();     // Catch: Throwable -> L4
            MethodCollector.access$1302(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r0 = MethodCollector.access$1400();     // Catch: Throwable -> L14
            monitor-enter(r0);     // Catch: Throwable -> L14
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L5:
            if (MethodCollector.access$100() != MethodCollector.STATUS_DEFAULT) goto L7;
        L8:
            MethodCollector.access$102(-2);     // Catch: Throwable -> L11
            MethodCollector.access$1502(true);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
        L17:
            return;
        L7:
            if (MethodCollector.access$100() != 1) goto L9;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class g {
        public final int a;
        public int b;
        public g c;
        public g d;
        public String e;
        public long f;

        public final String toString() {
            return "index:" + this.a + ",\tisValid:true source:" + this.e;
        }

        public g(int r1) {
            this.a = r1;
        }
    }

    public MethodCollector() {
    }

    private static void dispatchEnd() {
        isPauseUpdateTime = true;
    }

    private static long getTime(long r2) {
        return r2 & 8796093022207L;
    }

    public long[] copyAllData() {
        g r1 = sIndexRecordHead;     // Catch: Throwable -> L14
        if (r1 == null) goto L17;
        g r2 = sIndexRecordTail;     // Catch: Throwable -> L14
        if (r2 == null) goto L18;
        if (r1 == r2) goto L19;
        int r3 = r1.b;     // Catch: Throwable -> L14
        if (r3 != 0) goto L12;
        r3 = sIndex - 1;     // Catch: Throwable -> L14
    L12:
        return copyData(r2.a, r3);
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    L20:
        return null;
    }

    static {
        sInstance = new MethodCollector();
        status = STATUS_DEFAULT;
        sDontRecord = false;
        Object r2 = new Object();
        statusLock = r2;
        sBuffer = null;
        sIndex = 0;
        sLastIndex = -1;
        assertIn = false;
        sCurrentDiffTime = getCurrentTime();
        sDiffTime = sCurrentDiffTime;
        sMainThread = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
        sReleaseOnMainThread = null;
        sTimerUpdateThread = getTimerUpdateThread();
        sHandler = new Handler(sTimerUpdateThread.getLooper());
        updateTimeLock = new Object();
        isPauseUpdateTime = false;
        checkStartExpiredRunnable = null;
        looperMonitorListener = new a();
        sUpdateDiffTimeRunnable = new b();
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        status = STATUS_NO_PERMIT;
        sDontRecord = true;
    L17:
        sHandler.postDelayed(new c(), 15000);
        return;
    L5:
        sBuffer = new long[600000];
        if (status != STATUS_DEFAULT) goto L16;
        monitor-enter(r2);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (status != STATUS_DEFAULT) goto L11;
        realExecute();     // Catch: Throwable -> L13
        status = 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r2);     // Catch: Throwable -> L13
    L16:
        i(METHOD_ID_DISPATCH, 0);
        maskIndex("EvilMethodTracer#message_0", b27.a.b);
        goto L17
    }

    private static void dispatchBegin() {
        sCurrentDiffTime = b27.a.b - sDiffTime;
        isPauseUpdateTime = false;
        Object r0 = updateTimeLock;
        monitor-enter(r0);
        updateTimeLock.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getLastMethodIndex() {
        return sIndex - 1;
    }

    public static long getLastMethodTime() {
        return getTime(sBuffer[sIndex - 1]);
    }

    private static HandlerThread getTimerUpdateThread() {
        PthreadHandlerThreadV2 r0 = new PthreadHandlerThreadV2("trace_time_update_thread");
        ThreadMethodProxy.start(r0);
        return r0;
    }

    public static boolean isRealTrace() {
        if (status >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static void realRelease() {
        Object r0 = statusLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (status != STATUS_DEFAULT) goto L7;
    L8:
        status = -3;     // Catch: Throwable -> L11
        sDontRecord = true;     // Catch: Throwable -> L11
        sReleaseOnMainThread = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        if (status != STATUS_NO_PERMIT) goto L9;
        goto L8
    }

    public static void releaseForOpt() {
        Object r0 = statusLock;
        monitor-enter(r0);
        status = -3;     // Catch: Throwable -> L8
        sDontRecord = true;     // Catch: Throwable -> L8
        sReleaseOnMainThread = new e();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void unRegisterListener() {
        b27.e.h(looperMonitorListener);
    }

    public boolean isAlive() {
        if (status < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void onStart() {
        Object r0 = statusLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (status < 2) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L7:
        if (status < (-2)) goto L13;
        sHandler.removeCallbacks(checkStartExpiredRunnable);     // Catch: Throwable -> L15
        if (sBuffer == null) goto L12;
        status = 2;     // Catch: Throwable -> L15
        sDontRecord = false;     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L15
    }

    public void onStop() {
        Object r0 = statusLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (status != 2) goto L7;
        status = -1;     // Catch: Throwable -> L9
        sDontRecord = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public static /* synthetic */ long access$600() {
        return getCurrentTime();
    }

    private static long getCurrentTime() {
        return SystemClock.uptimeMillis();
    }

    public static String getVisibleScene() {
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    private static void realExecute() {
        sCurrentDiffTime = getCurrentTime() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5);
        Handler r0 = sHandler;
        f r1 = new f();
        checkStartExpiredRunnable = r1;
        r0.postDelayed(r1, 15000);
        b27.a r2 = looperMonitorListener;
        CopyOnWriteArrayList r3 = b27.e.d;
        monitor-enter(r3);
        if (r2 != null) goto L15;
    L10:
        monitor-exit(r3);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        if (r3.contains(r2) == true) goto L10;
        r3.add(r2);     // Catch: Throwable -> L12
        if (h.z.w == false) goto L10;
        b27.e.g();     // Catch: Throwable -> L12
        goto L10
    }

    public static /* synthetic */ Runnable access$000() {
        return sReleaseOnMainThread;
    }

    public static /* synthetic */ int access$100() {
        return status;
    }

    public static /* synthetic */ Handler access$1000() {
        return sHandler;
    }

    public static /* synthetic */ b27.a access$1100() {
        return looperMonitorListener;
    }

    public static /* synthetic */ HandlerThread access$1200() {
        return sTimerUpdateThread;
    }

    public static /* synthetic */ Object access$1400() {
        return statusLock;
    }

    public static /* synthetic */ void access$200() {
        dispatchBegin();
    }

    public static /* synthetic */ void access$300() {
        dispatchEnd();
    }

    public static /* synthetic */ boolean access$400() {
        return isPauseUpdateTime;
    }

    public static /* synthetic */ long access$500() {
        return sCurrentDiffTime;
    }

    public static /* synthetic */ long access$700() {
        return sDiffTime;
    }

    public static /* synthetic */ Object access$800() {
        return updateTimeLock;
    }

    public static /* synthetic */ void access$900() {
        realRelease();
    }

    public static long getCurrentDiffTime() {
        return sCurrentDiffTime;
    }

    public static long getDiffTime() {
        return sDiffTime;
    }

    public static MethodCollector getInstance() {
        return sInstance;
    }

    public static /* synthetic */ Runnable access$002(Runnable r0) {
        sReleaseOnMainThread = r0;
        return r0;
    }

    public static /* synthetic */ int access$102(int r0) {
        status = r0;
        return r0;
    }

    public static /* synthetic */ long[] access$1302(long[] r0) {
        sBuffer = r0;
        return r0;
    }

    public static /* synthetic */ boolean access$1502(boolean r0) {
        sDontRecord = r0;
        return r0;
    }

    public static /* synthetic */ long access$502(long r0) {
        sCurrentDiffTime = r0;
        return r0;
    }

    public long[] copyData(g r3) {
        return copyData(r3, new g(sIndex - 1));
    }

    public g getCurrentMethodIndex(String r5) {
        int r0 = sIndex - 1;
        g r1 = new g(r0);
        r1.e = r5;
        if (r0 < 0) goto L7;
        long[] r6 = sBuffer;
        if (r0 >= r6.length) goto L7;
        r1.f = getTime(r6[r0]);
    L7:
        return r1;
    }

    public static void i(int r4, long r5) {
        if (sDontRecord == false) goto L6;
        return;
    L6:
        if (r4 < METHOD_ID_MAX) goto L9;
        return;
    L9:
        if (ThreadMethodProxy.currentThread() == sMainThread) goto L11;
        return;
    L11:
        if (assertIn == false) goto L13;
        return;
    L13:
        assertIn = true;
        if (r5 == 0) goto L16;
        sCurrentDiffTime = r5 - sDiffTime;
        sCurrentDiffTime &= 8796093022207L;
    L16:
        long r6 = ((((long) r4) << 43) | Long.MIN_VALUE) | sCurrentDiffTime;
        long[] r7 = sBuffer;
        int r1 = sIndex;
        r7[r1] = r6;
        int r2 = r1 + 1;
        sIndex = r2;
        if (r2 != 600000) goto L19;
        sIndex = 0;
    L19:
        assertIn = false;
        g r8 = sIndexRecordTail;
        if (r8 != null) goto L23;
        return;
    L23:
        if (r8.a != sIndex) goto L30;
        g r9 = r8.d;
        sIndexRecordTail = r9;
        if (r9 == null) goto L27;
        r9.c = null;
        return;
    L27:
        sIndexRecordHead = null;
        return;
    }

    public static g maskIndex(String r5, long r6) {
        if (sIndexRecordHead != null) goto L9;
        g r0 = new g(sIndex);
        sIndexRecordHead = r0;
        if (r6 > 0) goto L7;
        r6 = SystemClock.uptimeMillis();
    L7:
        r0.f = r6;
        g r7 = sIndexRecordHead;
        r7.e = r5;
        sIndexRecordTail = r7;
        return r7;
    L9:
        int r3 = sIndex;
        g r1 = new g(r3);
        if (r6 > 0) goto L12;
        r6 = SystemClock.uptimeMillis();
    L12:
        r1.f = r6;
        r1.e = r5;
        g r8 = sIndexRecordHead;
        r1.c = r8;
        r8.b = r3 - 1;
        r8.d = r1;
        sIndexRecordHead = r1;
        return r1;
    }

    public static void o(int r4, long r5) {
        if (sDontRecord == false) goto L6;
        return;
    L6:
        if (r4 < METHOD_ID_MAX) goto L9;
        return;
    L9:
        if (ThreadMethodProxy.currentThread() == sMainThread) goto L11;
        return;
    L11:
        if (r5 == 0) goto L13;
        sCurrentDiffTime = r5 - sDiffTime;
        sCurrentDiffTime &= 8796093022207L;
    L13:
        long r6 = ((((long) r4) << 43) | 0) | sCurrentDiffTime;
        long[] r7 = sBuffer;
        int r0 = sIndex;
        r7[r0] = r6;
        int r1 = r0 + 1;
        sIndex = r1;
        if (r1 != 600000) goto L16;
        sIndex = 0;
    L16:
        g r8 = sIndexRecordTail;
        if (r8 != null) goto L19;
        return;
    L19:
        if (r8.a != sIndex) goto L27;
        g r9 = r8.d;
        sIndexRecordTail = r9;
        if (r9 == null) goto L23;
        r9.c = null;
        return;
    L23:
        sIndexRecordHead = null;
        return;
    }

    public long[] copyData(int r5, int r6) {
        long[] r1 = new long[0];
        int r7 = Math.max(0, r5);
        int r8 = Math.max(0, r6);
        if (r8 <= r7) goto L5;
        int r9 = (r8 - r7) + 1;
        long[] r2 = new long[r9];
        System.arraycopy(sBuffer, r7, r2, 0, r9);
        return r2;
    L5:
        if (r8 >= r7) goto L9;
        int r10 = r8 + 1;
        long[] r3 = sBuffer;
        long[] r4 = new long[(r3.length - r7) + r10];
        System.arraycopy(r3, r7, r4, 0, r3.length - r7);
        long[] r11 = sBuffer;
        System.arraycopy(r11, 0, r4, r11.length - r7, r10);
        return r4;
    L9:
        return r1;
    }

    public String evilMethodString(long[] r2, long r3) {
        if (r2 != null) goto L5;
        return "";
    L5:
        LinkedList r0 = new LinkedList();
        z37.a.f(r2, r0, r3);
        ListIterator r4 = r0.listIterator(r0.size());
    L7:
        if (r4.hasPrevious() == false) goto L13;
        m r5 = (m) r4.previous();
        if (r5 == null) goto L7;
        if (r5.b >= 1) goto L7;
        r4.remove();
        goto L7
    L13:
        StringBuilder r6 = new StringBuilder();
        z37.a.e(r0, r6);
        return r6.toString();
    }

    public String getEvilMethod(long r3, long r5) {
        long r0 = SystemClock.uptimeMillis();
        return evilMethodString(copyData(r3, r5), r0);
    }

    private long[] copyData(long r7, long r9) {
        g r0 = sIndexRecordHead;
        if (r0 == null) goto L19;
        g r1 = sIndexRecordTail;
        if (r1 == null) goto L28;
    L7:
        if (r0 == r1) goto L14;
        g r2 = r0.c;
        if (r2.f > r9) goto L10;
        g r3 = r1.d;
        if (r3.f >= r7) goto L14;
        r1 = r3;
        goto L7
    L10:
        r0 = r2;
    L14:
        int r8 = r0.b;
        if (r8 != 0) goto L18;
        r8 = sIndex - 1;
    L18:
        return copyData(r1.a, r8);
    L28:
        return null;
    L19:
        return null;
    }

    public long[] copyData(g r3, g r4) {
        if (status != (-3)) goto L6;
        return null;
    L6:
        long[] r0 = new long[0];
        r3.getClass();     // Catch: OutOfMemoryError -> L9
        r4.getClass();     // Catch: OutOfMemoryError -> L9
        return copyData(r3.a - 1, r4.a);
    L9:
        return r0;
    }
}
