package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Future;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class Disposables {
    public static Disposable empty() {
        return fromRunnable(Functions.EMPTY_RUNNABLE);
    }

    private Disposables() {
        throw new IllegalStateException("No instances!");
    }

    public static Disposable disposed() {
        return EmptyDisposable.INSTANCE;
    }

    public static Disposable fromAction(Action r100) {
        ObjectHelper.requireNonNull(r100, "run is null");
        return new ActionDisposable(r100);
    }

    public static Disposable fromFuture(Future<?> r100) {
        ObjectHelper.requireNonNull(r100, "future is null");
        return fromFuture(r100, true);
    }

    public static Disposable fromRunnable(Runnable r100) {
        ObjectHelper.requireNonNull(r100, "run is null");
        return new RunnableDisposable(r100);
    }

    public static Disposable fromSubscription(c r100) {
        ObjectHelper.requireNonNull(r100, "subscription is null");
        return new SubscriptionDisposable(r100);
    }

    public static Disposable fromFuture(Future<?> r100, boolean r101) {
        ObjectHelper.requireNonNull(r100, "future is null");
        return new FutureDisposable(r100, r101);
    }
}
