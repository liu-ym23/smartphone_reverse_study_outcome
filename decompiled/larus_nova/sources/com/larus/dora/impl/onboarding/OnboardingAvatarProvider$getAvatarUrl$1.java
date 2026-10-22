package com.larus.dora.impl.onboarding;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.OnboardingAvatarProvider", f = "OnboardingAvatarProvider.kt", i = {0, 2, 3, 3, 3}, l = {88, 45, 47, 98}, m = "getAvatarUrl", n = {"$this$withLock_u24default$iv", "request", "request", "avatarUrl", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0", "L$1", "L$2"})
public final class OnboardingAvatarProvider$getAvatarUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnboardingAvatarProvider this$0;

    public OnboardingAvatarProvider$getAvatarUrl$1(OnboardingAvatarProvider r100, Continuation<? super OnboardingAvatarProvider$getAvatarUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
