package com.lark.kmp.rustclient.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.lark.kmp.rustclient.internal.WaitConditionInterceptor$interceptEnqueue$1$action$1", f = "WaitConditionInterceptor.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
public final class WaitConditionInterceptor$interceptEnqueue$1$action$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ com.lark.kmp.rustclient.api.h<Resp> $chain;
    final /* synthetic */ MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> $resultFlow;
    int label;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> f282545a;

        public a(MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r100) {
            this.f282545a = r100;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            Object r102 = this.f282545a.emit((com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>) ((com.lark.kmp.rustclient.api.model.g) r100), (Continuation<? super Unit>) r101);
            if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r102;
        L6:
            return Unit.INSTANCE;
        }
    }

    public WaitConditionInterceptor$interceptEnqueue$1$action$1(com.lark.kmp.rustclient.api.h<Resp> r100, MutableSharedFlow<com.lark.kmp.rustclient.api.model.g<rpc.a, Resp>> r101, Continuation<? super WaitConditionInterceptor$interceptEnqueue$1$action$1> r102) {
        this.$chain = r100;
        this.$resultFlow = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new WaitConditionInterceptor$interceptEnqueue$1$action$1(this.$chain, this.$resultFlow, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((WaitConditionInterceptor$interceptEnqueue$1$action$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        com.lark.kmp.rustclient.api.h<Resp> r103 = this.$chain;
        Flow r104 = r103.b(r103.f282460c);
        a r105 = new a(this.$resultFlow);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L12;
        return r101;
    }
}
