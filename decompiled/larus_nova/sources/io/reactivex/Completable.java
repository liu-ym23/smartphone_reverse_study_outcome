package io.reactivex;

import com.bytedance.pia.core.metrics.ErrorType;
import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableCache;
import io.reactivex.internal.operators.completable.CompletableConcat;
import io.reactivex.internal.operators.completable.CompletableConcatArray;
import io.reactivex.internal.operators.completable.CompletableConcatIterable;
import io.reactivex.internal.operators.completable.CompletableCreate;
import io.reactivex.internal.operators.completable.CompletableDelay;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableMerge;
import io.reactivex.internal.operators.completable.CompletableMergeArray;
import io.reactivex.internal.operators.completable.CompletableMergeIterable;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.completable.CompletableSubscribeOn;
import io.reactivex.internal.operators.completable.CompletableTakeUntilCompletable;
import io.reactivex.internal.operators.completable.CompletableTimer;
import io.reactivex.internal.operators.completable.CompletableUsing;
import io.reactivex.internal.operators.completable.a0;
import io.reactivex.internal.operators.completable.u;
import io.reactivex.internal.operators.completable.v;
import io.reactivex.internal.operators.completable.x;
import io.reactivex.internal.operators.completable.y;
import io.reactivex.internal.operators.completable.z;
import io.reactivex.internal.operators.maybe.MaybeDelayWithCompletable;
import io.reactivex.internal.operators.maybe.w;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import io.reactivex.internal.operators.mixed.CompletableAndThenPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public abstract class Completable implements CompletableSource {
    public Completable() {
    }

    public abstract void subscribeActual(b r100);

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable complete() {
        return RxJavaPlugins.onAssembly(io.reactivex.internal.operators.completable.f.f492969a);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable never() {
        return RxJavaPlugins.onAssembly(u.f492994a);
    }

    @SchedulerSupport("none")
    public final void blockingAwait() {
        io.reactivex.internal.observers.f r100 = new io.reactivex.internal.observers.f();
        subscribe(r100);
        r100.a();
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Throwable blockingGet() {
        io.reactivex.internal.observers.f r100 = new io.reactivex.internal.observers.f();
        subscribe(r100);
        if (r100.getCount() == 0) goto L9;
        io.reactivex.internal.util.c.b();     // Catch: InterruptedException -> L6
        r100.await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        r100.b();
        return e;
    L9:
        return r100.f492877b;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable cache() {
        return RxJavaPlugins.onAssembly(new CompletableCache(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable hide() {
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.p(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<o<T>> materialize() {
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.r(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onTerminateDetach() {
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.c(this));
    }

    @SchedulerSupport("none")
    public final Disposable subscribe() {
        EmptyCompletableObserver r100 = new EmptyCompletableObserver();
        subscribe(r100);
        return r100;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<Void> test() {
        TestObserver<Void> r100 = new TestObserver();
        subscribe(r100);
        return r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> toFlowable() {
        if ((this instanceof vtc.b) == false) goto L7;
        return ((vtc.b) this).b();
    L7:
        return RxJavaPlugins.onAssembly(new y(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Maybe<T> toMaybe() {
        if ((this instanceof vtc.c) == false) goto L7;
        return ((vtc.c) this).a();
    L7:
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.maybe.q(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> toObservable() {
        if ((this instanceof vtc.d) == false) goto L7;
        return ((vtc.d) this).c();
    L7:
        return RxJavaPlugins.onAssembly(new z(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorComplete() {
        return onErrorComplete(Functions.alwaysTrue());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeat() {
        return fromPublisher(toFlowable().repeat());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry() {
        return fromPublisher(toFlowable().retry());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable amb(Iterable<? extends CompletableSource> r100) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.a(null, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable ambArray(CompletableSource... r100) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        if (r100.length != 0) goto L7;
        return complete();
    L7:
        if (r100.length != 1) goto L11;
        return wrap(r100[0]);
    L11:
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.a(r100, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable concat(Iterable<? extends CompletableSource> r100) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableConcatIterable(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable concatArray(CompletableSource... r100) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        if (r100.length != 0) goto L7;
        return complete();
    L7:
        if (r100.length != 1) goto L11;
        return wrap(r100[0]);
    L11:
        return RxJavaPlugins.onAssembly(new CompletableConcatArray(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable create(CompletableOnSubscribe r100) {
        ObjectHelper.requireNonNull(r100, "source is null");
        return RxJavaPlugins.onAssembly(new CompletableCreate(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable defer(Callable<? extends CompletableSource> r100) {
        ObjectHelper.requireNonNull(r100, "completableSupplier");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.b(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable error(Throwable r100) {
        ObjectHelper.requireNonNull(r100, "error is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.g(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromAction(Action r100) {
        ObjectHelper.requireNonNull(r100, "run is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.i(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromCallable(Callable<?> r100) {
        ObjectHelper.requireNonNull(r100, "callable is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.j(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromFuture(Future<?> r100) {
        ObjectHelper.requireNonNull(r100, "future is null");
        return fromAction(Functions.futureAction(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Completable fromMaybe(MaybeSource<T> r100) {
        ObjectHelper.requireNonNull(r100, "maybe is null");
        return RxJavaPlugins.onAssembly(new w(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Completable fromObservable(ObservableSource<T> r100) {
        ObjectHelper.requireNonNull(r100, "observable is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.k(r100));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static <T> Completable fromPublisher(Publisher<T> r100) {
        ObjectHelper.requireNonNull(r100, "publisher is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.l(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable fromRunnable(Runnable r100) {
        ObjectHelper.requireNonNull(r100, "run is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.m(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <T> Completable fromSingle(SingleSource<T> r100) {
        ObjectHelper.requireNonNull(r100, "single is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.n(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable merge(Iterable<? extends CompletableSource> r100) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        return RxJavaPlugins.onAssembly(new CompletableMergeIterable(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeArray(CompletableSource... r100) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        if (r100.length != 0) goto L7;
        return complete();
    L7:
        if (r100.length != 1) goto L11;
        return wrap(r100[0]);
    L11:
        return RxJavaPlugins.onAssembly(new CompletableMergeArray(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeArrayDelayError(CompletableSource... r100) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.s(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable mergeDelayError(Iterable<? extends CompletableSource> r100) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.t(r100));
    }

    private static NullPointerException toNpe(Throwable r100) {
        NullPointerException r101 = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        r101.initCause(r100);
        return r101;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable unsafeCreate(CompletableSource r100) {
        ObjectHelper.requireNonNull(r100, "source is null");
        if ((r100 instanceof Completable) == true) goto L7;
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.o(r100));
    L7:
        throw new IllegalArgumentException("Use of unsafeCreate(Completable)!");
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable wrap(CompletableSource r100) {
        ObjectHelper.requireNonNull(r100, "source is null");
        if ((r100 instanceof Completable) == false) goto L7;
        return RxJavaPlugins.onAssembly((Completable) r100);
    L7:
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.o(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable ambWith(CompletableSource r100) {
        ObjectHelper.requireNonNull(r100, "other is null");
        return ambArray(new CompletableSource[]{this, r100});
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable andThen(CompletableSource r100) {
        ObjectHelper.requireNonNull(r100, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenCompletable(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <R> R as(a<? extends R> r100) {
        return (R) ((a) ObjectHelper.requireNonNull(r100, "converter is null")).apply(this);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable compose(d r100) {
        return wrap(((d) ObjectHelper.requireNonNull(r100, "transformer is null")).apply(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable concatWith(CompletableSource r100) {
        ObjectHelper.requireNonNull(r100, "other is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenCompletable(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doAfterTerminate(Action r100) {
        Consumer<? super Disposable> r101 = Functions.emptyConsumer();
        Consumer<? super Throwable> r102 = Functions.emptyConsumer();
        Action r103 = Functions.EMPTY_ACTION;
        return doOnLifecycle(r101, r102, r103, r103, r100, r103);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doFinally(Action r100) {
        ObjectHelper.requireNonNull(r100, "onFinally is null");
        return RxJavaPlugins.onAssembly(new CompletableDoFinally(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnComplete(Action r100) {
        Consumer<? super Disposable> r101 = Functions.emptyConsumer();
        Consumer<? super Throwable> r102 = Functions.emptyConsumer();
        Action r103 = Functions.EMPTY_ACTION;
        return doOnLifecycle(r101, r102, r100, r103, r103, r103);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnDispose(Action r100) {
        Consumer<? super Disposable> r101 = Functions.emptyConsumer();
        Consumer<? super Throwable> r102 = Functions.emptyConsumer();
        Action r103 = Functions.EMPTY_ACTION;
        return doOnLifecycle(r101, r102, r103, r103, r103, r100);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnError(Consumer<? super Throwable> r100) {
        Consumer<? super Disposable> r101 = Functions.emptyConsumer();
        Action r102 = Functions.EMPTY_ACTION;
        return doOnLifecycle(r101, r100, r102, r102, r102, r102);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnEvent(Consumer<? super Throwable> r100) {
        ObjectHelper.requireNonNull(r100, "onEvent is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.e(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnSubscribe(Consumer<? super Disposable> r100) {
        Consumer<? super Throwable> r101 = Functions.emptyConsumer();
        Action r102 = Functions.EMPTY_ACTION;
        return doOnLifecycle(r100, r101, r102, r102, r102, r102);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable doOnTerminate(Action r100) {
        Consumer<? super Disposable> r101 = Functions.emptyConsumer();
        Consumer<? super Throwable> r102 = Functions.emptyConsumer();
        Action r103 = Functions.EMPTY_ACTION;
        return doOnLifecycle(r101, r102, r103, r100, r103, r103);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable lift(c r100) {
        ObjectHelper.requireNonNull(r100, "onLift is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.q(this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable mergeWith(CompletableSource r100) {
        ObjectHelper.requireNonNull(r100, "other is null");
        return mergeArray(new CompletableSource[]{this, r100});
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable observeOn(Scheduler r100) {
        ObjectHelper.requireNonNull(r100, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableObserveOn(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorComplete(Predicate<? super Throwable> r100) {
        ObjectHelper.requireNonNull(r100, "predicate is null");
        return RxJavaPlugins.onAssembly(new v(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable onErrorResumeNext(Function<? super Throwable, ? extends CompletableSource> r100) {
        ObjectHelper.requireNonNull(r100, "errorMapper is null");
        return RxJavaPlugins.onAssembly(new CompletableResumeNext(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeat(long r100) {
        return fromPublisher(toFlowable().repeat(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeatUntil(ttc.b r100) {
        return fromPublisher(toFlowable().repeatUntil(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable repeatWhen(Function<? super Flowable<Object>, ? extends Publisher<?>> r100) {
        return fromPublisher(toFlowable().repeatWhen(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(long r100) {
        return fromPublisher(toFlowable().retry(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retryWhen(Function<? super Flowable<Throwable>, ? extends Publisher<?>> r100) {
        return fromPublisher(toFlowable().retryWhen(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable startWith(CompletableSource r100) {
        ObjectHelper.requireNonNull(r100, "other is null");
        return concatArray(new CompletableSource[]{r100, this});
    }

    @Override // io.reactivex.CompletableSource
    @SchedulerSupport("none")
    public final void subscribe(b r100) {
        ObjectHelper.requireNonNull(r100, "s is null");
        b r101 = RxJavaPlugins.onSubscribe(this, r100);     // Catch: Throwable -> L5 NullPointerException -> L8
        ObjectHelper.requireNonNull(r101, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");     // Catch: Throwable -> L5 NullPointerException -> L8
        subscribeActual(r101);     // Catch: Throwable -> L5 NullPointerException -> L8
        return;
    L8:
        e = move-exception;
        throw e;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        throw toNpe(th);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable subscribeOn(Scheduler r100) {
        ObjectHelper.requireNonNull(r100, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableSubscribeOn(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <E extends b> E subscribeWith(E r100) {
        subscribe(r100);
        return r100;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable takeUntil(CompletableSource r100) {
        ObjectHelper.requireNonNull(r100, "other is null");
        return RxJavaPlugins.onAssembly(new CompletableTakeUntilCompletable(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final TestObserver<Void> test(boolean r100) {
        TestObserver<Void> r101 = new TestObserver();
        if (r100 == false) goto L5;
        r101.dispose();
    L5:
        subscribe(r101);
        return r101;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <U> U to(Function<? super Completable, U> r100) {
        return (U) ((Function) ObjectHelper.requireNonNull(r100, "converter is null")).apply(this);
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        throw ExceptionHelper.d(th);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> toSingle(Callable<? extends T> r100) {
        ObjectHelper.requireNonNull(r100, "completionValueSupplier is null");
        return RxJavaPlugins.onAssembly(new a0(this, r100, null));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> toSingleDefault(T r100) {
        ObjectHelper.requireNonNull(r100, "completionValue is null");
        return RxJavaPlugins.onAssembly(new a0(this, null, r100));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable unsubscribeOn(Scheduler r100) {
        ObjectHelper.requireNonNull(r100, "scheduler is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.d(this, r100));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable concat(Publisher<? extends CompletableSource> r100) {
        return concat(r100, 2);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static Completable error(Callable<? extends Throwable> r100) {
        ObjectHelper.requireNonNull(r100, "errorSupplier is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.h(r100));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static Completable merge(Publisher<? extends CompletableSource> r100) {
        return merge0(r100, Integer.MAX_VALUE, false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.UNBOUNDED_IN)
    @CheckReturnValue
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> r100) {
        return merge0(r100, Integer.MAX_VALUE, true);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> andThen(Publisher<T> r100) {
        ObjectHelper.requireNonNull(r100, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenPublisher(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(BiPredicate<? super Integer, ? super Throwable> r100) {
        return fromPublisher(toFlowable().retry(r100));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public final <T> Flowable<T> startWith(Publisher<T> r100) {
        ObjectHelper.requireNonNull(r100, "other is null");
        return toFlowable().startWith(r100);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Action r100) {
        ObjectHelper.requireNonNull(r100, "onComplete is null");
        CallbackCompletableObserver r101 = new CallbackCompletableObserver(r100);
        subscribe(r101);
        return r101;
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Maybe<T> andThen(MaybeSource<T> r100) {
        ObjectHelper.requireNonNull(r100, "next is null");
        return RxJavaPlugins.onAssembly(new MaybeDelayWithCompletable(r100, this));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(Predicate<? super Throwable> r100) {
        return fromPublisher(toFlowable().retry(r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> startWith(Observable<T> r100) {
        ObjectHelper.requireNonNull(r100, "other is null");
        return r100.concatWith(toObservable());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Observable<T> andThen(ObservableSource<T> r100) {
        ObjectHelper.requireNonNull(r100, "next is null");
        return RxJavaPlugins.onAssembly(new CompletableAndThenObservable(this, r100));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final <T> Single<T> andThen(SingleSource<T> r100) {
        ObjectHelper.requireNonNull(r100, "next is null");
        return RxJavaPlugins.onAssembly(new SingleDelayWithCompletable(r100, this));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable concat(Publisher<? extends CompletableSource> r100, int r101) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        ObjectHelper.verifyPositive(r101, ErrorType.PREFETCH);
        return RxJavaPlugins.onAssembly(new CompletableConcat(r100, r101));
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable merge(Publisher<? extends CompletableSource> r100, int r101) {
        return merge0(r100, r101, false);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    public static Completable mergeDelayError(Publisher<? extends CompletableSource> r100, int r101) {
        return merge0(r100, r101, true);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public static Completable timer(long r100, TimeUnit r101) {
        return timer(r100, r101, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final boolean blockingAwait(long r100, TimeUnit r101) {
        ObjectHelper.requireNonNull(r101, "unit is null");
        io.reactivex.internal.observers.f r102 = new io.reactivex.internal.observers.f();
        subscribe(r102);
        if (r102.getCount() != 0) goto L17;
    L11:
        Throwable r103 = r102.f492877b;
        if (r103 != null) goto L16;
        return true;
    L16:
        throw ExceptionHelper.d(r103);
    L17:
        io.reactivex.internal.util.c.b();     // Catch: InterruptedException -> L8
        if (r102.await(r100, r101) == true) goto L11;
        r102.b();     // Catch: InterruptedException -> L8
        return false;
    L8:
        e = move-exception;
        r102.b();
        throw ExceptionHelper.d(e);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Throwable blockingGet(long r100, TimeUnit r101) {
        ObjectHelper.requireNonNull(r101, "unit is null");
        io.reactivex.internal.observers.f r102 = new io.reactivex.internal.observers.f();
        subscribe(r102);
        if (r102.getCount() == 0) goto L13;
        io.reactivex.internal.util.c.b();     // Catch: InterruptedException -> L9
        if (r102.await(r100, r101) == true) goto L13;
        r102.b();     // Catch: InterruptedException -> L9
        throw ExceptionHelper.d(new TimeoutException(ExceptionHelper.c(r100, r101)));     // Catch: InterruptedException -> L9
    L9:
        e = move-exception;
        r102.b();
        throw ExceptionHelper.d(e);
    L13:
        return r102.f492877b;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable delay(long r100, TimeUnit r101) {
        return delay(r100, r101, Schedulers.computation(), false);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable delaySubscription(long r100, TimeUnit r101) {
        return delaySubscription(r100, r101, Schedulers.computation());
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Completable retry(long r100, Predicate<? super Throwable> r101) {
        return fromPublisher(toFlowable().retry(r100, r101));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public final Disposable subscribe(Action r100, Consumer<? super Throwable> r101) {
        ObjectHelper.requireNonNull(r101, "onError is null");
        ObjectHelper.requireNonNull(r100, "onComplete is null");
        CallbackCompletableObserver r102 = new CallbackCompletableObserver(r101, r100);
        subscribe(r102);
        return r102;
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable timeout(long r100, TimeUnit r101) {
        return timeout0(r100, r101, Schedulers.computation(), null);
    }

    @SchedulerSupport("none")
    @BackpressureSupport(BackpressureKind.FULL)
    @CheckReturnValue
    private static Completable merge0(Publisher<? extends CompletableSource> r100, int r101, boolean r102) {
        ObjectHelper.requireNonNull(r100, "sources is null");
        ObjectHelper.verifyPositive(r101, "maxConcurrency");
        return RxJavaPlugins.onAssembly(new CompletableMerge(r100, r101, r102));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public static Completable timer(long r100, TimeUnit r101, Scheduler r102) {
        ObjectHelper.requireNonNull(r101, "unit is null");
        ObjectHelper.requireNonNull(r102, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableTimer(r100, r101, r102));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <R> Completable using(Callable<R> r100, Function<? super R, ? extends CompletableSource> r101, Consumer<? super R> r102) {
        return using(r100, r101, r102, true);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable delay(long r100, TimeUnit r101, Scheduler r110) {
        return delay(r100, r101, r110, false);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable delaySubscription(long r100, TimeUnit r101, Scheduler r102) {
        return timer(r100, r101, r102).andThen(this);
    }

    @SchedulerSupport(SchedulerSupport.COMPUTATION)
    @CheckReturnValue
    public final Completable timeout(long r100, TimeUnit r110, CompletableSource r111) {
        ObjectHelper.requireNonNull(r111, "other is null");
        return timeout0(r100, r110, Schedulers.computation(), r111);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable timeout(long r100, TimeUnit r101, Scheduler r110) {
        return timeout0(r100, r101, r110, null);
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    private Completable timeout0(long r100, TimeUnit r110, Scheduler r111, CompletableSource r112) {
        ObjectHelper.requireNonNull(r110, "unit is null");
        ObjectHelper.requireNonNull(r111, "scheduler is null");
        return RxJavaPlugins.onAssembly(new x(this, r100, r110, r111, r112));
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    public static <R> Completable using(Callable<R> r100, Function<? super R, ? extends CompletableSource> r101, Consumer<? super R> r102, boolean r103) {
        ObjectHelper.requireNonNull(r100, "resourceSupplier is null");
        ObjectHelper.requireNonNull(r101, "completableFunction is null");
        ObjectHelper.requireNonNull(r102, "disposer is null");
        return RxJavaPlugins.onAssembly(new CompletableUsing(r100, r101, r102, r103));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable delay(long r100, TimeUnit r110, Scheduler r111, boolean r112) {
        ObjectHelper.requireNonNull(r110, "unit is null");
        ObjectHelper.requireNonNull(r111, "scheduler is null");
        return RxJavaPlugins.onAssembly(new CompletableDelay(this, r100, r110, r111, r112));
    }

    @SchedulerSupport("custom")
    @CheckReturnValue
    public final Completable timeout(long r100, TimeUnit r101, Scheduler r102, CompletableSource r103) {
        ObjectHelper.requireNonNull(r103, "other is null");
        return timeout0(r100, r101, r102, r103);
    }

    @SchedulerSupport("none")
    @CheckReturnValue
    private Completable doOnLifecycle(Consumer<? super Disposable> r110, Consumer<? super Throwable> r111, Action r112, Action r113, Action r114, Action r115) {
        ObjectHelper.requireNonNull(r110, "onSubscribe is null");
        ObjectHelper.requireNonNull(r111, "onError is null");
        ObjectHelper.requireNonNull(r112, "onComplete is null");
        ObjectHelper.requireNonNull(r113, "onTerminate is null");
        ObjectHelper.requireNonNull(r114, "onAfterTerminate is null");
        ObjectHelper.requireNonNull(r115, "onDispose is null");
        return RxJavaPlugins.onAssembly(new io.reactivex.internal.operators.completable.w(this, r110, r111, r112, r113, r114, r115));
    }
}
