package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationMetadataSynchronizer", f = "OfficeChatConversationMetadataSynchronizer.kt", i = {}, l = {212}, m = "queryConversationMetadata", n = {}, s = {})
final class OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ g this$0;

    public OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$1(g r100, Continuation<? super OfficeChatConversationMetadataSynchronizer$queryConversationMetadata$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return g.b(this.this$0, null, 0, null, this);
    }
}
