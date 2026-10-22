package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationCachePromotionStore", f = "OfficeChatConversationCachePromotionStore.kt", i = {}, l = {39}, m = "readCachedConversationId", n = {}, s = {})
public final class OfficeChatConversationCachePromotionStore$readCachedConversationId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeChatConversationCachePromotionStore this$0;

    public OfficeChatConversationCachePromotionStore$readCachedConversationId$1(OfficeChatConversationCachePromotionStore r100, Continuation<? super OfficeChatConversationCachePromotionStore$readCachedConversationId$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, this);
    }
}
