package com.larus.bmhome.taskskill.serviceimpl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.serviceimpl.TaskModeServiceImpl", f = "TaskModeServiceImpl.kt", i = {}, l = {37}, m = "authorizeDevice", n = {}, s = {})
public final class TaskModeServiceImpl$authorizeDevice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskModeServiceImpl this$0;

    public TaskModeServiceImpl$authorizeDevice$1(TaskModeServiceImpl r100, Continuation<? super TaskModeServiceImpl$authorizeDevice$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
