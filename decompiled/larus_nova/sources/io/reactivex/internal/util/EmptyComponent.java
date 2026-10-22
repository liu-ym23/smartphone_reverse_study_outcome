package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.k;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final enum EmptyComponent extends Enum<EmptyComponent> implements io.reactivex.g<Object>, Observer<Object>, k<Object>, SingleObserver<Object>, io.reactivex.b, wwc.c, Disposable {
    public static final EmptyComponent INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyComponent[] f495039a = null;

    @Override // wwc.c
    public void cancel() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    @Override // wwc.b
    public void onComplete() {
    }

    @Override // wwc.b
    public void onNext(Object r100) {
    }

    @Override // io.reactivex.k
    public void onSuccess(Object r100) {
    }

    @Override // wwc.c
    public void request(long r100) {
    }

    static {
        EmptyComponent r100 = new EmptyComponent();
        INSTANCE = r100;
        f495039a = new EmptyComponent[]{r100};
    }

    public EmptyComponent() {
        super("INSTANCE", 0);
    }

    public static EmptyComponent[] values() {
        return (EmptyComponent[]) f495039a.clone();
    }

    public static <T> Observer<T> asObserver() {
        return INSTANCE;
    }

    public static <T> wwc.b<T> asSubscriber() {
        return INSTANCE;
    }

    public static EmptyComponent valueOf(String r100) {
        return (EmptyComponent) r27.a.a(EmptyComponent.class, r100);
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        RxJavaPlugins.onError(r100);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        r100.dispose();
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(wwc.c r100) {
        r100.cancel();
    }
}
