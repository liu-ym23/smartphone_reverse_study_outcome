package com.larus.bmhome.chat.doclink;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.doclink.MessageDocPreviewRepository", f = "MessageDocPreviewRepository.kt", i = {0, 0}, l = {113}, m = "normalizeDistinctPreviewUrlsForRemote", n = {"distinctUrls", "waitedTime"}, s = {"L$0", "J$0"})
public final class MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageDocPreviewRepository this$0;

    public MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1(MessageDocPreviewRepository r100, Continuation<? super MessageDocPreviewRepository$normalizeDistinctPreviewUrlsForRemote$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MessageDocPreviewRepository r101 = this.this$0;
        MessageDocPreviewRepository r102 = MessageDocPreviewRepository.f302894a;
        return r101.f(null, this);
    }
}
