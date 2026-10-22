package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lio/ktor/client/statement/b;", "it", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.statement.HttpStatement$execute$4", f = "HttpStatement.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class HttpStatement$execute$4 extends SuspendLambda implements Function2<b, Continuation<? super b>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public HttpStatement$execute$4(Continuation<? super HttpStatement$execute$4> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        HttpStatement$execute$4 r102 = new HttpStatement$execute$4(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(b r100, Continuation<? super b> r101) {
        return ((HttpStatement$execute$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(b r100, Continuation<? super b> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return ((HttpClientCall) r100).d();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        HttpClientCall r103 = ((b) this.L$0).a80();
        this.label = 1;
        r100 = SavedCallKt.a(r103, this);
        if (r100 != r101) goto L12;
        return r101;
    }
}
