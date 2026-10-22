package com.larus.avlink.record.page;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/avlink/record/page/RecordMinutesItemData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel$fetchRecordMinutesHistoryList$2$larkOfflineDeferred$1", f = "RecordMinutesModel.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class RecordMinutesModel$fetchRecordMinutesHistoryList$2$larkOfflineDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends i0>>, Object> {
    int label;
    final /* synthetic */ RecordMinutesModel this$0;

    public RecordMinutesModel$fetchRecordMinutesHistoryList$2$larkOfflineDeferred$1(RecordMinutesModel r100, Continuation<? super RecordMinutesModel$fetchRecordMinutesHistoryList$2$larkOfflineDeferred$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new RecordMinutesModel$fetchRecordMinutesHistoryList$2$larkOfflineDeferred$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super List<? extends i0>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super List<i0>> r101) {
        return ((RecordMinutesModel$fetchRecordMinutesHistoryList$2$larkOfflineDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        RecordMinutesModel r103 = this.this$0;
        this.label = 1;
        r100 = RecordMinutesModel.d(r103, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
