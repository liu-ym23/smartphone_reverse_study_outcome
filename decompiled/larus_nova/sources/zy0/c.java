package zy0;

import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import wy0.e;

/* JADX INFO: loaded from: classes47.dex */
public interface c extends Disposable, a {
    @Override // io.reactivex.disposables.Disposable
    void dispose();

    xy0.a<?> g();

    @Override // io.reactivex.disposables.Disposable
    boolean isDisposed();

    void l1(Function1<? super e, Unit> r100);

    xy0.a<?> w();
}
