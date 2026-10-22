package com.larus.dora.impl.core;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraCoreTracker", f = "DoraCoreTracker.kt", i = {0, 0, 0, 0, 0}, l = {128}, m = "stateWithRetry", n = {"$this$stateWithRetry", "state", "action", "value", RXScreenCaptureService.KEY_INDEX}, s = {"L$0", "L$1", "L$2", "B$0", "I$0"})
final class DoraCoreTracker$stateWithRetry$1 extends ContinuationImpl {
    byte B$0;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ z this$0;

    public DoraCoreTracker$stateWithRetry$1(z r100, Continuation<? super DoraCoreTracker$stateWithRetry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return z.a(this.this$0, null, null, null, this);
    }
}
