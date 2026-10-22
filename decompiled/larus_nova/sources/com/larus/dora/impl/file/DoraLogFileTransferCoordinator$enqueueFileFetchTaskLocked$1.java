package com.larus.dora.impl.file;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraLogFileTransferCoordinator", f = "DoraLogFileTransferCoordinator.kt", i = {0, 0, 0, 0, 0}, l = {329}, m = "enqueueFileFetchTaskLocked", n = {"fetchFrom", "sn", "firmwareVersion", "types", "fileInfoList"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class DoraLogFileTransferCoordinator$enqueueFileFetchTaskLocked$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraLogFileTransferCoordinator this$0;

    public DoraLogFileTransferCoordinator$enqueueFileFetchTaskLocked$1(DoraLogFileTransferCoordinator r100, Continuation<? super DoraLogFileTransferCoordinator$enqueueFileFetchTaskLocked$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DoraLogFileTransferCoordinator r101 = this.this$0;
        DoraLogFileTransferCoordinator r102 = DoraLogFileTransferCoordinator.f335719a;
        return r101.e(null, null, null, null, this);
    }
}
