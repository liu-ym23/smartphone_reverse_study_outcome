package com.larus.bmhome.chat.list.cell.nested_file;

import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.nested_file.NestedFileDownloader", f = "NestedFileDownloader.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION}, m = "applyWatermarkOrFallback", n = {"src", PerfLog.TAG_PERF}, s = {"L$0", "L$1"})
public final class NestedFileDownloader$applyWatermarkOrFallback$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NestedFileDownloader this$0;

    public NestedFileDownloader$applyWatermarkOrFallback$1(NestedFileDownloader r100, Continuation<? super NestedFileDownloader$applyWatermarkOrFallback$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        NestedFileDownloader r101 = this.this$0;
        NestedFileDownloader r102 = NestedFileDownloader.f305412a;
        return r101.a(null, this);
    }
}
