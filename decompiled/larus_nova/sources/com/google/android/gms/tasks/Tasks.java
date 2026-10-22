package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import dv7.u;
import dv7.v;
import dv7.w;
import dv7.x;
import dv7.y;
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

/* JADX INFO: loaded from: classes23.dex */
public final class Tasks {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch f274662a;

        @Override // dv7.b
        public final void onCanceled() {
            this.f274662a.countDown();
        }

        public a() {
            this.f274662a = new CountDownLatch(1);
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception r100) {
            this.f274662a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object r100) {
            this.f274662a.countDown();
        }
    }

    public interface b extends dv7.b, OnFailureListener, OnSuccessListener<Object> {
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f274663a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f274664b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v<Void> f274665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f274666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f274667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f274668f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Exception f274669g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f274670h;

        public final void a() {
            if (((this.f274666d + this.f274667e) + this.f274668f) == this.f274664b) goto L5;
            return;
        L5:
            if (this.f274669g == null) goto L9;
            v<Void> r100 = this.f274665c;
            int r101 = this.f274667e;
            int r102 = this.f274664b;
            StringBuilder r103 = new StringBuilder(54);
            r103.append(r101);
            r103.append(" out of ");
            r103.append(r102);
            r103.append(" underlying tasks failed");
            r100.a(new ExecutionException(r103.toString(), this.f274669g));
            return;
        L9:
            if (this.f274670h == false) goto L12;
            this.f274665c.b();
            return;
        L12:
            this.f274665c.setResult(null);
        }

        @Override // dv7.b
        public final void onCanceled() {
            Object r100 = this.f274663a;
            monitor-enter(r100);
            this.f274668f++;     // Catch: Throwable -> L7
            this.f274670h = true;     // Catch: Throwable -> L7
            a();     // Catch: Throwable -> L7
            monitor-exit(r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception r100) {
            Object r101 = this.f274663a;
            monitor-enter(r101);
            this.f274667e++;     // Catch: Throwable -> L7
            this.f274669g = r100;     // Catch: Throwable -> L7
            a();     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object r100) {
            Object r101 = this.f274663a;
            monitor-enter(r101);
            this.f274666d++;     // Catch: Throwable -> L7
            a();     // Catch: Throwable -> L7
            monitor-exit(r101);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public c(int r100, v<Void> r101) {
            this.f274663a = new Object();
            this.f274664b = r100;
            this.f274665c = r101;
        }
    }

    private Tasks() {
    }

    public static <TResult> Task<TResult> forCanceled() {
        v r100 = new v();
        r100.b();
        return r100;
    }

    public static <TResult> TResult await(Task<TResult> r100) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(r100, "Task must not be null");
        if (r100.isComplete() == true) goto L5;
        a r101 = new a();
        zza(r100, r101);
        r101.f274662a.await();
        return (TResult) zzb(r100);
    L5:
        return (TResult) zzb(r100);
    }

    public static <TResult> Task<TResult> call(Callable<TResult> r100) {
        return call(dv7.c.f470160a, r100);
    }

    public static <TResult> Task<TResult> forException(Exception r100) {
        v r101 = new v();
        r101.a(r100);
        return r101;
    }

    public static <TResult> Task<TResult> forResult(TResult r100) {
        v r101 = new v();
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
        v r102 = new v();
        c r103 = new c(r100.size(), r102);
        Iterator<? extends Task<?>> r104 = r100.iterator();
    L16:
        if (r104.hasNext() == false) goto L18;
        zza(r104.next(), r103);
        goto L16
    L18:
        return r102;
    L5:
        return forResult(null);
    }

    public static Task<List<Task<?>>> whenAllComplete(Collection<? extends Task<?>> r100) {
        return whenAll(r100).continueWithTask(new y(r100));
    }

    public static <TResult> Task<List<TResult>> whenAllSuccess(Collection<? extends Task<?>> r100) {
        return (Task<List<TResult>>) whenAll(r100).continueWith(new x(r100));
    }

    private static <TResult> TResult zzb(Task<TResult> r100) throws ExecutionException {
        if (r100.isSuccessful() == false) goto L7;
        return r100.getResult();
    L7:
        if (r100.isCanceled() == false) goto L11;
        throw new CancellationException("Task is already canceled");
    L11:
        throw new ExecutionException(r100.getException());
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

    public static <TResult> Task<TResult> call(Executor r100, Callable<TResult> r101) {
        Preconditions.checkNotNull(r100, "Executor must not be null");
        Preconditions.checkNotNull(r101, "Callback must not be null");
        v r102 = new v();
        r100.execute(new w(r102, r101));
        return r102;
    }

    private static void zza(Task<?> r100, b r101) {
        u r102 = dv7.c.f470161b;
        r100.addOnSuccessListener(r102, r101);
        r100.addOnFailureListener(r102, r101);
        r100.addOnCanceledListener(r102, r101);
    }

    public static <TResult> TResult await(Task<TResult> r100, long r101, TimeUnit r102) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(r100, "Task must not be null");
        Preconditions.checkNotNull(r102, "TimeUnit must not be null");
        if (r100.isComplete() == true) goto L5;
        a r103 = new a();
        zza(r100, r103);
        if (r103.f274662a.await(r101, r102) == false) goto L11;
        return (TResult) zzb(r100);
    L11:
        throw new TimeoutException("Timed out waiting for Task");
    L5:
        return (TResult) zzb(r100);
    }
}
