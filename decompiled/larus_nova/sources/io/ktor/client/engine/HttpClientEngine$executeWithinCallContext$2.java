package io.ktor.client.engine;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/ktor/client/request/f;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.engine.HttpClientEngine$executeWithinCallContext$2", f = "HttpClientEngine.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
final class HttpClientEngine$executeWithinCallContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super io.ktor.client.request.f>, Object> {
    final /* synthetic */ io.ktor.client.request.c $requestData;
    int label;
    final /* synthetic */ a this$0;

    public HttpClientEngine$executeWithinCallContext$2(a r100, io.ktor.client.request.c r101, Continuation<? super HttpClientEngine$executeWithinCallContext$2> r102) {
        this.this$0 = r100;
        this.$requestData = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new HttpClientEngine$executeWithinCallContext$2(this.this$0, this.$requestData, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super io.ktor.client.request.f> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super io.ktor.client.request.f> r101) {
        return ((HttpClientEngine$executeWithinCallContext$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L17:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Job r103 = (Job) this.this$0.getCoroutineContext().get(Job.Key);
        if (r103 == null) goto L11;
        boolean r104 = r103.isActive();
    L13:
        if ((!r104) == true) goto L19;
        a r105 = this.this$0;
        this.label = 1;
        r100 = r105.Ld();
        if (r100 != r101) goto L17;
        return r101;
    L19:
        throw new ClientEngineClosedException(null, 1, null);
    L11:
        r104 = false;
        goto L13
    }
}
