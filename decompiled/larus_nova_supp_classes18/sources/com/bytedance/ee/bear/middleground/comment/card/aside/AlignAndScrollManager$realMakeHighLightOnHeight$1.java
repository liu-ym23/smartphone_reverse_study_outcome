package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AlignAndScrollManager", f = "AlignAndScrollManager.kt", i = {0, 0}, l = {323, 325}, m = "realMakeHighLightOnHeight", n = {"position", "height"}, s = {"I$0", "I$1"})
public final class AlignAndScrollManager$realMakeHighLightOnHeight$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlignAndScrollManager this$0;

    public AlignAndScrollManager$realMakeHighLightOnHeight$1(AlignAndScrollManager r1, Continuation<? super AlignAndScrollManager$realMakeHighLightOnHeight$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AlignAndScrollManager r3 = this.this$0;
        int r0 = AlignAndScrollManager.e;
        return r3.h(0, 0, this);
    }
}
