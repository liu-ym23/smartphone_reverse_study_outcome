package io.ktor.http.content;

import io.ktor.utils.io.jvm.javaio.BlockingKt;
import io.ktor.utils.io.jvm.javaio.OutputAdapter;
import java.io.Closeable;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
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
@DebugMetadata(c = "io.ktor.http.content.WriterContent$writeTo$2", f = "WriterContent.kt", i = {}, l = {26}, m = "invokeSuspend", n = {}, s = {})
final class WriterContent$writeTo$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ io.ktor.utils.io.d $channel;
    final /* synthetic */ Charset $charset;
    Object L$0;
    int label;
    final /* synthetic */ g this$0;

    public WriterContent$writeTo$2(io.ktor.utils.io.d r100, Charset r101, g r102, Continuation<? super WriterContent$writeTo$2> r103) {
        this.$channel = r100;
        this.$charset = r101;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new WriterContent$writeTo$2(this.$channel, this.$charset, null, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((WriterContent$writeTo$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        io.ktor.utils.io.d r102 = this.$channel;
        Charset r103 = this.$charset;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        Intrinsics.checkNotNullParameter(r103, "charset");
        Lazy r104 = BlockingKt.f492112a;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        OutputStreamWriter r105 = new OutputStreamWriter(new OutputAdapter(null, r102), r103);
        throw null;     // Catch: Throwable -> L16
    L16:
        th = th;
        Closeable r106 = r105;
    L24:
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);
        throw th;
    L5:
        if (r101 != 1) goto L13;
        r106 = (Closeable) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L10
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r106, null);
        return Unit.INSTANCE;
    L10:
        th = th;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
