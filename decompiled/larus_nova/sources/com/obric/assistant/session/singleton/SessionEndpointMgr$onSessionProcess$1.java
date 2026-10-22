package com.obric.assistant.session.singleton;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.session.singleton.SessionEndpointMgr", f = "SessionEndpointMgr.kt", i = {0, 0, 0}, l = {90}, m = "onSessionProcess", n = {"args", "listSize", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "I$0", "I$1"})
public final class SessionEndpointMgr$onSessionProcess$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SessionEndpointMgr this$0;

    public SessionEndpointMgr$onSessionProcess$1(SessionEndpointMgr r100, Continuation<? super SessionEndpointMgr$onSessionProcess$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
