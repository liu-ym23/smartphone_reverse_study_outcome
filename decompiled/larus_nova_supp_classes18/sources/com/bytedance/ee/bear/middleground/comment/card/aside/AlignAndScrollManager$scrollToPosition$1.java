package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AlignAndScrollManager", f = "AlignAndScrollManager.kt", i = {0, 0, 0}, l = {130, 149}, m = "scrollToPosition", n = {"outPosition", "innerPosition", "percentage"}, s = {"I$0", "I$1", "F$0"})
public final class AlignAndScrollManager$scrollToPosition$1 extends ContinuationImpl {
    float F$0;
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlignAndScrollManager this$0;

    public AlignAndScrollManager$scrollToPosition$1(AlignAndScrollManager r1, Continuation<? super AlignAndScrollManager$scrollToPosition$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(0, 0, 0.0f, this);
    }
}
