package com.oplus.ocs.base.task;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes34.dex */
public class Tasks {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f404263a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private TaskImpl<Void> f404264b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Exception f404265c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile int f404266d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private volatile int f404267e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private volatile int f404268f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private volatile int f404269g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private volatile boolean f404270h;

        private void a() {
            Object r100 = this.f404263a;
            monitor-enter(r100);
        L17:
            th = move-exception;
            throw th;
        L5:
            if (((this.f404267e + this.f404268f) + this.f404269g) == this.f404266d) goto L9;
            monitor-exit(r100);     // Catch: Throwable -> L17
            return;
        L9:
            if (this.f404265c == null) goto L12;
            this.f404264b.setException(new ExecutionException(this.f404268f + " out of " + this.f404266d + " underlying tasks failed", this.f404265c));     // Catch: Throwable -> L17
        L15:
            monitor-exit(r100);     // Catch: Throwable -> L17
            return;
        L12:
            if (this.f404270h == false) goto L14;
            this.f404264b.tryCancel();     // Catch: Throwable -> L17
            goto L15
        L14:
            this.f404264b.setResult(null);     // Catch: Throwable -> L17
            goto L15
        }

        @Override // com.oplus.ocs.base.task.OnCanceledListener
        public final void onCanceled() {
            Object r100 = this.f404263a;
            monitor-enter(r100);
            this.f404269g++;     // Catch: Throwable -> L7
            this.f404270h = true;     // Catch: Throwable -> L7
            a();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.oplus.ocs.base.task.OnFailureListener
        public final void onFailure(Exception r100) {
            com.oplus.ocs.base.utils.d.a(r100);
            Object r101 = this.f404263a;
            monitor-enter(r101);
            this.f404268f++;     // Catch: Throwable -> L7
            this.f404265c = r100;     // Catch: Throwable -> L7
            a();     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.oplus.ocs.base.task.OnSuccessListener
        public final void onSuccess(Object r100) {
            Object r101 = this.f404263a;
            monitor-enter(r101);
            this.f404267e++;     // Catch: Throwable -> L7
            a();     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public a(int r100, TaskImpl<Void> r101) {
            this.f404263a = new Object();
            this.f404266d = r100;
            this.f404264b = r101;
        }
    }

    public static class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CountDownLatch f404271a;

        @Override // com.oplus.ocs.base.task.OnCanceledListener
        public final void onCanceled() {
            this.f404271a.countDown();
        }

        private b() {
            this.f404271a = new CountDownLatch(1);
        }

        public b(byte r100) {
            this();
        }

        @Override // com.oplus.ocs.base.task.OnFailureListener
        public final void onFailure(Exception r100) {
            this.f404271a.countDown();
        }

        @Override // com.oplus.ocs.base.task.OnSuccessListener
        public final void onSuccess(Object r100) {
            this.f404271a.countDown();
        }
    }

    public interface c extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    public static <TResult> Task<TResult> forCanceled() {
        TaskImpl r100 = new TaskImpl();
        r100.tryCancel();
        return r100;
    }

    private Tasks() {
    }

    private static <TResult> TResult a(Task<TResult> r100) throws ExecutionException {
        if (r100.isSuccessful() == false) goto L7;
        return r100.getResult();
    L7:
        if (r100.isCanceled() == false) goto L11;
        throw new CancellationException("Task is already canceled");
    L11:
        throw new ExecutionException(r100.getException());
    }

    public static <TResult> TResult await(Task<TResult> r100) throws ExecutionException, InterruptedException {
        com.oplus.ocs.base.utils.d.b("Must not be called on the main application thread");
        com.oplus.ocs.base.utils.d.a(r100, "Task must not be null");
        if (r100.isComplete() == true) goto L5;
        b r101 = new b((byte) 0);
        a(r100, r101);
        r101.f404271a.await();
        return (TResult) a(r100);
    L5:
        return (TResult) a(r100);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> r100) {
        com.oplus.ocs.base.utils.d.a(r100);
        return call(TaskExecutors.MAIN_THREAD, r100);
    }

    public static <TResult> Task<TResult> forException(Exception r100) {
        com.oplus.ocs.base.utils.d.a(r100);
        TaskImpl r101 = new TaskImpl();
        r101.setException(r100);
        return r101;
    }

    public static <TResult> Task<TResult> forResult(TResult r100) {
        TaskImpl r101 = new TaskImpl();
        r101.setResult(r100);
        return r101;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> r100) {
        if (r100.isEmpty() == true) goto L5;
        Iterator<? extends Task<?>> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L14;
        if (r101.next() != null) goto L8;
        throw new NullPointerException("null tasks are not accepted");
    L14:
        TaskImpl r102 = new TaskImpl();
        a r103 = new a(r100.size(), r102);
        Iterator<? extends Task<?>> r104 = r100.iterator();
    L16:
        if (r104.hasNext() == false) goto L18;
        a(r104.next(), r103);
        goto L16
    L18:
        return r102;
    L5:
        return forResult(null);
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> r100) {
        return whenAll(r100).continueWithTask(new o(r100));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> r100) {
        return (Task<List<TResult>>) whenAll(r100).continueWith(new p(r100));
    }

    public static Task<Void> whenAll(Task<?>... r100) {
        if (r100.length != 0) goto L7;
        return forResult(null);
    L7:
        return whenAll(Arrays.asList(r100));
    }

    public static Task<List<Task<?>>> whenAllComplete(Task<?>... r100) {
        return whenAllComplete(Arrays.asList(r100));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Task<?>... r100) {
        return whenAllSuccess(Arrays.asList(r100));
    }

    private static <TResult> void a(Task<TResult> r100, c r101) {
        Executor r102 = TaskExecutors.CURRENT_THREAD;
        r100.addOnSuccessListener(r102, r101);
        r100.addOnFailureListener(r102, r101);
        r100.addOnCanceledListener(r102, r101);
    }

    public static <TResult> Task<TResult> call(Executor r100, Callable<TResult> r101) {
        com.oplus.ocs.base.utils.d.a(r100, "Executor must not be null");
        com.oplus.ocs.base.utils.d.a(r101, "Callback must not be null");
        TaskImpl r102 = new TaskImpl();
        r100.execute(new com.oplus.ocs.base.task.a(r102, r101));
        return r102;
    }

    public static <TResult> TResult await(Task<TResult> r100, long r101, TimeUnit r102) throws ExecutionException, InterruptedException, TimeoutException {
        com.oplus.ocs.base.utils.d.b("Must not be called on the main application thread");
        com.oplus.ocs.base.utils.d.a(r100, "Task must not be null");
        com.oplus.ocs.base.utils.d.a(r102, "TimeUnit must not be null");
        if (r100.isComplete() == true) goto L5;
        b r103 = new b((byte) 0);
        a(r100, r103);
        if (r103.f404271a.await(r101, r102) == false) goto L11;
        return (TResult) a(r100);
    L11:
        throw new TimeoutException("Timed out waiting for Task");
    L5:
        return (TResult) a(r100);
    }
}
