package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.model.data.decorator.MessageUniversalPinExtraDecorator", f = "MessageUniversalPinExtraDecorator.kt", i = {0}, l = {25}, m = "patchPinExtra", n = {"$this$patchPinExtra"}, s = {"L$0"})
final class MessageUniversalPinExtraDecorator$patchPinExtra$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ e this$0;

    public MessageUniversalPinExtraDecorator$patchPinExtra$1(e r100, Continuation<? super MessageUniversalPinExtraDecorator$patchPinExtra$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return e.b(this.this$0, null, this);
    }
}
