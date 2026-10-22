package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface i<T> extends Continuation<T> {
    b0 b(Object r1, Function1 r2);

    boolean cancel(Throwable r1);

    void d(Object r1);

    void f(CoroutineDispatcher r1, T r2);

    void h(T r1, Function1<? super Throwable, Unit> r2);

    void i(Function1<? super Throwable, Unit> r1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    b0 l(Object r1, Object r2);

    b0 m(Throwable r1);
}
