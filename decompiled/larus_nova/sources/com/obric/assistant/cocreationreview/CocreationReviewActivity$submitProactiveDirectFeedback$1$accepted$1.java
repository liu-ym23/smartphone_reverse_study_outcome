package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1", f = "CocreationReviewActivity.kt", i = {}, l = {3552}, m = "invokeSuspend", n = {}, s = {})
final class CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $feedbackText;
    final /* synthetic */ String $relatedInfo;
    final /* synthetic */ r0 $report;
    int label;

    public CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1(r0 r100, String r101, String r102, Continuation<? super CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1> r103) {
        this.$report = r100;
        this.$feedbackText = r101;
        this.$relatedInfo = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1(this.$report, this.$feedbackText, this.$relatedInfo, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((CocreationReviewActivity$submitProactiveDirectFeedback$1$accepted$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L30:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ska.b r103 = ska.b.f542436a;
        Object r104 = this.$report.f387706b;
        Object r105 = this.$feedbackText;
        Object r106 = this.$relatedInfo;
        this.label = 1;
        r103.getClass();
        JSONObject r107 = new JSONObject();
        if (r104 != null) goto L11;
        r104 = JSONObject.NULL;
    L11:
        JSONObject r108 = r107.put("feedbackReason", r104);
        if (r105 != null) goto L14;
        r105 = JSONObject.NULL;
    L14:
        JSONObject r109 = r108.put("feedbackText", r105);
        if (r106 != null) goto L17;
        r106 = JSONObject.NULL;
    L17:
        String r110 = ska.b.a("submitAiProactiveDirectFeedback", "requestJson", r109.put("relatedInfo", r106).put("feedbackSource", "label_app").toString());
        boolean r111 = false;
        if (r110 != null) goto L31;
    L27:
        r100 = Boxing.boxBoolean(r111);
        if (r100 != r101) goto L30;
        return r101;
    L31:
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L21
        Object r113 = Result.m9449constructorimpl(Boxing.boxBoolean(new JSONObject(r110).optBoolean("accepted", false)));     // Catch: Throwable -> L21
    L23:
        Boolean r114 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r113) == false) goto L26;
        r113 = r114;
    L26:
        r111 = ((Boolean) r113).booleanValue();
    L21:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }
}
