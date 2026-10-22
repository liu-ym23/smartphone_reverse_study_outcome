package com.larus.bmhome.chat.standarduikit.videogroup.binder;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.videogroup.binder.RelatedVideoBinder", f = "RelatedVideoBinder.kt", i = {0, 0, 0, 0}, l = {74}, m = "generateVMData", n = {"text", "span", "sizeData", "mobMessage"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class RelatedVideoBinder$generateVMData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RelatedVideoBinder this$0;

    public RelatedVideoBinder$generateVMData$1(RelatedVideoBinder r100, Continuation<? super RelatedVideoBinder$generateVMData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return RelatedVideoBinder.g(this.this$0, null, null, null, null, this);
    }
}
