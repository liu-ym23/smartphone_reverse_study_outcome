package com.bytedance.ee.bear.container;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.container.WikiInitNode", f = "WikiInitNode.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {63}, m = "run", n = {"bearUrl", "loaderTypeBefore", KtvSubElement.CONTAINER, "args", WikiFolderPushPlugin.WIKI_TOKEN, "userComponentAbility", "paramsWikiInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
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

    public WikiInitNode$run$1(WikiInitNode r100, Continuation<? super WikiInitNode$run$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, this);
    }
}
