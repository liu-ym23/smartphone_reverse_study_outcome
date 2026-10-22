package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.lark.LarkConversationSource$dispatchItemChanged$1", f = "LarkConversationSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LarkConversationSource$dispatchItemChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ d $item;
    int label;
    final /* synthetic */ i this$0;

    public LarkConversationSource$dispatchItemChanged$1(i r100, d r101, Continuation<? super LarkConversationSource$dispatchItemChanged$1> r102) {
        this.this$0 = r100;
        this.$item = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new LarkConversationSource$dispatchItemChanged$1(this.this$0, this.$item, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((LarkConversationSource$dispatchItemChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r100);
        i r101 = this.this$0;
        Object r102 = r101.f345424e;
        monitor-enter(r102);
        boolean r103 = r101.f345428i;     // Catch: Throwable -> L13
        monitor-exit(r102);
        if (r103 == true) goto L10;
        this.this$0.f345423d.c(l.b(this.$item));
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
