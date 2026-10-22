package com.larus.ugc.feed.impl.ability;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl", f = "CreationFeedAbilityImpl.kt", i = {0}, l = {165}, m = "checkCurrentData", n = {"requestIndex"}, s = {"I$0"})
public final class CreationFeedAbilityImpl$checkCurrentData$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationFeedAbilityImpl this$0;

    public CreationFeedAbilityImpl$checkCurrentData$1(CreationFeedAbilityImpl r100, Continuation<? super CreationFeedAbilityImpl$checkCurrentData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(false, this);
    }
}
