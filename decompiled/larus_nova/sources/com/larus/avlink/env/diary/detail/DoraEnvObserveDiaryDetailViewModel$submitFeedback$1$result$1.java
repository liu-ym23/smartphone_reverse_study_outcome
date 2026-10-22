package com.larus.avlink.env.diary.detail;

import com.larus.avlink.env.diary.feedback.api.DoraEnvObserveDiaryFeedbackApi;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/avlink/env/diary/feedback/api/DoraEnvObserveDiaryFeedbackApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.env.diary.detail.DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1", f = "DoraEnvObserveDiaryDetailViewModel.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
public final class DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1 extends SuspendLambda implements Function2<DoraEnvObserveDiaryFeedbackApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ String $diaryId;
    final /* synthetic */ j98.f $state;
    private /* synthetic */ Object L$0;
    int label;

    public DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1(String r100, j98.f r101, String r102, Continuation<? super DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1> r103) {
        this.$diaryId = r100;
        this.$state = r101;
        this.$content = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1 r102 = new DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1(this.$diaryId, this.$state, this.$content, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(DoraEnvObserveDiaryFeedbackApi r100, Continuation<? super BizResponse<Object>> r101) {
        return ((DoraEnvObserveDiaryDetailViewModel$submitFeedback$1$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(DoraEnvObserveDiaryFeedbackApi r100, Continuation<? super BizResponse<Object>> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L19:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        DoraEnvObserveDiaryFeedbackApi r111 = (DoraEnvObserveDiaryFeedbackApi) this.L$0;
        String r102 = this.$diaryId;
        j98.f r103 = this.$state;
        int r104 = r103.f497809b;
        List<String> r105 = r103.f497811d;
        List<String> r106 = j98.d.f497806a;
        Intrinsics.checkNotNullParameter(r105, "reasons");
        if (r105.isEmpty() == false) goto L11;
        String r107 = null;
    L12:
        String r108 = this.$content;
        if (StringsKt.isBlank(r108) == false) goto L15;
        String r109 = null;
    L16:
        j98.i r112 = new j98.i(new j98.e(r102, r104, r107, r109, 2), 2);
        this.label = 1;
        r110 = r111.submitFeedback(r112, this);
        if (r110 != r100) goto L19;
        return r100;
    L15:
        r109 = r108;
        goto L16
    L11:
        r107 = new JSONArray(r105).toString();
        goto L12
    }
}
