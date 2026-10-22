package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<T> implements Observer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f495061a;

    public a() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        Disposable r101 = this.f495061a;
        Class<?> r102 = getClass();
        ObjectHelper.requireNonNull(r100, "next is null");
        if (r101 == null) goto L8;
        r100.dispose();
        if (r101 == DisposableHelper.DISPOSED) goto L7;
        io.reactivex.internal.util.f.a(r102);
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L12;
        this.f495061a = r100;
        return;
    L12:
        return;
    L8:
        r103 = true;
        goto L9
    }
}
