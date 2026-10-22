package com.larus.ui.arch.vm.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "result", "Lkotlinx/coroutines/channels/ChannelResult;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$flowWhenStarted$1$1$1$1", f = "ComponentStateOperator.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
public final class ComponentStateOperator$flowWhenStarted$1$1$1$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.g<? extends Boolean>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $flowChannel;
    final /* synthetic */ Ref.ObjectRef<Object> $flowValue;
    final /* synthetic */ Ref.BooleanRef $isClosed;
    final /* synthetic */ Ref.ObjectRef<Boolean> $started;
    final /* synthetic */ Function3<Boolean, Object, Continuation<? super Unit>, Object> $transform;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ComponentStateOperator$flowWhenStarted$1$1$1$1(ReceiveChannel<Object> r100, Ref.BooleanRef r101, Ref.ObjectRef<Boolean> r102, Ref.ObjectRef<Object> r103, Function3<? super Boolean, Object, ? super Continuation<? super Unit>, ? extends Object> r104, Continuation<? super ComponentStateOperator$flowWhenStarted$1$1$1$1> r105) {
        this.$flowChannel = r100;
        this.$isClosed = r101;
        this.$started = r102;
        this.$flowValue = r103;
        this.$transform = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
        ComponentStateOperator$flowWhenStarted$1$1$1$1 r101 = new ComponentStateOperator$flowWhenStarted$1$1$1$1(this.$flowChannel, this.$isClosed, this.$started, this.$flowValue, this.$transform, r110);
        r101.L$0 = r100;
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [T, java.lang.Boolean, java.lang.Object] */
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
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ?? r103 = (Boolean) kotlinx.coroutines.channels.g.b(((kotlinx.coroutines.channels.g) this.L$0).f504697a);
        if (r103 != 0) goto L11;
        this.$flowChannel.cancel(null);
        this.$isClosed.element = true;
        goto L17
    L11:
        this.$started.element = r103;
        Object r104 = this.$flowValue.element;
        if (r104 == null) goto L17;
        Function3<Boolean, Object, Continuation<? super Unit>, Object> r105 = this.$transform;
        this.label = 1;
        if (r105.invoke(r103, r104, this) != r101) goto L17;
        return r101;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.g<? extends Boolean> r100, Continuation<? super Unit> r101) {
        return m8569invokeWpGqRn0(r100.f504697a, r101);
    }

    /* JADX INFO: renamed from: invoke-WpGqRn0, reason: not valid java name */
    public final Object m8569invokeWpGqRn0(Object r100, Continuation<? super Unit> r101) {
        return ((ComponentStateOperator$flowWhenStarted$1$1$1$1) create(new kotlinx.coroutines.channels.g(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }
}
