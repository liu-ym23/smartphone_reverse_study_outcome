package com.larus.bmhome.chat.doclink;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.doclink.MessageDocPreviewRepository", f = "MessageDocPreviewRepository.kt", i = {0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {33, 47, 241}, m = "fetchRemotePreviews", n = {"messageId", "messageId", "distinctUrls", "cachedPreviewIdsByUrl", "urlsNeedPreviewId", "previewIdsByUrl", "messageId", "distinctUrls", "previewIdsByUrl", "previewUrls", "previewIds", "fallbackUrlsByPreviewId"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class MessageDocPreviewRepository$fetchRemotePreviews$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MessageDocPreviewRepository this$0;

    public MessageDocPreviewRepository$fetchRemotePreviews$1(MessageDocPreviewRepository r100, Continuation<? super MessageDocPreviewRepository$fetchRemotePreviews$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
