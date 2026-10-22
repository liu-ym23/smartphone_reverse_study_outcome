package com.obric.aiagent.messenger.stub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.ObricForegroundWidgetSyncServiceImpl", f = "ObricForegroundWidgetSyncServiceImpl.kt", i = {0}, l = {20}, m = "awaitWidgetUpdatesBeforeConversationPull", n = {"conversationId"}, s = {"L$0"})
public final class ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricForegroundWidgetSyncServiceImpl this$0;

    public ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1(ObricForegroundWidgetSyncServiceImpl r100, Continuation<? super ObricForegroundWidgetSyncServiceImpl$awaitWidgetUpdatesBeforeConversationPull$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
