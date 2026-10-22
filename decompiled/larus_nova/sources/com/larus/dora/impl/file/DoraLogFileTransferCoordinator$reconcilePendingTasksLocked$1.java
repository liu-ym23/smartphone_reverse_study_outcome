package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraLogFileTransferCoordinator", f = "DoraLogFileTransferCoordinator.kt", i = {0, 0}, l = {406}, m = "reconcilePendingTasksLocked", n = {"sn", "firmwareVersion"}, s = {"L$0", "L$1"})
final class DoraLogFileTransferCoordinator$reconcilePendingTasksLocked$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraLogFileTransferCoordinator this$0;

    public DoraLogFileTransferCoordinator$reconcilePendingTasksLocked$1(DoraLogFileTransferCoordinator r100, Continuation<? super DoraLogFileTransferCoordinator$reconcilePendingTasksLocked$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraLogFileTransferCoordinator.b(this.this$0, null, null, this);
    }
}
