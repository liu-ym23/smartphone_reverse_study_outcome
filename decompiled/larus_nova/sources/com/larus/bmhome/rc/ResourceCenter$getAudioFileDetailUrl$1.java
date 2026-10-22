package com.larus.bmhome.rc;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.rc.ResourceCenter", f = "ResourceCenter.kt", i = {0}, l = {360}, m = "getAudioFileDetailUrl", n = {"resourceId"}, s = {"L$0"})
public final class ResourceCenter$getAudioFileDetailUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResourceCenter this$0;

    public ResourceCenter$getAudioFileDetailUrl$1(ResourceCenter r100, Continuation<? super ResourceCenter$getAudioFileDetailUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
