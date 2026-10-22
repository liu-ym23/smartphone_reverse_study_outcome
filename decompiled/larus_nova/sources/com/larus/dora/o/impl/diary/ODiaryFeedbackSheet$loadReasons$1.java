package com.larus.dora.o.impl.diary;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.ODiaryFeedbackSheet$loadReasons$1", f = "ODiaryFeedbackSheet.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
final class ODiaryFeedbackSheet$loadReasons$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ i0 this$0;

    public ODiaryFeedbackSheet$loadReasons$1(i0 r100, Continuation<? super ODiaryFeedbackSheet$loadReasons$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ODiaryFeedbackSheet$loadReasons$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ODiaryFeedbackSheet$loadReasons$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        List<String> r104 = (List) ((Map) r100).get(Boxing.boxInt(this.this$0.f338544d));
        List<String> r105 = r104;
        if (r105 != null) goto L14;
    L17:
        if (r103 == true) goto L20;
        this.this$0.c(r104);
    L20:
        return Unit.INSTANCE;
    L14:
        if (r105.isEmpty() == true) goto L17;
        r103 = false;
        goto L17
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DoraODiaryRepo r106 = DoraODiaryRepo.f338435a;
        int r107 = this.this$0.f338546f.f338558a;
        this.label = 1;
        r100 = r106.f(r107, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
