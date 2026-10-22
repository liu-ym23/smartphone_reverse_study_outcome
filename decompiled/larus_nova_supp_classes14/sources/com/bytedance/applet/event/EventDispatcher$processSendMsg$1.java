package com.bytedance.applet.event;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.event.EventDispatcher", f = "EventDispatcher.kt", i = {0}, l = {215}, m = "processSendMsg", n = {"msg"}, s = {"L$0"})
final class EventDispatcher$processSendMsg$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventDispatcher this$0;

    public EventDispatcher$processSendMsg$1(EventDispatcher r1, Continuation<? super EventDispatcher$processSendMsg$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return EventDispatcher.h(this.this$0, null, null, this);
    }
}
