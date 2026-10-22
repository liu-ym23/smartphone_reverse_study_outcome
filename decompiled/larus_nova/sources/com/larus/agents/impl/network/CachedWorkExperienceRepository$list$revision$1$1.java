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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository$list$revision$1$1", f = "WorkExperienceApi.kt", i = {}, l = {349}, m = "invokeSuspend", n = {}, s = {})
public final class CachedWorkExperienceRepository$list$revision$1$1 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {
    final /* synthetic */ String $it;
    int label;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$list$revision$1$1(CachedWorkExperienceRepository r100, String r101, Continuation<? super CachedWorkExperienceRepository$list$revision$1$1> r102) {
        this.this$0 = r100;
        this.$it = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new CachedWorkExperienceRepository$list$revision$1$1(this.this$0, this.$it, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Long> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Long> r100) {
        return ((CachedWorkExperienceRepository$list$revision$1$1) create(r100)).invokeSuspend(Unit.INSTANCE);
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
        String r104 = this.$it;
        this.label = 1;
        r100 = r103.k(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
