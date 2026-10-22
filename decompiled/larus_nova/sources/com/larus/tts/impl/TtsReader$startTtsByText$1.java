package com.larus.tts.impl;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader", f = "TtsReader.kt", i = {0, 0, 0, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS}, m = "startTtsByText", n = {"conversationId", RemoteMessageConst.MSGID, DBDefinition.TASK_ID, RemoteMessageConst.MSGID, DBDefinition.TASK_ID}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
public final class TtsReader$startTtsByText$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TtsReader this$0;

    public TtsReader$startTtsByText$1(TtsReader r100, Continuation<? super TtsReader$startTtsByText$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        this.result = r110;
        this.label |= Integer.MIN_VALUE;
        TtsReader r100 = this.this$0;
        int r111 = TtsReader.f370203i;
        return r100.f(null, null, null, false, null, null, null, false, null, null, null, this);
    }
}
