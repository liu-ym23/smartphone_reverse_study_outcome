package io.ktor.client.statement;

import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpResponseKt", f = "HttpResponse.kt", i = {}, l = {97}, m = "bodyAsChannel", n = {}, s = {})
final class HttpResponseKt$bodyAsChannel$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public HttpResponseKt$bodyAsChannel$1(Continuation<? super HttpResponseKt$bodyAsChannel$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        HttpResponseKt$bodyAsChannel$1 r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 != 0) goto L9;
        ResultKt.throwOnFailure(r103);
        throw null;
    L9:
        if (r104 != 1) goto L17;
        ResultKt.throwOnFailure(r103);
        if (r103 == null) goto L15;
        return (ByteReadChannel) r103;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel");
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r102 = new HttpResponseKt$bodyAsChannel$1(this);
        goto L6
    }
}
