package io.ktor.client.plugins;

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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"Lio/ktor/util/pipeline/b;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.plugins.UserAgent$Plugin$install$1", f = "UserAgent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserAgent$Plugin$install$1 extends SuspendLambda implements Function3<io.ktor.util.pipeline.b<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $plugin;
    private /* synthetic */ Object L$0;
    int label;

    public UserAgent$Plugin$install$1(w r100, Continuation<? super UserAgent$Plugin$install$1> r101) {
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(io.ktor.util.pipeline.b<Object, HttpRequestBuilder> r100, Object r101, Continuation<? super Unit> r102) {
        UserAgent$Plugin$install$1 r103 = new UserAgent$Plugin$install$1(null, r102);
        r103.L$0 = r100;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(io.ktor.util.pipeline.b<Object, HttpRequestBuilder> r100, Object r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        io.ktor.util.pipeline.b r101 = (io.ktor.util.pipeline.b) this.L$0;
        xwc.c r102 = x.f491756a;
        throw null;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
