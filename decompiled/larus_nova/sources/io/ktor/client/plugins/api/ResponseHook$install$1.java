package io.ktor.client.plugins.api;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"Lio/ktor/util/pipeline/b;", "Lio/ktor/client/statement/b;", "", "it", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "io.ktor.client.plugins.api.ResponseHook$install$1", f = "KtorCallContexts.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
final class ResponseHook$install$1 extends SuspendLambda implements Function3<io.ktor.util.pipeline.b<io.ktor.client.statement.b, Unit>, io.ktor.client.statement.b, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<b, io.ktor.client.statement.b, Continuation<? super Unit>, Object> $handler;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ResponseHook$install$1(Function3<? super b, ? super io.ktor.client.statement.b, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super ResponseHook$install$1> r101) {
        this.$handler = r100;
        super(3, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(io.ktor.util.pipeline.b<io.ktor.client.statement.b, Unit> r100, io.ktor.client.statement.b r101, Continuation<? super Unit> r102) {
        ResponseHook$install$1 r103 = new ResponseHook$install$1(this.$handler, r102);
        r103.L$0 = r100;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(io.ktor.util.pipeline.b<io.ktor.client.statement.b, Unit> r100, io.ktor.client.statement.b r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to io.ktor.client.plugins.api.ResponseHook$install$1 for r4v1 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r4.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        kotlin.ResultKt.throwOnFailure(r5);
    L11:
        kotlin.Unit r5 = kotlin.Unit.INSTANCE;
        return r5;
    L6:
        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r5;
    L8:
        kotlin.ResultKt.throwOnFailure(r5);
        java.lang.Object r5 = r4.L$0;
        io.ktor.util.pipeline.b r5 = (io.ktor.util.pipeline.b) r5;
        kotlin.jvm.functions.Function3<io.ktor.client.plugins.api.b, io.ktor.client.statement.b, kotlin.coroutines.Continuation<? super kotlin.Unit>, java.lang.Object> r1 = r4.$handler;
        io.ktor.client.plugins.api.b r3 = new io.ktor.client.plugins.api.b();
        java.lang.Object r5 = r5.c();
        r4.label = 1;
        io.ktor.client.statement.b r5 = (io.ktor.client.statement.b) r5;
        java.lang.Object r4 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4;
        java.lang.Object r5 = r1.invoke(r3, r5, r4);
        if (r5 != r0) goto L11;
        return r0;
    }
}
