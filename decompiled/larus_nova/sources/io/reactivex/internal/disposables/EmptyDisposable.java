package io.reactivex.internal.disposables;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.b;
import io.reactivex.k;
import r27.a;
import vtc.e;

/* JADX INFO: loaded from: classes41.dex */
public final enum EmptyDisposable extends Enum<EmptyDisposable> implements e<Object> {
    public static final EmptyDisposable INSTANCE = null;
    public static final EmptyDisposable NEVER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EmptyDisposable[] f492835a = null;

    @Override // vtc.j
    public void clear() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // vtc.j
    public boolean isEmpty() {
        return true;
    }

    @Override // vtc.j
    public Object poll() throws Exception {
        return null;
    }

    @Override // vtc.f
    public int requestFusion(int r100) {
        return r100 & 2;
    }

    static {
        EmptyDisposable r100 = new EmptyDisposable("INSTANCE", 0);
        INSTANCE = r100;
        EmptyDisposable r101 = new EmptyDisposable("NEVER", 1);
        NEVER = r101;
        f492835a = new EmptyDisposable[]{r100, r101};
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[]) f492835a.clone();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this != INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    public static void complete(Observer<?> r100) {
        r100.onSubscribe(INSTANCE);
        r100.onComplete();
    }

    public static EmptyDisposable valueOf(String r100) {
        return (EmptyDisposable) a.a(EmptyDisposable.class, r100);
    }

    @Override // vtc.j
    public boolean offer(Object r100) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(b r100) {
        r100.onSubscribe(INSTANCE);
        r100.onComplete();
    }

    public static void complete(k<?> r100) {
        r100.onSubscribe(INSTANCE);
        r100.onComplete();
    }

    public EmptyDisposable(String r100, int r101) {
        super(r100, r101);
    }

    public static void error(Throwable r100, Observer<?> r101) {
        r101.onSubscribe(INSTANCE);
        r101.onError(r100);
    }

    public boolean offer(Object r100, Object r101) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void error(Throwable r100, SingleObserver<?> r101) {
        r101.onSubscribe(INSTANCE);
        r101.onError(r100);
    }

    public static void error(Throwable r100, b r101) {
        r101.onSubscribe(INSTANCE);
        r101.onError(r100);
    }

    public static void error(Throwable r100, k<?> r101) {
        r101.onSubscribe(INSTANCE);
        r101.onError(r100);
    }
}
