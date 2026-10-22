package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionPanelRemoteData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.mention.MentionRecommendStore$startOrJoin$1$3$deferred$1", f = "MentionRecommendStore.kt", i = {}, l = {111}, m = "invokeSuspend", n = {}, s = {})
public final class MentionRecommendStore$startOrJoin$1$3$deferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super f0>, Object> {
    final /* synthetic */ qp8.e $config;
    final /* synthetic */ MentionRecommendStore.b $key;
    final /* synthetic */ MentionRecommendStore $this_run;
    int label;

    public MentionRecommendStore$startOrJoin$1$3$deferred$1(MentionRecommendStore r100, qp8.e r101, MentionRecommendStore.b r102, Continuation<? super MentionRecommendStore$startOrJoin$1$3$deferred$1> r103) {
        this.$this_run = r100;
        this.$config = r101;
        this.$key = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MentionRecommendStore$startOrJoin$1$3$deferred$1(this.$this_run, this.$config, this.$key, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super f0> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super f0> r101) {
        return ((MentionRecommendStore$startOrJoin$1$3$deferred$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        MentionRecommendStore r103 = this.$this_run;
        qp8.e r104 = this.$config;
        MentionRecommendStore.b r105 = this.$key;
        this.label = 1;
        r100 = MentionRecommendStore.a(r103, r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
