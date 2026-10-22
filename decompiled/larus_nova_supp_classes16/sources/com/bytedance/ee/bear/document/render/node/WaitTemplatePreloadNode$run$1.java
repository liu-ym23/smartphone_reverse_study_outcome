package com.bytedance.ee.bear.document.render.node;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.render.node.WaitTemplatePreloadNode", f = "WaitTemplatePreloadNode.kt", i = {0, 0}, l = {34}, m = "run", n = {"context", "isReady"}, s = {"L$0", "I$0"})
final class WaitTemplatePreloadNode$run$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ s this$0;

    public WaitTemplatePreloadNode$run$1(s r1, Continuation<? super WaitTemplatePreloadNode$run$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= ShareItemModel.SRC_TINT_UNDEFINED;
        return this.this$0.b(null, this);
    }
}
