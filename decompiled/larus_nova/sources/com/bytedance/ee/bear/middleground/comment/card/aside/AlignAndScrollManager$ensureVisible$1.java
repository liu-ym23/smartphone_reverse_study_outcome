package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AlignAndScrollManager", f = "AlignAndScrollManager.kt", i = {0, 1}, l = {204, 205, 217, 225}, m = "ensureVisible", n = {"positionToScroll", "positionToScroll"}, s = {"I$0", "I$0"})
public final class AlignAndScrollManager$ensureVisible$1 extends ContinuationImpl {
    int I$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AlignAndScrollManager this$0;

    public AlignAndScrollManager$ensureVisible$1(AlignAndScrollManager r100, Continuation<? super AlignAndScrollManager$ensureVisible$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(0, this);
    }
}
