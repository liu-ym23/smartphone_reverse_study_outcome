package com.larus.ugc.feed.impl.ability;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CommunityCreateAbilityImpl", f = "CommunityCreateAbilityImpl.kt", i = {0}, l = {210}, m = "fetchTabList", n = {"params"}, s = {"L$0"})
public final class CommunityCreateAbilityImpl$fetchTabList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommunityCreateAbilityImpl this$0;

    public CommunityCreateAbilityImpl$fetchTabList$1(CommunityCreateAbilityImpl r100, Continuation<? super CommunityCreateAbilityImpl$fetchTabList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(this);
    }
}
