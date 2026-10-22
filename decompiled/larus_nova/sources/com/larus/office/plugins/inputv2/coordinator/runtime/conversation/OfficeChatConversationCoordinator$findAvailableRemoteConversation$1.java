package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationCoordinator", f = "OfficeChatConversationCoordinator.kt", i = {}, l = {471}, m = "findAvailableRemoteConversation", n = {}, s = {})
public final class OfficeChatConversationCoordinator$findAvailableRemoteConversation$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeChatConversationCoordinator this$0;

    public OfficeChatConversationCoordinator$findAvailableRemoteConversation$1(OfficeChatConversationCoordinator r100, Continuation<? super OfficeChatConversationCoordinator$findAvailableRemoteConversation$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        OfficeChatConversationCoordinator r101 = this.this$0;
        int r102 = OfficeChatConversationCoordinator.f362812m;
        return r101.c(null, this);
    }
}
