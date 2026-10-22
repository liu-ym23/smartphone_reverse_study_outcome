package com.larus.office.base.watermark;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.base.watermark.DownloadWatermarkServiceImpl", f = "DownloadWatermarkServiceImpl.kt", i = {0, 0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION}, m = "downloadWatermarkUrlToCache", n = {"url", "fileName", PerfLog.PARAM_KEY_CONTEXT_ID, "saveDir", "saveDirPath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class DownloadWatermarkServiceImpl$downloadWatermarkUrlToCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadWatermarkServiceImpl this$0;

    public DownloadWatermarkServiceImpl$downloadWatermarkUrlToCache$1(DownloadWatermarkServiceImpl r100, Continuation<? super DownloadWatermarkServiceImpl$downloadWatermarkUrlToCache$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        DownloadWatermarkServiceImpl r101 = this.this$0;
        int r102 = DownloadWatermarkServiceImpl.f361217h;
        return r101.f(null, null, this);
    }
}
