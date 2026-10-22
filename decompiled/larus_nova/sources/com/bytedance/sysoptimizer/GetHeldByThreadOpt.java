package com.bytedance.sysoptimizer;

import android.content.Context;
import android.os.Build;
import android.os.Debug;
import com.bytedance.shadowhook.ShadowHook;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;

/* JADX INFO: loaded from: classes22.dex */
public class GetHeldByThreadOpt {
    private static String TAG = "GetHeldByThreadOpt";
    private static boolean sShadowHookInited;
    static Thread threadA;
    static Thread threadB;
    static Thread threadC;

    public static class ThreadData {
        public boolean countException;
        public boolean deadLock;
        public Thread thread;
        public int threadid;
        public int tid;

        public ThreadData() {
            this.thread = null;
            this.tid = 0;
            this.threadid = 0;
            this.deadLock = false;
            this.countException = false;
        }
    }

    public GetHeldByThreadOpt() {
    }

    public static native int getHeldByThreadId(Thread r100, int r101);

    public static native int nativePeer2ThreadTid(Thread r100, int r101);

    public static native int nativePeer2Threadid(Thread r100, int r101);

    static {
        threadA = new PthreadThreadV2("GetHeldByThreadOpt");
        threadB = new PthreadThreadV2("GetHeldByThreadOpt");
        threadC = new PthreadThreadV2("GetHeldByThreadOpt");
    }

