package com.larus.suggest.impl.popup;

import com.larus.suggest.impl.popup.model.PopWindowRepo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.popup.NexPulseDialogManager$reportPopWindowShow$1", f = "NexPulseDialogManager.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
final class NexPulseDialogManager$reportPopWindowShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $activityId;
    final /* synthetic */ Long $expireTime;
    final /* synthetic */ String $groupId;
    int label;

    public NexPulseDialogManager$reportPopWindowShow$1(String r100, String r101, Long r102, Continuation<? super NexPulseDialogManager$reportPopWindowShow$1> r103) {
        this.$activityId = r100;
        this.$groupId = r101;
        this.$expireTime = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new NexPulseDialogManager$reportPopWindowShow$1(this.$activityId, this.$groupId, this.$expireTime, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((NexPulseDialogManager$reportPopWindowShow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        com.larus.suggest.impl.popup.model.b r103 = new com.larus.suggest.impl.popup.model.b(this.$activityId, this.$groupId, Boxing.boxInt(3), this.$expireTime);
        PopWindowRepo r104 = PopWindowRepo.f369887a;
        this.label = 1;
        if (r104.b(r103, this) != r101) goto L12;
        return r101;
    }
}
