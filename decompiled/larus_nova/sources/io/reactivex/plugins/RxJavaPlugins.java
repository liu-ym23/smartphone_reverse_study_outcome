package io.reactivex.plugins;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.schedulers.e;
import io.reactivex.internal.schedulers.f;
import io.reactivex.internal.schedulers.j;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.k;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadFactory;
import stc.a;
import ttc.b;

/* JADX INFO: loaded from: classes41.dex */
public final class RxJavaPlugins {
    static volatile Consumer<? super Throwable> errorHandler;
    static volatile boolean failNonBlockingScheduler;
    static volatile boolean lockdown;
    static volatile b onBeforeBlocking;
    static volatile Function<? super Completable, ? extends Completable> onCompletableAssembly;
    static volatile BiFunction<? super Completable, ? super io.reactivex.b, ? extends io.reactivex.b> onCompletableSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onComputationHandler;
    static volatile Function<? super a, ? extends a> onConnectableFlowableAssembly;
    static volatile Function<? super io.reactivex.observables.a, ? extends io.reactivex.observables.a> onConnectableObservableAssembly;
    static volatile Function<? super Flowable, ? extends Flowable> onFlowableAssembly;
    static volatile BiFunction<? super Flowable, ? super wwc.b, ? extends wwc.b> onFlowableSubscribe;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitComputationHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitIoHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitNewThreadHandler;
    static volatile Function<? super Callable<Scheduler>, ? extends Scheduler> onInitSingleHandler;
    static volatile Function<? super Scheduler, ? extends Scheduler> onIoHandler;
    static volatile Function<? super Maybe, ? extends Maybe> onMaybeAssembly;
    static volatile BiFunction<? super Maybe, ? super k, ? extends k> onMaybeSubscribe;
    static volatile Function<? super Scheduler, ? extends Scheduler> onNewThreadHandler;
    static volatile Function<? super Observable, ? extends Observable> onObservableAssembly;
    static volatile BiFunction<? super Observable, ? super Observer, ? extends Observer> onObservableSubscribe;
    static volatile Function<? super wtc.a, ? extends wtc.a> onParallelAssembly;
    static volatile Function<? super Runnable, ? extends Runnable> onScheduleHandler;
    static volatile Function<? super Single, ? extends Single> onSingleAssembly;
    static volatile Function<? super Scheduler, ? extends Scheduler> onSingleHandler;
    static volatile BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> onSingleSubscribe;

    public static void lockdown() {
        lockdown = true;
    }

    public static void reset() {
        setErrorHandler(null);
        setScheduleHandler(null);
        setComputationSchedulerHandler(null);
        setInitComputationSchedulerHandler(null);
        setIoSchedulerHandler(null);
        setInitIoSchedulerHandler(null);
        setSingleSchedulerHandler(null);
        setInitSingleSchedulerHandler(null);
        setNewThreadSchedulerHandler(null);
        setInitNewThreadSchedulerHandler(null);
        setOnFlowableAssembly(null);
        setOnFlowableSubscribe(null);
        setOnObservableAssembly(null);
        setOnObservableSubscribe(null);
        setOnSingleAssembly(null);
        setOnSingleSubscribe(null);
        setOnCompletableAssembly(null);
        setOnCompletableSubscribe(null);
        setOnConnectableFlowableAssembly(null);
        setOnConnectableObservableAssembly(null);
        setOnMaybeAssembly(null);
        setOnMaybeSubscribe(null);
        setOnParallelAssembly(null);
        setFailOnNonBlockingScheduler(false);
        setOnBeforeBlocking(null);
    }

    public static void unlock() {
        lockdown = false;
    }

