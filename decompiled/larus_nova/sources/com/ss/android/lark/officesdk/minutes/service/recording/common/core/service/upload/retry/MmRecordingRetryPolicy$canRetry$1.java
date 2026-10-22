package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.retry;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.upload.retry.MmRecordingRetryPolicy", f = "MmRecordingRetryPolicy.kt", i = {0, 1, 2, 3}, l = {20, 26, 29, 39}, m = "canRetry", n = {DBDefinition.RETRY_COUNT, DBDefinition.RETRY_COUNT, DBDefinition.RETRY_COUNT, DBDefinition.RETRY_COUNT}, s = {"J$0", "J$0", "J$0", "J$0"})
public final class MmRecordingRetryPolicy$canRetry$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmRecordingRetryPolicy this$0;

    public MmRecordingRetryPolicy$canRetry$1(MmRecordingRetryPolicy r100, Continuation<? super MmRecordingRetryPolicy$canRetry$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, this);
    }
}
