package io.ktor.client.plugins.api;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"Lio/ktor/util/pipeline/b;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.plugins.api.SetupRequest$install$1", f = "CommonHooks.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
final class SetupRequest$install$1 extends SuspendLambda implements Function3<io.ktor.util.pipeline.b<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<HttpRequestBuilder, Continuation<? super Unit>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SetupRequest$install$1(Function2<? super HttpRequestBuilder, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super SetupRequest$install$1> r101) {
        this.$handler = r100;
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(io.ktor.util.pipeline.b<Object, HttpRequestBuilder> r100, Object r101, Continuation<? super Unit> r102) {
        SetupRequest$install$1 r103 = new SetupRequest$install$1(this.$handler, r102);
        r103.L$0 = r100;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(io.ktor.util.pipeline.b<Object, HttpRequestBuilder> r100, Object r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to io.ktor.client.plugins.api.SetupRequest$install$1 for r3v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r4) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r3.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r4);
    L11:
        kotlin.Unit r4 = kotlin.Unit.INSTANCE;
        return r4;
    L6:
        java.lang.IllegalStateException r4 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r4;
    L8:
        kotlin.ResultKt.throwOnFailure(r4);
        java.lang.Object r4 = r3.L$0;
        io.ktor.util.pipeline.b r4 = (io.ktor.util.pipeline.b) r4;
        kotlin.jvm.functions.Function2<io.ktor.client.request.HttpRequestBuilder, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r3.$handler;
        java.lang.Object r4 = r4.getContext();
        r3.label = 1;
        io.ktor.client.request.HttpRequestBuilder r4 = (io.ktor.client.request.HttpRequestBuilder) r4;
        java.lang.Object r3 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r3;
        java.lang.Object r4 = r1.invoke(r4, r3);
        if (r4 != r0) goto L11;
        return r0;
    }
}
