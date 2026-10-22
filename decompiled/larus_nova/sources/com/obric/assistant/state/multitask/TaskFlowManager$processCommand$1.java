package com.obric.assistant.state.multitask;

import jha.o;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.TaskFlowManager", f = "TaskFlowManager.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2}, l = {310, 320, 324}, m = "processCommand", n = {"entry", "command", "event", "sequenceId", "entry", "command", "event", "sequenceId", "entry", "command", "event", "sequenceId"}, s = {"L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"})
final class TaskFlowManager$processCommand$1<S extends o> extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskFlowManager this$0;

    public TaskFlowManager$processCommand$1(TaskFlowManager r100, Continuation<? super TaskFlowManager$processCommand$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return TaskFlowManager.b(this.this$0, null, null, this);
    }
}
