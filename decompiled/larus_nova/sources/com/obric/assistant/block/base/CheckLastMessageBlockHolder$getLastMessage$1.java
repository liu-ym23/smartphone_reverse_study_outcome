package com.obric.assistant.block.base;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.base.CheckLastMessageBlockHolder", f = "CheckLastMessageBlockHolder.kt", i = {0}, l = {153}, m = "getLastMessage", n = {"cvsId"}, s = {"L$0"})
final class CheckLastMessageBlockHolder$getLastMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CheckLastMessageBlockHolder<jc8.a> this$0;

    public CheckLastMessageBlockHolder$getLastMessage$1(CheckLastMessageBlockHolder<jc8.a> r100, Continuation<? super CheckLastMessageBlockHolder$getLastMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return CheckLastMessageBlockHolder.j(this.this$0, null, this);
    }
}
