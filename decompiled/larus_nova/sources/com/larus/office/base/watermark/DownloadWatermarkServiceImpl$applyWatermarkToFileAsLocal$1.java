package com.larus.office.base.watermark;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.DownloadWatermarkServiceImpl", f = "DownloadWatermarkServiceImpl.kt", i = {0, 1}, l = {165, 169, 177, 177}, m = "applyWatermarkToFileAsLocal", n = {HiAnalyticsConstant.Direction.REQUEST, "ready"}, s = {"L$0", "L$0"})
public final class DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadWatermarkServiceImpl this$0;

    public DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$1(DownloadWatermarkServiceImpl r100, Continuation<? super DownloadWatermarkServiceImpl$applyWatermarkToFileAsLocal$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
