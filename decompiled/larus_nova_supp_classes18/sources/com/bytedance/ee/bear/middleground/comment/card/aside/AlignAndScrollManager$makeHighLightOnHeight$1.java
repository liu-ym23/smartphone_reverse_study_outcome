package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AlignAndScrollManager", f = "AlignAndScrollManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 3}, l = {277, 281, 286, 293}, m = "makeHighLightOnHeight", n = {"position", "height", "position", "height", "position", "height", "position", "height", "success"}, s = {"I$0", "I$1", "I$0", "I$1", "I$0", "I$1", "I$0", "I$1", "Z$0"})
public final class AlignAndScrollManager$makeHighLightOnHeight$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlignAndScrollManager this$0;

    public AlignAndScrollManager$makeHighLightOnHeight$1(AlignAndScrollManager r1, Continuation<? super AlignAndScrollManager$makeHighLightOnHeight$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(0, 0, this);
    }
}
