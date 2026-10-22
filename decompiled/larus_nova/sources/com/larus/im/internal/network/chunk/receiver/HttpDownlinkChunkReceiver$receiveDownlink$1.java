package com.larus.im.internal.network.chunk.receiver;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.network.chunk.receiver.HttpDownlinkChunkReceiver", f = "HttpDownlinkChunkReceiver.kt", i = {0, 0, 0, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25}, l = {119, 121, 124, 139, 141, 146, 147, 147, 155, 157, 157, 158, 166, 168, 169, 169, 177, 179, 183, 184, 184, 192, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 198, 199, 199}, m = "receiveDownlink", n = {"reportInfo", ContainerPosition.BODY, "msg", "reportInfo", ContainerPosition.BODY, "msg", ContainerPosition.BODY, "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo", "reportInfo"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$0"})
public final class HttpDownlinkChunkReceiver$receiveDownlink$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpDownlinkChunkReceiver this$0;

    public HttpDownlinkChunkReceiver$receiveDownlink$1(HttpDownlinkChunkReceiver r100, Continuation<? super HttpDownlinkChunkReceiver$receiveDownlink$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, null, this);
    }
}
