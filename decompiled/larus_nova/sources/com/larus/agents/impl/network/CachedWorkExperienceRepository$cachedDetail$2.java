package com.larus.agents.impl.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/agents/impl/experience/WorkExperienceDetail;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$cachedDetail$2", f = "WorkExperienceApi.kt", i = {}, l = {440}, m = "invokeSuspend", n = {}, s = {})
final class CachedWorkExperienceRepository$cachedDetail$2 extends SuspendLambda implements Function1<Continuation<? super com.larus.agents.impl.experience.n>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ String $experienceId;
    int label;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$cachedDetail$2(CachedWorkExperienceRepository r100, String r101, String r102, Continuation<? super CachedWorkExperienceRepository$cachedDetail$2> r103) {
        this.this$0 = r100;
        this.$accountId = r101;
        this.$experienceId = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new CachedWorkExperienceRepository$cachedDetail$2(this.this$0, this.$accountId, this.$experienceId, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super com.larus.agents.impl.experience.n> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super com.larus.agents.impl.experience.n> r100) {
        return ((CachedWorkExperienceRepository$cachedDetail$2) create(r100)).invokeSuspend(Unit.INSTANCE);
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
        com.larus.agents.impl.experience.m r103 = this.this$0.f286701b;
        String r104 = this.$accountId;
        String r105 = this.$experienceId;
        this.label = 1;
        r100 = r103.c(r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
