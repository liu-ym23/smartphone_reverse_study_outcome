package io.ktor.client.plugins.api;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"Lio/ktor/util/pipeline/b;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.plugins.api.SendingRequest$install$1", f = "CommonHooks.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
final class SendingRequest$install$1 extends SuspendLambda implements Function3<io.ktor.util.pipeline.b<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<HttpRequestBuilder, io.ktor.http.content.c, Continuation<? super Unit>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SendingRequest$install$1(Function3<? super HttpRequestBuilder, ? super io.ktor.http.content.c, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super SendingRequest$install$1> r101) {
        this.$handler = r100;
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(io.ktor.util.pipeline.b<Object, HttpRequestBuilder> r100, Object r101, Continuation<? super Unit> r102) {
        SendingRequest$install$1 r103 = new SendingRequest$install$1(this.$handler, r102);
        r103.L$0 = r100;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(io.ktor.util.pipeline.b<Object, HttpRequestBuilder> r100, Object r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to io.ktor.client.plugins.api.SendingRequest$install$1 for r5v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r5.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r6);
    L11:
        kotlin.Unit r6 = kotlin.Unit.INSTANCE;
        return r6;
    L6:
        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r6;
    L8:
        kotlin.ResultKt.throwOnFailure(r6);
        java.lang.Object r6 = r5.L$0;
        io.ktor.util.pipeline.b r6 = (io.ktor.util.pipeline.b) r6;
        kotlin.jvm.functions.Function3<io.ktor.client.request.HttpRequestBuilder, io.ktor.http.content.c, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r5.$handler;
        java.lang.Object r3 = r6.getContext();
        java.lang.Object r6 = r6.c();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type io.ktor.http.content.OutgoingContent");
        io.ktor.http.content.c r6 = (io.ktor.http.content.c) r6;
        r5.label = 1;
        io.ktor.client.request.HttpRequestBuilder r3 = (io.ktor.client.request.HttpRequestBuilder) r3;
        java.lang.Object r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
        java.lang.Object r6 = r1.invoke(r3, r6, r5);
        if (r6 != r0) goto L11;
        return r0;
    }
}
