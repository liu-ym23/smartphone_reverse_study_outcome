package com.obric.assistant.settings.provider;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.provider.CocreationReviewSettingProvider$getSettingItems$4", f = "CocreationReviewSettingProvider.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CocreationReviewSettingProvider$getSettingItems$4 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ CocreationReviewSettingProvider this$0;

    public CocreationReviewSettingProvider$getSettingItems$4(CocreationReviewSettingProvider r100, Continuation<? super CocreationReviewSettingProvider$getSettingItems$4> r101) {
        this.this$0 = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new CocreationReviewSettingProvider$getSettingItems$4(this.this$0, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Boolean> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Boolean> r100) {
        return ((CocreationReviewSettingProvider$getSettingItems$4) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        CocreationReviewSettingProvider r101 = this.this$0;
        int r102 = CocreationReviewSettingProvider.f392253a;
        r101.getClass();
        com.obric.assistant.settings.h.f392071a.getClass();
        return Boxing.boxBoolean(com.obric.assistant.settings.h.a().f392075a);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
