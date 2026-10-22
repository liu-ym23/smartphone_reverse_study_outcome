package com.larus.bmhome.chat.referenceicon;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.referenceicon.MessageReferenceIconStore", f = "MessageReferenceIconStore.kt", i = {0, 0, 0, 0}, l = {110}, m = "loadAvatar", n = {"type", "avatarKey", "entityId", "cacheKey"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class MessageReferenceIconStore$loadAvatar$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageReferenceIconStore this$0;

    public MessageReferenceIconStore$loadAvatar$1(MessageReferenceIconStore r100, Continuation<? super MessageReferenceIconStore$loadAvatar$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, null, null, null, this);
    }
}
