package com.larus.agents.impl.network;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.agents.impl.network.NetworkWorkExperienceRepository", f = "WorkExperienceApi.kt", i = {0, 0}, l = {230}, m = "mutation", n = {WikiFolderPushPlugin.OPT, "isValidData"}, s = {"L$0", "L$1"})
public final class NetworkWorkExperienceRepository$mutation$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkWorkExperienceRepository this$0;

    public NetworkWorkExperienceRepository$mutation$1(NetworkWorkExperienceRepository r100, Continuation<? super NetworkWorkExperienceRepository$mutation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        NetworkWorkExperienceRepository r101 = this.this$0;
        int r102 = NetworkWorkExperienceRepository.f286703a;
        return r101.h(null, null, null, null, null, this);
    }
}
