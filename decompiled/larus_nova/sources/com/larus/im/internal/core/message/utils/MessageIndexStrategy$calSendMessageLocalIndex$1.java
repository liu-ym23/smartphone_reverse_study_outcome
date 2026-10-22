package com.larus.im.internal.core.message.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.message.utils.MessageIndexStrategy", f = "MessageIndexStrategy.kt", i = {}, l = {29}, m = "calSendMessageLocalIndex$core_release", n = {}, s = {})
public final class MessageIndexStrategy$calSendMessageLocalIndex$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageIndexStrategy this$0;

    public MessageIndexStrategy$calSendMessageLocalIndex$1(MessageIndexStrategy r100, Continuation<? super MessageIndexStrategy$calSendMessageLocalIndex$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
