package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes41.dex */
public interface ByteReadChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f492010a = null;

    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f492011a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<b> f492012b = null;

        public Companion() {
        }

        static {
            f492011a = new Companion();
            f492012b = LazyKt.lazy(ByteReadChannel$Companion$Empty$2.INSTANCE);
        }
    }

    public static final class a {
        public static /* synthetic */ Object a(ByteReadChannel r100, Continuation r101) {
            return r100.h(Long.MAX_VALUE, r101);
        }
    }

    static {
        f492010a = Companion.f492011a;
    }

    Object B(ByteBuffer r100, ContinuationImpl r101);

    Object D(io.ktor.utils.io.core.internal.a r100, ContinuationImpl r101);

    boolean E();

    Object F(Continuation<? super Integer> r100);

    boolean c();

    boolean cancel(Throwable r100);

    Throwable d();

    Object e(int r100, Continuation<? super io.ktor.utils.io.core.k> r101);

    Object h(long r100, Continuation<? super io.ktor.utils.io.core.k> r101);

    Object i(ByteBuffer r100, long r101, long r102, long r103, Continuation r104);

    Object j(Continuation<? super Long> r100);

    Object m(int r100, Function1<? super ByteBuffer, Unit> r101, Continuation<? super Unit> r102);

    Object n(Continuation r100);

    Object p(long r100, Continuation<? super Long> r101);

    Object r(byte[] r100, int r101, int r102, ContinuationImpl r103);

    Object s(Continuation<? super Short> r100);

    Object u(byte[] r100, int r101, ContinuationImpl r102);

    int w();

    Object z(Continuation<? super Byte> r100);
}
