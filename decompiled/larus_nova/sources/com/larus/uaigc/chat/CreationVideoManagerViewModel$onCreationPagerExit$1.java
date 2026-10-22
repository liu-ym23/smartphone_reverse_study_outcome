package com.larus.uaigc.chat;

import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.uaigc.chat.CreationVideoManagerViewModel$onCreationPagerExit$1", f = "CreationVideoManagerViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class CreationVideoManagerViewModel$onCreationPagerExit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CreationVideoManagerViewModel this$0;

    public CreationVideoManagerViewModel$onCreationPagerExit$1(CreationVideoManagerViewModel r100, Continuation<? super CreationVideoManagerViewModel$onCreationPagerExit$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CreationVideoManagerViewModel$onCreationPagerExit$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CreationVideoManagerViewModel$onCreationPagerExit$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Iterator<Map.Entry<String, Boolean>> r103 = (Iterator) this.L$1;
        CreationVideoManagerViewModel r104 = (CreationVideoManagerViewModel) this.L$0;
        ResultKt.throwOnFailure(r100);
    L10:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, Boolean> r105 = r103.next();
        int r106 = CreationVideoManagerViewModel.f370387j;
        MutableSharedFlow r107 = (MutableSharedFlow) r104.f370393f.getValue();
        Pair r108 = TuplesKt.to(r105.getKey(), r105.getValue());
        this.L$0 = r104;
        this.L$1 = r103;
        this.label = 1;
        if (r107.emit(r108, this) != r101) goto L10;
        return r101;
    L14:
        this.this$0.f370395h.clear();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r104 = this.this$0;
        r103 = r104.f370395h.entrySet().iterator();
        goto L10
    }
}
