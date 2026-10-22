package com.larus.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.SingleRunner$runInIsolation$2", f = "SingleRunner.kt", i = {0, 1}, l = {53, 59, 61, 61}, m = "invokeSuspend", n = {"myJob", "myJob"}, s = {"L$0", "L$0"})
public final class SingleRunner$runInIsolation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ int $priority;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleRunner this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public SingleRunner$runInIsolation$2(SingleRunner r100, int r101, Function1<? super Continuation<? super Unit>, ? extends Object> r102, Continuation<? super SingleRunner$runInIsolation$2> r103) {
        this.this$0 = r100;
        this.$priority = r101;
        this.$block = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        SingleRunner$runInIsolation$2 r102 = new SingleRunner$runInIsolation$2(this.this$0, this.$priority, this.$block, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SingleRunner$runInIsolation$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v9, types: [kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.paging.SingleRunner$Holder] */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.larus.paging.SingleRunner$Holder] */
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
        ?? r102 = this.label;
        int r103 = 4;
        if (r102 == 0) goto L18;
        if (r102 == 1) goto L17;
        if (r102 == 2) goto L12;
        if (r102 == 3) goto L11;
        if (r102 != 4) goto L9;
        Throwable r104 = (Throwable) this.L$0;
        ResultKt.throwOnFailure(r100);
        throw r104;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r100);
    L38:
        return Unit.INSTANCE;
    L12:
        Job r105 = (Job) this.L$0;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
        r102 = r105;
    L29:
        ?? r106 = this.this$0.f363739a;
        r103 = 0;
        this.L$0 = null;
        this.label = 3;
        if (r106.a(r102, this) != r101) goto L38;
        return r101;
    L17:
        Job r107 = (Job) this.L$0;
        ResultKt.throwOnFailure(r100);
        Job r108 = r107;
    L25:
        if (((Boolean) r100).booleanValue() == false) goto L38;
        Function1<Continuation<? super Unit>, Object> r109 = this.$block;     // Catch: Throwable -> L15
        this.L$0 = r108;     // Catch: Throwable -> L15
        this.label = 2;     // Catch: Throwable -> L15
        r102 = r108;
        if (r109.invoke(this) != r101) goto L29;
        return r101;
    L18:
        ResultKt.throwOnFailure(r100);
        CoroutineContext.Element r110 = ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key);
        if (r110 == null) goto L40;
        Job r111 = (Job) r110;
        SingleRunner.Holder r112 = this.this$0.f363739a;
        int r113 = this.$priority;
        this.L$0 = r111;
        this.label = 1;
        Object r114 = r112.b(r113, r111, this);
        if (r114 != r101) goto L23;
        return r101;
    L23:
        r108 = r111;
        r100 = r114;
        goto L25
    L40:
        throw new IllegalStateException("Internal error. coroutineScope should've created a job.".toString());
    L15:
        th = move-exception;
        ?? r115 = this.this$0.f363739a;
        this.L$0 = th;
        this.label = r103;
        if (r115.a(r102, this) != r101) goto L36;
        return r101;
    L36:
        throw th;
    }
}
