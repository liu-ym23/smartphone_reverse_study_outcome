package com.larus.im.internal.core.conversation.converter;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.converter.ConversationConverterKt", f = "ConversationConverter.kt", i = {0, 0}, l = {145}, m = "toEntity", n = {"$this$toEntity", "from"}, s = {"L$0", "L$1"})
public final class ConversationConverterKt$toEntity$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public ConversationConverterKt$toEntity$1(Continuation<? super ConversationConverterKt$toEntity$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ConversationConverterKt.b(null, null, this);
    }
}
