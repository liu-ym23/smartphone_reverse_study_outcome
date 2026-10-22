package com.larus.larkfeed.impl.gallery;

import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.larkfeed.impl.gallery.LarkImageView", f = "LarkImageView.kt", i = {}, l = {VideoRef.VALUE_VIDEO_REF_POPULARITY_LEVEL}, m = "isAnimatedImage", n = {}, s = {})
public final class LarkImageView$isAnimatedImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkImageView this$0;

    public LarkImageView$isAnimatedImage$1(LarkImageView r100, Continuation<? super LarkImageView$isAnimatedImage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
