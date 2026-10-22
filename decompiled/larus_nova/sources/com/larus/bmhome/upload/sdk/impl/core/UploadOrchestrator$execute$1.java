package com.larus.bmhome.upload.sdk.impl.core;

import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.sdk.impl.core.UploadOrchestrator", f = "UploadOrchestrator.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3}, l = {44, 49, 55, 69}, m = "execute", n = {DBDefinition.TASK_ID, "registry", "startedAt", DBDefinition.TASK_ID, "registry", "processedRequest", CloudControlInf.ROUTE, "startedAt", DBDefinition.TASK_ID, "registry", "processedRequest", CloudControlInf.ROUTE, "startedAt", DBDefinition.TASK_ID, "registry"}, s = {"L$0", "L$1", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1"})
public final class UploadOrchestrator$execute$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UploadOrchestrator this$0;

    public UploadOrchestrator$execute$1(UploadOrchestrator r100, Continuation<? super UploadOrchestrator$execute$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
