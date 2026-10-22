package com.bytedance.caijing.sdk.infra.base.task;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f202770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<a> f202771b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue<CJTask<?>> f202772c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f202773d = null;

    public static final class a extends WeakReference<CJTask<?>> {
        public a(CJTask<?> r100, ReferenceQueue<CJTask<?>> r101) {
            Intrinsics.checkNotNullParameter(r100, "task");
            Intrinsics.checkNotNullParameter(r101, "queue");
            super(r100, r101);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.caijing.sdk.infra.base.task.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes15.dex */
    public static final class RunnableC2945b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJTask<?> f202774a;

        public RunnableC2945b(CJTask<?> r100) {
            this.f202774a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CJTask<?> r100 = this.f202774a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            CJTask.f202763b.getValue().executeCPU(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJTask<?> f202775a;

        public c(CJTask<?> r100) {
            this.f202775a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CJTask<?> r100 = this.f202775a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            CJTask.f202763b.getValue().executeIO(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJTask<?> f202776a;

        public d(CJTask<?> r100) {
            this.f202776a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            CJTask<?> r100 = this.f202776a;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            CJTask.f202763b.getValue().executeLogic(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f202777a;

        public e(Runnable r100) {
            this.f202777a = r100;
        }

        @Override // java.util.concurrent.Callable
        public final void call() {
            this.f202777a.run();
            Handler r100 = b.f202770a;
            if ((b.f202773d.incrementAndGet() % 64) != 0) goto L8;
            Reference<? extends CJTask<?>> r101 = b.f202772c.poll();
        L6:
            if (r101 == null) goto L10;
            TypeIntrinsics.asMutableCollection(b.f202771b).remove(r101);
            r101 = b.f202772c.poll();
            goto L6
        L10:
            return;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            call();
            return Unit.INSTANCE;
        }
    }

    static {
        f202770a = new Handler(Looper.getMainLooper());
        f202771b = new ConcurrentLinkedQueue();
        f202772c = new ReferenceQueue();
        f202773d = new AtomicInteger(0);
    }

    public static /* synthetic */ void b(Runnable r100) {
        a(r100, 0);
    }

    public static /* synthetic */ void d(Runnable r100) {
        c(r100, 0);
    }

    public static /* synthetic */ void f(Runnable r100) {
        e(r100, 0);
    }

    public static CJTask h(Runnable r100) {
        CJTask r101 = new CJTask(new e(r100));
        r101.f202764a = r100;
        f202771b.add(new a(r101, f202772c));
        return r101;
    }

    @JvmStatic
    public static final void i(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        f202770a.post(r100);
    }

    @JvmStatic
    public static final void a(Runnable r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        CJTask r102 = h(r100);
        if (r101 <= 0) goto L5;
        f202770a.postDelayed(new RunnableC2945b(r102), r101);
        return;
    L5:
        CJTask.f202763b.getValue().executeCPU(r102);
    }

    @JvmStatic
    public static final void c(Runnable r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        CJTask r102 = h(r100);
        if (r101 <= 0) goto L5;
        f202770a.postDelayed(new c(r102), r101);
        return;
    L5:
        CJTask.f202763b.getValue().executeIO(r102);
    }

    @JvmStatic
    public static final void e(Runnable r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        CJTask r102 = h(r100);
        if (r101 <= 0) goto L5;
        f202770a.postDelayed(new d(r102), r101);
        return;
    L5:
        CJTask.f202763b.getValue().executeLogic(r102);
    }

    @JvmStatic
    public static final void g(Runnable r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        f202770a.postDelayed(r100, r101);
    }
}
