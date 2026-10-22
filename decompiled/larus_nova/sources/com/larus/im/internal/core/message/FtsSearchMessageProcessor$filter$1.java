package com.larus.im.internal.core.message;

import com.ss.ttvideoengine.model.VideoRef;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.FtsSearchMessageProcessor", f = "FtsSearchMessageProcessor.kt", i = {0, 0, 0}, l = {VideoRef.VALUE_VIDEO_REF_CONST_DEPTH}, m = "filter", n = {"destination$iv$iv", "element$iv$iv", "it"}, s = {"L$0", "L$2", "L$3"})
public final class FtsSearchMessageProcessor$filter$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FtsSearchMessageProcessor this$0;

    public FtsSearchMessageProcessor$filter$1(FtsSearchMessageProcessor r100, Continuation<? super FtsSearchMessageProcessor$filter$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        FtsSearchMessageProcessor r101 = this.this$0;
        List<Integer> r102 = FtsSearchMessageProcessor.f347740f;
        return r101.d(null, this);
    }
}
