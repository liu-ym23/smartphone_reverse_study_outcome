package io.ktor.client.plugins.api;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.v;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"Lio/ktor/client/plugins/v;", "Lio/ktor/client/request/HttpRequestBuilder;", "request", "Lio/ktor/client/call/HttpClientCall;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.plugins.api.Send$install$1", f = "CommonHooks.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
final class Send$install$1 extends SuspendLambda implements Function3<v, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> {
    final /* synthetic */ Function3<c, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> $handler;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public Send$install$1(Function3<? super c, ? super HttpRequestBuilder, ? super Continuation<? super HttpClientCall>, ? extends Object> r100, Continuation<? super Send$install$1> r101) {
        this.$handler = r100;
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(v r100, HttpRequestBuilder r101, Continuation<? super HttpClientCall> r102) {
        Send$install$1 r103 = new Send$install$1(this.$handler, r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(v r100, HttpRequestBuilder r101, Continuation<? super HttpClientCall> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        v r103 = (v) this.L$0;
        HttpRequestBuilder r104 = (HttpRequestBuilder) this.L$1;
        Function3<c, HttpRequestBuilder, Continuation<? super HttpClientCall>, Object> r105 = this.$handler;
        c r106 = new c(r103);
        this.L$0 = null;
        this.label = 1;
        r100 = r105.invoke(r106, r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
