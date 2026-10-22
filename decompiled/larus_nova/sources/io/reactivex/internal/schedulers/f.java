package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes41.dex */
public final class f extends Scheduler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final RxThreadFactory f494984b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f494985a;

    static {
        f494984b = new RxThreadFactory("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    }

    public f() {
        this(f494984b);
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new g(this.f494985a);
    }

    public f(ThreadFactory r100) {
        this.f494985a = r100;
    }
}
