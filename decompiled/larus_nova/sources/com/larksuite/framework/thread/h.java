package com.larksuite.framework.thread;

import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class h extends AbstractExecutorService {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicInteger f285754i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f285755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<Runnable> f285756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f285757c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Condition f285758d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Runnable f285759e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile ExecutorService f285760f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile AtomicInteger f285761g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f285762h;

    public class a extends k {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f285763h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f285764i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ h f285765j;

        public final void b() {
            this.f285775d = SystemClock.uptimeMillis();
            Callable r100 = null;
            String r101 = this.f285773b.getClass().getName();     // Catch: Throwable -> L21 Exception -> L23
            if ((this.f285773b instanceof FutureTask) == false) goto L13;
            if (CoreThreadPool.needMonitorTask() == false) goto L13;
            Callable r102 = (Callable) m.b(this.f285773b);     // Catch: Throwable -> L21 Exception -> L23
            r101 = r102.getClass().getName();     // Catch: Exception -> L10 Throwable -> L31
            r100 = r102;
        L10:
            Exception e100 = e;
        L25:
            Log.e("CoreThreadPool CoreSerialThreadPool", "SerialRunnable run exception, poolname" + this.f285763h, e100);     // Catch: Throwable -> L31
            if (r102 == null) goto L28;
            String r103 = r102.getClass().getName();
        L29:
            c(r103);
            h r104 = this.f285765j;
        L20:
            AtomicInteger r105 = h.f285754i;
            r104.c();
            return;
        L28:
            r103 = this.f285773b.getClass().toString();
        L31:
            th = th;
            r100 = r102;
        L33:
            if (r100 == null) goto L35;
            String r106 = r100.getClass().getName();
        L36:
            c(r106);
            h r107 = this.f285765j;
            AtomicInteger r108 = h.f285754i;
            r107.c();
            throw th;
        L35:
            r106 = this.f285773b.getClass().toString();
        L13:
            if (CoreThreadPool.sAppFront == true) goto L15;
            Log.i("CoreThreadPool CoreSerialThreadPool", r101 + " background executor, serial poolname is " + this.f285763h);     // Catch: Throwable -> L21 Exception -> L23
        L15:
            this.f285773b.run();     // Catch: Throwable -> L21 Exception -> L23
            if (r100 == null) goto L18;
            String r109 = r100.getClass().getName();
        L19:
            c(r109);
            r104 = this.f285765j;
            goto L20
        L18:
            r109 = this.f285773b.getClass().toString();
            goto L19
        L23:
            e = move-exception;
            r102 = r100;
            e100 = e;
        L21:
            th = th;
            goto L33
        }

        @Override // com.larksuite.framework.thread.k, java.lang.Runnable
        public final void run() {
            b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void c(String r210) {
            long r100 = this.f285764i;
            long r110 = r100 - this.f285774c;
            long r111 = this.f285775d - r100;
            long r101 = SystemClock.uptimeMillis() - this.f285775d;
            Log.d("CoreThreadPool CoreSerialThreadPool", this.f285763h + ", " + r210 + ", serialqueuetime& dispatchtime & runtime is(ms) " + r110 + ", " + r111 + ", " + r101);
            if (CoreThreadPool.needMonitorTask() == true) goto L6;
            return;
        L6:
            if ((this.f285765j.f285760f instanceof i) == true) goto L8;
            return;
        L8:
            if (((i) this.f285765j.f285760f).f285770j >= r110) goto L10;
            boolean r102 = true;
        L12:
            if (((i) this.f285765j.f285760f).f285768h >= r111) goto L15;
            r102 = true;
        L15:
            if (((i) this.f285765j.f285760f).f285769i >= r101) goto L17;
            boolean r103 = true;
        L18:
            if (r103 == false) goto L41;
            long r104 = ((i) this.f285765j.f285760f).f285770j;
            long r105 = ((i) this.f285765j.f285760f).f285768h;
            long r112 = ((i) this.f285765j.f285760f).f285769i;
            JSONObject r106 = l.a(r210, this.f285763h, r111, r101, r105, r112);
            r106.put("serialqueuewaittime", r110);     // Catch: Exception -> L35
            long r107 = r104;
            r106.put("maxserialqueuewaittime", r107);     // Catch: Exception -> L34
        L29:
            CoreThreadPool.a r108 = CoreThreadPool.mCoreThreadPoolDep;
            if (r108 == null) goto L32;
            r108.b();
        L32:
            Log.i("CoreThreadPool CoreSerialThreadPool", this.f285763h + ", " + r210 + ", serialqueuetime& dispatchtime & runtime is(ms) " + r110 + ", " + r111 + ", " + r101 + ", limit is " + r107 + ", " + r105 + ", " + r112);
            return;
        L28:
            Log.e("CoreTaskMonitor", "genSerialTaskEvent gen json failed");
        L26:
            r107 = r104;
            goto L28
        L41:
            return;
        L17:
            r103 = r102;
            goto L18
        L10:
            r102 = false;
            goto L12
        }

        public a(h r100, Runnable r101, ExecutorService r102, String r103) {
            this.f285765j = r100;
            if ((r102 instanceof t) == false) goto L5;
            t r104 = (t) r102;
        L6:
            super(r101, r104);
            this.f285763h = r103;
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    static {
        f285754i = new AtomicInteger(0);
    }

    public final void a() {
        if ((this.f285760f instanceof i) == false) goto L6;
        ((i) this.f285760f).h(false);
        return;
    }

    public final List<Runnable> b() {
        this.f285757c.lock();
        Log.i("CoreThreadPool CoreSerialThreadPool", "drainQueue: remove all undo task!");
        ArrayDeque<Runnable> r100 = this.f285756b;     // Catch: Throwable -> L16 Exception -> L18
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L16 Exception -> L18
    L14:
        Exception e100 = e;
    L20:
        Log.e("CoreThreadPool CoreSerialThreadPool", "drainQueue: ", e100);     // Catch: Throwable -> L16
    L21:
        this.f285757c.unlock();
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L21;
        Iterator<Runnable> r102 = r100.iterator();     // Catch: Exception -> L14 Throwable -> L16
    L8:
        if (r102.hasNext() == false) goto L12;
        Runnable r103 = r102.next();     // Catch: Exception -> L14 Throwable -> L16
        if (r100.remove(r103) == false) goto L8;
        r101.add(r103);     // Catch: Exception -> L14 Throwable -> L16
        goto L8
    L12:
        this.f285758d.signalAll();     // Catch: Exception -> L14 Throwable -> L16
    L18:
        e = move-exception;
        r101 = null;
        e100 = e;
    L16:
        th = move-exception;
        this.f285757c.unlock();
        throw th;
    }

    public final void c() {
        this.f285757c.lock();
        Runnable r100 = this.f285756b.poll();     // Catch: Exception -> L8 Throwable -> L15
        this.f285759e = r100;     // Catch: Exception -> L8 Throwable -> L15
        if (r100 == null) goto L12;
        if ((this.f285759e instanceof a) == false) goto L10;
        a r101 = (a) this.f285759e;     // Catch: Exception -> L8 Throwable -> L15
        r101.getClass();     // Catch: Exception -> L8 Throwable -> L15
        r101.f285764i = SystemClock.uptimeMillis();     // Catch: Exception -> L8 Throwable -> L15
    L10:
        this.f285760f.execute(this.f285759e);     // Catch: Exception -> L8 Throwable -> L15
        Log.i("CoreThreadPool CoreSerialThreadPool", "scheduleNext: poolname" + this.f285762h);     // Catch: Exception -> L8 Throwable -> L15
    L14:
        this.f285757c.unlock();
        return;
    L12:
        if (this.f285755a.get() != 0) goto L14;
        Log.i("CoreThreadPool CoreSerialThreadPool", "scheduleNext: found Lark Serial ThreadPool shutdown");     // Catch: Exception -> L8 Throwable -> L15
        this.f285755a.getAndIncrement();     // Catch: Exception -> L8 Throwable -> L15
        this.f285758d.signalAll();     // Catch: Exception -> L8 Throwable -> L15
        a();     // Catch: Exception -> L8 Throwable -> L15
    L8:
        e = move-exception;
        Log.e("CoreThreadPool CoreSerialThreadPool", "scheduleNext exception, poolname" + this.f285762h, e);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        this.f285757c.unlock();
        throw th;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isShutdown() {
        if (this.f285755a.get() <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean isTerminated() {
        if (this.f285755a.get() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.concurrent.ExecutorService
    public final void shutdown() {
        this.f285757c.lock();
    L17:
        th = move-exception;
        this.f285757c.unlock();
        if (this.f285755a.get() != 1) goto L21;
        a();
    L21:
        throw th;
    L5:
        if (this.f285755a.get() == (-1)) goto L10;
        this.f285757c.unlock();
        if (this.f285755a.get() != 1) goto L24;
        a();
        return;
    L24:
        return;
    L10:
        this.f285755a.getAndIncrement();     // Catch: Throwable -> L17
        if (this.f285756b.size() != 0) goto L13;
        this.f285755a.getAndIncrement();     // Catch: Throwable -> L17
    L13:
        this.f285757c.unlock();
        if (this.f285755a.get() != 1) goto L25;
        a();
        return;
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        this.f285757c.lock();
        int r100 = this.f285755a.get();     // Catch: Throwable -> L13
        if (r100 != (-1)) goto L6;
        this.f285755a.compareAndSet(r100, 1);     // Catch: Throwable -> L13
    L8:
        List<Runnable> r101 = b();     // Catch: Throwable -> L13
    L9:
        this.f285757c.unlock();
        a();
        return r101;
    L6:
        if (r100 != 0) goto L11;
        this.f285755a.getAndIncrement();     // Catch: Throwable -> L13
        goto L8
    L11:
        r101 = Collections.emptyList();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        this.f285757c.unlock();
        a();
        throw th;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        this.f285757c.lock();
    L17:
        e = move-exception;
        Log.e("CoreThreadPool CoreSerialThreadPool", "execute exception, poolname" + this.f285762h, e);     // Catch: Throwable -> L15
        this.f285757c.unlock();
        StringBuilder r101 = new StringBuilder("add task: poolname");
    L20:
        r101.append(this.f285762h);
        r101.append(", task size: ");
        r101.append(this.f285756b.size());
        Log.i("CoreThreadPool CoreSerialThreadPool", r101.toString());
        return;
    L4:
        if (this.f285755a.get() == (-1)) goto L8;
        Log.w("CoreThreadPool CoreSerialThreadPool", "execute: found SerialThreadPool already shutdown!");     // Catch: Throwable -> L15 Exception -> L17
        this.f285757c.unlock();
        Log.i("CoreThreadPool CoreSerialThreadPool", "add task: poolname" + this.f285762h + ", task size: " + this.f285756b.size());
        return;
    L8:
        this.f285756b.offer(new a(this, r100, this.f285760f, this.f285762h));     // Catch: Throwable -> L15 Exception -> L17
        if (this.f285756b.size() <= this.f285761g.get()) goto L12;
        this.f285761g.set(this.f285756b.size());     // Catch: Throwable -> L15 Exception -> L17
    L12:
        if (this.f285759e != null) goto L14;
        c();     // Catch: Throwable -> L15 Exception -> L17
    L14:
        this.f285757c.unlock();
        r101 = new StringBuilder("add task: poolname");
    L15:
        th = move-exception;
        this.f285757c.unlock();
        Log.i("CoreThreadPool CoreSerialThreadPool", "add task: poolname" + this.f285762h + ", task size: " + this.f285756b.size());
        throw th;
    }

    public h(String r100, int r101) {
        this.f285755a = new AtomicInteger(-1);
        this.f285756b = new ArrayDeque();
        ReentrantLock r102 = new ReentrantLock();
        this.f285757c = r102;
        this.f285758d = r102.newCondition();
        this.f285759e = null;
        this.f285760f = null;
        this.f285761g = new AtomicInteger(0);
        if (r101 != 2) goto L7;
        this.f285762h = r100 + "_IO_" + Integer.valueOf(f285754i.incrementAndGet()).toString();
        this.f285760f = CoreThreadPool.getDefault().getCachedThreadPool();
        return;
    L7:
        if (r101 != 1) goto L10;
        this.f285762h = r100 + "_CPU_" + Integer.valueOf(f285754i.incrementAndGet()).toString();
        this.f285760f = CoreThreadPool.getDefault().getFixedThreadPool();
        return;
    L10:
        if (r101 != 0) goto L28;
        this.f285762h = r100 + "_HIGH_" + Integer.valueOf(f285754i.incrementAndGet()).toString();
        i r103 = i.f285767m;
        if (r103 == null) goto L15;
    L22:
        this.f285760f = r103;
        ((i) this.f285760f).h(true);
        return;
    L15:
        monitor-enter(i.class);
    L24:
        th = move-exception;
        throw th;
    L17:
        if (i.f285767m != null) goto L19;
        i.f285767m = new i(r100, new LinkedBlockingDeque(128), new n("lk-serial", 0));     // Catch: Throwable -> L24
    L19:
        i r104 = i.f285767m;     // Catch: Throwable -> L24
        r104.f285768h = 300;     // Catch: Throwable -> L24
        r104.f285769i = 500;     // Catch: Throwable -> L24
        r104.f285770j = 400;     // Catch: Throwable -> L24
        monitor-exit(i.class);     // Catch: Throwable -> L24
        r103 = r104;
        goto L22
    L28:
        throw new IllegalArgumentException("Create CoreSerialThreadPool param: serialType illegal!");
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long r100, TimeUnit r101) throws InterruptedException {
        long r102 = r101.toNanos(r100);
        this.f285757c.lock();
    L17:
    L14:
        th = move-exception;
        this.f285757c.unlock();
        throw th;
    L5:
        if (this.f285755a.get() == 1) goto L12;
        if (r102 <= 0) goto L8;
        r102 = this.f285758d.awaitNanos(r102);     // Catch: Throwable -> L14
        goto L17
    L8:
        this.f285757c.unlock();
        return false;
    L12:
        this.f285757c.unlock();
        return true;
    }
}
