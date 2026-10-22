package com.larus.bmhome.resource.access;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.CompletionDrivenDagResourceNodeOrchestrator$execute$2", f = "ResourceAccessPipeline.kt", i = {0, 0}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT}, m = "invokeSuspend$cancelRunningNodes", n = {"runningJobs", "runningNodes"}, s = {"L$0", "L$1"})
public final class CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1(Continuation<? super CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return CompletionDrivenDagResourceNodeOrchestrator$execute$2.access$invokeSuspend$cancelRunningNodes(null, null, this);
    }
}
