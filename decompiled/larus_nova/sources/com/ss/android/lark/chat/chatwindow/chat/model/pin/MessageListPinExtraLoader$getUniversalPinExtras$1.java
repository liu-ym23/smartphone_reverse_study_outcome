package com.ss.android.lark.chat.chatwindow.chat.model.pin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.model.pin.MessageListPinExtraLoader", f = "MessageListPinExtraLoader.kt", i = {0}, l = {45}, m = "getUniversalPinExtras", n = {"messageIds"}, s = {"L$0"})
public final class MessageListPinExtraLoader$getUniversalPinExtras$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageListPinExtraLoader this$0;

    public MessageListPinExtraLoader$getUniversalPinExtras$1(MessageListPinExtraLoader r100, Continuation<? super MessageListPinExtraLoader$getUniversalPinExtras$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
