package com.bytedance.applet.debugger;

import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerConversationCreator", f = "DebuggerConversationCreator.kt", i = {0, 0, 1, 1, 1}, l = {TextExtraStruct.LVIDEO_WORK_DETAIL, 20, 27}, m = "createFromMainConversation", n = {"entryFrom", "mode", "entryFrom", "mode", "source"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
public final class DebuggerConversationCreator$createFromMainConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebuggerConversationCreator this$0;

    public DebuggerConversationCreator$createFromMainConversation$1(DebuggerConversationCreator r1, Continuation<? super DebuggerConversationCreator$createFromMainConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
