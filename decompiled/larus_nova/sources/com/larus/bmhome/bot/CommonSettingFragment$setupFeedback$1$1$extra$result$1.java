package com.larus.bmhome.bot;

import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.bot.CommonSettingFragment$setupFeedback$1$1$extra$result$1", f = "CommonSettingFragment.kt", i = {}, l = {2767}, m = "invokeSuspend", n = {}, s = {})
public final class CommonSettingFragment$setupFeedback$1$1$extra$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends Boolean, ? extends String>>, Object> {
    Object L$0;
    int label;

    public CommonSettingFragment$setupFeedback$1$1$extra$result$1(Continuation<? super CommonSettingFragment$setupFeedback$1$1$extra$result$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommonSettingFragment$setupFeedback$1$1$extra$result$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Pair<? extends Boolean, ? extends String>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Pair<Boolean, String>> r101) {
        return ((CommonSettingFragment$setupFeedback$1$1$extra$result$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Boolean r103 = (Boolean) this.L$0;
        ResultKt.throwOnFailure(r100);
    L13:
        return TuplesKt.to(r103, r100);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Boolean r104 = Boxing.boxBoolean(true);
        FlowFeedbackServiceDelegate r105 = FlowFeedbackServiceDelegate.f343027a;
        this.L$0 = r104;
        this.label = 1;
        Object r106 = r105.f(this);
        if (r106 != r101) goto L11;
        return r101;
    L11:
        r103 = r104;
        r100 = r106;
        goto L13
    }
}
