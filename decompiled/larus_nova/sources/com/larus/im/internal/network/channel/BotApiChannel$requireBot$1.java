package com.larus.im.internal.network.channel;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.channel.BotApiChannel", f = "BotApiChannel.kt", i = {}, l = {216}, m = "requireBot", n = {}, s = {})
public final class BotApiChannel$requireBot$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BotApiChannel this$0;

    public BotApiChannel$requireBot$1(BotApiChannel r100, Continuation<? super BotApiChannel$requireBot$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, this);
    }
}
