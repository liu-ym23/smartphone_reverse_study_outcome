package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.AILabServiceImpl$contentObserver$1$onChange$1", f = "AILabServiceImpl.kt", i = {}, l = {138}, m = "invokeSuspend", n = {}, s = {})
public final class AILabServiceImpl$contentObserver$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AILabSettingItem $settingItem;
    int label;
    final /* synthetic */ AILabServiceImpl this$0;

    public AILabServiceImpl$contentObserver$1$onChange$1(AILabServiceImpl r100, AILabSettingItem r101, Continuation<? super AILabServiceImpl$contentObserver$1$onChange$1> r102) {
        this.this$0 = r100;
        this.$settingItem = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AILabServiceImpl$contentObserver$1$onChange$1(this.this$0, this.$settingItem, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AILabServiceImpl$contentObserver$1$onChange$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        AILabServiceImpl r103 = this.this$0;
        AILabSettingItem r104 = this.$settingItem;
        this.label = 1;
        int r105 = AILabServiceImpl.f391690d;
        if (r103.e(r104, this) != r101) goto L12;
        return r101;
    }
}
