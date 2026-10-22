package com.obric.assistant.settings.experience;

import com.obric.assistant.network.api.IObricNetworkService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import vea.l;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/network/api/bean/ObricPrivacyConversationContentConfig;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanManager$refreshLocked$2$modelDeferred$1", f = "ObricUserExperiencePlanManager.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUserExperiencePlanManager$refreshLocked$2$modelDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super l>, Object> {
    final /* synthetic */ IObricNetworkService $networkService;
    private /* synthetic */ Object L$0;
    int label;

    public ObricUserExperiencePlanManager$refreshLocked$2$modelDeferred$1(IObricNetworkService r100, Continuation<? super ObricUserExperiencePlanManager$refreshLocked$2$modelDeferred$1> r101) {
        this.$networkService = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricUserExperiencePlanManager$refreshLocked$2$modelDeferred$1 r102 = new ObricUserExperiencePlanManager$refreshLocked$2$modelDeferred$1(this.$networkService, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super l> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super l> r101) {
        return ((ObricUserExperiencePlanManager$refreshLocked$2$modelDeferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        Object r103 = Result.m9449constructorimpl((l) r100);     // Catch: Throwable -> L15
    L18:
        if (Result.m9455isFailureimpl(r103) == false) goto L23;
        return null;
    L23:
        return r103;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r104 = (CoroutineScope) this.L$0;
        IObricNetworkService r105 = this.$networkService;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r100 = r105.w(this);     // Catch: Throwable -> L15
        if (r100 != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
