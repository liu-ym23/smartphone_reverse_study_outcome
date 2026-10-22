package com.larus.avlink;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.avlink.DoraWakeupResponseManager", f = "DoraWakeupResponseManager.kt", i = {1, 1, 1, 2, 2, 2}, l = {96, 103, 123}, m = "runWakeupResponse", n = {DBDefinition.TASK_ID, "startTimeMs", "resolveStartMs", DBDefinition.TASK_ID, "mp3Path", "startTimeMs"}, s = {"L$0", "J$0", "J$1", "L$0", "L$1", "J$0"})
final class DoraWakeupResponseManager$runWakeupResponse$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraWakeupResponseManager this$0;

    public DoraWakeupResponseManager$runWakeupResponse$1(DoraWakeupResponseManager r100, Continuation<? super DoraWakeupResponseManager$runWakeupResponse$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return DoraWakeupResponseManager.b(this.this$0, this);
    }
}
