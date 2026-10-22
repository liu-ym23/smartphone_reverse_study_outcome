package com.larus.community.impl.publish;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.publish.CreationPublishFragment", f = "CreationPublishFragment.kt", i = {0}, l = {215}, m = "getCreationTaskId", n = {"publishCreation"}, s = {"L$0"})
final class CreationPublishFragment$getCreationTaskId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationPublishFragment this$0;

    public CreationPublishFragment$getCreationTaskId$1(CreationPublishFragment r100, Continuation<? super CreationPublishFragment$getCreationTaskId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return CreationPublishFragment.U90(this.this$0, this);
    }
}
