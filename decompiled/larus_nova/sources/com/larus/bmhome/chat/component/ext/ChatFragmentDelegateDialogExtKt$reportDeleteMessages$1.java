package com.larus.bmhome.chat.component.ext;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.ext.ChatFragmentDelegateDialogExtKt", f = "ChatFragmentDelegateDialogExt.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {327, 340, 352, 356}, m = "reportDeleteMessages", n = {"messages", "botId", "traceInfo", "scene", "botType", "needDeleteList", "localDeleteList", "message", "messages", "botId", "traceInfo", "scene", "botType", "needDeleteList", "localDeleteList", "conversationId", "messages", "botId", "traceInfo", "botType", "localDeleteList", "conversationId", "success", "errMsg", "messages", "botId", "traceInfo", "botType", "success", "errMsg"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;

    public ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1(Continuation<? super ChatFragmentDelegateDialogExtKt$reportDeleteMessages$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ChatFragmentDelegateDialogExtKt.c(null, null, null, null, null, this);
    }
}