    public static boolean onBeforeBlocking() {
        b r100 = onBeforeBlocking;
        if (r100 != null) goto L11;
        return false;
    L11:
        return r100.getAsBoolean();
    L6:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    private RxJavaPlugins() {
        throw new IllegalStateException("No instances!");
    }

    public static Function<? super Scheduler, ? extends Scheduler> getComputationSchedulerHandler() {
        return onComputationHandler;
    }

    public static Consumer<? super Throwable> getErrorHandler() {
        return errorHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitComputationSchedulerHandler() {
        return onInitComputationHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitIoSchedulerHandler() {
        return onInitIoHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitNewThreadSchedulerHandler() {
        return onInitNewThreadHandler;
    }

    public static Function<? super Callable<Scheduler>, ? extends Scheduler> getInitSingleSchedulerHandler() {
        return onInitSingleHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getIoSchedulerHandler() {
        return onIoHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getNewThreadSchedulerHandler() {
        return onNewThreadHandler;
    }

    public static b getOnBeforeBlocking() {
        return onBeforeBlocking;
    }

    public static Function<? super Completable, ? extends Completable> getOnCompletableAssembly() {
        return onCompletableAssembly;
    }

    public static BiFunction<? super Completable, ? super io.reactivex.b, ? extends io.reactivex.b> getOnCompletableSubscribe() {
        return onCompletableSubscribe;
    }

    public static Function<? super a, ? extends a> getOnConnectableFlowableAssembly() {
        return onConnectableFlowableAssembly;
    }

    public static Function<? super io.reactivex.observables.a, ? extends io.reactivex.observables.a> getOnConnectableObservableAssembly() {
        return onConnectableObservableAssembly;
    }

    public static Function<? super Flowable, ? extends Flowable> getOnFlowableAssembly() {
        return onFlowableAssembly;
    }

    public static BiFunction<? super Flowable, ? super wwc.b, ? extends wwc.b> getOnFlowableSubscribe() {
        return onFlowableSubscribe;
    }

    public static Function<? super Maybe, ? extends Maybe> getOnMaybeAssembly() {
        return onMaybeAssembly;
    }

    public static BiFunction<? super Maybe, ? super k, ? extends k> getOnMaybeSubscribe() {
        return onMaybeSubscribe;
    }

    public static Function<? super Observable, ? extends Observable> getOnObservableAssembly() {
        return onObservableAssembly;
    }

    public static BiFunction<? super Observable, ? super Observer, ? extends Observer> getOnObservableSubscribe() {
        return onObservableSubscribe;
    }

    public static Function<? super wtc.a, ? extends wtc.a> getOnParallelAssembly() {
        return onParallelAssembly;
    }

    public static Function<? super Single, ? extends Single> getOnSingleAssembly() {
        return onSingleAssembly;
    }

    public static BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> getOnSingleSubscribe() {
        return onSingleSubscribe;
    }

    public static Function<? super Runnable, ? extends Runnable> getScheduleHandler() {
        return onScheduleHandler;
    }

    public static Function<? super Scheduler, ? extends Scheduler> getSingleSchedulerHandler() {
        return onSingleHandler;
    }

    public static boolean isFailOnNonBlockingScheduler() {
        return failNonBlockingScheduler;
    }

    public static boolean isLockdown() {
        return lockdown;
    }

    public static Scheduler callRequireNonNull(Callable<Scheduler> r100) {
        return (Scheduler) ObjectHelper.requireNonNull(r100.call(), "Scheduler Callable result can't be null");
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static Scheduler createComputationScheduler(ThreadFactory r100) {
        return new io.reactivex.internal.schedulers.a((ThreadFactory) ObjectHelper.requireNonNull(r100, "threadFactory is null"));
    }

    public static Scheduler createIoScheduler(ThreadFactory r100) {
        return new e((ThreadFactory) ObjectHelper.requireNonNull(r100, "threadFactory is null"));
    }

    public static Scheduler createNewThreadScheduler(ThreadFactory r100) {
        return new f((ThreadFactory) ObjectHelper.requireNonNull(r100, "threadFactory is null"));
    }

    public static Scheduler createSingleScheduler(ThreadFactory r100) {
        return new j((ThreadFactory) ObjectHelper.requireNonNull(r100, "threadFactory is null"));
    }

    public static Scheduler initComputationScheduler(Callable<Scheduler> r100) {
        ObjectHelper.requireNonNull(r100, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r101 = onInitComputationHandler;
        if (r101 != null) goto L7;
        return callRequireNonNull(r100);
    L7:
        return applyRequireNonNull(r101, r100);
    }

    public static Scheduler initIoScheduler(Callable<Scheduler> r100) {
        ObjectHelper.requireNonNull(r100, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r101 = onInitIoHandler;
        if (r101 != null) goto L7;
        return callRequireNonNull(r100);
    L7:
        return applyRequireNonNull(r101, r100);
    }

    public static Scheduler initNewThreadScheduler(Callable<Scheduler> r100) {
        ObjectHelper.requireNonNull(r100, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r101 = onInitNewThreadHandler;
        if (r101 != null) goto L7;
        return callRequireNonNull(r100);
    L7:
        return applyRequireNonNull(r101, r100);
    }

    public static Scheduler initSingleScheduler(Callable<Scheduler> r100) {
        ObjectHelper.requireNonNull(r100, "Scheduler Callable can't be null");
        Function<? super Callable<Scheduler>, ? extends Scheduler> r101 = onInitSingleHandler;
        if (r101 != null) goto L7;
        return callRequireNonNull(r100);
    L7:
        return applyRequireNonNull(r101, r100);
    }

    public static boolean isBug(Throwable r100) {
        if ((r100 instanceof OnErrorNotImplementedException) == false) goto L6;
        return true;
    L6:
        if ((r100 instanceof MissingBackpressureException) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof IllegalStateException) == false) goto L12;
        return true;
    L12:
        if ((r100 instanceof NullPointerException) == false) goto L15;
        return true;
    L15:
        if ((r100 instanceof IllegalArgumentException) == false) goto L18;
        return true;
    L18:
        if ((r100 instanceof CompositeException) == false) goto L20;
        return true;
    L20:
        return false;
    }

    public static Completable onAssembly(Completable r100) {
        Function<? super Completable, ? extends Completable> r101 = onCompletableAssembly;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return (Completable) apply(r101, r100);
    }

    public static Scheduler onComputationScheduler(Scheduler r100) {
        Function<? super Scheduler, ? extends Scheduler> r101 = onComputationHandler;
        if (r101 != null) goto L6;
        return r100;
    L6:
        return (Scheduler) apply(r101, r100);
    }

    public static void onError(Throwable r100) {
        Consumer<? super Throwable> r101 = errorHandler;
        if (r100 != null) goto L6;
        r100 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L8:
        if (r101 != null) goto L15;
    L13:
        r100.printStackTrace();
        uncaught(r100);
        return;
    L15:
        r101.accept(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        uncaught(th);
        goto L13
    L6:
        if (isBug(r100) == true) goto L8;
        r100 = new UndeliverableException(r100);
        goto L8
    }

    public static Scheduler onIoScheduler(Scheduler r100) {
        Function<? super Scheduler, ? extends Scheduler> r101 = onIoHandler;
        if (r101 != null) goto L6;
        return r100;
    L6:
        return (Scheduler) apply(r101, r100);
    }

    public static Scheduler onNewThreadScheduler(Scheduler r100) {
        Function<? super Scheduler, ? extends Scheduler> r101 = onNewThreadHandler;
        if (r101 != null) goto L6;
        return r100;
    L6:
        return (Scheduler) apply(r101, r100);
    }

    public static Runnable onSchedule(Runnable r100) {
        ObjectHelper.requireNonNull(r100, "run is null");
        Function<? super Runnable, ? extends Runnable> r101 = onScheduleHandler;
        if (r101 != null) goto L6;
        return r100;
    L6:
        return (Runnable) apply(r101, r100);
    }

    public static Scheduler onSingleScheduler(Scheduler r100) {
        Function<? super Scheduler, ? extends Scheduler> r101 = onSingleHandler;
        if (r101 != null) goto L6;
        return r100;
    L6:
        return (Scheduler) apply(r101, r100);
    }

    public static void setComputationSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> r100) {
        if (lockdown == true) goto L7;
        onComputationHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setErrorHandler(Consumer<? super Throwable> r100) {
        if (lockdown == true) goto L7;
        errorHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setFailOnNonBlockingScheduler(boolean r100) {
        if (lockdown == true) goto L7;
        failNonBlockingScheduler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitComputationSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> r100) {
        if (lockdown == true) goto L7;
        onInitComputationHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitIoSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> r100) {
        if (lockdown == true) goto L7;
        onInitIoHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitNewThreadSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> r100) {
        if (lockdown == true) goto L7;
        onInitNewThreadHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setInitSingleSchedulerHandler(Function<? super Callable<Scheduler>, ? extends Scheduler> r100) {
        if (lockdown == true) goto L7;
        onInitSingleHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setIoSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> r100) {
        if (lockdown == true) goto L7;
        onIoHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setNewThreadSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> r100) {
        if (lockdown == true) goto L7;
        onNewThreadHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnBeforeBlocking(b r100) {
        if (lockdown == true) goto L7;
        onBeforeBlocking = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableAssembly(Function<? super Completable, ? extends Completable> r100) {
        if (lockdown == true) goto L7;
        onCompletableAssembly = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnCompletableSubscribe(BiFunction<? super Completable, ? super io.reactivex.b, ? extends io.reactivex.b> r100) {
        if (lockdown == true) goto L7;
        onCompletableSubscribe = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableFlowableAssembly(Function<? super a, ? extends a> r100) {
        if (lockdown == true) goto L7;
        onConnectableFlowableAssembly = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnConnectableObservableAssembly(Function<? super io.reactivex.observables.a, ? extends io.reactivex.observables.a> r100) {
        if (lockdown == true) goto L7;
        onConnectableObservableAssembly = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableAssembly(Function<? super Flowable, ? extends Flowable> r100) {
        if (lockdown == true) goto L7;
        onFlowableAssembly = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnFlowableSubscribe(BiFunction<? super Flowable, ? super wwc.b, ? extends wwc.b> r100) {
        if (lockdown == true) goto L7;
        onFlowableSubscribe = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeAssembly(Function<? super Maybe, ? extends Maybe> r100) {
        if (lockdown == true) goto L7;
        onMaybeAssembly = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnMaybeSubscribe(BiFunction<? super Maybe, k, ? extends k> r100) {
        if (lockdown == true) goto L7;
        onMaybeSubscribe = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableAssembly(Function<? super Observable, ? extends Observable> r100) {
        if (lockdown == true) goto L7;
        onObservableAssembly = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnObservableSubscribe(BiFunction<? super Observable, ? super Observer, ? extends Observer> r100) {
        if (lockdown == true) goto L7;
        onObservableSubscribe = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnParallelAssembly(Function<? super wtc.a, ? extends wtc.a> r100) {
        if (lockdown == true) goto L7;
        onParallelAssembly = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleAssembly(Function<? super Single, ? extends Single> r100) {
        if (lockdown == true) goto L7;
        onSingleAssembly = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setOnSingleSubscribe(BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> r100) {
        if (lockdown == true) goto L7;
        onSingleSubscribe = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setScheduleHandler(Function<? super Runnable, ? extends Runnable> r100) {
        if (lockdown == true) goto L7;
        onScheduleHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void setSingleSchedulerHandler(Function<? super Scheduler, ? extends Scheduler> r100) {
        if (lockdown == true) goto L7;
        onSingleHandler = r100;
        return;
    L7:
        throw new IllegalStateException("Plugins can't be changed anymore");
    }

    public static void uncaught(Throwable r100) {
        Thread r101 = ThreadMethodProxy.currentThread();
        r101.getUncaughtExceptionHandler().uncaughtException(r101, r100);
    }

    public static <T> Flowable<T> onAssembly(Flowable<T> r100) {
        Function<? super Flowable, ? extends Flowable> r101 = onFlowableAssembly;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return (Flowable) apply(r101, r100);
    }

    public static <T> Maybe<T> onAssembly(Maybe<T> r100) {
        Function<? super Maybe, ? extends Maybe> r101 = onMaybeAssembly;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return (Maybe) apply(r101, r100);
    }

    public static <T> Observable<T> onAssembly(Observable<T> r100) {
        Function<? super Observable, ? extends Observable> r101 = onObservableAssembly;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return (Observable) apply(r101, r100);
    }

    public static <T> Single<T> onAssembly(Single<T> r100) {
        Function<? super Single, ? extends Single> r101 = onSingleAssembly;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return (Single) apply(r101, r100);
    }

    public static <T> io.reactivex.observables.a<T> onAssembly(io.reactivex.observables.a<T> r100) {
        Function<? super io.reactivex.observables.a, ? extends io.reactivex.observables.a> r101 = onConnectableObservableAssembly;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return (io.reactivex.observables.a) apply(r101, r100);
    }

    public static <T> a<T> onAssembly(a<T> r100) {
        Function<? super a, ? extends a> r101 = onConnectableFlowableAssembly;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return (a) apply(r101, r100);
    }

    public static <T> wtc.a<T> onAssembly(wtc.a<T> r100) {
        Function<? super wtc.a, ? extends wtc.a> r101 = onParallelAssembly;
        if (r101 != null) goto L5;
        return r100;
    L5:
        return (wtc.a) apply(r101, r100);
    }

    public static <T, R> R apply(Function<T, R> r100, T r101) {
        return r100.apply(r101);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }

    public static Scheduler applyRequireNonNull(Function<? super Callable<Scheduler>, ? extends Scheduler> r100, Callable<Scheduler> r101) {
        return (Scheduler) ObjectHelper.requireNonNull(apply(r100, r101), "Scheduler Callable result can't be null");
    }

    public static <T> Observer<? super T> onSubscribe(Observable<T> r100, Observer<? super T> r101) {
        BiFunction<? super Observable, ? super Observer, ? extends Observer> r102 = onObservableSubscribe;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return (Observer) apply(r102, r100, r101);
    }

    public static <T> SingleObserver<? super T> onSubscribe(Single<T> r100, SingleObserver<? super T> r101) {
        BiFunction<? super Single, ? super SingleObserver, ? extends SingleObserver> r102 = onSingleSubscribe;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return (SingleObserver) apply(r102, r100, r101);
    }

    public static io.reactivex.b onSubscribe(Completable r100, io.reactivex.b r101) {
        BiFunction<? super Completable, ? super io.reactivex.b, ? extends io.reactivex.b> r102 = onCompletableSubscribe;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return (io.reactivex.b) apply(r102, r100, r101);
    }

    public static <T> k<? super T> onSubscribe(Maybe<T> r100, k<? super T> r101) {
        BiFunction<? super Maybe, ? super k, ? extends k> r102 = onMaybeSubscribe;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return (k) apply(r102, r100, r101);
    }

    public static <T> wwc.b<? super T> onSubscribe(Flowable<T> r100, wwc.b<? super T> r101) {
        BiFunction<? super Flowable, ? super wwc.b, ? extends wwc.b> r102 = onFlowableSubscribe;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return (wwc.b) apply(r102, r100, r101);
    }

    public static <T, U, R> R apply(BiFunction<T, U, R> r100, T r101, U r102) {
        return r100.apply(r101, r102);
    L4:
        th = move-exception;
        throw ExceptionHelper.d(th);
    }
}
