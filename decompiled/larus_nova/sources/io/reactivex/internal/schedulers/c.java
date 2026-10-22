package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class c extends Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f494956a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f494957b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Disposable f494958c = null;

    public static final class a extends Scheduler.Worker {
        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return false;
        }

        public a() {
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100) {
            r100.run();
            return c.f494958c;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedulePeriodically(Runnable r100, long r101, long r102, TimeUnit r103) {
            throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        }
    }

    static {
        f494956a = new c();
        f494957b = new a();
        Disposable r100 = Disposables.empty();
        f494958c = r100;
        r100.dispose();
    }

    public c() {
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return f494957b;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100) {
        r100.run();
        return f494958c;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        throw new UnsupportedOperationException("This scheduler doesn't support delayed execution");
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(Runnable r100, long r101, long r102, TimeUnit r103) {
        throw new UnsupportedOperationException("This scheduler doesn't support periodic execution");
    }
}
