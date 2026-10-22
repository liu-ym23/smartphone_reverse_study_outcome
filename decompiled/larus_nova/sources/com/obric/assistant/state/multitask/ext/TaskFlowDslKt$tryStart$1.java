package com.obric.assistant.state.multitask.ext;

import jha.o;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.state.multitask.ext.TaskFlowDslKt", f = "TaskFlowDsl.kt", i = {0, 0, 0, 0}, l = {82}, m = "tryStart", n = {"$this$tryStart", "dispatchPolicy", "taskFlowStateMachine", "envelope"}, s = {"L$0", "L$1", "L$2", "L$3"})
public final class TaskFlowDslKt$tryStart$1<S extends o> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    public TaskFlowDslKt$tryStart$1(Continuation<? super TaskFlowDslKt$tryStart$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return TaskFlowDslKt.d(null, null, false, null, null, this);
    }
}
