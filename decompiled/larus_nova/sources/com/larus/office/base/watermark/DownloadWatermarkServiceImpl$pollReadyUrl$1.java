package com.larus.office.base.watermark;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.DownloadWatermarkServiceImpl", f = "DownloadWatermarkServiceImpl.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {336, 340}, m = "pollReadyUrl", n = {"path", "scene", DBDefinition.TASK_ID, "cleanup", "onPollFailed", "startMs", "path", "scene", DBDefinition.TASK_ID, Argument.OUT, "startMs"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
public final class DownloadWatermarkServiceImpl$pollReadyUrl$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadWatermarkServiceImpl this$0;

    public DownloadWatermarkServiceImpl$pollReadyUrl$1(DownloadWatermarkServiceImpl r100, Continuation<? super DownloadWatermarkServiceImpl$pollReadyUrl$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        DownloadWatermarkServiceImpl r100 = this.this$0;
        int r111 = DownloadWatermarkServiceImpl.f361217h;
        return r100.i(null, null, 0, null, null, null, this);
    }
}
