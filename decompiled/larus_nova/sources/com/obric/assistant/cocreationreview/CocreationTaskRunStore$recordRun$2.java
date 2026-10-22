package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationTaskRunStore$recordRun$2", f = "CocreationTaskRunStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CocreationTaskRunStore$recordRun$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskId;
    final /* synthetic */ String $userId;
    int label;
    final /* synthetic */ CocreationTaskRunStore this$0;

    public CocreationTaskRunStore$recordRun$2(String r100, String r101, CocreationTaskRunStore r102, Continuation<? super CocreationTaskRunStore$recordRun$2> r103) {
        this.$userId = r100;
        this.$taskId = r101;
        this.this$0 = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CocreationTaskRunStore$recordRun$2(this.$userId, this.$taskId, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CocreationTaskRunStore$recordRun$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        if ((!StringsKt.isBlank(this.$userId)) == false) goto L10;
        if ((!StringsKt.isBlank(this.$taskId)) == false) goto L10;
        CocreationTaskRunStore r101 = this.this$0;
        r101.f387137b.invoke(CocreationTaskRunStore.a(r101, this.$userId, this.$taskId));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
