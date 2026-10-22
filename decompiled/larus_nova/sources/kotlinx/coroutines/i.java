package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes.dex */
public interface i<T> extends Continuation<T> {
    kotlinx.coroutines.internal.b0 b(Object r100, Function1 r101);

    boolean cancel(Throwable r100);

    void d(Object r100);

    void f(CoroutineDispatcher r100, T r101);

    void h(T r100, Function1<? super Throwable, Unit> r101);

    void i(Function1<? super Throwable, Unit> r100);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    kotlinx.coroutines.internal.b0 l(Object r100, Object r101);

    kotlinx.coroutines.internal.b0 m(Throwable r100);
}
