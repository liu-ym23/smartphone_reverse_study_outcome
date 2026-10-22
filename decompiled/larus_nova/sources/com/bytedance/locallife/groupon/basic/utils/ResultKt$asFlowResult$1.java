package com.bytedance.locallife.groupon.basic.utils;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.locallife.model.response.BaseResponse;
import com.bytedance.retrofit2.Call;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H\u008a@"}, d2 = {"Lcom/bytedance/locallife/model/response/BaseResponse;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bytedance/locallife/groupon/basic/utils/e;", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.locallife.groupon.basic.utils.ResultKt$asFlowResult$1", f = "Result.kt", i = {}, l = {78, 80}, m = "invokeSuspend", n = {}, s = {})
final class ResultKt$asFlowResult$1 extends SuspendLambda implements Function2<FlowCollector<? super e<BaseResponse>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Call<BaseResponse> $this_asFlowResult;
    private /* synthetic */ Object L$0;
    int label;

    public ResultKt$asFlowResult$1(Call<BaseResponse> r100, Continuation<? super ResultKt$asFlowResult$1> r101) {
        this.$this_asFlowResult = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ResultKt$asFlowResult$1 r102 = new ResultKt$asFlowResult$1(this.$this_asFlowResult, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super e<BaseResponse>> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super e<BaseResponse>> r100, Continuation<? super Unit> r101) {
        return ((ResultKt$asFlowResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L19:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r100);
        FlowCollector r103 = (FlowCollector) this.L$0;
        if (this.$this_asFlowResult.isExecuted() == false) goto L15;
        e r104 = f.a(this.$this_asFlowResult.clone());
        this.label = 1;
        if (r103.emit(r104, this) != r101) goto L19;
        return r101;
    L15:
        e r105 = f.a(this.$this_asFlowResult);
        this.label = 2;
        if (r103.emit(r105, this) != r101) goto L19;
        return r101;
    }
}
