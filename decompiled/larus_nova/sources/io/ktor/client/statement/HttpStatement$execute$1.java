package io.ktor.client.statement;

import io.ktor.client.utils.d;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement", f = "HttpStatement.kt", i = {0, 0, 1, 1}, l = {47, 50, 52, 52}, m = "execute", n = {"this", "block", "this", "response"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class HttpStatement$execute$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpStatement this$0;

    public HttpStatement$execute$1(HttpStatement r100, Continuation<? super HttpStatement$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        HttpStatement r111 = this.this$0;
        r111.getClass();
        int r100 = this.label;
        if ((r100 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r100 - Integer.MIN_VALUE;
        HttpStatement$execute$1<T> r101 = this;
    L6:
        Object r102 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L28;
        if (r104 == 1) goto L25;
        if (r104 == 2) goto L20;
        if (r104 == 3) goto L17;
        if (r104 != 4) goto L13;
        Throwable r112 = (Throwable) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: CancellationException -> L48
        throw r112;     // Catch: CancellationException -> L48
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Object r113 = r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: CancellationException -> L48
        return r113;
    L20:
        b r114 = (b) r101.L$1;
        HttpStatement r105 = (HttpStatement) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L23
    L38:
        r101.L$0 = r102;     // Catch: CancellationException -> L48
        r101.L$1 = null;     // Catch: CancellationException -> L48
        r101.label = 3;     // Catch: CancellationException -> L48
        if (r105.a(r114, r101) != r103) goto L58;
        return r103;
    L58:
        return r102;
    L23:
        th = move-exception;
        b r106 = r114;
        Throwable r115 = th;
        HttpStatement r107 = r105;
    L44:
        r101.L$0 = r115;     // Catch: CancellationException -> L48
        r101.L$1 = null;     // Catch: CancellationException -> L48
        r101.label = 4;     // Catch: CancellationException -> L48
        if (r107.a(r106, r101) == r103) goto L59;
        throw r115;     // Catch: CancellationException -> L48
    L59:
        return r103;
    L25:
        Function2 r116 = (Function2) r101.L$1;
        HttpStatement r108 = (HttpStatement) r101.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: CancellationException -> L48
        Function2 r109 = r116;
        r111 = r108;
        Object r117 = r102;
    L33:
        r106 = (b) r117;     // Catch: CancellationException -> L48
        r101.L$0 = r111;     // Catch: Throwable -> L42
        r101.L$1 = r106;     // Catch: Throwable -> L42
        r101.label = 2;     // Catch: Throwable -> L42
        r102 = r109.invoke(r106, r101);     // Catch: Throwable -> L42
        if (r102 == r103) goto L60;
        r105 = r111;
        r114 = r106;
        goto L38
    L60:
        return r103;
    L42:
        th = move-exception;
        r107 = r111;
        r115 = th;
        goto L44
    L28:
        ResultKt.throwOnFailure(r102);
        r101.L$0 = r111;     // Catch: CancellationException -> L48
        r101.L$1 = null;     // Catch: CancellationException -> L48
        r101.label = 1;     // Catch: CancellationException -> L48
        Object r118 = r111.b(r101);     // Catch: CancellationException -> L48
        if (r118 == r103) goto L56;
        r117 = r118;
        r109 = null;
        goto L33
    L56:
        return r103;
    L48:
        e = move-exception;
        throw d.a(e);
    L5:
        r101 = new HttpStatement$execute$1(r111, this);
        goto L6
    }
}