    public static void debugWaitLockFor2Thread() {
        final Object r100 = new Object();
        final Object r101 = new Object();
        PthreadThreadV2 r102 = new PthreadThreadV2(new AnonymousClass3(r100), "GetHeldByThreadOpt");
        threadA = r102;
        ThreadMethodProxy.start(r102);
        Thread.sleep(200);     // Catch: InterruptedException -> L5
    L7:
        PthreadThreadV2 r103 = new PthreadThreadV2(new AnonymousClass4(r101, r100), "GetHeldByThreadOpt");
        threadB = r103;
        ThreadMethodProxy.start(r103);
        Thread.sleep(200);     // Catch: InterruptedException -> L10
    L12:
        PthreadThreadV2 r104 = new PthreadThreadV2(new AnonymousClass5(r101, r100), "GetHeldByThreadOpt");
        threadC = r104;
        ThreadMethodProxy.start(r104);
        Thread.sleep(1000);     // Catch: InterruptedException -> L15
    L17:
        threadC.getName();
        threadA.getName();
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void debugWaitLockForDeadLock() {
        final Object r100 = new Object();
        final Object r101 = new Object();
        PthreadThreadV2 r102 = new PthreadThreadV2(new AnonymousClass6(r100, r101), "GetHeldByThreadOpt");
        threadA = r102;
        ThreadMethodProxy.start(r102);
        Thread.sleep(200);     // Catch: InterruptedException -> L5
    L7:
        PthreadThreadV2 r103 = new PthreadThreadV2(new AnonymousClass7(r101, r100), "GetHeldByThreadOpt");
        threadB = r103;
        ThreadMethodProxy.start(r103);
        Thread.sleep(2000);     // Catch: InterruptedException -> L10
    L13:
        if (threadA.getState() != Thread.State.BLOCKED) goto L19;
        long r104 = Debug.threadCpuTimeNanos();
        ThreadData r105 = getThreadDataForLockMonitor(threadA);
        if (r105.thread == null) goto L19;
        if (r105.countException == true) goto L19;
        threadA.getName();
        threadA.getId();
        threadA.getState();
        Thread.State r106 = Thread.State.BLOCKED;
        r105.thread.getName();
        long r107 = (Debug.threadCpuTimeNanos() - r104) / 1000000;
    L19:
        threadA.getName();
        threadB.getName();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void debugWaitLockForDeadLock2() {
        final Object r100 = new Object();
        final Object r101 = new Object();
        final Object r102 = new Object();
        PthreadThreadV2 r103 = new PthreadThreadV2(new AnonymousClass8(r100), "GetHeldByThreadOpt");
        threadA = r103;
        ThreadMethodProxy.start(r103);
        Thread.sleep(200);     // Catch: InterruptedException -> L5
    L7:
        PthreadThreadV2 r104 = new PthreadThreadV2(new AnonymousClass9(r100, r102, r101), "GetHeldByThreadOpt");
        threadB = r104;
        ThreadMethodProxy.start(r104);
        PthreadThreadV2 r105 = new PthreadThreadV2(new AnonymousClass10(r101, r102), "GetHeldByThreadOpt");
        threadC = r105;
        ThreadMethodProxy.start(r105);
        Thread.sleep(2000);     // Catch: InterruptedException -> L10
    L13:
        if (threadA.getState() != Thread.State.BLOCKED) goto L19;
        long r106 = Debug.threadCpuTimeNanos();
        ThreadData r107 = getThreadDataForLockMonitor(threadA);
        if (r107.thread == null) goto L19;
        if (r107.countException == true) goto L19;
        threadA.getName();
        threadA.getId();
        threadA.getState();
        Thread.State r108 = Thread.State.BLOCKED;
        r107.thread.getName();
        long r109 = (Debug.threadCpuTimeNanos() - r106) / 1000000;
    L19:
        threadB.getName();
        threadC.getName();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void debugWaitLockForThread() {
        final Object r100 = new Object();
        PthreadThreadV2 r101 = new PthreadThreadV2(new AnonymousClass1(r100), "GetHeldByThreadOpt");
        threadA = r101;
        ThreadMethodProxy.start(r101);
        Thread.sleep(100);     // Catch: InterruptedException -> L5
    L7:
        PthreadThreadV2 r102 = new PthreadThreadV2(new AnonymousClass2(r100), "GetHeldByThreadOpt");
        threadB = r102;
        ThreadMethodProxy.start(r102);
        Thread.sleep(1000);     // Catch: InterruptedException -> L10
    L12:
        threadB.getName();
        threadA.getName();
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void debug() {
        debugWaitLockForThread();
        debugWaitLockFor2Thread();
        debugWaitLockForDeadLock();
        debugWaitLockForDeadLock2();
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static boolean Init(Context r100) {
        if (sShadowHookInited == false) goto L13;
        return true;
    L13:
    L10:
        th = move-exception;
        th.printStackTrace();
        return false;
    L7:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L9;
        ShadowHook.access$000();     // Catch: Throwable -> L10
        ShadowHook.access$100();     // Catch: Throwable -> L10
        int r101 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L10
        ShadowHook.b r102 = new ShadowHook.b();     // Catch: Throwable -> L10
        r102.f270294a = r101;     // Catch: Throwable -> L10
        r102.f270295b = true;     // Catch: Throwable -> L10
        r102.f270296c = false;     // Catch: Throwable -> L10
        r102.f270297d = false;     // Catch: Throwable -> L10
        ShadowHook.init(r102);     // Catch: Throwable -> L10
        sShadowHookInited = true;     // Catch: Throwable -> L10
    L9:
        return true;
    }

    private static Thread getHeldByThread(int r100) {
        ThreadGroup r101 = ThreadMethodProxy.currentThread().getThreadGroup();
        int r102 = Thread.activeCount();
        Thread[] r103 = new Thread[r102];
        r101.enumerate(r103);
        Thread r104 = null;
        int r105 = 0;
    L3:
        if (r105 >= r102) goto L8;
        Thread r106 = r103[r105];
        if (nativePeer2Threadid(r106, Build.VERSION.SDK_INT) != r100) goto L7;
        r104 = r106;
    L7:
        r105 = r105 + 1;
        goto L3
    L8:
        return r104;
    }

    public static ThreadData getThreadDataForLockMonitor(Thread r100) {
        return getThreadDataForLockMonitor(r100, r100, 0);
    }

    private static ThreadData getThreadDataForLockMonitor(Thread r100, Thread r101, int r102) {
        ThreadData r103 = new ThreadData();
        if (r102 <= 15) goto L7;
        r103.deadLock = true;
        r103.countException = true;
        return r103;
    L7:
        if (r101.getState() != Thread.State.BLOCKED) goto L25;
        int r104 = Build.VERSION.SDK_INT;
        int r105 = getHeldByThreadId(r101, r104);
        Thread r106 = getHeldByThread(r105);
        if (r106 == null) goto L25;
        int r107 = nativePeer2ThreadTid(r106, r104);
        r103.thread = r106;
        r103.tid = r107;
        r103.threadid = r105;
        if (r101 != r106) goto L14;
        r100.getName();
        r103.thread.getName();
        return r103;
    L14:
        if (r100 == r106) goto L24;
        ThreadData r108 = getThreadDataForLockMonitor(r100, r106, r102 + 1);
        if (r108.countException == false) goto L19;
        return r108;
    L19:
        if (r108.thread != null) goto L22;
        r100.getName();
        r103.thread.getName();
        return r103;
    L22:
        r100.getName();
        r108.thread.getName();
        return r108;
    L24:
        r103.deadLock = true;
        r103.thread = r101;
        r103.tid = nativePeer2ThreadTid(r101, r104);
        r103.threadid = getHeldByThreadId(r101, r104);
        r100.getName();
        r103.thread.getName();
    L25:
        return r103;
    }
}
