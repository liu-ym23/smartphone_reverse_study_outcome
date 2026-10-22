package com.larus.office.plugins.inputv2.coordinator.runtime.conversation;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.coordinator.runtime.conversation.OfficeChatConversationCoordinator", f = "OfficeChatConversationCoordinator.kt", i = {1, 1, 1, 5, 5, 5, 5, 5, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8}, l = {106, 112, 114, 123, 137, 144, 149, 156, 158, 168}, m = "prepare", n = {"service", "params", "generation", "service", "params", "userId", "resourceId", "generation", "service", "params", "userId", "resourceId", "cachedConversationId", "generation", "service", "params", "cachedConversationId", "generation"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "J$0"})
public final class OfficeChatConversationCoordinator$prepare$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfficeChatConversationCoordinator this$0;

    public OfficeChatConversationCoordinator$prepare$1(OfficeChatConversationCoordinator r100, Continuation<? super OfficeChatConversationCoordinator$prepare$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, 0, this);
    }
}
