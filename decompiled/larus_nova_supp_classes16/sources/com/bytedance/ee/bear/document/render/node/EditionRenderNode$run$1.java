package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.render.node.EditionRenderNode", f = "EditionRenderNode.kt", i = {0, 0, 1, 1}, l = {70, 73}, m = "run", n = {"context", "docViewModel", "context", "docViewModel"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class EditionRenderNode$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EditionRenderNode this$0;

    public EditionRenderNode$run$1(EditionRenderNode r1, Continuation<? super EditionRenderNode$run$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= ShareItemModel.SRC_TINT_UNDEFINED;
        return this.this$0.b(null, this);
    }
}
