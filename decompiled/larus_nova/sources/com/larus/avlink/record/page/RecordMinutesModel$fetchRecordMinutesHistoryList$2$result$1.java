package com.larus.avlink.record.page;

import com.larus.network.bean.BizResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0018\u00010\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/avlink/record/page/RecordMinutesResult;", "Lcom/larus/avlink/record/page/RecordMinutesApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1", f = "RecordMinutesModel.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1 extends SuspendLambda implements Function2<RecordMinutesApi, Continuation<? super BizResponse<List<? extends l0>>>, Object> {
    final /* synthetic */ d $request;
    private /* synthetic */ Object L$0;
    int label;

    public RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1(d r100, Continuation<? super RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1> r101) {
        this.$request = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1 r102 = new RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1(this.$request, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(RecordMinutesApi r100, Continuation<? super BizResponse<List<l0>>> r101) {
        return ((RecordMinutesModel$fetchRecordMinutesHistoryList$2$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(RecordMinutesApi r100, Continuation<? super BizResponse<List<? extends l0>>> r101) {
        return invoke2(r100, r101);
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
        RecordMinutesApi r103 = (RecordMinutesApi) this.L$0;
        d r104 = this.$request;
        this.label = 1;
        r100 = r103.listRecording(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
