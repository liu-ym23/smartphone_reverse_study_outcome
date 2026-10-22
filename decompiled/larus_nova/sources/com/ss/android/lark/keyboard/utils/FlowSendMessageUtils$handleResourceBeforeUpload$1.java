package com.ss.android.lark.keyboard.utils;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.utils.FlowSendMessageUtils", f = "FlowSendMessageUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5}, l = {45, 61, 80, 87, 102, 107}, m = "handleResourceBeforeUpload", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "uploadId", "localPath", "entity", "needTransferToFileSendMap", "fileType", "task", PerfLog.PARAM_KEY_CONTEXT_ID, "uploadId", "localPath", "entity", "needTransferToFileSendMap", "fileType", "localPath", "entity", "needTransferToFileSendMap", "fileType", "localPath", "entity", "needTransferToFileSendMap", "fileType", "compressPath", PerfLog.PARAM_KEY_CONTEXT_ID, "uploadId", "localPath", "entity", "needTransferToFileSendMap", "fileType", "localPath", "fileType"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1"})
public final class FlowSendMessageUtils$handleResourceBeforeUpload$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowSendMessageUtils this$0;

    public FlowSendMessageUtils$handleResourceBeforeUpload$1(FlowSendMessageUtils r100, Continuation<? super FlowSendMessageUtils$handleResourceBeforeUpload$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, null, null, this);
    }
}
