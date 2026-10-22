package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
public interface d {
    Object A(byte r100, ContinuationImpl r101);

    Object I(int r100, Function1<? super ByteBuffer, Unit> r101, Continuation<? super Unit> r102);

    boolean J();

    boolean c();

    boolean close(Throwable r100);

    Throwable d();

    void flush();

    Object g(Function1<? super ByteBuffer, Boolean> r100, Continuation<? super Unit> r101);

    @Deprecated(message = "Use write { } instead.")
    Object k(Function2<? super w, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Unit> r101);

    Object l(io.ktor.utils.io.core.k r100, ContinuationImpl r101);

    Object o(short r100, ContinuationImpl r101);

    Object q(long r100, ContinuationImpl r101);

    Object t(byte[] r100, int r101, int r102, Continuation<? super Unit> r103);

    Object v(int r100, Continuation<? super Unit> r101);

    Object x(ByteBuffer r100, ContinuationImpl r101);

    Object y(io.ktor.utils.io.core.a r100, ContinuationImpl r101);
}
