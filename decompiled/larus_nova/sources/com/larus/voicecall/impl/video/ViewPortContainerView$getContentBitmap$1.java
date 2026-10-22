package com.larus.voicecall.impl.video;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.video.ViewPortContainerView", f = "ViewPortSwitcher.kt", i = {}, l = {559}, m = "getContentBitmap", n = {}, s = {})
final class ViewPortContainerView$getContentBitmap$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ViewPortContainerView this$0;

    public ViewPortContainerView$getContentBitmap$1(ViewPortContainerView r100, Continuation<? super ViewPortContainerView$getContentBitmap$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ViewPortContainerView.a(this.this$0, 0.0f, 0.0f, this);
    }
}
