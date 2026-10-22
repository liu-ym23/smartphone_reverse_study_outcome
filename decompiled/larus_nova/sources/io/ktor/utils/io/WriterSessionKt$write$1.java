package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.WriterSessionKt", f = "WriterSession.kt", i = {0, 0}, l = {22, 29, 29}, m = "write", n = {"$this$write", "block"}, s = {"L$0", "L$1"})
final class WriterSessionKt$write$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public WriterSessionKt$write$1(Continuation<? super WriterSessionKt$write$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        int r111 = this.label | Integer.MIN_VALUE;
        this.label = r111;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r111 - Integer.MIN_VALUE;
        WriterSessionKt$write$1 r112 = this;
    L6:
        Object r100 = r112.result;
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r112.label;
        int r103 = 0;
        if (r102 == 0) goto L16;
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L12;
        Throwable r113 = (Throwable) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L34:
        InlineMarker.finallyEnd(1);
        throw r113;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        Integer r114 = (Integer) r112.L$0;
        ResultKt.throwOnFailure(r100);
        r101 = r114;
    L28:
        InlineMarker.finallyEnd(1);
    L32:
        return r101;
    L15:
        Function3 r104 = (Function3) r112.L$1;
        d r105 = (d) r112.L$0;
        ResultKt.throwOnFailure(r100);
    L20:
        io.ktor.utils.io.core.a r106 = (io.ktor.utils.io.core.a) r100;
        if (r106 != null) goto L36;
        int r107 = io.ktor.utils.io.core.a.f492019g;
        r106 = io.ktor.utils.io.core.internal.a.f492030m;
    L36:
        r103 = ((Number) r104.invoke(new jsc.c(r106.f492020a), Boxing.boxLong(r106.f492022c), Boxing.boxLong(r106.f492024e))).intValue();     // Catch: Throwable -> L29
        r106.a(r103);     // Catch: Throwable -> L29
        Integer r108 = Boxing.boxInt(r103);     // Catch: Throwable -> L29
        InlineMarker.finallyStart(1);
        r112.L$0 = r108;
        r112.L$1 = null;
        r112.label = 2;
        if (WriterSessionKt.a(r105, r106, r103, r112) == r101) goto L32;
        r101 = r108;
    L29:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r112.L$0 = th;
        r112.L$1 = null;
        r112.label = 3;
        if (WriterSessionKt.a(r105, r106, r103, r112) == r101) goto L32;
        r113 = th;
        goto L34
    L16:
        ResultKt.throwOnFailure(r100);
        r112.L$0 = null;
        r112.L$1 = null;
        r112.label = 1;
        r100 = WriterSessionKt.c(null, 0, r112);
        if (r100 == r101) goto L32;
        r104 = null;
        r105 = null;
        goto L20
    L5:
        r112 = new WriterSessionKt$write$1(this);
        goto L6
    }
}
