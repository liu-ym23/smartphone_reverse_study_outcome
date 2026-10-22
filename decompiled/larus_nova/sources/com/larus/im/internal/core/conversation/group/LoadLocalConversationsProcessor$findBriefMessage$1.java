package com.larus.im.internal.core.conversation.group;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.group.LoadLocalConversationsProcessor", f = "LoadLocalConversationsProcessor.kt", i = {0, 0, 0, 0, 0, 1, 1, 2}, l = {200, 203, 215}, m = "findBriefMessage", n = {"idList", "messageList", "page", "lastPageCount", RXScreenCaptureService.KEY_INDEX, "idList", "messageList", "destination$iv$iv"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$0"})
public final class LoadLocalConversationsProcessor$findBriefMessage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LoadLocalConversationsProcessor this$0;

    public LoadLocalConversationsProcessor$findBriefMessage$1(LoadLocalConversationsProcessor r100, Continuation<? super LoadLocalConversationsProcessor$findBriefMessage$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LoadLocalConversationsProcessor r101 = this.this$0;
        int r102 = LoadLocalConversationsProcessor.f347584f;
        return r101.f(null, this);
    }
}
