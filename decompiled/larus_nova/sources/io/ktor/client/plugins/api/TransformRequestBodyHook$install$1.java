package io.ktor.client.plugins.api;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"Lio/ktor/util/pipeline/b;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "it", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.plugins.api.TransformRequestBodyHook$install$1", f = "KtorCallContexts.kt", i = {0}, l = {82, 83}, m = "invokeSuspend", n = {"$this$intercept"}, s = {"L$0"})
final class TransformRequestBodyHook$install$1 extends SuspendLambda implements Function3<io.ktor.util.pipeline.b<Object, HttpRequestBuilder>, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function5<d, HttpRequestBuilder, Object, isc.a, Continuation<? super io.ktor.http.content.c>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public TransformRequestBodyHook$install$1(Function5<? super d, ? super HttpRequestBuilder, Object, ? super isc.a, ? super Continuation<? super io.ktor.http.content.c>, ? extends Object> r100, Continuation<? super TransformRequestBodyHook$install$1> r101) {
        this.$handler = r100;
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(io.ktor.util.pipeline.b<Object, HttpRequestBuilder> r100, Object r101, Continuation<? super Unit> r102) {
        TransformRequestBodyHook$install$1 r103 = new TransformRequestBodyHook$install$1(this.$handler, r102);
        r103.L$0 = r100;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(io.ktor.util.pipeline.b<Object, HttpRequestBuilder> r100, Object r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to io.ktor.client.plugins.api.TransformRequestBodyHook$install$1 for r10v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r10.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        kotlin.ResultKt.throwOnFailure(r11);
    L18:
        kotlin.Unit r11 = kotlin.Unit.INSTANCE;
        return r11;
    L7:
        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r11;
    L9:
        java.lang.Object r1 = r10.L$0;
        io.ktor.util.pipeline.b r1 = (io.ktor.util.pipeline.b) r1;
        kotlin.ResultKt.throwOnFailure(r11);
    L13:
        io.ktor.http.content.c r11 = (io.ktor.http.content.c) r11;
        if (r11 == null) goto L18;
        r10.L$0 = null;
        r10.label = 2;
        java.lang.Object r11 = r1.e(r11, r10);
        if (r11 != r0) goto L18;
        return r0;
    L10:
        kotlin.ResultKt.throwOnFailure(r11);
        java.lang.Object r11 = r10.L$0;
        r1 = (io.ktor.util.pipeline.b) r11;
        kotlin.jvm.functions.Function5<io.ktor.client.plugins.api.d, io.ktor.client.request.HttpRequestBuilder, java.lang.Object, isc.a, kotlin.coroutines.Continuation<? super io.ktor.http.content.c>, java.lang.Object> r4 = r10.$handler;
        io.ktor.client.plugins.api.d r5 = new io.ktor.client.plugins.api.d();
        java.lang.Object r6 = r1.getContext();
        java.lang.Object r7 = r1.c();
        java.lang.Object r11 = r1.getContext();
        io.ktor.client.request.HttpRequestBuilder r11 = (io.ktor.client.request.HttpRequestBuilder) r11;
        io.ktor.util.c r11 = r11.f491763f;
        io.ktor.util.a<isc.a> r8 = io.ktor.client.request.g.f491786a;
        java.lang.Object r11 = r11.b(r8);
        isc.a r8 = (isc.a) r11;
        r10.L$0 = r1;
        r10.label = 1;
        io.ktor.client.request.HttpRequestBuilder r6 = (io.ktor.client.request.HttpRequestBuilder) r6;
        java.lang.Object r10 = (kotlin.coroutines.Continuation<? super io.ktor.http.content.c>) r10;
        r11 = r4.invoke(r5, r6, r7, r8, r10);
        if (r11 != r0) goto L13;
        return r0;
    }
}
