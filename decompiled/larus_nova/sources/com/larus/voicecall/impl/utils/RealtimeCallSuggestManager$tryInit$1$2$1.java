package com.larus.voicecall.impl.utils;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$tryInit$1$2$1", f = "RealtimeCallSuggestManager.kt", i = {}, l = {55, 55}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallSuggestManager$tryInit$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<List<String>, String, Continuation<? super Unit>, Object> $onUpdate;
    final /* synthetic */ String $showFrom;
    Object L$0;
    int label;
    final /* synthetic */ RealtimeCallSuggestManager this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public RealtimeCallSuggestManager$tryInit$1$2$1(Function3<? super List<String>, ? super String, ? super Continuation<? super Unit>, ? extends Object> r100, RealtimeCallSuggestManager r101, String r102, Continuation<? super RealtimeCallSuggestManager$tryInit$1$2$1> r103) {
        this.$onUpdate = r100;
        this.this$0 = r101;
        this.$showFrom = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RealtimeCallSuggestManager$tryInit$1$2$1(this.$onUpdate, this.this$0, this.$showFrom, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RealtimeCallSuggestManager$tryInit$1$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Function3 r103 = (Function3) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        String r104 = this.$showFrom;
        this.L$0 = null;
        this.label = 2;
        if (r103.invoke(r100, r104, this) != r101) goto L17;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        r103 = this.$onUpdate;
        RealtimeCallSuggestManager.Repository r105 = (RealtimeCallSuggestManager.Repository) this.this$0.f379498d.getValue();
        this.L$0 = r103;
        this.label = 1;
        r100 = r105.a(this);
        if (r100 != r101) goto L13;
        return r101;
    }
}
