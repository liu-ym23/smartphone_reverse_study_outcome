package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.utils.d;
import io.ktor.utils.io.ByteReadChannel;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
public final class HttpStatement {
    public HttpStatement() {
        throw null;
    }

    public final String toString() {
        throw null;
    }

    public final Object b(Continuation<? super b> r100) {
        if ((r100 instanceof HttpStatement$executeUnsafe$1) == false) goto L7;
        HttpStatement$executeUnsafe$1 r101 = (HttpStatement$executeUnsafe$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 != 0) goto L11;
        ResultKt.throwOnFailure(r103);
        new HttpRequestBuilder();     // Catch: CancellationException -> L19
        Intrinsics.checkNotNullParameter(null, "builder");     // Catch: CancellationException -> L19
        throw null;
    L11:
        if (r104 != 1) goto L15;
        ResultKt.throwOnFailure(r103);     // Catch: CancellationException -> L19
        return ((HttpClientCall) r103).d();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        e = move-exception;
        throw d.a(e);
    L7:
        r101 = new HttpStatement$executeUnsafe$1(this, r100);
        goto L8
    }

    public final Object a(b r100, Continuation<? super Unit> r101) {
        if ((r101 instanceof HttpStatement$cleanup$1) == false) goto L7;
        HttpStatement$cleanup$1 r102 = (HttpStatement$cleanup$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        CompletableJob r107 = (CompletableJob) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L22:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        CoroutineContext.Element r108 = r100.getCoroutineContext().get(Job.Key);
        Intrinsics.checkNotNull(r108);
        CompletableJob r109 = (CompletableJob) r108;
        r109.complete();
        ByteReadChannel r110 = r100.a();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r110, "<this>");     // Catch: Throwable -> L17
        r110.cancel(null);     // Catch: Throwable -> L17
    L18:
        r102.L$0 = r109;
        r102.label = 1;
        if (r109.join(r102) != r105) goto L22;
        return r105;
    L7:
        r102 = new HttpStatement$cleanup$1(this, r101);
        goto L8
    }
}
