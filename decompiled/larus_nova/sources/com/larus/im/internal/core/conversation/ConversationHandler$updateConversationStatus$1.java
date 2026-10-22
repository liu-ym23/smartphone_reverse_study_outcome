package com.larus.im.internal.core.conversation;

import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.ConversationHandler", f = "ConversationHandler.kt", i = {0, 1}, l = {222, VideoRef.VALUE_VIDEO_REF_CODEC_HAS_BYTEVC2}, m = "updateConversationStatus$core_release", n = {"status", "newCvs"}, s = {"I$0", "L$0"})
public final class ConversationHandler$updateConversationStatus$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationHandler this$0;

    public ConversationHandler$updateConversationStatus$1(ConversationHandler r100, Continuation<? super ConversationHandler$updateConversationStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateConversationStatus$core_release(null, 0, this);
    }
}
