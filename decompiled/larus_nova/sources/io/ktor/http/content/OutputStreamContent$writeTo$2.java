package io.ktor.http.content;

import io.ktor.utils.io.jvm.javaio.BlockingKt;
import io.ktor.utils.io.jvm.javaio.OutputAdapter;
import java.io.Closeable;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.http.content.OutputStreamContent$writeTo$2", f = "OutputStreamContent.kt", i = {}, l = {28}, m = "invokeSuspend", n = {}, s = {})
final class OutputStreamContent$writeTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ io.ktor.utils.io.d $channel;
    Object L$0;
    int label;
    final /* synthetic */ d this$0;

    public OutputStreamContent$writeTo$2(io.ktor.utils.io.d r100, d r101, Continuation<? super OutputStreamContent$writeTo$2> r102) {
        this.$channel = r100;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new OutputStreamContent$writeTo$2(this.$channel, null, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((OutputStreamContent$writeTo$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, java.io.Closeable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        io.ktor.utils.io.d r102 = this.$channel;
        Lazy r103 = BlockingKt.f492112a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        new OutputAdapter(null, r102);
        throw null;     // Catch: Throwable -> L14
    L5:
        if (r101 != 1) goto L11;
        Closeable r104 = (Closeable) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L14
        Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r104, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }
}
