package io.ktor.utils.io;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: loaded from: classes41.dex */
public final class WriterSessionKt {
    public static final Object b(d r100, io.ktor.utils.io.core.a r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof WriterSessionKt$completeWritingFallback$1) == false) goto L7;
        WriterSessionKt$completeWritingFallback$1 r103 = (WriterSessionKt$completeWritingFallback$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = (io.ktor.utils.io.core.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L19:
        AtomicReferenceFieldUpdater r108 = io.ktor.utils.io.core.internal.a.f492027j;
        ((io.ktor.utils.io.core.internal.a) r101).k(io.ktor.utils.io.core.c.f492026a);
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        if ((r101 instanceof io.ktor.utils.io.core.internal.a) == false) goto L22;
        r103.L$0 = r101;
        r103.label = 1;
        if (r100.y(r101, r103) != r106) goto L19;
        return r106;
    L22:
        throw new UnsupportedOperationException("Only ChunkBuffer instance is supported.");
    L7:
        r103 = new WriterSessionKt$completeWritingFallback$1(r102);
        goto L8
    }

    public static final Object c(d r100, int r101, ContinuationImpl r102) {
        if ((r100 instanceof o) == false) goto L5;
        w r103 = ((o) r100).L();
    L6:
        if (r103 == null) goto L12;
        io.ktor.utils.io.core.internal.a r104 = r103.a(r101);
        if (r104 == null) goto L11;
        return r104;
    L11:
        return d(r103, r101, r102);
    L12:
        AtomicReferenceFieldUpdater r105 = io.ktor.utils.io.core.internal.a.f492027j;
        io.ktor.utils.io.core.internal.a r106 = io.ktor.utils.io.core.c.f492026a.Q5();
        io.ktor.utils.io.core.internal.a r107 = r106;
        r107.f(r107.f492025f - r107.f492023d);
        r107.e();
        return r106;
    L5:
        r103 = null;
        goto L6
    }

    public static final Object d(w r100, int r101, Continuation<? super io.ktor.utils.io.core.a> r102) {
        if ((r102 instanceof WriterSessionKt$writeBufferSuspend$1) == false) goto L7;
        WriterSessionKt$writeBufferSuspend$1 r103 = (WriterSessionKt$writeBufferSuspend$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.I$0;
        r100 = (w) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L17:
        io.ktor.utils.io.core.internal.a r108 = r100.a(r101);
        if (r108 == null) goto L21;
        return r108;
    L21:
        return r100.a(1);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;
        r103.I$0 = r101;
        r103.label = 1;
        if (r100.c(r101, r103) != r106) goto L17;
        return r106;
    L7:
        r103 = new WriterSessionKt$writeBufferSuspend$1(r102);
        goto L8
    }

    public static final Object a(d r100, io.ktor.utils.io.core.a r101, int r102, ContinuationImpl r103) {
        if ((r100 instanceof o) == false) goto L6;
        ((o) r100).G(r102);
        return Unit.INSTANCE;
    L6:
        Object r104 = b(r100, r101, r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r104;
    L10:
        return Unit.INSTANCE;
    }
}
