package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.operators.observable.ObservableRefCount;
import io.reactivex.internal.operators.observable.i;
import io.reactivex.internal.util.e;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<T> extends Observable<T> {
    public Observable<T> autoConnect() {
        return autoConnect(1);
    }

    public abstract void connect(Consumer<? super Disposable> r100);

    public final Disposable connect() {
        e r100 = new e();
        connect(r100);
        return r100.f495050a;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public Observable<T> refCount() {
        return RxJavaPlugins.onAssembly(new ObservableRefCount(this, 1, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline()));
    }

    public a() {
    }

    public Observable<T> autoConnect(int r100) {
        return autoConnect(r100, Functions.emptyConsumer());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Observable<T> refCount(int r100) {
        return refCount(r100, 0, TimeUnit.NANOSECONDS, Schedulers.trampoline());
    }

    public Observable<T> autoConnect(int r100, Consumer<? super Disposable> r101) {
        if (r100 > 0) goto L6;
        connect(r101);
        return RxJavaPlugins.onAssembly(this);
    L6:
        return RxJavaPlugins.onAssembly(new i(this, r100, r101));
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> refCount(long r100, TimeUnit r101) {
        return refCount(1, r100, r101, Schedulers.computation());
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Observable<T> refCount(int r100, long r101, TimeUnit r110) {
        return refCount(r100, r101, r110, Schedulers.computation());
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> refCount(long r100, TimeUnit r101, Scheduler r110) {
        return refCount(1, r100, r101, r110);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Observable<T> refCount(int r100, long r110, TimeUnit r111, Scheduler r112) {
        ObjectHelper.verifyPositive(r100, "subscriberCount");
        ObjectHelper.requireNonNull(r111, "unit is null");
        ObjectHelper.requireNonNull(r112, "scheduler is null");
        return RxJavaPlugins.onAssembly(new ObservableRefCount(this, r100, r110, r111, r112));
    }
}
