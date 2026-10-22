package com.ss.android.lark.flow.chat.mediapreview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView", f = "FlowLargeImageView.kt", i = {}, l = {580}, m = "isAnimatedImage", n = {}, s = {})
public final class FlowLargeImageView$isAnimatedImage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowLargeImageView this$0;

    public FlowLargeImageView$isAnimatedImage$1(FlowLargeImageView r100, Continuation<? super FlowLargeImageView$isAnimatedImage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.g(this);
    }
}
