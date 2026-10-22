package com.larus.agents.impl.network;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0, 0, 1}, l = {326, 329}, m = "updateEnabled", n = {"accountId", "enabled", "result"}, s = {"L$0", "Z$0", "L$0"})
public final class CachedWorkExperienceRepository$updateEnabled$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$updateEnabled$1(CachedWorkExperienceRepository r100, Continuation<? super CachedWorkExperienceRepository$updateEnabled$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(false, this);
    }
}
