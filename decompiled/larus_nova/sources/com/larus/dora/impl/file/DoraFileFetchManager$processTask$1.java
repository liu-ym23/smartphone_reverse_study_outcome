package com.larus.dora.impl.file;

import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.file.DoraFileFetchManager", f = "DoraFileFetchManager.kt", i = {0, 1, 1, 1, 2, 2, 3, 3}, l = {426, 471, 533, 541}, m = "processTask", n = {DBDefinition.TASK_ID, DBDefinition.TASK_ID, DyPayConstant.KEY_START_TIME, "previousDownloadSize", DBDefinition.TASK_ID, "task", DBDefinition.TASK_ID, "task"}, s = {"L$0", "L$0", "J$0", "J$1", "L$0", "L$1", "L$0", "L$1"})
final class DoraFileFetchManager$processTask$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFileFetchManager this$0;

    public DoraFileFetchManager$processTask$1(DoraFileFetchManager r100, Continuation<? super DoraFileFetchManager$processTask$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraFileFetchManager.a(this.this$0, null, this);
    }
}
