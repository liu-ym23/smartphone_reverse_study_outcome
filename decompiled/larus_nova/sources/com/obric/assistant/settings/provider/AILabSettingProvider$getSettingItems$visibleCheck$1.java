package com.obric.assistant.settings.provider;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.settings.IAILabService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.AILabSettingProvider$getSettingItems$visibleCheck$1", f = "AILabSettingProvider.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
public final class AILabSettingProvider$getSettingItems$visibleCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ IAILabService $aiLabService;
    int label;

    public AILabSettingProvider$getSettingItems$visibleCheck$1(IAILabService r100, Continuation<? super AILabSettingProvider$getSettingItems$visibleCheck$1> r101) {
        this.$aiLabService = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AILabSettingProvider$getSettingItems$visibleCheck$1(this.$aiLabService, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((AILabSettingProvider$getSettingItems$visibleCheck$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L13:
        Boolean r103 = (Boolean) r100;
    L15:
        FLogger.f375446a.d("AILabSettingProvider", "aiLabService?.isSettingEnabled:" + r103);
        return Boxing.boxBoolean(Intrinsics.areEqual(r103, Boxing.boxBoolean(true)));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IAILabService r104 = this.$aiLabService;
        if (r104 == null) goto L14;
        this.label = 1;
        r100 = r104.a(this);
        if (r100 != r101) goto L13;
        return r101;
    L14:
        r103 = null;
        goto L15
    }
}
