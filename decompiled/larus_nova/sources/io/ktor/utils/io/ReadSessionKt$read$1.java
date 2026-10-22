package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.ReadSessionKt", f = "ReadSession.kt", i = {0, 0, 1, 1, 1, 2}, l = {24, 28, 31}, m = "read", n = {"$this$read", "block", "$this$read", "buffer", "bytesRead", "cause"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0", "L$0"})
final class ReadSessionKt$read$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ReadSessionKt$read$1(Continuation<? super ReadSessionKt$read$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        int r111 = this.label | Integer.MIN_VALUE;
        this.label = r111;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r111 - Integer.MIN_VALUE;
        ReadSessionKt$read$1 r112 = this;
    L6:
        Object r100 = r112.result;
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r112.label;
        if (r102 == 0) goto L20;
        if (r102 == 1) goto L19;
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L12;
        Throwable r113 = (Throwable) r112.L$0;
        ResultKt.throwOnFailure(r100);
        throw r113;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        int r103 = r112.I$0;
        io.ktor.utils.io.core.a r104 = (io.ktor.utils.io.core.a) r112.L$1;
        ByteReadChannel r105 = (ByteReadChannel) r112.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L17
    L31:
        return Boxing.boxInt(r103);
    L17:
        Throwable th10 = th;
    L35:
        r112.L$0 = th10;
        r112.L$1 = null;
        r112.label = 3;
        if (ReadSessionKt.a(r105, r104, 0, r112) != r101) goto L39;
        return r101;
    L39:
        throw th10;
    L19:
        Function3 r106 = (Function3) r112.L$1;
        r105 = (ByteReadChannel) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L24:
        io.ktor.utils.io.core.a r107 = (io.ktor.utils.io.core.a) r100;
        if (r107 != null) goto L40;
        int r108 = io.ktor.utils.io.core.a.f492019g;
        r107 = io.ktor.utils.io.core.internal.a.f492030m;
    L40:
        r103 = ((Number) r106.invoke(new jsc.c(r107.f492020a), Boxing.boxLong(r107.f492021b), Boxing.boxLong(r107.f492022c))).intValue();     // Catch: Throwable -> L33
        r112.L$0 = r105;     // Catch: Throwable -> L33
        r112.L$1 = r107;     // Catch: Throwable -> L33
        r112.I$0 = r103;     // Catch: Throwable -> L33
        r112.label = 2;     // Catch: Throwable -> L33
        if (ReadSessionKt.a(r105, r107, r103, r112) == r101) goto L45;
        r104 = r107;
        goto L31
    L45:
        return r101;
    L33:
        th = move-exception;
        r104 = r107;
        th10 = th;
        goto L35
    L20:
        ResultKt.throwOnFailure(r100);
        r112.L$0 = null;
        r112.L$1 = null;
        r112.label = 1;
        r100 = ReadSessionKt.b(null, 0, r112);
        if (r100 == r101) goto L44;
        r106 = null;
        r105 = null;
        goto L24
    L44:
        return r101;
    L5:
        r112 = new ReadSessionKt$read$1(this);
        goto L6
    }
}
