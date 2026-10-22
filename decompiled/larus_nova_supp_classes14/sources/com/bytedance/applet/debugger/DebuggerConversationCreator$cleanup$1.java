package com.bytedance.applet.debugger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerConversationCreator", f = "DebuggerConversationCreator.kt", i = {}, l = {85}, m = "cleanup", n = {}, s = {})
public final class DebuggerConversationCreator$cleanup$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebuggerConversationCreator this$0;

    public DebuggerConversationCreator$cleanup$1(DebuggerConversationCreator r1, Continuation<? super DebuggerConversationCreator$cleanup$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
