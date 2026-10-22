package com.bytedance.ee.bear.container;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.container.WikiInitNode", f = "WikiInitNode.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {63}, m = "run", n = {"bearUrl", "loaderTypeBefore", "container", "args", "wikiToken", "userComponentAbility", "paramsWikiInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
public final class WikiInitNode$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WikiInitNode this$0;

    public WikiInitNode$run$1(WikiInitNode r1, Continuation<? super WikiInitNode$run$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= ShareItemModel.SRC_TINT_UNDEFINED;
        return this.this$0.a(null, null, null, this);
    }
}
