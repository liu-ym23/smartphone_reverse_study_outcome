package com.bytedance.ee.lark.infra.foundation.schedulers;

/* JADX INFO: loaded from: classes19.dex */
public abstract class Observable<T> {
    protected Scheduler mObsverSchduler;
    protected Scheduler mSubScheduler;

    public Observable() {
    }

    public abstract boolean isUnSubscribe();

    public abstract void subscribe(Subscriber<T> r100);

    public void subscribeSimple() {
        subscribe(null);
    }

    public abstract boolean unSubscribe();

    public static Observable create(Action r100) {
        return CompletableObservable.newInstance(r100);
    }

    public Observable observeOn(Scheduler r100) {
        this.mObsverSchduler = r100;
        return this;
    }

    public Observable schudleOn(Scheduler r100) {
        this.mSubScheduler = r100;
        return this;
    }

    public static <T> Observable<T> create(Function<T> r100) {
        return CompletableObservable.newInstance(r100);
    }
}
