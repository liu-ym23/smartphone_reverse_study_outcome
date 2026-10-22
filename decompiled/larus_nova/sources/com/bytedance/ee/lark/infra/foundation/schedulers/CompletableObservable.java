package com.bytedance.ee.lark.infra.foundation.schedulers;

/* JADX INFO: loaded from: classes19.dex */
public class CompletableObservable<T> extends Observable implements Excutor {
    private Action innerAction;
    private Function<T> innerFunction;
    private CompletableFutureTask<T> task;

    @Override // com.bytedance.ee.lark.infra.foundation.schedulers.Observable
    public boolean isUnSubscribe() {
        CompletableFutureTask<T> r100 = this.task;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isUnSubscribe();
    }

    @Override // com.bytedance.ee.lark.infra.foundation.schedulers.Observable
    public boolean unSubscribe() {
        CompletableFutureTask<T> r100 = this.task;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.cancel();
    }

    public CompletableObservable(Action r100) {
        this.innerAction = r100;
    }

    public static CompletableObservable newInstance(Action r100) {
        if (r100 == null) goto L6;
        return new CompletableObservable(r100);
    L6:
        throw new NullPointerException("action is null");
    }

    @Override // com.bytedance.ee.lark.infra.foundation.schedulers.Observable
    public synchronized void subscribe(final Subscriber r100) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.task != null) goto L18;
        Action r101 = this.innerAction;     // Catch: Throwable -> L19
        if (r101 == null) goto L8;
        final CompletableCallable r102 = new CompletableCallable(r101);     // Catch: Throwable -> L19
        this.task = new AnonymousClass1(this, r102, r100);     // Catch: Throwable -> L19
    L8:
        Function<T> r103 = this.innerFunction;     // Catch: Throwable -> L19
        if (r103 == null) goto L11;
        final CompletableCallable r104 = new CompletableCallable(r103);     // Catch: Throwable -> L19
        this.task = new AnonymousClass2(this, r104, r100);     // Catch: Throwable -> L19
    L11:
        Scheduler r105 = this.mSubScheduler;     // Catch: Throwable -> L19
        if (r105 != null) goto L14;
        this.task.run();     // Catch: Throwable -> L19
    L15:
        monitor-exit(this);
        return;
    L14:
        r105.execute(this.task);     // Catch: Throwable -> L19
        goto L15
    L18:
        throw new IllegalStateException("Observable has subscribed");     // Catch: Throwable -> L19
    }

    public CompletableObservable(Function<T> r100) {
        this.innerFunction = r100;
    }

    public static <M> CompletableObservable newInstance(Function<M> r100) {
        if (r100 == null) goto L6;
        return new CompletableObservable(r100);
    L6:
        throw new NullPointerException("function is null");
    }
}
