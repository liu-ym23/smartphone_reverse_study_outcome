package com.larus.agents.impl.network;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.network.CachedWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0}, l = {444}, m = "cacheRead", n = {WikiFolderPushPlugin.OPT}, s = {"L$0"})
public final class CachedWorkExperienceRepository$cacheRead$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CachedWorkExperienceRepository this$0;

    public CachedWorkExperienceRepository$cacheRead$1(CachedWorkExperienceRepository r100, Continuation<? super CachedWorkExperienceRepository$cacheRead$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CachedWorkExperienceRepository r101 = this.this$0;
        int r102 = CachedWorkExperienceRepository.f286699d;
        return r101.h(null, null, this);
    }
}
